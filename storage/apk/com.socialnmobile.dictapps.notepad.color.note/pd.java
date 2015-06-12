import android.view.View;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import android.view.View$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class pd implements View$OnClickListener
{
    final /* synthetic */ NoteListFragment a;
    
    public pd(final NoteListFragment a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        switch (view.getId()) {
            default: {}
            case 2131624078:
            case 2131624079:
            case 2131624080: {
                this.a.c(view.getId());
            }
        }
    }
}
