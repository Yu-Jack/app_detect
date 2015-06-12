import android.util.DisplayMetrics;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class gv
{
    public static int a(final Context context) {
        final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        final float density = displayMetrics.density;
        return Math.min((int)(displayMetrics.widthPixels / density), (int)(displayMetrics.heightPixels / density));
    }
    
    public static int b(final Context context) {
        final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int)(displayMetrics.widthPixels / displayMetrics.density);
    }
    
    public static int c(final Context context) {
        final int b = b(context);
        if (a(context) <= 400 && gw.b(context)) {
            return 2;
        }
        if (b < 400) {
            return 1;
        }
        return 3;
    }
    
    public static int d(final Context context) {
        return (int)(56.0f * context.getResources().getDisplayMetrics().density);
    }
}
