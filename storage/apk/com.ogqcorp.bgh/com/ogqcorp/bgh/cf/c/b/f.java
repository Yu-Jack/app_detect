// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.c.b;

import com.ogqcorp.bgh.cf.c.b.a.c;
import android.graphics.drawable.Drawable;
import android.support.v4.c.e;

class f extends e<String, Drawable> implements c
{
    public f(final int n) {
        super(n);
    }
    
    @Override
    public Drawable a(final String s) {
        final Drawable drawable = this.a(s);
        if (drawable != null && !(drawable instanceof com.ogqcorp.bgh.cf.c.b.c)) {
            throw new IllegalStateException("drawable is not RecyclingDrawable");
        }
        return drawable;
    }
    
    @Override
    public void a(final String s, final Drawable drawable) {
        if (drawable instanceof com.ogqcorp.bgh.cf.c.b.c) {
            ((com.ogqcorp.bgh.cf.c.b.c)drawable).a(true);
        }
        this.a(s, drawable);
    }
    
    @Override
    protected void a(final boolean b, final String s, final Drawable drawable, final Drawable drawable2) {
        if (drawable instanceof com.ogqcorp.bgh.cf.c.b.c) {
            ((com.ogqcorp.bgh.cf.c.b.c)drawable).a(false);
        }
    }
    
    @Override
    protected int b(final String s, final Drawable drawable) {
        if (drawable instanceof com.ogqcorp.bgh.cf.c.b.c) {
            return ((com.ogqcorp.bgh.cf.c.b.c)drawable).a();
        }
        return 0;
    }
}
