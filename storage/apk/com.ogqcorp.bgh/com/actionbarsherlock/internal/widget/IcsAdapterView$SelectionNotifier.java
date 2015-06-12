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
import android.os.Parcelable;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.AdapterView$OnItemClickListener;
import android.view.ViewDebug$ExportedProperty;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

class IcsAdapterView$SelectionNotifier implements Runnable
{
    final /* synthetic */ IcsAdapterView this$0;
    
    private IcsAdapterView$SelectionNotifier(final IcsAdapterView this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void run() {
        if (this.this$0.mDataChanged) {
            if (this.this$0.getAdapter() != null) {
                this.this$0.post((Runnable)this);
            }
            return;
        }
        this.this$0.fireOnSelected();
    }
}
