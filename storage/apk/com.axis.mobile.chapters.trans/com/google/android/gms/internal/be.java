// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Map;

public class be implements bc
{
    private final bf nc;
    
    public be(final bf nc) {
        this.nc = nc;
    }
    
    @Override
    public void b(final ex ex, final Map map) {
        this.nc.b("1".equals(map.get("transparentBackground")));
    }
}
