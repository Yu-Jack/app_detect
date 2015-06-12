// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.app;

import android.view.ViewGroup$LayoutParams;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;
import android.view.ViewDebug$IntToString;
import android.view.ViewDebug$ExportedProperty;
import android.view.ViewGroup$MarginLayoutParams;

public class ActionBar$LayoutParams extends ViewGroup$MarginLayoutParams
{
    private static final int[] ATTRS;
    @ViewDebug$ExportedProperty(mapping = { @ViewDebug$IntToString(from = -1, to = "NONE"), @ViewDebug$IntToString(from = 0, to = "NONE"), @ViewDebug$IntToString(from = 48, to = "TOP"), @ViewDebug$IntToString(from = 80, to = "BOTTOM"), @ViewDebug$IntToString(from = 3, to = "LEFT"), @ViewDebug$IntToString(from = 5, to = "RIGHT"), @ViewDebug$IntToString(from = 16, to = "CENTER_VERTICAL"), @ViewDebug$IntToString(from = 112, to = "FILL_VERTICAL"), @ViewDebug$IntToString(from = 1, to = "CENTER_HORIZONTAL"), @ViewDebug$IntToString(from = 7, to = "FILL_HORIZONTAL"), @ViewDebug$IntToString(from = 17, to = "CENTER"), @ViewDebug$IntToString(from = 119, to = "FILL") })
    public int gravity;
    
    static {
        ATTRS = new int[] { 16842931 };
    }
    
    public ActionBar$LayoutParams(final int n) {
        this(-2, -1, n);
    }
    
    public ActionBar$LayoutParams(final int n, final int n2) {
        super(n, n2);
        this.gravity = -1;
        this.gravity = 19;
    }
    
    public ActionBar$LayoutParams(final int n, final int n2, final int gravity) {
        super(n, n2);
        this.gravity = -1;
        this.gravity = gravity;
    }
    
    public ActionBar$LayoutParams(final Context context, final AttributeSet set) {
        super(context, set);
        this.gravity = -1;
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, ActionBar$LayoutParams.ATTRS);
        this.gravity = obtainStyledAttributes.getInt(0, -1);
        obtainStyledAttributes.recycle();
    }
    
    public ActionBar$LayoutParams(final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super(viewGroup$LayoutParams);
        this.gravity = -1;
    }
    
    public ActionBar$LayoutParams(final ActionBar$LayoutParams actionBar$LayoutParams) {
        super((ViewGroup$MarginLayoutParams)actionBar$LayoutParams);
        this.gravity = -1;
        this.gravity = actionBar$LayoutParams.gravity;
    }
}
