// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import android.view.View;

public class ScrollEvent
{
    public int l;
    public int nl;
    public int nt;
    public int t;
    private View targetView;
    
    ScrollEvent(final int nl, final int nt, final int l, final int n, final View targetView) {
        this.l = l;
        final int t = this.t;
        this.nl = nl;
        this.nt = nt;
        this.targetView = targetView;
    }
    
    public int dl() {
        return this.nl - this.l;
    }
    
    public int dt() {
        return this.nt - this.t;
    }
    
    public View getTargetView() {
        return this.targetView;
    }
}
