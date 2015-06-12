import android.net.Uri;
import android.content.Intent;
import android.view.View;
import android.view.View$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

final class yw implements View$OnClickListener
{
    final /* synthetic */ yu a;
    
    yw(final yu a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        if (this.a.d) {
            final Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.a.b.e.get(0).b));
            this.a.c.startActivity(intent);
            return;
        }
        this.a.a();
    }
}
