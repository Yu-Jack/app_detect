import android.os.Handler;

// 
// Decompiled by Procyon v0.5.29
// 

public final class abl implements abk
{
    final abk a;
    final Handler b;
    
    public abl(final abk a, final Handler b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void a() {
        this.b.post((Runnable)new abm(this));
    }
    
    @Override
    public final void b() {
        this.b.post((Runnable)new abn(this));
    }
}
