// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$ConstantState;

final class gt$b extends Drawable$ConstantState
{
    int FM;
    int FN;
    
    gt$b(final gt$b gt$b) {
        if (gt$b != null) {
            this.FM = gt$b.FM;
            this.FN = gt$b.FN;
        }
    }
    
    public int getChangingConfigurations() {
        return this.FM;
    }
    
    public Drawable newDrawable() {
        return new gt(this);
    }
}
