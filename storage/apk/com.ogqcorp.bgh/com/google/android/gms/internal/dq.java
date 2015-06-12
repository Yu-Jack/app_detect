// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import android.graphics.Color;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import android.location.Location;
import java.util.Locale;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.LinkedList;
import android.text.TextUtils;
import org.json.JSONObject;
import android.content.Context;
import java.text.SimpleDateFormat;

public final class dq
{
    private static final SimpleDateFormat a;
    
    static {
        a = new SimpleDateFormat("yyyyMMdd");
    }
    
    public static cz a(final Context context, final cx cx, final String s) {
        JSONObject jsonObject = null;
        String s2 = null;
        String optString2 = null;
        String s3 = null;
        long n = 0L;
        String optString3 = null;
        long g = 0L;
        int n2 = 0;
        cz cz = null;
        List<String> list = null;
    Label_0242_Outer:
        while (true) {
            List<String> d = null;
            Label_0627: {
                while (true) {
                Label_0648:
                    while (true) {
                        Label_0640: {
                            while (true) {
                                Label_0634: {
                                    while (true) {
                                        Label_0328: {
                                            try {
                                                jsonObject = new JSONObject(s);
                                                s2 = jsonObject.optString("ad_base_url", (String)null);
                                                final String optString = jsonObject.optString("ad_url", (String)null);
                                                optString2 = jsonObject.optString("ad_size", (String)null);
                                                s3 = jsonObject.optString("ad_html", (String)null);
                                                n = -1L;
                                                optString3 = jsonObject.optString("debug_dialog", (String)null);
                                                if (!jsonObject.has("interstitial_timeout")) {
                                                    break Label_0640;
                                                }
                                                g = (long)(1000.0 * jsonObject.getDouble("interstitial_timeout"));
                                                final String optString4 = jsonObject.optString("orientation", (String)null);
                                                n2 = -1;
                                                if ("portrait".equals(optString4)) {
                                                    n2 = eg.c();
                                                }
                                                else if ("landscape".equals(optString4)) {
                                                    n2 = eg.b();
                                                }
                                                final JSONArray optJSONArray;
                                                if (!TextUtils.isEmpty((CharSequence)s3)) {
                                                    if (TextUtils.isEmpty((CharSequence)s2)) {
                                                        en.e("Could not parse the mediation config: Missing required ad_base_url field");
                                                        return new cz(0);
                                                    }
                                                    break Label_0634;
                                                }
                                                else {
                                                    if (TextUtils.isEmpty((CharSequence)optString)) {
                                                        en.e("Could not parse the mediation config: Missing required ad_html or ad_url field.");
                                                        return new cz(0);
                                                    }
                                                    final cz a = dp.a(context, cx.k.b, optString);
                                                    s2 = a.b;
                                                    s3 = a.c;
                                                    n = a.n;
                                                    cz = a;
                                                    optJSONArray = jsonObject.optJSONArray("click_urls");
                                                    if (cz != null) {
                                                        break Label_0328;
                                                    }
                                                    d = null;
                                                    if (optJSONArray == null) {
                                                        break Label_0627;
                                                    }
                                                    if (d == null) {
                                                        d = new LinkedList<String>();
                                                    }
                                                    break Label_0648;
                                                }
                                                while (true) {
                                                    int n3 = 0;
                                                    d.add(optJSONArray.getString(n3));
                                                    ++n3;
                                                    continue Label_0242_Outer;
                                                }
                                            }
                                            // iftrue(Label_0654:, n3 >= optJSONArray.length())
                                            catch (JSONException ex) {
                                                en.e("Could not parse the mediation config: " + ex.getMessage());
                                                return new cz(0);
                                            }
                                        }
                                        d = cz.d;
                                        continue Label_0242_Outer;
                                    }
                                }
                                cz = null;
                                continue Label_0242_Outer;
                            }
                        }
                        g = -1L;
                        continue Label_0242_Outer;
                    }
                    int n3 = 0;
                    continue;
                }
            }
            list = d;
            break;
            Label_0654: {
                list = d;
            }
            break;
        }
        final JSONArray optJSONArray2 = jsonObject.optJSONArray("impression_urls");
        List<String> f;
        if (cz == null) {
            f = null;
        }
        else {
            f = cz.f;
        }
        List<String> list2;
        if (optJSONArray2 != null) {
            if (f == null) {
                f = new LinkedList<String>();
            }
            for (int i = 0; i < optJSONArray2.length(); ++i) {
                f.add(optJSONArray2.getString(i));
            }
            list2 = f;
        }
        else {
            list2 = f;
        }
        final JSONArray optJSONArray3 = jsonObject.optJSONArray("manual_impression_urls");
        List<String> j;
        if (cz == null) {
            j = null;
        }
        else {
            j = cz.j;
        }
        List<String> list3;
        if (optJSONArray3 != null) {
            if (j == null) {
                j = new LinkedList<String>();
            }
            for (int k = 0; k < optJSONArray3.length(); ++k) {
                j.add(optJSONArray3.getString(k));
            }
            list3 = j;
        }
        else {
            list3 = j;
        }
        if (cz != null) {
            if (cz.l != -1) {
                n2 = cz.l;
            }
            if (cz.g > 0L) {
                g = cz.g;
            }
        }
        final String optString5 = jsonObject.optString("active_view");
        final boolean optBoolean = jsonObject.optBoolean("ad_is_javascript", false);
        String optString6 = null;
        if (optBoolean) {
            optString6 = jsonObject.optString("ad_passback_url", (String)null);
        }
        return new cz(s2, s3, list, list2, g, false, -1L, list3, -1L, n2, optString2, n, optString3, optBoolean, optString6, optString5);
    }
    
