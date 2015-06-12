import android.os.Handler;

// 
// Decompiled by Procyon v0.5.29
// 

public final class abs implements abr
{
    final Handler a;
    final abr b;
    
    public abs(final abr b, final Handler a) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void a() {
        this.a.post((Runnable)new abv(this));
    }
    
    @Override
    public final void a(final Exception ex) {
        this.a.post((Runnable)new abu(this, ex));
    }
    
    @Override
    public final void a(final Object o) {
        this.a.post((Runnable)new abt(this, o));
    }
}
