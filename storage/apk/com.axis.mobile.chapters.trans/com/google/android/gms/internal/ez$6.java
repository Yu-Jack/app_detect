// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.widget.EditText;
import android.webkit.JsPromptResult;
import android.content.DialogInterface$OnClickListener;

final class ez$6 implements DialogInterface$OnClickListener
{
    final /* synthetic */ JsPromptResult sQ;
    final /* synthetic */ EditText sR;
    
    ez$6(final JsPromptResult sq, final EditText sr) {
        this.sQ = sq;
        this.sR = sr;
    }
    
    public void onClick(final DialogInterface dialogInterface, final int n) {
        this.sQ.confirm(this.sR.getText().toString());
    }
}
