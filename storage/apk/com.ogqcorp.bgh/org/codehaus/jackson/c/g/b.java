// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.g;

import java.util.Collection;
import java.lang.reflect.Method;
import org.codehaus.jackson.c.g.b.h;
import java.nio.charset.Charset;
import org.codehaus.jackson.c.g.b.az;
import java.util.TimeZone;
import java.net.InetAddress;
import java.lang.reflect.Member;
import org.codehaus.jackson.c.i.l;
import org.codehaus.jackson.c.g.b.u;
import org.codehaus.jackson.c.g.b.t;
import org.codehaus.jackson.c.i.p;
import org.codehaus.jackson.c.au;
import org.codehaus.jackson.c.a.i;
import java.util.RandomAccess;
import org.codehaus.jackson.c.g.b.n;
import java.util.EnumMap;
import org.codehaus.jackson.c.h.g;
import org.codehaus.jackson.c.g.b.ax;
import org.codehaus.jackson.c.g.b.ai;
import org.codehaus.jackson.c.g.b.j;
import java.util.EnumSet;
import org.codehaus.jackson.c.h.d;
import org.codehaus.jackson.c.e;
import org.codehaus.jackson.c.g.b.q;
import org.codehaus.jackson.c.g.b.ah;
import org.codehaus.jackson.c.e.k;
import org.codehaus.jackson.c.b;
import org.codehaus.jackson.c.at;
import java.util.Iterator;
import org.codehaus.jackson.c.g.b.af;
import org.codehaus.jackson.c.g.b.ag;
import org.codehaus.jackson.c.g.b.bb;
import org.codehaus.jackson.g.m;
import java.util.Map;
import org.codehaus.jackson.c.g.b.al;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import org.codehaus.jackson.c.g.b.f;
import org.codehaus.jackson.c.g.b.c;
import java.util.Calendar;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.c.g.b.ba;
import org.codehaus.jackson.c.g.b.ay;
import org.codehaus.jackson.c.d.a;
import org.codehaus.jackson.c.ad;
import java.util.HashMap;
import org.codehaus.jackson.c.av;

public abstract class b extends av
{
    protected static final HashMap<String, ad<?>> a;
    protected static final HashMap<String, Class<? extends ad<?>>> b;
    protected static final HashMap<String, ad<?>> c;
    protected a d;
    
