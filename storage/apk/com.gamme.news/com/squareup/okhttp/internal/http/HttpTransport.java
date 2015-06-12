// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.http;

import java.io.ByteArrayOutputStream;
import java.net.ProtocolException;
import com.squareup.okhttp.internal.AbstractOutputStream;
import java.net.CacheRequest;
import java.net.Socket;
import com.squareup.okhttp.Connection;
import java.io.IOException;
import com.squareup.okhttp.internal.Util;
import java.io.InputStream;
import java.io.OutputStream;

public final class HttpTransport implements Transport
{
    public static final int DEFAULT_CHUNK_LENGTH = 1024;
    private static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;
    private final HttpEngine httpEngine;
    private OutputStream requestOut;
    private final InputStream socketIn;
    private final OutputStream socketOut;
    
    public HttpTransport(final HttpEngine httpEngine, final OutputStream outputStream, final InputStream socketIn) {
        this.httpEngine = httpEngine;
        this.socketOut = outputStream;
        this.requestOut = outputStream;
        this.socketIn = socketIn;
    }
    
    private static boolean discardStream(final HttpEngine httpEngine, final InputStream inputStream) {
        final Connection connection = httpEngine.connection;
        if (connection != null) {
            final Socket socket = connection.getSocket();
            if (socket != null) {
                try {
                    final int soTimeout = socket.getSoTimeout();
                    socket.setSoTimeout(100);
                    try {
                        Util.skipAll(inputStream);
                        return true;
                    }
                    finally {
                        socket.setSoTimeout(soTimeout);
                    }
                }
                catch (IOException ex) {
                    return false;
                }
            }
        }
        return false;
    }
    
    @Override
    public OutputStream createRequestBody() throws IOException {
        int chunked = this.httpEngine.requestHeaders.isChunked() ? 1 : 0;
        if (chunked == 0 && this.httpEngine.policy.getChunkLength() > 0 && this.httpEngine.connection.getHttpMinorVersion() != 0) {
            this.httpEngine.requestHeaders.setChunked();
            chunked = 1;
        }
        if (chunked != 0) {
            int chunkLength = this.httpEngine.policy.getChunkLength();
            if (chunkLength == -1) {
                chunkLength = 1024;
            }
            this.writeRequestHeaders();
            return new ChunkedOutputStream(this.requestOut, chunkLength, null);
        }
        final long fixedContentLength = this.httpEngine.policy.getFixedContentLength();
        if (fixedContentLength != -1L) {
            this.httpEngine.requestHeaders.setContentLength(fixedContentLength);
            this.writeRequestHeaders();
            return new FixedLengthOutputStream(this.requestOut, fixedContentLength, null);
        }
        final long contentLength = this.httpEngine.requestHeaders.getContentLength();
        if (contentLength > 2147483647L) {
            throw new IllegalArgumentException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
        }
        if (contentLength != -1L) {
            this.writeRequestHeaders();
            return new RetryableOutputStream((int)contentLength);
        }
        return new RetryableOutputStream();
    }
    
    @Override
    public void flushRequest() throws IOException {
        this.requestOut.flush();
        this.requestOut = this.socketOut;
    }
    
    @Override
    public InputStream getTransferStream(final CacheRequest cacheRequest) throws IOException {
        if (!this.httpEngine.hasResponseBody()) {
            return new FixedLengthInputStream(this.socketIn, cacheRequest, this.httpEngine, 0L);
        }
        if (this.httpEngine.responseHeaders.isChunked()) {
            return new ChunkedInputStream(this.socketIn, cacheRequest, this);
        }
        if (this.httpEngine.responseHeaders.getContentLength() != -1L) {
            return new FixedLengthInputStream(this.socketIn, cacheRequest, this.httpEngine, this.httpEngine.responseHeaders.getContentLength());
        }
        return new UnknownLengthHttpInputStream(this.socketIn, cacheRequest, this.httpEngine);
    }
    
    @Override
    public boolean makeReusable(final boolean b, final OutputStream outputStream, final InputStream inputStream) {
        return !b && (outputStream == null || ((AbstractOutputStream)outputStream).isClosed()) && !this.httpEngine.requestHeaders.hasConnectionClose() && (this.httpEngine.responseHeaders == null || !this.httpEngine.responseHeaders.hasConnectionClose()) && !(inputStream instanceof UnknownLengthHttpInputStream) && (inputStream == null || discardStream(this.httpEngine, inputStream));
    }
    
