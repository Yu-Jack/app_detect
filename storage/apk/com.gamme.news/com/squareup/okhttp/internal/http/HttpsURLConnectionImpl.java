// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.http;

import java.net.HttpURLConnection;
import java.net.ProtocolException;
import android.annotation.SuppressLint;
import javax.net.ssl.SSLSocketFactory;
import java.security.Permission;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.io.OutputStream;
import java.security.Principal;
import java.security.cert.Certificate;
import javax.net.ssl.HostnameVerifier;
import java.util.List;
import java.util.Map;
import java.io.InputStream;
import java.net.SecureCacheResponse;
import java.io.IOException;
import javax.net.ssl.SSLSocket;
import com.squareup.okhttp.OkHttpClient;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public final class HttpsURLConnectionImpl extends HttpsURLConnection
{
    private final HttpUrlConnectionDelegate delegate;
    
    public HttpsURLConnectionImpl(final URL url, final OkHttpClient okHttpClient) {
        super(url);
        this.delegate = new HttpUrlConnectionDelegate(url, okHttpClient, (HttpUrlConnectionDelegate)null);
    }
    
    private SSLSocket getSslSocket() {
        if (this.delegate.httpEngine == null || !this.delegate.httpEngine.connected) {
            throw new IllegalStateException("Connection has not yet been established");
        }
        if (this.delegate.httpEngine instanceof HttpsEngine) {
            return ((HttpsEngine)this.delegate.httpEngine).getSslSocket();
        }
        return null;
    }
    
    @Override
    public void addRequestProperty(final String s, final String s2) {
        this.delegate.addRequestProperty(s, s2);
    }
    
    @Override
    public void connect() throws IOException {
        this.connected = true;
        this.delegate.connect();
    }
    
    @Override
    public void disconnect() {
        this.delegate.disconnect();
    }
    
    @Override
    public boolean getAllowUserInteraction() {
        return this.delegate.getAllowUserInteraction();
    }
    
    @Override
    public String getCipherSuite() {
        final SecureCacheResponse secureCacheResponse = this.delegate.getSecureCacheResponse();
        if (secureCacheResponse != null) {
            return secureCacheResponse.getCipherSuite();
        }
        final SSLSocket sslSocket = this.getSslSocket();
        if (sslSocket != null) {
            return sslSocket.getSession().getCipherSuite();
        }
        return null;
    }
    
    @Override
    public int getConnectTimeout() {
        return this.delegate.getConnectTimeout();
    }
    
    @Override
    public Object getContent() throws IOException {
        return this.delegate.getContent();
    }
    
    @Override
    public Object getContent(final Class[] classes) throws IOException {
        return this.delegate.getContent(classes);
    }
    
    @Override
    public String getContentEncoding() {
        return this.delegate.getContentEncoding();
    }
    
    @Override
    public int getContentLength() {
        return this.delegate.getContentLength();
    }
    
    @Override
    public String getContentType() {
        return this.delegate.getContentType();
    }
    
    @Override
    public long getDate() {
        return this.delegate.getDate();
    }
    
    @Override
    public boolean getDefaultUseCaches() {
        return this.delegate.getDefaultUseCaches();
    }
    
    @Override
    public boolean getDoInput() {
        return this.delegate.getDoInput();
    }
    
    @Override
    public boolean getDoOutput() {
        return this.delegate.getDoOutput();
    }
    
    @Override
    public InputStream getErrorStream() {
        return this.delegate.getErrorStream();
    }
    
    @Override
    public long getExpiration() {
        return this.delegate.getExpiration();
    }
    
    @Override
    public String getHeaderField(final int n) {
        return this.delegate.getHeaderField(n);
    }
    
    @Override
    public String getHeaderField(final String s) {
        return this.delegate.getHeaderField(s);
    }
    
    @Override
    public long getHeaderFieldDate(final String name, final long default1) {
        return this.delegate.getHeaderFieldDate(name, default1);
    }
    
    @Override
    public int getHeaderFieldInt(final String name, final int default1) {
        return this.delegate.getHeaderFieldInt(name, default1);
    }
    
    @Override
    public String getHeaderFieldKey(final int n) {
        return this.delegate.getHeaderFieldKey(n);
    }
    
    @Override
    public Map<String, List<String>> getHeaderFields() {
        return this.delegate.getHeaderFields();
    }
    
    @Override
    public HostnameVerifier getHostnameVerifier() {
        return this.delegate.client.getHostnameVerifier();
    }
    
    public HttpEngine getHttpEngine() {
        return this.delegate.getHttpEngine();
    }
    
    @Override
    public long getIfModifiedSince() {
        return this.delegate.getIfModifiedSince();
    }
    
    @Override
    public InputStream getInputStream() throws IOException {
        return this.delegate.getInputStream();
    }
    
    @Override
    public boolean getInstanceFollowRedirects() {
        return this.delegate.getInstanceFollowRedirects();
    }
    
    @Override
    public long getLastModified() {
        return this.delegate.getLastModified();
    }
    
    @Override
    public Certificate[] getLocalCertificates() {
        final SecureCacheResponse secureCacheResponse = this.delegate.getSecureCacheResponse();
        Certificate[] array;
        if (secureCacheResponse != null) {
            final List<Certificate> localCertificateChain = secureCacheResponse.getLocalCertificateChain();
            array = null;
            if (localCertificateChain != null) {
                array = localCertificateChain.toArray(new Certificate[localCertificateChain.size()]);
            }
        }
        else {
            final SSLSocket sslSocket = this.getSslSocket();
            array = null;
            if (sslSocket != null) {
                return sslSocket.getSession().getLocalCertificates();
            }
        }
        return array;
    }
    
    @Override
    public Principal getLocalPrincipal() {
        final SecureCacheResponse secureCacheResponse = this.delegate.getSecureCacheResponse();
        if (secureCacheResponse != null) {
            return secureCacheResponse.getLocalPrincipal();
        }
        final SSLSocket sslSocket = this.getSslSocket();
        if (sslSocket != null) {
            return sslSocket.getSession().getLocalPrincipal();
        }
        return null;
    }
    
    @Override
    public OutputStream getOutputStream() throws IOException {
        return this.delegate.getOutputStream();
    }
    
    @Override
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        final SecureCacheResponse secureCacheResponse = this.delegate.getSecureCacheResponse();
        if (secureCacheResponse != null) {
            return secureCacheResponse.getPeerPrincipal();
        }
        final SSLSocket sslSocket = this.getSslSocket();
        if (sslSocket != null) {
            return sslSocket.getSession().getPeerPrincipal();
        }
        return null;
    }
    
    @Override
    public Permission getPermission() throws IOException {
        return this.delegate.getPermission();
    }
    
    @Override
    public int getReadTimeout() {
        return this.delegate.getReadTimeout();
    }
    
    @Override
    public String getRequestMethod() {
        return this.delegate.getRequestMethod();
    }
    
    @Override
    public Map<String, List<String>> getRequestProperties() {
        return this.delegate.getRequestProperties();
    }
    
    @Override
    public String getRequestProperty(final String s) {
        return this.delegate.getRequestProperty(s);
    }
    
    @Override
    public int getResponseCode() throws IOException {
        return this.delegate.getResponseCode();
    }
    
    @Override
    public String getResponseMessage() throws IOException {
        return this.delegate.getResponseMessage();
    }
    
    @Override
    public SSLSocketFactory getSSLSocketFactory() {
        return this.delegate.client.getSslSocketFactory();
    }
    
    @Override
    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        final SecureCacheResponse secureCacheResponse = this.delegate.getSecureCacheResponse();
        Certificate[] array;
        if (secureCacheResponse != null) {
            final List<Certificate> serverCertificateChain = secureCacheResponse.getServerCertificateChain();
            array = null;
            if (serverCertificateChain != null) {
                array = serverCertificateChain.toArray(new Certificate[serverCertificateChain.size()]);
            }
        }
        else {
            final SSLSocket sslSocket = this.getSslSocket();
            array = null;
            if (sslSocket != null) {
                return sslSocket.getSession().getPeerCertificates();
            }
        }
        return array;
    }
    
    @Override
    public URL getURL() {
        return this.delegate.getURL();
    }
    
    @Override
    public boolean getUseCaches() {
        return this.delegate.getUseCaches();
    }
    
    @Override
    public void setAllowUserInteraction(final boolean allowUserInteraction) {
        this.delegate.setAllowUserInteraction(allowUserInteraction);
    }
    
    @Override
    public void setChunkedStreamingMode(final int chunkedStreamingMode) {
        this.delegate.setChunkedStreamingMode(chunkedStreamingMode);
    }
    
    @Override
    public void setConnectTimeout(final int connectTimeout) {
        this.delegate.setConnectTimeout(connectTimeout);
    }
    
    @Override
    public void setDefaultUseCaches(final boolean defaultUseCaches) {
        this.delegate.setDefaultUseCaches(defaultUseCaches);
    }
    
    @Override
    public void setDoInput(final boolean doInput) {
        this.delegate.setDoInput(doInput);
    }
    
    @Override
    public void setDoOutput(final boolean doOutput) {
        this.delegate.setDoOutput(doOutput);
    }
    
    @Override
    public void setFixedLengthStreamingMode(final int fixedLengthStreamingMode) {
        this.delegate.setFixedLengthStreamingMode(fixedLengthStreamingMode);
    }
    
    @SuppressLint({ "NewApi" })
    @Override
    public void setFixedLengthStreamingMode(final long fixedLengthStreamingMode) {
        this.delegate.setFixedLengthStreamingMode(fixedLengthStreamingMode);
    }
    
    @Override
    public void setHostnameVerifier(final HostnameVerifier hostnameVerifier) {
        this.delegate.client.setHostnameVerifier(hostnameVerifier);
    }
    
    @Override
    public void setIfModifiedSince(final long ifModifiedSince) {
        this.delegate.setIfModifiedSince(ifModifiedSince);
    }
    
    @Override
    public void setInstanceFollowRedirects(final boolean instanceFollowRedirects) {
        this.delegate.setInstanceFollowRedirects(instanceFollowRedirects);
    }
    
    @Override
    public void setReadTimeout(final int readTimeout) {
        this.delegate.setReadTimeout(readTimeout);
    }
    
    @Override
    public void setRequestMethod(final String requestMethod) throws ProtocolException {
        this.delegate.setRequestMethod(requestMethod);
    }
    
    @Override
    public void setRequestProperty(final String s, final String s2) {
        this.delegate.setRequestProperty(s, s2);
    }
    
    @Override
    public void setSSLSocketFactory(final SSLSocketFactory sslSocketFactory) {
        this.delegate.client.setSslSocketFactory(sslSocketFactory);
    }
    
    @Override
    public void setUseCaches(final boolean useCaches) {
        this.delegate.setUseCaches(useCaches);
    }
    
    @Override
    public String toString() {
        return this.delegate.toString();
    }
    
    @Override
    public boolean usingProxy() {
        return this.delegate.usingProxy();
    }
    
    private final class HttpUrlConnectionDelegate extends HttpURLConnectionImpl
    {
        private HttpUrlConnectionDelegate(final URL url, final OkHttpClient okHttpClient) {
            super(url, okHttpClient);
        }
        
        @Override
        public HttpURLConnection getHttpConnectionToCache() {
            return HttpsURLConnectionImpl.this;
        }
        
        public SecureCacheResponse getSecureCacheResponse() {
            if (this.httpEngine instanceof HttpsEngine) {
                return (SecureCacheResponse)this.httpEngine.getCacheResponse();
            }
            return null;
        }
    }
}
