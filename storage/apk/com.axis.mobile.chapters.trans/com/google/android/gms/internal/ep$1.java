// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.view.MotionEvent;
import java.util.Iterator;
import java.util.Map;
import android.net.Uri;
import android.app.AlertDialog$Builder;
import android.net.Uri$Builder;
import android.text.TextUtils;
import android.content.Context;
import android.content.Intent;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;

class ep$1 implements DialogInterface$OnClickListener
{
    final /* synthetic */ String st;
    final /* synthetic */ ep su;
    
    ep$1(final ep su, final String st) {
        this.su = su;
        this.st = st;
    }
    
    public void onClick(final DialogInterface dialogInterface, final int n) {
        this.su.mContext.startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", this.st), (CharSequence)"Share via"));
    }
}
