import android.view.View;
import com.socialnmobile.colornote.view.NotesOptions;
import android.view.View$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class aar implements View$OnClickListener
{
    final /* synthetic */ NotesOptions a;
    
    public aar(final NotesOptions a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        if (view.getId() == 2131624122) {
            this.a.c.setCurrentItem(0, true);
        }
        else if (view.getId() == 2131624123) {
            this.a.c.setCurrentItem(1, true);
        }
    }
}
