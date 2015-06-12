import android.content.SharedPreferences;
import java.security.GeneralSecurityException;
import android.content.SharedPreferences$Editor;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class jq
{
    public static String a(final Context context, final int i, final int j) {
        if (i == -1) {
            return "";
        }
        return kr.a(context, "name_label_" + i).getString("USER_COLOR_LABEL" + j, "");
    }
    
    public static void a(final Context context, final int i, final int j, final String s) {
        final SharedPreferences$Editor edit = kr.a(context, "name_label_" + i).edit();
        edit.putString("USER_COLOR_LABEL" + j, s);
        edit.commit();
    }
    
    public static boolean a(final Context context) {
        final String b = b(context);
        final String e = e(context);
        return b != null && e != null;
    }
    
    public static boolean a(final Context context, final String s) {
        final String e = e(context);
        final String b = b(context);
        final jz b2 = jz.b(30);
        b2.a(s);
        b2.c(2);
        try {
            if (b2.d(e).equals(b)) {
                return true;
            }
        }
        catch (GeneralSecurityException ex) {}
        return false;
    }
    
    public static String b(final Context context) {
        final SharedPreferences a = kr.a(context, "name_master_password");
        final String string = a.getString("BACKUP_SECRET_KEY", (String)null);
        if (string == null) {
            final String a2 = jp.a(context, "BACKUP_SECRET_KEY", null);
            final String a3 = jp.a(context, "BACKUP_ENCRYPTED_DATA", null);
            if (a2 != null && a3 != null) {
                final SharedPreferences$Editor edit = a.edit();
                edit.putString("BACKUP_SECRET_KEY", a2);
                edit.putString("BACKUP_ENCRYPTED_DATA", a3);
                edit.commit();
                return a2;
            }
        }
        return string;
    }
    
    public static String c(final Context context) {
        final SharedPreferences a = kr.a(context, "name_master_password");
        final String b = b(context);
        String d = null;
        if (b == null) {
            return d;
        }
        final jz b2 = jz.b(30);
        b2.b(b);
        final String string = a.getString("CRYPTO_ENCRYPTED_USER_KEY", (String)null);
        b2.c(2);
        try {
            d = b2.d(string);
            return d;
        }
        catch (GeneralSecurityException ex) {
            return null;
        }
    }
    
    public static boolean d(final Context context) {
        return kr.a(context, "name_master_password").getString("CRYPTO_ENCRYPTED_USER_KEY", (String)null) != null;
    }
    
    private static String e(final Context context) {
        final SharedPreferences a = kr.a(context, "name_master_password");
        final String string = a.getString("BACKUP_ENCRYPTED_DATA", (String)null);
        if (string == null) {
            final String a2 = jp.a(context, "BACKUP_SECRET_KEY", null);
            final String a3 = jp.a(context, "BACKUP_ENCRYPTED_DATA", null);
            if (a2 != null && a3 != null) {
                final SharedPreferences$Editor edit = a.edit();
                edit.putString("BACKUP_SECRET_KEY", a2);
                edit.putString("BACKUP_ENCRYPTED_DATA", a3);
                edit.commit();
                return a3;
            }
        }
        return string;
    }
}
