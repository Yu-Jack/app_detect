// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.widget.FrameLayout$LayoutParams;
import android.content.Context;
import android.app.Activity;
import android.widget.ImageButton;
import android.view.View$OnClickListener;
import android.widget.FrameLayout;

public final class ck extends FrameLayout implements View$OnClickListener
{
    private final ImageButton oR;
    private final Activity og;
    
    public ck(final Activity og, final int n) {
        super((Context)og);
        this.og = og;
        this.setOnClickListener((View$OnClickListener)this);
        (this.oR = new ImageButton((Context)og)).setImageResource(17301527);
        this.oR.setBackgroundColor(0);
        this.oR.setOnClickListener((View$OnClickListener)this);
        this.oR.setPadding(0, 0, 0, 0);
        final int a = et.a((Context)og, n);
        this.addView((View)this.oR, (ViewGroup$LayoutParams)new FrameLayout$LayoutParams(a, a, 17));
    }
    
    public void j(final boolean b) {
        final ImageButton or = this.oR;
        int visibility;
        if (b) {
            visibility = 4;
        }
        else {
            visibility = 0;
        }
        or.setVisibility(visibility);
    }
    
    public void onClick(final View view) {
        this.og.finish();
    }
}
