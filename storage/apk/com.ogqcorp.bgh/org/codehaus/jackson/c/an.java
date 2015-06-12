// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c;

import java.io.IOException;
import java.io.Closeable;
import org.codehaus.jackson.c;
import java.io.EOFException;
import java.io.Writer;
import org.codehaus.jackson.b.j;
import java.io.File;
import org.codehaus.jackson.f;
import org.codehaus.jackson.c.g.g;
import org.codehaus.jackson.c.e.y;
import org.codehaus.jackson.c.e.l;
import org.codehaus.jackson.c.h.h;
import java.util.concurrent.ConcurrentHashMap;
import org.codehaus.jackson.c.h.k;
import org.codehaus.jackson.d;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.e.x;
import org.codehaus.jackson.q;

public class an extends q
{
    protected static final i<? extends e> a;
    protected static final b b;
    protected static final x<?> c;
    private static final a n;
    protected final d d;
    protected org.codehaus.jackson.c.f.b e;
    protected k f;
    protected w g;
    protected at h;
    protected ax i;
    protected av j;
    protected n k;
    protected t l;
    protected final ConcurrentHashMap<a, org.codehaus.jackson.c.x<Object>> m;
    
    static {
        n = h.d(org.codehaus.jackson.i.class);
        a = l.i;
        b = new org.codehaus.jackson.c.e.q();
        c = y.a();
    }
    
    public an() {
        this(null, null, null);
    }
    
    public an(final d d) {
        this(d, null, null);
    }
    
    public an(final d d, final ax ax, final t t) {
        this(d, ax, t, null, null);
    }
    
    public an(final d d, ax i, t l, at h, n k) {
        this.m = new ConcurrentHashMap<a, org.codehaus.jackson.c.x<Object>>(64, 0.6f, 2);
        if (d == null) {
            this.d = new am(this);
        }
        else {
            this.d = d;
            if (d.a() == null) {
                this.d.a(this);
            }
        }
        this.f = org.codehaus.jackson.c.h.k.a();
        if (h == null) {
            h = new at(an.a, an.b, an.c, null, null, this.f, null);
        }
        this.h = h;
        if (k == null) {
            k = new n(an.a, an.b, an.c, null, null, this.f, null);
        }
        this.k = k;
        if (i == null) {
            i = new org.codehaus.jackson.c.g.t();
        }
        this.i = i;
        if (l == null) {
            l = new org.codehaus.jackson.c.b.q();
        }
        this.l = l;
        this.j = org.codehaus.jackson.c.g.g.e;
    }
    
