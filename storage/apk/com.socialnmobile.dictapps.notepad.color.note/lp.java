import android.app.AlertDialog;
import android.content.DialogInterface;
import com.socialnmobile.colornote.fragment.CalendarFragment;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class lp implements DialogInterface$OnClickListener
{
    private final /* synthetic */ CalendarFragment a;
    
    public lp(final CalendarFragment a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        this.a.b(((kh)((AlertDialog)dialogInterface).getListView().getAdapter().getItem(n)).a);
    }
}