    static {
        a = new HashMap<String, ad<?>>();
        b = new HashMap<String, Class<? extends ad<?>>>();
        org.codehaus.jackson.c.g.b.a.put(String.class.getName(), new ay());
        final ba a2 = ba.a;
        org.codehaus.jackson.c.g.b.a.put(StringBuffer.class.getName(), a2);
        org.codehaus.jackson.c.g.b.a.put(StringBuilder.class.getName(), a2);
        org.codehaus.jackson.c.g.b.a.put(Character.class.getName(), a2);
        org.codehaus.jackson.c.g.b.a.put(Character.TYPE.getName(), a2);
        org.codehaus.jackson.c.g.b.a.put(Boolean.TYPE.getName(), new w(true));
        org.codehaus.jackson.c.g.b.a.put(Boolean.class.getName(), new w(false));
        final aa aa = new aa();
        org.codehaus.jackson.c.g.b.a.put(Integer.class.getName(), aa);
        org.codehaus.jackson.c.g.b.a.put(Integer.TYPE.getName(), aa);
        org.codehaus.jackson.c.g.b.a.put(Long.class.getName(), ab.a);
        org.codehaus.jackson.c.g.b.a.put(Long.TYPE.getName(), ab.a);
        org.codehaus.jackson.c.g.b.a.put(Byte.class.getName(), z.a);
        org.codehaus.jackson.c.g.b.a.put(Byte.TYPE.getName(), z.a);
        org.codehaus.jackson.c.g.b.a.put(Short.class.getName(), z.a);
        org.codehaus.jackson.c.g.b.a.put(Short.TYPE.getName(), z.a);
        org.codehaus.jackson.c.g.b.a.put(Float.class.getName(), y.a);
        org.codehaus.jackson.c.g.b.a.put(Float.TYPE.getName(), y.a);
        org.codehaus.jackson.c.g.b.a.put(Double.class.getName(), x.a);
        org.codehaus.jackson.c.g.b.a.put(Double.TYPE.getName(), x.a);
        final ac ac = new ac();
        org.codehaus.jackson.c.g.b.a.put(BigInteger.class.getName(), ac);
        org.codehaus.jackson.c.g.b.a.put(BigDecimal.class.getName(), ac);
        org.codehaus.jackson.c.g.b.a.put(Calendar.class.getName(), org.codehaus.jackson.c.g.b.c.a);
        final f a3 = f.a;
        org.codehaus.jackson.c.g.b.a.put(Date.class.getName(), a3);
        org.codehaus.jackson.c.g.b.a.put(Timestamp.class.getName(), a3);
        org.codehaus.jackson.c.g.b.a.put(java.sql.Date.class.getName(), new org.codehaus.jackson.c.g.ad());
        org.codehaus.jackson.c.g.b.a.put(Time.class.getName(), new ae());
        for (final Map.Entry<Class<?>, Object> entry : new al().a()) {
            final Class<? extends ad<?>> value = entry.getValue();
            if (value instanceof ad) {
                org.codehaus.jackson.c.g.b.a.put(entry.getKey().getName(), (ad<?>)value);
            }
            else {
                if (!(value instanceof Class)) {
                    throw new IllegalStateException("Internal error: unrecognized value of type " + entry.getClass().getName());
                }
                org.codehaus.jackson.c.g.b.b.put(entry.getKey().getName(), value);
            }
        }
        org.codehaus.jackson.c.g.b.b.put(m.class.getName(), bb.class);
        (c = new HashMap<String, ad<?>>()).put(boolean[].class.getName(), new org.codehaus.jackson.c.g.b.z());
        org.codehaus.jackson.c.g.b.c.put(byte[].class.getName(), new org.codehaus.jackson.c.g.b.aa());
        org.codehaus.jackson.c.g.b.c.put(char[].class.getName(), new org.codehaus.jackson.c.g.b.ab());
        org.codehaus.jackson.c.g.b.c.put(short[].class.getName(), new ag());
        org.codehaus.jackson.c.g.b.c.put(int[].class.getName(), new org.codehaus.jackson.c.g.b.ae());
        org.codehaus.jackson.c.g.b.c.put(long[].class.getName(), new af());
        org.codehaus.jackson.c.g.b.c.put(float[].class.getName(), new org.codehaus.jackson.c.g.b.ad());
        org.codehaus.jackson.c.g.b.c.put(double[].class.getName(), new org.codehaus.jackson.c.g.b.ac());
    }
    
    protected b() {
        this.d = org.codehaus.jackson.c.d.a.a;
    }
    
    protected static ad<Object> b(final at at, final org.codehaus.jackson.c.e.a a, final org.codehaus.jackson.c.f f) {
        final org.codehaus.jackson.c.b a2 = at.a();
        Class<? extends ad<?>> clazz = a2.c(a);
        if ((clazz == null || clazz == org.codehaus.jackson.c.ae.class) && f != null) {
            clazz = a2.c((org.codehaus.jackson.c.e.a)f.b());
        }
        if (clazz != null && clazz != org.codehaus.jackson.c.ae.class) {
            return at.a(a, clazz);
        }
        return null;
    }
    