    @Override
    public ResponseHeaders readResponseHeaders() throws IOException {
        final RawHeaders fromBytes = RawHeaders.fromBytes(this.socketIn);
        this.httpEngine.connection.setHttpMinorVersion(fromBytes.getHttpMinorVersion());
        this.httpEngine.receiveHeaders(fromBytes);
        final ResponseHeaders responseHeaders = new ResponseHeaders(this.httpEngine.uri, fromBytes);
        responseHeaders.setTransport("http/1.1");
        return responseHeaders;
    }
    
    @Override
    public void writeRequestBody(final RetryableOutputStream retryableOutputStream) throws IOException {
        retryableOutputStream.writeToSocket(this.requestOut);
    }
    
    @Override
    public void writeRequestHeaders() throws IOException {
        this.httpEngine.writingRequestHeaders();
        this.requestOut.write(this.httpEngine.requestHeaders.getHeaders().toBytes());
    }
    
    private static class ChunkedInputStream extends AbstractHttpInputStream
    {
        private static final int NO_CHUNK_YET = -1;
        private int bytesRemainingInChunk;
        private boolean hasMoreChunks;
        private final HttpTransport transport;
        
        ChunkedInputStream(final InputStream inputStream, final CacheRequest cacheRequest, final HttpTransport transport) throws IOException {
            super(inputStream, transport.httpEngine, cacheRequest);
            this.bytesRemainingInChunk = -1;
            this.hasMoreChunks = true;
            this.transport = transport;
        }
        
        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                Util.readAsciiLine(this.in);
            }
            String str = Util.readAsciiLine(this.in);
            final int index = str.indexOf(";");
            if (index != -1) {
                str = str.substring(0, index);
            }
            try {
                this.bytesRemainingInChunk = Integer.parseInt(str.trim(), 16);
                if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    final RawHeaders headers = this.httpEngine.responseHeaders.getHeaders();
                    RawHeaders.readHeaders(this.transport.socketIn, headers);
                    this.httpEngine.receiveHeaders(headers);
                    this.endOfInput();
                }
            }
            catch (NumberFormatException ex) {
                throw new ProtocolException("Expected a hex chunk size but was " + str);
            }
        }
        
        @Override
        public int available() throws IOException {
            this.checkNotClosed();
            if (!this.hasMoreChunks || this.bytesRemainingInChunk == -1) {
                return 0;
            }
            return Math.min(this.in.available(), this.bytesRemainingInChunk);
        }
        
        @Override
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (this.hasMoreChunks && !discardStream(this.httpEngine, this)) {
                this.unexpectedEndOfInput();
            }
            this.closed = true;
        }
        
        @Override
        public int read(final byte[] b, final int off, final int a) throws IOException {
            Util.checkOffsetAndCount(b.length, off, a);
            this.checkNotClosed();
            if (!this.hasMoreChunks) {
                return -1;
            }
            if (this.bytesRemainingInChunk == 0 || this.bytesRemainingInChunk == -1) {
                this.readChunkSize();
                if (!this.hasMoreChunks) {
                    return -1;
                }
            }
            final int read = this.in.read(b, off, Math.min(a, this.bytesRemainingInChunk));
            if (read == -1) {
                this.unexpectedEndOfInput();
                throw new IOException("unexpected end of stream");
            }
            this.bytesRemainingInChunk -= read;
            this.cacheWrite(b, off, read);
            return read;
        }
    }
    
    private static final class ChunkedOutputStream extends AbstractOutputStream
    {
        private static final byte[] CRLF;
        private static final byte[] FINAL_CHUNK;
        private static final byte[] HEX_DIGITS;
        private final ByteArrayOutputStream bufferedChunk;
        private final byte[] hex;
        private final int maxChunkLength;
        private final OutputStream socketOut;
        
        static {
            CRLF = new byte[] { 13, 10 };
            HEX_DIGITS = new byte[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
            FINAL_CHUNK = new byte[] { 48, 13, 10, 13, 10 };
        }
        
        private ChunkedOutputStream(final OutputStream socketOut, final int size) {
            this.hex = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 13, 10 };
            this.socketOut = socketOut;
            this.maxChunkLength = Math.max(1, this.dataLength(size));
            this.bufferedChunk = new ByteArrayOutputStream(size);
        }
        
        private int dataLength(final int n) {
            int n2 = 4;
            for (int i = n - n2; i > 0; i >>= 4) {
                ++n2;
            }
            return n - n2;
        }
        
        private void writeBufferedChunkToSocket() throws IOException {
            final int size = this.bufferedChunk.size();
            if (size <= 0) {
                return;
            }
            this.writeHex(size);
            this.bufferedChunk.writeTo(this.socketOut);
            this.bufferedChunk.reset();
            this.socketOut.write(ChunkedOutputStream.CRLF);
        }
        
        private void writeHex(int i) throws IOException {
            int off = 8;
            do {
                final byte[] hex = this.hex;
                --off;
                hex[off] = ChunkedOutputStream.HEX_DIGITS[i & 0xF];
                i >>>= 4;
            } while (i != 0);
            this.socketOut.write(this.hex, off, this.hex.length - off);
        }
        
        @Override
        public void close() throws IOException {
            synchronized (this) {
                if (!this.closed) {
                    this.closed = true;
                    this.writeBufferedChunkToSocket();
                    this.socketOut.write(ChunkedOutputStream.FINAL_CHUNK);
                }
            }
        }
        
        @Override
        public void flush() throws IOException {
            synchronized (this) {
                if (!this.closed) {
                    this.writeBufferedChunkToSocket();
                    this.socketOut.flush();
                }
            }
        }
        
        @Override
        public void write(final byte[] array, int n, int a) throws IOException {
            while (true) {
                while (true) {
                    int n2;
                    synchronized (this) {
                        this.checkNotClosed();
                        Util.checkOffsetAndCount(array.length, n, a);
                        if (a <= 0) {
                            return;
                        }
                        if (this.bufferedChunk.size() > 0 || a < this.maxChunkLength) {
                            n2 = Math.min(a, this.maxChunkLength - this.bufferedChunk.size());
                            this.bufferedChunk.write(array, n, n2);
                            if (this.bufferedChunk.size() == this.maxChunkLength) {
                                this.writeBufferedChunkToSocket();
                            }
                        }
                        else {
                            n2 = this.maxChunkLength;
                            this.writeHex(n2);
                            this.socketOut.write(array, n, n2);
                            this.socketOut.write(ChunkedOutputStream.CRLF);
                        }
                    }
                    n += n2;
                    a -= n2;
                    continue;
                }
            }
        }
    }
    
    private static class FixedLengthInputStream extends AbstractHttpInputStream
    {
        private long bytesRemaining;
        
        public FixedLengthInputStream(final InputStream inputStream, final CacheRequest cacheRequest, final HttpEngine httpEngine, final long bytesRemaining) throws IOException {
            super(inputStream, httpEngine, cacheRequest);
            this.bytesRemaining = bytesRemaining;
            if (this.bytesRemaining == 0L) {
                this.endOfInput();
            }
        }
        
        @Override
        public int available() throws IOException {
            this.checkNotClosed();
            if (this.bytesRemaining == 0L) {
                return 0;
            }
            return (int)Math.min(this.in.available(), this.bytesRemaining);
        }
        
        @Override
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (this.bytesRemaining != 0L && !discardStream(this.httpEngine, this)) {
                this.unexpectedEndOfInput();
            }
            this.closed = true;
        }
        
        @Override
        public int read(final byte[] b, final int off, final int n) throws IOException {
            Util.checkOffsetAndCount(b.length, off, n);
            this.checkNotClosed();
            int read;
            if (this.bytesRemaining == 0L) {
                read = -1;
            }
            else {
                read = this.in.read(b, off, (int)Math.min(n, this.bytesRemaining));
                if (read == -1) {
                    this.unexpectedEndOfInput();
                    throw new ProtocolException("unexpected end of stream");
                }
                this.bytesRemaining -= read;
                this.cacheWrite(b, off, read);
                if (this.bytesRemaining == 0L) {
                    this.endOfInput();
                    return read;
                }
            }
            return read;
        }
    }
    
    private static final class FixedLengthOutputStream extends AbstractOutputStream
    {
        private long bytesRemaining;
        private final OutputStream socketOut;
        
        private FixedLengthOutputStream(final OutputStream socketOut, final long bytesRemaining) {
            this.socketOut = socketOut;
            this.bytesRemaining = bytesRemaining;
        }
        
        @Override
        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                if (this.bytesRemaining > 0L) {
                    throw new ProtocolException("unexpected end of stream");
                }
            }
        }
        
        @Override
        public void flush() throws IOException {
            if (this.closed) {
                return;
            }
            this.socketOut.flush();
        }
        
        @Override
        public void write(final byte[] b, final int off, final int n) throws IOException {
            this.checkNotClosed();
            Util.checkOffsetAndCount(b.length, off, n);
            if (n > this.bytesRemaining) {
                throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + n);
            }
            this.socketOut.write(b, off, n);
            this.bytesRemaining -= n;
        }
    }
}
