import org.apache.http.protocol.HttpContext;
import org.apache.http.HttpRequest;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import org.apache.http.message.BasicHeader;
import android.os.Build$VERSION;
import android.content.Context;
import org.apache.http.Header;
import org.apache.http.HttpRequestInterceptor;

// 
// Decompiled by Procyon v0.5.29
// 

public final class wl implements HttpRequestInterceptor
{
    final Header a;
    
    public wl(final Context context) {
        this.a = (Header)new BasicHeader("X-COLORNOTE-AGENT", String.valueOf(new StringBuilder("ColorNote ").append(a(context)).toString()) + '/' + ("android-" + Build$VERSION.SDK_INT));
    }
    
    private static String a(final Context context) {
        final PackageManager packageManager = context.getPackageManager();
        try {
            return packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
        }
        catch (PackageManager$NameNotFoundException ex) {
            ex.printStackTrace();
            return "UNKNOWN";
        }
    }
    
    public final void process(final HttpRequest httpRequest, final HttpContext httpContext) {
        httpRequest.addHeader(this.a);
    }
}
