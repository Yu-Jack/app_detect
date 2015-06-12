import com.socialnmobile.colornote.ColorNote;
import org.apache.http.HttpHost;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import java.io.UnsupportedEncodingException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.HttpClient;
import android.content.Context;
import android.os.Build;

// 
// Decompiled by Procyon v0.5.29
// 

public final class adl
{
    public static adl a;
    
    static {
        adl.a = new adl();
    }
    
    private static xj a() {
        final xj xj = new xj();
        try {
            xj.a("BOARD", Build.BOARD);
            xj.a("BRAND", Build.BRAND);
            xj.a("DEVICE", Build.DEVICE);
            xj.a("DISPLAY", Build.DISPLAY);
            xj.a("FINGERPRINT", Build.FINGERPRINT);
            xj.a("ID", Build.ID);
            xj.a("MANUFACTURER", Build.MANUFACTURER);
            xj.a("MODEL", Build.MODEL);
            xj.a("PRODUCT", Build.PRODUCT);
            return xj;
        }
        catch (Exception ex) {
            return xj;
        }
    }
    
    static boolean a(final Context context, final xj xj) {
        return a(new wv(), xj, (HttpClient)new tr(context).b());
    }
    
    private static boolean a(final wt wt, final xj xj, final HttpClient httpClient) {
        final HttpHost a = wt.a();
        final HttpPost httpPost = new HttpPost(String.valueOf(a.getSchemeName()) + "://" + a.getHostName() + "/support/report-client-error");
        try {
            final StringEntity entity = new StringEntity(xj.toString(), "UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity((HttpEntity)entity);
            final int statusCode = httpClient.execute((HttpUriRequest)httpPost).getStatusLine().getStatusCode();
            boolean b = false;
            if (statusCode == 200) {
                b = true;
            }
            return b;
        }
        catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            return false;
        }
        catch (ClientProtocolException ex2) {
            ex2.printStackTrace();
            return false;
        }
        catch (IOException ex3) {
            ex3.printStackTrace();
            return false;
        }
        catch (IllegalArgumentException ex4) {
            ex4.printStackTrace();
            return false;
        }
    }
    
    private static xj b(final Context context, final Exception ex, final Object o) {
        final xj xj = new xj();
        if (o != null) {
            xj.a("info", o);
        }
        xj.a("exception", ex, adr.a);
        xj.a("buildinfo", a());
        xj.a("agent", wk.a(wk.a(context)));
        if (ex instanceof RuntimeException) {
            final RuntimeException ex2 = (RuntimeException)ex;
            if (ex2 instanceof vs) {
                xj.a("accountData", ((vs)ex2).a);
            }
        }
        while (true) {
            try {
                final rt e = rt.e(context);
                if (e != null) {
                    xj.a("account", e.m);
                }
                return xj;
            }
            catch (RuntimeException ex3) {
                ex3.printStackTrace();
                final rt e = null;
                continue;
            }
            break;
        }
    }
    
    private void b(final Context context, final xj xj) {
        new adm(this, context, xj).start();
    }
    
    public final void a(final Context context, final Exception ex) {
        this.b(context, b(context, ex, null));
    }
    
    public final void a(final Context context, final Exception ex, final Object o) {
        this.b(context, b(context, ex, o));
    }
    
    public final void a(final Exception ex) {
        this.a((Context)ColorNote.e(), ex);
    }
    
    public final void a(final Object o) {
        try {
            throw new RuntimeException("Unexpected situation");
        }
        catch (RuntimeException ex) {
            final ColorNote e = ColorNote.e();
            this.b((Context)e, b((Context)e, ex, o));
        }
    }
}
