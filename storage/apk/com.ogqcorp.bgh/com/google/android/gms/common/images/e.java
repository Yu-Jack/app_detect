// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.common.images;

import android.graphics.drawable.BitmapDrawable;
import com.google.android.gms.internal.fw;
import android.graphics.Bitmap;
import com.google.android.gms.internal.fd;
import android.content.res.Resources;
import com.google.android.gms.internal.fu;
import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.ft;
import android.content.Context;

public abstract class e
{
    final f a;
    protected int b;
    protected int c;
    
    private Drawable a(final Context context, final ft ft, final int n) {
        final Resources resources = context.getResources();
        if (this.c > 0) {
            final fu fu = new fu(n, this.c);
            Drawable drawable = ft.a(fu);
            if (drawable == null) {
                drawable = resources.getDrawable(n);
                if ((0x1 & this.c) != 0x0) {
                    drawable = this.a(resources, drawable);
                }
                ft.b(fu, drawable);
            }
            return drawable;
        }
        return resources.getDrawable(n);
    }
    
    protected Drawable a(final Resources resources, final Drawable drawable) {
        return fd.a(resources, drawable);
    }
    
    void a(final Context context, Bitmap a, final boolean b) {
        fw.a(a);
        if ((0x1 & this.c) != 0x0) {
            a = fd.a(a);
        }
        this.a((Drawable)new BitmapDrawable(context.getResources(), a), b, false, true);
    }
    
    void a(final Context context, final ft ft, final boolean b) {
        final int b2 = this.b;
        Drawable a = null;
        if (b2 != 0) {
            a = this.a(context, ft, this.b);
        }
        this.a(a, b, false, false);
    }
    
    protected abstract void a(final Drawable p0, final boolean p1, final boolean p2, final boolean p3);
}
