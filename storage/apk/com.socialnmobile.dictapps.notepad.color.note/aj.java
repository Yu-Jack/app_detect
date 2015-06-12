import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Executor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import android.os.Process;

// 
// Decompiled by Procyon v0.5.29
// 

final class aj extends ap
{
    final /* synthetic */ ah a;
    
    aj(final ah a) {
        this.a = a;
        super((byte)0);
    }
    
    @Override
    public final Object call() {
        this.a.i.set(true);
        Process.setThreadPriority(10);
        final ah a = this.a;
        final ah a2 = this.a;
        final Object[] b = this.b;
        return a.b(a2.b());
    }
}
