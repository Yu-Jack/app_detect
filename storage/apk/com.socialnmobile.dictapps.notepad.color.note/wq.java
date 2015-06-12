import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HttpContext;
import org.apache.http.HttpRequest;
import java.util.Locale;
import org.apache.http.HttpRequestInterceptor;

// 
// Decompiled by Procyon v0.5.29
// 

public final class wq implements HttpRequestInterceptor
{
    final String a;
    final String b;
    
    public wq() {
        this.a = Locale.getDefault().getCountry();
        this.b = Locale.getDefault().getLanguage();
    }
    
    public final void process(final HttpRequest httpRequest, final HttpContext httpContext) {
        httpRequest.addHeader((Header)new BasicHeader("Accept-Language", String.valueOf(this.b) + "-" + this.a));
    }
}
