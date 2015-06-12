// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.model;

import org.json.JSONException;
import com.facebook.internal.Validate;
import java.util.AbstractList;
import java.lang.reflect.Method;
import com.facebook.internal.Utility;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import org.json.JSONArray;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Collection;
import com.facebook.FacebookGraphObjectException;
import java.lang.reflect.ParameterizedType;
import java.util.Locale;
import java.util.HashSet;
import java.text.SimpleDateFormat;
import org.json.JSONObject;
import java.util.Map;

public interface GraphObject
{
    Map<String, Object> asMap();
    
     <T extends GraphObject> T cast(Class<T> p0);
    
    JSONObject getInnerJSONObject();
    
    Object getProperty(String p0);
    
     <T extends GraphObject> T getPropertyAs(String p0, Class<T> p1);
    
     <T extends GraphObject> GraphObjectList<T> getPropertyAsList(String p0, Class<T> p1);
    
    void removeProperty(String p0);
    
    void setProperty(String p0, Object p1);
    
    public static final class Factory
    {
        private static final SimpleDateFormat[] dateFormats;
        private static final HashSet<Class<?>> verifiedGraphObjectClasses;
        
        static {
            verifiedGraphObjectClasses = new HashSet<Class<?>>();
            dateFormats = new SimpleDateFormat[] { new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US), new SimpleDateFormat("yyyy-MM-dd", Locale.US) };
        }
        
        static <U> U coerceValueToExpectedType(Object o, Class<U> clazz, ParameterizedType parameterizedType) {
            Class<?> class1;
            SimpleDateFormat[] dateFormats;
            int length;
            int i;
            SimpleDateFormat simpleDateFormat;
            Date parse;
            Type[] actualTypeArguments;
            Class clazz2;
            if (o == null) {
                if (Boolean.TYPE.equals(clazz)) {
                    return (U)false;
                }
                if (Character.TYPE.equals(clazz)) {
                    return (U)'\0';
                }
                if (clazz.isPrimitive()) {
                    return (U)0;
                }
                return null;
            }
            else {
                class1 = o.getClass();
                if (clazz.isAssignableFrom(class1)) {
                    return (U)o;
                }
                if (clazz.isPrimitive()) {
                    return (U)o;
                }
                if (GraphObject.class.isAssignableFrom(clazz)) {
                    if (JSONObject.class.isAssignableFrom(class1)) {
                        return createGraphObjectProxy(clazz, (JSONObject)o);
                    }
                    if (GraphObject.class.isAssignableFrom(class1)) {
                        return ((GraphObject)o).cast(clazz);
                    }
                    throw new FacebookGraphObjectException("Can't create GraphObject from " + class1.getName());
                }
                else {
                    if (!Iterable.class.equals(clazz) && !Collection.class.equals(clazz) && !List.class.equals(clazz) && !GraphObjectList.class.equals(clazz)) {
                        if (String.class.equals(clazz)) {
                            if (Double.class.isAssignableFrom(class1) || Float.class.isAssignableFrom(class1)) {
                                return (U)String.format("%f", o);
                            }
                            if (Number.class.isAssignableFrom(class1)) {
                                return (U)String.format("%d", o);
                            }
                        }
                        else if (Date.class.equals(clazz) && String.class.isAssignableFrom(class1)) {
                            for (final SimpleDateFormat simpleDateFormat : Factory.dateFormats) {
                                try {
                                    parse = simpleDateFormat.parse((String)o);
                                    if (parse != null) {
                                        return (U)parse;
                                    }
                                }
                                catch (ParseException ex) {}
                            }
                        }
                        throw new FacebookGraphObjectException("Can't convert type" + class1.getName() + " to " + clazz.getName());
                    }
                    if (parameterizedType == null) {
                        throw new FacebookGraphObjectException("can't infer generic type of: " + clazz.toString());
                    }
                    actualTypeArguments = parameterizedType.getActualTypeArguments();
                    if (actualTypeArguments == null || actualTypeArguments.length != 1 || !(actualTypeArguments[0] instanceof Class)) {
                        throw new FacebookGraphObjectException("Expect collection properties to be of a type with exactly one generic parameter.");
                    }
                    clazz2 = (Class)actualTypeArguments[0];
                    if (JSONArray.class.isAssignableFrom(class1)) {
                        return (U)createList((JSONArray)o, (Class<Object>)clazz2);
                    }
                    throw new FacebookGraphObjectException("Can't create Collection from " + class1.getName());
                }
            }
        }
        
        static String convertCamelCaseToLowercaseWithUnderscores(String s) {
            return s.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase(Locale.US);
        }
        
