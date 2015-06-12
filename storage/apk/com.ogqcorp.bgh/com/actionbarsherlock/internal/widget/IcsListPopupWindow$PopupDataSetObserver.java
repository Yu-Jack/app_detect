// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.database.DataSetObserver;

class IcsListPopupWindow$PopupDataSetObserver extends DataSetObserver
{
    final /* synthetic */ IcsListPopupWindow this$0;
    
    private IcsListPopupWindow$PopupDataSetObserver(final IcsListPopupWindow this$0) {
        this.this$0 = this$0;
    }
    
    public void onChanged() {
        if (this.this$0.isShowing()) {
            this.this$0.show();
        }
    }
    
    public void onInvalidated() {
        this.this$0.dismiss();
    }
}
