// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.widget.ListAdapter;

interface IcsSpinner$SpinnerPopup
{
    void dismiss();
    
    CharSequence getHintText();
    
    boolean isShowing();
    
    void setAdapter(ListAdapter p0);
    
    void setPromptText(CharSequence p0);
    
    void show();
}
