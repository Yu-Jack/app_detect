import java.util.HashMap;
import android.content.SharedPreferences;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class rz extends adg
{
    final Context a;
    
    public rz(final Context a) {
        this.a = a;
    }
    
    private vc a(final long lng) {
        final SharedPreferences sharedPreferences = this.a.getSharedPreferences("Account-" + lng + ".prefs", 0);
        if (sharedPreferences == null) {
            return null;
        }
        try {
            return new vc((byte[])adb.b.d(sharedPreferences.getString("key128", (String)null)), (byte[])adb.b.d(sharedPreferences.getString("key256", (String)null)));
        }
        catch (Exception ex) {
            return null;
        }
    }
}
