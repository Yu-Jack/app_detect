// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Map;
import java.util.HashMap;

class ll implements lo
{
    private ep a;
    
    public ll(final ep a) {
        this.a = a;
    }
    
    @Override
    public void a(final b b, final boolean b2) {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        String s;
        if (b2) {
            s = "1";
        }
        else {
            s = "0";
        }
        hashMap.put("isVisible", s);
        this.a.a("onAdVisibilityChanged", hashMap);
    }
}
