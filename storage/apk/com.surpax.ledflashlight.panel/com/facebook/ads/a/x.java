// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a;

import java.util.HashMap;
import java.util.Map;
import android.content.Intent;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;
import android.os.Bundle;
import java.util.Collection;

public final class x implements e
{
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final h e;
    private final Collection f;
    
    private x(final String a, final String b, final String c, final String d, final h e, final Collection f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public static x a(final Bundle bundle) {
        return new x(bundle.getString("markup"), null, bundle.getString("activation_command"), null, h.a, null);
    }
    
    public static x a(final JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        final String optString = jsonObject.optString("markup");
        final String optString2 = jsonObject.optString("secondary_markup");
        final String optString3 = jsonObject.optString("activation_command");
        final String optString4 = jsonObject.optString("secondary_activation_command");
        final h a = h.a(jsonObject.optString("invalidation_behavior"));
        try {
            final JSONArray jsonArray = new JSONArray(jsonObject.optString("detection_strings"));
            return new x(optString, optString2, optString3, optString4, a, i.a(jsonArray));
        }
        catch (JSONException ex) {
            ex.printStackTrace();
            final JSONArray jsonArray = null;
            return new x(optString, optString2, optString3, optString4, a, i.a(jsonArray));
        }
    }
    
    public static x b(final Intent intent) {
        return new x(intent.getStringExtra("markup"), null, intent.getStringExtra("activation_command"), null, h.a, null);
    }
    
    @Override
    public final h a() {
        return this.e;
    }
    
    public final void a(final Intent intent) {
        intent.putExtra("markup", this.a);
        intent.putExtra("activation_command", this.c);
    }
    
    @Override
    public final Collection b() {
        return this.f;
    }
    
    public final String c() {
        return this.a;
    }
    
    public final String d() {
        return this.c;
    }
    
    public final Bundle e() {
        final Bundle bundle = new Bundle();
        bundle.putString("markup", this.a);
        return bundle;
    }
    
    public final Map f() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("markup", this.b);
        hashMap.put("activation_command", this.d);
        return hashMap;
    }
}
