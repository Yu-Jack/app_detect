// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public final class c
{
    private String a;
    private Map b;
    private int c;
    
    private c(final String a, final Map b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public static c a(final Exception ex) {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("ex", ex.getClass().getSimpleName());
        hashMap.put("ex_msg", ex.getMessage());
        return new c("error", hashMap, (int)(System.currentTimeMillis() / 1000L));
    }
    
    public final JSONObject a() {
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", (Object)this.a);
            jsonObject.put("data", (Object)new JSONObject(this.b));
            jsonObject.put("time", this.c);
            return jsonObject;
        }
        catch (JSONException ex) {
            ex.printStackTrace();
            return jsonObject;
        }
    }
}
