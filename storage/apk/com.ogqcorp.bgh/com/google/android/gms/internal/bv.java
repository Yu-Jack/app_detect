// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.view.ViewParent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;

final class bv
{
    public final int a;
    public final ViewGroup$LayoutParams b;
    public final ViewGroup c;
    
    public bv(final ep ep) {
        this.b = ep.getLayoutParams();
        final ViewParent parent = ep.getParent();
        if (parent instanceof ViewGroup) {
            this.c = (ViewGroup)parent;
            this.a = this.c.indexOfChild((View)ep);
            this.c.removeView((View)ep);
            ep.a(true);
            return;
        }
        throw new bt("Could not get the parent of the WebView for an overlay.");
    }
}
