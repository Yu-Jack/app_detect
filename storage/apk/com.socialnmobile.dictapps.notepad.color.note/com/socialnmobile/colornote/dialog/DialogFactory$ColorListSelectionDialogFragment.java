// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.dialog;

import android.app.Dialog;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import android.support.v4.app.DialogFragment;

public class DialogFactory$ColorListSelectionDialogFragment extends DialogFragment
{
    ku Y;
    
    public DialogFactory$ColorListSelectionDialogFragment(final NoteListFragment noteListFragment) {
        this.Y = new ku(noteListFragment);
        this.o();
    }
    
    @Override
    public final Dialog b() {
        return this.Y;
    }
    
    @Override
    public final void w() {
        super.w();
        this.a(false);
    }
}
