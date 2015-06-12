import com.socialnmobile.colornote.sync.SyncService$BackgroundSyncConnection;

// 
// Decompiled by Procyon v0.5.29
// 

public final class wb implements Runnable
{
    final /* synthetic */ SyncService$BackgroundSyncConnection a;
    
    public wb(final SyncService$BackgroundSyncConnection a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        this.a.unbind();
    }
}
