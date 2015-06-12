// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HttpTransport;
import com.squareup.okhttp.internal.http.SpdyTransport;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.net.SocketTimeoutException;
import java.net.Proxy;
import java.util.Arrays;
import javax.net.ssl.SSLSocket;
import com.squareup.okhttp.internal.Platform;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import com.squareup.okhttp.internal.http.HttpAuthenticator;
import java.net.URL;
import java.io.IOException;
import com.squareup.okhttp.internal.http.RawHeaders;
import com.squareup.okhttp.internal.spdy.SpdyConnection;
import java.net.Socket;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.Closeable;

public final class Connection implements Closeable
{
    private static final byte[] HTTP_11;
    private static final byte[] NPN_PROTOCOLS;
    private static final byte[] SPDY3;
    private boolean connected;
    private int httpMinorVersion;
    private long idleStartTimeNs;
    private InputStream in;
    private OutputStream out;
    private final Route route;
    private Socket socket;
    private SpdyConnection spdyConnection;
    
    static {
        NPN_PROTOCOLS = new byte[] { 6, 115, 112, 100, 121, 47, 51, 8, 104, 116, 116, 112, 47, 49, 46, 49 };
        SPDY3 = new byte[] { 115, 112, 100, 121, 47, 51 };
        HTTP_11 = new byte[] { 104, 116, 116, 112, 47, 49, 46, 49 };
    }
    
    public Connection(final Route route) {
        this.connected = false;
        this.httpMinorVersion = 1;
        this.route = route;
    }
    
    private void makeTunnel(final TunnelRequest tunnelRequest) throws IOException {
        RawHeaders requestHeaders = tunnelRequest.getRequestHeaders();
        while (true) {
            this.out.write(requestHeaders.toBytes());
            final RawHeaders fromBytes = RawHeaders.fromBytes(this.in);
            switch (fromBytes.getResponseCode()) {
                default: {
                    throw new IOException("Unexpected response code for CONNECT: " + fromBytes.getResponseCode());
                }
                case 407: {
                    final RawHeaders rawHeaders = new RawHeaders(requestHeaders);
                    if (HttpAuthenticator.processAuthHeader(this.route.address.authenticator, 407, fromBytes, rawHeaders, this.route.proxy, new URL("https", tunnelRequest.host, tunnelRequest.port, "/"))) {
                        requestHeaders = rawHeaders;
                        continue;
                    }
                    throw new IOException("Failed to authenticate with proxy");
                }
                case 200: {}
            }
        }
    }
    
    private void streamWrapper() throws IOException {
        this.in = new BufferedInputStream(this.in, 4096);
        this.out = new BufferedOutputStream(this.out, 256);
    }
    
    private void upgradeToTls(final TunnelRequest tunnelRequest) throws IOException {
        final Platform value = Platform.get();
        if (this.requiresTunnel()) {
            this.makeTunnel(tunnelRequest);
        }
        this.socket = this.route.address.sslSocketFactory.createSocket(this.socket, this.route.address.uriHost, this.route.address.uriPort, true);
        final SSLSocket sslSocket = (SSLSocket)this.socket;
        if (this.route.modernTls) {
            value.enableTlsExtensions(sslSocket, this.route.address.uriHost);
        }
        else {
            value.supportTlsIntolerantServer(sslSocket);
        }
        boolean b;
        if (this.route.modernTls && this.route.address.transports.contains("spdy/3")) {
            b = true;
        }
        else {
            b = false;
        }
        if (b) {
            value.setNpnProtocols(sslSocket, Connection.NPN_PROTOCOLS);
        }
        sslSocket.startHandshake();
        if (!this.route.address.hostnameVerifier.verify(this.route.address.uriHost, sslSocket.getSession())) {
            throw new IOException("Hostname '" + this.route.address.uriHost + "' was not verified");
        }
        this.out = sslSocket.getOutputStream();
        this.in = sslSocket.getInputStream();
        this.streamWrapper();
        if (b) {
            final byte[] npnSelectedProtocol = value.getNpnSelectedProtocol(sslSocket);
            if (npnSelectedProtocol != null) {
                if (Arrays.equals(npnSelectedProtocol, Connection.SPDY3)) {
                    sslSocket.setSoTimeout(0);
                    (this.spdyConnection = new SpdyConnection.Builder(this.route.address.getUriHost(), true, this.in, this.out).build()).sendConnectionHeader();
                }
                else if (!Arrays.equals(npnSelectedProtocol, Connection.HTTP_11)) {
                    throw new IOException("Unexpected NPN transport " + new String(npnSelectedProtocol, "ISO-8859-1"));
                }
            }
        }
    }
    
