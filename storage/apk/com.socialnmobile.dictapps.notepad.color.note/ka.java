import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ka
{
    private static ka b;
    public kb a;
    private Context c;
    
    public static ka a(final Context context) {
        if (ka.b == null) {
            final ka ka = ka.b = new ka();
            final Context applicationContext = context.getApplicationContext();
            ka.c = applicationContext;
            ka.a = new kb(applicationContext);
        }
        return ka.b;
    }
}
