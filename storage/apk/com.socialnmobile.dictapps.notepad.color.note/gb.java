import android.content.pm.PackageInfo;
import android.content.Context;
import android.text.TextUtils;

// 
// Decompiled by Procyon v0.5.29
// 

public class gb
{
    private static final String a;
    private static String b;
    private static String c;
    
    static {
        a = gb.class.getSimpleName();
    }
    
    public static String a() {
        if (!TextUtils.isEmpty((CharSequence)gb.b)) {
            return gb.b;
        }
        if (!TextUtils.isEmpty((CharSequence)gb.c)) {
            return gb.c;
        }
        return gb.c = b();
    }
    
    public static void a(final String b) {
        gb.b = b;
    }
    
    private static String b() {
        try {
            final Context b = fq.a.b;
            final PackageInfo packageInfo = b.getPackageManager().getPackageInfo(b.getPackageName(), 0);
            if (packageInfo.versionName != null) {
                return packageInfo.versionName;
            }
            if (packageInfo.versionCode != 0) {
                return Integer.toString(packageInfo.versionCode);
            }
        }
        catch (Throwable t) {
            final String a = gb.a;
            gj.b("", t);
        }
        return "Unknown";
    }
}
