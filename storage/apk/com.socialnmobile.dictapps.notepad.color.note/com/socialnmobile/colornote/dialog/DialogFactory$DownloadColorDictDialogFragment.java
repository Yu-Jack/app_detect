// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.dialog;

import android.content.DialogInterface$OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.content.Context;
import android.app.AlertDialog$Builder;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;

public final class DialogFactory$DownloadColorDictDialogFragment extends DialogFragment
{
    @Override
    public final Dialog b() {
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)super.C);
        alertDialog$Builder.setTitle(2131230910);
        alertDialog$Builder.setMessage(2131230911);
        final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pname:com.socialnmobile.colordict"));
        intent.setFlags(524288);
        if (gw.a((Context)super.C, intent)) {
            alertDialog$Builder.setPositiveButton(2131230912, (DialogInterface$OnClickListener)new la(this, intent));
        }
        else {
            alertDialog$Builder.setPositiveButton(17039370, (DialogInterface$OnClickListener)new lb(this));
        }
        return (Dialog)alertDialog$Builder.create();
    }
}
