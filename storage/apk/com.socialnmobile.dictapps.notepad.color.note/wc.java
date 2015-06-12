import com.socialnmobile.colornote.sync.SyncService;
import android.os.Binder;

// 
// Decompiled by Procyon v0.5.29
// 

public final class wc extends Binder
{
    final /* synthetic */ SyncService a;
    
    public wc(final SyncService a) {
        this.a = a;
    }
    
    public final SyncService a() {
        return this.a;
    }
}
