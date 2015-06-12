// 
// Decompiled by Procyon v0.5.29
// 

final class abp implements Runnable
{
    private final /* synthetic */ abk a;
    private final /* synthetic */ Runnable b;
    
    abp(final abk a, final Runnable b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        this.a.a();
        try {
            this.b.run();
        }
        finally {
            this.a.b();
        }
    }
}
