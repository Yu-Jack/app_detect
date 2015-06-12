import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class jo
{
    public static int a(final Context context, final String s) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences("INTERNAL_PREF", 0);
        if (sharedPreferences.contains(s)) {
            return sharedPreferences.getInt(s, 0);
        }
        return jp.a(context, s, 0);
    }
    
    public static to a(final Context context) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences("INTERNAL_PREF", 0);
        Label_0050: {
            if (!sharedPreferences.contains("CLIENT_RELEASES")) {
                break Label_0050;
            }
            String s = sharedPreferences.getString("CLIENT_RELEASES", (String)null);
            while (true) {
                final tp tp = new tp();
                try {
                    return (to)tp.d(s);
                    s = jp.a(context, "CLIENT_RELEASES", null);
                }
                catch (ux ux) {
                    return null;
                }
            }
        }
    }
    
    public static void a(final Context context, final String s, final int n) {
        final SharedPreferences$Editor edit = context.getSharedPreferences("INTERNAL_PREF", 0).edit();
        edit.putInt(s, n);
        edit.commit();
    }
    
    public static void a(final Context context, final String s, final long n) {
        final SharedPreferences$Editor edit = context.getSharedPreferences("INTERNAL_PREF", 0).edit();
        edit.putLong(s, n);
        edit.commit();
    }
    
    public static void a(final Context context, final to to) {
        final SharedPreferences$Editor edit = context.getSharedPreferences("INTERNAL_PREF", 0).edit();
        edit.putString("CLIENT_RELEASES", (String)new tp().c(to));
        edit.putLong("CLIENT_RELEASES_SAVE_TIME", System.currentTimeMillis());
        edit.commit();
    }
    
    public static long b(final Context context, final String s) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences("INTERNAL_PREF", 0);
        if (sharedPreferences.contains(s)) {
            return sharedPreferences.getLong(s, 0L);
        }
        return jp.a(context, s);
    }
    
    public static boolean b(final Context context) {
        return a(context, "WIPE_OUT_MARK") == 1;
    }
}
