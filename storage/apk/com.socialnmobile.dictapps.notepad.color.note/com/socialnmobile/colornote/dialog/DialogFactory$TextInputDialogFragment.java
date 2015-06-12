// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.DialogFragment;

public class DialogFactory$TextInputDialogFragment extends DialogFragment
{
    lv Y;
    
    public DialogFactory$TextInputDialogFragment(final Context context, final ma ma) {
        this.Y = new lv(context, ma);
        this.o();
    }
    
    public final void a(final String s) {
        this.Y.a(s);
    }
    
    @Override
    public final Dialog b() {
        return (Dialog)this.Y;
    }
    
    @Override
    public final void w() {
        super.w();
        this.a(false);
    }
}
