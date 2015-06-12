// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import com.squareup.okhttp.internal.Util;
import java.nio.charset.Charset;
import java.io.Reader;
import java.util.List;
import java.util.Set;
import com.squareup.okhttp.internal.http.RawHeaders;

final class Response
{
    private final Body body;
    private final int code;
    private final RawHeaders headers;
    private final Response redirectedBy;
    private final Request request;
    
    private Response(final Builder builder) {
        this.request = builder.request;
        this.code = builder.code;
        this.headers = new RawHeaders(builder.headers);
        this.body = builder.body;
        this.redirectedBy = builder.redirectedBy;
    }
    
    public Body body() {
        return this.body;
    }
    
    public int code() {
        return this.code;
    }
    
    public String header(final String s) {
        return this.header(s, null);
    }
    
    public String header(final String s, final String s2) {
        final String value = this.headers.get(s);
        if (value != null) {
            return value;
        }
        return s2;
    }
    
    public int headerCount() {
        return this.headers.length();
    }
    
    public String headerName(final int n) {
        return this.headers.getFieldName(n);
    }
    
    public Set<String> headerNames() {
        return this.headers.names();
    }
    
    public String headerValue(final int n) {
        return this.headers.getValue(n);
    }
    
    public List<String> headers(final String s) {
        return this.headers.values(s);
    }
    
    RawHeaders rawHeaders() {
        return new RawHeaders(this.headers);
    }
    
    public Response redirectedBy() {
        return this.redirectedBy;
    }
    
    public Request request() {
        return this.request;
    }
    
    public abstract static class Body
    {
        private Reader reader;
        
        private Charset charset() {
            final MediaType contentType = this.contentType();
            if (contentType != null) {
                return contentType.charset(Util.UTF_8);
            }
            return Util.UTF_8;
        }
        
        public abstract InputStream byteStream() throws IOException;
        
        public final byte[] bytes() throws IOException {
            final long contentLength = this.contentLength();
            if (contentLength > 2147483647L) {
                throw new IOException("Cannot buffer entire body for content length: " + contentLength);
            }
            byte[] byteArray;
            if (contentLength != -1L) {
                byteArray = new byte[(int)contentLength];
                final InputStream byteStream = this.byteStream();
                Util.readFully(byteStream, byteArray);
                if (byteStream.read() != -1) {
                    throw new IOException("Content-Length and stream length disagree");
                }
            }
            else {
                final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Util.copy(this.byteStream(), byteArrayOutputStream);
                byteArray = byteArrayOutputStream.toByteArray();
            }
            return byteArray;
        }
        
        public final Reader charStream() throws IOException {
            if (this.reader == null) {
                this.reader = new InputStreamReader(this.byteStream(), this.charset());
            }
            return this.reader;
        }
        
        public abstract long contentLength();
        
        public abstract MediaType contentType();
        
        public abstract boolean ready() throws IOException;
        
        public final String string() throws IOException {
            return new String(this.bytes(), this.charset().name());
        }
    }
    
    public static class Builder
    {
        private Body body;
        private final int code;
        private RawHeaders headers;
        private Response redirectedBy;
        private final Request request;
        
        public Builder(final Request request, final int code) {
            this.headers = new RawHeaders();
            if (request == null) {
                throw new IllegalArgumentException("request == null");
            }
            if (code <= 0) {
                throw new IllegalArgumentException("code <= 0");
            }
            this.request = request;
            this.code = code;
        }
        
        public Builder addHeader(final String s, final String s2) {
            this.headers.add(s, s2);
            return this;
        }
        
        public Builder body(final Body body) {
            this.body = body;
            return this;
        }
        
        public Response build() {
            if (this.request == null) {
                throw new IllegalStateException("Response has no request.");
            }
            if (this.code == -1) {
                throw new IllegalStateException("Response has no code.");
            }
            return new Response(this, null);
        }
        
        public Builder header(final String s, final String s2) {
            this.headers.set(s, s2);
            return this;
        }
        
        Builder rawHeaders(final RawHeaders rawHeaders) {
            this.headers = new RawHeaders(rawHeaders);
            return this;
        }
        
        public Builder redirectedBy(final Response redirectedBy) {
            this.redirectedBy = redirectedBy;
            return this;
        }
    }
    
    public interface Receiver
    {
        void onFailure(Failure p0);
        
        boolean onResponse(Response p0) throws IOException;
    }
}
