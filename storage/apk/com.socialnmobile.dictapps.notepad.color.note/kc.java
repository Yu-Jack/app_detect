import java.util.Iterator;
import org.json.JSONException;
import com.socialnmobile.colornote.ColorNote;
import org.json.JSONObject;

// 
// Decompiled by Procyon v0.5.29
// 

public final class kc extends ke
{
    JSONObject a;
    JSONObject b;
    
    public kc() {
        this.a();
    }
    
    private void a(final String s, final kd kd) {
        synchronized (this) {
            try {
                this.a.put(s, (Object)kd.a());
            }
            catch (JSONException ex) {
                ColorNote.a("JSON Exeption" + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
    
    private kd c(final String s) {
        synchronized (this) {
            if (!this.a.has(s)) {
                return null;
            }
            try {
                return new kd(this.a.getJSONObject(s));
            }
            catch (JSONException ex) {
                ColorNote.a("JSON Exeption" + ex.getMessage());
                ex.printStackTrace();
            }
            return null;
        }
    }
    
    public final void a() {
        try {
            this.a = new JSONObject();
            (this.b = new JSONObject()).put("T", 1);
            this.b.put("V", 1);
            this.b.put("D", (Object)this.a);
        }
        catch (JSONException ex) {
            ColorNote.a("JSON Exeption" + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public final void a(final long n, final long n2) {
        synchronized (this) {
            final Iterator keys = this.a.keys();
            while (keys.hasNext()) {
                this.a(keys.next(), n, n2);
            }
        }
    }
    
    public final void a(final String s, final long n, final long n2) {
        synchronized (this) {
            final kd c = this.c(s);
            if (c != null) {
                c.a(n, n2);
                this.a(s, c);
            }
        }
    }
    
    public final void a(final String s, final Object o, final long n, final long n2) {
        synchronized (this) {
            kd c = this.c(s);
            if (c != null) {
                c.a(o, n, n2);
            }
            else {
                c = new kd();
                c.a(o, n, n2);
            }
            this.a(s, c);
        }
    }
    
    public final boolean a(final String s) {
        synchronized (this) {
            final boolean has = this.a.has(s);
            boolean has2 = false;
            if (has) {
                try {
                    has2 = this.a.getJSONObject(s).has("V");
                }
                catch (JSONException ex) {
                    ColorNote.a("JSON Exeption" + ex.getMessage());
                    ex.printStackTrace();
                    has2 = false;
                }
            }
            return has2;
        }
    }
    
    public final Object b(final String s) {
        synchronized (this) {
            final boolean has = this.a.has(s);
            Object o = null;
            if (!has) {
                return o;
            }
            while (true) {
                try {
                    final Object opt = this.a.getJSONObject(s).opt("V");
                    final Object null = JSONObject.NULL;
                    o = null;
                    if (opt != null) {
                        o = opt;
                    }
                    return o;
                }
                catch (JSONException ex) {
                    ColorNote.a("JSON Exeption" + ex.getMessage());
                    ex.printStackTrace();
                    o = null;
                    return o;
                }
                return o;
            }
        }
    }
    
    public final boolean b() {
        synchronized (this) {
            final Iterator keys = this.a.keys();
            while (keys.hasNext()) {
                if (this.a(keys.next())) {
                    return false;
                }
            }
            return true;
        }
    }
}
