// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

class IcsListPopupWindow$ListSelectorHider implements Runnable
{
    final /* synthetic */ IcsListPopupWindow this$0;
    
    private IcsListPopupWindow$ListSelectorHider(final IcsListPopupWindow this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void run() {
        this.this$0.clearListSelection();
    }
}
