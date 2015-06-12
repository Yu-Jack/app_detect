// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

final class gt$a extends Drawable
{
    private static final gt$a FK;
    private static final gt$a$a FL;
    
    static {
        FK = new gt$a();
        FL = new gt$a$a(null);
    }
    
    public void draw(final Canvas canvas) {
    }
    
    public Drawable$ConstantState getConstantState() {
        return gt$a.FL;
    }
    
    public int getOpacity() {
        return -2;
    }
    
    public void setAlpha(final int n) {
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
    }
}
