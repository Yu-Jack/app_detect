// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.e;

import java.util.LinkedHashMap;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Map;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.lang.reflect.AnnotatedElement;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Field;
import java.util.Collections;
import org.codehaus.jackson.c.i.l;
import org.codehaus.jackson.c.b;
import java.util.List;

public final class b extends a
{
    private static final j[] l;
    protected final Class<?> a;
    protected final List<Class<?>> b;
    protected final org.codehaus.jackson.c.b c;
    protected final org.codehaus.jackson.c.j d;
    protected final Class<?> e;
    protected j f;
    protected c g;
    protected List<c> h;
    protected List<f> i;
    protected g j;
    protected List<d> k;
    
    static {
        l = new j[0];
    }
    
    private b(final Class<?> a, final List<Class<?>> b, final org.codehaus.jackson.c.b c, final org.codehaus.jackson.c.j d, final j f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        Class<?> a2;
        if (this.d == null) {
            a2 = null;
        }
        else {
            a2 = this.d.a(this.a);
        }
        this.e = a2;
        this.f = f;
    }
    
    public static b a(final Class<?> clazz, final org.codehaus.jackson.c.b b, final org.codehaus.jackson.c.j j) {
        final b b2 = new b(clazz, org.codehaus.jackson.c.i.l.a(clazz, null), b, j, null);
        b2.m();
        return b2;
    }
    
    private j[] a(final int n) {
        j[] l;
        if (n == 0) {
            l = org.codehaus.jackson.c.e.b.l;
        }
        else {
            l = new j[n];
            for (int i = 0; i < n; ++i) {
                l[i] = this.o();
            }
        }
        return l;
    }
    
    public static b b(final Class<?> clazz, final org.codehaus.jackson.c.b b, final org.codehaus.jackson.c.j j) {
        final b b2 = new b(clazz, Collections.emptyList(), b, j, null);
        b2.m();
        return b2;
    }
    
