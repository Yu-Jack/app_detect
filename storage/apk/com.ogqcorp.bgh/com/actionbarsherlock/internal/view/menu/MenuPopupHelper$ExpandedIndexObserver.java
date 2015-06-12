// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.view.menu;

import android.util.AttributeSet;
import com.actionbarsherlock.R$attr;
import android.os.Parcelable;
import android.view.KeyEvent;
import com.actionbarsherlock.view.MenuItem;
import android.widget.AdapterView;
import com.actionbarsherlock.internal.view.View_HasStateListenerSupport;
import android.widget.FrameLayout;
import android.view.View$MeasureSpec;
import android.widget.ListAdapter;
import android.content.res.Resources;
import com.actionbarsherlock.R$dimen;
import com.actionbarsherlock.R$layout;
import android.view.ViewTreeObserver;
import com.actionbarsherlock.internal.widget.IcsListPopupWindow;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.content.Context;
import android.view.View;
import com.actionbarsherlock.internal.view.View_OnAttachStateChangeListener;
import android.widget.PopupWindow$OnDismissListener;
import android.widget.AdapterView$OnItemClickListener;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.View$OnKeyListener;
import android.database.DataSetObserver;

class MenuPopupHelper$ExpandedIndexObserver extends DataSetObserver
{
    final /* synthetic */ MenuPopupHelper this$0;
    
    private MenuPopupHelper$ExpandedIndexObserver(final MenuPopupHelper this$0) {
        this.this$0 = this$0;
    }
    
    public void onChanged() {
        this.this$0.mAdapter.findExpandedIndex();
    }
}
