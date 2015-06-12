import android.support.v4.app.DialogFragment;
import com.socialnmobile.colornote.fragment.NoteListFragment;

// 
// Decompiled by Procyon v0.5.29
// 

public final class os implements Runnable
{
    final /* synthetic */ NoteListFragment a;
    private final /* synthetic */ DialogFragment b;
    
    public os(final NoteListFragment a, final DialogFragment b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        if (this.a.m()) {
            this.b.a(this.a.k(), "dialog");
        }
    }
}
