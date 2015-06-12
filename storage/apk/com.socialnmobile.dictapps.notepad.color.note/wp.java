import org.apache.http.HeaderElement;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpRequestInterceptor;

// 
// Decompiled by Procyon v0.5.29
// 

public final class wp implements HttpRequestInterceptor, HttpResponseInterceptor
{
    public final void process(final HttpRequest httpRequest, final HttpContext httpContext) {
        if (!httpRequest.containsHeader("Accept-Encoding")) {
            httpRequest.addHeader("Accept-Encoding", "gzip");
        }
    }
    
    public final void process(final HttpResponse httpResponse, final HttpContext httpContext) {
        final HttpEntity entity = httpResponse.getEntity();
        final Header contentEncoding = entity.getContentEncoding();
        if (contentEncoding != null) {
            final HeaderElement[] elements = contentEncoding.getElements();
            for (int length = elements.length, i = 0; i < length; ++i) {
                if (elements[i].getName().equalsIgnoreCase("gzip")) {
                    httpResponse.setEntity((HttpEntity)new wo(entity));
                }
            }
        }
    }
}
