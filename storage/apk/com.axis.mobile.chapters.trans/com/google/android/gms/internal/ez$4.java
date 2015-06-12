// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.content.DialogInterface$OnCancelListener;

final class ez$4 implements DialogInterface$OnCancelListener
{
    final /* synthetic */ JsPromptResult sQ;
    
    ez$4(final JsPromptResult sq) {
        this.sQ = sq;
    }
    
    public void onCancel(final DialogInterface dialogInterface) {
        this.sQ.cancel();
    }
}
