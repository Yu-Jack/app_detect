// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.i;

import java.util.Map;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Modifier;
import java.util.EnumSet;
import java.util.EnumMap;
import java.io.Serializable;

public final class l
{
    public static Class<? extends Enum<?>> a(final Enum<?> enum1) {
        Serializable s = enum1.getClass();
        if (((Class<? extends Enum<?>>)s).getSuperclass() != Enum.class) {
            s = ((Class<? extends Enum<?>>)s).getSuperclass();
        }
        return (Class<? extends Enum<?>>)s;
    }
    
    public static Class<?> a(final String className) {
        if (className.indexOf(46) < 0) {
            if ("int".equals(className)) {
                return Integer.TYPE;
            }
            if ("long".equals(className)) {
                return Long.TYPE;
            }
            if ("float".equals(className)) {
                return Float.TYPE;
            }
            if ("double".equals(className)) {
                return Double.TYPE;
            }
            if ("boolean".equals(className)) {
                return Boolean.TYPE;
            }
            if ("byte".equals(className)) {
                return Byte.TYPE;
            }
            if ("char".equals(className)) {
                return Character.TYPE;
            }
            if ("short".equals(className)) {
                return Short.TYPE;
            }
            if ("void".equals(className)) {
                return Void.TYPE;
            }
        }
        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Throwable ex = null;
        if (contextClassLoader != null) {
            try {
                return Class.forName(className, true, contextClassLoader);
            }
            catch (Exception ex2) {
                ex = a(ex2);
            }
        }
        try {
            return Class.forName(className);
        }
        catch (Exception ex3) {
            if (ex == null) {
                ex = a(ex3);
            }
            if (ex instanceof RuntimeException) {
                throw (RuntimeException)ex;
            }
            throw new ClassNotFoundException(ex.getMessage(), ex);
        }
    }
    
    public static Class<? extends Enum<?>> a(final EnumMap<?, ?> enumMap) {
        if (!enumMap.isEmpty()) {
            return a((Enum<?>)enumMap.keySet().iterator().next());
        }
        return m.a.a(enumMap);
    }
    
    public static Class<? extends Enum<?>> a(final EnumSet<?> set) {
        if (!set.isEmpty()) {
            return a(set.iterator().next());
        }
        return m.a.a(set);
    }
    
    public static String a(final Class<?> clazz) {
        if (clazz.isAnnotation()) {
            return "annotation";
        }
        if (clazz.isArray()) {
            return "array";
        }
        if (clazz.isEnum()) {
            return "enum";
        }
        if (clazz.isPrimitive()) {
            return "primitive";
        }
        return null;
    }
    
    public static String a(final Class<?> clazz, final boolean b) {
        try {
            if (clazz.getEnclosingMethod() != null) {
                return "local/anonymous";
            }
            if (!b && clazz.getEnclosingClass() != null && !Modifier.isStatic(clazz.getModifiers())) {
                return "non-static member class";
            }
            goto Label_0035;
        }
        catch (NullPointerException ex) {}
        catch (SecurityException ex2) {
            goto Label_0035;
        }
    }
    
    public static Throwable a(Throwable cause) {
        while (cause.getCause() != null) {
            cause = cause.getCause();
        }
        return cause;
    }
    
    public static List<Class<?>> a(final Class<?> clazz, final Class<?> clazz2) {
        return a(clazz, clazz2, new ArrayList<Class<?>>(8));
    }
    
    public static List<Class<?>> a(final Class<?> clazz, final Class<?> clazz2, final List<Class<?>> list) {
        a(clazz, clazz2, list, false);
        return list;
    }
    
    private static void a(final Class<?> clazz, final Class<?> clazz2, final Collection<Class<?>> collection, final boolean b) {
        if (clazz != clazz2 && clazz != null && clazz != Object.class) {
            if (b) {
                if (collection.contains(clazz)) {
                    return;
                }
                collection.add(clazz);
            }
            final Class<?>[] interfaces = clazz.getInterfaces();
            for (int length = interfaces.length, i = 0; i < length; ++i) {
                a(interfaces[i], clazz2, collection, true);
            }
            a(clazz.getSuperclass(), clazz2, collection, true);
        }
    }
    
