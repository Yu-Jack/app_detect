// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.c;

import java.util.Map;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import com.facebook.b.aj;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Collection;
import com.facebook.ac;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.HashSet;

public final class d
{
    private static final HashSet a;
    private static final SimpleDateFormat[] b;
    
    static {
        a = new HashSet();
        b = new SimpleDateFormat[] { new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US), new SimpleDateFormat("yyyy-MM-dd", Locale.US) };
    }
    
    public static c a() {
        return b(c.class, new JSONObject());
    }
    
    public static c a(final JSONObject jsonObject) {
        return b(c.class, jsonObject);
    }
    
    public static h a(final Class clazz) {
        return a(new JSONArray(), clazz);
    }
    
    public static h a(final JSONArray jsonArray, final Class clazz) {
        return new e(jsonArray, clazz);
    }
    
    static Object a(Object value, final Class clazz, final ParameterizedType parameterizedType) {
        if (value == null) {
            if (Boolean.TYPE.equals(clazz)) {
                value = false;
            }
            else {
                if (Character.TYPE.equals(clazz)) {
                    return '\0';
                }
                if (clazz.isPrimitive()) {
                    return 0;
                }
                return null;
            }
        }
        else {
            final Class<?> class1 = value.getClass();
            if (!clazz.isAssignableFrom(class1) && !clazz.isPrimitive()) {
                if (c.class.isAssignableFrom(clazz)) {
                    if (JSONObject.class.isAssignableFrom(class1)) {
                        return b(clazz, (JSONObject)value);
                    }
                    if (c.class.isAssignableFrom(class1)) {
                        return ((c)value).b();
                    }
                    throw new ac("Can't create GraphObject from " + class1.getName());
                }
                else {
                    if (!Iterable.class.equals(clazz) && !Collection.class.equals(clazz) && !List.class.equals(clazz) && !h.class.equals(clazz)) {
                        if (String.class.equals(clazz)) {
                            if (Double.class.isAssignableFrom(class1) || Float.class.isAssignableFrom(class1)) {
                                return String.format("%f", value);
                            }
                            if (Number.class.isAssignableFrom(class1)) {
                                return String.format("%d", value);
                            }
                        }
                        else if (Date.class.equals(clazz) && String.class.isAssignableFrom(class1)) {
                            for (final SimpleDateFormat simpleDateFormat : d.b) {
                                try {
                                    final Date parse = simpleDateFormat.parse((String)value);
                                    if (parse != null) {
                                        return parse;
                                    }
                                }
                                catch (ParseException ex) {}
                            }
                        }
                        throw new ac("Can't convert type" + class1.getName() + " to " + clazz.getName());
                    }
                    if (parameterizedType == null) {
                        throw new ac("can't infer generic type of: " + clazz.toString());
                    }
                    final Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    if (actualTypeArguments == null || actualTypeArguments.length != 1 || !(actualTypeArguments[0] instanceof Class)) {
                        throw new ac("Expect collection properties to be of a type with exactly one generic parameter.");
                    }
                    final Class clazz2 = (Class)actualTypeArguments[0];
                    if (JSONArray.class.isAssignableFrom(class1)) {
                        return a((JSONArray)value, clazz2);
                    }
                    throw new ac("Can't create Collection from " + class1.getName());
                }
            }
        }
        return value;
    }
    
    static String a(final String s) {
        return s.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase(Locale.US);
    }
    
    private static c b(final Class clazz, final JSONObject jsonObject) {
        if (!b(clazz)) {
            if (!clazz.isInterface()) {
                throw new ac("Factory can only wrap interfaces, not class: " + clazz.getName());
            }
            for (final Method method : clazz.getMethods()) {
                final String name = method.getName();
                final int length2 = method.getParameterTypes().length;
                final Class<?> returnType = method.getReturnType();
                final boolean annotationPresent = method.isAnnotationPresent(l.class);
                Label_0190: {
                    if (!method.getDeclaringClass().isAssignableFrom(c.class)) {
                        if (length2 == 1 && returnType == Void.TYPE) {
                            if (annotationPresent) {
                                if (!aj.a(method.getAnnotation(l.class).a())) {
                                    break Label_0190;
                                }
                            }
                            else if (name.startsWith("set") && name.length() > 3) {
                                break Label_0190;
                            }
                        }
                        else if (length2 == 0 && returnType != Void.TYPE) {
                            if (annotationPresent) {
                                if (!aj.a(method.getAnnotation(l.class).a())) {
                                    break Label_0190;
                                }
                            }
                            else if (name.startsWith("get")) {
                                if (name.length() > 3) {
                                    break Label_0190;
                                }
                            }
                        }
                        throw new ac("Factory can't proxy method: " + method.toString());
                    }
                }
            }
            c(clazz);
        }
        return (c)Proxy.newProxyInstance(c.class.getClassLoader(), new Class[] { clazz }, new f(jsonObject, clazz));
    }
    
    private static boolean b(final Class o) {
        synchronized (d.class) {
            return d.a.contains(o);
        }
    }
    
    private static void c(final Class e) {
        synchronized (d.class) {
            d.a.add(e);
        }
    }
}
