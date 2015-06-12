// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsResult;
import android.content.DialogInterface$OnCancelListener;

final class ez$1 implements DialogInterface$OnCancelListener
{
    final /* synthetic */ JsResult sP;
    
    ez$1(final JsResult sp) {
        this.sP = sp;
    }
    
    public void onCancel(final DialogInterface dialogInterface) {
        this.sP.cancel();
    }
}
