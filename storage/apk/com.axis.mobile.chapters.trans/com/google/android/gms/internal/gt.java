// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable$ConstantState;
import android.os.SystemClock;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable;

public final class gt extends Drawable implements Drawable$Callback
{
    private int FA;
    private int FB;
    private boolean FC;
    private gt$b FD;
    private Drawable FE;
    private Drawable FF;
    private boolean FG;
    private boolean FH;
    private boolean FI;
    private int FJ;
    private boolean Fp;
    private int Fv;
    private long Fw;
    private int Fx;
    private int Fy;
    private int Fz;
    
    public gt(Drawable fh, Drawable fh2) {
        this(null);
        if (fh == null) {
            fh = gt$a.FK;
        }
        (this.FE = fh).setCallback((Drawable$Callback)this);
        final gt$b fd = this.FD;
        fd.FN |= fh.getChangingConfigurations();
        if (fh2 == null) {
            fh2 = gt$a.FK;
        }
        (this.FF = fh2).setCallback((Drawable$Callback)this);
        final gt$b fd2 = this.FD;
        fd2.FN |= fh2.getChangingConfigurations();
    }
    
    gt(final gt$b gt$b) {
        this.Fv = 0;
        this.Fz = 255;
        this.FB = 0;
        this.Fp = true;
        this.FD = new gt$b(gt$b);
    }
    
    public boolean canConstantState() {
        if (!this.FG) {
            this.FH = (this.FE.getConstantState() != null && this.FF.getConstantState() != null);
            this.FG = true;
        }
        return this.FH;
    }
    
    public void draw(final Canvas canvas) {
        boolean b = true;
        int n = 0;
        Label_0031: {
            switch (this.Fv) {
                case 1: {
                    this.Fw = SystemClock.uptimeMillis();
                    this.Fv = 2;
                    n = 0;
                    break Label_0031;
                }
                case 2: {
                    if (this.Fw >= 0L) {
                        final float a = (SystemClock.uptimeMillis() - this.Fw) / this.FA;
                        if (a < 1.0f) {
                            b = false;
                        }
                        if (b) {
                            this.Fv = 0;
                        }
                        this.FB = (int)(this.Fx + Math.min(a, 1.0f) * (this.Fy - this.Fx));
                        break;
                    }
                    break;
                }
            }
            n = (b ? 1 : 0);
        }
        final int fb = this.FB;
        final boolean fp = this.Fp;
        final Drawable fe = this.FE;
        final Drawable ff = this.FF;
        if (n != 0) {
            if (!fp || fb == 0) {
                fe.draw(canvas);
            }
            if (fb == this.Fz) {
                ff.setAlpha(this.Fz);
                ff.draw(canvas);
            }
            return;
        }
        if (fp) {
            fe.setAlpha(this.Fz - fb);
        }
        fe.draw(canvas);
        if (fp) {
            fe.setAlpha(this.Fz);
        }
        if (fb > 0) {
            ff.setAlpha(fb);
            ff.draw(canvas);
            ff.setAlpha(this.Fz);
        }
        this.invalidateSelf();
    }
    
    public Drawable fg() {
        return this.FF;
    }
    
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.FD.FM | this.FD.FN;
    }
    
    public Drawable$ConstantState getConstantState() {
        if (this.canConstantState()) {
            this.FD.FM = this.getChangingConfigurations();
            return this.FD;
        }
        return null;
    }
    
    public int getIntrinsicHeight() {
        return Math.max(this.FE.getIntrinsicHeight(), this.FF.getIntrinsicHeight());
    }
    
    public int getIntrinsicWidth() {
        return Math.max(this.FE.getIntrinsicWidth(), this.FF.getIntrinsicWidth());
    }
    
    public int getOpacity() {
        if (!this.FI) {
            this.FJ = Drawable.resolveOpacity(this.FE.getOpacity(), this.FF.getOpacity());
            this.FI = true;
        }
        return this.FJ;
    }
    
    public void invalidateDrawable(final Drawable drawable) {
        if (ip.gc()) {
            final Drawable$Callback callback = this.getCallback();
            if (callback != null) {
                callback.invalidateDrawable((Drawable)this);
            }
        }
    }
    
    public Drawable mutate() {
        if (!this.FC && super.mutate() == this) {
            if (!this.canConstantState()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.FE.mutate();
            this.FF.mutate();
            this.FC = true;
        }
        return this;
    }
    
    protected void onBoundsChange(final Rect rect) {
        this.FE.setBounds(rect);
        this.FF.setBounds(rect);
    }
    
    public void scheduleDrawable(final Drawable drawable, final Runnable runnable, final long n) {
        if (ip.gc()) {
            final Drawable$Callback callback = this.getCallback();
            if (callback != null) {
                callback.scheduleDrawable((Drawable)this, runnable, n);
            }
        }
    }
    
    public void setAlpha(final int n) {
        if (this.FB == this.Fz) {
            this.FB = n;
        }
        this.Fz = n;
        this.invalidateSelf();
    }
    
    public void setColorFilter(final ColorFilter colorFilter) {
        this.FE.setColorFilter(colorFilter);
        this.FF.setColorFilter(colorFilter);
    }
    
    public void startTransition(final int fa) {
        this.Fx = 0;
        this.Fy = this.Fz;
        this.FB = 0;
        this.FA = fa;
        this.Fv = 1;
        this.invalidateSelf();
    }
    
    public void unscheduleDrawable(final Drawable drawable, final Runnable runnable) {
        if (ip.gc()) {
            final Drawable$Callback callback = this.getCallback();
            if (callback != null) {
                callback.unscheduleDrawable((Drawable)this, runnable);
            }
        }
    }
}