    @Override
    public void close() throws IOException {
        this.socket.close();
    }
    
    public void connect(final int n, final int soTimeout, final TunnelRequest tunnelRequest) throws IOException {
        if (this.connected) {
            throw new IllegalStateException("already connected");
        }
        Socket socket;
        if (this.route.proxy.type() != Proxy.Type.HTTP) {
            socket = new Socket(this.route.proxy);
        }
        else {
            socket = new Socket();
        }
        this.socket = socket;
        Platform.get().connectSocket(this.socket, this.route.inetSocketAddress, n);
        this.socket.setSoTimeout(soTimeout);
        this.in = this.socket.getInputStream();
        this.out = this.socket.getOutputStream();
        if (this.route.address.sslSocketFactory != null) {
            this.upgradeToTls(tunnelRequest);
        }
        else {
            this.streamWrapper();
        }
        this.connected = true;
    }
    
    public int getHttpMinorVersion() {
        return this.httpMinorVersion;
    }
    
    public long getIdleStartTimeNs() {
        if (this.spdyConnection == null) {
            return this.idleStartTimeNs;
        }
        return this.spdyConnection.getIdleStartTimeNs();
    }
    
    public Route getRoute() {
        return this.route;
    }
    
    public Socket getSocket() {
        return this.socket;
    }
    
    public SpdyConnection getSpdyConnection() {
        return this.spdyConnection;
    }
    
    public boolean isAlive() {
        return !this.socket.isClosed() && !this.socket.isInputShutdown() && !this.socket.isOutputShutdown();
    }
    
    public boolean isConnected() {
        return this.connected;
    }
    
    public boolean isExpired(final long n) {
        return this.getIdleStartTimeNs() < System.nanoTime() - n;
    }
    
    public boolean isIdle() {
        return this.spdyConnection == null || this.spdyConnection.isIdle();
    }
    
    public boolean isReadable() {
        if (!(this.in instanceof BufferedInputStream) || this.isSpdy()) {
            return true;
        }
        final BufferedInputStream bufferedInputStream = (BufferedInputStream)this.in;
        try {
            final int soTimeout = this.socket.getSoTimeout();
            try {
                this.socket.setSoTimeout(1);
                bufferedInputStream.mark(1);
                if (bufferedInputStream.read() == -1) {
                    return false;
                }
                bufferedInputStream.reset();
                return true;
            }
            finally {
                this.socket.setSoTimeout(soTimeout);
            }
        }
        catch (IOException ex) {
            return false;
        }
        catch (SocketTimeoutException ex2) {
            return true;
        }
    }
    
    public boolean isSpdy() {
        return this.spdyConnection != null;
    }
    
    public Object newTransport(final HttpEngine httpEngine) throws IOException {
        if (this.spdyConnection != null) {
            return new SpdyTransport(httpEngine, this.spdyConnection);
        }
        return new HttpTransport(httpEngine, this.out, this.in);
    }
    
    public boolean requiresTunnel() {
        return this.route.address.sslSocketFactory != null && this.route.proxy.type() == Proxy.Type.HTTP;
    }
    
    public void resetIdleStartTime() {
        if (this.spdyConnection != null) {
            throw new IllegalStateException("spdyConnection != null");
        }
        this.idleStartTimeNs = System.nanoTime();
    }
    
    public void setHttpMinorVersion(final int httpMinorVersion) {
        this.httpMinorVersion = httpMinorVersion;
    }
    
    public void updateReadTimeout(final int soTimeout) throws IOException {
        if (!this.connected) {
            throw new IllegalStateException("updateReadTimeout - not connected");
        }
        this.socket.setSoTimeout(soTimeout);
    }
}
