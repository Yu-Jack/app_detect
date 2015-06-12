import com.socialnmobile.colornote.fragment.CalendarFragment;
import com.socialnmobile.colornote.fragment.NotesFragment;
import android.support.v4.app.Fragment;
import com.socialnmobile.colornote.activity.Main;

// 
// Decompiled by Procyon v0.5.29
// 

public final class hw extends zq
{
    final /* synthetic */ Main a;
    
    public hw(final Main a, final m m, final zr zr) {
        this.a = a;
        super(m, zr);
    }
    
    @Override
    public final Fragment a(final int n) {
        if (n == 0) {
            return new NotesFragment();
        }
        if (n == 1) {
            return new CalendarFragment();
        }
        return null;
    }
}
