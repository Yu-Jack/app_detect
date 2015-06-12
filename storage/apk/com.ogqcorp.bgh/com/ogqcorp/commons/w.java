// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons;

import android.widget.TextView;
import android.widget.CompoundButton;
import android.view.animation.Animation;
import android.view.animation.AlphaAnimation;
import android.app.Activity;
import android.view.View;

public class w
{
    protected View a;
    private View b;
    private Activity c;
    
    public w(final Activity activity) {
        this(activity, null);
    }
    
    public w(final Activity c, final View view) {
        this.c = c;
        this.b = view;
        this.a = view;
    }
    
    private View d(final int n) {
        if (this.b != null) {
            return this.b.findViewById(n);
        }
        if (this.c != null) {
            return this.c.findViewById(n);
        }
        return null;
    }
    
    public w a() {
        return this.b(0);
    }
    
    public w a(final float n) {
        if (this.a != null) {
            if (n < 1.0f) {
                final AlphaAnimation alphaAnimation = new AlphaAnimation(n, n);
                alphaAnimation.setDuration(0L);
                alphaAnimation.setFillAfter(true);
                this.a.startAnimation((Animation)alphaAnimation);
                return this;
            }
            this.a.clearAnimation();
        }
        return this;
    }
    
    public w a(final int n) {
        return this.a(this.d(n));
    }
    
    public w a(final View a) {
        this.a = a;
        this.d();
        return this;
    }
    
    public w a(final boolean enabled) {
        if (this.a != null) {
            this.a.setEnabled(enabled);
        }
        return this;
    }
    
    public w b(final int visibility) {
        if (this.a != null && this.a.getVisibility() != visibility) {
            this.a.setVisibility(visibility);
        }
        return this;
    }
    
    public w b(final boolean checked) {
        if (this.a instanceof CompoundButton) {
            ((CompoundButton)this.a).setChecked(checked);
        }
        return this;
    }
    
    public boolean b() {
        return this.a != null && this.a.isEnabled();
    }
    
    public w c(final int text) {
        if (this.a instanceof TextView) {
            ((TextView)this.a).setText(text);
        }
        return this;
    }
    
    public boolean c() {
        return this.a instanceof CompoundButton && ((CompoundButton)this.a).isChecked();
    }
    
    protected void d() {
    }
}
