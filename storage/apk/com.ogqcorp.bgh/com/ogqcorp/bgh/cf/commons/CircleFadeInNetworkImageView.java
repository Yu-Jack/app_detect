// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.commons;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Xfermode;
import android.graphics.PorterDuffXfermode;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.content.Context;
import com.ogqcorp.bgh.cf.c.b.a.g;

public class CircleFadeInNetworkImageView extends g
{
    public CircleFadeInNetworkImageView(final Context context) {
        super(context);
    }
    
    public CircleFadeInNetworkImageView(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public CircleFadeInNetworkImageView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
    }
    
    public static Bitmap a(Bitmap scaledBitmap, final int n) {
        if (scaledBitmap.getWidth() != n || scaledBitmap.getHeight() != n) {
            scaledBitmap = Bitmap.createScaledBitmap(scaledBitmap, n, n, true);
        }
        final Bitmap bitmap = Bitmap.createBitmap(scaledBitmap.getWidth(), scaledBitmap.getHeight(), Bitmap$Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap);
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, scaledBitmap.getWidth(), scaledBitmap.getHeight());
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-6187148);
        canvas.drawCircle(0.7f + scaledBitmap.getWidth() / 2, 0.7f + scaledBitmap.getHeight() / 2, 0.1f + scaledBitmap.getWidth() / 2, paint);
        paint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff$Mode.SRC_IN));
        canvas.drawBitmap(scaledBitmap, rect, rect, paint);
        return bitmap;
    }
    
    protected void onDraw(final Canvas canvas) {
        final Drawable drawable = this.getDrawable();
        if (drawable != null && this.getWidth() != 0 && this.getHeight() != 0 && drawable instanceof BitmapDrawable) {
            final Bitmap copy = ((BitmapDrawable)drawable).getBitmap().copy(Bitmap$Config.ARGB_8888, true);
            final Bitmap a = a(copy, this.getWidth());
            canvas.drawBitmap(a, 0.0f, 0.0f, (Paint)null);
            a.recycle();
            copy.recycle();
        }
    }
}
