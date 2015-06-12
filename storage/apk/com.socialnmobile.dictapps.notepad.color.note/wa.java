import com.socialnmobile.util.service.ServiceJob$JobListener;
import com.socialnmobile.colornote.sync.SyncService;

// 
// Decompiled by Procyon v0.5.29
// 

public final class wa implements Runnable
{
    final /* synthetic */ SyncService a;
    private final /* synthetic */ ServiceJob$JobListener b;
    
    public wa(final SyncService a, final ServiceJob$JobListener b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        this.b.onFinalize();
    }
}
