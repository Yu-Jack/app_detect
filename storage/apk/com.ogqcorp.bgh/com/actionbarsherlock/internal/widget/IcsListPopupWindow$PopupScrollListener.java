// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.view.View$OnTouchListener;
import android.widget.PopupWindow$OnDismissListener;
import android.widget.ListView;
import android.view.ViewParent;
import android.widget.AbsListView$LayoutParams;
import android.view.ViewGroup;
import android.view.View$MeasureSpec;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
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
import android.view.View;
import android.content.Context;
import android.widget.ListAdapter;
import android.widget.AbsListView;
import android.widget.AbsListView$OnScrollListener;

class IcsListPopupWindow$PopupScrollListener implements AbsListView$OnScrollListener
{
    final /* synthetic */ IcsListPopupWindow this$0;
    
    private IcsListPopupWindow$PopupScrollListener(final IcsListPopupWindow this$0) {
        this.this$0 = this$0;
    }
    
    public void onScroll(final AbsListView absListView, final int n, final int n2, final int n3) {
    }
    
    public void onScrollStateChanged(final AbsListView absListView, final int n) {
        if (n == 1 && !this.this$0.isInputMethodNotNeeded() && this.this$0.mPopup.getContentView() != null) {
            this.this$0.mHandler.removeCallbacks((Runnable)this.this$0.mResizePopupRunnable);
            this.this$0.mResizePopupRunnable.run();
        }
    }
}
