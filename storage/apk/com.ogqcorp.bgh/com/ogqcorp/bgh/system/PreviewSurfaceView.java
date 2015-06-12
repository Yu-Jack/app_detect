// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import android.view.SurfaceHolder;
import android.view.MotionEvent;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.content.Context;
import java.io.File;

public final class PreviewSurfaceView extends t
{
    private File a;
    
    public PreviewSurfaceView(final Context context) {
        super(context);
    }
    
    public PreviewSurfaceView(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public PreviewSurfaceView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
    }
    
    @Override
    protected void a() {
        this.getHolder().setFormat(1);
        super.a();
    }
    
    @Override
    protected Bitmap getOriginalBitmap() {
        if (this.a == null) {
            return null;
        }
        return BitmapFactory.decodeFile(this.a.getAbsolutePath());
    }
    
    @Override
    public boolean onDown(final MotionEvent motionEvent) {
        this.setAutoScrolling(false);
        return super.onDown(motionEvent);
    }
    
    public void setBitmapFile(final File a) {
        this.a = a;
    }
    
    @Override
    public void surfaceCreated(final SurfaceHolder surfaceHolder) {
        this.setAutoScrolling(true);
        super.surfaceCreated(surfaceHolder);
    }
}
