// 
// Decompiled by Procyon v0.5.29
// 

package bolts;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import android.annotation.SuppressLint;
import android.os.Build$VERSION;
import java.util.concurrent.ThreadPoolExecutor;

final class Executors
{
    static final int CORE_POOL_SIZE = 0;
    private static final int CPU_COUNT = 0;
    static final long KEEP_ALIVE_TIME = 1L;
    static final int MAX_POOL_SIZE = 0;
    static final int MAX_QUEUE_SIZE = 128;
    
    @SuppressLint({ "NewApi" })
    public static void allowCoreThreadTimeout(final ThreadPoolExecutor threadPoolExecutor, final boolean value) {
        if (Build$VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(value);
        }
    }
    
    public static ExecutorService newCachedThreadPool() {
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Executors.CORE_POOL_SIZE, Executors.MAX_POOL_SIZE, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(128));
        allowCoreThreadTimeout(threadPoolExecutor, true);
        return threadPoolExecutor;
    }
    
    public static ExecutorService newCachedThreadPool(final ThreadFactory threadFactory) {
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Executors.CORE_POOL_SIZE, Executors.MAX_POOL_SIZE, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(128), threadFactory);
        allowCoreThreadTimeout(threadPoolExecutor, true);
        return threadPoolExecutor;
    }
}
