// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons.cp;

import android.graphics.Color;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.PorterDuff$Mode;
import android.graphics.LinearGradient;
import android.graphics.Shader$TileMode;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Shader;
import android.graphics.Paint;
import android.view.View;

public class ColorBrowser extends View
{
    private Paint a;
    private Shader b;
    private final float[] c;
    private int d;
    
    public ColorBrowser(final Context context, final AttributeSet set) {
        super(context, set);
        this.c = new float[] { 1.0f, 1.0f, 1.0f };
        this.d = 0;
    }
    
    public ColorBrowser(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.c = new float[] { 1.0f, 1.0f, 1.0f };
        this.d = 0;
    }
    
    private void a(final int d) {
        if (this.d == 0 || this.d != d) {
            this.a.setShader((Shader)new ComposeShader(this.b, (Shader)new LinearGradient(0.0f, 0.0f, (float)this.getMeasuredWidth(), 0.0f, -1, d, Shader$TileMode.CLAMP), PorterDuff$Mode.MULTIPLY));
            this.d = d;
        }
    }
    
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        if (this.a == null) {
            this.a = new Paint();
            this.b = (Shader)new LinearGradient(0.0f, 0.0f, 0.0f, (float)this.getMeasuredHeight(), -1, -16777216, Shader$TileMode.CLAMP);
        }
        this.a(Color.HSVToColor(this.c));
        canvas.drawRect(0.0f, 0.0f, (float)this.getMeasuredWidth(), (float)this.getMeasuredHeight(), this.a);
    }
    
    public void setHue(final float n) {
        this.c[0] = n;
        this.invalidate();
    }
}
