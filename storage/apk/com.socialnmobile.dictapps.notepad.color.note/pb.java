import android.content.Context;
import com.socialnmobile.colornote.fragment.NoteListFragment;

// 
// Decompiled by Procyon v0.5.29
// 

public final class pb implements lh
{
    final /* synthetic */ NoteListFragment a;
    
    public pb(final NoteListFragment a) {
        this.a = a;
    }
    
    @Override
    public final boolean a(final String s) {
        if (jq.a((Context)this.a.h(), s)) {
            kg.a((Context)this.a.h(), this.a.ac, true);
            if (gu.a(this.a.ab)) {
                this.a.e(1018);
            }
            return true;
        }
        return false;
    }
}
