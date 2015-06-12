// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.h;

import java.util.ArrayList;
import java.util.HashMap;
import org.codehaus.jackson.f.b;
import java.lang.reflect.WildcardType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.TypeVariable;
import java.util.List;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import org.codehaus.jackson.f.a;

public final class k
{
    @Deprecated
    public static final k a;
    private static final a[] f;
    protected final l[] b;
    protected final m c;
    protected e d;
    protected e e;
    
    static {
        a = new k();
        f = new a[0];
    }
    
    private k() {
        this.c = new m(this);
        this.b = null;
    }
    
    public static k a() {
        return k.a;
    }
    
    public static a a(final String s) {
        return k.a.b(s);
    }
    
    public static a b() {
        return a().c();
    }
    
    private a b(final Class<?> clazz) {
        final a[] a = this.a(clazz, Map.class);
        if (a == null) {
            return g.a(clazz, this.c(), this.c());
        }
        if (a.length != 2) {
            throw new IllegalArgumentException("Strange Map type " + clazz.getName() + ": can not determine type parameters");
        }
        return g.a(clazz, a[0], a[1]);
    }
    
    private a c(final Class<?> clazz) {
        final a[] a = this.a(clazz, Collection.class);
        if (a == null) {
            return org.codehaus.jackson.c.h.d.a(clazz, this.c());
        }
        if (a.length != 1) {
            throw new IllegalArgumentException("Strange Collection type " + clazz.getName() + ": can not determine type parameters");
        }
        return org.codehaus.jackson.c.h.d.a(clazz, a[0]);
    }
    
    protected e a(final Type type, final Class<?> clazz) {
        final e e = new e(type);
        final Class<?> e2 = e.e();
        if (e2 == clazz) {
            return e;
        }
        final Type genericSuperclass = e2.getGenericSuperclass();
        if (genericSuperclass != null) {
            final e a = this.a(genericSuperclass, clazz);
            if (a != null) {
                a.b(e);
                e.a(a);
                return e;
            }
        }
        return null;
    }
    
    protected e a(final e e) {
        synchronized (this) {
            if (this.d == null) {
                final e a = e.a();
                this.a(a, Map.class);
                this.d = a.b();
            }
            final e a2 = this.d.a();
            e.a(a2);
            a2.b(e);
            return e;
        }
    }
    
    protected e a(final e e, final Class<?> clazz) {
        final Class<?> e2 = e.e();
        final Type[] genericInterfaces = e2.getGenericInterfaces();
        if (genericInterfaces != null) {
            for (int length = genericInterfaces.length, i = 0; i < length; ++i) {
                final e b = this.b(genericInterfaces[i], clazz);
                if (b != null) {
                    b.b(e);
                    e.a(b);
                    return e;
                }
            }
        }
        final Type genericSuperclass = e2.getGenericSuperclass();
        if (genericSuperclass != null) {
            final e b2 = this.b(genericSuperclass, clazz);
            if (b2 != null) {
                b2.b(e);
                e.a(b2);
                return e;
            }
        }
        return null;
    }
    
    public g a(final Class<? extends Map> clazz, final Class<?> clazz2, final Class<?> clazz3) {
        return g.a(clazz, this.a((Type)clazz2), this.a((Type)clazz3));
    }
    
    public a a(final Class<?> clazz) {
        return new h(clazz);
    }
    
    protected a a(final Class<?> clazz, final List<a> list) {
        if (clazz.isArray()) {
            return org.codehaus.jackson.c.h.a.a(this.b(clazz.getComponentType(), (j)null), null, null);
        }
        if (clazz.isEnum()) {
            return new h(clazz);
        }
        if (Map.class.isAssignableFrom(clazz)) {
            if (list.size() > 0) {
                final a a = list.get(0);
                a c;
                if (list.size() >= 2) {
                    c = list.get(1);
                }
                else {
                    c = this.c();
                }
                return g.a(clazz, a, c);
            }
            return this.b(clazz);
        }
        else if (Collection.class.isAssignableFrom(clazz)) {
            if (list.size() >= 1) {
                return org.codehaus.jackson.c.h.d.a(clazz, list.get(0));
            }
            return this.c(clazz);
        }
        else {
            if (list.size() == 0) {
                return new h(clazz);
            }
            return this.a(clazz, list.toArray(new a[list.size()]));
        }
    }
    
