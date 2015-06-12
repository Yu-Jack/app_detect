// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Iterator;
import org.codehaus.jackson.c.y;
import org.codehaus.jackson.c.ag;
import org.codehaus.jackson.c.b.b.aa;
import java.util.EnumMap;
import org.codehaus.jackson.c.b.b.bv;
import org.codehaus.jackson.c.b.b.l;
import java.util.EnumSet;
import org.codehaus.jackson.c.b.b.ab;
import org.codehaus.jackson.c.h.g;
import org.codehaus.jackson.c.h.c;
import org.codehaus.jackson.i;
import org.codehaus.jackson.c.i.o;
import org.codehaus.jackson.c.e.k;
import org.codehaus.jackson.c.f.d;
import org.codehaus.jackson.c.ai;
import org.codehaus.jackson.c.az;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.e.e;
import org.codehaus.jackson.c.n;
import org.codehaus.jackson.c.b.b.ac;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;
import java.util.SortedSet;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.LinkedHashMap;
import org.codehaus.jackson.c.b.b.bs;
import java.util.Collection;
import java.util.Map;
import org.codehaus.jackson.c.af;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.c.h.b;
import java.util.HashMap;
import org.codehaus.jackson.c.r;

public abstract class b extends r
{
    static final HashMap<org.codehaus.jackson.c.h.b, x<Object>> b;
    static final HashMap<a, af> c;
    static final HashMap<String, Class<? extends Map>> d;
    static final HashMap<String, Class<? extends Collection>> e;
    protected static final HashMap<a, x<Object>> f;
    protected org.codehaus.jackson.c.d.a g;
    
    static {
        b = s.a();
        c = bs.a();
        (d = new HashMap<String, Class<? extends Map>>()).put(Map.class.getName(), LinkedHashMap.class);
        org.codehaus.jackson.c.b.b.d.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
        org.codehaus.jackson.c.b.b.d.put(SortedMap.class.getName(), TreeMap.class);
        org.codehaus.jackson.c.b.b.d.put("java.util.NavigableMap", TreeMap.class);
        while (true) {
            try {
                org.codehaus.jackson.c.b.b.d.put(Class.forName("java.util.concurrent.ConcurrentNavigableMap").getName(), (Class<? extends Map>)Class.forName("java.util.concurrent.ConcurrentSkipListMap"));
                (e = new HashMap<String, Class<? extends Collection>>()).put(Collection.class.getName(), ArrayList.class);
                org.codehaus.jackson.c.b.b.e.put(List.class.getName(), ArrayList.class);
                org.codehaus.jackson.c.b.b.e.put(Set.class.getName(), HashSet.class);
                org.codehaus.jackson.c.b.b.e.put(SortedSet.class.getName(), TreeSet.class);
                org.codehaus.jackson.c.b.b.e.put(Queue.class.getName(), LinkedList.class);
                org.codehaus.jackson.c.b.b.e.put("java.util.Deque", LinkedList.class);
                org.codehaus.jackson.c.b.b.e.put("java.util.NavigableSet", TreeSet.class);
                f = ac.a();
            }
            catch (SecurityException ex) {
                continue;
            }
            catch (ClassNotFoundException ex2) {
                continue;
            }
            break;
        }
    }
    
    protected b() {
        this.g = org.codehaus.jackson.c.d.a.a;
    }
    
    public az a(final n n, final a a, final e e, final f f) {
        final org.codehaus.jackson.c.b a2 = n.a();
        final d<?> a3 = a2.a(n, e, a);
        if (a3 == null) {
            return this.b(n, a, f);
        }
        return a3.a(n, a, n.l().a(e, n, a2), f);
    }
    
    public abstract t a(final n p0, final k p1);
    
    protected o<?> a(final Class<?> clazz, final n n) {
        if (n.a(org.codehaus.jackson.c.o.j)) {
            return o.b(clazz);
        }
        return o.b(clazz, n.a());
    }
    
    protected abstract x<?> a(final Class<?> p0, final n p1, final k p2, final f p3);
    
    protected abstract x<?> a(final Class<? extends i> p0, final n p1, final f p2);
    
    protected abstract x<?> a(final org.codehaus.jackson.c.h.a p0, final n p1, final org.codehaus.jackson.c.t p2, final f p3, final az p4, final x<?> p5);
    
    protected abstract x<?> a(final c p0, final n p1, final org.codehaus.jackson.c.t p2, final k p3, final f p4, final az p5, final x<?> p6);
    
