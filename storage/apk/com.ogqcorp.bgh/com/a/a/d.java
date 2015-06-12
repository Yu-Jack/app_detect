// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public class d extends Thread
{
    private static final boolean a;
    private final BlockingQueue<n<?>> b;
    private final BlockingQueue<n<?>> c;
    private final b d;
    private final t e;
    private volatile boolean f;
    
    static {
        a = y.b;
    }
    
    public d(final BlockingQueue<n<?>> b, final BlockingQueue<n<?>> c, final b d, final t e) {
        this.f = false;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public void a() {
        this.f = true;
        this.interrupt();
    }
    
    @Override
    public void run() {
        if (com.a.a.d.a) {
            y.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.d.a();
    Label_0029_Outer:
        while (true) {
            while (true) {
                n<?> n;
                try {
                    while (true) {
                        n = this.b.take();
                        n.a("cache-queue-take");
                        if (!n.g()) {
                            break;
                        }
                        n.b("cache-discard-canceled");
                    }
                }
                catch (InterruptedException ex) {
                    if (this.f) {
                        return;
                    }
                    continue Label_0029_Outer;
                }
                final c a = this.d.a(n.d());
                if (a == null) {
                    n.a("cache-miss");
                    this.c.put(n);
                    continue;
                }
                if (a.a()) {
                    n.a("cache-hit-expired");
                    n.a(a);
                    this.c.put(n);
                    continue;
                }
                n.a("cache-hit");
                final q<?> a2 = n.a(new k(a.a, a.f));
                n.a("cache-hit-parsed");
                if (!a.b()) {
                    this.e.a(n, a2);
                    continue;
                }
                n.a("cache-hit-refresh-needed");
                n.a(a);
                a2.d = true;
                this.e.a(n, a2, new Runnable() {
                    @Override
                    public void run() {
                        try {
                            com.a.a.d.this.c.put(n);
                        }
                        catch (InterruptedException ex) {}
                    }
                });
                continue;
            }
        }
    }
}
