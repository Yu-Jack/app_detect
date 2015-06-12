import org.apache.http.protocol.HttpContext;
import org.apache.http.HttpRequest;
import com.socialnmobile.colornote.sync.jobs.SyncJob;
import org.apache.http.HttpRequestInterceptor;

// 
// Decompiled by Procyon v0.5.29
// 

public final class xa implements HttpRequestInterceptor
{
    final /* synthetic */ SyncJob a;
    private final /* synthetic */ td b;
    
    public xa(final SyncJob a, final td b) {
        this.a = a;
        this.b = b;
    }
    
    public final void process(final HttpRequest httpRequest, final HttpContext httpContext) {
        this.b.a(httpRequest);
    }
}
