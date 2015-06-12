// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.widget.PopupWindow$OnDismissListener;
import android.widget.ListView;
import android.view.ViewParent;
import android.widget.AbsListView$LayoutParams;
import android.view.ViewGroup;
import android.view.View$MeasureSpec;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.AbsListView$OnScrollListener;
import android.widget.AdapterView;
import android.view.ContextThemeWrapper;
import android.os.Build$VERSION;
import android.util.AttributeSet;
import com.actionbarsherlock.R$attr;
import android.graphics.Rect;
import android.database.DataSetObserver;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.AdapterView$OnItemClickListener;
import android.os.Handler;
import android.graphics.drawable.Drawable;
import android.content.Context;
import android.widget.ListAdapter;
import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnTouchListener;

class IcsListPopupWindow$PopupTouchInterceptor implements View$OnTouchListener
{
    final /* synthetic */ IcsListPopupWindow this$0;
    
    private IcsListPopupWindow$PopupTouchInterceptor(final IcsListPopupWindow this$0) {
        this.this$0 = this$0;
    }
    
    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        final int action = motionEvent.getAction();
        final int n = (int)motionEvent.getX();
        final int n2 = (int)motionEvent.getY();
        if (action == 0 && this.this$0.mPopup != null && this.this$0.mPopup.isShowing() && n >= 0 && n < this.this$0.mPopup.getWidth() && n2 >= 0 && n2 < this.this$0.mPopup.getHeight()) {
            this.this$0.mHandler.postDelayed((Runnable)this.this$0.mResizePopupRunnable, 250L);
        }
        else if (action == 1) {
            this.this$0.mHandler.removeCallbacks((Runnable)this.this$0.mResizePopupRunnable);
        }
        return false;
    }
}
