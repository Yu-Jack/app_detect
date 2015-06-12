import org.apache.http.HttpHost;
import java.util.Locale;

// 
// Decompiled by Procyon v0.5.29
// 

public final class wv implements wt
{
    boolean a;
    final String b;
    final String c;
    
    public wv() {
        this.a = Locale.getDefault().getCountry().equals(Locale.CHINA.getCountry());
        this.b = "proxy.colornote.com";
        this.c = "colornote-server";
    }
    
    private HttpHost a(final boolean b) {
        if (this.a) {
            return a(b, "proxy.colornote.com");
        }
        String s;
        if (b) {
            s = "api." + "colornote-server" + ".appspot.com";
        }
        else {
            s = "api-dot-" + "colornote-server" + ".appspot.com";
        }
        return a(b, s);
    }
    
    private static HttpHost a(final boolean b, final String s) {
        if (b) {
            return new HttpHost(s);
        }
        return new HttpHost(s, 443, "https");
    }
    
    @Override
    public final HttpHost a() {
        return this.a(false);
    }
    
    @Override
    public final HttpHost b() {
        return this.a(true);
    }
}
