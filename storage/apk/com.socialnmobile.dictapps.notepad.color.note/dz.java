import org.json.JSONException;
import org.json.JSONObject;
import android.content.ActivityNotFoundException;
import android.content.pm.Signature;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.Intent;
import android.app.AlertDialog$Builder;
import android.content.Context;
import android.text.TextUtils;
import android.app.Activity;
import android.webkit.CookieSyncManager;
import android.os.Bundle;
import android.util.Log;

// 
// Decompiled by Procyon v0.5.29
// 

final class dz implements ea
{
    final /* synthetic */ dy a;
    
    dz(final dy a) {
        this.a = a;
    }
    
    @Override
    public final void a() {
        Log.d("Facebook-authorize", "Login canceled");
        this.a.j.a();
    }
    
    @Override
    public final void a(final Bundle bundle) {
        CookieSyncManager.getInstance().sync();
        this.a.a(bundle.getString("access_token"));
        this.a.b(bundle.getString("expires_in"));
        if (this.a.a()) {
            Log.d("Facebook-authorize", "Login Success! access_token=" + this.a.b() + " expires=" + this.a.c());
            this.a.j.a(bundle);
            return;
        }
        this.a.j.a(new eb("Failed to receive access token."));
    }
    
    @Override
    public final void a(final dx obj) {
        Log.d("Facebook-authorize", "Login failed: " + obj);
        this.a.j.a(obj);
    }
    
    @Override
    public final void a(final eb obj) {
        Log.d("Facebook-authorize", "Login failed: " + obj);
        this.a.j.a(obj);
    }
}
