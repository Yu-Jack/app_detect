// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Map;

final class bb$8 implements bc
{
    @Override
    public void b(final ex ex, final Map map) {
        final String s = map.get("tx");
        final String s2 = map.get("ty");
        final String s3 = map.get("td");
        try {
            final int int1 = Integer.parseInt(s);
            final int int2 = Integer.parseInt(s2);
            final int int3 = Integer.parseInt(s3);
            final k cc = ex.cc();
            if (cc != null) {
                cc.z().a(int1, int2, int3);
            }
        }
        catch (NumberFormatException ex2) {
            eu.D("Could not parse touch parameters from gmsg.");
        }
    }
}
