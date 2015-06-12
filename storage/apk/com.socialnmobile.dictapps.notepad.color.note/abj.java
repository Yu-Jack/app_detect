import android.view.View;
import android.view.View$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

final class abj implements View$OnClickListener
{
    final /* synthetic */ abi a;
    
    abj(final abi a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        if (jo.a(view.getContext(), "PREF_TITLE_NOTI_NUMBER") <= 0) {
            jo.a(view.getContext(), "PREF_TITLE_NOTI_NUMBER", 1);
            this.a.c.setVisibility(8);
        }
        if (this.a.h != null) {
            this.a.h.onClick(view);
        }
    }
}
