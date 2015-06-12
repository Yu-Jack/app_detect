// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.dialog;

import android.content.Context;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;

public final class DialogFactory$ColorSelectorDialogFragment extends DialogFragment
{
    int Y;
    int Z;
    kz aa;
    
    public DialogFactory$ColorSelectorDialogFragment(final int y, final int z, final kz aa) {
        this.Y = y;
        this.Z = z;
        this.aa = aa;
        this.o();
    }
    
    @Override
    public final Dialog b() {
        final kx kx = new kx((Context)super.C, this.Y, this.Z);
        kx.a(this.aa);
        return kx;
    }
    
    @Override
    public final void w() {
        super.w();
        this.a(false);
    }
}