    private static Integer a(final boolean b) {
        int i;
        if (b) {
            i = 1;
        }
        else {
            i = 0;
        }
        return i;
    }
    
    private static String a(final int n) {
        return String.format(Locale.US, "#%06x", 0xFFFFFF & n);
    }
    
    public static String a(final cx cx, final dt dt, final Location location, final String value) {
        try {
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            if (value != null && value.trim() != "") {
                hashMap.put("eid", value);
            }
            if (cx.b != null) {
                hashMap.put("ad_pos", (String)cx.b);
            }
            a((HashMap<String, Object>)hashMap, cx.c);
            hashMap.put("format", cx.d.b);
            if (cx.d.f == -1) {
                hashMap.put("smart_w", "full");
            }
            if (cx.d.c == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (cx.d.h != null) {
                final StringBuilder value2 = new StringBuilder();
                for (final ak ak : cx.d.h) {
                    if (value2.length() != 0) {
                        value2.append("|");
                    }
                    int f;
                    if (ak.f == -1) {
                        f = (int)(ak.g / dt.q);
                    }
                    else {
                        f = ak.f;
                    }
                    value2.append(f);
                    value2.append("x");
                    int c;
                    if (ak.c == -2) {
                        c = (int)(ak.d / dt.q);
                    }
                    else {
                        c = ak.c;
                    }
                    value2.append(c);
                }
                hashMap.put("sz", (String)value2);
            }
            hashMap.put("slotname", cx.e);
            hashMap.put("pn", cx.f.packageName);
            if (cx.g != null) {
                hashMap.put("vc", (String)cx.g.versionCode);
            }
            hashMap.put("ms", cx.h);
            hashMap.put("seq_num", cx.i);
            hashMap.put("session_id", cx.j);
            hashMap.put("js", cx.k.b);
            a((HashMap<String, Object>)hashMap, dt);
            if (cx.c.a >= 2 && cx.c.k != null) {
                a((HashMap<String, Object>)hashMap, cx.c.k);
            }
            if (cx.a >= 2) {
                hashMap.put("quality_signals", (String)cx.l);
            }
            if (en.a(2)) {
                en.d("Ad Request JSON: " + eg.a(hashMap).toString(2));
            }
            return eg.a(hashMap).toString();
        }
        catch (JSONException ex) {
            en.e("Problem serializing ad request to JSON: " + ex.getMessage());
            return null;
        }
    }
    
    private static void a(final HashMap<String, Object> hashMap, final Location location) {
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
    
    private static void a(final HashMap<String, Object> hashMap, final ah ah) {
        final String a = ec.a();
        if (a != null) {
            hashMap.put("abf", a);
        }
        if (ah.b != -1L) {
            hashMap.put("cust_age", dq.a.format(new Date(ah.b)));
        }
        if (ah.c != null) {
            hashMap.put("extras", ah.c);
        }
        if (ah.d != -1) {
            hashMap.put("cust_gender", ah.d);
        }
        if (ah.e != null) {
            hashMap.put("kw", ah.e);
        }
        if (ah.g != -1) {
            hashMap.put("tag_for_child_directed_treatment", ah.g);
        }
        if (ah.f) {
            hashMap.put("adtest", "on");
        }
        if (ah.a >= 2) {
            if (ah.h) {
                hashMap.put("d_imp_hdr", 1);
            }
            if (!TextUtils.isEmpty((CharSequence)ah.i)) {
                hashMap.put("ppid", ah.i);
            }
            if (ah.j != null) {
                a(hashMap, ah.j);
            }
        }
        if (ah.a >= 3 && ah.l != null) {
            hashMap.put("url", ah.l);
        }
    }
    
    private static void a(final HashMap<String, Object> hashMap, final av av) {
        if (Color.alpha(av.b) != 0) {
            hashMap.put("acolor", a(av.b));
        }
        if (Color.alpha(av.c) != 0) {
            hashMap.put("bgcolor", a(av.c));
        }
        if (Color.alpha(av.d) != 0 && Color.alpha(av.e) != 0) {
            hashMap.put("gradientto", a(av.d));
            hashMap.put("gradientfrom", a(av.e));
        }
        if (Color.alpha(av.f) != 0) {
            hashMap.put("bcolor", a(av.f));
        }
        hashMap.put("bthick", Integer.toString(av.g));
        String value = null;
        switch (av.h) {
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
        final int i = av.i;
        String value2 = null;
        switch (i) {
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
        if (av.j != null) {
            hashMap.put("channel", av.j);
        }
        if (Color.alpha(av.k) != 0) {
            hashMap.put("dcolor", a(av.k));
        }
        if (av.l != null) {
            hashMap.put("font", av.l);
        }
        if (Color.alpha(av.m) != 0) {
            hashMap.put("hcolor", a(av.m));
        }
        hashMap.put("headersize", Integer.toString(av.n));
        if (av.o != null) {
            hashMap.put("q", av.o);
        }
    }
    
    private static void a(final HashMap<String, Object> hashMap, final dt dt) {
        hashMap.put("am", dt.a);
        hashMap.put("cog", a(dt.b));
        hashMap.put("coh", a(dt.c));
        if (!TextUtils.isEmpty((CharSequence)dt.d)) {
            hashMap.put("carrier", dt.d);
        }
        hashMap.put("gl", dt.e);
        if (dt.f) {
            hashMap.put("simulator", 1);
        }
        hashMap.put("ma", a(dt.g));
        hashMap.put("sp", a(dt.h));
        hashMap.put("hl", dt.i);
        if (!TextUtils.isEmpty((CharSequence)dt.j)) {
            hashMap.put("mv", dt.j);
        }
        hashMap.put("muv", dt.k);
        if (dt.l != -2) {
            hashMap.put("cnt", dt.l);
        }
        hashMap.put("gnt", dt.m);
        hashMap.put("pt", dt.n);
        hashMap.put("rm", dt.o);
        hashMap.put("riv", dt.p);
        hashMap.put("u_sd", dt.q);
        hashMap.put("sh", dt.s);
        hashMap.put("sw", dt.r);
    }
}
