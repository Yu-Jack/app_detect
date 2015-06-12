// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.widget.a;

import android.graphics.Canvas;
import java.io.File;
import android.graphics.Bitmap$Config;
import android.graphics.drawable.Drawable;
import android.graphics.Bitmap$CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.app.Activity;
import android.os.Handler;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.ImageView;

public class e extends ImageView
{
    public e(final Context context) {
        super(context);
    }
    
    public e(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public e(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
    }
    
    private void a() {
        new Handler().post((Runnable)new Runnable() {
            @Override
            public void run() {
                e.this.b();
            }
        });
    }
    
    private void b() {
        try {
            if (((Activity)this.getContext()).isFinishing()) {
                return;
            }
            final Drawable drawable = this.getDrawable();
            if (drawable instanceof BitmapDrawable) {
                c.a((BitmapDrawable)drawable, this.getCacheFile(), Bitmap$CompressFormat.JPEG, 90);
            }
            h.a(this);
        }
        catch (Exception ex) {
            d.c(ex);
        }
    }
    
    private void c() {
        if (this.getDrawable() != null) {
            return;
        }
        final File cacheFile = this.getCacheFile();
        if (cacheFile.exists()) {
            this.setImageDrawable((Drawable)c.a(cacheFile, Bitmap$Config.RGB_565, -1));
        }
        cacheFile.delete();
    }
    
    private File getCacheFile() {
        return new File(this.getContext().getFilesDir(), Integer.toHexString(this.hashCode()));
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h.a(this);
        this.getCacheFile().delete();
    }
    
    protected void onDraw(final Canvas canvas) {
        try {
            super.onDraw(canvas);
        }
        catch (Exception ex) {
            d.c(ex);
        }
    }
    
    protected void onWindowVisibilityChanged(final int n) {
        super.onWindowVisibilityChanged(n);
        if (n == 8) {
            this.a();
        }
        else if (n == 0) {
            this.c();
        }
    }
}
