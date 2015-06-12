// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.util.AttributeSet;
import com.actionbarsherlock.R$attr;
import android.content.Context;
import android.widget.ListView;

class IcsListPopupWindow$DropDownListView extends ListView
{
    private boolean mHijackFocus;
    private boolean mListSelectionHidden;
    
    public IcsListPopupWindow$DropDownListView(final Context context, final boolean mHijackFocus) {
        super(context, (AttributeSet)null, R$attr.dropDownListViewStyle);
        this.mHijackFocus = mHijackFocus;
        this.setCacheColorHint(0);
    }
    
    public boolean hasFocus() {
        return this.mHijackFocus || super.hasFocus();
    }
    
    public boolean hasWindowFocus() {
        return this.mHijackFocus || super.hasWindowFocus();
    }
    
    public boolean isFocused() {
        return this.mHijackFocus || super.isFocused();
    }
    
    public boolean isInTouchMode() {
        return (this.mHijackFocus && this.mListSelectionHidden) || super.isInTouchMode();
    }
}