    private boolean b(final Field field) {
        if (!field.isSynthetic()) {
            final int modifiers = field.getModifiers();
            if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers)) {
                return true;
            }
        }
        return false;
    }
    
    private j o() {
        return new j();
    }
    
    @Override
    public <A extends Annotation> A a(final Class<A> clazz) {
        if (this.f == null) {
            return null;
        }
        return this.f.a(clazz);
    }
    
    protected c a(final Constructor<?> constructor, final boolean b) {
        if (this.c == null) {
            return new c(constructor, this.o(), this.a(constructor.getParameterTypes().length));
        }
        if (b) {
            return new c(constructor, this.a(constructor.getDeclaredAnnotations()), null);
        }
        final Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
        final int length = constructor.getParameterTypes().length;
        j[] array2;
        if (length != parameterAnnotations.length) {
            final Class<?> declaringClass = constructor.getDeclaringClass();
            Annotation[][] array;
            if (declaringClass.isEnum() && length == 2 + parameterAnnotations.length) {
                array = new Annotation[2 + parameterAnnotations.length][];
                System.arraycopy(parameterAnnotations, 0, array, 2, parameterAnnotations.length);
                array2 = this.a(array);
            }
            else if (declaringClass.isMemberClass() && length == 1 + parameterAnnotations.length) {
                array = new Annotation[1 + parameterAnnotations.length][];
                System.arraycopy(parameterAnnotations, 0, array, 1, parameterAnnotations.length);
                array2 = this.a(array);
            }
            else {
                array = parameterAnnotations;
                array2 = null;
            }
            if (array2 == null) {
                throw new IllegalStateException("Internal error: constructor for " + constructor.getDeclaringClass().getName() + " has mismatch: " + length + " parameters; " + array.length + " sets of annotations");
            }
        }
        else {
            array2 = this.a(parameterAnnotations);
        }
        return new c(constructor, this.a(constructor.getDeclaredAnnotations()), array2);
    }
    
    protected d a(final Field field) {
        if (this.c == null) {
            return new d(field, this.o());
        }
        return new d(field, this.a(field.getDeclaredAnnotations()));
    }
    
    public f a(final String s, final Class<?>[] array) {
        return this.j.a(s, array);
    }
    
    protected f a(final Method method) {
        if (this.c == null) {
            return new f(method, this.o(), null);
        }
        return new f(method, this.a(method.getDeclaredAnnotations()), null);
    }
    
    protected j a(final Annotation[] array) {
        final j j = new j();
        if (array != null) {
            for (final Annotation annotation : array) {
                if (this.c.a(annotation)) {
                    j.b(annotation);
                }
            }
        }
        return j;
    }
    
    protected void a(final Class<?> clazz, final Class<?> clazz2, final Map<String, d> map) {
        final ArrayList<Class> list = new ArrayList<Class>();
        list.add(clazz2);
        org.codehaus.jackson.c.i.l.a(clazz2, clazz, (List<Class<?>>)list);
        final Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            for (final Field field : iterator.next().getDeclaredFields()) {
                if (this.b(field)) {
                    final d d = map.get(field.getName());
                    if (d != null) {
                        for (final Annotation annotation : field.getDeclaredAnnotations()) {
                            if (this.c.a(annotation)) {
                                d.a(annotation);
                            }
                        }
                    }
                }
            }
        }
    }
    
    protected void a(final Class<?> clazz, final s s, final g g, final Class<?> clazz2, final g g2) {
        if (clazz2 != null) {
            this.b(clazz, s, g, clazz2, g2);
        }
        if (clazz != null) {
            for (final Method method : clazz.getDeclaredMethods()) {
                if (this.a(method, s)) {
                    final f b = g.b(method);
                    if (b == null) {
                        final f a = this.a(method);
                        g.a(a);
                        final f a2 = g2.a(method);
                        if (a2 != null) {
                            this.a(a2.e(), a, false);
                        }
                    }
                    else {
                        this.a(method, b);
                        if (b.h().isInterface() && !method.getDeclaringClass().isInterface()) {
                            g.a(b.a(method));
                        }
                    }
                }
            }
        }
    }
    
    protected void a(final Constructor<?> constructor, final c c, final boolean b) {
        for (final Annotation annotation : constructor.getDeclaredAnnotations()) {
            if (this.c.a(annotation)) {
                c.a(annotation);
            }
        }
        if (b) {
            final Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
            for (int length2 = parameterAnnotations.length, j = 0; j < length2; ++j) {
                final Annotation[] array = parameterAnnotations[j];
                for (int length3 = array.length, k = 0; k < length3; ++k) {
                    c.a(j, array[k]);
                }
            }
        }
    }
    
    protected void a(final Method method, final f f) {
        for (final Annotation annotation : method.getDeclaredAnnotations()) {
            if (this.c.a(annotation)) {
                f.b(annotation);
            }
        }
    }
    
    protected void a(final Method method, final f f, final boolean b) {
        for (final Annotation annotation : method.getDeclaredAnnotations()) {
            if (this.c.a(annotation)) {
                f.a(annotation);
            }
        }
        if (b) {
            final Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            for (int length2 = parameterAnnotations.length, j = 0; j < length2; ++j) {
                final Annotation[] array = parameterAnnotations[j];
                for (int length3 = array.length, k = 0; k < length3; ++k) {
                    f.a(j, array[k]);
                }
            }
        }
    }
    
    protected void a(final Map<String, d> map, final Class<?> clazz) {
        final Class<?> superclass = clazz.getSuperclass();
        if (superclass != null) {
            this.a(map, superclass);
            for (final Field field : clazz.getDeclaredFields()) {
                if (this.b(field)) {
                    map.put(field.getName(), this.a(field));
                }
            }
            if (this.d != null) {
                final Class<?> a = this.d.a(clazz);
                if (a != null) {
                    this.a(superclass, a, map);
                }
            }
        }
    }
    
    protected void a(final j j, final Class<?> clazz) {
        if (this.d != null) {
            this.a(j, clazz, this.d.a(clazz));
        }
    }
    
    protected void a(final j j, final Class<?> clazz, final Class<?> clazz2) {
        if (clazz2 != null) {
            for (final Annotation annotation : clazz2.getDeclaredAnnotations()) {
                if (this.c.a(annotation)) {
                    j.a(annotation);
                }
            }
            final Iterator<Class<?>> iterator = org.codehaus.jackson.c.i.l.a(clazz2, clazz).iterator();
            while (iterator.hasNext()) {
                for (final Annotation annotation2 : iterator.next().getDeclaredAnnotations()) {
                    if (this.c.a(annotation2)) {
                        j.a(annotation2);
                    }
                }
            }
        }
    }
    
    public void a(final s s) {
        this.j = new g();
        final g g = new g();
        this.a(this.a, s, this.j, this.e, g);
        for (final Class<?> clazz : this.b) {
            Class<?> a;
            if (this.d == null) {
                a = null;
            }
            else {
                a = this.d.a(clazz);
            }
            this.a(clazz, s, this.j, a, g);
        }
        if (this.d != null) {
            final Class<?> a2 = this.d.a(Object.class);
            if (a2 != null) {
                this.b(this.a, s, this.j, a2, g);
            }
        }
        if (this.c != null && !g.a()) {
            for (final f f : g) {
                try {
                    final Method declaredMethod = Object.class.getDeclaredMethod(f.b(), f.m());
                    if (declaredMethod == null) {
                        continue;
                    }
                    final f a3 = this.a(declaredMethod);
                    this.a(f.e(), a3, false);
                    this.j.a(a3);
                }
                catch (Exception ex) {}
            }
        }
    }
    
    public void a(final boolean b) {
        this.h = null;
        for (final Constructor<?> constructor : this.a.getDeclaredConstructors()) {
            if (constructor.getParameterTypes().length == 0) {
                this.g = this.a(constructor, true);
            }
            else if (b) {
                if (this.h == null) {
                    final Constructor<?>[] declaredConstructors;
                    this.h = new ArrayList<c>(Math.max(10, declaredConstructors.length));
                }
                this.h.add(this.a(constructor, false));
            }
        }
        if (this.e != null && (this.g != null || this.h != null)) {
            this.c(this.e);
        }
        if (this.c != null) {
            if (this.g != null && this.c.a(this.g)) {
                this.g = null;
            }
            if (this.h != null) {
                int size = this.h.size();
                while (true) {
                    final int n = size - 1;
                    if (n < 0) {
                        break;
                    }
                    if (this.c.a(this.h.get(n))) {
                        this.h.remove(n);
                        size = n;
                    }
                    else {
                        size = n;
                    }
                }
            }
        }
        this.i = null;
        if (b) {
            for (final Method method : this.a.getDeclaredMethods()) {
                if (Modifier.isStatic(method.getModifiers()) && method.getParameterTypes().length >= 1) {
                    if (this.i == null) {
                        this.i = new ArrayList<f>(8);
                    }
                    this.i.add(this.b(method));
                }
            }
            if (this.e != null && this.i != null) {
                this.d(this.e);
            }
            if (this.c != null && this.i != null) {
                int size2 = this.i.size();
                while (true) {
                    final int n2 = size2 - 1;
                    if (n2 < 0) {
                        break;
                    }
                    if (this.c.a(this.i.get(n2))) {
                        this.i.remove(n2);
                        size2 = n2;
                    }
                    else {
                        size2 = n2;
                    }
                }
            }
        }
    }
    
    protected boolean a(final Method method, final s s) {
        return (s == null || s.a(method)) && !method.isSynthetic() && !method.isBridge();
    }
    
    protected j[] a(final Annotation[][] array) {
        final int length = array.length;
        final j[] array2 = new j[length];
        for (int i = 0; i < length; ++i) {
            array2[i] = this.a(array[i]);
        }
        return array2;
    }
    
    @Override
    public String b() {
        return this.a.getName();
    }
    
    protected f b(final Method method) {
        if (this.c == null) {
            return new f(method, this.o(), this.a(method.getParameterTypes().length));
        }
        return new f(method, this.a(method.getDeclaredAnnotations()), this.a(method.getParameterAnnotations()));
    }
    
    protected void b(final Class<?> clazz, final s s, final g g, final Class<?> clazz2, final g g2) {
        final ArrayList<Class> list = new ArrayList<Class>();
        list.add(clazz2);
        org.codehaus.jackson.c.i.l.a(clazz2, clazz, (List<Class<?>>)list);
        final Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            for (final Method method : iterator.next().getDeclaredMethods()) {
                if (this.a(method, s)) {
                    final f b = g.b(method);
                    if (b != null) {
                        this.a(method, b);
                    }
                    else {
                        g2.a(this.a(method));
                    }
                }
            }
        }
    }
    
    @Override
    public Type c() {
        return this.a;
    }
    
    protected void c(final Class<?> clazz) {
        int size;
        if (this.h == null) {
            size = 0;
        }
        else {
            size = this.h.size();
        }
        final Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        final int length = declaredConstructors.length;
        int i = 0;
        r[] array = null;
        while (i < length) {
            final Constructor constructor = declaredConstructors[i];
            Label_0064: {
                if (constructor.getParameterTypes().length == 0) {
                    if (this.g != null) {
                        this.a(constructor, this.g, false);
                    }
                }
                else {
                    r[] array2;
                    if (array == null) {
                        array2 = new r[size];
                        for (int j = 0; j < size; ++j) {
                            array2[j] = new r(this.h.get(j).e());
                        }
                    }
                    else {
                        array2 = array;
                    }
                    final r r = new r(constructor);
                    for (int k = 0; k < size; ++k) {
                        if (r.equals(array2[k])) {
                            this.a(constructor, this.h.get(k), true);
                            array = array2;
                            break Label_0064;
                        }
                    }
                    array = array2;
                }
            }
            ++i;
        }
    }
    
    @Override
    public Class<?> d() {
        return this.a;
    }
    
    protected void d(final Class<?> clazz) {
        r[] array = null;
        final int size = this.i.size();
        for (final Method method : clazz.getDeclaredMethods()) {
            Label_0051: {
                if (Modifier.isStatic(method.getModifiers()) && method.getParameterTypes().length != 0) {
                    r[] array2;
                    if (array == null) {
                        array2 = new r[size];
                        for (int j = 0; j < size; ++j) {
                            array2[j] = new r(this.i.get(j).e());
                        }
                    }
                    else {
                        array2 = array;
                    }
                    final r r = new r(method);
                    for (int k = 0; k < size; ++k) {
                        if (r.equals(array2[k])) {
                            this.a(method, this.i.get(k), true);
                            array = array2;
                            break Label_0051;
                        }
                    }
                    array = array2;
                }
            }
        }
    }
    
    public Class<?> e() {
        return this.a;
    }
    
    public org.codehaus.jackson.c.i.a f() {
        return this.f;
    }
    
    public boolean g() {
        return this.f.a() > 0;
    }
    
    public c h() {
        return this.g;
    }
    
    public List<c> i() {
        if (this.h == null) {
            return Collections.emptyList();
        }
        return this.h;
    }
    
    public List<f> j() {
        if (this.i == null) {
            return Collections.emptyList();
        }
        return this.i;
    }
    
    public Iterable<f> k() {
        return this.j;
    }
    
    public Iterable<d> l() {
        if (this.k == null) {
            return (Iterable<d>)Collections.emptyList();
        }
        return this.k;
    }
    
    public void m() {
        this.f = new j();
        if (this.c == null) {
            return;
        }
        if (this.e != null) {
            this.a(this.f, this.a, this.e);
        }
        for (final Annotation annotation : this.a.getDeclaredAnnotations()) {
            if (this.c.a(annotation)) {
                this.f.a(annotation);
            }
        }
        for (final Class<?> clazz : this.b) {
            this.a(this.f, clazz);
            for (final Annotation annotation2 : clazz.getDeclaredAnnotations()) {
                if (this.c.a(annotation2)) {
                    this.f.a(annotation2);
                }
            }
        }
        this.a(this.f, Object.class);
    }
    
    public void n() {
        final LinkedHashMap<String, d> linkedHashMap = new LinkedHashMap<String, d>();
        this.a(linkedHashMap, this.a);
        if (linkedHashMap.isEmpty()) {
            this.k = Collections.emptyList();
            return;
        }
        (this.k = new ArrayList<d>(linkedHashMap.size())).addAll(linkedHashMap.values());
    }
    
    @Override
    public String toString() {
        return "[AnnotedClass " + this.a.getName() + "]";
    }
}
