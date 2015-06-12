// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.view;

public interface ActionMode$Callback
{
    boolean onActionItemClicked(ActionMode p0, MenuItem p1);
    
    boolean onCreateActionMode(ActionMode p0, Menu p1);
    
    void onDestroyActionMode(ActionMode p0);
    
    boolean onPrepareActionMode(ActionMode p0, Menu p1);
}
