// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.c;

import android.view.ViewGroup;
import android.view.View;
import android.widget.BaseAdapter;

public abstract class a extends BaseAdapter
{
    public abstract View a(final int p0, final View p1, final ViewGroup p2, final boolean p3);
    
    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        return this.a(n, view, viewGroup, false);
    }
}
