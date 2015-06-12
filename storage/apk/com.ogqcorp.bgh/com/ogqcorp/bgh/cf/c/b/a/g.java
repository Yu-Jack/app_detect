// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.c.b.a;

import com.a.a.x;
import android.text.TextUtils;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.content.Context;
import com.ogqcorp.bgh.cf.c.b.d;

public class g extends d
{
    private String a;
    private int b;
    private int c;
    private a d;
    private com.ogqcorp.bgh.cf.c.b.a.d e;
    
    public g(final Context context) {
        this(context, null);
    }
    
    public g(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public g(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
    }
    
    private void a() {
        if (this.b != 0) {
            this.setImageResource(this.b);
            return;
        }
        this.setImageDrawable(null);
    }
    
    public void a(final String a, final a d) {
        this.a = a;
        this.d = d;
        this.a(false);
    }
    
    void a(final boolean b) {
        int n = 1;
        final int width = this.getWidth();
        final int height = this.getHeight();
        int n2;
        int n3;
        if (this.getLayoutParams() != null) {
            if (this.getLayoutParams().width == -2) {
                n2 = n;
            }
            else {
                n2 = 0;
            }
            if (this.getLayoutParams().height == -2) {
                n3 = n;
            }
            else {
                n3 = 0;
            }
        }
        else {
            n2 = 0;
            n3 = 0;
        }
        if (n2 == 0 || n3 == 0) {
            n = 0;
        }
        if (width != 0 || height != 0 || n != 0) {
            if (TextUtils.isEmpty((CharSequence)this.a)) {
                if (this.e != null) {
                    this.e.a();
                    this.e = null;
                }
                this.a();
                return;
            }
            if (this.e != null && this.e.c() != null) {
                if (this.e.c().equals(this.a)) {
                    return;
                }
                this.e.a();
                this.a();
            }
            int n4;
            if (n2 != 0) {
                n4 = 0;
            }
            else {
                n4 = width;
            }
            int n5 = 0;
            if (n3 == 0) {
                n5 = height;
            }
            this.e = this.d.a(this.a, new e() {
                @Override
                public void a(final x x) {
                    if (g.this.c != 0) {
                        g.this.setImageResource(g.this.c);
                    }
                }
                
                @Override
                public void a(final com.ogqcorp.bgh.cf.c.b.a.d d, final boolean b) {
                    if (b && b) {
                        g.this.post((Runnable)new Runnable() {
                            @Override
                            public void run() {
                                e.this.a(d, false);
                            }
                        });
                    }
                    else {
                        if (d.b() != null) {
                            g.this.setImageDrawable(d.b());
                            return;
                        }
                        if (g.this.b != 0) {
                            g.this.setImageResource(g.this.b);
                        }
                    }
                }
            }, n4, n5);
        }
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.invalidate();
    }
    
    @Override
    protected void onDetachedFromWindow() {
        if (this.e != null) {
            this.e.a();
            this.setImageDrawable(null);
            this.e = null;
        }
        super.onDetachedFromWindow();
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        this.a(true);
    }
    
    public void setDefaultImageResId(final int b) {
        this.b = b;
    }
    
    public void setErrorImageResId(final int c) {
        this.c = c;
    }
}
