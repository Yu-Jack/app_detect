import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.Context;
import android.os.Build;
import android.os.Build$VERSION;

// 
// Decompiled by Procyon v0.5.29
// 

public final class wk
{
    public static final String a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final String f;
    
    static {
        a = "Android/" + Build$VERSION.RELEASE;
        b = "Android-api/" + Build$VERSION.SDK_INT;
        c = "Brand/" + Build.BRAND;
        d = "Model/" + Build.MODEL;
        e = "Manufacturer/" + Build.MANUFACTURER;
        f = String.valueOf(Build$VERSION.CODENAME) + "/" + Build$VERSION.INCREMENTAL;
    }
    
    public static String a(final Context context) {
        final PackageManager packageManager = context.getPackageManager();
        try {
            final PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return String.valueOf(packageInfo.versionName) + "-" + packageInfo.versionCode;
        }
        catch (PackageManager$NameNotFoundException ex) {
            ex.printStackTrace();
            return "UNKNOWN";
        }
    }
    
    public static String a(final String str) {
        return String.valueOf(new StringBuilder("ColorNote/").append(str).toString()) + " " + wk.b + " " + wk.a + " " + wk.f + " " + wk.c + " " + wk.d + " " + wk.e;
    }
}
