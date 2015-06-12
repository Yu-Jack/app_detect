import android.content.Context;
import android.content.DialogInterface;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class oo implements DialogInterface$OnClickListener
{
    final /* synthetic */ NoteListFragment a;
    
    public oo(final NoteListFragment a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        kg.a((Context)this.a.h(), this.a.ac, true);
        if (gu.a(this.a.ab)) {
            this.a.e(1018);
        }
    }
}
