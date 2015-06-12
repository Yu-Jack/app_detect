// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.os.Parcelable;
import android.view.ViewGroup;
import android.view.View$MeasureSpec;
import android.widget.Adapter;
import android.view.ViewGroup$LayoutParams;
import android.util.AttributeSet;
import android.content.Context;
import android.os.Build$VERSION;
import android.graphics.Rect;
import android.database.DataSetObserver;
import android.widget.SpinnerAdapter;
import android.view.View;
import android.util.SparseArray;

class IcsAbsSpinner$RecycleBin
{
    private final SparseArray<View> mScrapHeap;
    final /* synthetic */ IcsAbsSpinner this$0;
    
    IcsAbsSpinner$RecycleBin(final IcsAbsSpinner this$0) {
        this.this$0 = this$0;
        this.mScrapHeap = (SparseArray<View>)new SparseArray();
    }
    
    void clear() {
        final SparseArray<View> mScrapHeap = this.mScrapHeap;
        for (int size = mScrapHeap.size(), i = 0; i < size; ++i) {
            final View view = (View)mScrapHeap.valueAt(i);
            if (view != null) {
                IcsAbsSpinner.access$100(this.this$0, view, true);
            }
        }
        mScrapHeap.clear();
    }
    
    View get(final int n) {
        final View view = (View)this.mScrapHeap.get(n);
        if (view != null) {
            this.mScrapHeap.delete(n);
        }
        return view;
    }
    
    public void put(final int n, final View view) {
        this.mScrapHeap.put(n, (Object)view);
    }
}
