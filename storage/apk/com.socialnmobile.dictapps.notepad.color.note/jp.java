import android.os.Build;
import android.os.Build$VERSION;
import java.util.Locale;
import android.content.SharedPreferences;
import android.content.Intent;
import android.content.SharedPreferences$Editor;
import android.preference.PreferenceManager;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class jp
{
    private static int a;
    
    public static int a(final Context context, final String s, final int n) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(s, n);
    }
    
    public static long a(final Context context, final String s) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(s, 0L);
    }
    
    public static String a(final Context context, final String s, final String s2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(s, s2);
    }
    
    public static void a(final Context context) {
        final SharedPreferences$Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.remove("BACKUP_SECRET_KEY");
        edit.remove("BACKUP_ENCRYPTED_DATA");
        edit.remove("CRYPTO_ENCRYPTED_USER_KEY");
        edit.remove("PREF_LAST_AUTO_SYNC_TIME");
        edit.remove("LAST_SYNC_TIME_MILLIS");
        edit.remove("LAST_SYNC_CHECKOUT_TIME_MILLIS");
        edit.remove("SYNC_ERROR_TIME_MILLIS");
        edit.remove("PREF_LAST_AUTO_SDBACKUP_TIME");
        edit.remove("PREF_RESERVED_AUTO_SYNC_TIME");
        edit.remove("SYNC_ERROR_MESSAGE");
        edit.remove("SYNC_ERROR_EXCEPTION_NAME");
        edit.remove("SYNC_ERROR_EXCEPTION_MSG");
        edit.remove("SYNC_NOTE_COUNT");
        edit.commit();
    }
    
    public static void a(final Context context, final long n, final Exception ex) {
        final SharedPreferences$Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        final String a = gt.a(context, ex);
        final String simpleName = ex.getClass().getSimpleName();
        final String message = ex.getMessage();
        edit.putLong("SYNC_ERROR_TIME_MILLIS", n);
        edit.putString("SYNC_ERROR_MESSAGE", a);
        edit.putString("SYNC_ERROR_EXCEPTION_NAME", simpleName);
        edit.putString("SYNC_ERROR_EXCEPTION_MSG", message);
        edit.commit();
    }
    
    public static void a(final Context context, final boolean b) {
        final SharedPreferences$Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("pref_use_colordict_in_editor", b);
        edit.commit();
    }
    
    public static boolean a(final Context context, final String s, final boolean b) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(s, b);
    }
    
    public static int b(final Context context) {
        return Integer.valueOf(a(context, "pref_list_item_height", context.getString(2131230723)));
    }
    
    private static void b(final Context context, final String s, final String s2) {
        final SharedPreferences$Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(s, s2);
        edit.commit();
    }
    
    public static void c(final Context context) {
        final int b = b(context);
        if (b == 2) {
            jp.a = context.getResources().getDimensionPixelSize(2131361822);
            return;
        }
        if (b == 1) {
            jp.a = context.getResources().getDimensionPixelSize(2131361823);
            return;
        }
        jp.a = context.getResources().getDimensionPixelSize(2131361824);
    }
    
    public static int d(final Context context) {
        if (jp.a == 0) {
            c(context);
        }
        return jp.a;
    }
    
    public static boolean e(final Context context) {
        final SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (defaultSharedPreferences.contains("pref_use_colordict_in_editor")) {
            return defaultSharedPreferences.getBoolean("pref_use_colordict_in_editor", context.getResources().getBoolean(2131296259));
        }
        final Intent intent = new Intent("android.intent.action.VIEW");
        intent.setClassName("com.socialnmobile.colordict", "com.socialnmobile.colordict.activity.Main");
        if (gw.a(context, intent) && defaultSharedPreferences.getBoolean("pref_use_colordict", false)) {
            a(context, true);
            return true;
        }
        a(context, false);
        return false;
    }
    
    public static int f(final Context context) {
        return Integer.valueOf(a(context, "pref_default_screen", context.getString(2131230721)));
    }
    
    public static int g(final Context context) {
        return Integer.valueOf(a(context, "pref_default_font_size", context.getString(2131230720)));
    }
    
    public static String h(final Context context) {
        return a(context, "PREF_THEME", "COLORTABLE/DEFAULT");
    }
    
    public static String i(final Context context) {
        String a = a(context, "pref_show_lunar_date_str", null);
        if (a == null) {
            if (Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) || Locale.getDefault().getCountry().equals(Locale.KOREA.getCountry())) {
                a = "KR";
            }
            else {
                if (Locale.CHINA.getCountry().equals(Locale.getDefault().getCountry().toUpperCase())) {
                    return "CN";
                }
                return "";
            }
        }
        return a;
    }
    
    public static String j(final Context context) {
        if ("KR".equals(i(context))) {
            return "KR";
        }
        return "CN";
    }
    
    public static int k(final Context context) {
        return Integer.parseInt(a(context, "pref_widget_transparency", context.getString(2131230725)), 16);
    }
    
    public static long l(final Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("SYNC_ERROR_TIME_MILLIS", 0L);
    }
    
    public static boolean m(final Context context) {
        return l(context) > a(context, "LAST_SYNC_TIME_MILLIS");
    }
    
    public static boolean n(final Context context) {
        return a(context, "pref_sync_on_launch", context.getResources().getBoolean(2131296267));
    }
    
    public static boolean o(final Context context) {
        return a(context, "pref_auto_sort_by_status", context.getResources().getBoolean(2131296268));
    }
    
    public static int p(final Context context) {
        int intValue = 1;
        if (jn.c()) {
            if (Build$VERSION.SDK_INT == 15 && Build.BRAND.equals("NOOK")) {
                if (!PreferenceManager.getDefaultSharedPreferences(context).contains("pref_base_style")) {
                    b(context, "pref_base_style", "2");
                }
            }
            else if (Build$VERSION.SDK_INT >= 21 && intValue && !a(context, "pref_v21_base_style_set", false)) {
                final SharedPreferences$Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
                edit.putBoolean("pref_v21_base_style_set", (boolean)(intValue != 0));
                edit.commit();
                b(context, "pref_base_style", "2");
            }
            intValue = Integer.valueOf(a(context, "pref_base_style", context.getString(2131230727)));
        }
        return intValue;
    }
    
    public static boolean q(final Context context) {
        return a(context, "pref_gpu_rendering", context.getResources().getBoolean(2131296269));
    }
}
