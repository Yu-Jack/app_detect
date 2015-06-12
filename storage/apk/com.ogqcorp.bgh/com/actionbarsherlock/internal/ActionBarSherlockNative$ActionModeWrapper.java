// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal;

import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.Menu;
import android.view.View;
import com.actionbarsherlock.internal.view.menu.MenuWrapper;
import com.actionbarsherlock.view.ActionMode;

class ActionBarSherlockNative$ActionModeWrapper extends ActionMode
{
    private final android.view.ActionMode mActionMode;
    private MenuWrapper mMenu;
    final /* synthetic */ ActionBarSherlockNative this$0;
    
    ActionBarSherlockNative$ActionModeWrapper(final ActionBarSherlockNative this$0, final android.view.ActionMode mActionMode) {
        this.this$0 = this$0;
        this.mMenu = null;
        this.mActionMode = mActionMode;
    }
    
    @Override
    public void finish() {
        this.mActionMode.finish();
    }
    
    @Override
    public View getCustomView() {
        return this.mActionMode.getCustomView();
    }
    
    @Override
    public MenuWrapper getMenu() {
        if (this.mMenu == null) {
            this.mMenu = new MenuWrapper(this.mActionMode.getMenu());
        }
        return this.mMenu;
    }
    
    @Override
    public MenuInflater getMenuInflater() {
        return this.this$0.getMenuInflater();
    }
    
    @Override
    public CharSequence getSubtitle() {
        return this.mActionMode.getSubtitle();
    }
    
    @Override
    public Object getTag() {
        return this.mActionMode.getTag();
    }
    
    @Override
    public CharSequence getTitle() {
        return this.mActionMode.getTitle();
    }
    
    @Override
    public void invalidate() {
        this.mActionMode.invalidate();
        if (this.mMenu != null) {
            this.mMenu.invalidate();
        }
    }
    
    @Override
    public void setCustomView(final View customView) {
        this.mActionMode.setCustomView(customView);
    }
    
    @Override
    public void setSubtitle(final int subtitle) {
        this.mActionMode.setSubtitle(subtitle);
    }
    
    @Override
    public void setSubtitle(final CharSequence subtitle) {
        this.mActionMode.setSubtitle(subtitle);
    }
    
    @Override
    public void setTag(final Object tag) {
        this.mActionMode.setTag(tag);
    }
    
    @Override
    public void setTitle(final int title) {
        this.mActionMode.setTitle(title);
    }
    
    @Override
    public void setTitle(final CharSequence title) {
        this.mActionMode.setTitle(title);
    }
}