    protected a a(final Class<?> clazz, final j j) {
        if (clazz.isArray()) {
            return org.codehaus.jackson.c.h.a.a(this.b(clazz.getComponentType(), (j)null), null, null);
        }
        if (clazz.isEnum()) {
            return new h(clazz);
        }
        if (Map.class.isAssignableFrom(clazz)) {
            return this.b(clazz);
        }
        if (Collection.class.isAssignableFrom(clazz)) {
            return this.c(clazz);
        }
        return new h(clazz);
    }
    
    public a a(final Class<?> clazz, final a[] array) {
        final TypeVariable<Class<?>>[] typeParameters = clazz.getTypeParameters();
        if (typeParameters.length != array.length) {
            throw new IllegalArgumentException("Parameter type mismatch for " + clazz.getName() + ": expected " + typeParameters.length + " parameters, was given " + array.length);
        }
        final String[] array2 = new String[typeParameters.length];
        for (int i = 0; i < typeParameters.length; ++i) {
            array2[i] = typeParameters[i].getName();
        }
        return new h(clazz, array2, array, null, null);
    }
    
    protected a a(final GenericArrayType genericArrayType, final j j) {
        return org.codehaus.jackson.c.h.a.a(this.b(genericArrayType.getGenericComponentType(), j), null, null);
    }
    
    protected a a(final ParameterizedType parameterizedType, final j j) {
        final Class clazz = (Class)parameterizedType.getRawType();
        final Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        int length;
        if (actualTypeArguments == null) {
            length = 0;
        }
        else {
            length = actualTypeArguments.length;
        }
        a[] f;
        if (length == 0) {
            f = k.f;
        }
        else {
            f = new a[length];
            for (int i = 0; i < length; ++i) {
                f[i] = this.b(actualTypeArguments[i], j);
            }
        }
        if (Map.class.isAssignableFrom(clazz)) {
            final a[] b = this.b(this.a(clazz, f), Map.class);
            if (b.length != 2) {
                throw new IllegalArgumentException("Could not find 2 type parameters for Map class " + clazz.getName() + " (found " + b.length + ")");
            }
            return g.a(clazz, b[0], b[1]);
        }
        else if (Collection.class.isAssignableFrom(clazz)) {
            final a[] b2 = this.b(this.a(clazz, f), Collection.class);
            if (b2.length != 1) {
                throw new IllegalArgumentException("Could not find 1 type parameter for Collection class " + clazz.getName() + " (found " + b2.length + ")");
            }
            return org.codehaus.jackson.c.h.d.a(clazz, b2[0]);
        }
        else {
            if (length == 0) {
                return new h(clazz);
            }
            return this.a(clazz, f);
        }
    }
    
    public a a(final Type type) {
        return this.b(type, (j)null);
    }
    
    public a a(final Type type, final j j) {
        return this.b(type, j);
    }
    
    protected a a(final TypeVariable<?> typeVariable, final j j) {
        a a;
        if (j == null) {
            a = this.c();
        }
        else {
            final String name = typeVariable.getName();
            a = j.a(name);
            if (a == null) {
                final Type[] bounds = typeVariable.getBounds();
                j.b(name);
                return this.b(bounds[0], j);
            }
        }
        return a;
    }
    
    protected a a(final WildcardType wildcardType, final j j) {
        return this.b(wildcardType.getUpperBounds()[0], j);
    }
    
    public a a(final a obj, final Class<?> clazz) {
        if (!(obj instanceof h) || (!clazz.isArray() && !Map.class.isAssignableFrom(clazz) && !Collection.class.isAssignableFrom(clazz))) {
            return obj.f(clazz);
        }
        if (!obj.p().isAssignableFrom(clazz)) {
            throw new IllegalArgumentException("Class " + clazz.getClass().getName() + " not subtype of " + obj);
        }
        a a = this.a(clazz, new j(this, obj.p()));
        final Object n = obj.n();
        if (n != null) {
            a = a.d(n);
        }
        final Object o = obj.o();
        if (o != null) {
            a = a.f(o);
        }
        return a;
    }
    
