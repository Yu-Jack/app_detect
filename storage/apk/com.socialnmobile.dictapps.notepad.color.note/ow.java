import com.socialnmobile.colornote.view.ScreenGridList;
import com.socialnmobile.colornote.fragment.NoteListFragment;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ow implements rg
{
    final /* synthetic */ NoteListFragment a;
    private final /* synthetic */ String b;
    
    public ow(final NoteListFragment a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final boolean a(final int n, final String s) {
        final ScreenGridList p2 = this.a.P();
        if (this.a.I() == 1) {
            p2.a(n, true);
        }
        else {
            p2.a(n, false);
        }
        this.a.a(this.b);
        return true;
    }
}
