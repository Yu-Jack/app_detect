import android.content.DialogInterface;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ol implements DialogInterface$OnClickListener
{
    final /* synthetic */ NoteListFragment a;
    
    public ol(final NoteListFragment a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        this.a.Z();
    }
}
