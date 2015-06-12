// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.view;

import android.view.View;

public abstract class ActionMode
{
    private Object mTag;
    
    public abstract void finish();
    
    public abstract View getCustomView();
    
    public abstract Menu getMenu();
    
    public abstract MenuInflater getMenuInflater();
    
    public abstract CharSequence getSubtitle();
    
    public Object getTag() {
        return this.mTag;
    }
    
    public abstract CharSequence getTitle();
    
    public abstract void invalidate();
    
    public boolean isUiFocusable() {
        return true;
    }
    
    public abstract void setCustomView(final View p0);
    
    public abstract void setSubtitle(final int p0);
    
    public abstract void setSubtitle(final CharSequence p0);
    
    public void setTag(final Object mTag) {
        this.mTag = mTag;
    }
    
    public abstract void setTitle(final int p0);
    
    public abstract void setTitle(final CharSequence p0);
}
