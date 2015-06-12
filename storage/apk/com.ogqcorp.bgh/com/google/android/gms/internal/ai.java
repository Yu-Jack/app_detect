// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.pm.PackageManager;
import android.content.Intent;
import android.net.Uri;
import java.util.HashMap;
import android.text.TextUtils;
import java.util.Map;

public final class ai
{
    public static final aj a;
    public static final aj b;
    public static final aj c;
    public static final aj d;
    public static final aj e;
    public static final aj f;
    public static final aj g;
    public static final aj h;
    public static final aj i;
    
    static {
        a = new aj() {
            @Override
            public void a(final ep ep, final Map<String, String> map) {
            }
        };
        b = new aj() {
            @Override
            public void a(final ep ep, final Map<String, String> map) {
                final String s = map.get("urls");
                if (TextUtils.isEmpty((CharSequence)s)) {
                    en.e("URLs missing in canOpenURLs GMSG.");
                    return;
                }
                final String[] split = s.split(",");
                final HashMap<String, Boolean> hashMap = new HashMap<String, Boolean>();
                final PackageManager packageManager = ep.getContext().getPackageManager();
                for (final String key : split) {
                    final String[] split2 = key.split(";", 2);
                    final String trim = split2[0].trim();
                    String trim2;
                    if (split2.length > 1) {
                        trim2 = split2[1].trim();
                    }
                    else {
                        trim2 = "android.intent.action.VIEW";
                    }
                    hashMap.put(key, packageManager.resolveActivity(new Intent(trim2, Uri.parse(trim)), 65536) != null);
                }
                ep.a("openableURLs", hashMap);
            }
        };
        c = new aj() {
            @Override
            public void a(final ep ep, final Map<String, String> map) {
                final String str = map.get("u");
                if (str == null) {
                    en.e("URL missing from click GMSG.");
                    return;
                }
                while (true) {
                    final Uri parse = Uri.parse(str);
                    while (true) {
                        try {
                            final kw g = ep.g();
                            if (g != null && g.a(parse)) {
                                final Uri a = g.a(parse, ep.getContext());
                                new el(ep.getContext(), ep.h().b, a.toString()).e();
                                return;
                            }
                        }
                        catch (kx kx) {
                            en.e("Unable to append parameter to URL: " + str);
                        }
                        final Uri a = parse;
                        continue;
                    }
                }
            }
        };
        d = new aj() {
            @Override
            public void a(final ep ep, final Map<String, String> map) {
                final bs d = ep.d();
                if (d == null) {
                    en.e("A GMSG tried to close something that wasn't an overlay.");
                    return;
                }
                d.a();
            }
        };
        e = new aj() {
            @Override
            public void a(final ep ep, final Map<String, String> map) {
                final bs d = ep.d();
                if (d == null) {
                    en.e("A GMSG tried to use a custom close button on something that wasn't an overlay.");
                    return;
                }
                d.b("1".equals(map.get("custom_close")));
            }
        };
        f = new aj() {
            @Override
            public void a(final ep ep, final Map<String, String> map) {
                final String s = map.get("u");
                if (s == null) {
                    en.e("URL missing from httpTrack GMSG.");
                    return;
                }
                new el(ep.getContext(), ep.h().b, s).e();
            }
        };
        g = new aj() {
            @Override
            public void a(final ep ep, final Map<String, String> map) {
                en.c("Received log message: " + map.get("string"));
            }
        };
        h = new aj() {
            @Override
            public void a(final ep ep, final Map<String, String> map) {
                final String s = map.get("tx");
                final String s2 = map.get("ty");
                final String s3 = map.get("td");
                try {
                    final int int1 = Integer.parseInt(s);
                    final int int2 = Integer.parseInt(s2);
                    final int int3 = Integer.parseInt(s3);
                    final kw g = ep.g();
                    if (g != null) {
                        g.a().a(int1, int2, int3);
                    }
                }
                catch (NumberFormatException ex) {
                    en.e("Could not parse touch parameters from gmsg.");
                }
            }
        };
        i = new an();
    }
}
