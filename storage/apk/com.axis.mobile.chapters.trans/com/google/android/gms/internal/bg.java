// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public final class bg implements bc
{
    private final bd nd;
    
    public bg(final bd nd) {
        this.nd = nd;
    }
    
    private static boolean a(final Map map) {
        return "1".equals(map.get("custom_close"));
    }
    
    private static int b(final Map map) {
        final String s = map.get("o");
        if (s != null) {
            if ("p".equalsIgnoreCase(s)) {
                return eo.bS();
            }
            if ("l".equalsIgnoreCase(s)) {
                return eo.bR();
            }
        }
        return -1;
    }
    
    @Override
    public void b(final ex ex, final Map map) {
        final String anotherString = map.get("a");
        if (anotherString == null) {
            eu.D("Action missing from an open GMSG.");
        }
        else {
            final ey cb = ex.cb();
            if ("expand".equalsIgnoreCase(anotherString)) {
                if (ex.ce()) {
                    eu.D("Cannot expand WebView that is already expanded.");
                    return;
                }
                cb.a(a(map), b(map));
            }
            else if ("webapp".equalsIgnoreCase(anotherString)) {
                final String s = map.get("u");
                if (s != null) {
                    cb.a(a(map), b(map), s);
                    return;
                }
                cb.a(a(map), b(map), map.get("html"), map.get("baseurl"));
            }
            else {
                if (!"in_app_purchase".equalsIgnoreCase(anotherString)) {
                    cb.a(new ce(map.get("i"), map.get("u"), map.get("m"), map.get("p"), map.get("c"), map.get("f"), map.get("e")));
                    return;
                }
                final String s2 = map.get("product_id");
                final String s3 = map.get("report_urls");
                if (this.nd != null) {
                    if (s3 != null && !s3.isEmpty()) {
                        this.nd.a(s2, new ArrayList(Arrays.asList(s3.split(" "))));
                        return;
                    }
                    this.nd.a(s2, new ArrayList());
                }
            }
        }
    }
}
