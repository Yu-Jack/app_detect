// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.content.DialogInterface$OnClickListener;

final class ez$5 implements DialogInterface$OnClickListener
{
    final /* synthetic */ JsPromptResult sQ;
    
    ez$5(final JsPromptResult sq) {
        this.sQ = sq;
    }
    
    public void onClick(final DialogInterface dialogInterface, final int n) {
        this.sQ.cancel();
    }
}
