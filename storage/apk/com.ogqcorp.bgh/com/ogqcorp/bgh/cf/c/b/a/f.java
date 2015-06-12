// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.c.b.a;

import com.a.a.o;
import com.a.a.y;
import com.a.a.a.h;
import android.content.res.Resources;
import com.ogqcorp.bgh.cf.c.b.b;
import com.a.a.x;
import com.a.a.m;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory$Options;
import com.a.a.q;
import com.a.a.k;
import com.a.a.u;
import com.a.a.e;
import com.a.a.r;
import android.graphics.Bitmap$Config;
import com.a.a.s;
import android.graphics.drawable.Drawable;
import com.a.a.n;

public class f extends n<Drawable>
{
    private static final Object e;
    private final s<Drawable> a;
    private final Bitmap$Config b;
    private final int c;
    private final int d;
    
    static {
        e = new Object();
    }
    
    public f(final String s, final s<Drawable> a, final int c, final int d, final Bitmap$Config b, final r r) {
        super(0, s, r);
        this.a(new e(1000, 2, 2.0f));
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    static int a(final int n, final int n2, final int n3, final int n4) {
        double min;
        float n5;
        for (min = Math.min(n / n3, n2 / n4), n5 = 1.0f; n5 * 2.0f <= min; n5 *= 2.0f) {}
        return (int)n5;
    }
    
    private static int b(int n, final int n2, final int n3, final int n4) {
        if (n == 0 && n2 == 0) {
            n = n3;
        }
        else {
            if (n == 0) {
                return n2 / n4 * n3;
            }
            if (n2 != 0) {
                final double n5 = n4 / n3;
                if (n5 * n > n2) {
                    return (int)(n2 / n5);
                }
            }
        }
        return n;
    }
    
    private q<Drawable> b(final k k) {
        final byte[] b = k.b;
        final BitmapFactory$Options bitmapFactory$Options = new BitmapFactory$Options();
        Bitmap decodeByteArray;
        if (this.c == 0 && this.d == 0) {
            bitmapFactory$Options.inPreferredConfig = this.b;
            decodeByteArray = BitmapFactory.decodeByteArray(b, 0, b.length, bitmapFactory$Options);
        }
        else {
            bitmapFactory$Options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(b, 0, b.length, bitmapFactory$Options);
            final int outWidth = bitmapFactory$Options.outWidth;
            final int outHeight = bitmapFactory$Options.outHeight;
            final int b2 = b(this.c, this.d, outWidth, outHeight);
            final int b3 = b(this.d, this.c, outHeight, outWidth);
            bitmapFactory$Options.inJustDecodeBounds = false;
            bitmapFactory$Options.inSampleSize = a(outWidth, outHeight, b2, b3);
            final Bitmap decodeByteArray2 = BitmapFactory.decodeByteArray(b, 0, b.length, bitmapFactory$Options);
            if (decodeByteArray2 != null && (decodeByteArray2.getWidth() > b2 || decodeByteArray2.getHeight() > b3)) {
                final Bitmap scaledBitmap = Bitmap.createScaledBitmap(decodeByteArray2, b2, b3, true);
                decodeByteArray2.recycle();
                decodeByteArray = scaledBitmap;
            }
            else {
                decodeByteArray = decodeByteArray2;
            }
        }
        if (decodeByteArray == null) {
            return q.a(new m(k));
        }
        final b b4 = new b(null, decodeByteArray);
        b4.setTargetDensity(decodeByteArray.getDensity());
        return q.a((Drawable)b4, com.a.a.a.h.a(k));
    }
    
    @Override
    protected q<Drawable> a(final k k) {
        synchronized (f.e) {
            try {
                return this.b(k);
            }
            catch (OutOfMemoryError outOfMemoryError) {
                y.c("Caught OOM for %d byte image, url=%s", k.b.length, this.c());
                return q.a(new m(outOfMemoryError));
            }
        }
    }
    
    @Override
    protected void a(final Drawable drawable) {
        this.a.a(drawable);
    }
    
    @Override
    public o r() {
        return o.a;
    }
}
