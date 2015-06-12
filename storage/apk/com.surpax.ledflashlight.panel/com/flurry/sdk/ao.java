// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.io.Closeable;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.Iterator;
import com.flurry.android.impl.ads.FlurryAdModule;
import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.lang.ref.WeakReference;
import java.util.Map;

public class ao
{
    private static final String b;
    final Map a;
    private final Map c;
    private final Map d;
    private final av e;
    private final long f;
    private final int g;
    private boolean h;
    private WeakReference i;
    
    static {
        b = ao.class.getSimpleName();
    }
    
    ao(final String s, final long n, final long f, final boolean b) {
        this.a = new HashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.h = false;
        this.i = new WeakReference(null);
        this.e = new av(new ew(), s, n, b);
        this.f = f;
        int g;
        if (Runtime.getRuntime().availableProcessors() > 1) {
            g = 2;
        }
        else {
            g = 1;
        }
        this.g = g;
    }
    
    private void a(final aq aq) {
        if (aq == null || TextUtils.isEmpty((CharSequence)aq.a()) || this.a.containsKey(aq.a())) {
            return;
        }
        eo.a(3, ao.b, "Precaching: adding cached asset info from persisted storage: " + aq.a() + " asset exp: " + aq.c() + " saved time: " + aq.f());
        synchronized (this.a) {
            this.a.put(aq.a(), aq);
        }
    }
    
    private void a(final aq aq, final ar obj) {
        if (aq != null && obj != null && !obj.equals(aq.b())) {
            eo.a(3, ao.b, "Asset status changed for asset:" + aq.a() + " from:" + aq.b() + " to:" + obj);
            aq.a(obj);
            final ao$a ao$a = (ao$a)this.i.get();
            if (ao$a != null) {
                do.a().c(new ff() {
                    @Override
                    public void a() {
                        ao$a.a(aq.a(), obj);
                    }
                });
            }
        }
    }
    
    private void b(final aq aq) {
        if (aq != null) {
            final ar c = this.c(aq);
            if (!ar.d.equals(c)) {
                while (true) {
                    Label_0103: {
                        if (!ar.c.equals(c) && !ar.b.equals(c)) {
                            break Label_0103;
                        }
                        synchronized (this.c) {
                            if (!this.c.containsKey(aq.a())) {
                                this.c.put(aq.a(), aq);
                            }
                            // monitorexit(this.c)
                            do.a().c(new ff() {
                                @Override
                                public void a() {
                                    ao.this.j();
                                }
                            });
                            return;
                        }
                    }
                    eo.a(3, ao.b, "Precaching: Queueing asset:" + aq.a());
                    FlurryAdModule.getInstance().a("precachingDownloadRequested", 1);
                    this.a(aq, ar.b);
                    synchronized (this.c) {
                        this.c.put(aq.a(), aq);
                        continue;
                    }
                    break;
                }
            }
        }
    }
    
    private ar c(final aq aq) {
        if (aq == null) {
            return ar.a;
        }
        if (aq.d()) {
            return ar.a;
        }
        if (ar.d.equals(aq.b()) && !this.e.d(aq.a())) {
            this.a(aq, ar.f);
        }
        return aq.b();
    }
    
    private aq d(final String s) {
        if (!this.h || TextUtils.isEmpty((CharSequence)s)) {
            return null;
        }
        while (true) {
            aq aq = null;
            Label_0124: {
                synchronized (this.a) {
                    aq = this.a.get(s);
                    // monitorexit(this.a)
                    if (aq != null) {
                        if (!aq.d()) {
                            break Label_0124;
                        }
                        eo.a(3, ao.b, "Precaching: expiring cached asset: " + aq.a() + " asset exp: " + aq.c() + " device epoch" + System.currentTimeMillis());
                        this.a(aq.a());
                        aq = null;
                    }
                    return aq;
                }
            }
            this.c(aq);
            aq.e();
            return aq;
        }
    }
    
