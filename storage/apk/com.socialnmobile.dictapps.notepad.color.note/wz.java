import com.socialnmobile.colornote.sync.jobs.SyncJob$Listener;

// 
// Decompiled by Procyon v0.5.29
// 

final class wz implements Runnable
{
    final /* synthetic */ wy a;
    private final /* synthetic */ SyncJob$Listener b;
    private final /* synthetic */ int c;
    private final /* synthetic */ int d;
    
    wz(final wy a, final SyncJob$Listener b, final int c, final int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public final void run() {
        this.b.onProgress(this.c, this.d);
    }
}
