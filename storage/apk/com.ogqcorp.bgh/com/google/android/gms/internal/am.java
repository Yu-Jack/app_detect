// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public final class am implements aj
{
    private final al a;
    
    public am(final al a) {
        this.a = a;
    }
    
    private static boolean a(final Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }
    
    private static int b(final Map<String, String> map) {
        final String s = map.get("o");
        if (s != null) {
            if ("p".equalsIgnoreCase(s)) {
                return eg.c();
            }
            if ("l".equalsIgnoreCase(s)) {
                return eg.b();
            }
        }
        return -1;
    }
    
    @Override
    public void a(final ep ep, final Map<String, String> map) {
        final String anotherString = map.get("a");
        if (anotherString == null) {
            en.e("Action missing from an open GMSG.");
        }
        else {
            final es f = ep.f();
            if ("expand".equalsIgnoreCase(anotherString)) {
                if (ep.i()) {
                    en.e("Cannot expand WebView that is already expanded.");
                    return;
                }
                f.a(a(map), b(map));
            }
            else if ("webapp".equalsIgnoreCase(anotherString)) {
                final String s = map.get("u");
                if (s != null) {
                    f.a(a(map), b(map), s);
                    return;
                }
                f.a(a(map), b(map), map.get("html"), map.get("baseurl"));
            }
            else {
                if (!"in_app_purchase".equalsIgnoreCase(anotherString)) {
                    f.a(new cb(map.get("i"), map.get("u"), map.get("m"), map.get("p"), map.get("c"), map.get("f"), map.get("e")));
                    return;
                }
                final String s2 = map.get("product_id");
                final String s3 = map.get("report_urls");
                if (this.a != null) {
                    if (s3 != null && !s3.isEmpty()) {
                        this.a.a(s2, new ArrayList<String>(Arrays.asList(s3.split(" "))));
                        return;
                    }
                    this.a.a(s2, new ArrayList<String>());
                }
            }
        }
    }
}
