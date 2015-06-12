// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp;

import java.security.cert.X509Certificate;
import java.security.Principal;
import java.util.Arrays;
import java.net.SecureCacheResponse;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.security.cert.CertificateEncodingException;
import java.io.Writer;
import java.security.cert.CertificateException;
import java.io.ByteArrayInputStream;
import com.squareup.okhttp.internal.Base64;
import java.security.cert.CertificateFactory;
import com.squareup.okhttp.internal.http.HttpsEngine;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLPeerUnverifiedException;
import com.squareup.okhttp.internal.StrictLineReader;
import com.squareup.okhttp.internal.http.RawHeaders;
import java.security.cert.Certificate;
import java.io.Closeable;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import com.squareup.okhttp.internal.http.ResponseHeaders;
import com.squareup.okhttp.internal.Util;
import java.io.FilterInputStream;
import com.squareup.okhttp.internal.http.HttpsURLConnectionImpl;
import com.squareup.okhttp.internal.http.HttpURLConnectionImpl;
import com.squareup.okhttp.internal.http.HttpEngine;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.CacheRequest;
import java.net.URLConnection;
import java.io.IOException;
import java.net.CacheResponse;
import java.util.List;
import java.util.Map;
import java.net.URI;
import java.io.File;
import com.squareup.okhttp.internal.DiskLruCache;
import java.net.ResponseCache;

public final class HttpResponseCache extends ResponseCache
{
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    final OkResponseCache okResponseCache;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;
    
    static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$okhttp$ResponseSource() {
        final int[] $switch_TABLE$com$squareup$okhttp$ResponseSource = HttpResponseCache.$SWITCH_TABLE$com$squareup$okhttp$ResponseSource;
        if ($switch_TABLE$com$squareup$okhttp$ResponseSource != null) {
            return $switch_TABLE$com$squareup$okhttp$ResponseSource;
        }
        final int[] $switch_TABLE$com$squareup$okhttp$ResponseSource2 = new int[ResponseSource.values().length];
        while (true) {
            try {
                $switch_TABLE$com$squareup$okhttp$ResponseSource2[ResponseSource.CACHE.ordinal()] = 1;
                try {
                    $switch_TABLE$com$squareup$okhttp$ResponseSource2[ResponseSource.CONDITIONAL_CACHE.ordinal()] = 2;
                    try {
                        $switch_TABLE$com$squareup$okhttp$ResponseSource2[ResponseSource.NETWORK.ordinal()] = 3;
                        return HttpResponseCache.$SWITCH_TABLE$com$squareup$okhttp$ResponseSource = $switch_TABLE$com$squareup$okhttp$ResponseSource2;
                    }
                    catch (NoSuchFieldError noSuchFieldError) {}
                }
                catch (NoSuchFieldError noSuchFieldError2) {}
            }
            catch (NoSuchFieldError noSuchFieldError3) {
                continue;
            }
            break;
        }
    }
    
    public HttpResponseCache(final File file, final long n) throws IOException {
        this.okResponseCache = new OkResponseCache() {
            @Override
            public CacheResponse get(final URI uri, final String s, final Map<String, List<String>> map) throws IOException {
                return HttpResponseCache.this.get(uri, s, map);
            }
            
            @Override
            public void maybeRemove(final String s, final URI uri) throws IOException {
                HttpResponseCache.this.maybeRemove(s, uri);
            }
            
            @Override
            public CacheRequest put(final URI uri, final URLConnection urlConnection) throws IOException {
                return HttpResponseCache.this.put(uri, urlConnection);
            }
            
            @Override
            public void trackConditionalCacheHit() {
                HttpResponseCache.this.trackConditionalCacheHit();
            }
            
            @Override
            public void trackResponse(final ResponseSource responseSource) {
                HttpResponseCache.this.trackResponse(responseSource);
            }
            
            @Override
            public void update(final CacheResponse cacheResponse, final HttpURLConnection httpURLConnection) throws IOException {
                HttpResponseCache.this.update(cacheResponse, httpURLConnection);
            }
        };
        this.cache = DiskLruCache.open(file, 201105, 2, n);
    }
    
    private void abortQuietly(final DiskLruCache.Editor editor) {
        if (editor == null) {
            return;
        }
        try {
            editor.abort();
        }
        catch (IOException ex) {}
    }
    
    static /* synthetic */ void access$5(final HttpResponseCache httpResponseCache, final int writeSuccessCount) {
        httpResponseCache.writeSuccessCount = writeSuccessCount;
    }
    