        public static GraphObject create() {
            return create(GraphObject.class);
        }
        
        public static <T extends GraphObject> T create(Class<T> clazz) {
            return createGraphObjectProxy(clazz, new JSONObject());
        }
        
        public static GraphObject create(JSONObject jsonObject) {
            return create(jsonObject, GraphObject.class);
        }
        
        public static <T extends GraphObject> T create(JSONObject jsonObject, Class<T> clazz) {
            return createGraphObjectProxy(clazz, jsonObject);
        }
        
        private static <T extends GraphObject> T createGraphObjectProxy(Class<T> clazz, JSONObject jsonObject) {
            verifyCanProxyClass(clazz);
            return (T)Proxy.newProxyInstance(GraphObject.class.getClassLoader(), new Class[] { clazz }, new GraphObjectProxy(jsonObject, clazz));
        }
        
        private static Map<String, Object> createGraphObjectProxyForMap(JSONObject jsonObject) {
            return (Map<String, Object>)Proxy.newProxyInstance(GraphObject.class.getClassLoader(), new Class[] { Map.class }, new GraphObjectProxy(jsonObject, Map.class));
        }
        
        public static <T> GraphObjectList<T> createList(Class<T> clazz) {
            return createList(new JSONArray(), clazz);
        }
        
        public static <T> GraphObjectList<T> createList(JSONArray jsonArray, Class<T> clazz) {
            return new GraphObjectListImpl<T>(jsonArray, clazz);
        }
        
        private static Object getUnderlyingJSONObject(Object o) {
            JSONArray jsonArray;
            Class<?> class1;
            Iterator<GraphObject> iterator;
            GraphObject next;
            if (o == null) {
                jsonArray = null;
            }
            else {
                class1 = o.getClass();
                if (GraphObject.class.isAssignableFrom(class1)) {
                    return ((GraphObject)o).getInnerJSONObject();
                }
                if (GraphObjectList.class.isAssignableFrom(class1)) {
                    return ((GraphObjectList)o).getInnerJSONArray();
                }
                if (!Iterable.class.isAssignableFrom(class1)) {
                    return o;
                }
                jsonArray = new JSONArray();
                for (final GraphObject next : (Iterable)o) {
                    if (GraphObject.class.isAssignableFrom(next.getClass())) {
                        jsonArray.put((Object)next.getInnerJSONObject());
                    }
                    else {
                        jsonArray.put((Object)next);
                    }
                }
            }
            return jsonArray;
        }
        
        private static <T extends GraphObject> boolean hasClassBeenVerified(Class<T> o) {
            synchronized (Factory.class) {
                return Factory.verifiedGraphObjectClasses.contains(o);
            }
        }
        
        public static boolean hasSameId(GraphObject graphObject, GraphObject obj) {
            Object property;
            Object property2;
            if (graphObject != null && obj != null && graphObject.asMap().containsKey("id") && obj.asMap().containsKey("id")) {
                if (graphObject.equals(obj)) {
                    return true;
                }
                property = graphObject.getProperty("id");
                property2 = obj.getProperty("id");
                if (property != null && property2 != null && property instanceof String && property2 instanceof String) {
                    return property.equals(property2);
                }
            }
            return false;
        }
        
        private static <T extends GraphObject> void recordClassHasBeenVerified(Class<T> e) {
            synchronized (Factory.class) {
                Factory.verifiedGraphObjectClasses.add(e);
            }
        }
        
        private static <T extends GraphObject> void verifyCanProxyClass(Class<T> clazz) {
            Method[] methods;
            int length;
            int i;
            Method method;
            String name;
            int length2;
            Class<?> returnType;
            boolean annotationPresent;
            if (hasClassBeenVerified(clazz)) {
                return;
            }
            if (!clazz.isInterface()) {
                throw new FacebookGraphObjectException("Factory can only wrap interfaces, not class: " + clazz.getName());
            }
            for (final Method method : clazz.getMethods()) {
                name = method.getName();
                length2 = method.getParameterTypes().length;
                returnType = method.getReturnType();
                annotationPresent = method.isAnnotationPresent(PropertyName.class);
                Label_0113: {
                    if (!method.getDeclaringClass().isAssignableFrom(GraphObject.class)) {
                        if (length2 == 1 && returnType == Void.TYPE) {
                            if (annotationPresent) {
                                if (!Utility.isNullOrEmpty(method.getAnnotation(PropertyName.class).value())) {
                                    break Label_0113;
                                }
                            }
                            else if (name.startsWith("set") && name.length() > 3) {
                                break Label_0113;
                            }
                        }
                        else if (length2 == 0 && returnType != Void.TYPE) {
                            if (annotationPresent) {
                                if (!Utility.isNullOrEmpty(method.getAnnotation(PropertyName.class).value())) {
                                    break Label_0113;
                                }
                            }
                            else if (name.startsWith("get") && name.length() > 3) {
                                break Label_0113;
                            }
                        }
                        throw new FacebookGraphObjectException("Factory can't proxy method: " + method.toString());
                    }
                }
            }
            recordClassHasBeenVerified((Class<GraphObject>)clazz);
        }
        
