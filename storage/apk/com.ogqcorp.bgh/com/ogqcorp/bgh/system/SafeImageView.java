// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import android.graphics.drawable.Drawable;
import com.ogqcorp.commons.k;
import android.app.Activity;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Bitmap$Config;
import java.io.File;
import android.widget.ImageView;

public class SafeImageView extends ImageView
{
    private File a;
    private Bitmap$Config b;
    
    public SafeImageView(final Context context) {
        super(context);
    }
    
    public SafeImageView(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public SafeImageView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
    }
    
    public void a(final File a, final Bitmap$Config b) {
        this.a = a;
        this.b = b;
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ac.a(this);
        this.a(null, null);
    }
    
    protected void onDraw(final Canvas canvas) {
        try {
            super.onDraw(canvas);
        }
        catch (Exception ex) {
            l.c(ex);
        }
    }
    
    protected void onWindowVisibilityChanged(final int n) {
        super.onWindowVisibilityChanged(n);
        if (n == 8) {
            if (!((Activity)this.getContext()).isFinishing()) {
                ac.a(this);
            }
        }
        else if (n == 0 && this.getDrawable() == null && this.a != null && this.a.exists()) {
            this.setImageDrawable((Drawable)k.a(this.a, this.b, -1));
        }
    }
}
