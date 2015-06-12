import android.os.Handler;

// 
// Decompiled by Procyon v0.5.29
// 

final class q implements Runnable
{
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ o c;
    
    q(final o c, final int a) {
        this.c = c;
        this.a = a;
        this.b = 1;
    }
    
    @Override
    public final void run() {
        final o c = this.c;
        final Handler a = this.c.o.a;
        c.a(this.a, this.b);
    }
}
