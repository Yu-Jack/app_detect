import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.SchemeRegistry;

// 
// Decompiled by Procyon v0.5.29
// 

public final class gi
{
    private static SchemeRegistry a;
    
    static SchemeRegistry a() {
        synchronized (gi.class) {
            SchemeRegistry schemeRegistry;
            if (gi.a != null) {
                schemeRegistry = gi.a;
            }
            else {
                (gi.a = new SchemeRegistry()).register(new Scheme("http", (SocketFactory)PlainSocketFactory.getSocketFactory(), 80));
                gi.a.register(new Scheme("https", (SocketFactory)new gg(), 443));
                schemeRegistry = gi.a;
            }
            return schemeRegistry;
        }
    }
}
