// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Map;

final class bb$6 implements bc
{
    @Override
    public void b(final ex ex, final Map map) {
        final String s = map.get("u");
        if (s == null) {
            eu.D("URL missing from httpTrack GMSG.");
            return;
        }
        new es(ex.getContext(), ex.cd().sw, s).start();
    }
}
