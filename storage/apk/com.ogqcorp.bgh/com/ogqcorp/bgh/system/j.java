// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.ogqcorp.commons.g;
import android.graphics.Bitmap$Config;
import android.widget.ImageView;
import java.io.File;

public final class j
{
    private String a;
    private File b;
    
    private void a(final ImageView imageView, final Bitmap$Config bitmap$Config, final Object o) {
        if (imageView.getDrawable() != null && (imageView.getTag() == null || imageView.getTag().equals(o))) {
            return;
        }
        imageView.setTag(o);
        ac.a(imageView);
        if (imageView instanceof SafeImageView) {
            ((SafeImageView)imageView).a(null, null);
        }
        g.a().a(o, this.a, this.b, (View)imageView, bitmap$Config, new k(null));
    }
    
    public void a(final Context context, final int i, final ImageView imageView) {
        if (this.a == null) {
            this.a = o.b().a(context, i);
        }
        if (this.b == null) {
            this.b = o.b().a(i);
        }
        this.a(imageView, Bitmap$Config.RGB_565, i);
    }
    
    public void b(final Context context, final int i, final ImageView imageView) {
        if (this.a == null) {
            this.a = o.b().b(context, i);
        }
        if (this.b == null) {
            this.b = o.b().b(i);
        }
        this.a(imageView, null, i);
    }
    
    public void c(final Context context, final int i, final ImageView imageView) {
        if (this.a == null) {
            this.a = o.b().c(context, i);
        }
        if (this.b == null) {
            this.b = o.b().c(i);
        }
        this.a(imageView, Bitmap$Config.RGB_565, i);
    }
    
    public void d(final Context context, final int i, final ImageView imageView) {
        if (this.a == null) {
            this.a = o.b().d(context, i);
        }
        if (this.b == null) {
            this.b = o.b().d(i);
        }
        this.a(imageView, Bitmap$Config.RGB_565, i);
    }
}
