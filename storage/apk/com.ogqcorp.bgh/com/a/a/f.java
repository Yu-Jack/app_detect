// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a;

import android.os.Handler;
import java.util.concurrent.Executor;

public class f implements t
{
    private final Executor a;
    
    public f(final Handler handler) {
        this.a = new Executor() {
            @Override
            public void execute(final Runnable runnable) {
                handler.post(runnable);
            }
        };
    }
    
    @Override
    public void a(final n<?> n, final q<?> q) {
        this.a(n, q, null);
    }
    
    @Override
    public void a(final n<?> n, final q<?> q, final Runnable runnable) {
        n.u();
        n.a("post-response");
        this.a.execute(new g(this, n, q, runnable));
    }
    
    @Override
    public void a(final n<?> n, final x x) {
        n.a("post-error");
        this.a.execute(new g(this, n, q.a(x), null));
    }
}