    protected abstract x<?> a(final org.codehaus.jackson.c.h.d p0, final n p1, final org.codehaus.jackson.c.t p2, final k p3, final f p4, final az p5, final x<?> p6);
    
    protected abstract x<?> a(final org.codehaus.jackson.c.h.f p0, final n p1, final org.codehaus.jackson.c.t p2, final k p3, final f p4, final af p5, final az p6, final x<?> p7);
    
    protected abstract x<?> a(final g p0, final n p1, final org.codehaus.jackson.c.t p2, final k p3, final f p4, final af p5, final az p6, final x<?> p7);
    
    protected x<Object> a(final n n, final org.codehaus.jackson.c.e.a a, final f f) {
        final Object h = n.a().h(a);
        if (h != null) {
            return this.a(n, a, f, h);
        }
        return null;
    }
    
    x<Object> a(final n n, final org.codehaus.jackson.c.e.a a, final f f, final Object o) {
        if (o instanceof x) {
            x<Object> a2 = (x<Object>)o;
            if (a2 instanceof org.codehaus.jackson.c.k) {
                a2 = ((org.codehaus.jackson.c.k<Object>)a2).a(n, f);
            }
            return a2;
        }
        if (!(o instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned deserializer definition of type " + o.getClass().getName() + "; expected type JsonDeserializer or Class<JsonDeserializer> instead");
        }
        final Class clazz = (Class)o;
        if (!x.class.isAssignableFrom(clazz)) {
            throw new IllegalStateException("AnnotationIntrospector returned Class " + clazz.getName() + "; expected Class<JsonDeserializer>");
        }
        x<Object> x = n.a(a, clazz);
        if (x instanceof org.codehaus.jackson.c.k) {
            x = ((org.codehaus.jackson.c.k<Object>)x).a(n, f);
        }
        return x;
    }
    
    @Override
    public x<?> a(final n n, final org.codehaus.jackson.c.t t, final org.codehaus.jackson.c.h.a obj, final f f) {
        final a g = obj.g();
        x<Object> a = g.n();
        Label_0104: {
            if (a != null) {
                break Label_0104;
            }
            x<?> a2 = org.codehaus.jackson.c.b.b.f.get(g);
            if (a2 != null) {
                final x<?> a3 = this.a(obj, n, t, f, null, null);
                if (a3 != null) {
                    a2 = a3;
                }
            }
            else {
                if (g.t()) {
                    throw new IllegalArgumentException("Internal error: primitive type (" + obj + ") passed, no array deserializer found");
                }
                break Label_0104;
            }
            return a2;
        }
        final az az = g.o();
        az b;
        if (az == null) {
            b = this.b(n, g, f);
        }
        else {
            b = az;
        }
        x<?> a2 = this.a(obj, n, t, f, b, a);
        if (a2 == null) {
            if (a == null) {
                a = t.a(n, g, f);
            }
            return new ab(obj, a, b);
        }
        return a2;
    }
    
    @Override
    public x<?> a(final n n, final org.codehaus.jackson.c.t t, final c c, final f f) {
        final c c2 = (c)this.a(n, c);
        final k k = n.c(c2.p());
        final x<Object> a = this.a(n, k.c(), f);
        if (a != null) {
            return a;
        }
        final c c3 = this.a(n, k.c(), c2, null);
        final a g = c3.g();
        final x<?> x = g.n();
        final az az = g.o();
        az b;
        if (az == null) {
            b = this.b(n, g, f);
        }
        else {
            b = az;
        }
        return this.a(c3, n, t, k, f, b, x);
    }
    
    @Override
    public x<?> a(final n n, final org.codehaus.jackson.c.t t, final org.codehaus.jackson.c.h.d d, final f f) {
        final org.codehaus.jackson.c.h.d d2 = (org.codehaus.jackson.c.h.d)this.a(n, d);
        final Class<?> p4 = d2.p();
        k k = n.c(d2);
        final x<Object> a = this.a(n, k.c(), f);
        x<?> a2;
        if (a != null) {
            a2 = a;
        }
        else {
            org.codehaus.jackson.c.h.d obj = this.a(n, k.c(), d2, null);
            final a g = obj.g();
            x<?> a3 = g.n();
            final az az = g.o();
            az b;
            if (az == null) {
                b = this.b(n, g, f);
            }
            else {
                b = az;
            }
            a2 = this.a(obj, n, t, k, f, b, a3);
            if (a2 == null) {
                if (a3 == null) {
                    if (EnumSet.class.isAssignableFrom(p4)) {
                        return new l(g.p(), this.b(n, t, g, f));
                    }
                    a3 = t.a(n, g, f);
                }
                if (obj.s() || obj.c()) {
                    final Class<? extends Collection> clazz = org.codehaus.jackson.c.b.b.e.get(p4.getName());
                    if (clazz == null) {
                        throw new IllegalArgumentException("Can not find a deserializer for non-concrete Collection type " + obj);
                    }
                    final org.codehaus.jackson.c.h.d d3 = (org.codehaus.jackson.c.h.d)n.a(obj, clazz);
                    k = (k)n.c(d3);
                    obj = d3;
                }
                final t a4 = this.a(n, k);
                if (g.p() == String.class) {
                    return new bv(obj, a3, a4);
                }
                return new org.codehaus.jackson.c.b.b.f(obj, (x<Object>)a3, b, a4);
            }
        }
        return a2;
    }
    
    @Override
    public x<?> a(final n n, final org.codehaus.jackson.c.t t, final org.codehaus.jackson.c.h.f f, final f f2) {
        final org.codehaus.jackson.c.h.f f3 = (org.codehaus.jackson.c.h.f)this.a(n, f);
        final k k = n.c(f3);
        final x<Object> a = this.a(n, k.c(), f2);
        if (a != null) {
            return a;
        }
        final org.codehaus.jackson.c.h.f f4 = this.a(n, k.c(), f3, null);
        final a i = f4.k();
        final a g = f4.g();
        final x<?> x = g.n();
        final af af = i.n();
        af c;
        if (af == null) {
            c = t.c(n, i, f2);
        }
        else {
            c = af;
        }
        final az az = g.o();
        az b;
        if (az == null) {
            b = this.b(n, g, f2);
        }
        else {
            b = az;
        }
        return this.a(f4, n, t, k, f2, c, b, x);
    }
    
    @Override
    public x<?> a(final n n, final org.codehaus.jackson.c.t t, final g g, final f f) {
        final g g2 = (g)this.a(n, g);
        final k k = n.c(g2);
        final x<Object> a = this.a(n, k.c(), f);
        x<?> a2;
        if (a != null) {
            a2 = a;
        }
        else {
            g obj = this.a(n, k.c(), g2, null);
            final a i = obj.k();
            final a g3 = obj.g();
            x<?> a3 = g3.n();
            final af af = i.n();
            af c;
            if (af == null) {
                c = t.c(n, i, f);
            }
            else {
                c = af;
            }
            final az az = g3.o();
            az b;
            if (az == null) {
                b = this.b(n, g3, f);
            }
            else {
                b = az;
            }
            a2 = this.a(obj, n, t, k, f, c, b, a3);
            if (a2 == null) {
                if (a3 == null) {
                    a3 = t.a(n, g3, f);
                }
                final Class<?> p4 = obj.p();
                if (!EnumMap.class.isAssignableFrom(p4)) {
                    k j;
                    if (obj.s() || obj.c()) {
                        final Class<? extends Map> clazz = org.codehaus.jackson.c.b.b.d.get(p4.getName());
                        if (clazz == null) {
                            throw new IllegalArgumentException("Can not find a deserializer for non-concrete Map type " + obj);
                        }
                        final g g4 = (g)n.a(obj, clazz);
                        j = n.c(g4);
                        obj = g4;
                    }
                    else {
                        j = k;
                    }
                    final aa aa = new aa(obj, this.a(n, j), c, (x<Object>)a3, b);
                    aa.a(n.a().c(j.c()));
                    return aa;
                }
                final Class<?> p5 = i.p();
                if (p5 == null || !p5.isEnum()) {
                    throw new IllegalArgumentException("Can not construct EnumMap; generic (key) type not available");
                }
                return new org.codehaus.jackson.c.b.b.k(i.p(), this.b(n, t, i, f), (x<Object>)a3);
            }
        }
        return a2;
    }
    
    protected <T extends a> T a(final n p0, final org.codehaus.jackson.c.e.a p1, final T p2, final String p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_1        
        //     1: invokevirtual   org/codehaus/jackson/c/n.a:()Lorg/codehaus/jackson/c/b;
        //     4: astore          5
        //     6: aload           5
        //     8: aload_2        
        //     9: aload_3        
        //    10: aload           4
        //    12: invokevirtual   org/codehaus/jackson/c/b.a:(Lorg/codehaus/jackson/c/e/a;Lorg/codehaus/jackson/f/a;Ljava/lang/String;)Ljava/lang/Class;
        //    15: astore          6
        //    17: aload           6
        //    19: ifnull          459
        //    22: aload_3        
        //    23: aload           6
        //    25: invokevirtual   org/codehaus/jackson/f/a.f:(Ljava/lang/Class;)Lorg/codehaus/jackson/f/a;
        //    28: astore          19
        //    30: aload           19
        //    32: astore          7
        //    34: aload           7
        //    36: invokevirtual   org/codehaus/jackson/f/a.f:()Z
        //    39: ifeq            332
        //    42: aload           5
        //    44: aload_2        
        //    45: aload           7
        //    47: invokevirtual   org/codehaus/jackson/f/a.k:()Lorg/codehaus/jackson/f/a;
        //    50: aload           4
        //    52: invokevirtual   org/codehaus/jackson/c/b.b:(Lorg/codehaus/jackson/c/e/a;Lorg/codehaus/jackson/f/a;Ljava/lang/String;)Ljava/lang/Class;
        //    55: astore          8
        //    57: aload           8
        //    59: ifnull          195
        //    62: aload           7
        //    64: instanceof      Lorg/codehaus/jackson/c/h/f;
        //    67: ifne            179
        //    70: new             Lorg/codehaus/jackson/c/z;
        //    73: dup            
        //    74: new             Ljava/lang/StringBuilder;
        //    77: dup            
        //    78: invokespecial   java/lang/StringBuilder.<init>:()V
        //    81: ldc_w           "Illegal key-type annotation: type "
        //    84: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    87: aload           7
        //    89: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    92: ldc_w           " is not a Map(-like) type"
        //    95: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    98: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   101: invokespecial   org/codehaus/jackson/c/z.<init>:(Ljava/lang/String;)V
        //   104: athrow         
        //   105: astore          18
        //   107: new             Lorg/codehaus/jackson/c/z;
        //   110: dup            
        //   111: new             Ljava/lang/StringBuilder;
        //   114: dup            
        //   115: invokespecial   java/lang/StringBuilder.<init>:()V
        //   118: ldc_w           "Failed to narrow type "
        //   121: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   124: aload_3        
        //   125: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   128: ldc_w           " with concrete-type annotation (value "
        //   131: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   134: aload           6
        //   136: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //   139: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   142: ldc_w           "), method '"
        //   145: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   148: aload_2        
        //   149: invokevirtual   org/codehaus/jackson/c/e/a.b:()Ljava/lang/String;
        //   152: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   155: ldc_w           "': "
        //   158: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   161: aload           18
        //   163: invokevirtual   java/lang/IllegalArgumentException.getMessage:()Ljava/lang/String;
        //   166: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   169: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   172: aconst_null    
        //   173: aload           18
        //   175: invokespecial   org/codehaus/jackson/c/z.<init>:(Ljava/lang/String;Lorg/codehaus/jackson/h;Ljava/lang/Throwable;)V
        //   178: athrow         
        //   179: aload           7
        //   181: checkcast       Lorg/codehaus/jackson/c/h/f;
        //   184: aload           8
        //   186: invokevirtual   org/codehaus/jackson/c/h/f.d:(Ljava/lang/Class;)Lorg/codehaus/jackson/f/a;
        //   189: astore          17
        //   191: aload           17
        //   193: astore          7
        //   195: aload           7
        //   197: invokevirtual   org/codehaus/jackson/f/a.k:()Lorg/codehaus/jackson/f/a;
        //   200: astore          9
        //   202: aload           9
        //   204: ifnull          248
        //   207: aload           9
        //   209: invokevirtual   org/codehaus/jackson/f/a.n:()Ljava/lang/Object;
        //   212: ifnonnull       248
        //   215: aload           5
        //   217: aload_2        
        //   218: invokevirtual   org/codehaus/jackson/c/b.i:(Lorg/codehaus/jackson/c/e/a;)Ljava/lang/Class;
        //   221: astore          15
        //   223: aload           15
        //   225: ifnull          248
        //   228: aload           15
        //   230: ldc_w           Lorg/codehaus/jackson/c/ag;.class
        //   233: if_acmpeq       248
        //   236: aload           9
        //   238: aload_1        
        //   239: aload_2        
        //   240: aload           15
        //   242: invokevirtual   org/codehaus/jackson/c/n.b:(Lorg/codehaus/jackson/c/e/a;Ljava/lang/Class;)Lorg/codehaus/jackson/c/af;
        //   245: invokevirtual   org/codehaus/jackson/f/a.j:(Ljava/lang/Object;)V
        //   248: aload           5
        //   250: aload_2        
        //   251: aload           7
        //   253: invokevirtual   org/codehaus/jackson/f/a.g:()Lorg/codehaus/jackson/f/a;
        //   256: aload           4
        //   258: invokevirtual   org/codehaus/jackson/c/b.c:(Lorg/codehaus/jackson/c/e/a;Lorg/codehaus/jackson/f/a;Ljava/lang/String;)Ljava/lang/Class;
        //   261: astore          10
        //   263: aload           10
        //   265: ifnull          281
        //   268: aload           7
        //   270: aload           10
        //   272: invokevirtual   org/codehaus/jackson/f/a.b:(Ljava/lang/Class;)Lorg/codehaus/jackson/f/a;
        //   275: astore          14
        //   277: aload           14
        //   279: astore          7
        //   281: aload           7
        //   283: invokevirtual   org/codehaus/jackson/f/a.g:()Lorg/codehaus/jackson/f/a;
        //   286: invokevirtual   org/codehaus/jackson/f/a.n:()Ljava/lang/Object;
        //   289: ifnonnull       332
        //   292: aload           5
        //   294: aload_2        
        //   295: invokevirtual   org/codehaus/jackson/c/b.j:(Lorg/codehaus/jackson/c/e/a;)Ljava/lang/Class;
        //   298: astore          11
        //   300: aload           11
        //   302: ifnull          332
        //   305: aload           11
        //   307: ldc_w           Lorg/codehaus/jackson/c/y;.class
        //   310: if_acmpeq       332
        //   313: aload_1        
        //   314: aload_2        
        //   315: aload           11
        //   317: invokevirtual   org/codehaus/jackson/c/n.a:(Lorg/codehaus/jackson/c/e/a;Ljava/lang/Class;)Lorg/codehaus/jackson/c/x;
        //   320: astore          12
        //   322: aload           7
        //   324: invokevirtual   org/codehaus/jackson/f/a.g:()Lorg/codehaus/jackson/f/a;
        //   327: aload           12
        //   329: invokevirtual   org/codehaus/jackson/f/a.j:(Ljava/lang/Object;)V
        //   332: aload           7
        //   334: areturn        
        //   335: astore          16
        //   337: new             Lorg/codehaus/jackson/c/z;
        //   340: dup            
        //   341: new             Ljava/lang/StringBuilder;
        //   344: dup            
        //   345: invokespecial   java/lang/StringBuilder.<init>:()V
        //   348: ldc_w           "Failed to narrow key type "
        //   351: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   354: aload           7
        //   356: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   359: ldc_w           " with key-type annotation ("
        //   362: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   365: aload           8
        //   367: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //   370: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   373: ldc_w           "): "
        //   376: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   379: aload           16
        //   381: invokevirtual   java/lang/IllegalArgumentException.getMessage:()Ljava/lang/String;
        //   384: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   387: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   390: aconst_null    
        //   391: aload           16
        //   393: invokespecial   org/codehaus/jackson/c/z.<init>:(Ljava/lang/String;Lorg/codehaus/jackson/h;Ljava/lang/Throwable;)V
        //   396: athrow         
        //   397: astore          13
        //   399: new             Lorg/codehaus/jackson/c/z;
        //   402: dup            
        //   403: new             Ljava/lang/StringBuilder;
        //   406: dup            
        //   407: invokespecial   java/lang/StringBuilder.<init>:()V
        //   410: ldc_w           "Failed to narrow content type "
        //   413: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   416: aload           7
        //   418: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   421: ldc_w           " with content-type annotation ("
        //   424: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   427: aload           10
        //   429: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //   432: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   435: ldc_w           "): "
        //   438: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   441: aload           13
        //   443: invokevirtual   java/lang/IllegalArgumentException.getMessage:()Ljava/lang/String;
        //   446: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   449: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   452: aconst_null    
        //   453: aload           13
        //   455: invokespecial   org/codehaus/jackson/c/z.<init>:(Ljava/lang/String;Lorg/codehaus/jackson/h;Ljava/lang/Throwable;)V
        //   458: athrow         
        //   459: aload_3        
        //   460: astore          7
        //   462: goto            34
        //    Signature:
        //  <T:Lorg/codehaus/jackson/f/a;>(Lorg/codehaus/jackson/c/n;Lorg/codehaus/jackson/c/e/a;TT;Ljava/lang/String;)TT;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  22     30     105    179    Ljava/lang/IllegalArgumentException;
        //  179    191    335    397    Ljava/lang/IllegalArgumentException;
        //  268    277    397    459    Ljava/lang/IllegalArgumentException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0281:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:314)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:235)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:120)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    protected a a(final n n, final k k, a a, final e e, final f f) {
        if (a.f()) {
            final org.codehaus.jackson.c.b a2 = n.a();
            final a i = a.k();
            if (i != null) {
                final Class<? extends af> j = a2.i(e);
                if (j != null && j != ag.class) {
                    i.j(n.b(e, j));
                }
            }
            final Class<? extends x<?>> l = a2.j(e);
            if (l != null && l != y.class) {
                a.g().j(n.a(e, l));
            }
            if (e instanceof e) {
                final az b = this.b(n, a, e, f);
                if (b != null) {
                    a = a.e(b);
                }
            }
        }
        az az;
        if (e instanceof e) {
            az = this.a(n, a, e, f);
        }
        else {
            az = this.b(n, a, null);
        }
        if (az != null) {
            a = a.f(az);
        }
        return a;
    }
    
    public abstract a a(final n p0, final a p1);
    
    public az b(final n n, final a a, final e e, final f f) {
        final org.codehaus.jackson.c.b a2 = n.a();
        final d<?> b = a2.b(n, e, a);
        final a g = a.g();
        if (b == null) {
            return this.b(n, g, f);
        }
        return b.a(n, g, n.l().a(e, n, a2), f);
    }
    
    @Override
    public az b(final n n, final a a, final f f) {
        final org.codehaus.jackson.c.e.b c = n.c(a.p()).c();
        final org.codehaus.jackson.c.b a2 = n.a();
        final d<?> a3 = a2.a(n, c, a);
        Object a4;
        Collection<org.codehaus.jackson.c.f.a> a5;
        if (a3 == null) {
            final d<?> d = n.d(a);
            if (d == null) {
                return null;
            }
            a4 = d;
            a5 = null;
        }
        else {
            a5 = n.l().a(c, n, a2);
            a4 = a3;
        }
        if (((d)a4).a() == null && a.c()) {
            final a a6 = this.a(n, a);
            if (a6 != null && a6.p() != a.p()) {
                a4 = ((d<?>)a4).a(a6.p());
            }
        }
        return ((d)a4).a(n, a, a5, f);
    }
    
    @Override
    public x<?> b(final n n, final org.codehaus.jackson.c.t t, final a a, final f f) {
        final k k = n.c(a);
        final x<Object> a2 = this.a(n, k.c(), f);
        if (a2 != null) {
            return a2;
        }
        final Class<?> p4 = a.p();
        final x<?> a3 = this.a(p4, n, k, f);
        if (a3 != null) {
            return a3;
        }
        for (final org.codehaus.jackson.c.e.f obj : k.o()) {
            if (n.a().k(obj)) {
                if (obj.f() == 1 && obj.d().isAssignableFrom(p4)) {
                    return org.codehaus.jackson.c.b.b.i.a(n, p4, obj);
                }
                throw new IllegalArgumentException("Unsuitable method (" + obj + ") decorated with @JsonCreator (for Enum type " + p4.getName() + ")");
            }
        }
        return new org.codehaus.jackson.c.b.b.i(this.a(p4, n));
    }
    
    @Override
    public x<?> c(final n n, final org.codehaus.jackson.c.t t, final a a, final f f) {
        final Class<?> p4 = a.p();
        final x<?> a2 = this.a((Class<? extends i>)p4, n, f);
        if (a2 != null) {
            return a2;
        }
        return org.codehaus.jackson.c.b.b.x.a(p4);
    }
    
    protected x<Object> d(final n n, final org.codehaus.jackson.c.t t, final a a, final f f) {
        final Class<?> p4 = a.p();
        x<?> a2 = org.codehaus.jackson.c.b.b.b.get(new org.codehaus.jackson.c.h.b(p4));
        if (a2 == null) {
            if (AtomicReference.class.isAssignableFrom(p4)) {
                final a[] b = n.m().b(a, AtomicReference.class);
                a b2;
                if (b == null || b.length < 1) {
                    b2 = org.codehaus.jackson.c.h.k.b();
                }
                else {
                    b2 = b[0];
                }
                return (x<Object>)new org.codehaus.jackson.c.b.b.b(b2, f);
            }
            a2 = this.g.a(a, n, t);
            if (a2 == null) {
                return null;
            }
        }
        return (x<Object>)a2;
    }
}
