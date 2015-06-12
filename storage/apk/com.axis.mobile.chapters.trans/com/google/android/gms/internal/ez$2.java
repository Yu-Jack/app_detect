// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsResult;
import android.content.DialogInterface$OnClickListener;

final class ez$2 implements DialogInterface$OnClickListener
{
    final /* synthetic */ JsResult sP;
    
    ez$2(final JsResult sp) {
        this.sP = sp;
    }
    
    public void onClick(final DialogInterface dialogInterface, final int n) {
        this.sP.cancel();
    }
}