    private final void a(final f p0, final Object p1, final at p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_2        
        //     1: checkcast       Ljava/io/Closeable;
        //     4: astore          4
        //     6: aload_0        
        //     7: getfield        org/codehaus/jackson/c/an.i:Lorg/codehaus/jackson/c/ax;
        //    10: aload_3        
        //    11: aload_1        
        //    12: aload_2        
        //    13: aload_0        
        //    14: getfield        org/codehaus/jackson/c/an.j:Lorg/codehaus/jackson/c/av;
        //    17: invokevirtual   org/codehaus/jackson/c/ax.a:(Lorg/codehaus/jackson/c/at;Lorg/codehaus/jackson/f;Ljava/lang/Object;Lorg/codehaus/jackson/c/av;)V
        //    20: aload_1        
        //    21: invokevirtual   org/codehaus/jackson/f.close:()V
        //    24: aload           4
        //    26: invokeinterface java/io/Closeable.close:()V
        //    31: iconst_0       
        //    32: ifeq            39
        //    35: aconst_null    
        //    36: invokevirtual   org/codehaus/jackson/f.close:()V
        //    39: iconst_0       
        //    40: ifeq            49
        //    43: aconst_null    
        //    44: invokeinterface java/io/Closeable.close:()V
        //    49: return         
        //    50: astore          5
        //    52: aload           4
        //    54: astore          6
        //    56: aload           5
        //    58: astore          7
        //    60: aload_1        
        //    61: ifnull          68
        //    64: aload_1        
        //    65: invokevirtual   org/codehaus/jackson/f.close:()V
        //    68: aload           6
        //    70: ifnull          80
        //    73: aload           6
        //    75: invokeinterface java/io/Closeable.close:()V
        //    80: aload           7
        //    82: athrow         
        //    83: astore          12
        //    85: goto            39
        //    88: astore          11
        //    90: return         
        //    91: astore          9
        //    93: goto            68
        //    96: astore          8
        //    98: goto            80
        //   101: astore          10
        //   103: aload           10
        //   105: astore          7
        //   107: aload           4
        //   109: astore          6
        //   111: aconst_null    
        //   112: astore_1       
        //   113: goto            60
        //   116: astore          7
        //   118: aconst_null    
        //   119: astore          6
        //   121: aconst_null    
        //   122: astore_1       
        //   123: goto            60
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  6      20     50     60     Any
        //  20     24     101    116    Any
        //  24     31     116    126    Any
        //  35     39     83     88     Ljava/io/IOException;
        //  43     49     88     91     Ljava/io/IOException;
        //  64     68     91     96     Ljava/io/IOException;
        //  73     80     96     101    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 61, Size: 61
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:635)
        //     at java.util.ArrayList.get(ArrayList.java:411)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3305)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3419)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:114)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:210)
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
    
