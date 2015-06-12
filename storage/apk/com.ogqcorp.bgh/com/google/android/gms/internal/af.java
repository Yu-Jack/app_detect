// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Map;

public final class af implements aj
{
    private final ag a;
    
    public af(final ag a) {
        this.a = a;
    }
    
    @Override
    public void a(final ep ep, final Map<String, String> map) {
        final String s = map.get("name");
        if (s == null) {
            en.e("App event with no name parameter.");
            return;
        }
        this.a.a(s, map.get("info"));
    }
}
