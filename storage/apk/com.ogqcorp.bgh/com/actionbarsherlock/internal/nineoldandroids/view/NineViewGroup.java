// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.nineoldandroids.view;

import android.view.animation.Animation;
import android.util.AttributeSet;
import android.view.View;
import android.content.Context;
import com.actionbarsherlock.internal.nineoldandroids.view.animation.AnimatorProxy;
import android.view.ViewGroup;

public abstract class NineViewGroup extends ViewGroup
{
    private final AnimatorProxy mProxy;
    
    public NineViewGroup(final Context context) {
        super(context);
        AnimatorProxy wrap;
        if (AnimatorProxy.NEEDS_PROXY) {
            wrap = AnimatorProxy.wrap((View)this);
        }
        else {
            wrap = null;
        }
        this.mProxy = wrap;
    }
    
    public NineViewGroup(final Context context, final AttributeSet set) {
        super(context, set);
        AnimatorProxy wrap;
        if (AnimatorProxy.NEEDS_PROXY) {
            wrap = AnimatorProxy.wrap((View)this);
        }
        else {
            wrap = null;
        }
        this.mProxy = wrap;
    }
    
    public NineViewGroup(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        AnimatorProxy wrap;
        if (AnimatorProxy.NEEDS_PROXY) {
            wrap = AnimatorProxy.wrap((View)this);
        }
        else {
            wrap = null;
        }
        this.mProxy = wrap;
    }
    
    public float getAlpha() {
        if (AnimatorProxy.NEEDS_PROXY) {
            return this.mProxy.getAlpha();
        }
        return super.getAlpha();
    }
    
    public float getTranslationX() {
        if (AnimatorProxy.NEEDS_PROXY) {
            return this.mProxy.getTranslationX();
        }
        return super.getTranslationX();
    }
    
    public float getTranslationY() {
        if (AnimatorProxy.NEEDS_PROXY) {
            return this.mProxy.getTranslationY();
        }
        return super.getTranslationY();
    }
    
    public void setAlpha(final float n) {
        if (AnimatorProxy.NEEDS_PROXY) {
            this.mProxy.setAlpha(n);
            return;
        }
        super.setAlpha(n);
    }
    
    public void setTranslationX(final float n) {
        if (AnimatorProxy.NEEDS_PROXY) {
            this.mProxy.setTranslationX(n);
            return;
        }
        super.setTranslationX(n);
    }
    
    public void setTranslationY(final float n) {
        if (AnimatorProxy.NEEDS_PROXY) {
            this.mProxy.setTranslationY(n);
            return;
        }
        super.setTranslationY(n);
    }
    
    public void setVisibility(final int visibility) {
        if (this.mProxy != null) {
            if (visibility == 8) {
                this.clearAnimation();
            }
            else if (visibility == 0) {
                this.setAnimation((Animation)this.mProxy);
            }
        }
        super.setVisibility(visibility);
    }
}
