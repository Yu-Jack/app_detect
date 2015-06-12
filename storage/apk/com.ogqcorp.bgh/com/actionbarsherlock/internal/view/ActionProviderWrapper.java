// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.view;

import com.actionbarsherlock.internal.view.menu.SubMenuWrapper;
import android.view.SubMenu;
import android.view.View;
import android.content.Context;
import android.view.ActionProvider;

public class ActionProviderWrapper extends ActionProvider
{
    private final com.actionbarsherlock.view.ActionProvider mProvider;
    
    public ActionProviderWrapper(final com.actionbarsherlock.view.ActionProvider mProvider) {
        super((Context)null);
        this.mProvider = mProvider;
    }
    
    public boolean hasSubMenu() {
        return this.mProvider.hasSubMenu();
    }
    
    public View onCreateActionView() {
        return this.mProvider.onCreateActionView();
    }
    
    public boolean onPerformDefaultAction() {
        return this.mProvider.onPerformDefaultAction();
    }
    
    public void onPrepareSubMenu(final SubMenu subMenu) {
        this.mProvider.onPrepareSubMenu(new SubMenuWrapper(subMenu));
    }
    
    public com.actionbarsherlock.view.ActionProvider unwrap() {
        return this.mProvider;
    }
}
