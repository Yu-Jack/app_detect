// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager$StateListResult;
import com.google.android.gms.common.api.b;

final class ga$d extends b implements AppStateManager$StateListResult
{
    private final AppStateBuffer yT;
    
    public ga$d(final DataHolder dataHolder) {
        super(dataHolder);
        this.yT = new AppStateBuffer(dataHolder);
    }
    
    @Override
    public AppStateBuffer getStateBuffer() {
        return this.yT;
    }
}
