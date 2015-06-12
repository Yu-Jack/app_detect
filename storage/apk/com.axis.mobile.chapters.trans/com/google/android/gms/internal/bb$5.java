// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Map;

final class bb$5 implements bc
{
    @Override
    public void b(final ex ex, final Map map) {
        final cf ca = ex.ca();
        if (ca == null) {
            eu.D("A GMSG tried to use a custom close button on something that wasn't an overlay.");
            return;
        }
        ca.j("1".equals(map.get("custom_close")));
    }
}
