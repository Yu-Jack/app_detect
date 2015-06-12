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

class IcsProgressBar$RefreshProgressRunnable implements Runnable
{
    private boolean mFromUser;
    private int mId;
    private int mProgress;
    final /* synthetic */ IcsProgressBar this$0;
    
    IcsProgressBar$RefreshProgressRunnable(final IcsProgressBar this$0, final int mId, final int mProgress, final boolean mFromUser) {
        this.this$0 = this$0;
        this.mId = mId;
        this.mProgress = mProgress;
        this.mFromUser = mFromUser;
    }
    
    @Override
    public void run() {
        this.this$0.doRefreshProgress(this.mId, this.mProgress, this.mFromUser, true);
        this.this$0.mRefreshProgressRunnable = this;
    }
    
    public void setup(final int mId, final int mProgress, final boolean mFromUser) {
        this.mId = mId;
        this.mProgress = mProgress;
        this.mFromUser = mFromUser;
    }
}
