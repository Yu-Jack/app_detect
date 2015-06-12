// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.c;

import java.lang.reflect.InvocationHandler;
import java.lang.annotation.Annotation;
import java.text.ParseException;
import java.util.Date;
import java.util.Collection;
import com.facebook.ac;
import org.json.JSONArray;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Map;
import java.lang.reflect.Method;
import org.json.JSONException;
import java.util.Iterator;
import java.util.List;
import com.facebook.b.aj;
import org.json.JSONObject;

final class f extends g
{
    private final Class b;
    
    public f(final JSONObject jsonObject, final Class b) {
        super(jsonObject);
        this.b = b;
    }
    
    private static Object a(final a a, Object o) {
        if (a != null && !aj.a(a.a())) {
            a.a();
            if (!List.class.isAssignableFrom(o.getClass())) {
                final c a2 = d.a();
                a2.f();
                return a2;
            }
            final List<c> a3 = (List<c>)d.a(c.class);
            final Iterator iterator = ((List)o).iterator();
            while (iterator.hasNext()) {
                iterator.next();
                final c a4 = d.a();
                a4.f();
                a3.add(a4);
            }
            o = a3;
        }
        return o;
    }
    
    private Object a(final Object[] array) {
        final String s = (String)array[0];
        final Object a = d.a(array[1]);
        try {
            ((JSONObject)this.a).putOpt(s, a);
            return null;
        }
        catch (JSONException cause) {
            throw new IllegalArgumentException((Throwable)cause);
        }
    }
    
    @Override
    public final Object invoke(final Object proxy, final Method method, final Object[] array) {
        final Class<?> declaringClass = method.getDeclaringClass();
        Object a;
        if (declaringClass == Object.class) {
            a = this.a(method, array);
        }
        else if (declaringClass == Map.class) {
            final String name = method.getName();
            if (name.equals("clear")) {
                final Iterator keys = ((JSONObject)this.a).keys();
                while (true) {
                    final boolean hasNext = keys.hasNext();
                    a = null;
                    if (!hasNext) {
                        break;
                    }
                    keys.next();
                    keys.remove();
                }
            }
            else {
                if (name.equals("containsKey")) {
                    return ((JSONObject)this.a).has((String)array[0]);
                }
                if (name.equals("containsValue")) {
                    final JSONObject jsonObject = (JSONObject)this.a;
                    final Object obj = array[0];
                    final Iterator keys2 = jsonObject.keys();
                    while (keys2.hasNext()) {
                        final Object opt = jsonObject.opt((String)keys2.next());
                        if (opt != null && opt.equals(obj)) {
                            return true;
                        }
                    }
                    return false;
                }
                if (name.equals("entrySet")) {
                    final JSONObject jsonObject2 = (JSONObject)this.a;
                    a = new HashSet<k>();
                    final Iterator keys3 = jsonObject2.keys();
                    while (keys3.hasNext()) {
                        final String s = keys3.next();
                        ((HashSet<k>)a).add(new k(s, jsonObject2.opt(s)));
                    }
                }
                else {
                    if (name.equals("get")) {
                        return ((JSONObject)this.a).opt((String)array[0]);
                    }
                    if (name.equals("isEmpty")) {
                        if (((JSONObject)this.a).length() == 0) {
                            return true;
                        }
                        return false;
                    }
                    else {
                        if (name.equals("keySet")) {
                            return j.a((JSONObject)this.a);
                        }
                        if (name.equals("put")) {
                            return this.a(array);
                        }
                        if (name.equals("putAll")) {
                            Map c;
                            if (array[0] instanceof Map) {
                                c = (Map)array[0];
                            }
                            else {
                                final boolean b2 = array[0] instanceof c;
                                a = null;
                                if (!b2) {
                                    return a;
                                }
                                c = ((c)array[0]).c();
                            }
                            j.a((JSONObject)this.a, c);
                            return null;
                        }
                        if (name.equals("remove")) {
                            ((JSONObject)this.a).remove((String)array[0]);
                            return null;
                        }
                        if (name.equals("size")) {
                            return ((JSONObject)this.a).length();
                        }
                        if (name.equals("values")) {
                            return j.b((JSONObject)this.a);
                        }
                        return this.a(method);
                    }
                }
            }
        }
        else if (declaringClass == c.class) {
            final String name2 = method.getName();
            if (name2.equals("cast")) {
                final Class clazz = (Class)array[0];
                if (clazz != null && clazz.isAssignableFrom(this.b)) {
                    return proxy;
                }
                return b(clazz, (JSONObject)this.a);
            }
            else {
                if (name2.equals("getInnerJSONObject")) {
                    return ((f)Proxy.getInvocationHandler(proxy)).a;
                }
                if (name2.equals("asMap")) {
                    return d.b((JSONObject)this.a);
                }
                if (name2.equals("getProperty")) {
                    return ((JSONObject)this.a).opt((String)array[0]);
                }
                if (name2.equals("getPropertyAs")) {
                    return d.a(((JSONObject)this.a).opt((String)array[0]), (Class)array[1], null);
                }
                if (name2.equals("getPropertyAsList")) {
                    return d.a(((JSONObject)this.a).opt((String)array[0]), h.class, new ParameterizedType() {
                        private final /* synthetic */ Class b = (Class)array[1];
                        
                        @Override
                        public final Type[] getActualTypeArguments() {
                            return new Type[] { this.b };
                        }
                        
                        @Override
                        public final Type getOwnerType() {
                            return null;
                        }
                        
                        @Override
                        public final Type getRawType() {
                            return h.class;
                        }
                    });
                }
                if (name2.equals("setProperty")) {
                    return this.a(array);
                }
                if (name2.equals("removeProperty")) {
                    ((JSONObject)this.a).remove((String)array[0]);
                    return null;
                }
                return this.a(method);
            }
        }
        else {
            if (!c.class.isAssignableFrom(declaringClass)) {
                return this.a(method);
            }
            final String name3 = method.getName();
            final int length = method.getParameterTypes().length;
            final l l = method.getAnnotation(l.class);
            String s2;
            if (l != null) {
                s2 = l.a();
            }
            else {
                s2 = d.a(name3.substring(3));
            }
            if (length == 0) {
                final Object opt2 = ((JSONObject)this.a).opt(s2);
                final Class<?> returnType = method.getReturnType();
                final Type genericReturnType = method.getGenericReturnType();
                ParameterizedType parameterizedType;
                if (genericReturnType instanceof ParameterizedType) {
                    parameterizedType = (ParameterizedType)genericReturnType;
                }
                else {
                    parameterizedType = null;
                }
                return d.a(opt2, returnType, parameterizedType);
            }
            if (length == 1) {
                ((JSONObject)this.a).putOpt(s2, d.a(a(method.getAnnotation(a.class), array[0])));
                return null;
            }
            return this.a(method);
        }
        return a;
    }
    
    @Override
    public final String toString() {
        return String.format("GraphObject{graphObjectClass=%s, state=%s}", this.b.getSimpleName(), this.a);
    }
}
