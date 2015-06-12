import org.apache.http.client.HttpResponseException;
import org.apache.http.protocol.HttpContext;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;

// 
// Decompiled by Procyon v0.5.29
// 

public final class wu implements HttpResponseInterceptor
{
    public final void process(final HttpResponse httpResponse, final HttpContext httpContext) {
        if (httpResponse.getStatusLine().getStatusCode() >= 400) {
            throw new HttpResponseException(httpResponse.getStatusLine().getStatusCode(), httpResponse.getStatusLine().getReasonPhrase());
        }
    }
}
