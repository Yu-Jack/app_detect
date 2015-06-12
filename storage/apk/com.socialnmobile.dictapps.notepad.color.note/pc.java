import android.content.Context;
import com.socialnmobile.colornote.fragment.NoteListFragment;

// 
// Decompiled by Procyon v0.5.29
// 

public final class pc implements lh
{
    final /* synthetic */ NoteListFragment a;
    
    public pc(final NoteListFragment a) {
        this.a = a;
    }
    
    @Override
    public final boolean a(final String s) {
        final boolean a = jq.a((Context)this.a.h(), s);
        boolean b = false;
        if (a) {
            kg.a((Context)this.a.h(), this.a.ac, false);
            b = true;
        }
        return b;
    }
}
