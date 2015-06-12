// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.view.animation.LinearInterpolator;
import android.view.animation.AnimationUtils;
import android.graphics.drawable.Drawable$Callback;
import android.os.Parcelable;
import android.view.accessibility.AccessibilityEvent;
import android.graphics.drawable.Animatable;
import android.os.SystemClock;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.ViewDebug$ExportedProperty;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.Shader;
import android.graphics.BitmapShader;
import android.graphics.Shader$TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LayerDrawable;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import android.view.animation.Transformation;
import android.graphics.Bitmap;
import android.view.animation.Interpolator;
import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.accessibility.AccessibilityManager;
import android.widget.RemoteViews$RemoteView;
import android.view.View;

@RemoteViews$RemoteView
public class IcsProgressBar extends View
{
    private static final int ANIMATION_RESOLUTION = 200;
    private static final boolean IS_HONEYCOMB = false;
    private static final int MAX_LEVEL = 10000;
    private static final int[] ProgressBar;
    private static final int ProgressBar_animationResolution = 14;
    private static final int ProgressBar_indeterminate = 5;
    private static final int ProgressBar_indeterminateBehavior = 10;
    private static final int ProgressBar_indeterminateDrawable = 7;
    private static final int ProgressBar_indeterminateDuration = 9;
    private static final int ProgressBar_indeterminateOnly = 6;
    private static final int ProgressBar_interpolator = 13;
    private static final int ProgressBar_max = 2;
    private static final int ProgressBar_maxHeight = 1;
    private static final int ProgressBar_maxWidth = 0;
    private static final int ProgressBar_minHeight = 12;
    private static final int ProgressBar_minWidth = 11;
    private static final int ProgressBar_progress = 3;
    private static final int ProgressBar_progressDrawable = 8;
    private static final int ProgressBar_secondaryProgress = 4;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    private IcsProgressBar$AccessibilityEventSender mAccessibilityEventSender;
    private AccessibilityManager mAccessibilityManager;
    private AlphaAnimation mAnimation;
    private int mAnimationResolution;
    private int mBehavior;
    private Drawable mCurrentDrawable;
    private int mDuration;
    private boolean mInDrawing;
    private boolean mIndeterminate;
    private Drawable mIndeterminateDrawable;
    private int mIndeterminateRealLeft;
    private int mIndeterminateRealTop;
    private Interpolator mInterpolator;
    private long mLastDrawTime;
    private int mMax;
    int mMaxHeight;
    int mMaxWidth;
    int mMinHeight;
    int mMinWidth;
    private boolean mNoInvalidate;
    private boolean mOnlyIndeterminate;
    private int mProgress;
    private Drawable mProgressDrawable;
    private IcsProgressBar$RefreshProgressRunnable mRefreshProgressRunnable;
    Bitmap mSampleTile;
    private int mSecondaryProgress;
    private boolean mShouldStartAnimationDrawable;
    private Transformation mTransformation;
    private long mUiThreadId;
    
    static {
        ProgressBar = new int[] { 16843039, 16843040, 16843062, 16843063, 16843064, 16843065, 16843066, 16843067, 16843068, 16843069, 16843070, 16843071, 16843072, 16843073, 16843546 };
    }
    
    public IcsProgressBar(final Context context) {
        this(context, null);
    }
    
    public IcsProgressBar(final Context context, final AttributeSet set) {
        this(context, set, 16842871);
    }
    
    public IcsProgressBar(final Context context, final AttributeSet set, final int n) {
        this(context, set, n, 0);
    }
    