    static /* synthetic */ void access$7(final HttpResponseCache httpResponseCache, final int writeAbortCount) {
        httpResponseCache.writeAbortCount = writeAbortCount;
    }
    
    private HttpEngine getHttpEngine(final URLConnection urlConnection) {
        if (urlConnection instanceof HttpURLConnectionImpl) {
            return ((HttpURLConnectionImpl)urlConnection).getHttpEngine();
        }
        if (urlConnection instanceof HttpsURLConnectionImpl) {
            return ((HttpsURLConnectionImpl)urlConnection).getHttpEngine();
        }
        return null;
    }
    
    private boolean maybeRemove(final String s, final URI uri) {
        if (!s.equals("POST") && !s.equals("PUT")) {
            if (!s.equals("DELETE")) {
                return false;
            }
        }
        try {
            this.cache.remove(this.uriToKey(uri));
            return true;
        }
        catch (IOException ex) {
            return true;
        }
    }
    
    private static InputStream newBodyInputStream(final DiskLruCache.Snapshot snapshot) {
        return new FilterInputStream(snapshot.getInputStream(1)) {
            @Override
            public void close() throws IOException {
                snapshot.close();
                super.close();
            }
        };
    }
    
    private void trackConditionalCacheHit() {
        synchronized (this) {
            ++this.hitCount;
        }
    }
    
    private void trackResponse(final ResponseSource responseSource) {
        while (true) {
            Label_0069: {
                synchronized (this) {
                    ++this.requestCount;
                    switch ($SWITCH_TABLE$com$squareup$okhttp$ResponseSource()[responseSource.ordinal()]) {
                        case 1: {
                            ++this.hitCount;
                            break;
                        }
                        case 2:
                        case 3: {
                            break Label_0069;
                        }
                    }
                    return;
                }
            }
            ++this.networkCount;
        }
    }
    
    private void update(final CacheResponse cacheResponse, final HttpURLConnection httpURLConnection) throws IOException {
        final HttpEngine httpEngine = this.getHttpEngine(httpURLConnection);
        final Entry entry = new Entry(httpEngine.getUri(), httpEngine.getRequestHeaders().getHeaders().getAll(httpEngine.getResponseHeaders().getVaryFields()), httpURLConnection);
        Label_0089: {
            if (!(cacheResponse instanceof EntryCacheResponse)) {
                break Label_0089;
            }
            DiskLruCache.Snapshot snapshot = ((EntryCacheResponse)cacheResponse).snapshot;
            while (true) {
                DiskLruCache.Editor edit = null;
                try {
                    edit = snapshot.edit();
                    if (edit != null) {
                        entry.writeTo(edit);
                        edit.commit();
                    }
                    return;
                    snapshot = ((EntrySecureCacheResponse)cacheResponse).snapshot;
                }
                catch (IOException ex) {
                    this.abortQuietly(edit);
                }
            }
        }
    }
    
    private String uriToKey(final URI uri) {
        return Util.hash(uri.toString());
    }
    
    public void close() throws IOException {
        this.cache.close();
    }
    
    public void delete() throws IOException {
        this.cache.delete();
    }
    
    public void flush() throws IOException {
        this.cache.flush();
    }
    
    @Override
    public CacheResponse get(final URI uri, final String s, final Map<String, List<String>> map) {
        final String uriToKey = this.uriToKey(uri);
        DiskLruCache.Snapshot value;
        Entry entry;
        try {
            value = this.cache.get(uriToKey);
            if (value == null) {
                return null;
            }
            entry = new Entry(value.getInputStream(0));
            if (!entry.matches(uri, s, map)) {
                value.close();
                return null;
            }
        }
        catch (IOException ex) {
            return null;
        }
        if (entry.isHttps()) {
            return new EntrySecureCacheResponse(entry, value);
        }
        return new EntryCacheResponse(entry, value);
    }
    
    public File getDirectory() {
        return this.cache.getDirectory();
    }
    
    public int getHitCount() {
        synchronized (this) {
            return this.hitCount;
        }
    }
    
    public long getMaxSize() {
        return this.cache.getMaxSize();
    }
    
    public int getNetworkCount() {
        synchronized (this) {
            return this.networkCount;
        }
    }
    
    public int getRequestCount() {
        synchronized (this) {
            return this.requestCount;
        }
    }
    
