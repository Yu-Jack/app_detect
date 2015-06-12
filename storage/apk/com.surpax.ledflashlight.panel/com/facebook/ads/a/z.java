// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a;

import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Collection;
import com.facebook.ads.o;
import com.facebook.ads.n;
import android.net.Uri;

public class z implements e
{
    private static final String a;
    private final Uri b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final n g;
    private final n h;
    private final o i;
    private final String j;
    private final String k;
    private final h l;
    private final Collection m;
    
    static {
        a = z.class.getSimpleName();
    }
    
    private z(final Uri b, final String c, final String d, final String e, final String f, final n g, final n h, final o i, final String j, final String k, final h l, final Collection m) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;
        this.m = m;
    }
    
    public static z a(final JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        final Uri parse = Uri.parse(jsonObject.optString("fbad_command"));
        final String optString = jsonObject.optString("title");
        final String optString2 = jsonObject.optString("body");
        final String optString3 = jsonObject.optString("call_to_action");
        final String optString4 = jsonObject.optString("social_context");
        final n a = n.a(jsonObject.optJSONObject("icon"));
        final n a2 = n.a(jsonObject.optJSONObject("image"));
        final o a3 = o.a(jsonObject.optJSONObject("star_rating"));
        final String optString5 = jsonObject.optString("impression_report_url");
        final String optString6 = jsonObject.optString("click_report_url");
        final h a4 = h.a(jsonObject.optString("invalidation_behavior"));
        try {
            final JSONArray jsonArray = new JSONArray(jsonObject.optString("detection_strings"));
            return new z(parse, optString, optString2, optString3, optString4, a, a2, a3, optString5, optString6, a4, i.a(jsonArray));
        }
        catch (JSONException ex) {
            ex.printStackTrace();
            final JSONArray jsonArray = null;
            return new z(parse, optString, optString2, optString3, optString4, a, a2, a3, optString5, optString6, a4, i.a(jsonArray));
        }
    }
    
    @Override
    public final h a() {
        return this.l;
    }
    
    @Override
    public final Collection b() {
        return this.m;
    }
}
