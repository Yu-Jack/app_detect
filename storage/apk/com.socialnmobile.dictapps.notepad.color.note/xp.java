import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.ProtocolVersion;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.HttpVersion;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.util.EntityUtils;
import com.socialnmobile.colornote.ColorNote;
import org.apache.http.HttpResponse;
import org.apache.http.HttpRequest;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;

// 
// Decompiled by Procyon v0.5.29
// 

public final class xp implements xo
{
    final HttpClient a;
    final HttpHost b;
    final String c;
    
    public xp(final HttpClient a, final HttpHost b, final String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    private HttpResponse a(final HttpRequest httpRequest) {
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            return this.a.execute(this.b, httpRequest);
        }
        finally {
            new StringBuilder("HTTP request time: ").append(Long.toString(System.currentTimeMillis() - currentTimeMillis)).toString();
            ColorNote.b();
        }
    }
    
    private static xs a(final HttpResponse httpResponse) {
        final String string = EntityUtils.toString(httpResponse.getEntity());
        try {
            return xs.k(string);
        }
        catch (Exception ex) {
            throw new xq("failed to parse HTTP Response: " + ex.getMessage(), ex);
        }
    }
    
    private HttpEntityEnclosingRequest b(final xr xr) {
        final BasicHttpEntityEnclosingRequest basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("POST", this.c, (ProtocolVersion)HttpVersion.HTTP_1_1);
        try {
            final StringEntity entity = new StringEntity(xr.toString(), "UTF-8");
            entity.setContentType("application/json");
            ((HttpEntityEnclosingRequest)basicHttpEntityEnclosingRequest).setEntity((HttpEntity)entity);
            return (HttpEntityEnclosingRequest)basicHttpEntityEnclosingRequest;
        }
        catch (UnsupportedEncodingException cause) {
            throw new RuntimeException(cause);
        }
    }
    
    @Override
    public final xs a(final xr xr) {
        return a(this.a((HttpRequest)this.b(xr)));
    }
}
