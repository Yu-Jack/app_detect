// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import android.view.MotionEvent;
import android.graphics.BitmapFactory;
import java.util.Random;
import java.io.FilenameFilter;
import java.io.File;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.content.Context;

public final class SplashSurfaceView extends t
{
    private static final int[] a;
    private Integer b;
    private boolean c;
    
    static {
        a = new int[] { 2130837738, 2130837739 };
    }
    
    public SplashSurfaceView(final Context context) {
        super(context);
        this.c = false;
    }
    
    public SplashSurfaceView(final Context context, final AttributeSet set) {
        super(context, set);
        this.c = false;
    }
    
    public SplashSurfaceView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.c = false;
    }
    
    private Bitmap getLandscapeBitmap() {
        final Bitmap originalBitmap = this.getOriginalBitmap();
        final float n = originalBitmap.getWidth() / this.getWidth() * this.getHeight();
        final float n2 = 0.3f * (originalBitmap.getHeight() - n);
        Bitmap bitmap;
        if (n2 >= 0.0f) {
            bitmap = Bitmap.createBitmap(originalBitmap, 0, (int)n2, originalBitmap.getWidth(), (int)n);
            if (originalBitmap != bitmap) {
                originalBitmap.recycle();
            }
        }
        else {
            bitmap = originalBitmap;
        }
        final Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, (int)(1.2f * this.getWidth()), (int)(1.2f * this.getHeight()), true);
        if (bitmap != scaledBitmap) {
            bitmap.recycle();
        }
        return scaledBitmap;
    }
    
    @Override
    protected void a() {
        super.a();
        this.setUseEdgeEffect(false);
    }
    
    @Override
    protected Bitmap getBitmap() {
        try {
            if (this.getWidth() > 0 + this.getHeight()) {
                return this.getLandscapeBitmap();
            }
            return super.getBitmap();
        }
        catch (Exception ex) {
            if (this.c) {
                return null;
            }
            this.c = true;
            return this.getBitmap();
        }
    }
    
    @Override
    protected Bitmap getOriginalBitmap() {
        if (!this.c) {
            try {
                final File[] listFiles = new File(v.a().e(this.getContext())).listFiles(new FilenameFilter() {
                    @Override
                    public boolean accept(final File file, final String s) {
                        return s.endsWith("_BG.jpg");
                    }
                });
                if (listFiles.length != 0) {
                    return BitmapFactory.decodeFile(listFiles[new Random().nextInt(listFiles.length)].getAbsolutePath());
                }
            }
            catch (Exception ex) {
                com.ogqcorp.bgh.system.l.b(ex);
            }
        }
        if (this.b == null) {
            this.b = new Random().nextInt(SplashSurfaceView.a.length);
        }
        return BitmapFactory.decodeResource(this.getResources(), SplashSurfaceView.a[this.b]);
    }
    
    @Override
    public boolean onDown(final MotionEvent motionEvent) {
        return false;
    }
    
    @Override
    public boolean onFling(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float n, final float n2) {
        return false;
    }
    
    @Override
    public boolean onScroll(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float n, final float n2) {
        return false;
    }
}
