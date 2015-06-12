import android.view.View;
import android.view.View$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

final class re implements View$OnClickListener
{
    final /* synthetic */ rc a;
    
    re(final rc a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        (this.a.b = new qq(view.getContext(), view, this.a.a)).a();
    }
}
