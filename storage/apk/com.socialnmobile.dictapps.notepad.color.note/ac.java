import android.os.SystemClock;
import java.util.concurrent.CountDownLatch;

// 
// Decompiled by Procyon v0.5.29
// 

final class ac extends ah implements Runnable
{
    Object a;
    boolean b;
    final /* synthetic */ ab c;
    private CountDownLatch e;
    
    ac(final ab c) {
        this.c = c;
        this.e = new CountDownLatch(1);
    }
    
    @Override
    protected final void a() {
        try {
            this.c.a(this, this.a);
        }
        finally {
            this.e.countDown();
        }
    }
    
    @Override
    protected final void a(final Object o) {
        while (true) {
            ab c = null;
            Label_0052: {
                try {
                    c = this.c;
                    if (c.a != this) {
                        c.a(this, o);
                    }
                    else {
                        if (!c.q) {
                            break Label_0052;
                        }
                        c.a(o);
                    }
                    return;
                }
                finally {
                    this.e.countDown();
                }
            }
            c.t = false;
            c.d = SystemClock.uptimeMillis();
            c.a = null;
            c.b(o);
        }
    }
    
    @Override
    public final void run() {
        this.b = false;
        this.c.c();
    }
}
