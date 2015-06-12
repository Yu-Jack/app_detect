import org.apache.http.params.HttpParams;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.ProtocolVersion;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.HttpVersion;
import org.apache.http.impl.client.DefaultHttpClient;

// 
// Decompiled by Procyon v0.5.29
// 

public final class wm extends DefaultHttpClient
{
    static final wp a;
    static final wq b;
    static final wu c;
    
    static {
        a = new wp();
        b = new wq();
        c = new wu();
    }
    
    public wm(final String s) {
        final HttpParams params = this.getParams();
        HttpProtocolParams.setVersion(params, (ProtocolVersion)HttpVersion.HTTP_1_1);
        HttpConnectionParams.setConnectionTimeout(params, 10000);
        HttpProtocolParams.setUseExpectContinue(params, false);
        HttpProtocolParams.setUserAgent(params, "gzip " + wk.a(s));
        this.setParams(params);
        this.addRequestInterceptor((HttpRequestInterceptor)wm.a);
        this.addResponseInterceptor((HttpResponseInterceptor)wm.a);
        this.addRequestInterceptor((HttpRequestInterceptor)wm.b);
        this.addResponseInterceptor((HttpResponseInterceptor)wm.c);
    }
}
