import android.content.DialogInterface;
import com.socialnmobile.colornote.activity.Main;
import android.content.DialogInterface$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class hs implements DialogInterface$OnClickListener
{
    final /* synthetic */ Main a;
    
    public hs(final Main a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        gw.c(this.a.getApplicationContext());
    }
}
