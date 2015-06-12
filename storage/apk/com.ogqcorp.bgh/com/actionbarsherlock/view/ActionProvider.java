// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.view;

import android.view.View;
import android.content.Context;

public abstract class ActionProvider
{
    private ActionProvider$SubUiVisibilityListener mSubUiVisibilityListener;
    
    public ActionProvider(final Context context) {
    }
    
    public boolean hasSubMenu() {
        return false;
    }
    
    public abstract View onCreateActionView();
    
    public boolean onPerformDefaultAction() {
        return false;
    }
    
    public void onPrepareSubMenu(final SubMenu subMenu) {
    }
    
    public void setSubUiVisibilityListener(final ActionProvider$SubUiVisibilityListener mSubUiVisibilityListener) {
        this.mSubUiVisibilityListener = mSubUiVisibilityListener;
    }
    
    public void subUiVisibilityChanged(final boolean b) {
        if (this.mSubUiVisibilityListener != null) {
            this.mSubUiVisibilityListener.onSubUiVisibilityChanged(b);
        }
    }
}