    public long getSize() {
        return this.cache.size();
    }
    
    public int getWriteAbortCount() {
        synchronized (this) {
            return this.writeAbortCount;
        }
    }
    
    public int getWriteSuccessCount() {
        synchronized (this) {
            return this.writeSuccessCount;
        }
    }
    
    public boolean isClosed() {
        return this.cache.isClosed();
    }
    
    @Override
    public CacheRequest put(final URI uri, final URLConnection urlConnection) throws IOException {
        if (urlConnection instanceof HttpURLConnection) {
            final HttpURLConnection httpURLConnection = (HttpURLConnection)urlConnection;
            final String requestMethod = httpURLConnection.getRequestMethod();
            if (!this.maybeRemove(requestMethod, uri) && requestMethod.equals("GET")) {
                final HttpEngine httpEngine = this.getHttpEngine(httpURLConnection);
                if (httpEngine != null) {
                    final ResponseHeaders responseHeaders = httpEngine.getResponseHeaders();
                    if (!responseHeaders.hasVaryAll()) {
                        final Entry entry = new Entry(uri, httpEngine.getRequestHeaders().getHeaders().getAll(responseHeaders.getVaryFields()), httpURLConnection);
                        Object edit = null;
                        try {
                            edit = this.cache.edit(this.uriToKey(uri));
                            if (edit != null) {
                                entry.writeTo((DiskLruCache.Editor)edit);
                                return new CacheRequestImpl((DiskLruCache.Editor)edit);
                            }
                        }
                        catch (IOException ex) {
                            this.abortQuietly((DiskLruCache.Editor)edit);
                            return null;
                        }
                    }
                }
            }
        }
        return null;
    }
    
    private final class CacheRequestImpl extends CacheRequest
    {
        private OutputStream body;
        private OutputStream cacheOut;
        private boolean done;
        private final DiskLruCache.Editor editor;
        
        public CacheRequestImpl(final DiskLruCache.Editor editor) throws IOException {
            this.editor = editor;
            this.cacheOut = editor.newOutputStream(1);
            this.body = new FilterOutputStream(this.cacheOut) {
                @Override
                public void close() throws IOException {
                    synchronized (HttpResponseCache.this) {
                        if (CacheRequestImpl.this.done) {
                            return;
                        }
                        CacheRequestImpl.access$1(CacheRequestImpl.this, true);
                        final HttpResponseCache access$2 = HttpResponseCache.this;
                        HttpResponseCache.access$5(access$2, 1 + access$2.writeSuccessCount);
                        // monitorexit(CacheRequestImpl.access$2(this.this$1))
                        super.close();
                        editor.commit();
                    }
                }
                
                @Override
                public void write(final byte[] b, final int off, final int len) throws IOException {
                    this.out.write(b, off, len);
                }
            };
        }
        
        static /* synthetic */ void access$1(final CacheRequestImpl cacheRequestImpl, final boolean done) {
            cacheRequestImpl.done = done;
        }
        
        @Override
        public void abort() {
            synchronized (HttpResponseCache.this) {
                if (this.done) {
                    return;
                }
                this.done = true;
                final HttpResponseCache this$0 = HttpResponseCache.this;
                HttpResponseCache.access$7(this$0, 1 + this$0.writeAbortCount);
                // monitorexit(this.this$0)
                Util.closeQuietly(this.cacheOut);
                try {
                    this.editor.abort();
                }
                catch (IOException ex) {}
            }
        }
        
        @Override
        public OutputStream getBody() throws IOException {
            return this.body;
        }
    }
    
    private static final class Entry
    {
        private final String cipherSuite;
        private final Certificate[] localCertificates;
        private final Certificate[] peerCertificates;
        private final String requestMethod;
        private final RawHeaders responseHeaders;
        private final String uri;
        private final RawHeaders varyHeaders;
        
