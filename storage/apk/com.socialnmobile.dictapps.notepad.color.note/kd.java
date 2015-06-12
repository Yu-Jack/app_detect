import org.json.JSONException;
import com.socialnmobile.colornote.ColorNote;
import org.json.JSONObject;

// 
// Decompiled by Procyon v0.5.29
// 

final class kd implements Comparable
{
    int a;
    int b;
    long c;
    long d;
    boolean e;
    Object f;
    boolean g;
    Object h;
    
    kd() {
    }
    
    kd(final JSONObject jsonObject) {
        this.e = jsonObject.has("V");
        this.f = jsonObject.opt("V");
        this.g = jsonObject.has("O");
        this.h = jsonObject.opt("O");
        this.a = jsonObject.optInt("M");
        this.b = jsonObject.optInt("B");
        this.c = jsonObject.optLong("U");
        this.d = jsonObject.optLong("R");
    }
    
    final JSONObject a() {
        while (true) {
            final JSONObject jsonObject = new JSONObject();
            while (true) {
                Label_0145: {
                    try {
                        if (this.e) {
                            if (this.f == null) {
                                jsonObject.put("V", JSONObject.NULL);
                            }
                            else {
                                jsonObject.put("V", this.f);
                            }
                        }
                        if (this.g) {
                            if (this.h != null) {
                                break Label_0145;
                            }
                            jsonObject.put("O", JSONObject.NULL);
                        }
                        jsonObject.put("U", this.c);
                        jsonObject.put("R", this.d);
                        jsonObject.put("M", this.a);
                        jsonObject.put("B", this.b);
                        return jsonObject;
                    }
                    catch (JSONException ex) {
                        ColorNote.a("JSON Exeption" + ex.getMessage());
                        ex.printStackTrace();
                        return jsonObject;
                    }
                }
                jsonObject.put("O", this.h);
                continue;
            }
        }
    }
    
    final void a(final long c, final long d) {
        if (d > this.d) {
            this.h = this.f;
            this.g = this.e;
        }
        this.e = false;
        this.f = null;
        this.a = 1;
        this.b = 1;
        this.c = c;
        this.d = d;
    }
    
    final void a(final Object f, final long c, final long d) {
        if (d > this.d) {
            this.h = this.f;
            this.g = this.e;
        }
        this.e = true;
        this.f = f;
        this.a = 1;
        this.b = 1;
        this.c = c;
        this.d = d;
    }
}
