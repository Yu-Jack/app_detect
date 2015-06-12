// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Map;

public final class az implements bc
{
    private final ba mS;
    
    public az(final ba ms) {
        this.mS = ms;
    }
    
    @Override
    public void b(final ex ex, final Map map) {
        final String s = map.get("name");
        if (s == null) {
            eu.D("App event with no name parameter.");
            return;
        }
        this.mS.onAppEvent(s, map.get("info"));
    }
}
