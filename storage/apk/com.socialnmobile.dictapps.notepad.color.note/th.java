import java.util.Date;
import org.apache.http.HttpRequest;

// 
// Decompiled by Procyon v0.5.29
// 

public final class th extends td
{
    public final String b;
    
    public th(final String b) {
        this.b = b;
    }
    
    private boolean a(final Object o) {
        try {
            return this.b.equals(((th)o).b);
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    @Override
    public final void a(final HttpRequest httpRequest) {
        httpRequest.addHeader("X-COLORNOTE-TOKEN-V1", this.b);
    }
    
    @Override
    public final boolean a(final Date date) {
        return false;
    }
    
    @Override
    public final boolean equals(final Object o) {
        return this.a(o);
    }
}
