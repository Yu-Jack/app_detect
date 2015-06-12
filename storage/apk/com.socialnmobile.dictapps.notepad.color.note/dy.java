import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.ActivityNotFoundException;
import android.content.pm.Signature;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.Intent;
import android.app.AlertDialog$Builder;
import android.content.Context;
import android.webkit.CookieSyncManager;
import android.text.TextUtils;
import android.os.Bundle;
import android.app.Activity;

// 
// Decompiled by Procyon v0.5.29
// 

public final class dy
{
    protected static String a;
    protected static String b;
    protected static String c;
    private String d;
    private long e;
    private String f;
    private Activity g;
    private String[] h;
    private int i;
    private ea j;
    
    static {
        dy.a = "https://facebook.com/v2.0/dialog/";
        dy.b = "https://graph.facebook.com/";
        dy.c = "https://api.facebook.com/restserver.php";
    }
    
    public dy(final String f) {
        this.d = null;
        this.e = 0L;
        if (f == null) {
            throw new IllegalArgumentException("You must specify your application ID when instantiating a Facebook object. See README for details.");
        }
        this.f = f;
    }
    
    private void a(final Activity activity, final String[] array) {
        final Bundle bundle = new Bundle();
        if (array.length > 0) {
            bundle.putString("scope", TextUtils.join((CharSequence)",", (Object[])array));
        }
        CookieSyncManager.createInstance((Context)activity);
        final dz dz = new dz(this);
        final String string = String.valueOf(dy.a) + "oauth";
        bundle.putString("display", "touch");
        bundle.putString("redirect_uri", "fbconnect://success");
        if ("oauth".equals("oauth")) {
            bundle.putString("type", "user_agent");
            bundle.putString("client_id", this.f);
        }
        else {
            bundle.putString("app_id", this.f);
        }
        if (this.a()) {
            bundle.putString("access_token", this.d);
        }
        final String string2 = String.valueOf(string) + "?" + ef.a(bundle);
        if (activity.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)activity);
            alertDialog$Builder.setTitle((CharSequence)"Error");
            alertDialog$Builder.setMessage((CharSequence)"Application requires permission to access the Internet");
            alertDialog$Builder.create().show();
            return;
        }
        new ec(activity, string2, dz).show();
    }
    
    private static boolean a(final Activity activity, final Intent intent) {
        final ResolveInfo resolveActivity = activity.getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity != null) {
            final String packageName = resolveActivity.activityInfo.packageName;
            try {
                final Signature[] signatures = activity.getPackageManager().getPackageInfo(packageName, 64).signatures;
                for (int length = signatures.length, i = 0; i < length; ++i) {
                    if (signatures[i].toCharsString().equals("30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2")) {
                        return true;
                    }
                }
                return false;
            }
            catch (PackageManager$NameNotFoundException ex) {
                return false;
            }
        }
        return false;
    }
    
    private boolean a(final Activity g, final String s, final String[] h) {
        boolean b = true;
        final Intent intent = new Intent();
        intent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
        intent.putExtra("client_id", s);
        if (h.length > 0) {
            intent.putExtra("scope", TextUtils.join((CharSequence)",", (Object[])h));
        }
        final String d = d();
        if (!TextUtils.isEmpty((CharSequence)d)) {
            intent.putExtra("e2e", d);
        }
        intent.putExtra("response_type", "token");
        intent.putExtra("return_scopes", "true");
        intent.putExtra("default_audience", "everyone");
        intent.putExtra("legacy_override", "v2.2");
        if (g.getPackageManager().resolveActivity(intent, 0) == null || !a(g, intent)) {
            return false;
        }
        this.g = g;
        this.h = h;
        this.i = 32665;
        try {
            g.startActivityForResult(intent, 32665);
            return b;
        }
        catch (ActivityNotFoundException ex) {
            b = false;
            return b;
        }
    }
    
    private static String d() {
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("init", System.currentTimeMillis());
            return jsonObject.toString();
        }
        catch (JSONException ex) {
            return jsonObject.toString();
        }
    }
    
    public final void a(final int n, final int n2, final Intent intent) {
        if (n == this.i) {
            if (n2 == -1) {
                String str = intent.getStringExtra("error");
                if (str == null) {
                    str = intent.getStringExtra("error_type");
                }
                if (str != null) {
                    if (str.equals("service_disabled") || str.equals("AndroidAuthKillSwitchException")) {
                        Log.d("Facebook-authorize", "Hosted auth currently disabled. Retrying dialog auth...");
                        this.a(this.g, this.h);
                    }
                    else {
                        if (str.equals("access_denied") || str.equals("OAuthAccessDeniedException")) {
                            Log.d("Facebook-authorize", "Login canceled by user.");
                            this.j.a();
                            return;
                        }
                        Log.d("Facebook-authorize", "Login failed: " + str);
                        this.j.a(new eb(str));
                    }
                }
                else {
                    this.d = intent.getStringExtra("access_token");
                    this.b(intent.getStringExtra("expires_in"));
                    if (this.a()) {
                        Log.d("Facebook-authorize", "Login Success! access_token=" + this.d + " expires=" + this.e);
                        this.j.a(intent.getExtras());
                        return;
                    }
                    this.j.a(new eb("Failed to receive access token."));
                }
            }
            else if (n2 == 0) {
                if (intent != null) {
                    Log.d("Facebook-authorize", "Login failed: " + intent.getStringExtra("error"));
                    this.j.a(new dx(intent.getStringExtra("error"), intent.getIntExtra("error_code", -1), intent.getStringExtra("failing_url")));
                    return;
                }
                Log.d("Facebook-authorize", "Login canceled by user.");
                this.j.a();
            }
        }
    }
    
    public final void a(final Activity activity, final String[] array, final ea j) {
        this.j = j;
        if (!this.a(activity, this.f, array)) {
            this.a(activity, array);
        }
    }
    
    public final void a(final String d) {
        this.d = d;
    }
    
    public final boolean a() {
        return this.d != null && (this.e == 0L || System.currentTimeMillis() < this.e);
    }
    
    public final String b() {
        return this.d;
    }
    
    public final void b(final String s) {
        if (s != null && !s.equals("0")) {
            this.e = System.currentTimeMillis() + 1000 * Integer.parseInt(s);
        }
    }
    
    public final long c() {
        return this.e;
    }
}
