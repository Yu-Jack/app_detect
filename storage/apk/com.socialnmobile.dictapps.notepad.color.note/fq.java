import android.os.Looper;
import android.os.Handler;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class fq
{
    public static fq a;
    public final Context b;
    final Handler c;
    
    private fq(final Context context) {
        this.b = context.getApplicationContext();
        this.c = new Handler(Looper.getMainLooper());
    }
    
    public static void a(final Context context) {
        while (true) {
            synchronized (fq.class) {
                if (fq.a != null) {
                    return;
                }
                if (context == null) {
                    throw new IllegalArgumentException("Context cannot be null");
                }
            }
            fq.a = new fq(context);
        }
    }
}
