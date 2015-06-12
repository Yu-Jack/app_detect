import android.content.Context;
import java.util.concurrent.Semaphore;

// 
// Decompiled by Procyon v0.5.29
// 

public final class uh implements Runnable
{
    final /* synthetic */ ug a;
    private final /* synthetic */ Semaphore b;
    
    public uh(final ug a, final Semaphore b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        final ug a = this.a;
        final Context b = this.a.b;
        kg.b(b);
        jp.a(b);
        new jr(b).d();
        jo.a(b, "WIPE_OUT_MARK", 1);
        this.b.release();
    }
}
