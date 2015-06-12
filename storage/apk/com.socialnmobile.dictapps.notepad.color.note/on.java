import android.content.DialogInterface;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class on implements DialogInterface$OnClickListener
{
    final /* synthetic */ NoteListFragment a;
    
    public on(final NoteListFragment a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        this.a.e(1006);
    }
}
