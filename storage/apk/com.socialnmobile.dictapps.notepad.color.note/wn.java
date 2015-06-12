import java.io.IOException;
import org.apache.http.protocol.HttpContext;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;

// 
// Decompiled by Procyon v0.5.29
// 

public final class wn implements HttpResponseInterceptor
{
    public final void process(final HttpResponse httpResponse, final HttpContext httpContext) {
        int n;
        if (System.currentTimeMillis() % 10L > 7L) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n != 0) {
            throw new IOException("Fake Connection Failed");
        }
    }
}
