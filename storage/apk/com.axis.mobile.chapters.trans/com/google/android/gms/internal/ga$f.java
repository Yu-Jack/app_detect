// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager$StateResult;
import com.google.android.gms.appstate.AppStateManager$StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager$StateConflictResult;
import com.google.android.gms.common.api.b;

final class ga$f extends b implements AppStateManager$StateConflictResult, AppStateManager$StateLoadedResult, AppStateManager$StateResult
{
    private final int yS;
    private final AppStateBuffer yT;
    
    public ga$f(final int ys, final DataHolder dataHolder) {
        super(dataHolder);
        this.yS = ys;
        this.yT = new AppStateBuffer(dataHolder);
    }
    
    private boolean dW() {
        return this.yz.getStatusCode() == 2000;
    }
    
    @Override
    public AppStateManager$StateConflictResult getConflictResult() {
        if (this.dW()) {
            return this;
        }
        return null;
    }
    
    @Override
    public AppStateManager$StateLoadedResult getLoadedResult() {
        final AppStateManager$StateLoadedResult appStateManager$StateLoadedResult;
        if (this.dW()) {
            appStateManager$StateLoadedResult = null;
        }
        return appStateManager$StateLoadedResult;
    }
    
    @Override
    public byte[] getLocalData() {
        if (this.yT.getCount() == 0) {
            return null;
        }
        return this.yT.get(0).getLocalData();
    }
    
    @Override
    public String getResolvedVersion() {
        if (this.yT.getCount() == 0) {
            return null;
        }
        return this.yT.get(0).getConflictVersion();
    }
    
    @Override
    public byte[] getServerData() {
        if (this.yT.getCount() == 0) {
            return null;
        }
        return this.yT.get(0).getConflictData();
    }
    
    @Override
    public int getStateKey() {
        return this.yS;
    }
    
    @Override
    public void release() {
        this.yT.close();
    }
}
