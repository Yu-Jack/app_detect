// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;

public final class an extends as$a
{
    private final AppEventListener mh;
    
    public an(final AppEventListener mh) {
        this.mh = mh;
    }
    
    public void onAppEvent(final String s, final String s2) {
        this.mh.onAppEvent(s, s2);
    }
}