        public Entry(final InputStream inputStream) throws IOException {
        Label_0090_Outer:
            while (true) {
                Label_0220: {
                    StrictLineReader strictLineReader = null;
                Label_0189:
                    while (true) {
                        int n2 = 0;
                    Label_0172:
                        while (true) {
                            int n;
                            try {
                                strictLineReader = new StrictLineReader(inputStream, Util.US_ASCII);
                                this.uri = strictLineReader.readLine();
                                this.requestMethod = strictLineReader.readLine();
                                this.varyHeaders = new RawHeaders();
                                final int int1 = strictLineReader.readInt();
                                n = 0;
                                if (n >= int1) {
                                    (this.responseHeaders = new RawHeaders()).setStatusLine(strictLineReader.readLine());
                                    final int int2 = strictLineReader.readInt();
                                    n2 = 0;
                                    if (n2 < int2) {
                                        break Label_0172;
                                    }
                                    if (!this.isHttps()) {
                                        break Label_0220;
                                    }
                                    final String line = strictLineReader.readLine();
                                    if (line.length() > 0) {
                                        throw new IOException("expected \"\" but was \"" + line + "\"");
                                    }
                                    break Label_0189;
                                }
                            }
                            finally {
                                inputStream.close();
                            }
                            this.varyHeaders.addLine(strictLineReader.readLine());
                            ++n;
                            continue Label_0090_Outer;
                        }
                        this.responseHeaders.addLine(strictLineReader.readLine());
                        ++n2;
                        continue;
                    }
                    this.cipherSuite = strictLineReader.readLine();
                    this.peerCertificates = this.readCertArray(strictLineReader);
                    this.localCertificates = this.readCertArray(strictLineReader);
                    break;
                }
                this.cipherSuite = null;
                this.peerCertificates = null;
                this.localCertificates = null;
                break;
            }
            inputStream.close();
        }
        
        public Entry(final URI uri, final RawHeaders varyHeaders, final HttpURLConnection httpURLConnection) throws IOException {
            this.uri = uri.toString();
            this.varyHeaders = varyHeaders;
            this.requestMethod = httpURLConnection.getRequestMethod();
            this.responseHeaders = RawHeaders.fromMultimap(httpURLConnection.getHeaderFields(), true);
            final SSLSocket sslSocket = this.getSslSocket(httpURLConnection);
            Label_0100: {
                if (sslSocket == null) {
                    break Label_0100;
                }
                this.cipherSuite = sslSocket.getSession().getCipherSuite();
                while (true) {
                    try {
                        final Certificate[] peerCertificates = sslSocket.getSession().getPeerCertificates();
                        this.peerCertificates = peerCertificates;
                        this.localCertificates = sslSocket.getSession().getLocalCertificates();
                        return;
                        this.cipherSuite = null;
                        this.peerCertificates = null;
                        this.localCertificates = null;
                    }
                    catch (SSLPeerUnverifiedException ex) {
                        final Certificate[] peerCertificates = null;
                        continue;
                    }
                    break;
                }
            }
        }
        
        private SSLSocket getSslSocket(final HttpURLConnection httpURLConnection) {
            HttpEngine httpEngine;
            if (httpURLConnection instanceof HttpsURLConnectionImpl) {
                httpEngine = ((HttpsURLConnectionImpl)httpURLConnection).getHttpEngine();
            }
            else {
                httpEngine = ((HttpURLConnectionImpl)httpURLConnection).getHttpEngine();
            }
            if (httpEngine instanceof HttpsEngine) {
                return ((HttpsEngine)httpEngine).getSslSocket();
            }
            return null;
        }
        
        private boolean isHttps() {
            return this.uri.startsWith("https://");
        }
        
        private Certificate[] readCertArray(final StrictLineReader strictLineReader) throws IOException {
            final int int1 = strictLineReader.readInt();
            Certificate[] array;
            if (int1 == -1) {
                array = null;
            }
            else {
                try {
                    final CertificateFactory instance = CertificateFactory.getInstance("X.509");
                    array = new Certificate[int1];
                    for (int i = 0; i < array.length; ++i) {
                        array[i] = instance.generateCertificate(new ByteArrayInputStream(Base64.decode(strictLineReader.readLine().getBytes("US-ASCII"))));
                    }
                }
                catch (CertificateException ex) {
                    throw new IOException(ex.getMessage());
                }
            }
            return array;
        }
        
        private void writeCertArray(final Writer writer, final Certificate[] array) throws IOException {
            if (array == null) {
                writer.write("-1\n");
            }
            else {
                try {
                    writer.write(String.valueOf(Integer.toString(array.length)) + '\n');
                    for (int length = array.length, i = 0; i < length; ++i) {
                        writer.write(String.valueOf(Base64.encode(array[i].getEncoded())) + '\n');
                    }
                }
                catch (CertificateEncodingException ex) {
                    throw new IOException(ex.getMessage());
                }
            }
        }
        
