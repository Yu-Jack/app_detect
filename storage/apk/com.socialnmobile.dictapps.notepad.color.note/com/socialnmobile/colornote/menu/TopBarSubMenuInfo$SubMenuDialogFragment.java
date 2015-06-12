// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.menu;

import android.app.AlertDialog;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.DialogFragment;

public final class TopBarSubMenuInfo$SubMenuDialogFragment extends DialogFragment
{
    TopBarSubMenuInfo Y;
    
    public TopBarSubMenuInfo$SubMenuDialogFragment(final TopBarSubMenuInfo y) {
        this.Y = y;
    }
    
    public final Dialog a(final Context context) {
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder(context);
        alertDialog$Builder.setTitle((CharSequence)this.Y.c);
        alertDialog$Builder.setAdapter(this.Y.b(context), (DialogInterface$OnClickListener)new ri(this.Y));
        final AlertDialog create = alertDialog$Builder.create();
        create.setCanceledOnTouchOutside(true);
        return (Dialog)create;
    }
    
    @Override
    public final Dialog b() {
        return this.a((Context)super.C);
    }
}