    private void d(final aq aq) {
        FlurryAdModule.getInstance().a("precachingDownloadStarted", 1);
        eo.a(3, ao.b, "Precaching: Submitting for download: " + aq.a());
        final ax ax = new ax(this.e, aq.a());
        ax.a(aq.a());
        ax.a(this.e);
        ax.a(new as$a() {
            @Override
            public void a(final as as) {
                while (true) {
                    while (true) {
                        synchronized (ao.this.d) {
                            ao.this.d.remove(aq.a());
                            // monitorexit(ao.b(this.b))
                            ao.this.e(aq);
                            if (as.a()) {
                                final long c = as.c();
                                eo.a(3, ao.b, "Precaching: Download success: " + aq.a() + " size: " + c);
                                aq.a(c);
                                ao.this.a(aq, ar.d);
                                FlurryAdModule.getInstance().a("precachingDownloadSuccess", 1);
                                do.a().c(new ff() {
                                    @Override
                                    public void a() {
                                        ao.this.j();
                                    }
                                });
                                return;
                            }
                        }
                        eo.a(3, ao.b, "Precaching: Download error: " + aq.a());
                        ao.this.a(aq, ar.g);
                        FlurryAdModule.getInstance().a("precachingDownloadError", 1);
                        continue;
                    }
                }
            }
        });
        ax.d();
        synchronized (this.d) {
            this.d.put(aq.a(), ax);
            // monitorexit(this.d)
            this.a(aq, ar.c);
        }
    }
    
    private void e(final aq aq) {
        if (aq == null) {
            return;
        }
        synchronized (this.c) {
            this.c.remove(aq.a());
        }
    }
    
    private void j() {
        if (!this.h) {
            return;
        }
        while (true) {
            eo.a(3, ao.b, "Precaching: Download files");
        Label_0179:
            while (true) {
                aq aq = null;
                Label_0126: {
                    synchronized (this.c) {
                        final Iterator<aq> iterator = this.c.values().iterator();
                        while (iterator.hasNext()) {
                            aq = iterator.next();
                            if (!this.e.d(aq.a())) {
                                break Label_0126;
                            }
                            eo.a(3, ao.b, "Precaching: Asset already cached.  Skipping download:" + aq.a());
                            iterator.remove();
                            this.a(aq, ar.d);
                        }
                        break Label_0179;
                    }
                }
                if (ar.c.equals(this.c(aq))) {
                    continue;
                }
                if (em.a().b(this) >= this.g) {
                    eo.a(3, ao.b, "Precaching: Download limit reached");
                    // monitorexit(map)
                    return;
                }
                this.d(aq);
                continue;
            }
            // monitorexit(map)
            eo.a(3, ao.b, "Precaching: No more files to download");
        }
    }
    
    private void k() {
        eo.a(3, ao.b, "Precaching: Cancelling in-progress downloads");
        synchronized (this.d) {
            final Iterator<Map.Entry<K, as>> iterator = this.d.entrySet().iterator();
            while (iterator.hasNext()) {
                iterator.next().getValue().e();
            }
        }
        this.d.clear();
        // monitorexit(map)
        synchronized (this.c) {
            final Iterator<Map.Entry<K, aq>> iterator2 = this.c.entrySet().iterator();
            while (iterator2.hasNext()) {
                final aq aq = iterator2.next().getValue();
                if (!ar.d.equals(this.c(aq))) {
                    eo.a(3, ao.b, "Precaching: Download cancelled: " + aq.f());
                    this.a(aq, ar.e);
                }
            }
        }
    }
    // monitorexit(map2)
    
    private void l() {
        for (final aq aq : this.g()) {
            if (!ar.d.equals(this.c(aq))) {
                eo.a(3, ao.b, "Precaching: expiring cached asset: " + aq.a() + " asset exp: " + aq.c() + " device epoch: " + System.currentTimeMillis());
                this.a(aq.a());
            }
        }
    }
    
    public void a() {
        synchronized (this) {
            if (!this.h) {
                eo.a(3, ao.b, "Precaching: Starting AssetCache");
                this.e.a();
                do.a().c(new ff() {
                    @Override
                    public void a() {
                        ao.this.j();
                    }
                });
                this.h = true;
            }
        }
    }
    
    public void a(final ao$a referent) {
        this.i = new WeakReference((T)referent);
    }
    
