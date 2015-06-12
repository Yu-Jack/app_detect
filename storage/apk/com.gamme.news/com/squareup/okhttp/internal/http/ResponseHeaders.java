// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.http;

import java.util.Iterator;
import com.squareup.okhttp.internal.Util;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.squareup.okhttp.ResponseSource;
import java.util.concurrent.TimeUnit;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.Collections;
import com.squareup.okhttp.internal.Platform;
import java.util.Set;
import java.net.URI;
import java.util.Date;

public final class ResponseHeaders
{
    private static final String RECEIVED_MILLIS;
    static final String RESPONSE_SOURCE;
    static final String SELECTED_TRANSPORT;
    private static final String SENT_MILLIS;
    private int ageSeconds;
    private String connection;
    private String contentEncoding;
    private long contentLength;
    private String contentType;
    private String etag;
    private Date expires;
    private final RawHeaders headers;
    private boolean isPublic;
    private Date lastModified;
    private int maxAgeSeconds;
    private boolean mustRevalidate;
    private boolean noCache;
    private boolean noStore;
    private long receivedResponseMillis;
    private int sMaxAgeSeconds;
    private long sentRequestMillis;
    private Date servedDate;
    private String transferEncoding;
    private final URI uri;
    private Set<String> varyFields;
    
    static {
        SENT_MILLIS = String.valueOf(Platform.get().getPrefix()) + "-Sent-Millis";
        RECEIVED_MILLIS = String.valueOf(Platform.get().getPrefix()) + "-Received-Millis";
        RESPONSE_SOURCE = String.valueOf(Platform.get().getPrefix()) + "-Response-Source";
        SELECTED_TRANSPORT = String.valueOf(Platform.get().getPrefix()) + "-Selected-Transport";
    }
    
    public ResponseHeaders(final URI uri, final RawHeaders headers) {
        this.maxAgeSeconds = -1;
        this.sMaxAgeSeconds = -1;
        this.ageSeconds = -1;
        this.varyFields = Collections.emptySet();
        this.contentLength = -1L;
        this.uri = uri;
        this.headers = headers;
        final HeaderParser.CacheControlHandler cacheControlHandler = new HeaderParser.CacheControlHandler() {
            @Override
            public void handle(final String s, final String s2) {
                if ("no-cache".equalsIgnoreCase(s)) {
                    ResponseHeaders.access$0(ResponseHeaders.this, true);
                }
                else {
                    if ("no-store".equalsIgnoreCase(s)) {
                        ResponseHeaders.access$1(ResponseHeaders.this, true);
                        return;
                    }
                    if ("max-age".equalsIgnoreCase(s)) {
                        ResponseHeaders.access$2(ResponseHeaders.this, HeaderParser.parseSeconds(s2));
                        return;
                    }
                    if ("s-maxage".equalsIgnoreCase(s)) {
                        ResponseHeaders.access$3(ResponseHeaders.this, HeaderParser.parseSeconds(s2));
                        return;
                    }
                    if ("public".equalsIgnoreCase(s)) {
                        ResponseHeaders.access$4(ResponseHeaders.this, true);
                        return;
                    }
                    if ("must-revalidate".equalsIgnoreCase(s)) {
                        ResponseHeaders.access$5(ResponseHeaders.this, true);
                    }
                }
            }
        };
        for (int i = 0; i < headers.length(); ++i) {
            final String fieldName = headers.getFieldName(i);
            final String value = headers.getValue(i);
            if ("Cache-Control".equalsIgnoreCase(fieldName)) {
                HeaderParser.parseCacheControl(value, (HeaderParser.CacheControlHandler)cacheControlHandler);
            }
            else if ("Date".equalsIgnoreCase(fieldName)) {
                this.servedDate = HttpDate.parse(value);
            }
            else if ("Expires".equalsIgnoreCase(fieldName)) {
                this.expires = HttpDate.parse(value);
            }
            else if ("Last-Modified".equalsIgnoreCase(fieldName)) {
                this.lastModified = HttpDate.parse(value);
            }
            else if ("ETag".equalsIgnoreCase(fieldName)) {
                this.etag = value;
            }
            else if ("Pragma".equalsIgnoreCase(fieldName)) {
                if ("no-cache".equalsIgnoreCase(value)) {
                    this.noCache = true;
                }
            }
            else if ("Age".equalsIgnoreCase(fieldName)) {
                this.ageSeconds = HeaderParser.parseSeconds(value);
            }
            else if ("Vary".equalsIgnoreCase(fieldName)) {
                if (this.varyFields.isEmpty()) {
                    this.varyFields = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
                }
                final String[] split = value.split(",");
                for (int length = split.length, j = 0; j < length; ++j) {
                    this.varyFields.add(split[j].trim());
                }
            }
            else if ("Content-Encoding".equalsIgnoreCase(fieldName)) {
                this.contentEncoding = value;
            }
            else if ("Transfer-Encoding".equalsIgnoreCase(fieldName)) {
                this.transferEncoding = value;
            }
            else if ("Content-Length".equalsIgnoreCase(fieldName)) {
                try {
                    this.contentLength = Long.parseLong(value);
                }
                catch (NumberFormatException ex) {}
            }
            else if ("Content-Type".equalsIgnoreCase(fieldName)) {
                this.contentType = value;
            }
            else if ("Connection".equalsIgnoreCase(fieldName)) {
                this.connection = value;
            }
            else if (ResponseHeaders.SENT_MILLIS.equalsIgnoreCase(fieldName)) {
                this.sentRequestMillis = Long.parseLong(value);
            }
            else if (ResponseHeaders.RECEIVED_MILLIS.equalsIgnoreCase(fieldName)) {
                this.receivedResponseMillis = Long.parseLong(value);
            }
        }
    }
    