    protected static <T extends org.codehaus.jackson.f.a> T b(final at p0, final org.codehaus.jackson.c.e.a p1, final T p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: invokevirtual   org/codehaus/jackson/c/at.a:()Lorg/codehaus/jackson/c/b;
        //     4: astore_3       
        //     5: aload_2        
        //     6: invokevirtual   org/codehaus/jackson/f/a.f:()Z
        //     9: ifeq            110
        //    12: aload_3        
        //    13: aload_1        
        //    14: aload_2        
        //    15: invokevirtual   org/codehaus/jackson/f/a.k:()Lorg/codehaus/jackson/f/a;
        //    18: invokevirtual   org/codehaus/jackson/c/b.a:(Lorg/codehaus/jackson/c/e/a;Lorg/codehaus/jackson/f/a;)Ljava/lang/Class;
        //    21: astore          4
        //    23: aload           4
        //    25: ifnull          83
        //    28: aload_2        
        //    29: instanceof      Lorg/codehaus/jackson/c/h/g;
        //    32: ifne            69
        //    35: new             Ljava/lang/IllegalArgumentException;
        //    38: dup            
        //    39: new             Ljava/lang/StringBuilder;
        //    42: dup            
        //    43: invokespecial   java/lang/StringBuilder.<init>:()V
        //    46: ldc_w           "Illegal key-type annotation: type "
        //    49: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    52: aload_2        
        //    53: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    56: ldc_w           " is not a Map type"
        //    59: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    62: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    65: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //    68: athrow         
        //    69: aload_2        
        //    70: checkcast       Lorg/codehaus/jackson/c/h/g;
        //    73: aload           4
        //    75: invokevirtual   org/codehaus/jackson/c/h/g.e:(Ljava/lang/Class;)Lorg/codehaus/jackson/f/a;
        //    78: astore          9
        //    80: aload           9
        //    82: astore_2       
        //    83: aload_3        
        //    84: aload_1        
        //    85: aload_2        
        //    86: invokevirtual   org/codehaus/jackson/f/a.g:()Lorg/codehaus/jackson/f/a;
        //    89: invokevirtual   org/codehaus/jackson/c/b.b:(Lorg/codehaus/jackson/c/e/a;Lorg/codehaus/jackson/f/a;)Ljava/lang/Class;
        //    92: astore          5
        //    94: aload           5
        //    96: ifnull          110
        //    99: aload_2        
        //   100: aload           5
        //   102: invokevirtual   org/codehaus/jackson/f/a.c:(Ljava/lang/Class;)Lorg/codehaus/jackson/f/a;
        //   105: astore          7
        //   107: aload           7
        //   109: astore_2       
        //   110: aload_2        
        //   111: areturn        
        //   112: astore          8
        //   114: new             Ljava/lang/IllegalArgumentException;
        //   117: dup            
        //   118: new             Ljava/lang/StringBuilder;
        //   121: dup            
        //   122: invokespecial   java/lang/StringBuilder.<init>:()V
        //   125: ldc_w           "Failed to narrow key type "
        //   128: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   131: aload_2        
        //   132: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   135: ldc_w           " with key-type annotation ("
        //   138: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   141: aload           4
        //   143: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //   146: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   149: ldc_w           "): "
        //   152: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   155: aload           8
        //   157: invokevirtual   java/lang/IllegalArgumentException.getMessage:()Ljava/lang/String;
        //   160: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   163: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   166: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //   169: athrow         
        //   170: astore          6
        //   172: new             Ljava/lang/IllegalArgumentException;
        //   175: dup            
        //   176: new             Ljava/lang/StringBuilder;
        //   179: dup            
        //   180: invokespecial   java/lang/StringBuilder.<init>:()V
        //   183: ldc_w           "Failed to narrow content type "
        //   186: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   189: aload_2        
        //   190: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   193: ldc_w           " with content-type annotation ("
        //   196: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   199: aload           5
        //   201: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //   204: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   207: ldc_w           "): "
        //   210: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   213: aload           6
        //   215: invokevirtual   java/lang/IllegalArgumentException.getMessage:()Ljava/lang/String;
        //   218: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   221: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   224: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //   227: athrow         
        //    Signature:
        //  <T:Lorg/codehaus/jackson/f/a;>(Lorg/codehaus/jackson/c/at;Lorg/codehaus/jackson/c/e/a;TT;)TT;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  69     80     112    170    Ljava/lang/IllegalArgumentException;
        //  99     107    170    228    Ljava/lang/IllegalArgumentException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0110:
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
    
    protected static ad<Object> c(final at at, final org.codehaus.jackson.c.e.a a, final org.codehaus.jackson.c.f f) {
        final org.codehaus.jackson.c.b a2 = at.a();
        Class<? extends ad<?>> clazz = a2.d(a);
        if ((clazz == null || clazz == org.codehaus.jackson.c.ae.class) && f != null) {
            clazz = a2.d((org.codehaus.jackson.c.e.a)f.b());
        }
        if (clazz != null && clazz != org.codehaus.jackson.c.ae.class) {
            return at.a(a, clazz);
        }
        return null;
    }
    
    protected abstract Iterable<org.codehaus.jackson.c.ay> a();
    
    protected ad<Object> a(final at at, final org.codehaus.jackson.c.e.a a, final org.codehaus.jackson.c.f f) {
        final Object b = at.a().b(a);
        Object a2;
        if (b == null) {
            a2 = null;
        }
        else if (b instanceof ad) {
            a2 = b;
            if (a2 instanceof org.codehaus.jackson.c.m) {
                return ((org.codehaus.jackson.c.m<Object>)a2).a(at, f);
            }
        }
        else {
            if (!(b instanceof Class)) {
                throw new IllegalStateException("AnnotationIntrospector returned value of type " + ((Class<? extends ad<?>>)b).getClass().getName() + "; expected type JsonSerializer or Class<JsonSerializer> instead");
            }
            final Class<? extends ad<?>> clazz = (Class<? extends ad<?>>)b;
            if (!ad.class.isAssignableFrom(clazz)) {
                throw new IllegalStateException("AnnotationIntrospector returned Class " + clazz.getName() + "; expected Class<JsonSerializer>");
            }
            a2 = at.a(a, clazz);
            if (a2 instanceof org.codehaus.jackson.c.m) {
                return ((org.codehaus.jackson.c.m<Object>)a2).a(at, f);
            }
        }
        return (ad<Object>)a2;
    }
    
    protected ad<?> a(final at at, final org.codehaus.jackson.c.h.a a, final k k, final org.codehaus.jackson.c.f f, final boolean b, final org.codehaus.jackson.c.ba ba, final ad<Object> ad) {
        final Class<?> p7 = a.p();
        ad<?> ad2;
        if (String[].class == p7) {
            ad2 = new ah(f);
        }
        else {
            ad2 = b.c.get(p7.getName());
            if (ad2 == null) {
                return new q(a.g(), b, ba, f, ad);
            }
        }
        return ad2;
    }
    
    protected ad<?> a(final at at, final org.codehaus.jackson.c.h.c c, final k k, final org.codehaus.jackson.c.f f, final boolean b, final org.codehaus.jackson.c.ba ba, final ad<Object> ad) {
        final Iterator<org.codehaus.jackson.c.ay> iterator = this.a().iterator();
        while (iterator.hasNext()) {
            final ad<?> a = iterator.next().a(at, c, k, f, ba, ad);
            if (a != null) {
                return a;
            }
        }
        return null;
    }
    
    protected ad<?> a(final at at, final d d, final k k, final org.codehaus.jackson.c.f f, final boolean b, final org.codehaus.jackson.c.ba ba, final ad<Object> ad) {
        final Iterator<org.codehaus.jackson.c.ay> iterator = this.a().iterator();
        while (iterator.hasNext()) {
            final ad<?> a = iterator.next().a(at, d, k, f, ba, ad);
            if (a != null) {
                return a;
            }
        }
        final Class<?> p7 = d.p();
        if (EnumSet.class.isAssignableFrom(p7)) {
            return this.a(at, (org.codehaus.jackson.f.a)d, k, f, b, ba, ad);
        }
        final Class<?> p8 = d.g().p();
        if (this.a(p7)) {
            if (p8 == String.class) {
                return new j(f, ad);
            }
            return ai.a(d.g(), b, ba, f, ad);
        }
        else {
            if (p8 == String.class) {
                return new ax(f, ad);
            }
            return ai.b(d.g(), b, ba, f, ad);
        }
    }
    
    protected ad<?> a(final at at, final org.codehaus.jackson.c.h.f f, final k k, final org.codehaus.jackson.c.f f2, final boolean b, final ad<Object> ad, final org.codehaus.jackson.c.ba ba, final ad<Object> ad2) {
        final Iterator<org.codehaus.jackson.c.ay> iterator = this.a().iterator();
        while (iterator.hasNext()) {
            final ad<?> a = iterator.next().a(at, f, k, f2, ad, ba, ad2);
            if (a != null) {
                return a;
            }
        }
        return null;
    }
    
    protected ad<?> a(final at at, final g g, final k k, final org.codehaus.jackson.c.f f, final boolean b, final ad<Object> ad, final org.codehaus.jackson.c.ba ba, final ad<Object> ad2) {
        final Iterator<org.codehaus.jackson.c.ay> iterator = this.a().iterator();
        while (iterator.hasNext()) {
            final ad<?> a = iterator.next().a(at, g, k, f, ad, ba, ad2);
            if (a != null) {
                return a;
            }
        }
        if (EnumMap.class.isAssignableFrom(g.p())) {
            return this.b(at, g, k, f, b, ba, ad2);
        }
        return n.a(at.a().c(k.c()), g, b, ba, f, ad, ad2);
    }
    
    public final ad<?> a(final at at, final org.codehaus.jackson.f.a a, final k k, final org.codehaus.jackson.c.f f, final boolean b) {
        final Class<?> p5 = a.p();
        if (Iterator.class.isAssignableFrom(p5)) {
            return this.c(at, a, k, f, b);
        }
        if (Iterable.class.isAssignableFrom(p5)) {
            return this.d(at, a, k, f, b);
        }
        if (CharSequence.class.isAssignableFrom(p5)) {
            return ba.a;
        }
        return null;
    }
    
    protected ad<?> a(final at at, final org.codehaus.jackson.f.a a, final k k, final org.codehaus.jackson.c.f f, final boolean b, final org.codehaus.jackson.c.ba ba, final ad<Object> ad) {
        org.codehaus.jackson.f.a g = a.g();
        if (!g.r()) {
            g = null;
        }
        return ai.a(g, f);
    }
    
    public final ad<?> a(final org.codehaus.jackson.f.a a, final at at, final k k, final org.codehaus.jackson.c.f f, final boolean b) {
        final String name = a.p().getName();
        final ad<?> ad = b.a.get(name);
        if (ad != null) {
            return ad;
        }
        final Class<? extends ad<?>> clazz = b.b.get(name);
        if (clazz != null) {
            try {
                return (ad<?>)clazz.newInstance();
            }
            catch (Exception cause) {
                throw new IllegalStateException("Failed to instantiate standard serializer (of type " + clazz.getName() + "): " + cause.getMessage(), cause);
            }
        }
        return null;
    }
    
    protected <T extends org.codehaus.jackson.f.a> T a(final at at, final org.codehaus.jackson.c.e.a a, T h) {
        final Class<?> e = at.a().e(a);
        Label_0026: {
            if (e == null) {
                break Label_0026;
            }
            try {
                h = (T)h.h(e);
                return (T)b(at, a, (org.codehaus.jackson.f.a)h);
            }
            catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("Failed to widen type " + h + " with concrete-type annotation (value " + e.getName() + "), method '" + a.b() + "': " + ex.getMessage());
            }
        }
    }
    
