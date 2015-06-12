import android.view.View;
import android.view.View$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

final class rd implements View$OnClickListener
{
    final /* synthetic */ rc a;
    
    rd(final rc a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        switch (view.getId()) {
            default: {}
            case 2131624089: {
                final rf rf = this.a.d.get(0);
                this.a.a.a(rf.a, rf.d);
            }
            case 2131624090: {
                final rf rf2 = this.a.d.get(1);
                this.a.a.a(rf2.a, rf2.d);
            }
            case 2131624091: {
                if (this.a.a()) {
                    final rf b = this.a.b();
                    this.a.a.a(b.a, b.d);
                    return;
                }
                (this.a.b = new qq(view.getContext(), view, this.a.a)).a();
            }
        }
    }
}
