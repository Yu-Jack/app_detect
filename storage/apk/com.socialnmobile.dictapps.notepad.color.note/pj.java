import android.support.v4.app.DialogFragment;
import com.socialnmobile.colornote.fragment.NotesFragment;

// 
// Decompiled by Procyon v0.5.29
// 

public final class pj implements Runnable
{
    final /* synthetic */ NotesFragment a;
    private final /* synthetic */ DialogFragment b;
    
    public pj(final NotesFragment a, final DialogFragment b) {
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
