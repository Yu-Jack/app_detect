// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.c.b;

import android.graphics.Bitmap;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;

public class b extends BitmapDrawable implements c
{
    private int a;
    private int b;
    private boolean c;
    
    public b(final Resources resources, final Bitmap bitmap) {
        super(resources, bitmap);
    }
    
    private void b() {
        synchronized (this) {
            boolean b;
            if (this.getBitmap() != null && !this.getBitmap().isRecycled()) {
                b = true;
            }
            else {
                b = false;
            }
            if (this.a <= 0 && this.b <= 0 && this.c && b) {
                this.getBitmap().recycle();
            }
        }
    }
    
    public int a() {
        final Bitmap bitmap = this.getBitmap();
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
    }
    
    public void a(final boolean b) {
        // monitorenter(this)
        Label_0024: {
            if (!b) {
                break Label_0024;
            }
            try {
                ++this.a;
                while (true) {
                    this.b();
                    return;
                    --this.a;
                    continue;
                }
            }
            // monitorexit(this)
            finally {
            }
            // monitorexit(this)
        }
    }
    
    public void b(final boolean b) {
        // monitorenter(this)
        Label_0029: {
            if (!b) {
                break Label_0029;
            }
            try {
                ++this.b;
                this.c = true;
                while (true) {
                    this.b();
                    return;
                    --this.b;
                    continue;
                }
            }
            // monitorexit(this)
            finally {
            }
            // monitorexit(this)
        }
    }
}
