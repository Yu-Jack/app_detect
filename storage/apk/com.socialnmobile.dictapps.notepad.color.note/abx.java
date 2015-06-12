import java.util.List;
import java.util.concurrent.TimeUnit;
import android.os.Handler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.AbstractExecutorService;

// 
// Decompiled by Procyon v0.5.29
// 

public final class abx extends AbstractExecutorService
{
    final ExecutorService a;
    final aca b;
    final Handler c;
    int d;
    
    public abx(final ExecutorService a, final aca b, final Handler c) {
        this.d = 0;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    private void b() {
        synchronized (this) {
            ++this.d;
        }
    }
    
    final void a() {
        synchronized (this) {
            final int d = -1 + this.d;
            this.d = d;
            // monitorexit(this)
            if (d == 0) {
                this.b.c();
            }
        }
    }
    
    @Override
    public final boolean awaitTermination(final long n, final TimeUnit timeUnit) {
        return this.a.awaitTermination(n, timeUnit);
    }
    
    @Override
    public final void execute(final Runnable runnable) {
        this.b();
        this.a.execute(new aby(this, runnable));
    }
    
    @Override
    public final boolean isShutdown() {
        return this.a.isShutdown();
    }
    
    @Override
    public final boolean isTerminated() {
        return this.a.isTerminated();
    }
    
    @Override
    public final void shutdown() {
        this.a.shutdown();
    }
    
    @Override
    public final List shutdownNow() {
        return this.a.shutdownNow();
    }
}
