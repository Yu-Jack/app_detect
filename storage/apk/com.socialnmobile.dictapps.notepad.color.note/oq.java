import android.content.Context;
import com.socialnmobile.colornote.fragment.NoteListFragment;

// 
// Decompiled by Procyon v0.5.29
// 

public final class oq implements ma
{
    final /* synthetic */ NoteListFragment a;
    
    public oq(final NoteListFragment a) {
        this.a = a;
    }
    
    @Override
    public final void a(final String s) {
        jq.a((Context)this.a.h(), this.a.ae, this.a.ad, s);
        if (this.a.Y != null) {
            this.a.Y.a();
        }
    }
}