    public static void a(final Throwable cause, final String message) {
        if (cause instanceof RuntimeException) {
            throw (RuntimeException)cause;
        }
        if (cause instanceof Error) {
            throw (Error)cause;
        }
        throw new IllegalArgumentException(message, cause);
    }
    
    public static void a(final Member obj) {
        final AccessibleObject accessibleObject = (AccessibleObject)obj;
        try {
            accessibleObject.setAccessible(true);
        }
        catch (SecurityException ex) {
            if (!accessibleObject.isAccessible()) {
                throw new IllegalArgumentException("Can not access " + obj + " (from class " + obj.getDeclaringClass().getName() + "; failed to set access: " + ex.getMessage());
            }
        }
    }
    
    public static boolean a(final Method method) {
        if (!Modifier.isStatic(method.getModifiers())) {
            final Class<?>[] parameterTypes = method.getParameterTypes();
            if ((parameterTypes == null || parameterTypes.length == 0) && Void.TYPE != method.getReturnType()) {
                return true;
            }
        }
        return false;
    }
    
    public static Class<?> b(final Class<?> clazz) {
        try {
            if (clazz.getEnclosingMethod() != null) {
                return null;
            }
            if (!Modifier.isStatic(clazz.getModifiers())) {
                return clazz.getEnclosingClass();
            }
        }
        catch (NullPointerException ex) {
            return null;
        }
        catch (SecurityException ex2) {}
        return null;
    }
    
    public static <T> T b(final Class<T> clazz, final boolean b) {
        final Constructor<T> c = c(clazz, b);
        if (c == null) {
            throw new IllegalArgumentException("Class " + clazz.getName() + " has no default (no arg) constructor");
        }
        try {
            return c.newInstance(new Object[0]);
        }
        catch (Exception ex) {
            b(ex, "Failed to instantiate class " + clazz.getName() + ", problem: " + ex.getMessage());
            return null;
        }
    }
    
    public static void b(final Throwable t) {
        a(t, t.getMessage());
    }
    
    public static void b(final Throwable t, final String s) {
        a(a(t), s);
    }
    
    public static <T> Constructor<T> c(final Class<T> clazz, final boolean b) {
        Constructor<T> declaredConstructor = null;
        try {
            declaredConstructor = clazz.getDeclaredConstructor((Class<?>[])new Class[0]);
            if (b) {
                a(declaredConstructor);
                return declaredConstructor;
            }
            if (!Modifier.isPublic(declaredConstructor.getModifiers())) {
                throw new IllegalArgumentException("Default constructor for " + clazz.getName() + " is not accessible (non-public?): not allowed to try modify access via Reflection: can not instantiate type");
            }
        }
        catch (NoSuchMethodException ex2) {}
        catch (Exception ex) {
            b(ex, "Failed to find default constructor of class " + clazz.getName() + ", problem: " + ex.getMessage());
            goto Label_0071;
        }
        return declaredConstructor;
    }
    
    public static void c(final Throwable t) {
        b(a(t));
    }
    
    public static boolean c(final Class<?> clazz) {
        final String name = clazz.getName();
        return name.startsWith("net.sf.cglib.proxy.") || name.startsWith("org.hibernate.proxy.");
    }
    
    public static boolean d(final Class<?> clazz) {
        return (0x600 & clazz.getModifiers()) == 0x0;
    }
    
    public static boolean e(final Class<?> clazz) {
        return clazz.isArray() || Collection.class.isAssignableFrom(clazz) || Map.class.isAssignableFrom(clazz);
    }
    
    public static Object f(final Class<?> clazz) {
        if (clazz == Integer.TYPE) {
            return 0;
        }
        if (clazz == Long.TYPE) {
            return 0L;
        }
        if (clazz == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (clazz == Double.TYPE) {
            return 0.0;
        }
        if (clazz == Float.TYPE) {
            return 0.0f;
        }
        if (clazz == Byte.TYPE) {
            return 0;
        }
        if (clazz == Short.TYPE) {
            return 0;
        }
        if (clazz == Character.TYPE) {
            return '\0';
        }
        throw new IllegalArgumentException("Class " + clazz.getName() + " is not a primitive type");
    }
    
    public static Class<? extends Enum<?>> g(Class<?> superclass) {
        if (superclass.getSuperclass() != Enum.class) {
            superclass = superclass.getSuperclass();
        }
        return (Class<? extends Enum<?>>)superclass;
    }
}
