import java.net.SocketAddress;
import javax.net.ssl.SSLSocket;
import java.net.InetSocketAddress;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import java.net.InetAddress;
import java.net.Socket;
import java.io.IOException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.scheme.LayeredSocketFactory;

// 
// Decompiled by Procyon v0.5.29
// 

public class gg implements LayeredSocketFactory, SocketFactory
{
    private SSLContext a;
    
    public gg() {
        this.a = null;
    }
    
    private static SSLContext a() {
        try {
            final SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, new TrustManager[] { new gh() }, null);
            return instance;
        }
        catch (Exception ex) {
            throw new IOException(ex.getMessage());
        }
    }
    
    private SSLContext b() {
        if (this.a == null) {
            this.a = a();
        }
        return this.a;
    }
    
    public Socket connectSocket(final Socket socket, final String hostname, final int port, final InetAddress addr, int port2, final HttpParams httpParams) {
        final int connectionTimeout = HttpConnectionParams.getConnectionTimeout(httpParams);
        final int soTimeout = HttpConnectionParams.getSoTimeout(httpParams);
        final InetSocketAddress endpoint = new InetSocketAddress(hostname, port);
        Socket socket2;
        if (socket != null) {
            socket2 = socket;
        }
        else {
            socket2 = this.createSocket();
        }
        final SSLSocket sslSocket = (SSLSocket)socket2;
        if (addr != null || port2 > 0) {
            if (port2 < 0) {
                port2 = 0;
            }
            sslSocket.bind(new InetSocketAddress(addr, port2));
        }
        sslSocket.connect(endpoint, connectionTimeout);
        sslSocket.setSoTimeout(soTimeout);
        return sslSocket;
    }
    
    public Socket createSocket() {
        return this.b().getSocketFactory().createSocket();
    }
    
    public Socket createSocket(final Socket socket, final String s, final int n, final boolean b) {
        return this.b().getSocketFactory().createSocket(socket, s, n, b);
    }
    
    @Override
    public boolean equals(final Object o) {
        return o != null && o.getClass().equals(gg.class);
    }
    
    @Override
    public int hashCode() {
        return gg.class.hashCode();
    }
    
    public boolean isSecure(final Socket socket) {
        return true;
    }
}
