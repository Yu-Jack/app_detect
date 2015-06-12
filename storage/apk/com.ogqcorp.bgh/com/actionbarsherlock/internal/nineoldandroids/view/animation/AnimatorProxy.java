// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.nineoldandroids.view.animation;

import android.view.animation.Transformation;
import android.util.FloatMath;
import android.os.Build$VERSION;
import java.lang.ref.WeakReference;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import java.util.WeakHashMap;
import android.view.animation.Animation;

public final class AnimatorProxy extends Animation
{
    public static final boolean NEEDS_PROXY;
    private static final WeakHashMap<View, AnimatorProxy> PROXIES;
    private final RectF mAfter;
    private float mAlpha;
    private final RectF mBefore;
    private float mScaleX;
    private float mScaleY;
    private final Matrix mTempMatrix;
    private float mTranslationX;
    private float mTranslationY;
    private final WeakReference<View> mView;
    
    static {
        NEEDS_PROXY = (Build$VERSION.SDK_INT < 11);
        PROXIES = new WeakHashMap<View, AnimatorProxy>();
    }
    
    private AnimatorProxy(final View referent) {
        this.mAlpha = 1.0f;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mBefore = new RectF();
        this.mAfter = new RectF();
        this.mTempMatrix = new Matrix();
        this.setDuration(0L);
        this.setFillAfter(true);
        referent.setAnimation((Animation)this);
        this.mView = new WeakReference<View>(referent);
    }
    
    private void computeRect(final RectF rectF, final View view) {
        rectF.set(0.0f, 0.0f, (float)view.getWidth(), (float)view.getHeight());
        final Matrix mTempMatrix = this.mTempMatrix;
        mTempMatrix.reset();
        this.transformMatrix(mTempMatrix, view);
        this.mTempMatrix.mapRect(rectF);
        rectF.offset((float)view.getLeft(), (float)view.getTop());
        if (rectF.right < rectF.left) {
            final float right = rectF.right;
            rectF.right = rectF.left;
            rectF.left = right;
        }
        if (rectF.bottom < rectF.top) {
            final float top = rectF.top;
            rectF.top = rectF.bottom;
            rectF.bottom = top;
        }
    }
    
    private void invalidateAfterUpdate() {
        final View view = this.mView.get();
        if (view != null) {
            final View view2 = (View)view.getParent();
            if (view2 != null) {
                view.setAnimation((Animation)this);
                final RectF mAfter = this.mAfter;
                this.computeRect(mAfter, view);
                mAfter.union(this.mBefore);
                view2.invalidate((int)FloatMath.floor(mAfter.left), (int)FloatMath.floor(mAfter.top), (int)FloatMath.ceil(mAfter.right), (int)FloatMath.ceil(mAfter.bottom));
            }
        }
    }
    
    private void prepareForUpdate() {
        final View view = this.mView.get();
        if (view != null) {
            this.computeRect(this.mBefore, view);
        }
    }
    
    private void transformMatrix(final Matrix matrix, final View view) {
        final float n = view.getWidth();
        final float n2 = view.getHeight();
        final float mScaleX = this.mScaleX;
        final float mScaleY = this.mScaleY;
        if (mScaleX != 1.0f || mScaleY != 1.0f) {
            final float n3 = (mScaleX * n - n) / 2.0f;
            final float n4 = (mScaleY * n2 - n2) / 2.0f;
            matrix.postScale(mScaleX, mScaleY);
            matrix.postTranslate(-n3, -n4);
        }
        matrix.postTranslate(this.mTranslationX, this.mTranslationY);
    }
    
    public static AnimatorProxy wrap(final View view) {
        AnimatorProxy value = AnimatorProxy.PROXIES.get(view);
        if (value == null) {
            value = new AnimatorProxy(view);
            AnimatorProxy.PROXIES.put(view, value);
        }
        return value;
    }
    
    protected void applyTransformation(final float n, final Transformation transformation) {
        final View view = this.mView.get();
        if (view != null) {
            transformation.setAlpha(this.mAlpha);
            this.transformMatrix(transformation.getMatrix(), view);
        }
    }
    
    public float getAlpha() {
        return this.mAlpha;
    }
    
    public float getScaleX() {
        return this.mScaleX;
    }
    
    public float getScaleY() {
        return this.mScaleY;
    }
    
    public int getScrollX() {
        final View view = this.mView.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }
    
    public int getScrollY() {
        final View view = this.mView.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }
    
    public float getTranslationX() {
        return this.mTranslationX;
    }
    
    public float getTranslationY() {
        return this.mTranslationY;
    }
    
    public void reset() {
    }
    
    public void setAlpha(final float mAlpha) {
        if (this.mAlpha != mAlpha) {
            this.mAlpha = mAlpha;
            final View view = this.mView.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }
    
    public void setScaleX(final float mScaleX) {
        if (this.mScaleX != mScaleX) {
            this.prepareForUpdate();
            this.mScaleX = mScaleX;
            this.invalidateAfterUpdate();
        }
    }
    
    public void setScaleY(final float mScaleY) {
        if (this.mScaleY != mScaleY) {
            this.prepareForUpdate();
            this.mScaleY = mScaleY;
            this.invalidateAfterUpdate();
        }
    }
    
    public void setScrollX(final int n) {
        final View view = this.mView.get();
        if (view != null) {
            view.scrollTo(n, view.getScrollY());
        }
    }
    
    public void setScrollY(final int n) {
        final View view = this.mView.get();
        if (view != null) {
            view.scrollTo(view.getScrollY(), n);
        }
    }
    
    public void setTranslationX(final float mTranslationX) {
        if (this.mTranslationX != mTranslationX) {
            this.prepareForUpdate();
            this.mTranslationX = mTranslationX;
            this.invalidateAfterUpdate();
        }
    }
    
    public void setTranslationY(final float mTranslationY) {
        if (this.mTranslationY != mTranslationY) {
            this.prepareForUpdate();
            this.mTranslationY = mTranslationY;
            this.invalidateAfterUpdate();
        }
    }
}
