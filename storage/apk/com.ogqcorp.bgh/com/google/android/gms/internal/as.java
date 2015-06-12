// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Iterator;
import org.json.JSONArray;
import java.util.Collections;
import java.util.ArrayList;
import org.json.JSONObject;
import java.util.List;

public final class as
{
    public final List<ar> a;
    public final long b;
    public final List<String> c;
    public final List<String> d;
    public final List<String> e;
    public final String f;
    public final long g;
    public int h;
    public int i;
    
    public as(final String s) {
        final JSONObject jsonObject = new JSONObject(s);
        if (en.a(2)) {
            en.d("Mediation Response JSON: " + jsonObject.toString(2));
        }
        final JSONArray jsonArray = jsonObject.getJSONArray("ad_networks");
        final ArrayList list = new ArrayList<ar>(jsonArray.length());
        int h = -1;
        for (int i = 0; i < jsonArray.length(); ++i) {
            final ar ar = new ar(jsonArray.getJSONObject(i));
            list.add(ar);
            if (h < 0 && this.a(ar)) {
                h = i;
            }
        }
        this.h = h;
        this.i = jsonArray.length();
        this.a = Collections.unmodifiableList((List<? extends ar>)list);
        this.f = jsonObject.getString("qdata");
        final JSONObject optJSONObject = jsonObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.b = optJSONObject.optLong("ad_network_timeout_millis", -1L);
            this.c = az.a(optJSONObject, "click_urls");
            this.d = az.a(optJSONObject, "imp_urls");
            this.e = az.a(optJSONObject, "nofill_urls");
            final long optLong = optJSONObject.optLong("refresh", -1L);
            long g;
            if (optLong > 0L) {
                g = optLong * 1000L;
            }
            else {
                g = -1L;
            }
            this.g = g;
            return;
        }
        this.b = -1L;
        this.c = null;
        this.d = null;
        this.e = null;
        this.g = -1L;
    }
    
    private boolean a(final ar ar) {
        final Iterator<String> iterator = ar.c.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
