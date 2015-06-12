import android.content.ServiceConnection;
import com.socialnmobile.colornote.activity.Main;
import com.socialnmobile.colornote.activity.Main$SyncListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class hy implements Runnable
{
    final /* synthetic */ Main$SyncListener a;
    
    public hy(final Main$SyncListener a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        final Main main = (Main)this.a.mActivityReference.get();
        if (main != null) {
            main.unbindService((ServiceConnection)this.a);
        }
    }
}
