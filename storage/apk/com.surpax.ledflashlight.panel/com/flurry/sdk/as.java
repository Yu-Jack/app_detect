// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.io.OutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.List;

public abstract class as
{
    private static final String a;
    private as$a b;
    private String c;
    private long d;
    private int e;
    private aw f;
    private long g;
    private boolean h;
    private int i;
    private long j;
    private int k;
    private boolean l;
    private boolean m;
    
    static {
        a = as.class.getSimpleName();
    }
    
    public as() {
        this.d = Long.MAX_VALUE;
        this.e = Integer.MAX_VALUE;
        this.j = 102400L;
    }
    
    private long a(final en en) {
        final List b = en.b("Content-Length");
        if (b != null && !b.isEmpty()) {
            try {
                return Long.parseLong(b.get(0));
            }
            catch (NumberFormatException ex) {
                eo.a(3, as.a, "Downloader: could not determine content length for url: " + this.c);
            }
        }
        return -1L;
    }
    
    private String a(final int i) {
        return String.format(Locale.US, "%s__%03d", this.c, i);
    }
    
    private String b(final int n) {
        return String.format("%s=%d-%d", "bytes", n * this.j, Math.min(this.g, (n + 1) * this.j) - 1L);
    }
    
    private void j() {
        if (this.b()) {
            return;
        }
        eo.a(3, as.a, "Downloader: Requesting file from url: " + this.c);
        final en en = new en();
        en.a(this.c);
        en.a(en$a.b);
        en.a(this.e);
        en.a(new en$b() {
            final /* synthetic */ as a;
            
            @Override
            public void a(final en en) {
                if (as.this.b()) {
                    return;
                }
                eo.a(3, as.a, "Downloader: Download status code is:" + en.e() + " for url: " + as.this.c);
                as.this.l = en.c();
                do.a().c(new ff() {
                    @Override
                    public void a() {
                        if (!as.this.l) {
                            as.this.h();
                        }
                        as.this.o();
                    }
                });
            }
            
            @Override
            public void a(final en en, final InputStream inputStream) {
                if (as.this.b()) {
                    throw new IOException("Downloader: request cancelled");
                }
                as.this.g = as.this.a(en);
                if (as.this.g > as.this.d) {
                    throw new IOException("Downloader: content length: " + as.this.g + " exceeds size limit: " + as.this.d);
                }
                az az;
                try {
                    final az az2;
                    az = (az2 = new az(inputStream, as.this.d));
                    final en$b en$b = this;
                    final as as = en$b.a;
                    final OutputStream outputStream = as.f();
                    fe.a(az2, outputStream);
                    final en$b en$b2 = this;
                    final as as2 = en$b2.a;
                    as2.g();
                    final az az3 = az;
                    fe.a(az3);
                    return;
                }
                finally {
                    final Object o2;
                    final Object o = o2;
                    az = null;
                }
                while (true) {
                    try {
                        final az az2 = az;
                        final en$b en$b = this;
                        final as as = en$b.a;
                        final OutputStream outputStream = as.f();
                        fe.a(az2, outputStream);
                        final en$b en$b2 = this;
                        final as as2 = en$b2.a;
                        as2.g();
                        final az az3 = az;
                        fe.a(az3);
                        return;
                        com.flurry.sdk.as.this.g();
                        fe.a(az);
                        throw;
                    }
                    finally {
                        continue;
                    }
                    break;
                }
            }
        });
        em.a().a(this, en);
    }
    
    private void k() {
        if (this.b()) {
            return;
        }
        final el el = new el();
        el.a(this.c);
        el.a(en$a.f);
        el.a(new el$a() {
            public void a(final el el, final Void void1) {
                if (as.this.b()) {
                    return;
                }
                eo.a(3, as.a, "Downloader: HTTP HEAD status code is:" + el.e() + " for url: " + as.this.c);
                if (!el.c()) {
                    do.a().c(new ff() {
                        @Override
                        public void a() {
                            as.this.o();
                        }
                    });
                    return;
                }
                as.this.g = as.this.a(el);
                final List b = el.b("Accept-Ranges");
                if (as.this.g > 0L && b != null && !b.isEmpty()) {
                    as.this.h = "bytes".equals(b.get(0).trim());
                    final as a = as.this;
                    final long n = as.this.g / as.this.j;
                    boolean b2;
                    if (as.this.g % as.this.j > 0L) {
                        b2 = true;
                    }
                    else {
                        b2 = false;
                    }
                    a.i = (int)(n + (b2 ? 1 : 0));
                }
                else {
                    as.this.i = 1;
                }
                if (as.this.d > 0L && as.this.g > as.this.d) {
                    eo.a(3, as.a, "Downloader: Size limit exceeded -- limit: " + as.this.d + ", content-length: " + as.this.g + " bytes!");
                    do.a().c(new ff() {
                        @Override
                        public void a() {
                            as.this.o();
                        }
                    });
                    return;
                }
                do.a().c(new ff() {
                    @Override
                    public void a() {
                        as.this.l();
                    }
                });
            }
        });
        eo.a(3, as.a, "Downloader: requesting HTTP HEAD for url: " + this.c);
        em.a().a(this, el);
    }
    
