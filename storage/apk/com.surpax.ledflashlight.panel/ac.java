import android.os.Looper;
import java.util.ArrayList;
import android.os.Handler;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ac extends Thread
{
    private Handler a;
    private final ArrayList b;
    private final Object c;
    
    public ac(final Object c) {
        this.a = null;
        this.b = new ArrayList();
        this.c = c;
        this.start();
    }
    
    public static void a() {
        Looper.myLooper().quit();
    }
    
    public final void a(final Runnable runnable, final int n) {
        if (this.a == null) {
            this.b.add(new ad(runnable, n));
            return;
        }
        if (n > 0) {
            this.a.postDelayed(runnable, (long)n);
            return;
        }
        this.a.post(runnable);
    }
    
    @Override
    public final void run() {
        while (true) {
            Looper.prepare();
            while (true) {
                int index = 0;
                Label_0116: {
                    synchronized (this.c) {
                        this.a = new Handler();
                        final int size = this.b.size();
                        index = 0;
                        if (index < size) {
                            final ad ad = this.b.get(index);
                            if (ad.b > 0) {
                                this.a.postDelayed(ad.a, (long)ad.b);
                                break Label_0116;
                            }
                            this.a.post(ad.a);
                            break Label_0116;
                        }
                    }
                    break;
                }
                ++index;
                continue;
            }
        }
        this.b.clear();
        // monitorexit(o)
        Looper.loop();
    }
}
