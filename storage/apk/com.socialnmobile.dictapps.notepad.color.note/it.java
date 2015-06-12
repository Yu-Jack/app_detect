import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.socialnmobile.colornote.activity.SyncSignUp;
import android.view.View$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class it implements View$OnClickListener
{
    final /* synthetic */ SyncSignUp a;
    
    public it(final SyncSignUp a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        if (!this.a.a((View$OnClickListener)this, view)) {
            return;
        }
        switch (view.getId()) {
            default: {}
            case 2131624004: {
                this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.colornote.com/help/tos.html")));
            }
            case 2131624005: {
                if (this.a.i != null) {
                    new iu(this.a, this.a.i).execute((Object[])new String[0]);
                    return;
                }
                this.a.b();
            }
            case 2131624006: {
                if (this.a.j != null) {
                    new iu(this.a, this.a.j).execute((Object[])new String[0]);
                    return;
                }
                this.a.c();
            }
        }
    }
}
