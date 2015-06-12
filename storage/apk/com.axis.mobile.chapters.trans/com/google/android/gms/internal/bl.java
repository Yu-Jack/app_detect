// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import org.json.JSONArray;
import java.util.Collections;
import java.util.ArrayList;
import org.json.JSONObject;
import java.util.List;

public final class bl
{
    public final String nk;
    public final String nl;
    public final List nm;
    public final String nn;
    public final String no;
    public final List np;
    public final String nq;
    
    public bl(final JSONObject jsonObject) {
        this.nl = jsonObject.getString("id");
        final JSONArray jsonArray = jsonObject.getJSONArray("adapters");
        final ArrayList list = new ArrayList<String>(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); ++i) {
            list.add(jsonArray.getString(i));
        }
        this.nm = Collections.unmodifiableList((List<?>)list);
        this.nn = jsonObject.optString("allocation_id", (String)null);
        this.np = br.a(jsonObject, "imp_urls");
        final JSONObject optJSONObject = jsonObject.optJSONObject("ad");
        String string;
        if (optJSONObject != null) {
            string = optJSONObject.toString();
        }
        else {
            string = null;
        }
        this.nk = string;
        final JSONObject optJSONObject2 = jsonObject.optJSONObject("data");
        String string2;
        if (optJSONObject2 != null) {
            string2 = optJSONObject2.toString();
        }
        else {
            string2 = null;
        }
        this.nq = string2;
        String optString = null;
        if (optJSONObject2 != null) {
            optString = optJSONObject2.optString("class_name");
        }
        this.no = optString;
    }
}