    public a a(final b<?> b) {
        return this.b(b.a(), (j)null);
    }
    
    public a[] a(final Class<?> clazz, final Class<?> clazz2) {
        return this.a(clazz, clazz2, new j(this, clazz));
    }
    
    public a[] a(final Class<?> clazz, final Class<?> clazz2, j j) {
        e e = this.c(clazz, clazz2);
        if (e == null) {
            throw new IllegalArgumentException("Class " + clazz.getName() + " is not a subtype of " + clazz2.getName());
        }
        while (e.b() != null) {
            e = e.b();
            final Class<?> e2 = e.e();
            final j i = new j(this, e2);
            if (e.c()) {
                final Type[] actualTypeArguments = e.d().getActualTypeArguments();
                final TypeVariable<Class<?>>[] typeParameters = e2.getTypeParameters();
                for (int length = actualTypeArguments.length, k = 0; k < length; ++k) {
                    i.a(typeParameters[k].getName(), k.a.b(actualTypeArguments[k], j));
                }
            }
            j = i;
        }
        if (!e.c()) {
            return null;
        }
        return j.b();
    }
    
    public d b(final Class<? extends Collection> clazz, final Class<?> clazz2) {
        return org.codehaus.jackson.c.h.d.a(clazz, this.a((Type)clazz2));
    }
    
    protected e b(final Type type, final Class<?> clazz) {
        final e e = new e(type);
        final Class<?> e2 = e.e();
        if (e2 == clazz) {
            return new e(type);
        }
        if (e2 == HashMap.class && clazz == Map.class) {
            return this.a(e);
        }
        if (e2 == ArrayList.class && clazz == List.class) {
            return this.b(e);
        }
        return this.a(e, clazz);
    }
    
    protected e b(final e e) {
        synchronized (this) {
            if (this.e == null) {
                final e a = e.a();
                this.a(a, List.class);
                this.e = a.b();
            }
            final e a2 = this.e.a();
            e.a(a2);
            a2.b(e);
            return e;
        }
    }
    
    public a b(final String s) {
        return this.c.a(s);
    }
    
    public a b(final Type type, j j) {
        a a;
        if (type instanceof Class) {
            final Class clazz = (Class)type;
            if (j == null) {
                j = new j(this, clazz);
            }
            a = this.a(clazz, j);
        }
        else if (type instanceof ParameterizedType) {
            a = this.a((ParameterizedType)type, j);
        }
        else if (type instanceof GenericArrayType) {
            a = this.a((GenericArrayType)type, j);
        }
        else if (type instanceof TypeVariable) {
            a = this.a((TypeVariable<?>)type, j);
        }
        else {
            if (!(type instanceof WildcardType)) {
                throw new IllegalArgumentException("Unrecognized Type: " + type.toString());
            }
            a = this.a((WildcardType)type, j);
        }
        if (this.b != null && !a.f()) {
            final l[] b = this.b;
            a a2;
            for (int length = b.length, i = 0; i < length; ++i, a = a2) {
                a2 = b[i].a(a, type, j, this);
            }
        }
        return a;
    }
    
    public a[] b(final a a, final Class<?> clazz) {
        final Class<?> p2 = a.p();
        if (p2 == clazz) {
            final int h = a.h();
            a[] array;
            if (h == 0) {
                array = null;
            }
            else {
                array = new a[h];
                for (int i = 0; i < h; ++i) {
                    array[i] = a.b(i);
                }
            }
            return array;
        }
        return this.a(p2, clazz, new j(this, a));
    }
    
    protected e c(final Class<?> clazz, final Class<?> clazz2) {
        if (clazz2.isInterface()) {
            return this.b(clazz, clazz2);
        }
        return this.a((Type)clazz, clazz2);
    }
    
    protected a c() {
        return new h(Object.class);
    }
}