    private void l() {
        if (this.b()) {
            return;
        }
        if (this.q()) {
            for (int i = 0; i < this.i; ++i) {
                this.f.d(this.a(i));
            }
            this.m();
            return;
        }
        this.j();
    }
    
    private void m() {
        while (this.k < this.i) {
            if (this.b()) {
                return;
            }
            final String a = this.a(this.k);
            final String b = this.b(this.k);
            if (!this.f.d(a)) {
                eo.a(3, as.a, "Downloader: Requesting chunk with range:" + b + " for url: " + this.c + " chunk: " + this.k);
                final en en = new en();
                en.a(this.c);
                en.a(en$a.b);
                en.a(this.e);
                en.a("Range", b);
                en.a(new en$b() {
                    @Override
                    public void a(final en en) {
                        if (as.this.b()) {
                            return;
                        }
                        final int e = en.e();
                        eo.a(3, as.a, "Downloader: Download status code is:" + e + " for url: " + as.this.c + " chunk: " + as.this.k);
                        final List b = en.b("Content-Range");
                        String str = null;
                        if (b != null) {
                            final boolean empty = b.isEmpty();
                            str = null;
                            if (!empty) {
                                str = b.get(0);
                                eo.a(3, as.a, "Downloader: Content range is:" + str + " for url: " + as.this.c + " chunk: " + as.this.k);
                            }
                        }
                        if (en.c() && e == 206 && str != null && str.startsWith(b.replaceAll("=", " "))) {
                            as.this.k++;
                            do.a().c(new ff() {
                                @Override
                                public void a() {
                                    as.this.m();
                                }
                            });
                            return;
                        }
                        do.a().c(new ff() {
                            @Override
                            public void a() {
                                as.this.o();
                            }
                        });
                    }
                    
                    @Override
                    public void a(final en p0, final InputStream p1) {
                        // 
                        // This method could not be decompiled.
                        // 
                        // Original Bytecode:
                        // 
                        //     0: aload_0        
                        //     1: getfield        com/flurry/sdk/as$4.c:Lcom/flurry/sdk/as;
                        //     4: invokevirtual   com/flurry/sdk/as.b:()Z
                        //     7: ifeq            20
                        //    10: new             Ljava/io/IOException;
                        //    13: dup            
                        //    14: ldc             "Downloader: request cancelled"
                        //    16: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
                        //    19: athrow         
                        //    20: aload_0        
                        //    21: getfield        com/flurry/sdk/as$4.c:Lcom/flurry/sdk/as;
                        //    24: invokestatic    com/flurry/sdk/as.k:(Lcom/flurry/sdk/as;)Lcom/flurry/sdk/aw;
                        //    27: aload_0        
                        //    28: getfield        com/flurry/sdk/as$4.a:Ljava/lang/String;
                        //    31: invokevirtual   com/flurry/sdk/aw.b:(Ljava/lang/String;)Lcom/flurry/sdk/aw$c;
                        //    34: astore_3       
                        //    35: aconst_null    
                        //    36: astore          4
                        //    38: aload_3        
                        //    39: ifnull          78
                        //    42: new             Lcom/flurry/sdk/az;
                        //    45: dup            
                        //    46: aload_2        
                        //    47: aload_0        
                        //    48: getfield        com/flurry/sdk/as$4.c:Lcom/flurry/sdk/as;
                        //    51: invokestatic    com/flurry/sdk/as.e:(Lcom/flurry/sdk/as;)J
                        //    54: invokespecial   com/flurry/sdk/az.<init>:(Ljava/io/InputStream;J)V
                        //    57: astore          6
                        //    59: aload           6
                        //    61: aload_3        
                        //    62: invokevirtual   com/flurry/sdk/aw$c.a:()Ljava/io/OutputStream;
                        //    65: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/InputStream;Ljava/io/OutputStream;)J
                        //    68: pop2           
                        //    69: aload_3        
                        //    70: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
                        //    73: aload           6
                        //    75: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
                        //    78: aload           4
                        //    80: ifnull          136
                        //    83: aload_0        
                        //    84: getfield        com/flurry/sdk/as$4.c:Lcom/flurry/sdk/as;
                        //    87: invokestatic    com/flurry/sdk/as.k:(Lcom/flurry/sdk/as;)Lcom/flurry/sdk/aw;
                        //    90: aload_0        
                        //    91: getfield        com/flurry/sdk/as$4.a:Ljava/lang/String;
                        //    94: invokevirtual   com/flurry/sdk/aw.c:(Ljava/lang/String;)Z
                        //    97: pop            
                        //    98: aload           4
                        //   100: athrow         
                        //   101: astore          7
                        //   103: aconst_null    
                        //   104: astore          6
                        //   106: aload_3        
                        //   107: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
                        //   110: aload           6
                        //   112: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
                        //   115: aload           7
                        //   117: astore          4
                        //   119: goto            78
                        //   122: astore          8
                        //   124: aload_3        
                        //   125: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
                        //   128: aload           4
                        //   130: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
                        //   133: aload           8
                        //   135: athrow         
                        //   136: return         
                        //   137: astore          8
                        //   139: aload           6
                        //   141: astore          4
                        //   143: goto            124
                        //   146: astore          7
                        //   148: goto            106
                        //    Exceptions:
                        //  Try           Handler
                        //  Start  End    Start  End    Type                 
                        //  -----  -----  -----  -----  ---------------------
                        //  42     59     101    106    Ljava/io/IOException;
                        //  42     59     122    124    Any
                        //  59     69     146    151    Ljava/io/IOException;
                        //  59     69     137    146    Any
                        // 
                        // The error that occurred was:
                        // 
                        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0078:
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
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1163)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1010)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:437)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:425)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
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
                });
                em.a().a(this, en);
                return;
            }
            eo.a(3, as.a, "Downloader: Skipping chunk with range:" + b + " for url: " + this.c + " chunk: " + this.k);
            ++this.k;
        }
        this.n();
    }
    
    private void n() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: iconst_0       
        //     1: istore_1       
        //     2: aload_0        
        //     3: invokevirtual   com/flurry/sdk/as.b:()Z
        //     6: ifeq            10
        //     9: return         
        //    10: iconst_3       
        //    11: getstatic       com/flurry/sdk/as.a:Ljava/lang/String;
        //    14: new             Ljava/lang/StringBuilder;
        //    17: dup            
        //    18: ldc_w           "Downloader: assembling output file for url: "
        //    21: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    24: aload_0        
        //    25: getfield        com/flurry/sdk/as.c:Ljava/lang/String;
        //    28: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    31: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    34: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;)V
        //    37: aload_0        
        //    38: invokevirtual   com/flurry/sdk/as.f:()Ljava/io/OutputStream;
        //    41: astore          6
        //    43: iconst_0       
        //    44: istore          7
        //    46: iload           7
        //    48: aload_0        
        //    49: getfield        com/flurry/sdk/as.i:I
        //    52: if_icmpge       226
        //    55: aload_0        
        //    56: invokevirtual   com/flurry/sdk/as.b:()Z
        //    59: ifeq            123
        //    62: new             Ljava/io/IOException;
        //    65: dup            
        //    66: ldc_w           "Download cancelled"
        //    69: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //    72: athrow         
        //    73: astore_3       
        //    74: aload_0        
        //    75: invokevirtual   com/flurry/sdk/as.g:()V
        //    78: aload_3        
        //    79: astore          4
        //    81: aload           4
        //    83: ifnonnull       236
        //    86: iconst_3       
        //    87: getstatic       com/flurry/sdk/as.a:Ljava/lang/String;
        //    90: new             Ljava/lang/StringBuilder;
        //    93: dup            
        //    94: ldc_w           "Downloader: assemble succeeded for url: "
        //    97: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   100: aload_0        
        //   101: getfield        com/flurry/sdk/as.c:Ljava/lang/String;
        //   104: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   107: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   110: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;)V
        //   113: aload_0        
        //   114: iconst_1       
        //   115: putfield        com/flurry/sdk/as.l:Z
        //   118: aload_0        
        //   119: invokespecial   com/flurry/sdk/as.o:()V
        //   122: return         
        //   123: aload_0        
        //   124: iload           7
        //   126: invokespecial   com/flurry/sdk/as.a:(I)Ljava/lang/String;
        //   129: astore          8
        //   131: aload_0        
        //   132: getfield        com/flurry/sdk/as.f:Lcom/flurry/sdk/aw;
        //   135: aload           8
        //   137: invokevirtual   com/flurry/sdk/aw.a:(Ljava/lang/String;)Lcom/flurry/sdk/aw$b;
        //   140: astore          11
        //   142: aload           11
        //   144: astore          10
        //   146: aload           10
        //   148: ifnonnull       194
        //   151: new             Ljava/io/IOException;
        //   154: dup            
        //   155: new             Ljava/lang/StringBuilder;
        //   158: dup            
        //   159: ldc_w           "Could not create reader for chunk key: "
        //   162: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   165: aload           8
        //   167: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   170: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   173: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   176: athrow         
        //   177: astore          9
        //   179: aload           10
        //   181: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   184: aload           9
        //   186: athrow         
        //   187: astore_2       
        //   188: aload_0        
        //   189: invokevirtual   com/flurry/sdk/as.g:()V
        //   192: aload_2        
        //   193: athrow         
        //   194: aload           10
        //   196: invokevirtual   com/flurry/sdk/aw$b.a:()Ljava/io/InputStream;
        //   199: aload           6
        //   201: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/InputStream;Ljava/io/OutputStream;)J
        //   204: pop2           
        //   205: aload           10
        //   207: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   210: aload_0        
        //   211: getfield        com/flurry/sdk/as.f:Lcom/flurry/sdk/aw;
        //   214: aload           8
        //   216: invokevirtual   com/flurry/sdk/aw.c:(Ljava/lang/String;)Z
        //   219: pop            
        //   220: iinc            7, 1
        //   223: goto            46
        //   226: aload_0        
        //   227: invokevirtual   com/flurry/sdk/as.g:()V
        //   230: aconst_null    
        //   231: astore          4
        //   233: goto            81
        //   236: iconst_3       
        //   237: getstatic       com/flurry/sdk/as.a:Ljava/lang/String;
        //   240: new             Ljava/lang/StringBuilder;
        //   243: dup            
        //   244: ldc_w           "Downloader: assemble failed for url: "
        //   247: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   250: aload_0        
        //   251: getfield        com/flurry/sdk/as.c:Ljava/lang/String;
        //   254: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   257: ldc_w           " failed with exception: "
        //   260: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   263: aload           4
        //   265: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   268: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   271: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;)V
        //   274: iload_1        
        //   275: aload_0        
        //   276: getfield        com/flurry/sdk/as.i:I
        //   279: if_icmpge       301
        //   282: aload_0        
        //   283: getfield        com/flurry/sdk/as.f:Lcom/flurry/sdk/aw;
        //   286: aload_0        
        //   287: iload_1        
        //   288: invokespecial   com/flurry/sdk/as.a:(I)Ljava/lang/String;
        //   291: invokevirtual   com/flurry/sdk/aw.c:(Ljava/lang/String;)Z
        //   294: pop            
        //   295: iinc            1, 1
        //   298: goto            274
        //   301: aload_0        
        //   302: invokevirtual   com/flurry/sdk/as.h:()V
        //   305: goto            118
        //   308: astore          9
        //   310: aconst_null    
        //   311: astore          10
        //   313: goto            179
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  37     43     73     81     Ljava/io/IOException;
        //  37     43     187    194    Any
        //  46     73     73     81     Ljava/io/IOException;
        //  46     73     187    194    Any
        //  123    131    73     81     Ljava/io/IOException;
        //  123    131    187    194    Any
        //  131    142    308    316    Any
        //  151    177    177    179    Any
        //  179    187    73     81     Ljava/io/IOException;
        //  179    187    187    194    Any
        //  194    205    177    179    Any
        //  205    220    73     81     Ljava/io/IOException;
        //  205    220    187    194    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0179:
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
    
    private void o() {
        if (!this.b() && this.b != null) {
            eo.a(3, as.a, "Downloader: finished -- success: " + this.l + " for url: " + this.c);
            this.b.a(this);
        }
    }
    
    private boolean p() {
        return this.f != null;
    }
    
    private boolean q() {
        return this.f != null && this.h && this.i > 1;
    }
    
    public void a(final as$a b) {
        this.b = b;
    }
    
    public void a(final aw f) {
        this.f = f;
    }
    
    public void a(final String c) {
        this.c = c;
    }
    
    public boolean a() {
        return this.l;
    }
    
    public boolean b() {
        return this.m;
    }
    
    public long c() {
        return this.g;
    }
    
    public void d() {
        do.a().c(new ff() {
            @Override
            public void a() {
                if (as.this.p()) {
                    as.this.k();
                    return;
                }
                as.this.j();
            }
        });
    }
    
    public void e() {
        this.m = true;
        em.a().a(this);
    }
    
    protected abstract OutputStream f();
    
    protected abstract void g();
    
    protected abstract void h();
}
