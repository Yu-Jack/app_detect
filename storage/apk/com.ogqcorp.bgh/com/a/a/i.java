// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a;

import android.os.Process;
import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build$VERSION;
import java.util.concurrent.BlockingQueue;

public class i extends Thread
{
    private final BlockingQueue<n<?>> a;
    private final h b;
    private final b c;
    private final t d;
    private volatile boolean e;
    
    public i(final BlockingQueue<n<?>> a, final h b, final b c, final t d) {
        this.e = false;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @TargetApi(14)
    private void a(final n<?> n) {
        if (Build$VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(n.b());
        }
    }
    
    private void a(final n<?> n, final x x) {
        this.d.a(n, n.a(x));
    }
    
    public void a() {
        this.e = true;
        this.interrupt();
    }
    
    @Override
    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            while (true) {
                n<?> n = null;
                try {
                    while (true) {
                        n = this.a.take();
                        try {
                            n.a("network-queue-take");
                            if (!n.g()) {
                                goto Label_0061;
                            }
                            n.b("network-discard-cancelled");
                        }
                        catch (x x) {
                            this.a(n, x);
                        }
                        catch (Exception ex) {
                            y.a(ex, "Unhandled exception %s", ex.toString());
                            this.d.a(n, new x(ex));
                        }
                    }
                }
                catch (InterruptedException ex2) {}
                final k k;
                final q<?> a = n.a(k);
                n.a("network-parse-complete");
                if (n.q() && a.b != null) {
                    this.c.a(n.d(), a.b);
                    n.a("network-cache-written");
                }
                n.u();
                this.d.a(n, a);
                continue;
            }
        }
    }
}
