import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ThreadFactory;

// 
// Decompiled by Procyon v0.5.29
// 

final class ai implements ThreadFactory
{
    private final AtomicInteger a;
    
    ai() {
        this.a = new AtomicInteger(1);
    }
    
    @Override
    public final Thread newThread(final Runnable target) {
        return new Thread(target, "ModernAsyncTask #" + this.a.getAndIncrement());
    }
}
