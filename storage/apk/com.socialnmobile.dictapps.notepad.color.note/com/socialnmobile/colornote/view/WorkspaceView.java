// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.view;

import android.graphics.Rect;
import android.view.View;
import android.view.MotionEvent;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.FrameLayout;

public abstract class WorkspaceView extends FrameLayout
{
    public WorkspaceView(final Context context) {
        super(context);
    }
    
    public WorkspaceView(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    public WorkspaceView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
    }
    
    public void cancelLongPress() {
        super.cancelLongPress();
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            this.getChildAt(i).cancelLongPress();
        }
    }
    
    public void dispatchDraw(final Canvas canvas) {
        super.dispatchDraw(canvas);
    }
    
    public boolean dispatchTouchEvent(final MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }
    
    public void requestChildFocus(final View view, final View view2) {
        super.requestChildFocus(view, view2);
        if (view != null) {
            final Rect rect = new Rect();
            view.getDrawingRect(rect);
            this.requestRectangleOnScreen(rect);
        }
    }
    
    protected void setChildrenDrawingCacheEnabled(final boolean b) {
        super.setChildrenDrawingCacheEnabled(b);
        for (int childCount = this.getChildCount(), i = 0; i < childCount; ++i) {
            final View child = this.getChildAt(i);
            child.setDrawingCacheEnabled(b);
            child.buildDrawingCache(true);
        }
    }
    
    protected void setChildrenDrawnWithCacheEnabled(final boolean childrenDrawnWithCacheEnabled) {
        super.setChildrenDrawnWithCacheEnabled(childrenDrawnWithCacheEnabled);
    }
}
