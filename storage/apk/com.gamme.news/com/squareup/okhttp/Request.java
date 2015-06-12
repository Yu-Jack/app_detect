// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp;

import java.net.MalformedURLException;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.io.Closeable;
import com.squareup.okhttp.internal.Util;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.net.URL;
import com.squareup.okhttp.internal.http.RawHeaders;

final class Request
{
    private final Body body;
    private final RawHeaders headers;
    private final String method;
    private final Object tag;
    private final URL url;
    
    private Request(final Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = new RawHeaders(builder.headers);
        this.body = builder.body;
        Object access$4;
        if (builder.tag != null) {
            access$4 = builder.tag;
        }
        else {
            access$4 = this;
        }
        this.tag = access$4;
    }
    
    public Body body() {
        return this.body;
    }
    
    public String header(final String s) {
        return this.headers.get(s);
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
    
    public String method() {
        return this.method;
    }
    
    Builder newBuilder() {
        return new Builder(this.url).method(this.method, this.body).rawHeaders(this.headers).tag(this.tag);
    }
    
    RawHeaders rawHeaders() {
        return new RawHeaders(this.headers);
    }
    
    public Object tag() {
        return this.tag;
    }
    
    public URL url() {
        return this.url;
    }
    
    public String urlString() {
        return this.url.toString();
    }
    
    public abstract static class Body
    {
        public static Body create(final MediaType mediaType, final File file) {
            if (mediaType == null) {
                throw new NullPointerException("contentType == null");
            }
            if (file == null) {
                throw new NullPointerException("content == null");
            }
            return new Body() {
                @Override
                public long contentLength() {
                    return file.length();
                }
                
                @Override
                public MediaType contentType() {
                    return mediaType;
                }
                
                @Override
                public void writeTo(final OutputStream outputStream) throws IOException {
                    final long contentLength = this.contentLength();
                    if (contentLength == 0L) {
                        return;
                    }
                    while (true) {
                        try {
                            final FileInputStream fileInputStream = new FileInputStream(file);
                            FileInputStream fileInputStream2;
                            try {
                                final byte[] array = new byte[(int)Math.min(8192L, contentLength)];
                                while (true) {
                                    final int read = fileInputStream.read(array);
                                    if (read == -1) {
                                        break;
                                    }
                                    outputStream.write(array, 0, read);
                                }
                                Util.closeQuietly(fileInputStream);
                                return;
                            }
                            finally {
                                fileInputStream2 = fileInputStream;
                            }
                            Util.closeQuietly(fileInputStream2);
                            throw;
                        }
                        finally {
                            final FileInputStream fileInputStream2 = null;
                            continue;
                        }
                        break;
                    }
                }
            };
        }
        
        public static Body create(MediaType parse, final String s) {
            Label_0025: {
                if (parse.charset() == null) {
                    break Label_0025;
                }
                try {
                    return create(parse, s.getBytes(parse.charset().name()));
                    parse = MediaType.parse(parse + "; charset=utf-8");
                    return create(parse, s.getBytes(parse.charset().name()));
                }
                catch (UnsupportedEncodingException ex) {
                    throw new AssertionError();
                }
            }
        }
        
        public static Body create(final MediaType mediaType, final byte[] array) {
            if (mediaType == null) {
                throw new NullPointerException("contentType == null");
            }
            if (array == null) {
                throw new NullPointerException("content == null");
            }
            return new Body() {
                @Override
                public long contentLength() {
                    return array.length;
                }
                
                @Override
                public MediaType contentType() {
                    return mediaType;
                }
                
                @Override
                public void writeTo(final OutputStream outputStream) throws IOException {
                    outputStream.write(array);
                }
            };
        }
        
        public long contentLength() {
            return -1L;
        }
        
        public abstract MediaType contentType();
        
        public abstract void writeTo(final OutputStream p0) throws IOException;
    }
    
    public static class Builder
    {
        private Body body;
        private RawHeaders headers;
        private String method;
        private Object tag;
        private URL url;
        
        public Builder(final String s) {
            this.method = "GET";
            this.headers = new RawHeaders();
            this.url(s);
        }
        
        public Builder(final URL url) {
            this.method = "GET";
            this.headers = new RawHeaders();
            this.url(url);
        }
        
        public Builder addHeader(final String s, final String s2) {
            this.headers.add(s, s2);
            return this;
        }
        
        public Request build() {
            return new Request(this, null);
        }
        
        public Builder get() {
            return this.method("GET", null);
        }
        
        public Builder head() {
            return this.method("HEAD", null);
        }
        
        public Builder header(final String s, final String s2) {
            this.headers.set(s, s2);
            return this;
        }
        
        public Builder method(final String method, final Body body) {
            if (method == null || method.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            }
            this.method = method;
            this.body = body;
            return this;
        }
        
        public Builder post(final Body body) {
            return this.method("POST", body);
        }
        
        public Builder put(final Body body) {
            return this.method("PUT", body);
        }
        
        Builder rawHeaders(final RawHeaders rawHeaders) {
            this.headers = new RawHeaders(rawHeaders);
            return this;
        }
        
        public Builder tag(final Object tag) {
            this.tag = tag;
            return this;
        }
        
        public Builder url(final String s) {
            try {
                this.url = new URL(s);
                return this;
            }
            catch (MalformedURLException ex) {
                throw new IllegalArgumentException("Malformed URL: " + s);
            }
        }
        
        public Builder url(final URL url) {
            if (url == null) {
                throw new IllegalStateException("url == null");
            }
            this.url = url;
            return this;
        }
    }
}
