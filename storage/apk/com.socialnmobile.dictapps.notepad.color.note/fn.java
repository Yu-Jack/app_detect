import java.util.TimerTask;
import java.util.Timer;

// 
// Decompiled by Procyon v0.5.29
// 

final class fn
{
    private Timer a;
    private fo b;
    private fp c;
    
    fn(final fp c) {
        this.c = c;
    }
    
    public final void a() {
        synchronized (this) {
            if (this.a != null) {
                this.a.cancel();
                this.a = null;
            }
            this.b = null;
        }
    }
    
    public final void a(final long delay) {
        synchronized (this) {
            if (this.b()) {
                this.a();
            }
            this.a = new Timer("FlurrySessionTimer");
            this.b = new fo(this, this.c);
            this.a.schedule(this.b, delay);
        }
    }
    
    public final boolean b() {
        return this.a != null;
    }
}
