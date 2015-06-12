import com.socialnmobile.colornote.ColorNote;
import android.content.Context;
import android.widget.Toast;
import android.os.Bundle;
import com.socialnmobile.colornote.activity.SyncActivity;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ip implements ea
{
    final /* synthetic */ SyncActivity a;
    
    public ip(final SyncActivity a) {
        this.a = a;
    }
    
    @Override
    public final void a() {
    }
    
    @Override
    public final void a(final Bundle bundle) {
        final String string = bundle.getString("access_token");
        final int int1 = Integer.parseInt(bundle.getString("expires_in"));
        final ur ur = new ur(string, int1, new tw(tw.b().a + int1 * 1000));
        if (this.a.c != null) {
            this.a.a(ur);
        }
    }
    
    @Override
    public final void a(final dx dx) {
        Toast.makeText((Context)this.a, (CharSequence)dx.getLocalizedMessage(), 0).show();
        Toast.makeText((Context)this.a, 2131230844, 0).show();
        ColorNote.a("Facebook Auth Error" + dx.getMessage());
    }
    
    @Override
    public final void a(final eb eb) {
        Toast.makeText((Context)this.a, (CharSequence)eb.getLocalizedMessage(), 0).show();
        ColorNote.a("Facebook Auth Error" + eb.getMessage());
    }
}
