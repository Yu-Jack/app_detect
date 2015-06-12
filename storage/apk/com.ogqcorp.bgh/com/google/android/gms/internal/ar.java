// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import org.json.JSONArray;
import java.util.Collections;
import java.util.ArrayList;
import org.json.JSONObject;
import java.util.List;

public final class ar
{
    public final String a;
    public final String b;
    public final List<String> c;
    public final String d;
    public final List<String> e;
    public final String f;
    
    public ar(final JSONObject jsonObject) {
        this.b = jsonObject.getString("id");
        final JSONArray jsonArray = jsonObject.getJSONArray("adapters");
        final ArrayList list = new ArrayList<String>(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); ++i) {
            list.add(jsonArray.getString(i));
        }
        this.c = Collections.unmodifiableList((List<? extends String>)list);
        this.d = jsonObject.optString("allocation_id", (String)null);
        this.e = az.a(jsonObject, "imp_urls");
        final JSONObject optJSONObject = jsonObject.optJSONObject("ad");
        String string;
        if (optJSONObject != null) {
            string = optJSONObject.toString();
        }
        else {
            string = null;
        }
        this.a = string;
        final JSONObject optJSONObject2 = jsonObject.optJSONObject("data");
        String string2 = null;
        if (optJSONObject2 != null) {
            string2 = optJSONObject2.toString();
        }
        this.f = string2;
    }
}
