import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.GestureDetector$SimpleOnGestureListener;

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.view;

import android.view.ViewGroup$LayoutParams;
import android.graphics.Bitmap$Config;
import android.view.ViewGroup;
import android.view.GestureDetector$OnGestureListener;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewConfiguration;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.Bitmap;
import android.view.GestureDetector;
import android.view.WindowManager$LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;

public final class zc extends GestureDetector$SimpleOnGestureListener
{
    final /* synthetic */ DragDropListView a;
    
    public zc(final DragDropListView a) {
        this.a = a;
    }
    
    public final boolean onFling(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float n, final float n2) {
        if (DragDropListView.a(this.a) != null) {
            if (n > 1000.0f) {
                final Rect b = DragDropListView.b(this.a);
                DragDropListView.a(this.a).getDrawingRect(b);
                if (motionEvent2.getX() > 2 * b.right / 3) {
                    this.a.a();
                    DragDropListView.d(this.a).a(DragDropListView.e(this.a));
                    DragDropListView.f(this.a);
                }
            }
            return true;
        }
        return false;
    }
}
