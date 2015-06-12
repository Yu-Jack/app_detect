import android.text.TextUtils;
import android.util.Log;

// 
// Decompiled by Procyon v0.5.29
// 

public final class gj
{
    private static int a;
    private static boolean b;
    private static int c;
    private static boolean d;
    
    static {
        gj.a = 4000;
        gj.b = false;
        gj.c = 5;
        gj.d = true;
    }
    
    public static void a() {
        gj.b = false;
    }
    
    public static void a(final int n, final String s) {
        c(n, s);
    }
    
    public static void a(final String s) {
        b(3, s);
    }
    
    public static void a(final String obj, final Throwable t) {
        b(6, String.valueOf(obj) + '\n' + Log.getStackTraceString(t));
    }
    
    public static int b() {
        return gj.c;
    }
    
    private static void b(final int n, final String s) {
        if (!gj.b && gj.c <= n) {
            d(n, s);
        }
    }
    
    public static void b(final String s) {
        b(6, s);
    }
    
    public static void b(final String obj, final Throwable t) {
        c(6, String.valueOf(obj) + '\n' + Log.getStackTraceString(t));
    }
    
    public static void c() {
        gj.c = 6;
    }
    
    private static void c(final int n, final String s) {
        if (gj.d) {
            d(n, s);
        }
    }
    
    private static void d(final int n, final String s) {
        if (!gj.b && gj.c <= n) {
            int length;
            if (TextUtils.isEmpty((CharSequence)s)) {
                length = 0;
            }
            else {
                length = s.length();
            }
            int endIndex;
            for (int i = 0; i < length; i = endIndex) {
                if (gj.a > length - i) {
                    endIndex = length;
                }
                else {
                    endIndex = i + gj.a;
                }
                if (Log.println(n, "FlurryAgent", s.substring(i, endIndex)) <= 0) {
                    break;
                }
            }
        }
    }
}
