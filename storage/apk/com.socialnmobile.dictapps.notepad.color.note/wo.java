import java.util.zip.GZIPInputStream;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

// 
// Decompiled by Procyon v0.5.29
// 

final class wo extends HttpEntityWrapper
{
    public wo(final HttpEntity httpEntity) {
        super(httpEntity);
    }
    
    public final InputStream getContent() {
        return new GZIPInputStream(this.wrappedEntity.getContent());
    }
}
