// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

class IcsProgressBar$AccessibilityEventSender implements Runnable
{
    final /* synthetic */ IcsProgressBar this$0;
    
    private IcsProgressBar$AccessibilityEventSender(final IcsProgressBar this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void run() {
        this.this$0.sendAccessibilityEvent(4);
    }
}