    public IcsProgressBar(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n);
        this.mUiThreadId = Thread.currentThread().getId();
        this.initProgressBar();
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, IcsProgressBar.ProgressBar, n, n2);
        this.mNoInvalidate = true;
        final Drawable drawable = obtainStyledAttributes.getDrawable(8);
        if (drawable != null) {
            this.setProgressDrawable(this.tileify(drawable, false));
        }
        this.mDuration = obtainStyledAttributes.getInt(9, this.mDuration);
        this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(11, this.mMinWidth);
        this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(0, this.mMaxWidth);
        this.mMinHeight = obtainStyledAttributes.getDimensionPixelSize(12, this.mMinHeight);
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(1, this.mMaxHeight);
        this.mBehavior = obtainStyledAttributes.getInt(10, this.mBehavior);
        final int resourceId = obtainStyledAttributes.getResourceId(13, 17432587);
        if (resourceId > 0) {
            this.setInterpolator(context, resourceId);
        }
        this.setMax(obtainStyledAttributes.getInt(2, this.mMax));
        this.setProgress(obtainStyledAttributes.getInt(3, this.mProgress));
        this.setSecondaryProgress(obtainStyledAttributes.getInt(4, this.mSecondaryProgress));
        final Drawable drawable2 = obtainStyledAttributes.getDrawable(7);
        if (drawable2 != null) {
            this.setIndeterminateDrawable(this.tileifyIndeterminate(drawable2));
        }
        this.mOnlyIndeterminate = obtainStyledAttributes.getBoolean(6, this.mOnlyIndeterminate);
        this.mNoInvalidate = false;
        boolean indeterminate = false;
        Label_0291: {
            if (!this.mOnlyIndeterminate) {
                final boolean boolean1 = obtainStyledAttributes.getBoolean(5, this.mIndeterminate);
                indeterminate = false;
                if (!boolean1) {
                    break Label_0291;
                }
            }
            indeterminate = true;
        }
        this.setIndeterminate(indeterminate);
        this.mAnimationResolution = obtainStyledAttributes.getInteger(14, 200);
        obtainStyledAttributes.recycle();
        this.mAccessibilityManager = (AccessibilityManager)context.getSystemService("accessibility");
    }
    
    private void doRefreshProgress(final int n, final int n2, final boolean b, final boolean b2) {
    Label_0059_Outer:
        while (true) {
            while (true) {
                float n3 = 0.0f;
                Drawable drawableByLayerId = null;
                Label_0109: {
                    synchronized (this) {
                        if (this.mMax > 0) {
                            n3 = n2 / this.mMax;
                        }
                        else {
                            n3 = 0.0f;
                        }
                        final Drawable mCurrentDrawable = this.mCurrentDrawable;
                        while (true) {
                            if (mCurrentDrawable == null) {
                                this.invalidate();
                                if (b2 && n == 16908301) {
                                    this.onProgressRefresh(n3, b);
                                }
                                return;
                            }
                            final boolean b3 = mCurrentDrawable instanceof LayerDrawable;
                            drawableByLayerId = null;
                            if (b3) {
                                drawableByLayerId = ((LayerDrawable)mCurrentDrawable).findDrawableByLayerId(n);
                            }
                            break Label_0109;
                            final int level;
                            mCurrentDrawable.setLevel(level);
                            continue Label_0059_Outer;
                        }
                    }
                }
                final int level = (int)(10000.0f * n3);
                if (drawableByLayerId != null) {
                    final Drawable mCurrentDrawable = drawableByLayerId;
                    continue;
                }
                continue;
            }
        }
    }
    
    private void initProgressBar() {
        this.mMax = 100;
        this.mProgress = 0;
        this.mSecondaryProgress = 0;
        this.mIndeterminate = false;
        this.mOnlyIndeterminate = false;
        this.mDuration = 4000;
        this.mBehavior = 1;
        this.mMinWidth = 24;
        this.mMaxWidth = 48;
        this.mMinHeight = 24;
        this.mMaxHeight = 48;
    }
    
    private void refreshProgress(final int n, final int n2, final boolean b) {
        while (true) {
            while (true) {
                Label_0070: {
                    synchronized (this) {
                        if (this.mUiThreadId == Thread.currentThread().getId()) {
                            this.doRefreshProgress(n, n2, b, true);
                        }
                        else {
                            if (this.mRefreshProgressRunnable == null) {
                                break Label_0070;
                            }
                            final IcsProgressBar$RefreshProgressRunnable mRefreshProgressRunnable = this.mRefreshProgressRunnable;
                            this.mRefreshProgressRunnable = null;
                            mRefreshProgressRunnable.setup(n, n2, b);
                            this.post((Runnable)mRefreshProgressRunnable);
                        }
                        return;
                    }
                }
                final IcsProgressBar$RefreshProgressRunnable mRefreshProgressRunnable = new IcsProgressBar$RefreshProgressRunnable(this, n, n2, b);
                continue;
            }
        }
    }
    
    private void scheduleAccessibilityEventSender() {
        if (this.mAccessibilityEventSender == null) {
            this.mAccessibilityEventSender = new IcsProgressBar$AccessibilityEventSender(this, null);
        }
        else {
            this.removeCallbacks((Runnable)this.mAccessibilityEventSender);
        }
        this.postDelayed((Runnable)this.mAccessibilityEventSender, 200L);
    }
    
    private Drawable tileify(final Drawable drawable, final boolean b) {
        int i = 0;
        Object o;
        if (drawable instanceof LayerDrawable) {
            final LayerDrawable layerDrawable = (LayerDrawable)drawable;
            final int numberOfLayers = layerDrawable.getNumberOfLayers();
            final Drawable[] array = new Drawable[numberOfLayers];
            for (int j = 0; j < numberOfLayers; ++j) {
                final int id = layerDrawable.getId(j);
                array[j] = this.tileify(layerDrawable.getDrawable(j), id == 16908301 || id == 16908303);
            }
            o = new LayerDrawable(array);
            while (i < numberOfLayers) {
                ((LayerDrawable)o).setId(i, layerDrawable.getId(i));
                ++i;
            }
        }
        else {
            if (!(drawable instanceof BitmapDrawable)) {
                return drawable;
            }
            final Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
            if (this.mSampleTile == null) {
                this.mSampleTile = bitmap;
            }
            final ShapeDrawable shapeDrawable = new ShapeDrawable(this.getDrawableShape());
            shapeDrawable.getPaint().setShader((Shader)new BitmapShader(bitmap, Shader$TileMode.REPEAT, Shader$TileMode.CLAMP));
            if (!b) {
                return (Drawable)shapeDrawable;
            }
            o = new ClipDrawable((Drawable)shapeDrawable, 3, 1);
        }
        return (Drawable)o;
    }
    
    private Drawable tileifyIndeterminate(Drawable drawable) {
        if (drawable instanceof AnimationDrawable) {
            final AnimationDrawable animationDrawable = (AnimationDrawable)drawable;
            final int numberOfFrames = animationDrawable.getNumberOfFrames();
            final AnimationDrawable animationDrawable2 = new AnimationDrawable();
            animationDrawable2.setOneShot(animationDrawable.isOneShot());
            for (int i = 0; i < numberOfFrames; ++i) {
                final Drawable tileify = this.tileify(animationDrawable.getFrame(i), true);
                tileify.setLevel(10000);
                animationDrawable2.addFrame(tileify, animationDrawable.getDuration(i));
            }
            animationDrawable2.setLevel(10000);
            drawable = (Drawable)animationDrawable2;
        }
        return drawable;
    }
    
    private void updateDrawableBounds(final int n, final int n2) {
        final int n3 = n - this.getPaddingRight() - this.getPaddingLeft();
        final int n4 = n2 - this.getPaddingBottom() - this.getPaddingTop();
        int n8 = 0;
        int n9 = 0;
        Label_0160: {
            if (this.mIndeterminateDrawable != null) {
                while (true) {
                    Label_0223: {
                        if (!this.mOnlyIndeterminate || this.mIndeterminateDrawable instanceof AnimationDrawable) {
                            break Label_0223;
                        }
                        final float n5 = this.mIndeterminateDrawable.getIntrinsicWidth() / this.mIndeterminateDrawable.getIntrinsicHeight();
                        final float n6 = n / n2;
                        if (n5 == n6) {
                            break Label_0223;
                        }
                        int mIndeterminateRealLeft;
                        int mIndeterminateRealTop;
                        if (n6 > n5) {
                            final int n7 = (int)(n5 * n2);
                            mIndeterminateRealLeft = (n - n7) / 2;
                            n8 = n7 + mIndeterminateRealLeft;
                            n9 = n4;
                            mIndeterminateRealTop = 0;
                        }
                        else {
                            final int n10 = (int)(n * (1.0f / n5));
                            final int n11 = (n2 - n10) / 2;
                            final int n12 = n10 + n11;
                            n8 = n3;
                            n9 = n12;
                            mIndeterminateRealTop = n11;
                            mIndeterminateRealLeft = 0;
                        }
                        this.mIndeterminateDrawable.setBounds(0, 0, n8 - mIndeterminateRealLeft, n9 - mIndeterminateRealTop);
                        this.mIndeterminateRealLeft = mIndeterminateRealLeft;
                        this.mIndeterminateRealTop = mIndeterminateRealTop;
                        break Label_0160;
                    }
                    n8 = n3;
                    n9 = n4;
                    int mIndeterminateRealLeft = 0;
                    int mIndeterminateRealTop = 0;
                    continue;
                }
            }
            n8 = n3;
            n9 = n4;
        }
        if (this.mProgressDrawable != null) {
            this.mProgressDrawable.setBounds(0, 0, n8, n9);
        }
    }
    
    private void updateDrawableState() {
        final int[] drawableState = this.getDrawableState();
        if (this.mProgressDrawable != null && this.mProgressDrawable.isStateful()) {
            this.mProgressDrawable.setState(drawableState);
        }
        if (this.mIndeterminateDrawable != null && this.mIndeterminateDrawable.isStateful()) {
            this.mIndeterminateDrawable.setState(drawableState);
        }
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.updateDrawableState();
    }
    
    Drawable getCurrentDrawable() {
        return this.mCurrentDrawable;
    }
    
    Shape getDrawableShape() {
        return (Shape)new RoundRectShape(new float[] { 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f }, (RectF)null, (float[])null);
    }
    
    public Drawable getIndeterminateDrawable() {
        return this.mIndeterminateDrawable;
    }
    
    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }
    
    @ViewDebug$ExportedProperty(category = "progress")
    public int getMax() {
        synchronized (this) {
            return this.mMax;
        }
    }
    
    @ViewDebug$ExportedProperty(category = "progress")
    public int getProgress() {
        synchronized (this) {
            int mProgress;
            if (this.mIndeterminate) {
                mProgress = 0;
            }
            else {
                mProgress = this.mProgress;
            }
            return mProgress;
        }
    }
    
    public Drawable getProgressDrawable() {
        return this.mProgressDrawable;
    }
    
    @ViewDebug$ExportedProperty(category = "progress")
    public int getSecondaryProgress() {
        synchronized (this) {
            int mSecondaryProgress;
            if (this.mIndeterminate) {
                mSecondaryProgress = 0;
            }
            else {
                mSecondaryProgress = this.mSecondaryProgress;
            }
            return mSecondaryProgress;
        }
    }
    
    public final void incrementProgressBy(final int n) {
        synchronized (this) {
            this.setProgress(n + this.mProgress);
        }
    }
    
    public final void incrementSecondaryProgressBy(final int n) {
        synchronized (this) {
            this.setSecondaryProgress(n + this.mSecondaryProgress);
        }
    }
    
    public void invalidateDrawable(final Drawable drawable) {
        if (!this.mInDrawing) {
            if (!this.verifyDrawable(drawable)) {
                super.invalidateDrawable(drawable);
                return;
            }
            final Rect bounds = drawable.getBounds();
            final int n = this.getScrollX() + this.getPaddingLeft();
            final int n2 = this.getScrollY() + this.getPaddingTop();
            this.invalidate(n + bounds.left, n2 + bounds.top, n + bounds.right, n2 + bounds.bottom);
        }
    }
    
    @ViewDebug$ExportedProperty(category = "progress")
    public boolean isIndeterminate() {
        synchronized (this) {
            return this.mIndeterminate;
        }
    }
    
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.mProgressDrawable != null) {
            this.mProgressDrawable.jumpToCurrentState();
        }
        if (this.mIndeterminateDrawable != null) {
            this.mIndeterminateDrawable.jumpToCurrentState();
        }
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIndeterminate) {
            this.startAnimation();
        }
    }
    
    protected void onDetachedFromWindow() {
        if (this.mIndeterminate) {
            this.stopAnimation();
        }
        if (this.mRefreshProgressRunnable != null) {
            this.removeCallbacks((Runnable)this.mRefreshProgressRunnable);
        }
        if (this.mAccessibilityEventSender != null) {
            this.removeCallbacks((Runnable)this.mAccessibilityEventSender);
        }
        super.onDetachedFromWindow();
    }
    
    protected void onDraw(final Canvas canvas) {
        synchronized (this) {
            super.onDraw(canvas);
            final Drawable mCurrentDrawable = this.mCurrentDrawable;
            if (mCurrentDrawable == null) {
                return;
            }
            canvas.save();
            canvas.translate((float)(this.getPaddingLeft() + this.mIndeterminateRealLeft), (float)(this.getPaddingTop() + this.mIndeterminateRealTop));
            final long drawingTime = this.getDrawingTime();
            Label_0136: {
                if (this.mAnimation == null) {
                    break Label_0136;
                }
                this.mAnimation.getTransformation(drawingTime, this.mTransformation);
                final float alpha = this.mTransformation.getAlpha();
                try {
                    this.mInDrawing = true;
                    mCurrentDrawable.setLevel((int)(alpha * 10000.0f));
                    this.mInDrawing = false;
                    if (SystemClock.uptimeMillis() - this.mLastDrawTime >= this.mAnimationResolution) {
                        this.mLastDrawTime = SystemClock.uptimeMillis();
                        this.postInvalidateDelayed((long)this.mAnimationResolution);
                    }
                    mCurrentDrawable.draw(canvas);
                    canvas.restore();
                    if (this.mShouldStartAnimationDrawable && mCurrentDrawable instanceof Animatable) {
                        ((Animatable)mCurrentDrawable).start();
                        this.mShouldStartAnimationDrawable = false;
                    }
                }
                finally {
                    this.mInDrawing = false;
                }
            }
        }
    }
    
    public void onInitializeAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setItemCount(this.mMax);
        accessibilityEvent.setCurrentItemIndex(this.mProgress);
    }
    
    protected void onMeasure(final int n, final int n2) {
        while (true) {
            while (true) {
                synchronized (this) {
                    final Drawable mCurrentDrawable = this.mCurrentDrawable;
                    if (mCurrentDrawable != null) {
                        final int max = Math.max(this.mMinWidth, Math.min(this.mMaxWidth, mCurrentDrawable.getIntrinsicWidth()));
                        final int max2 = Math.max(this.mMinHeight, Math.min(this.mMaxHeight, mCurrentDrawable.getIntrinsicHeight()));
                        this.updateDrawableState();
                        final int n3 = max + (this.getPaddingLeft() + this.getPaddingRight());
                        final int n4 = max2 + (this.getPaddingTop() + this.getPaddingBottom());
                        if (IcsProgressBar.IS_HONEYCOMB) {
                            this.setMeasuredDimension(View.resolveSizeAndState(n3, n, 0), View.resolveSizeAndState(n4, n2, 0));
                        }
                        else {
                            this.setMeasuredDimension(View.resolveSize(n3, n), View.resolveSize(n4, n2));
                        }
                        return;
                    }
                }
                final int max2 = 0;
                final int max = 0;
                continue;
            }
        }
    }
    
    void onProgressRefresh(final float n, final boolean b) {
        if (this.mAccessibilityManager.isEnabled()) {
            this.scheduleAccessibilityEventSender();
        }
    }
    
    public void onRestoreInstanceState(final Parcelable parcelable) {
        final IcsProgressBar$SavedState icsProgressBar$SavedState = (IcsProgressBar$SavedState)parcelable;
        super.onRestoreInstanceState(icsProgressBar$SavedState.getSuperState());
        this.setProgress(icsProgressBar$SavedState.progress);
        this.setSecondaryProgress(icsProgressBar$SavedState.secondaryProgress);
    }
    
    public Parcelable onSaveInstanceState() {
        final IcsProgressBar$SavedState icsProgressBar$SavedState = new IcsProgressBar$SavedState(super.onSaveInstanceState());
        icsProgressBar$SavedState.progress = this.mProgress;
        icsProgressBar$SavedState.secondaryProgress = this.mSecondaryProgress;
        return (Parcelable)icsProgressBar$SavedState;
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        this.updateDrawableBounds(n, n2);
    }
    
    protected void onVisibilityChanged(final View view, final int n) {
        super.onVisibilityChanged(view, n);
        if (this.mIndeterminate) {
            if (n != 8 && n != 4) {
                this.startAnimation();
                return;
            }
            this.stopAnimation();
        }
    }
    
    public void postInvalidate() {
        if (!this.mNoInvalidate) {
            super.postInvalidate();
        }
    }
    
    public void setIndeterminate(final boolean mIndeterminate) {
        synchronized (this) {
            if ((!this.mOnlyIndeterminate || !this.mIndeterminate) && mIndeterminate != this.mIndeterminate) {
                this.mIndeterminate = mIndeterminate;
                if (mIndeterminate) {
                    this.mCurrentDrawable = this.mIndeterminateDrawable;
                    this.startAnimation();
                }
                else {
                    this.mCurrentDrawable = this.mProgressDrawable;
                    this.stopAnimation();
                }
            }
        }
    }
    
    public void setIndeterminateDrawable(final Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback((Drawable$Callback)this);
        }
        this.mIndeterminateDrawable = drawable;
        if (this.mIndeterminate) {
            this.mCurrentDrawable = drawable;
            this.postInvalidate();
        }
    }
    
    public void setInterpolator(final Context context, final int n) {
        this.setInterpolator(AnimationUtils.loadInterpolator(context, n));
    }
    
    public void setInterpolator(final Interpolator mInterpolator) {
        this.mInterpolator = mInterpolator;
    }
    
    public void setMax(int n) {
        // monitorenter(this)
        if (n < 0) {
            n = 0;
        }
        try {
            if (n != this.mMax) {
                this.mMax = n;
                this.postInvalidate();
                if (this.mProgress > n) {
                    this.mProgress = n;
                }
                this.refreshProgress(16908301, this.mProgress, false);
            }
        }
        finally {
        }
        // monitorexit(this)
    }
    
    public void setProgress(final int n) {
        synchronized (this) {
            this.setProgress(n, false);
        }
    }
    
    void setProgress(final int n, final boolean b) {
        while (true) {
            while (true) {
                Label_0073: {
                    synchronized (this) {
                        if (!this.mIndeterminate) {
                            if (n >= 0) {
                                break Label_0073;
                            }
                            int mMax = 0;
                            if (mMax > this.mMax) {
                                mMax = this.mMax;
                            }
                            if (mMax != this.mProgress) {
                                this.refreshProgress(16908301, this.mProgress = mMax, b);
                            }
                        }
                        return;
                    }
                }
                int mMax = n;
                continue;
            }
        }
    }
    
    public void setProgressDrawable(final Drawable drawable) {
        int n;
        if (this.mProgressDrawable != null && drawable != this.mProgressDrawable) {
            this.mProgressDrawable.setCallback((Drawable$Callback)null);
            n = 1;
        }
        else {
            n = 0;
        }
        if (drawable != null) {
            drawable.setCallback((Drawable$Callback)this);
            final int minimumHeight = drawable.getMinimumHeight();
            if (this.mMaxHeight < minimumHeight) {
                this.mMaxHeight = minimumHeight;
                this.requestLayout();
            }
        }
        this.mProgressDrawable = drawable;
        if (!this.mIndeterminate) {
            this.mCurrentDrawable = drawable;
            this.postInvalidate();
        }
        if (n != 0) {
            this.updateDrawableBounds(this.getWidth(), this.getHeight());
            this.updateDrawableState();
            this.doRefreshProgress(16908301, this.mProgress, false, false);
            this.doRefreshProgress(16908303, this.mSecondaryProgress, false, false);
        }
    }
    
    public void setSecondaryProgress(final int n) {
        while (true) {
            while (true) {
                Label_0071: {
                    synchronized (this) {
                        if (!this.mIndeterminate) {
                            int mMax = 0;
                            if (n >= 0) {
                                break Label_0071;
                            }
                            if (mMax > this.mMax) {
                                mMax = this.mMax;
                            }
                            if (mMax != this.mSecondaryProgress) {
                                this.refreshProgress(16908303, this.mSecondaryProgress = mMax, false);
                            }
                        }
                        return;
                    }
                }
                int mMax = n;
                continue;
            }
        }
    }
    
    public void setVisibility(final int visibility) {
        if (this.getVisibility() != visibility) {
            super.setVisibility(visibility);
            if (this.mIndeterminate) {
                if (visibility != 8 && visibility != 4) {
                    this.startAnimation();
                    return;
                }
                this.stopAnimation();
            }
        }
    }
    
    void startAnimation() {
        if (this.getVisibility() != 0) {
            return;
        }
        if (this.mIndeterminateDrawable instanceof Animatable) {
            this.mShouldStartAnimationDrawable = true;
            this.mAnimation = null;
        }
        else {
            if (this.mInterpolator == null) {
                this.mInterpolator = (Interpolator)new LinearInterpolator();
            }
            this.mTransformation = new Transformation();
            (this.mAnimation = new AlphaAnimation(0.0f, 1.0f)).setRepeatMode(this.mBehavior);
            this.mAnimation.setRepeatCount(-1);
            this.mAnimation.setDuration((long)this.mDuration);
            this.mAnimation.setInterpolator(this.mInterpolator);
            this.mAnimation.setStartTime(-1L);
        }
        this.postInvalidate();
    }
    
    void stopAnimation() {
        this.mAnimation = null;
        this.mTransformation = null;
        if (this.mIndeterminateDrawable instanceof Animatable) {
            ((Animatable)this.mIndeterminateDrawable).stop();
            this.mShouldStartAnimationDrawable = false;
        }
        this.postInvalidate();
    }
    
    protected boolean verifyDrawable(final Drawable drawable) {
        return drawable == this.mProgressDrawable || drawable == this.mIndeterminateDrawable || super.verifyDrawable(drawable);
    }
}