        public boolean matches(final URI uri, final String anObject, final Map<String, List<String>> map) {
            final boolean equals = this.uri.equals(uri.toString());
            boolean b = false;
            if (equals) {
                final boolean equals2 = this.requestMethod.equals(anObject);
                b = false;
                if (equals2) {
                    final boolean varyMatches = new ResponseHeaders(uri, this.responseHeaders).varyMatches(this.varyHeaders.toMultimap(false), map);
                    b = false;
                    if (varyMatches) {
                        b = true;
                    }
                }
            }
            return b;
        }
        
        public void writeTo(final DiskLruCache.Editor editor) throws IOException {
            final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(editor.newOutputStream(0), Util.UTF_8));
            bufferedWriter.write(String.valueOf(this.uri) + '\n');
            bufferedWriter.write(String.valueOf(this.requestMethod) + '\n');
            bufferedWriter.write(String.valueOf(Integer.toString(this.varyHeaders.length())) + '\n');
            for (int i = 0; i < this.varyHeaders.length(); ++i) {
                bufferedWriter.write(String.valueOf(this.varyHeaders.getFieldName(i)) + ": " + this.varyHeaders.getValue(i) + '\n');
            }
            bufferedWriter.write(String.valueOf(this.responseHeaders.getStatusLine()) + '\n');
            bufferedWriter.write(String.valueOf(Integer.toString(this.responseHeaders.length())) + '\n');
            for (int j = 0; j < this.responseHeaders.length(); ++j) {
                bufferedWriter.write(String.valueOf(this.responseHeaders.getFieldName(j)) + ": " + this.responseHeaders.getValue(j) + '\n');
            }
            if (this.isHttps()) {
                bufferedWriter.write(10);
                bufferedWriter.write(String.valueOf(this.cipherSuite) + '\n');
                this.writeCertArray(bufferedWriter, this.peerCertificates);
                this.writeCertArray(bufferedWriter, this.localCertificates);
            }
            bufferedWriter.close();
        }
    }
    
    static class EntryCacheResponse extends CacheResponse
    {
        private final Entry entry;
        private final InputStream in;
        private final DiskLruCache.Snapshot snapshot;
        
        public EntryCacheResponse(final Entry entry, final DiskLruCache.Snapshot snapshot) {
            this.entry = entry;
            this.snapshot = snapshot;
            this.in = newBodyInputStream(snapshot);
        }
        
        @Override
        public InputStream getBody() {
            return this.in;
        }
        
        @Override
        public Map<String, List<String>> getHeaders() {
            return this.entry.responseHeaders.toMultimap(true);
        }
    }
    
    static class EntrySecureCacheResponse extends SecureCacheResponse
    {
        private final Entry entry;
        private final InputStream in;
        private final DiskLruCache.Snapshot snapshot;
        
        public EntrySecureCacheResponse(final Entry entry, final DiskLruCache.Snapshot snapshot) {
            this.entry = entry;
            this.snapshot = snapshot;
            this.in = newBodyInputStream(snapshot);
        }
        
        @Override
        public InputStream getBody() {
            return this.in;
        }
        
        @Override
        public String getCipherSuite() {
            return this.entry.cipherSuite;
        }
        
        @Override
        public Map<String, List<String>> getHeaders() {
            return this.entry.responseHeaders.toMultimap(true);
        }
        
        @Override
        public List<Certificate> getLocalCertificateChain() {
            if (this.entry.localCertificates == null || this.entry.localCertificates.length == 0) {
                return null;
            }
            return Arrays.asList((Certificate[])this.entry.localCertificates.clone());
        }
        
        @Override
        public Principal getLocalPrincipal() {
            if (this.entry.localCertificates == null || this.entry.localCertificates.length == 0) {
                return null;
            }
            return ((X509Certificate)this.entry.localCertificates[0]).getSubjectX500Principal();
        }
        
        @Override
        public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
            if (this.entry.peerCertificates == null || this.entry.peerCertificates.length == 0) {
                throw new SSLPeerUnverifiedException((String)null);
            }
            return ((X509Certificate)this.entry.peerCertificates[0]).getSubjectX500Principal();
        }
        
        @Override
        public List<Certificate> getServerCertificateChain() throws SSLPeerUnverifiedException {
            if (this.entry.peerCertificates == null || this.entry.peerCertificates.length == 0) {
                throw new SSLPeerUnverifiedException((String)null);
            }
            return Arrays.asList((Certificate[])this.entry.peerCertificates.clone());
        }
    }
}
