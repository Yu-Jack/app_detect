import android.content.SharedPreferences$OnSharedPreferenceChangeListener;
import java.util.Set;
import java.util.Map;
import android.content.SharedPreferences$Editor;
import android.database.Cursor;
import org.json.JSONException;
import com.socialnmobile.colornote.ColorNote;
import org.json.JSONObject;
import android.content.ContentUris;
import android.net.Uri;
import android.content.Context;
import android.os.Handler;
import java.util.HashMap;
import android.content.SharedPreferences;

// 
// Decompiled by Procyon v0.5.29
// 

public final class kr implements SharedPreferences
{
    private static final HashMap b;
    private static Handler c;
    kc a;
    private Context d;
    private String e;
    private Uri f;
    private String g;
    private long h;
    
    static {
        b = new HashMap();
    }
    
    private kr(final Context d, final String e) {
        this.a = new kc();
        this.d = d;
        this.e = e;
        final Cursor a = kg.a(d, e);
    Label_0237:
        while (true) {
        Label_0359:
            while (true) {
                Label_0245: {
                    Cursor a2 = null;
                    Label_0116: {
                        if (a.getCount() <= 1) {
                            a2 = a;
                            break Label_0116;
                        }
                        a.moveToNext();
                        final Uri withAppendedId = ContentUris.withAppendedId(kf.a, a.getLong(a.getColumnIndex("_id")));
                        final long long1 = a.getLong(a.getColumnIndex("revision"));
                        final Uri uri = withAppendedId;
                        if (a.moveToNext()) {
                            break Label_0245;
                        }
                        a.close();
                        a2 = kg.a(d, e);
                    }
                    if (!a2.moveToFirst()) {
                        break Label_0359;
                    }
                    this.f = ContentUris.withAppendedId(kf.a, a2.getLong(a2.getColumnIndex("_id")));
                    this.g = a2.getString(a2.getColumnIndex("note"));
                    this.h = a2.getLong(a2.getColumnIndex("revision"));
                    final kc a3 = this.a;
                    final String g = this.g;
                    try {
                        a3.b = new JSONObject(g);
                        a3.a = a3.b.getJSONObject("D");
                        a2.close();
                        return;
                        final Uri withAppendedId2 = ContentUris.withAppendedId(kf.a, a.getLong(a.getColumnIndex("_id")));
                        final long long2 = a.getLong(a.getColumnIndex("revision"));
                        // iftrue(Label_0304:, long1 >= long2)
                        Block_6: {
                            break Block_6;
                            Label_0304: {
                                final Uri uri;
                                kg.d(d, uri);
                            }
                            final long long1 = long2;
                            final Uri uri = withAppendedId2;
                            continue;
                        }
                        kg.d(d, withAppendedId2);
                        continue;
                    }
                    catch (JSONException ex) {
                        a3.a();
                        ColorNote.a("Load MergeableNote JSON Parse Error" + ex.getMessage());
                        ex.printStackTrace();
                        continue Label_0237;
                    }
                }
                break;
            }
            this.f = null;
            this.g = null;
            this.h = 0L;
            continue Label_0237;
        }
    }
    
    public static SharedPreferences a(final Context context, final String s) {
        synchronized (kr.b) {
            kr value = kr.b.get(s);
            if (value != null) {
                return (SharedPreferences)value;
            }
            if (value == null) {
                value = new kr(context, s);
                kr.b.put(s, value);
            }
            return (SharedPreferences)value;
        }
    }
    
    public static void a() {
        kr.b.clear();
    }
    
    public static void a(final Handler c) {
        kr.c = c;
    }
    
    public final boolean contains(final String s) {
        synchronized (this) {
            return this.a.a(s);
        }
    }
    
    public final SharedPreferences$Editor edit() {
        return (SharedPreferences$Editor)new ks(this);
    }
    
    public final Map getAll() {
        throw new RuntimeException("not support");
    }
    
    public final boolean getBoolean(final String s, boolean booleanValue) {
        synchronized (this) {
            final Boolean b = (Boolean)this.a.b(s);
            if (b != null) {
                booleanValue = b;
            }
            return booleanValue;
        }
    }
    
    public final float getFloat(final String s, float floatValue) {
        synchronized (this) {
            final Float n = (Float)this.a.b(s);
            if (n != null) {
                floatValue = n;
            }
            return floatValue;
        }
    }
    
    public final int getInt(final String s, int intValue) {
        synchronized (this) {
            final Integer n = (Integer)this.a.b(s);
            if (n != null) {
                intValue = n;
            }
            return intValue;
        }
    }
    
    public final long getLong(final String s, long longValue) {
        synchronized (this) {
            final Long n = (Long)this.a.b(s);
            if (n != null) {
                longValue = n;
            }
            return longValue;
        }
    }
    
    public final String getString(final String s, final String s2) {
        synchronized (this) {
            String s3 = (String)this.a.b(s);
            if (s3 == null) {
                s3 = s2;
            }
            return s3;
        }
    }
    
    public final Set getStringSet(final String s, final Set set) {
        synchronized (this) {
            Set set2 = (Set)this.a.b(s);
            if (set2 == null) {
                set2 = set;
            }
            return set2;
        }
    }
    
    public final void registerOnSharedPreferenceChangeListener(final SharedPreferences$OnSharedPreferenceChangeListener sharedPreferences$OnSharedPreferenceChangeListener) {
        throw new RuntimeException("not supports");
    }
    
    public final void unregisterOnSharedPreferenceChangeListener(final SharedPreferences$OnSharedPreferenceChangeListener sharedPreferences$OnSharedPreferenceChangeListener) {
        throw new RuntimeException("not supports");
    }
}