        private static final class GraphObjectListImpl<T> extends AbstractList<T> implements GraphObjectList<T>
        {
            private final Class<?> itemType;
            private final JSONArray state;
            
            public GraphObjectListImpl(JSONArray state, Class<?> itemType) {
                Validate.notNull(state, "state");
                Validate.notNull(itemType, "itemType");
                this.state = state;
                this.itemType = itemType;
            }
            
            private void checkIndex(int n) {
                if (n < 0 || n >= this.state.length()) {
                    throw new IndexOutOfBoundsException();
                }
            }
            
            private void put(int n, T t) {
                Object access$2;
                JSONException cause;
                access$2 = getUnderlyingJSONObject(t);
                try {
                    this.state.put(n, access$2);
                }
                catch (JSONException cause) {
                    throw new IllegalArgumentException((Throwable)cause);
                }
            }
            
            @Override
            public void add(int n, T t) {
                if (n < 0) {
                    throw new IndexOutOfBoundsException();
                }
                if (n < this.size()) {
                    throw new UnsupportedOperationException("Only adding items at the end of the list is supported.");
                }
                this.put(n, t);
            }
            
            @Override
            public final <U extends GraphObject> GraphObjectList<U> castToListOf(Class<U> clazz) {
                if (!GraphObject.class.isAssignableFrom(this.itemType)) {
                    throw new FacebookGraphObjectException("Can't cast GraphObjectCollection of non-GraphObject type " + this.itemType);
                }
                if (clazz.isAssignableFrom(this.itemType)) {
                    return (GraphObjectList<U>)this;
                }
                return Factory.createList(this.state, clazz);
            }
            
            @Override
            public void clear() {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public boolean equals(Object o) {
                if (o != null) {
                    if (this == o) {
                        return true;
                    }
                    if (this.getClass() == o.getClass()) {
                        return this.state.equals((Object)((GraphObjectListImpl)o).state);
                    }
                }
                return false;
            }
            
            @Override
            public T get(int n) {
                this.checkIndex(n);
                return Factory.coerceValueToExpectedType(this.state.opt(n), this.itemType, null);
            }
            
            @Override
            public final JSONArray getInnerJSONArray() {
                return this.state;
            }
            
            @Override
            public int hashCode() {
                return this.state.hashCode();
            }
            
            @Override
            public boolean remove(Object o) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public boolean removeAll(Collection<?> collection) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public boolean retainAll(Collection<?> collection) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public T set(int n, T t) {
                T value;
                this.checkIndex(n);
                value = this.get(n);
                this.put(n, t);
                return value;
            }
            
            @Override
            public int size() {
                return this.state.length();
            }
            
            @Override
            public String toString() {
                return String.format("GraphObjectList{itemType=%s, state=%s}", this.itemType.getSimpleName(), this.state);
            }
        }
        
        private static final class GraphObjectProxy extends ProxyBase<JSONObject>
        {
            private static final String CASTTOMAP_METHOD = "asMap";
            private static final String CAST_METHOD = "cast";
            private static final String CLEAR_METHOD = "clear";
            private static final String CONTAINSKEY_METHOD = "containsKey";
            private static final String CONTAINSVALUE_METHOD = "containsValue";
            private static final String ENTRYSET_METHOD = "entrySet";
            private static final String GETINNERJSONOBJECT_METHOD = "getInnerJSONObject";
            private static final String GETPROPERTYASLIST_METHOD = "getPropertyAsList";
            private static final String GETPROPERTYAS_METHOD = "getPropertyAs";
            private static final String GETPROPERTY_METHOD = "getProperty";
            private static final String GET_METHOD = "get";
            private static final String ISEMPTY_METHOD = "isEmpty";
            private static final String KEYSET_METHOD = "keySet";
            private static final String PUTALL_METHOD = "putAll";
            private static final String PUT_METHOD = "put";
            private static final String REMOVEPROPERTY_METHOD = "removeProperty";
            private static final String REMOVE_METHOD = "remove";
            private static final String SETPROPERTY_METHOD = "setProperty";
            private static final String SIZE_METHOD = "size";
            private static final String VALUES_METHOD = "values";
            private final Class<?> graphObjectClass;
            
