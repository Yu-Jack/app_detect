// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.dialog;

import android.content.Context;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DatePickerDialog$OnDateSetListener;
import android.support.v4.app.DialogFragment;

public final class DialogFactory$DatePickerDialogFragment extends DialogFragment
{
    int Y;
    int Z;
    DatePickerDialog$OnDateSetListener aa;
    
    public DialogFactory$DatePickerDialogFragment(final DatePickerDialog$OnDateSetListener aa, final int y, final int z) {
        this.aa = aa;
        this.Y = y;
        this.Z = z;
        this.o();
    }
    
    @Override
    public final Dialog b() {
        final DatePickerDialog datePickerDialog = new DatePickerDialog((Context)super.C, this.aa, this.Y, this.Z, 1);
        ((Dialog)datePickerDialog).setCancelable(true);
        ((Dialog)datePickerDialog).setCanceledOnTouchOutside(true);
        return (Dialog)datePickerDialog;
    }
    
    @Override
    public final void w() {
        super.w();
        this.a(false);
    }
}
