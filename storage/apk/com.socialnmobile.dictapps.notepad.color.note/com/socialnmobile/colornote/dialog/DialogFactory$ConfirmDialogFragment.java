// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.dialog;

import android.app.AlertDialog;
import android.app.AlertDialog$Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface$OnClickListener;
import android.support.v4.app.DialogFragment;

public class DialogFactory$ConfirmDialogFragment extends DialogFragment
{
    int Y;
    int Z;
    int aa;
    int ab;
    int ac;
    boolean ad;
    boolean ae;
    DialogInterface$OnClickListener af;
    
    public DialogFactory$ConfirmDialogFragment(final int z, final int y, final int aa, final int ab, final int ac, final boolean ad, final boolean ae, final DialogInterface$OnClickListener af) {
        this.Y = y;
        this.Z = z;
        this.aa = aa;
        this.ab = ab;
        this.ac = ac;
        this.af = af;
        this.ad = ad;
        this.ae = ae;
        this.o();
    }
    
    public DialogFactory$ConfirmDialogFragment(final int n, final int n2, final int n3, final boolean b, final DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        this(n, n2, n3, 17039370, 17039360, b, true, dialogInterface$OnClickListener);
    }
    
    public final Dialog a(final Context context) {
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder(context);
        if (this.Z != 0) {
            alertDialog$Builder.setIcon(this.Z);
        }
        alertDialog$Builder.setTitle(this.Y);
        alertDialog$Builder.setMessage(this.aa);
        alertDialog$Builder.setPositiveButton(this.ab, this.af);
        if (this.ad) {
            alertDialog$Builder.setNegativeButton(this.ac, (DialogInterface$OnClickListener)null);
        }
        final AlertDialog create = alertDialog$Builder.create();
        ((Dialog)create).setCanceledOnTouchOutside(this.ae);
        return (Dialog)create;
    }
    
    @Override
    public final Dialog b() {
        return this.a((Context)super.C);
    }
    
    @Override
    public final void w() {
        super.w();
        this.a(false);
    }
}
