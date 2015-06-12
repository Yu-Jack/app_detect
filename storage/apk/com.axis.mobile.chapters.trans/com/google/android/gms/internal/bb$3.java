// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.net.Uri;
import java.util.Map;

final class bb$3 implements bc
{
    @Override
    public void b(final ex ex, final Map map) {
        final String str = map.get("u");
        if (str == null) {
            eu.D("URL missing from click GMSG.");
            return;
        }
        while (true) {
            final Uri parse = Uri.parse(str);
            while (true) {
                try {
                    final k cc = ex.cc();
                    if (cc != null && cc.b(parse)) {
                        final Uri a = cc.a(parse, ex.getContext());
                        new es(ex.getContext(), ex.cd().sw, a.toString()).start();
                        return;
                    }
                }
                catch (l l) {
                    eu.D("Unable to append parameter to URL: " + str);
                }
                final Uri a = parse;
                continue;
            }
        }
    }
}