    protected boolean a(final Class<?> clazz) {
        return RandomAccess.class.isAssignableFrom(clazz);
    }
    
    protected boolean a(final at at, final k k, final org.codehaus.jackson.c.ba ba, final org.codehaus.jackson.c.f f) {
        if (ba == null) {
            final org.codehaus.jackson.c.b a = at.a();
            final i f2 = a.f((org.codehaus.jackson.c.e.a)k.c());
            if (f2 != null) {
                if (f2 == i.b) {
                    return true;
                }
            }
            else if (at.a(au.h)) {
                return true;
            }
            if (f != null) {
                final org.codehaus.jackson.f.a a2 = f.a();
                if (a2.f()) {
                    if (a.b(f.b(), f.a()) != null) {
                        return true;
                    }
                    if (a2 instanceof g && a.a(f.b(), f.a()) != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public ad<?> b(final at at, final org.codehaus.jackson.f.a a, final k k, final org.codehaus.jackson.c.f f, final boolean b) {
        final org.codehaus.jackson.c.ba b2 = this.b(at, a.g(), f);
        boolean a2;
        if (b2 != null) {
            a2 = false;
        }
        else if (!b) {
            a2 = this.a(at, k, b2, f);
        }
        else {
            a2 = b;
        }
        final ad<Object> c = c(at, k.c(), f);
        if (a.j()) {
            final org.codehaus.jackson.c.h.f f2 = (org.codehaus.jackson.c.h.f)a;
            final ad<Object> b3 = b(at, (org.codehaus.jackson.c.e.a)k.c(), f);
            if (f2.l()) {
                return this.a(at, (g)f2, k, f, a2, b3, b2, c);
            }
            return this.a(at, f2, k, f, a2, b3, b2, c);
        }
        else if (a.i()) {
            final org.codehaus.jackson.c.h.c c2 = (org.codehaus.jackson.c.h.c)a;
            if (c2.b_()) {
                return this.a(at, (d)c2, k, f, a2, b2, c);
            }
            return this.a(at, c2, k, f, a2, b2, c);
        }
        else {
            if (a.b()) {
                return this.a(at, (org.codehaus.jackson.c.h.a)a, k, f, a2, b2, c);
            }
            return null;
        }
    }
    
    protected ad<?> b(final at at, final org.codehaus.jackson.f.a a, final k k, final org.codehaus.jackson.c.f f, final boolean b, final org.codehaus.jackson.c.ba ba, final ad<Object> ad) {
        final org.codehaus.jackson.f.a i = a.k();
        final boolean r = i.r();
        p a2 = null;
        if (r) {
            a2 = p.a((Class<Enum<?>>)i.p(), at.a());
        }
        return new org.codehaus.jackson.c.g.b.g(a.g(), b, a2, ba, f, ad);
    }
    
    public final ad<?> b(final org.codehaus.jackson.f.a a, final at at, final k k, final org.codehaus.jackson.c.f f, final boolean b) {
        final Class<?> p5 = a.p();
        ad<?> ad;
        if (org.codehaus.jackson.c.ab.class.isAssignableFrom(p5)) {
            if (!org.codehaus.jackson.c.ac.class.isAssignableFrom(p5)) {
                return t.a;
            }
            ad = u.a;
        }
        else {
            final org.codehaus.jackson.c.e.f e = k.e();
            if (e != null) {
                final Method e2 = e.e();
                if (at.a(au.e)) {
                    l.a((Member)e2);
                }
                return new org.codehaus.jackson.c.g.b.m(e2, this.a(at, (org.codehaus.jackson.c.e.a)e, f), f);
            }
            if (InetAddress.class.isAssignableFrom(p5)) {
                return org.codehaus.jackson.c.g.b.k.a;
            }
            if (TimeZone.class.isAssignableFrom(p5)) {
                return az.a;
            }
            if (Charset.class.isAssignableFrom(p5)) {
                return ba.a;
            }
            ad = this.d.a(at, a);
            if (ad == null) {
                if (Number.class.isAssignableFrom(p5)) {
                    return ac.a;
                }
                if (Enum.class.isAssignableFrom(p5)) {
                    return h.a((Class<Enum<?>>)p5, at, k);
                }
                if (Calendar.class.isAssignableFrom(p5)) {
                    return org.codehaus.jackson.c.g.b.c.a;
                }
                if (Date.class.isAssignableFrom(p5)) {
                    return f.a;
                }
                return null;
            }
        }
        return ad;
    }
    
    @Override
    public org.codehaus.jackson.c.ba b(final at at, final org.codehaus.jackson.f.a a, final org.codehaus.jackson.c.f f) {
        final org.codehaus.jackson.c.e.b c = at.c(a.p()).c();
        final org.codehaus.jackson.c.b a2 = at.a();
        org.codehaus.jackson.c.f.d<?> d = a2.a(at, c, a);
        Collection<org.codehaus.jackson.c.f.a> a3;
        if (d == null) {
            d = at.d(a);
            a3 = null;
        }
        else {
            a3 = at.l().a(c, at, a2);
        }
        if (d == null) {
            return null;
        }
        return d.a(at, a, a3, f);
    }
    
    protected ad<?> c(final at at, final org.codehaus.jackson.f.a a, final k k, final org.codehaus.jackson.c.f f, final boolean b) {
        org.codehaus.jackson.f.a a2 = a.b(0);
        if (a2 == null) {
            a2 = org.codehaus.jackson.c.h.k.b();
        }
        final org.codehaus.jackson.c.ba b2 = this.b(at, a2, f);
        return ai.a(a2, this.a(at, k, b2, f), b2, f);
    }
    
    protected ad<?> d(final at at, final org.codehaus.jackson.f.a a, final k k, final org.codehaus.jackson.c.f f, final boolean b) {
        org.codehaus.jackson.f.a a2 = a.b(0);
        if (a2 == null) {
            a2 = org.codehaus.jackson.c.h.k.b();
        }
        final org.codehaus.jackson.c.ba b2 = this.b(at, a2, f);
        return ai.b(a2, this.a(at, k, b2, f), b2, f);
    }
}
