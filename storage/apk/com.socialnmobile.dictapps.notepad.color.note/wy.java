import com.socialnmobile.colornote.sync.jobs.SyncJob$Listener;
import com.socialnmobile.colornote.sync.jobs.SyncJob;
import android.os.Handler;

// 
// Decompiled by Procyon v0.5.29
// 

public final class wy implements wf
{
    final Handler a;
    final /* synthetic */ SyncJob b;
    
    public wy(final SyncJob b) {
        this.b = b;
        this.a = new Handler();
    }
    
    @Override
    public final void a(final int n, final int n2) {
        final SyncJob$Listener syncJob$Listener = (SyncJob$Listener)this.b.getJobListener();
        if (syncJob$Listener != null) {
            this.a.post((Runnable)new wz(this, syncJob$Listener, n, n2));
        }
    }
}
