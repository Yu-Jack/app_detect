// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.view.View;
import android.view.ContextMenu$ContextMenuInfo;

public class IcsAdapterView$AdapterContextMenuInfo implements ContextMenu$ContextMenuInfo
{
    public long id;
    public int position;
    public View targetView;
    
    public IcsAdapterView$AdapterContextMenuInfo(final View targetView, final int position, final long id) {
        this.targetView = targetView;
        this.position = position;
        this.id = id;
    }
}
