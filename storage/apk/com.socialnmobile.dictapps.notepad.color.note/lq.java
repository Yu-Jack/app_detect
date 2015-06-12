import android.content.Context;
import com.socialnmobile.colornote.view.NotesOptions;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import android.app.Dialog;

// 
// Decompiled by Procyon v0.5.29
// 

public final class lq extends Dialog
{
    NoteListFragment a;
    NotesOptions b;
    
    public lq(final NoteListFragment a, final int n) {
        super((Context)a.h(), n);
        this.setContentView(2130903057);
        this.a = a;
        this.setCanceledOnTouchOutside(true);
        (this.b = (NotesOptions)this.findViewById(2131624036)).a(a, this);
    }
}
