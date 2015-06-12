// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a;

import java.util.concurrent.BlockingQueue;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.HashMap;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.Set;
import java.util.Queue;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class p
{
    private AtomicInteger a;
    private final Map<String, Queue<n<?>>> b;
    private final Set<n<?>> c;
    private final PriorityBlockingQueue<n<?>> d;
    private final PriorityBlockingQueue<n<?>> e;
    private final b f;
    private final h g;
    private final t h;
    private i[] i;
    private d j;
    
    public p(final b b, final h h) {
        this(b, h, 4);
    }
    
    public p(final b b, final h h, final int n) {
        this(b, h, n, new f(new Handler(Looper.getMainLooper())));
    }
    
    public p(final b f, final h g, final int n, final t h) {
        this.a = new AtomicInteger();
        this.b = new HashMap<String, Queue<n<?>>>();
        this.c = new HashSet<n<?>>();
        this.d = new PriorityBlockingQueue<n<?>>();
        this.e = new PriorityBlockingQueue<n<?>>();
        this.f = f;
        this.g = g;
        this.i = new i[n];
        this.h = h;
    }
    
    public <T> n<T> a(final n<T> n) {
        n.a(this);
        synchronized (this.c) {
            this.c.add(n);
            // monitorexit(this.c)
            n.a(this.c());
            n.a("add-to-queue");
            if (!n.q()) {
                this.e.add(n);
                return n;
            }
        }
        while (true) {
            final String d;
            synchronized (this.b) {
                d = n.d();
                if (this.b.containsKey(d)) {
                    Queue<n<?>> queue = this.b.get(d);
                    if (queue == null) {
                        queue = new LinkedList<n<?>>();
                    }
                    queue.add(n);
                    this.b.put(d, queue);
                    if (y.b) {
                        y.a("Request for cacheKey=%s is in flight, putting on hold.", d);
                    }
                    return n;
                }
            }
            this.b.put(d, null);
            this.d.add(n);
            return n;
        }
    }
    
    public void a() {
        this.b();
        (this.j = new d(this.d, this.e, this.f, this.h)).start();
        for (int i = 0; i < this.i.length; ++i) {
            (this.i[i] = new i(this.e, this.g, this.f, this.h)).start();
        }
    }
    
    public void b() {
        if (this.j != null) {
            this.j.a();
        }
        for (int i = 0; i < this.i.length; ++i) {
            if (this.i[i] != null) {
                this.i[i].a();
            }
        }
    }
    
    void b(final n<?> p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/a/a/p.c:Ljava/util/Set;
        //     4: astore_2       
        //     5: aload_2        
        //     6: monitorenter   
        //     7: aload_0        
        //     8: getfield        com/a/a/p.c:Ljava/util/Set;
        //    11: aload_1        
        //    12: invokeinterface java/util/Set.remove:(Ljava/lang/Object;)Z
        //    17: pop            
        //    18: aload_2        
        //    19: monitorexit    
        //    20: aload_1        
        //    21: invokevirtual   com/a/a/n.q:()Z
        //    24: ifeq            115
        //    27: aload_0        
        //    28: getfield        com/a/a/p.b:Ljava/util/Map;
        //    31: astore          5
        //    33: aload           5
        //    35: monitorenter   
        //    36: aload_1        
        //    37: invokevirtual   com/a/a/n.d:()Ljava/lang/String;
        //    40: astore          7
        //    42: aload_0        
        //    43: getfield        com/a/a/p.b:Ljava/util/Map;
        //    46: aload           7
        //    48: invokeinterface java/util/Map.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //    53: checkcast       Ljava/util/Queue;
        //    56: astore          8
        //    58: aload           8
        //    60: ifnull          112
        //    63: getstatic       com/a/a/y.b:Z
        //    66: ifeq            102
        //    69: iconst_2       
        //    70: anewarray       Ljava/lang/Object;
        //    73: astore          10
        //    75: aload           10
        //    77: iconst_0       
        //    78: aload           8
        //    80: invokeinterface java/util/Queue.size:()I
        //    85: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    88: aastore        
        //    89: aload           10
        //    91: iconst_1       
        //    92: aload           7
        //    94: aastore        
        //    95: ldc             "Releasing %d waiting requests for cacheKey=%s."
        //    97: aload           10
        //    99: invokestatic    com/a/a/y.a:(Ljava/lang/String;[Ljava/lang/Object;)V
        //   102: aload_0        
        //   103: getfield        com/a/a/p.d:Ljava/util/concurrent/PriorityBlockingQueue;
        //   106: aload           8
        //   108: invokevirtual   java/util/concurrent/PriorityBlockingQueue.addAll:(Ljava/util/Collection;)Z
        //   111: pop            
        //   112: aload           5
        //   114: monitorexit    
        //   115: return         
        //   116: astore_3       
        //   117: aload_2        
        //   118: monitorexit    
        //   119: aload_3        
        //   120: athrow         
        //   121: astore          6
        //   123: aload           5
        //   125: monitorexit    
        //   126: aload           6
        //   128: athrow         
        //    Signature:
        //  (Lcom/a/a/n<*>;)V
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  7      20     116    121    Any
        //  36     58     121    129    Any
        //  63     102    121    129    Any
        //  102    112    121    129    Any
        //  112    115    121    129    Any
        //  117    119    116    121    Any
        //  123    126    121    129    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0102:
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
    
    public int c() {
        return this.a.incrementAndGet();
    }
}
