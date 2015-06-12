import java.util.TimerTask;

// 
// Decompiled by Procyon v0.5.29
// 

final class fo extends TimerTask
{
    final /* synthetic */ fn a;
    private fp b;
    
    fo(final fn a, final fp b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        this.a.a();
        if (this.b != null) {
            this.b.f();
        }
    }
}
