// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import org.json.JSONException;
import com.facebook.b.aj;
import com.facebook.a.g;
import java.net.HttpURLConnection;
import org.json.JSONObject;

public final class ae
{
    private static final ag a;
    private static final ag b;
    private static final ag c;
    private static final ag d;
    private final int e;
    private final boolean f;
    private final af g;
    private final int h;
    private final int i;
    private final int j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final boolean o;
    private final JSONObject p;
    private final JSONObject q;
    private final Object r;
    private final HttpURLConnection s;
    private final ab t;
    
    static {
        a = new ag(200, 299, (byte)0);
        b = new ag(200, 299, (byte)0);
        c = new ag(400, 499, (byte)0);
        d = new ag(500, 599, (byte)0);
    }
    
    private ae(final int n, final int n2, final int n3, final String s, final String s2, final String s3, final String s4, final boolean b, final JSONObject jsonObject, final JSONObject jsonObject2, final Object o, final HttpURLConnection httpURLConnection) {
        this(n, n2, n3, s, s2, s3, s4, b, jsonObject, jsonObject2, o, httpURLConnection, null);
    }
    
    private ae(final int h, final int i, final int j, final String k, final String l, final String m, final String n, final boolean o, final JSONObject q, final JSONObject p13, final Object r, final HttpURLConnection s, final ab t) {
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;
        this.q = q;
        this.p = p13;
        this.r = r;
        this.s = s;
        this.m = m;
        this.n = n;
        this.o = o;
        int n2;
        if (t != null) {
            this.t = t;
            n2 = 1;
        }
        else {
            this.t = new ah(this, l);
            n2 = 0;
        }
        int n3 = 0;
        af g;
        int e;
        if (n2 != 0) {
            g = af.h;
            e = 0;
        }
        else {
            af af = null;
            Label_0173: {
                if (i == 1 || i == 2) {
                    af = com.facebook.af.d;
                }
                else if (i == 4 || i == 17) {
                    af = com.facebook.af.e;
                    n3 = 0;
                }
                else if (i == 10 || ae.a.a(i)) {
                    af = com.facebook.af.c;
                    n3 = com.facebook.a.g.k;
                }
                else {
                    if (i != 102) {
                        n3 = 0;
                        af = null;
                        if (i != 190) {
                            break Label_0173;
                        }
                    }
                    if (j == 459 || j == 464) {
                        af = com.facebook.af.a;
                        n3 = com.facebook.a.g.n;
                    }
                    else {
                        af = com.facebook.af.b;
                        if (j == 458 || j == 463) {
                            n3 = com.facebook.a.g.m;
                        }
                        else if (j == 460) {
                            n3 = com.facebook.a.g.j;
                        }
                        else {
                            n3 = com.facebook.a.g.l;
                        }
                    }
                }
            }
            if (af == null) {
                if (ae.c.a(h)) {
                    g = com.facebook.af.g;
                    e = n3;
                }
                else if (ae.d.a(h)) {
                    g = com.facebook.af.d;
                    e = n3;
                }
                else {
                    g = com.facebook.af.f;
                    e = n3;
                }
            }
            else {
                g = af;
                e = n3;
            }
        }
        final boolean f = n != null && n.length() > 0;
        this.g = g;
        this.e = e;
        this.f = f;
    }
    
    public ae(final int n, final String s, final String s2) {
        this(-1, n, -1, s, s2, null, null, false, null, null, null, null, null);
    }
    
    ae(final HttpURLConnection httpURLConnection, final Exception ex) {
        ab ab;
        if (ex instanceof ab) {
            ab = (ab)ex;
        }
        else {
            ab = new ab(ex);
        }
        this(-1, -1, -1, null, null, null, null, false, null, null, null, httpURLConnection, ab);
    }
    
    static ae a(final JSONObject jsonObject, final Object o, final HttpURLConnection httpURLConnection) {
        while (true) {
            while (true) {
                Label_0352: {
                    try {
                        if (jsonObject.has("code")) {
                            final int int1 = jsonObject.getInt("code");
                            final Object a = aj.a(jsonObject, "body", "FACEBOOK_NON_JSON_RESULT");
                            if (a != null && a instanceof JSONObject) {
                                final JSONObject jsonObject2 = (JSONObject)a;
                                String s = null;
                                String s2 = null;
                                int n = 0;
                                int n2 = 0;
                                String optString = null;
                                String optString2 = null;
                                boolean optBoolean = false;
                                int n3 = 0;
                                Label_0143: {
                                    if (jsonObject2.has("error")) {
                                        final JSONObject jsonObject3 = (JSONObject)aj.a(jsonObject2, "error", null);
                                        s = jsonObject3.optString("type", (String)null);
                                        s2 = jsonObject3.optString("message", (String)null);
                                        n = jsonObject3.optInt("code", -1);
                                        n2 = jsonObject3.optInt("error_subcode", -1);
                                        optString = jsonObject3.optString("error_user_msg", (String)null);
                                        optString2 = jsonObject3.optString("error_user_title", (String)null);
                                        optBoolean = jsonObject3.optBoolean("is_transient", false);
                                        n3 = 1;
                                    }
                                    else {
                                        if (!jsonObject2.has("error_code") && !jsonObject2.has("error_msg")) {
                                            final boolean has = jsonObject2.has("error_reason");
                                            n3 = 0;
                                            n = 0;
                                            n2 = 0;
                                            s = null;
                                            s2 = null;
                                            optString2 = null;
                                            optString = null;
                                            optBoolean = false;
                                            if (!has) {
                                                break Label_0143;
                                            }
                                        }
                                        s = jsonObject2.optString("error_reason", (String)null);
                                        s2 = jsonObject2.optString("error_msg", (String)null);
                                        n = jsonObject2.optInt("error_code", -1);
                                        n2 = jsonObject2.optInt("error_subcode", -1);
                                        n3 = 1;
                                        optString2 = null;
                                        optString = null;
                                        optBoolean = false;
                                    }
                                }
                                if (n3 != 0) {
                                    return new ae(int1, n, n2, s, s2, optString2, optString, optBoolean, jsonObject2, jsonObject, o, httpURLConnection);
                                }
                            }
                            if (!ae.b.a(int1)) {
                                if (jsonObject.has("body")) {
                                    final JSONObject jsonObject4 = (JSONObject)aj.a(jsonObject, "body", "FACEBOOK_NON_JSON_RESULT");
                                    return new ae(int1, -1, -1, null, null, null, null, false, jsonObject4, jsonObject, o, httpURLConnection);
                                }
                                break Label_0352;
                            }
                        }
                    }
                    catch (JSONException ex) {}
                    break;
                }
                final JSONObject jsonObject4 = null;
                continue;
            }
        }
        return null;
    }
    
    public final int a() {
        return this.h;
    }
    
    public final int b() {
        return this.i;
    }
    
    public final String c() {
        return this.k;
    }
    
    public final String d() {
        if (this.l != null) {
            return this.l;
        }
        return this.t.getLocalizedMessage();
    }
    
    public final ab e() {
        return this.t;
    }
    
    @Override
    public final String toString() {
        return "{HttpStatus: " + this.h + ", errorCode: " + this.i + ", errorType: " + this.k + ", errorMessage: " + this.d() + "}";
    }
}
