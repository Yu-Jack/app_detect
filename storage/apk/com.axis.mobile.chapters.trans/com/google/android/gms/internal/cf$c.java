// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.view.ViewParent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;

final class cf$c
{
    public final int index;
    public final ViewGroup$LayoutParams ot;
    public final ViewGroup ou;
    
    public cf$c(final ex ex) {
        this.ot = ex.getLayoutParams();
        final ViewParent parent = ex.getParent();
        if (parent instanceof ViewGroup) {
            this.ou = (ViewGroup)parent;
            this.index = this.ou.indexOfChild((View)ex);
            this.ou.removeView((View)ex);
            ex.q(true);
            return;
        }
        throw new cf$a("Could not get the parent of the WebView for an overlay.");
    }
}
