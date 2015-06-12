import android.webkit.CookieSyncManager;
import android.os.Bundle;

// 
// Decompiled by Procyon v0.5.29
// 

public final class rp implements ea
{
    final /* synthetic */ ro a;
    
    public rp(final ro a) {
        this.a = a;
    }
    
    @Override
    public final void a() {
        this.a.a.a();
    }
    
    @Override
    public final void a(final Bundle bundle) {
        CookieSyncManager.getInstance().sync();
        this.a.d = bundle.getString("access_token");
        this.a.e = bundle.getString("refresh_token");
        this.a.d = bundle.getString("access_token");
        final ro a = this.a;
        final String string = bundle.getString("expires_in");
        if (string != null && !string.equals("0")) {
            a.f = System.currentTimeMillis() + 1000 * Integer.parseInt(string);
        }
        final ro a2 = this.a;
        int n;
        if (a2.d != null && (a2.f == 0L || System.currentTimeMillis() < a2.f)) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n != 0) {
            this.a.a.a(bundle);
            return;
        }
        this.a.a.a(new dx("Failed to receive access token.", 0, ""));
    }
    
    @Override
    public final void a(final dx dx) {
        this.a.a.a(dx);
    }
    
    @Override
    public final void a(final eb eb) {
        this.a.a.a(eb);
    }
}
