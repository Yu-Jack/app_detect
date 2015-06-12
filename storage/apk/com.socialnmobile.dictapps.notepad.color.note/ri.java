import android.content.DialogInterface;
import com.socialnmobile.colornote.menu.TopBarSubMenuInfo;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ri implements DialogInterface$OnClickListener
{
    final /* synthetic */ TopBarSubMenuInfo a;
    
    public ri(final TopBarSubMenuInfo a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int index) {
        final rf rf = this.a.b.get(index);
        if (this.a.e != null) {
            this.a.e.a(rf.a, rf.d);
        }
    }
}
