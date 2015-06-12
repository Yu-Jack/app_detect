// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Locale;
import android.os.Bundle;
import android.graphics.Color;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import android.location.Location;
import org.json.JSONArray;
import java.util.List;
import org.json.JSONException;
import java.util.LinkedList;
import android.text.TextUtils;
import org.json.JSONObject;
import android.content.Context;
import java.text.SimpleDateFormat;

public final class dy
{
    private static final SimpleDateFormat qA;
    
    static {
        qA = new SimpleDateFormat("yyyyMMdd");
    }
    
    public static du a(final Context context, final ds ds, final String s) {
        JSONObject jsonObject = null;
        String s2 = null;
        String optString2 = null;
        String s3 = null;
        long qk = 0L;
        String optString3 = null;
        long qf = 0L;
        int n = 0;
        du du = null;
        List<String> list = null;
    Label_0244_Outer:
        while (true) {
            List<String> nt = null;
            Label_0629: {
                while (true) {
                Label_0650:
                    while (true) {
                        Label_0642: {
                            while (true) {
                                Label_0636: {
                                    while (true) {
                                        Label_0330: {
                                            try {
                                                jsonObject = new JSONObject(s);
                                                s2 = jsonObject.optString("ad_base_url", (String)null);
                                                final String optString = jsonObject.optString("ad_url", (String)null);
                                                optString2 = jsonObject.optString("ad_size", (String)null);
                                                s3 = jsonObject.optString("ad_html", (String)null);
                                                qk = -1L;
                                                optString3 = jsonObject.optString("debug_dialog", (String)null);
                                                if (!jsonObject.has("interstitial_timeout")) {
                                                    break Label_0642;
                                                }
                                                qf = (long)(1000.0 * jsonObject.getDouble("interstitial_timeout"));
                                                final String optString4 = jsonObject.optString("orientation", (String)null);
                                                n = -1;
                                                if ("portrait".equals(optString4)) {
                                                    n = eo.bS();
                                                }
                                                else if ("landscape".equals(optString4)) {
                                                    n = eo.bR();
                                                }
                                                final JSONArray optJSONArray;
                                                if (!TextUtils.isEmpty((CharSequence)s3)) {
                                                    if (TextUtils.isEmpty((CharSequence)s2)) {
                                                        eu.D("Could not parse the mediation config: Missing required ad_base_url field");
                                                        return new du(0);
                                                    }
                                                    break Label_0636;
                                                }
                                                else {
                                                    if (TextUtils.isEmpty((CharSequence)optString)) {
                                                        eu.D("Could not parse the mediation config: Missing required ad_html or ad_url field.");
                                                        return new du(0);
                                                    }
                                                    final du a = dx.a(context, ds.kQ.sw, optString, null, null);
                                                    s2 = a.oA;
                                                    s3 = a.qe;
                                                    qk = a.qk;
                                                    du = a;
                                                    optJSONArray = jsonObject.optJSONArray("click_urls");
                                                    if (du != null) {
                                                        break Label_0330;
                                                    }
                                                    nt = null;
                                                    if (optJSONArray == null) {
                                                        break Label_0629;
                                                    }
                                                    if (nt == null) {
                                                        nt = new LinkedList<String>();
                                                    }
                                                    break Label_0650;
                                                }
                                                while (true) {
                                                    int n2 = 0;
                                                    nt.add(optJSONArray.getString(n2));
                                                    ++n2;
                                                    continue Label_0244_Outer;
                                                }
                                            }
                                            // iftrue(Label_0656:, n2 >= optJSONArray.length())
                                            catch (JSONException ex) {
                                                eu.D("Could not parse the mediation config: " + ex.getMessage());
                                                return new du(0);
                                            }
                                        }
                                        nt = (List<String>)du.nt;
                                        continue Label_0244_Outer;
                                    }
                                }
                                du = null;
                                continue Label_0244_Outer;
                            }
                        }
                        qf = -1L;
                        continue Label_0244_Outer;
                    }
                    int n2 = 0;
                    continue;
                }
            }
            list = nt;
            break;
            Label_0656: {
                list = nt;
            }
            break;
        }
        final JSONArray optJSONArray2 = jsonObject.optJSONArray("impression_urls");
        List<String> nu;
        if (du == null) {
            nu = null;
        }
        else {
            nu = (List<String>)du.nu;
        }
        List<String> list2;
        if (optJSONArray2 != null) {
            if (nu == null) {
                nu = new LinkedList<String>();
            }
            for (int i = 0; i < optJSONArray2.length(); ++i) {
                nu.add(optJSONArray2.getString(i));
            }
            list2 = nu;
        }
        else {
            list2 = nu;
        }
        final JSONArray optJSONArray3 = jsonObject.optJSONArray("manual_impression_urls");
        List<String> qi;
        if (du == null) {
            qi = null;
        }
        else {
            qi = (List<String>)du.qi;
        }
        List<String> list3;
        if (optJSONArray3 != null) {
            if (qi == null) {
                qi = new LinkedList<String>();
            }
            for (int j = 0; j < optJSONArray3.length(); ++j) {
                qi.add(optJSONArray3.getString(j));
            }
            list3 = qi;
        }
        else {
            list3 = qi;
        }
        if (du != null) {
            if (du.orientation != -1) {
                n = du.orientation;
            }
            if (du.qf > 0L) {
                qf = du.qf;
            }
        }
        final String optString5 = jsonObject.optString("active_view");
        final boolean optBoolean = jsonObject.optBoolean("ad_is_javascript", false);
        String optString6 = null;
        if (optBoolean) {
            optString6 = jsonObject.optString("ad_passback_url", (String)null);
        }
        return new du(s2, s3, list, list2, qf, false, -1L, list3, -1L, n, optString2, qk, optString3, optBoolean, optString6, optString5);
    }
    