    static /* synthetic */ void access$0(final ResponseHeaders responseHeaders, final boolean noCache) {
        responseHeaders.noCache = noCache;
    }
    
    static /* synthetic */ void access$1(final ResponseHeaders responseHeaders, final boolean noStore) {
        responseHeaders.noStore = noStore;
    }
    
    static /* synthetic */ void access$2(final ResponseHeaders responseHeaders, final int maxAgeSeconds) {
        responseHeaders.maxAgeSeconds = maxAgeSeconds;
    }
    
    static /* synthetic */ void access$3(final ResponseHeaders responseHeaders, final int sMaxAgeSeconds) {
        responseHeaders.sMaxAgeSeconds = sMaxAgeSeconds;
    }
    
    static /* synthetic */ void access$4(final ResponseHeaders responseHeaders, final boolean isPublic) {
        responseHeaders.isPublic = isPublic;
    }
    
    static /* synthetic */ void access$5(final ResponseHeaders responseHeaders, final boolean mustRevalidate) {
        responseHeaders.mustRevalidate = mustRevalidate;
    }
    
    private long computeAge(final long n) {
        long max = 0L;
        if (this.servedDate != null) {
            max = Math.max(max, this.receivedResponseMillis - this.servedDate.getTime());
        }
        long max2;
        if (this.ageSeconds != -1) {
            max2 = Math.max(max, TimeUnit.SECONDS.toMillis(this.ageSeconds));
        }
        else {
            max2 = max;
        }
        return n - this.receivedResponseMillis + (max2 + (this.receivedResponseMillis - this.sentRequestMillis));
    }
    
    private long computeFreshnessLifetime() {
        long millis = 0L;
        if (this.maxAgeSeconds != -1) {
            millis = TimeUnit.SECONDS.toMillis(this.maxAgeSeconds);
        }
        else {
            if (this.expires != null) {
                long n;
                if (this.servedDate != null) {
                    n = this.servedDate.getTime();
                }
                else {
                    n = this.receivedResponseMillis;
                }
                long n2 = this.expires.getTime() - n;
                if (n2 <= millis) {
                    n2 = millis;
                }
                return n2;
            }
            if (this.lastModified != null && this.uri.getRawQuery() == null) {
                long n3;
                if (this.servedDate != null) {
                    n3 = this.servedDate.getTime();
                }
                else {
                    n3 = this.sentRequestMillis;
                }
                final long n4 = n3 - this.lastModified.getTime();
                if (n4 > millis) {
                    return n4 / 10L;
                }
            }
        }
        return millis;
    }
    
    private static boolean isEndToEnd(final String s) {
        return !"Connection".equalsIgnoreCase(s) && !"Keep-Alive".equalsIgnoreCase(s) && !"Proxy-Authenticate".equalsIgnoreCase(s) && !"Proxy-Authorization".equalsIgnoreCase(s) && !"TE".equalsIgnoreCase(s) && !"Trailers".equalsIgnoreCase(s) && !"Transfer-Encoding".equalsIgnoreCase(s) && !"Upgrade".equalsIgnoreCase(s);
    }
    
    private boolean isFreshnessLifetimeHeuristic() {
        return this.maxAgeSeconds == -1 && this.expires == null;
    }
    
