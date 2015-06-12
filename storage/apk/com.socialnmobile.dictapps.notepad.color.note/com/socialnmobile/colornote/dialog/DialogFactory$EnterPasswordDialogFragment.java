// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.dialog;

import android.content.DialogInterface;
import android.content.Context;
import android.app.Dialog;
import android.os.Bundle;
import android.content.DialogInterface$OnCancelListener;
import android.support.v4.app.DialogFragment;

public class DialogFactory$EnterPasswordDialogFragment extends DialogFragment
{
    lh Y;
    DialogInterface$OnCancelListener Z;
    int aa;
    
    public DialogFactory$EnterPasswordDialogFragment() {
    }
    
    public DialogFactory$EnterPasswordDialogFragment(final lh y, final DialogInterface$OnCancelListener z) {
        this.Y = y;
        this.Z = z;
        this.aa = 0;
        this.o();
    }
    
    @Override
    public final void a(final Bundle bundle) {
        super.a(bundle);
        if (this.Y == null) {
            this.a(false);
        }
    }
    
    @Override
    public final Dialog b() {
        return new ld((Context)super.C, this.Y, this.Z, this.aa);
    }
    
    @Override
    public void onCancel(final DialogInterface dialogInterface) {
        if (this.Z != null) {
            this.Z.onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }
    
    @Override
    public final void w() {
        super.w();
        this.a(false);
    }
}