    public static String a(final ds ds, final ec ec, final Location location, final String value) {
        try {
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            if (value != null && value.trim() != "") {
                hashMap.put("eid", value);
            }
            if (ds.pW != null) {
                hashMap.put("ad_pos", (String)ds.pW);
            }
            a(hashMap, ds.pX);
            hashMap.put("format", ds.kT.me);
            if (ds.kT.width == -1) {
                hashMap.put("smart_w", "full");
            }
            if (ds.kT.height == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (ds.kT.mg != null) {
                final StringBuilder value2 = new StringBuilder();
                for (final al al : ds.kT.mg) {
                    if (value2.length() != 0) {
                        value2.append("|");
                    }
                    int width;
                    if (al.width == -1) {
                        width = (int)(al.widthPixels / ec.rr);
                    }
                    else {
                        width = al.width;
                    }
                    value2.append(width);
                    value2.append("x");
                    int height;
                    if (al.height == -2) {
                        height = (int)(al.heightPixels / ec.rr);
                    }
                    else {
                        height = al.height;
                    }
                    value2.append(height);
                }
                hashMap.put("sz", (String)value2);
            }
            hashMap.put("slotname", ds.kN);
            hashMap.put("pn", ds.applicationInfo.packageName);
            if (ds.pY != null) {
                hashMap.put("vc", (String)ds.pY.versionCode);
            }
            hashMap.put("ms", ds.pZ);
            hashMap.put("ms2", ds.qd);
            hashMap.put("seq_num", ds.qa);
            hashMap.put("session_id", ds.qb);
            hashMap.put("js", ds.kQ.sw);
            a(hashMap, ec);
            if (ds.pX.versionCode >= 2 && ds.pX.ma != null) {
                a(hashMap, ds.pX.ma);
            }
            if (ds.versionCode >= 2) {
                hashMap.put("quality_signals", (String)ds.qc);
            }
            if (eu.p(2)) {
                eu.C("Ad Request JSON: " + eo.o(hashMap).toString(2));
            }
            return eo.o(hashMap).toString();
        }
        catch (JSONException ex) {
            eu.D("Problem serializing ad request to JSON: " + ex.getMessage());
            return null;
        }
    }
    
    private static void a(final HashMap hashMap, final Location location) {
        final HashMap<String, Float> value = new HashMap<String, Float>();
        final Float value2 = 1000.0f * location.getAccuracy();
        final Long value3 = 1000L * location.getTime();
        final Long value4 = (long)(1.0E7 * location.getLatitude());
        final Long value5 = (long)(1.0E7 * location.getLongitude());
        value.put("radius", value2);
        value.put("lat", (Float)value4);
        value.put("long", (Float)value5);
        value.put("time", (Float)value3);
        hashMap.put("uule", value);
    }
    
    private static void a(final HashMap hashMap, final ai ai) {
        final String bp = el.bP();
        if (bp != null) {
            hashMap.put("abf", bp);
        }
        if (ai.lS != -1L) {
            hashMap.put("cust_age", dy.qA.format(new Date(ai.lS)));
        }
        if (ai.extras != null) {
            hashMap.put("extras", ai.extras);
        }
        if (ai.lT != -1) {
            hashMap.put("cust_gender", ai.lT);
        }
        if (ai.lU != null) {
            hashMap.put("kw", ai.lU);
        }
        if (ai.lW != -1) {
            hashMap.put("tag_for_child_directed_treatment", ai.lW);
        }
        if (ai.lV) {
            hashMap.put("adtest", "on");
        }
        if (ai.versionCode >= 2) {
            if (ai.lX) {
                hashMap.put("d_imp_hdr", 1);
            }
            if (!TextUtils.isEmpty((CharSequence)ai.lY)) {
                hashMap.put("ppid", ai.lY);
            }
            if (ai.lZ != null) {
                a(hashMap, ai.lZ);
            }
        }
        if (ai.versionCode >= 3 && ai.mb != null) {
            hashMap.put("url", ai.mb);
        }
    }
    
    private static void a(final HashMap hashMap, final aw aw) {
        if (Color.alpha(aw.mD) != 0) {
            hashMap.put("acolor", o(aw.mD));
        }
        if (Color.alpha(aw.backgroundColor) != 0) {
            hashMap.put("bgcolor", o(aw.backgroundColor));
        }
        if (Color.alpha(aw.mE) != 0 && Color.alpha(aw.mF) != 0) {
            hashMap.put("gradientto", o(aw.mE));
            hashMap.put("gradientfrom", o(aw.mF));
        }
        if (Color.alpha(aw.mG) != 0) {
            hashMap.put("bcolor", o(aw.mG));
        }
        hashMap.put("bthick", Integer.toString(aw.mH));
        String value = null;
        switch (aw.mI) {
            default: {
                value = null;
                break;
            }
            case 0: {
                value = "none";
                break;
            }
            case 1: {
                value = "dashed";
                break;
            }
            case 2: {
                value = "dotted";
                break;
            }
            case 3: {
                value = "solid";
                break;
            }
        }
        if (value != null) {
            hashMap.put("btype", value);
        }
        final int mj = aw.mJ;
        String value2 = null;
        switch (mj) {
            case 2: {
                value2 = "dark";
                break;
            }
            case 0: {
                value2 = "light";
                break;
            }
            case 1: {
                value2 = "medium";
                break;
            }
        }
        if (value2 != null) {
            hashMap.put("callbuttoncolor", value2);
        }
        if (aw.mK != null) {
            hashMap.put("channel", aw.mK);
        }
        if (Color.alpha(aw.mL) != 0) {
            hashMap.put("dcolor", o(aw.mL));
        }
        if (aw.mM != null) {
            hashMap.put("font", aw.mM);
        }
        if (Color.alpha(aw.mN) != 0) {
            hashMap.put("hcolor", o(aw.mN));
        }
        hashMap.put("headersize", Integer.toString(aw.mO));
        if (aw.mP != null) {
            hashMap.put("q", aw.mP);
        }
    }
    
    private static void a(final HashMap hashMap, final ec ec) {
        hashMap.put("am", ec.rb);
        hashMap.put("cog", m(ec.rc));
        hashMap.put("coh", m(ec.rd));
        if (!TextUtils.isEmpty((CharSequence)ec.re)) {
            hashMap.put("carrier", ec.re);
        }
        hashMap.put("gl", ec.rf);
        if (ec.rg) {
            hashMap.put("simulator", 1);
        }
        hashMap.put("ma", m(ec.rh));
        hashMap.put("sp", m(ec.ri));
        hashMap.put("hl", ec.rj);
        if (!TextUtils.isEmpty((CharSequence)ec.rk)) {
            hashMap.put("mv", ec.rk);
        }
        hashMap.put("muv", ec.rl);
        if (ec.rm != -2) {
            hashMap.put("cnt", ec.rm);
        }
        hashMap.put("gnt", ec.rn);
        hashMap.put("pt", ec.ro);
        hashMap.put("rm", ec.rp);
        hashMap.put("riv", ec.rq);
        hashMap.put("u_sd", ec.rr);
        hashMap.put("sh", ec.rt);
        hashMap.put("sw", ec.rs);
        final Bundle value = new Bundle();
        value.putInt("active_network_state", ec.rx);
        value.putBoolean("active_network_metered", ec.rw);
        hashMap.put("connectivity", value);
        final Bundle value2 = new Bundle();
        value2.putBoolean("is_charging", ec.rv);
        value2.putDouble("battery_level", ec.ru);
        hashMap.put("battery", value2);
    }
    
    private static Integer m(final boolean b) {
        int i;
        if (b) {
            i = 1;
        }
        else {
            i = 0;
        }
        return i;
    }
    
    private static String o(final int n) {
        return String.format(Locale.US, "#%06x", 0xFFFFFF & n);
    }
}
