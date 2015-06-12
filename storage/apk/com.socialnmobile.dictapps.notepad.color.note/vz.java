import android.content.Context;
import com.socialnmobile.util.service.ServiceJob$JobListener;
import com.socialnmobile.colornote.sync.SyncService;

// 
// Decompiled by Procyon v0.5.29
// 

public final class vz implements Runnable
{
    final /* synthetic */ SyncService a;
    private final /* synthetic */ RuntimeException b;
    private final /* synthetic */ ServiceJob$JobListener c;
    
    public vz(final SyncService a, final RuntimeException b, final ServiceJob$JobListener c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void run() {
        jp.a((Context)this.a, System.currentTimeMillis(), this.b);
        this.c.onException(this.b);
    }
}
