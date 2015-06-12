// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Map;

final class bb$4 implements bc
{
    @Override
    public void b(final ex ex, final Map map) {
        final cf ca = ex.ca();
        if (ca == null) {
            eu.D("A GMSG tried to close something that wasn't an overlay.");
            return;
        }
        ca.close();
    }
}
