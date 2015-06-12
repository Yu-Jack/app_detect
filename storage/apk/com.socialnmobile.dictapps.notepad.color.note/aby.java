// 
// Decompiled by Procyon v0.5.29
// 

final class aby implements Runnable
{
    final /* synthetic */ abx a;
    private final /* synthetic */ Runnable b;
    
    aby(final abx a, final Runnable b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        try {
            this.b.run();
        }
        finally {
            this.a.c.post((Runnable)new abz(this));
        }
    }
}
