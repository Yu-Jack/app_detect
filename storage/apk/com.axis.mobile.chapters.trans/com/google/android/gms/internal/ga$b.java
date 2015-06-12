// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.appstate.AppStateManager$StateDeletedResult;

final class ga$b implements AppStateManager$StateDeletedResult
{
    private final int yS;
    private final Status yz;
    
    public ga$b(final Status yz, final int ys) {
        this.yz = yz;
        this.yS = ys;
    }
    
    @Override
    public int getStateKey() {
        return this.yS;
    }
    
    @Override
    public Status getStatus() {
        return this.yz;
    }
}
