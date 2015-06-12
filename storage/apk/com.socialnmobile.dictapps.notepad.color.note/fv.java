import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageInfo;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class fv
{
    private static final String a;
    
    static {
        a = fv.class.getSimpleName();
    }
    
    public static String a(final Context context) {
        final PackageInfo b = b(context);
        if (b != null && b.packageName != null) {
            return b.packageName;
        }
        return "";
    }
    
    private static PackageInfo b(final Context context) {
        PackageInfo packageInfo = null;
        if (context == null) {
            return packageInfo;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 20815);
            return packageInfo;
        }
        catch (PackageManager$NameNotFoundException ex) {
            final String a = fv.a;
            gj.a("Cannot find package info for package: " + context.getPackageName());
            return null;
        }
    }
}