    public void a(final InputStream p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: monitorenter   
        //     2: aload_1        
        //     3: ifnonnull       24
        //     6: new             Ljava/io/IOException;
        //     9: dup            
        //    10: ldc_w           "Invalid input stream!"
        //    13: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //    16: athrow         
        //    17: astore          4
        //    19: aload_0        
        //    20: monitorexit    
        //    21: aload           4
        //    23: athrow         
        //    24: new             Ljava/io/DataInputStream;
        //    27: dup            
        //    28: aload_1        
        //    29: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    32: astore_2       
        //    33: aload_2        
        //    34: invokevirtual   java/io/DataInputStream.readShort:()S
        //    37: istore          5
        //    39: iconst_0       
        //    40: istore          6
        //    42: iload           6
        //    44: iload           5
        //    46: if_icmpge       67
        //    49: aload_0        
        //    50: new             Lcom/flurry/sdk/aq;
        //    53: dup            
        //    54: aload_2        
        //    55: invokespecial   com/flurry/sdk/aq.<init>:(Ljava/io/DataInput;)V
        //    58: invokespecial   com/flurry/sdk/ao.a:(Lcom/flurry/sdk/aq;)V
        //    61: iinc            6, 1
        //    64: goto            42
        //    67: aload_0        
        //    68: invokespecial   com/flurry/sdk/ao.l:()V
        //    71: aload_2        
        //    72: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //    75: aload_0        
        //    76: monitorexit    
        //    77: return         
        //    78: astore_3       
        //    79: aconst_null    
        //    80: astore_2       
        //    81: aload_2        
        //    82: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //    85: aload_3        
        //    86: athrow         
        //    87: astore_3       
        //    88: goto            81
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  6      17     17     24     Any
        //  24     33     78     81     Any
        //  33     39     87     91     Any
        //  49     61     87     91     Any
        //  67     71     87     91     Any
        //  71     75     17     24     Any
        //  81     87     17     24     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0042:
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
    
    public void a(final OutputStream out) {
        // monitorenter(this)
        if (out == null) {
            try {
                throw new IOException("Invalid output stream!");
            }
            finally {
            }
            // monitorexit(this)
        }
        while (true) {
            try {
                final DataOutputStream dataOutputStream = new DataOutputStream(out);
                Label_0093: {
                    try {
                        final List g = this.g();
                        dataOutputStream.writeShort(g.size());
                        final Iterator<aq> iterator = g.iterator();
                        while (iterator.hasNext()) {
                            iterator.next().a(dataOutputStream);
                        }
                        break Label_0093;
                    }
                    finally {}
                    fe.a(dataOutputStream);
                    throw;
                }
                fe.a(dataOutputStream);
            }
            // monitorexit(this)
            finally {
                final DataOutputStream dataOutputStream = null;
                continue;
            }
            break;
        }
    }
    
    public void a(final String s) {
        if (!this.h || TextUtils.isEmpty((CharSequence)s)) {
            return;
        }
        synchronized (this.a) {
            this.a.remove(s);
            // monitorexit(this.a)
            this.e.c(s);
        }
    }
    
    public boolean a(final String s, final ay other, final long n) {
        if (!this.h || TextUtils.isEmpty((CharSequence)s) || other == null || !ay.b.equals(other)) {
            return false;
        }
        final aq d = this.d(s);
        Label_0099: {
            if (d != null) {
                break Label_0099;
            }
            final aq aq = new aq(s, other, n);
            synchronized (this.a) {
                this.a.put(aq.a(), aq);
                // monitorexit(this.a)
                this.b(aq);
                return true;
            }
        }
        if (!ar.d.equals(this.c(d))) {
            this.b(d);
            return true;
        }
        return true;
    }
    
    public ar b(final String s) {
        if (!this.h) {
            return ar.a;
        }
        return this.c(this.d(s));
    }
    
    public void b() {
        synchronized (this) {
            if (this.h) {
                eo.a(3, ao.b, "Precaching: Stopping AssetCache");
                this.k();
                this.e.b();
                this.h = false;
            }
        }
    }
    
    public aw$b c(final String s) {
        if (this.h && !TextUtils.isEmpty((CharSequence)s)) {
            return this.e.a(s);
        }
        return null;
    }
    
    public void c() {
        synchronized (this) {
            if (this.h) {
                eo.a(3, ao.b, "Precaching: Pausing AssetCache");
                this.k();
            }
        }
    }
    
    public void d() {
        synchronized (this) {
            if (this.h) {
                eo.a(3, ao.b, "Precaching: Resuming AssetCache");
                do.a().c(new ff() {
                    @Override
                    public void a() {
                        ao.this.j();
                    }
                });
            }
        }
    }
    
    public void e() {
        if (!this.h) {
            return;
        }
        final Iterator<aq> iterator = this.g().iterator();
        while (iterator.hasNext()) {
            this.a(iterator.next().a());
        }
        this.e.c();
    }
    
    public void f() {
        if (this.h) {
            final Iterator<aq> iterator = this.g().iterator();
            while (iterator.hasNext()) {
                this.c(iterator.next());
            }
        }
    }
    
    public List g() {
        synchronized (this.a) {
            return new ArrayList(this.a.values());
        }
    }
    
    public List h() {
        this.f();
        return this.g();
    }
}
