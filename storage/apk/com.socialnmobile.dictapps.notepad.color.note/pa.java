import android.content.Context;
import com.socialnmobile.colornote.fragment.NoteListFragment;

// 
// Decompiled by Procyon v0.5.29
// 

public final class pa implements lh
{
    final /* synthetic */ NoteListFragment a;
    
    public pa(final NoteListFragment a) {
        this.a = a;
    }
    
    @Override
    public final boolean a(final String s) {
        if (jq.a((Context)this.a.h(), s)) {
            kg.a((Context)this.a.h(), this.a.ac, this.a.R());
            return true;
        }
        return false;
    }
}
