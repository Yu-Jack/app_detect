import android.content.SharedPreferences$OnSharedPreferenceChangeListener;
import android.database.Cursor;
import org.json.JSONException;
import com.socialnmobile.colornote.ColorNote;
import org.json.JSONObject;
import android.content.ContentUris;
import android.net.Uri;
import android.content.Context;
import android.os.Handler;
import android.content.SharedPreferences;
import java.util.Set;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import android.content.SharedPreferences$Editor;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ks implements SharedPreferences$Editor
{
    final /* synthetic */ kr a;
    private final Map b;
    private boolean c;
    
    public ks(final kr a) {
        this.a = a;
        this.b = new HashMap();
        this.c = false;
    }
    
    public final void apply() {
        this.commit();
    }
    
    public final SharedPreferences$Editor clear() {
        synchronized (this) {
            this.c = true;
            return (SharedPreferences$Editor)this;
        }
    }
    
    public final boolean commit() {
        if (this.a.f == null) {
            kr.a(this.a, kg.a(this.a.d, 256, 256, 256, 3, this.a.e, ""));
        }
    Label_0116_Outer:
        while (true) {
            while (true) {
                final long currentTimeMillis;
                String s = null;
                V value = null;
                Label_0276: {
                    synchronized (this.a) {
                        currentTimeMillis = System.currentTimeMillis();
                        if (this.c) {
                            if (!this.a.a.b()) {
                                this.a.a.a(currentTimeMillis, this.a.h);
                            }
                            this.c = false;
                        }
                        for (final Map.Entry<String, V> entry : this.b.entrySet()) {
                            s = entry.getKey();
                            value = entry.getValue();
                            if (value != this) {
                                break Label_0276;
                            }
                            if (!this.a.a.a(s)) {
                                continue Label_0116_Outer;
                            }
                            this.a.a.a(s, currentTimeMillis, this.a.h);
                        }
                        this.b.clear();
                        // monitorexit(this.a)
                        kr.a(this.a, this.a.a.b.toString());
                        kg.a(this.a.d, this.a.f, 0, this.a.g, this.a.e, 3, 0, 0);
                        return true;
                    }
                }
                if (this.a.a.a(s)) {
                    final Object b = this.a.a.b(s);
                    if (b != null && b.equals(value)) {
                        continue;
                    }
                }
                this.a.a.a(s, value, currentTimeMillis, this.a.h);
                continue;
            }
        }
    }
    
    public final SharedPreferences$Editor putBoolean(final String s, final boolean b) {
        synchronized (this) {
            this.b.put(s, b);
            return (SharedPreferences$Editor)this;
        }
    }
    
    public final SharedPreferences$Editor putFloat(final String s, final float f) {
        synchronized (this) {
            this.b.put(s, f);
            return (SharedPreferences$Editor)this;
        }
    }
    
    public final SharedPreferences$Editor putInt(final String s, final int i) {
        synchronized (this) {
            this.b.put(s, i);
            return (SharedPreferences$Editor)this;
        }
    }
    
    public final SharedPreferences$Editor putLong(final String s, final long l) {
        synchronized (this) {
            this.b.put(s, l);
            return (SharedPreferences$Editor)this;
        }
    }
    
    public final SharedPreferences$Editor putString(final String s, final String s2) {
        synchronized (this) {
            this.b.put(s, s2);
            return (SharedPreferences$Editor)this;
        }
    }
    
    public final SharedPreferences$Editor putStringSet(final String s, final Set set) {
        synchronized (this) {
            this.b.put(s, set);
            return (SharedPreferences$Editor)this;
        }
    }
    
    public final SharedPreferences$Editor remove(final String s) {
        synchronized (this) {
            this.b.put(s, this);
            return (SharedPreferences$Editor)this;
        }
    }
}
