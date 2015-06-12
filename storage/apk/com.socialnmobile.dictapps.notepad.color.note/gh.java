import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import java.security.NoSuchAlgorithmException;
import java.security.KeyStore;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

// 
// Decompiled by Procyon v0.5.29
// 

public final class gh implements X509TrustManager
{
    private X509TrustManager a;
    
    public gh() {
        this.a = null;
        final TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init((KeyStore)null);
        final TrustManager[] trustManagers = instance.getTrustManagers();
        if (trustManagers.length == 0) {
            throw new NoSuchAlgorithmException("no trust manager found");
        }
        this.a = (X509TrustManager)trustManagers[0];
    }
    
    @Override
    public final void checkClientTrusted(final X509Certificate[] array, final String s) {
        this.a.checkClientTrusted(array, s);
    }
    
    @Override
    public final void checkServerTrusted(final X509Certificate[] array, final String s) {
        if (array != null && array.length == 1) {
            array[0].checkValidity();
            return;
        }
        this.a.checkServerTrusted(array, s);
    }
    
    @Override
    public final X509Certificate[] getAcceptedIssuers() {
        return this.a.getAcceptedIssuers();
    }
}