            public GraphObjectProxy(JSONObject jsonObject, Class<?> graphObjectClass) {
                super(jsonObject);
                this.graphObjectClass = graphObjectClass;
            }
            
            private Object createGraphObjectsFromParameters(CreateGraphObject createGraphObject, Object o) {
                String value;
                GraphObject create;
                GraphObjectList<GraphObject> list;
                Iterator<Object> iterator;
                Object next;
                GraphObject create2;
                if (createGraphObject != null && !Utility.isNullOrEmpty(createGraphObject.value())) {
                    value = createGraphObject.value();
                    if (!List.class.isAssignableFrom(o.getClass())) {
                        create = Factory.create();
                        create.setProperty(value, o);
                        return create;
                    }
                    list = Factory.createList(GraphObject.class);
                    for (final Object next : (List)o) {
                        create2 = Factory.create();
                        create2.setProperty(value, next);
                        list.add(create2);
                    }
                    o = list;
                }
                return o;
            }
            
            private final Object proxyGraphObjectGettersAndSetters(Method method, Object[] array) throws JSONException {
                String name;
                int length;
                PropertyName propertyName;
                String s;
                Object opt;
                Class<?> returnType;
                Type genericReturnType;
                boolean b;
                ParameterizedType parameterizedType;
                name = method.getName();
                length = method.getParameterTypes().length;
                propertyName = method.getAnnotation(PropertyName.class);
                if (propertyName != null) {
                    s = propertyName.value();
                }
                else {
                    s = Factory.convertCamelCaseToLowercaseWithUnderscores(name.substring(3));
                }
                if (length == 0) {
                    opt = ((JSONObject)this.state).opt(s);
                    returnType = method.getReturnType();
                    genericReturnType = method.getGenericReturnType();
                    b = (genericReturnType instanceof ParameterizedType);
                    parameterizedType = null;
                    if (b) {
                        parameterizedType = (ParameterizedType)genericReturnType;
                    }
                    return Factory.coerceValueToExpectedType(opt, returnType, parameterizedType);
                }
                if (length == 1) {
                    ((JSONObject)this.state).putOpt(s, getUnderlyingJSONObject(this.createGraphObjectsFromParameters(method.getAnnotation(CreateGraphObject.class), array[0])));
                    return null;
                }
                return ((ProxyBase)this).throwUnexpectedMethodSignature(method);
            }
            
            private final Object proxyGraphObjectMethods(Object proxy, Method method, Object[] jsonProperty) {
                String name;
                Class clazz;
                name = method.getName();
                if (name.equals("cast")) {
                    clazz = (Class)jsonProperty[0];
                    if (clazz != null && clazz.isAssignableFrom(this.graphObjectClass)) {
                        return proxy;
                    }
                    return createGraphObjectProxy((Class<GraphObject>)clazz, (JSONObject)this.state);
                }
                else {
                    if (name.equals("getInnerJSONObject")) {
                        return ((GraphObjectProxy)Proxy.getInvocationHandler(proxy)).state;
                    }
                    if (name.equals("asMap")) {
                        return createGraphObjectProxyForMap((JSONObject)this.state);
                    }
                    if (name.equals("getProperty")) {
                        return ((JSONObject)this.state).opt((String)jsonProperty[0]);
                    }
                    if (name.equals("getPropertyAs")) {
                        return Factory.coerceValueToExpectedType(((JSONObject)this.state).opt((String)jsonProperty[0]), (Class<Object>)jsonProperty[1], null);
                    }
                    if (name.equals("getPropertyAsList")) {
                        return Factory.coerceValueToExpectedType(((JSONObject)this.state).opt((String)jsonProperty[0]), GraphObjectList.class, new ParameterizedType() {
                            private final /* synthetic */ Class val$expectedType = (Class)jsonProperty[1];
                            
                            @Override
                            public Type[] getActualTypeArguments() {
                                return new Type[] { this.val$expectedType };
                            }
                            
                            @Override
                            public Type getOwnerType() {
                                return null;
                            }
                            
                            @Override
                            public Type getRawType() {
                                return GraphObjectList.class;
                            }
                        });
                    }
                    if (name.equals("setProperty")) {
                        return this.setJSONProperty(jsonProperty);
                    }
                    if (name.equals("removeProperty")) {
                        ((JSONObject)this.state).remove((String)jsonProperty[0]);
                        return null;
                    }
                    return ((ProxyBase)this).throwUnexpectedMethodSignature(method);
                }
            }
            
