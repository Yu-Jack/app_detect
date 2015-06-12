// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.dialog;

import android.support.v4.app.DialogFragment;
import android.content.DialogInterface$OnClickListener;

public final class DialogFactory
{
    public static DialogFragment a(final int n, final int n2, final DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return new DialogFactory$ConfirmDialogFragment(2130837583, n, n2, true, dialogInterface$OnClickListener);
    }
    
    public static DialogFragment a(final DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return new DialogFactory$ConfirmDialogFragment(2130837583, 2131231067, 2131231068, 2131231067, 0, false, false, dialogInterface$OnClickListener);
    }
    
    public static DialogFragment a(final lh lh) {
        return new lc(lh);
    }
    
    public static DialogFragment b(final int n, final int n2, final DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return new DialogFactory$ConfirmDialogFragment(0, n, n2, true, dialogInterface$OnClickListener);
    }
}
