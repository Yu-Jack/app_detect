import android.content.Context;
import android.content.DialogInterface;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class or implements DialogInterface$OnClickListener
{
    final /* synthetic */ NoteListFragment a;
    
    public or(final NoteListFragment a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        kg.a((Context)this.a.h(), this.a.ac, this.a.ab.m);
    }
}
