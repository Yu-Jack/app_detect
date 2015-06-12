// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.view.View$OnClickListener;
import android.widget.AdapterView;
import android.view.accessibility.AccessibilityRecord;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.ViewDebug$CapturedViewProperty;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.accessibility.AccessibilityEvent;
import android.view.ViewGroup$LayoutParams;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.AdapterView$OnItemClickListener;
import android.view.ViewDebug$ExportedProperty;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.os.Parcelable;
import android.database.DataSetObserver;

class IcsAdapterView$AdapterDataSetObserver extends DataSetObserver
{
    private Parcelable mInstanceState;
    final /* synthetic */ IcsAdapterView this$0;
    
    IcsAdapterView$AdapterDataSetObserver(final IcsAdapterView this$0) {
        this.this$0 = this$0;
        this.mInstanceState = null;
    }
    
    public void clearSavedState() {
        this.mInstanceState = null;
    }
    
    public void onChanged() {
        this.this$0.mDataChanged = true;
        this.this$0.mOldItemCount = this.this$0.mItemCount;
        this.this$0.mItemCount = this.this$0.getAdapter().getCount();
        if (this.this$0.getAdapter().hasStableIds() && this.mInstanceState != null && this.this$0.mOldItemCount == 0 && this.this$0.mItemCount > 0) {
            IcsAdapterView.access$000(this.this$0, this.mInstanceState);
            this.mInstanceState = null;
        }
        else {
            this.this$0.rememberSyncState();
        }
        this.this$0.checkFocus();
        this.this$0.requestLayout();
    }
    
    public void onInvalidated() {
        this.this$0.mDataChanged = true;
        if (this.this$0.getAdapter().hasStableIds()) {
            this.mInstanceState = IcsAdapterView.access$100(this.this$0);
        }
        this.this$0.mOldItemCount = this.this$0.mItemCount;
        this.this$0.mItemCount = 0;
        this.this$0.mSelectedPosition = -1;
        this.this$0.mSelectedRowId = Long.MIN_VALUE;
        this.this$0.mNextSelectedPosition = -1;
        this.this$0.mNextSelectedRowId = Long.MIN_VALUE;
        this.this$0.mNeedSync = false;
        this.this$0.checkFocus();
        this.this$0.requestLayout();
    }
}
