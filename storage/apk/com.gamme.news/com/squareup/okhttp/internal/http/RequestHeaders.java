// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.http;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.net.URI;

public final class RequestHeaders
{
    private String acceptEncoding;
    private String connection;
    private long contentLength;
    private String contentType;
    private boolean hasAuthorization;
    private final RawHeaders headers;
    private String host;
    private String ifModifiedSince;
    private String ifNoneMatch;
    private int maxAgeSeconds;
    private int maxStaleSeconds;
    private int minFreshSeconds;
    private boolean noCache;
    private boolean onlyIfCached;
    private String proxyAuthorization;
    private String transferEncoding;
    private final URI uri;
    private String userAgent;
    
    public RequestHeaders(final URI uri, final RawHeaders headers) {
        this.maxAgeSeconds = -1;
        this.maxStaleSeconds = -1;
        this.minFreshSeconds = -1;
        this.contentLength = -1L;
        this.uri = uri;
        this.headers = headers;
        final HeaderParser.CacheControlHandler cacheControlHandler = new HeaderParser.CacheControlHandler() {
            @Override
            public void handle(final String anotherString, final String s) {
                if ("no-cache".equalsIgnoreCase(anotherString)) {
                    RequestHeaders.access$0(RequestHeaders.this, true);
                }
                else {
                    if ("max-age".equalsIgnoreCase(anotherString)) {
                        RequestHeaders.access$1(RequestHeaders.this, HeaderParser.parseSeconds(s));
                        return;
                    }
                    if ("max-stale".equalsIgnoreCase(anotherString)) {
                        RequestHeaders.access$2(RequestHeaders.this, HeaderParser.parseSeconds(s));
                        return;
                    }
                    if ("min-fresh".equalsIgnoreCase(anotherString)) {
                        RequestHeaders.access$3(RequestHeaders.this, HeaderParser.parseSeconds(s));
                        return;
                    }
                    if ("only-if-cached".equalsIgnoreCase(anotherString)) {
                        RequestHeaders.access$4(RequestHeaders.this, true);
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
            else if ("Pragma".equalsIgnoreCase(fieldName)) {
                if ("no-cache".equalsIgnoreCase(value)) {
                    this.noCache = true;
                }
            }
            else if ("If-None-Match".equalsIgnoreCase(fieldName)) {
                this.ifNoneMatch = value;
            }
            else if ("If-Modified-Since".equalsIgnoreCase(fieldName)) {
                this.ifModifiedSince = value;
            }
            else if ("Authorization".equalsIgnoreCase(fieldName)) {
                this.hasAuthorization = true;
            }
            else if ("Content-Length".equalsIgnoreCase(fieldName)) {
                try {
                    this.contentLength = Integer.parseInt(value);
                }
                catch (NumberFormatException ex) {}
            }
            else if ("Transfer-Encoding".equalsIgnoreCase(fieldName)) {
                this.transferEncoding = value;
            }
            else if ("User-Agent".equalsIgnoreCase(fieldName)) {
                this.userAgent = value;
            }
            else if ("Host".equalsIgnoreCase(fieldName)) {
                this.host = value;
            }
            else if ("Connection".equalsIgnoreCase(fieldName)) {
                this.connection = value;
            }
            else if ("Accept-Encoding".equalsIgnoreCase(fieldName)) {
                this.acceptEncoding = value;
            }
            else if ("Content-Type".equalsIgnoreCase(fieldName)) {
                this.contentType = value;
            }
            else if ("Proxy-Authorization".equalsIgnoreCase(fieldName)) {
                this.proxyAuthorization = value;
            }
        }
    }
    
    static /* synthetic */ void access$0(final RequestHeaders requestHeaders, final boolean noCache) {
        requestHeaders.noCache = noCache;
    }
    
    static /* synthetic */ void access$1(final RequestHeaders requestHeaders, final int maxAgeSeconds) {
        requestHeaders.maxAgeSeconds = maxAgeSeconds;
    }
    
    static /* synthetic */ void access$2(final RequestHeaders requestHeaders, final int maxStaleSeconds) {
        requestHeaders.maxStaleSeconds = maxStaleSeconds;
    }
    
    static /* synthetic */ void access$3(final RequestHeaders requestHeaders, final int minFreshSeconds) {
        requestHeaders.minFreshSeconds = minFreshSeconds;
    }
    
    static /* synthetic */ void access$4(final RequestHeaders requestHeaders, final boolean onlyIfCached) {
        requestHeaders.onlyIfCached = onlyIfCached;
    }
    
    private String buildCookieHeader(final List<String> list) {
        if (list.size() == 1) {
            return list.get(0);
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); ++i) {
            if (i > 0) {
                sb.append("; ");
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }
    
    public void addCookies(final Map<String, List<String>> map) {
        for (final Map.Entry<String, List<String>> entry : map.entrySet()) {
            final String s = entry.getKey();
            if (("Cookie".equalsIgnoreCase(s) || "Cookie2".equalsIgnoreCase(s)) && !entry.getValue().isEmpty()) {
                this.headers.add(s, this.buildCookieHeader(entry.getValue()));
            }
        }
    }
    
    public String getAcceptEncoding() {
        return this.acceptEncoding;
    }
    
    public String getConnection() {
        return this.connection;
    }
    
    public long getContentLength() {
        return this.contentLength;
    }
    
    public String getContentType() {
        return this.contentType;
    }
    
    public RawHeaders getHeaders() {
        return this.headers;
    }
    
    public String getHost() {
        return this.host;
    }
    
    public String getIfModifiedSince() {
        return this.ifModifiedSince;
    }
    
    public String getIfNoneMatch() {
        return this.ifNoneMatch;
    }
    
    public int getMaxAgeSeconds() {
        return this.maxAgeSeconds;
    }
    
    public int getMaxStaleSeconds() {
        return this.maxStaleSeconds;
    }
    
    public int getMinFreshSeconds() {
        return this.minFreshSeconds;
    }
    
    public String getProxyAuthorization() {
        return this.proxyAuthorization;
    }
    
    public String getTransferEncoding() {
        return this.transferEncoding;
    }
    
    public URI getUri() {
        return this.uri;
    }
    
    public String getUserAgent() {
        return this.userAgent;
    }
    
    public boolean hasAuthorization() {
        return this.hasAuthorization;
    }
    
    public boolean hasConditions() {
        return this.ifModifiedSince != null || this.ifNoneMatch != null;
    }
    
    public boolean hasConnectionClose() {
        return "close".equalsIgnoreCase(this.connection);
    }
    
    public boolean isChunked() {
        return "chunked".equalsIgnoreCase(this.transferEncoding);
    }
    
    public boolean isNoCache() {
        return this.noCache;
    }
    
    public boolean isOnlyIfCached() {
        return this.onlyIfCached;
    }
    
    public void removeContentLength() {
        if (this.contentLength != -1L) {
            this.headers.removeAll("Content-Length");
            this.contentLength = -1L;
        }
    }
    
    public void setAcceptEncoding(final String acceptEncoding) {
        if (this.acceptEncoding != null) {
            this.headers.removeAll("Accept-Encoding");
        }
        this.headers.add("Accept-Encoding", acceptEncoding);
        this.acceptEncoding = acceptEncoding;
    }
    
    public void setChunked() {
        if (this.transferEncoding != null) {
            this.headers.removeAll("Transfer-Encoding");
        }
        this.headers.add("Transfer-Encoding", "chunked");
        this.transferEncoding = "chunked";
    }
    
    public void setConnection(final String connection) {
        if (this.connection != null) {
            this.headers.removeAll("Connection");
        }
        this.headers.add("Connection", connection);
        this.connection = connection;
    }
    
    public void setContentLength(final long n) {
        if (this.contentLength != -1L) {
            this.headers.removeAll("Content-Length");
        }
        this.headers.add("Content-Length", Long.toString(n));
        this.contentLength = n;
    }
    
    public void setContentType(final String contentType) {
        if (this.contentType != null) {
            this.headers.removeAll("Content-Type");
        }
        this.headers.add("Content-Type", contentType);
        this.contentType = contentType;
    }
    
    public void setHost(final String host) {
        if (this.host != null) {
            this.headers.removeAll("Host");
        }
        this.headers.add("Host", host);
        this.host = host;
    }
    
    public void setIfModifiedSince(final Date date) {
        if (this.ifModifiedSince != null) {
            this.headers.removeAll("If-Modified-Since");
        }
        final String format = HttpDate.format(date);
        this.headers.add("If-Modified-Since", format);
        this.ifModifiedSince = format;
    }
    
    public void setIfNoneMatch(final String ifNoneMatch) {
        if (this.ifNoneMatch != null) {
            this.headers.removeAll("If-None-Match");
        }
        this.headers.add("If-None-Match", ifNoneMatch);
        this.ifNoneMatch = ifNoneMatch;
    }
    
    public void setUserAgent(final String userAgent) {
        if (this.userAgent != null) {
            this.headers.removeAll("User-Agent");
        }
        this.headers.add("User-Agent", userAgent);
        this.userAgent = userAgent;
    }
}
