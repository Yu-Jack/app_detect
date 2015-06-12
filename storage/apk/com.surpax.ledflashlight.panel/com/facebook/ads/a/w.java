// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a;

import org.json.JSONArray;
import java.util.ArrayList;
import org.json.JSONObject;
import java.util.List;

public final class w
{
    private final String a;
    private final String b;
    private final String c;
    private final List d;
    private final String e;
    private final String f;
    
    private w(final String a, final String b, final String c, final List d, final String e, final String f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public static w a(final JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        final String optString = jsonObject.optString("package");
        final String optString2 = jsonObject.optString("appsite");
        final String optString3 = jsonObject.optString("appsite_url");
        final JSONArray optJSONArray = jsonObject.optJSONArray("key_hashes");
        final ArrayList<String> list = new ArrayList<String>();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); ++i) {
                list.add(optJSONArray.optString(i));
            }
        }
        return new w(optString, optString2, optString3, list, jsonObject.optString("market_uri"), jsonObject.optString("fallback_url"));
    }
    
    public final String a() {
        return this.a;
    }
    
    public final String b() {
        return this.b;
    }
    
    public final String c() {
        return this.c;
    }
}
