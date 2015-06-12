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
import android.view.View;
import android.content.Context;
import android.widget.ListAdapter;

class IcsListPopupWindow$ResizePopupRunnable implements Runnable
{
    final /* synthetic */ IcsListPopupWindow this$0;
    
    private IcsListPopupWindow$ResizePopupRunnable(final IcsListPopupWindow this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void run() {
        if (this.this$0.mDropDownList != null && this.this$0.mDropDownList.getCount() > this.this$0.mDropDownList.getChildCount() && this.this$0.mDropDownList.getChildCount() <= this.this$0.mListItemExpandMaximum) {
            this.this$0.mPopup.setInputMethodMode(2);
            this.this$0.show();
        }
    }
}