    private final void b(final f p0, final Object p1, final at p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_2        
        //     1: checkcast       Ljava/io/Closeable;
        //     4: astore          4
        //     6: aload_0        
        //     7: getfield        org/codehaus/jackson/c/an.i:Lorg/codehaus/jackson/c/ax;
        //    10: aload_3        
        //    11: aload_1        
        //    12: aload_2        
        //    13: aload_0        
        //    14: getfield        org/codehaus/jackson/c/an.j:Lorg/codehaus/jackson/c/av;
        //    17: invokevirtual   org/codehaus/jackson/c/ax.a:(Lorg/codehaus/jackson/c/at;Lorg/codehaus/jackson/f;Ljava/lang/Object;Lorg/codehaus/jackson/c/av;)V
        //    20: aload_3        
        //    21: getstatic       org/codehaus/jackson/c/au.p:Lorg/codehaus/jackson/c/au;
        //    24: invokevirtual   org/codehaus/jackson/c/at.a:(Lorg/codehaus/jackson/c/au;)Z
        //    27: ifeq            34
        //    30: aload_1        
        //    31: invokevirtual   org/codehaus/jackson/f.g:()V
        //    34: aload           4
        //    36: invokeinterface java/io/Closeable.close:()V
        //    41: iconst_0       
        //    42: ifeq            51
        //    45: aconst_null    
        //    46: invokeinterface java/io/Closeable.close:()V
        //    51: return         
        //    52: astore          5
        //    54: aload           4
        //    56: astore          6
        //    58: aload           5
        //    60: astore          7
        //    62: aload           6
        //    64: ifnull          74
        //    67: aload           6
        //    69: invokeinterface java/io/Closeable.close:()V
        //    74: aload           7
        //    76: athrow         
        //    77: astore          9
        //    79: return         
        //    80: astore          8
        //    82: goto            74
        //    85: astore          7
        //    87: aconst_null    
        //    88: astore          6
        //    90: goto            62
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  6      34     52     62     Any
        //  34     41     85     93     Any
        //  45     51     77     80     Ljava/io/IOException;
        //  67     74     80     85     Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0034:
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
    
    public <T> T a(final File file, final org.codehaus.jackson.f.b b) {
        return (T)this.a(this.d.a(file), this.f.a(b));
    }
    
    public <T> T a(final String s, final org.codehaus.jackson.f.b b) {
        return (T)this.a(this.d.a(s), this.f.a(b));
    }
    
    protected Object a(final org.codehaus.jackson.k p0, final a p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: aload_1        
        //     2: invokevirtual   org/codehaus/jackson/c/an.a:(Lorg/codehaus/jackson/k;)Lorg/codehaus/jackson/p;
        //     5: astore          5
        //     7: aload           5
        //     9: getstatic       org/codehaus/jackson/p.m:Lorg/codehaus/jackson/p;
        //    12: if_acmpne       40
        //    15: aload_0        
        //    16: aload_0        
        //    17: getfield        org/codehaus/jackson/c/an.k:Lorg/codehaus/jackson/c/n;
        //    20: aload_2        
        //    21: invokevirtual   org/codehaus/jackson/c/an.a:(Lorg/codehaus/jackson/c/n;Lorg/codehaus/jackson/f/a;)Lorg/codehaus/jackson/c/x;
        //    24: invokevirtual   org/codehaus/jackson/c/x.b:()Ljava/lang/Object;
        //    27: astore          6
        //    29: aload_1        
        //    30: invokevirtual   org/codehaus/jackson/k.f:()V
        //    33: aload_1        
        //    34: invokevirtual   org/codehaus/jackson/k.close:()V
        //    37: aload           6
        //    39: areturn        
        //    40: aload           5
        //    42: getstatic       org/codehaus/jackson/p.e:Lorg/codehaus/jackson/p;
        //    45: if_acmpeq       143
        //    48: aload           5
        //    50: getstatic       org/codehaus/jackson/p.c:Lorg/codehaus/jackson/p;
        //    53: if_acmpne       59
        //    56: goto            143
        //    59: aload_0        
        //    60: invokevirtual   org/codehaus/jackson/c/an.b:()Lorg/codehaus/jackson/c/n;
        //    63: astore          8
        //    65: aload_0        
        //    66: aload_1        
        //    67: aload           8
        //    69: invokevirtual   org/codehaus/jackson/c/an.a:(Lorg/codehaus/jackson/k;Lorg/codehaus/jackson/c/n;)Lorg/codehaus/jackson/c/p;
        //    72: astore          9
        //    74: aload_0        
        //    75: aload           8
        //    77: aload_2        
        //    78: invokevirtual   org/codehaus/jackson/c/an.a:(Lorg/codehaus/jackson/c/n;Lorg/codehaus/jackson/f/a;)Lorg/codehaus/jackson/c/x;
        //    81: astore          10
        //    83: aload           8
        //    85: getstatic       org/codehaus/jackson/c/o.p:Lorg/codehaus/jackson/c/o;
        //    88: invokevirtual   org/codehaus/jackson/c/n.a:(Lorg/codehaus/jackson/c/o;)Z
        //    91: ifeq            109
        //    94: aload_0        
        //    95: aload_1        
        //    96: aload_2        
        //    97: aload           9
        //    99: aload           10
        //   101: invokevirtual   org/codehaus/jackson/c/an.a:(Lorg/codehaus/jackson/k;Lorg/codehaus/jackson/f/a;Lorg/codehaus/jackson/c/p;Lorg/codehaus/jackson/c/x;)Ljava/lang/Object;
        //   104: astore          6
        //   106: goto            29
        //   109: aload           10
        //   111: aload_1        
        //   112: aload           9
        //   114: invokevirtual   org/codehaus/jackson/c/x.a:(Lorg/codehaus/jackson/k;Lorg/codehaus/jackson/c/p;)Ljava/lang/Object;
        //   117: astore          11
        //   119: aload           11
        //   121: astore          6
        //   123: goto            29
        //   126: astore_3       
        //   127: aload_1        
        //   128: invokevirtual   org/codehaus/jackson/k.close:()V
        //   131: aload_3        
        //   132: athrow         
        //   133: astore          7
        //   135: aload           6
        //   137: areturn        
        //   138: astore          4
        //   140: goto            131
        //   143: aconst_null    
        //   144: astore          6
        //   146: goto            29
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      29     126    133    Any
        //  29     33     126    133    Any
        //  33     37     133    138    Ljava/io/IOException;
        //  40     56     126    133    Any
        //  59     106    126    133    Any
        //  109    119    126    133    Any
        //  127    131    138    143    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 73, Size: 73
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:635)
        //     at java.util.ArrayList.get(ArrayList.java:411)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3305)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:114)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:210)
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
    
    protected Object a(final org.codehaus.jackson.k k, final a obj, final p p4, final org.codehaus.jackson.c.x<Object> x) {
        final org.codehaus.jackson.b.k a = this.l.a(p4.a(), obj);
        if (k.e() != org.codehaus.jackson.p.b) {
            throw z.a(k, "Current token not START_OBJECT (needed to unwrap root name '" + a + "'), but " + k.e());
        }
        if (k.b() != org.codehaus.jackson.p.f) {
            throw z.a(k, "Current token not FIELD_NAME (to contain expected root name '" + a + "'), but " + k.e());
        }
        final String g = k.g();
        if (!a.a().equals(g)) {
            throw z.a(k, "Root name '" + g + "' does not match expected ('" + a + "') for type " + obj);
        }
        k.b();
        final Object a2 = x.a(k, p4);
        if (k.b() != org.codehaus.jackson.p.c) {
            throw z.a(k, "Current token not END_OBJECT (to match wrapper object with root name '" + a + "'), but " + k.e());
        }
        return a2;
    }
    
    public <T> T a(final byte[] array, final a a) {
        return (T)this.a(this.d.a(array), a);
    }
    
    public String a(final Object o) {
        final j j = new j(this.d.b());
        this.b(this.d.a(j), o);
        return j.a();
    }
    
    public an a(final o o, final boolean b) {
        this.k.a(o, b);
        return this;
    }
    
    public at a() {
        return this.h.a(this.e);
    }
    
    protected p a(final org.codehaus.jackson.k k, final n n) {
        return new org.codehaus.jackson.c.b.p(n, k, this.l, this.g);
    }
    
    protected org.codehaus.jackson.c.x<Object> a(final n n, final a key) {
        final org.codehaus.jackson.c.x<Object> x = this.m.get(key);
        if (x != null) {
            return x;
        }
        final org.codehaus.jackson.c.x<Object> b = this.l.b(n, key, null);
        if (b == null) {
            throw new z("Can not find a deserializer for type " + key);
        }
        this.m.put(key, b);
        return b;
    }
    
    protected org.codehaus.jackson.p a(final org.codehaus.jackson.k k) {
        org.codehaus.jackson.p p = k.e();
        if (p == null) {
            p = k.b();
            if (p == null) {
                throw new EOFException("No content to map to Object due to end of input");
            }
        }
        return p;
    }
    
    public void a(final File file, final Object o) {
        this.b(this.d.a(file, org.codehaus.jackson.c.a), o);
    }
    
    @Override
    public void a(final f f, final Object o) {
        final at a = this.a();
        if (a.a(au.o) && o instanceof Closeable) {
            this.b(f, o, a);
        }
        else {
            this.i.a(a, f, o, this.j);
            if (a.a(au.p)) {
                f.g();
            }
        }
    }
    
    public n b() {
        return this.k.a(this.e).a(this.h.i);
    }
    
    protected final void b(final f f, final Object o) {
        final at a = this.a();
        if (a.a(au.k)) {
            f.a();
        }
        if (a.a(au.o) && o instanceof Closeable) {
            this.a(f, o, a);
            return;
        }
        boolean b = false;
        try {
            this.i.a(a, f, o, this.j);
            b = true;
            f.close();
        }
        finally {
            Label_0081: {
                if (b) {
                    break Label_0081;
                }
                try {
                    f.close();
                }
                catch (IOException ex) {}
            }
        }
    }
}