            private final Object proxyMapMethods(Method method, Object[] jsonProperty) {
                String name;
                Map<String, Object> map;
                name = method.getName();
                if (name.equals("clear")) {
                    JsonUtil.jsonObjectClear((JSONObject)this.state);
                    return null;
                }
                if (name.equals("containsKey")) {
                    return ((JSONObject)this.state).has((String)jsonProperty[0]);
                }
                if (name.equals("containsValue")) {
                    return JsonUtil.jsonObjectContainsValue((JSONObject)this.state, jsonProperty[0]);
                }
                if (name.equals("entrySet")) {
                    return JsonUtil.jsonObjectEntrySet((JSONObject)this.state);
                }
                if (name.equals("get")) {
                    return ((JSONObject)this.state).opt((String)jsonProperty[0]);
                }
                if (name.equals("isEmpty")) {
                    if (((JSONObject)this.state).length() == 0) {
                        return true;
                    }
                    return false;
                }
                else {
                    if (name.equals("keySet")) {
                        return JsonUtil.jsonObjectKeySet((JSONObject)this.state);
                    }
                    if (name.equals("put")) {
                        return this.setJSONProperty(jsonProperty);
                    }
                    if (name.equals("putAll")) {
                        if (jsonProperty[0] instanceof Map) {
                            map = (Map<String, Object>)jsonProperty[0];
                        }
                        else {
                            if (!(jsonProperty[0] instanceof GraphObject)) {
                                return null;
                            }
                            map = ((GraphObject)jsonProperty[0]).asMap();
                        }
                        JsonUtil.jsonObjectPutAll((JSONObject)this.state, map);
                        return null;
                    }
                    if (name.equals("remove")) {
                        ((JSONObject)this.state).remove((String)jsonProperty[0]);
                        return null;
                    }
                    if (name.equals("size")) {
                        return ((JSONObject)this.state).length();
                    }
                    if (name.equals("values")) {
                        return JsonUtil.jsonObjectValues((JSONObject)this.state);
                    }
                    return ((ProxyBase)this).throwUnexpectedMethodSignature(method);
                }
            }
            
            private Object setJSONProperty(Object[] array) {
                String s;
                Object access$2;
                JSONException cause;
                s = (String)array[0];
                access$2 = getUnderlyingJSONObject(array[1]);
                try {
                    ((JSONObject)this.state).putOpt(s, access$2);
                    return null;
                }
                catch (JSONException cause) {
                    throw new IllegalArgumentException((Throwable)cause);
                }
            }
            
            @Override
            public final Object invoke(Object o, Method method, Object[] array) throws Throwable {
                Class<?> declaringClass;
                declaringClass = method.getDeclaringClass();
                if (declaringClass == Object.class) {
                    return ((ProxyBase)this).proxyObjectMethods(o, method, array);
                }
                if (declaringClass == Map.class) {
                    return this.proxyMapMethods(method, array);
                }
                if (declaringClass == GraphObject.class) {
                    return this.proxyGraphObjectMethods(o, method, array);
                }
                if (GraphObject.class.isAssignableFrom(declaringClass)) {
                    return this.proxyGraphObjectGettersAndSetters(method, array);
                }
                return ((ProxyBase)this).throwUnexpectedMethodSignature(method);
            }
            
            @Override
            public String toString() {
                return String.format("GraphObject{graphObjectClass=%s, state=%s}", this.graphObjectClass.getSimpleName(), this.state);
            }
        }
        
        private abstract static class ProxyBase<STATE> implements InvocationHandler
        {
            private static final String EQUALS_METHOD = "equals";
            private static final String TOSTRING_METHOD = "toString";
            protected final STATE state;
            
            protected ProxyBase(STATE state) {
                this.state = state;
            }
            
            protected final Object proxyObjectMethods(Object o, Method method, Object[] args) throws Throwable {
                String name;
                Object proxy;
                InvocationHandler invocationHandler;
                name = method.getName();
                if (name.equals("equals")) {
                    proxy = args[0];
                    if (proxy == null) {
                        return false;
                    }
                    invocationHandler = Proxy.getInvocationHandler(proxy);
                    if (!(invocationHandler instanceof GraphObjectProxy)) {
                        return false;
                    }
                    return this.state.equals(((GraphObjectProxy)invocationHandler).state);
                }
                else {
                    if (name.equals("toString")) {
                        return this.toString();
                    }
                    return method.invoke(this.state, args);
                }
            }
            
            protected final Object throwUnexpectedMethodSignature(Method method) {
                throw new FacebookGraphObjectException(String.valueOf(this.getClass().getName()) + " got an unexpected method signature: " + method.toString());
            }
        }
    }
}
