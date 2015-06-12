// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Locale;

class MraidStateProperty extends MraidProperty
{
    private final MraidView$ViewState mViewState;
    
    MraidStateProperty(final MraidView$ViewState mViewState) {
        this.mViewState = mViewState;
    }
    
    public static MraidStateProperty createWithViewState(final MraidView$ViewState mraidView$ViewState) {
        return new MraidStateProperty(mraidView$ViewState);
    }
    
    @Override
    public String toJsonPair() {
        return "state: '" + this.mViewState.toString().toLowerCase(Locale.US) + "'";
    }
}
