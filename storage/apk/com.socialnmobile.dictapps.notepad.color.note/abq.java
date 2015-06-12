import java.util.concurrent.Callable;

// 
// Decompiled by Procyon v0.5.29
// 

public final class abq implements Callable
{
    private final /* synthetic */ abk a;
    private final /* synthetic */ Callable b;
    
    public abq(final abk a, final Callable b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final Object call() {
        this.a.a();
        try {
            return this.b.call();
        }
        finally {
            this.a.b();
        }
    }
}
