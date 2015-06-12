import android.view.View;
import com.socialnmobile.colornote.fragment.NotesFragment;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ph implements Runnable
{
    final /* synthetic */ NotesFragment a;
    private final /* synthetic */ View b;
    
    public ph(final NotesFragment a, final View b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        if (this.b.isSelected()) {
            this.b.setSelected(false);
        }
        else {
            this.b.setSelected(true);
        }
        if (this.a.c-- > 0) {
            this.a.i.postDelayed((Runnable)this, 1500L);
            return;
        }
        this.b.setSelected(false);
    }
}
