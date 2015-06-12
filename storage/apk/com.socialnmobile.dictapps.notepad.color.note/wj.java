import org.apache.http.protocol.HttpContext;
import org.apache.http.HttpRequest;
import android.content.Context;
import org.apache.http.HttpRequestInterceptor;

// 
// Decompiled by Procyon v0.5.29
// 

public final class wj implements HttpRequestInterceptor
{
    final Context a;
    final ki b;
    final vr c;
    
    public wj(final Context a, final ki b) {
        this.c = new vr();
        this.a = a;
        this.b = b;
    }
    
    public final void process(final HttpRequest httpRequest, final HttpContext httpContext) {
        final rt a = rt.a(this.a, this.b);
        td q;
        if (a != null) {
            q = a.q();
        }
        else {
            q = null;
        }
        if (q != null) {
            q.a(httpRequest);
        }
    }
}
