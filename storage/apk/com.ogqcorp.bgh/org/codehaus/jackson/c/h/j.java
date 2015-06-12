// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.h;

import java.util.Collections;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.ParameterizedType;
import java.util.LinkedHashMap;
import java.lang.reflect.Type;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Map;
import org.codehaus.jackson.f.a;

public class j
{
    public static final a a;
    private static final a[] g;
    protected final k b;
    protected final a c;
    protected final Class<?> d;
    protected Map<String, a> e;
    protected HashSet<String> f;
    private final j h;
    
    static {
        g = new a[0];
        a = new h(Object.class);
    }
    
    public j(final k k, final Class<?> clazz) {
        this(k, null, clazz, null);
    }
    
    private j(final k b, final j h, final Class<?> d, final a c) {
        this.b = b;
        this.h = h;
        this.d = d;
        this.c = c;
    }
    
    public j(final k k, final a a) {
        this(k, null, a.p(), a);
    }
    
    public j a() {
        return new j(this.b, this, this.d, this.c);
    }
    
    public a a(final String s) {
        if (this.e == null) {
            this.c();
        }
        final a a = this.e.get(s);
        if (a != null) {
            return a;
        }
        if (this.f != null && this.f.contains(s)) {
            return j.a;
        }
        if (this.h != null) {
            return this.h.a(s);
        }
        if (this.d != null && this.d.getEnclosingClass() != null && !Modifier.isStatic(this.d.getModifiers())) {
            return j.a;
        }
        String str;
        if (this.d != null) {
            str = this.d.getName();
        }
        else if (this.c != null) {
            str = this.c.toString();
        }
        else {
            str = "UNKNOWN";
        }
        throw new IllegalArgumentException("Type variable '" + s + "' can not be resolved (with context of class " + str + ")");
    }
    
    public a a(final Type type) {
        return this.b.b(type, this);
    }
    
    public void a(final String s, final a a) {
        if (this.e == null || this.e.size() == 0) {
            this.e = new LinkedHashMap<String, a>();
        }
        this.e.put(s, a);
    }
    
    public void b(final String e) {
        if (this.f == null) {
            this.f = new HashSet<String>();
        }
        this.f.add(e);
    }
    
    protected void b(final Type type) {
        int i = 0;
        if (type != null) {
            Class<?> clazz2;
            if (type instanceof ParameterizedType) {
                final ParameterizedType parameterizedType = (ParameterizedType)type;
                final Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                if (actualTypeArguments != null && actualTypeArguments.length > 0) {
                    final Class clazz = (Class)parameterizedType.getRawType();
                    final TypeVariable[] typeParameters = clazz.getTypeParameters();
                    if (typeParameters.length != actualTypeArguments.length) {
                        throw new IllegalArgumentException("Strange parametrized type (in class " + clazz.getName() + "): number of type arguments != number of type parameters (" + actualTypeArguments.length + " vs " + typeParameters.length + ")");
                    }
                    for (int length = actualTypeArguments.length, j = 0; j < length; ++j) {
                        final String name = typeParameters[j].getName();
                        if (this.e == null) {
                            this.e = new LinkedHashMap<String, a>();
                        }
                        else if (this.e.containsKey(name)) {
                            continue;
                        }
                        this.b(name);
                        this.e.put(name, this.b.b(actualTypeArguments[j], this));
                    }
                }
                clazz2 = (Class<?>)parameterizedType.getRawType();
            }
            else {
                if (!(type instanceof Class)) {
                    return;
                }
                final Class clazz3 = (Class)type;
                this.b(clazz3.getDeclaringClass());
                final TypeVariable<Class<?>>[] typeParameters2 = clazz3.getTypeParameters();
                if (typeParameters2 != null && typeParameters2.length > 0) {
                    final a c = this.c;
                    a[] b = null;
                    if (c != null) {
                        final boolean assignable = clazz3.isAssignableFrom(this.c.p());
                        b = null;
                        if (assignable) {
                            b = this.b.b(this.c, clazz3);
                        }
                    }
                    for (int k = 0; k < typeParameters2.length; ++k) {
                        final TypeVariable<Class<?>> typeVariable = typeParameters2[k];
                        final String name2 = typeVariable.getName();
                        final Type type2 = typeVariable.getBounds()[0];
                        if (type2 != null) {
                            if (this.e == null) {
                                this.e = new LinkedHashMap<String, a>();
                            }
                            else if (this.e.containsKey(name2)) {
                                continue;
                            }
                            this.b(name2);
                            if (b != null) {
                                this.e.put(name2, b[k]);
                            }
                            else {
                                this.e.put(name2, this.b.b(type2, this));
                            }
                        }
                    }
                }
                clazz2 = (Class<?>)clazz3;
            }
            this.b(clazz2.getGenericSuperclass());
            for (Type[] genericInterfaces = clazz2.getGenericInterfaces(); i < genericInterfaces.length; ++i) {
                this.b(genericInterfaces[i]);
            }
        }
    }
    
    public a[] b() {
        if (this.e == null) {
            this.c();
        }
        if (this.e.size() == 0) {
            return j.g;
        }
        return this.e.values().toArray(new a[this.e.size()]);
    }
    
    protected void c() {
        this.b(this.d);
        if (this.c != null) {
            final int h = this.c.h();
            if (h > 0) {
                if (this.e == null) {
                    this.e = new LinkedHashMap<String, a>();
                }
                for (int i = 0; i < h; ++i) {
                    this.e.put(this.c.a(i), this.c.b(i));
                }
            }
        }
        if (this.e == null) {
            this.e = Collections.emptyMap();
        }
    }
    
    @Override
    public String toString() {
        if (this.e == null) {
            this.c();
        }
        final StringBuilder sb = new StringBuilder("[TypeBindings for ");
        if (this.c != null) {
            sb.append(this.c.toString());
        }
        else {
            sb.append(this.d.getName());
        }
        sb.append(": ").append(this.e).append("]");
        return sb.toString();
    }
}
