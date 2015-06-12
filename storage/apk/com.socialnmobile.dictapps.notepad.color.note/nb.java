import android.support.v4.app.DialogFragment;
import com.socialnmobile.colornote.fragment.CalendarFragment;

// 
// Decompiled by Procyon v0.5.29
// 

public final class nb implements Runnable
{
    final /* synthetic */ CalendarFragment a;
    private final /* synthetic */ DialogFragment b;
    
    public nb(final CalendarFragment a, final DialogFragment b) {
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
