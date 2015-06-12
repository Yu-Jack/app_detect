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

public final class bm
{
    public final List nr;
    public final long ns;
    public final List nt;
    public final List nu;
    public final List nv;
    public final String nw;
    public final long nx;
    public int ny;
    public int nz;
    
    public bm(final String s) {
        final JSONObject jsonObject = new JSONObject(s);
        if (eu.p(2)) {
            eu.C("Mediation Response JSON: " + jsonObject.toString(2));
        }
        final JSONArray jsonArray = jsonObject.getJSONArray("ad_networks");
        final ArrayList list = new ArrayList<bl>(jsonArray.length());
        int ny = -1;
        for (int i = 0; i < jsonArray.length(); ++i) {
            final bl bl = new bl(jsonArray.getJSONObject(i));
            list.add(bl);
            if (ny < 0 && this.a(bl)) {
                ny = i;
            }
        }
        this.ny = ny;
        this.nz = jsonArray.length();
        this.nr = Collections.unmodifiableList((List<?>)list);
        this.nw = jsonObject.getString("qdata");
        final JSONObject optJSONObject = jsonObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.ns = optJSONObject.optLong("ad_network_timeout_millis", -1L);
            this.nt = br.a(optJSONObject, "click_urls");
            this.nu = br.a(optJSONObject, "imp_urls");
            this.nv = br.a(optJSONObject, "nofill_urls");
            final long optLong = optJSONObject.optLong("refresh", -1L);
            long nx;
            if (optLong > 0L) {
                nx = optLong * 1000L;
            }
            else {
                nx = -1L;
            }
            this.nx = nx;
            return;
        }
        this.ns = -1L;
        this.nt = null;
        this.nu = null;
        this.nv = null;
        this.nx = -1L;
    }
    
    private boolean a(final bl bl) {
        final Iterator<String> iterator = bl.nm.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