    public ResponseSource chooseResponseSource(final long n, final RequestHeaders requestHeaders) {
        if (!this.isCacheable(requestHeaders)) {
            return ResponseSource.NETWORK;
        }
        if (requestHeaders.isNoCache() || requestHeaders.hasConditions()) {
            return ResponseSource.NETWORK;
        }
        final long computeAge = this.computeAge(n);
        long a = this.computeFreshnessLifetime();
        if (requestHeaders.getMaxAgeSeconds() != -1) {
            a = Math.min(a, TimeUnit.SECONDS.toMillis(requestHeaders.getMaxAgeSeconds()));
        }
        long millis = 0L;
        if (requestHeaders.getMinFreshSeconds() != -1) {
            millis = TimeUnit.SECONDS.toMillis(requestHeaders.getMinFreshSeconds());
        }
        long millis2 = 0L;
        if (!this.mustRevalidate && requestHeaders.getMaxStaleSeconds() != -1) {
            millis2 = TimeUnit.SECONDS.toMillis(requestHeaders.getMaxStaleSeconds());
        }
        if (!this.noCache && computeAge + millis < a + millis2) {
            if (computeAge + millis >= a) {
                this.headers.add("Warning", "110 HttpURLConnection \"Response is stale\"");
            }
            if (computeAge > 86400000L && this.isFreshnessLifetimeHeuristic()) {
                this.headers.add("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
            }
            return ResponseSource.CACHE;
        }
        if (this.lastModified != null) {
            requestHeaders.setIfModifiedSince(this.lastModified);
        }
        else if (this.servedDate != null) {
            requestHeaders.setIfModifiedSince(this.servedDate);
        }
        if (this.etag != null) {
            requestHeaders.setIfNoneMatch(this.etag);
        }
        if (requestHeaders.hasConditions()) {
            return ResponseSource.CONDITIONAL_CACHE;
        }
        return ResponseSource.NETWORK;
    }
    
    public ResponseHeaders combine(final ResponseHeaders responseHeaders) throws IOException {
        final RawHeaders rawHeaders = new RawHeaders();
        rawHeaders.setStatusLine(this.headers.getStatusLine());
        for (int i = 0; i < this.headers.length(); ++i) {
            final String fieldName = this.headers.getFieldName(i);
            final String value = this.headers.getValue(i);
            if ((!"Warning".equals(fieldName) || !value.startsWith("1")) && (!isEndToEnd(fieldName) || responseHeaders.headers.get(fieldName) == null)) {
                rawHeaders.add(fieldName, value);
            }
        }
        for (int j = 0; j < responseHeaders.headers.length(); ++j) {
            final String fieldName2 = responseHeaders.headers.getFieldName(j);
            if (isEndToEnd(fieldName2)) {
                rawHeaders.add(fieldName2, responseHeaders.headers.getValue(j));
            }
        }
        return new ResponseHeaders(this.uri, rawHeaders);
    }
    
    public String getConnection() {
        return this.connection;
    }
    
    public String getContentEncoding() {
        return this.contentEncoding;
    }
    
    public long getContentLength() {
        return this.contentLength;
    }
    
    public String getContentType() {
        return this.contentType;
    }
    
    public String getEtag() {
        return this.etag;
    }
    
    public Date getExpires() {
        return this.expires;
    }
    
    public RawHeaders getHeaders() {
        return this.headers;
    }
    
    public Date getLastModified() {
        return this.lastModified;
    }
    
    public int getMaxAgeSeconds() {
        return this.maxAgeSeconds;
    }
    
    public int getSMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }
    
    public Date getServedDate() {
        return this.servedDate;
    }
    
    public URI getUri() {
        return this.uri;
    }
    
    public Set<String> getVaryFields() {
        return this.varyFields;
    }
    
    public boolean hasConnectionClose() {
        return "close".equalsIgnoreCase(this.connection);
    }
    
    public boolean hasVaryAll() {
        return this.varyFields.contains("*");
    }
    
    public boolean isCacheable(final RequestHeaders requestHeaders) {
        final int responseCode = this.headers.getResponseCode();
        return (responseCode == 200 || responseCode == 203 || responseCode == 300 || responseCode == 301 || responseCode == 410) && (!requestHeaders.hasAuthorization() || this.isPublic || this.mustRevalidate || this.sMaxAgeSeconds != -1) && !this.noStore;
    }
    
    public boolean isChunked() {
        return "chunked".equalsIgnoreCase(this.transferEncoding);
    }
    
    public boolean isContentEncodingGzip() {
        return "gzip".equalsIgnoreCase(this.contentEncoding);
    }
    
    public boolean isMustRevalidate() {
        return this.mustRevalidate;
    }
    
    public boolean isNoCache() {
        return this.noCache;
    }
    
    public boolean isNoStore() {
        return this.noStore;
    }
    
    public boolean isPublic() {
        return this.isPublic;
    }
    
    public void setLocalTimestamps(final long n, final long n2) {
        this.sentRequestMillis = n;
        this.headers.add(ResponseHeaders.SENT_MILLIS, Long.toString(n));
        this.receivedResponseMillis = n2;
        this.headers.add(ResponseHeaders.RECEIVED_MILLIS, Long.toString(n2));
    }
    
    public void setResponseSource(final ResponseSource responseSource) {
        this.headers.set(ResponseHeaders.RESPONSE_SOURCE, String.valueOf(responseSource.toString()) + " " + this.headers.getResponseCode());
    }
    
    public void setTransport(final String s) {
        this.headers.set(ResponseHeaders.SELECTED_TRANSPORT, s);
    }
    
    public void stripContentEncoding() {
        this.contentEncoding = null;
        this.headers.removeAll("Content-Encoding");
    }
    
    public void stripContentLength() {
        this.contentLength = -1L;
        this.headers.removeAll("Content-Length");
    }
    
    public boolean validate(final ResponseHeaders responseHeaders) {
        return responseHeaders.headers.getResponseCode() == 304 || (this.lastModified != null && responseHeaders.lastModified != null && responseHeaders.lastModified.getTime() < this.lastModified.getTime());
    }
    
    public boolean varyMatches(final Map<String, List<String>> map, final Map<String, List<String>> map2) {
        for (final String s : this.varyFields) {
            if (!Util.equal(map.get(s), map2.get(s))) {
                return false;
            }
        }
        return true;
    }
}
