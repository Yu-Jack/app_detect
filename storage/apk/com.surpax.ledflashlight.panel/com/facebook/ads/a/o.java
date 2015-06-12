// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a;

import org.json.JSONArray;
import java.util.ArrayList;
import org.json.JSONObject;
import android.content.Context;
import com.facebook.ads.b;
import java.util.List;

public final class o
{
    private final int a;
    private final int b;
    private final int c;
    private final List d;
    private final b e;
    
    private o(final int a, final int b, final int c, final List d, final b e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public static o a(final Context context, final JSONObject jsonObject) {
        final int n = 1000 * jsonObject.optInt("refresh", 0);
        final int n2 = 1000 * jsonObject.optInt("refresh_threshold", 20);
        final int optInt = jsonObject.optInt("min_viewability_percentage", 10);
        final JSONObject optJSONObject = jsonObject.optJSONObject("reason");
        b b;
        if (optJSONObject != null) {
            b = new b(optJSONObject.optInt("code"), optJSONObject.optString("message"));
        }
        else {
            b = null;
        }
        final int optInt2 = jsonObject.optInt("ad_type");
        final ArrayList<x> list = new ArrayList<x>();
        final JSONArray optJSONArray = jsonObject.optJSONArray("ads");
        Label_0250: {
            if (optJSONArray == null) {
                break Label_0250;
            }
            final int length = optJSONArray.length();
            int i = 0;
            if (length <= 0) {
                break Label_0250;
            }
            while (i < optJSONArray.length()) {
                final JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    e e;
                    if (optInt2 == q.a.a()) {
                        e = x.a(optJSONObject2.optJSONObject("data"));
                    }
                    else if (optInt2 == q.b.a()) {
                        e = z.a(optJSONObject2.optJSONObject("metadata"));
                    }
                    else {
                        e = null;
                    }
                    if (e != null && !com.facebook.ads.a.i.a(context, e)) {
                        list.add((x)e);
                    }
                }
                ++i;
            }
            if (!list.isEmpty()) {
                break Label_0250;
            }
            final b a = com.facebook.ads.b.a;
            return new o(n, n2, optInt, list, a);
        }
        final b a = b;
        return new o(n, n2, optInt, list, a);
    }
    
    public final int a() {
        return this.a;
    }
    
    public final int b() {
        return this.b;
    }
    
    public final int c() {
        return this.c;
    }
    
    public final e d() {
        if (this.d == null || this.d.isEmpty()) {
            return null;
        }
        return this.d.get(0);
    }
    
    public final b e() {
        return this.e;
    }
}
