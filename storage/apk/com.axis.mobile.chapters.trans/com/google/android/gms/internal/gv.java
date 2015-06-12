// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.net.Uri;
import android.widget.ImageView;

public final class gv extends ImageView
{
    private Uri FO;
    private int FP;
    private int FQ;
    private gv$a FR;
    
    public void al(final int fp) {
        this.FP = fp;
    }
    
    public int fi() {
        return this.FP;
    }
    
    public void g(final Uri fo) {
        this.FO = fo;
    }
    
    protected void onDraw(final Canvas canvas) {
        if (this.FR != null) {
            canvas.clipPath(this.FR.d(this.getWidth(), this.getHeight()));
        }
        super.onDraw(canvas);
        if (this.FQ != 0) {
            canvas.drawColor(this.FQ);
        }
    }
}
