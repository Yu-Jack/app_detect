import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Executor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import android.os.Message;
import android.os.Handler;

// 
// Decompiled by Procyon v0.5.29
// 

final class an extends Handler
{
    public final void handleMessage(final Message message) {
        final am am = (am)message.obj;
        switch (message.what) {
            default: {}
            case 1: {
                ah.c(am.a, am.b[0]);
            }
            case 2: {
                final ah a = am.a;
                final Object[] b = am.b;
                ah.c();
            }
        }
    }
}
