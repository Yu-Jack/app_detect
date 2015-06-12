import java.util.concurrent.Callable;

// 
// Decompiled by Procyon v0.5.29
// 

public final class abw implements Runnable
{
    final Callable a;
    final abr b;
    
    public abw(final Callable a, final abr b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        try {
            this.b.a(this.a.call());
        }
        catch (Exception ex) {
            this.b.a(ex);
        }
        finally {
            this.b.a();
        }
    }
}
