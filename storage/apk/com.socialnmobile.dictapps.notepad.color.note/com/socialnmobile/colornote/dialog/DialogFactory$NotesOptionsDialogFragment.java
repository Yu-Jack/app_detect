// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.dialog;

import android.content.Context;
import android.app.Dialog;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import android.support.v4.app.DialogFragment;

public final class DialogFactory$NotesOptionsDialogFragment extends DialogFragment
{
    NoteListFragment Y;
    
    public DialogFactory$NotesOptionsDialogFragment(final NoteListFragment y) {
        this.Y = y;
    }
    
    @Override
    public final Dialog b() {
        if (gr.a((Context)super.C).a()) {
            return new lq(this.Y, 2131492870);
        }
        return new lq(this.Y, 2131492869);
    }
    
    @Override
    public final void w() {
        super.w();
        this.a(false);
    }
}
