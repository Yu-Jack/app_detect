// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.Util;
import java.util.Collection;
import java.util.ArrayList;
import java.net.SocketTimeoutException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;

public final class SpdyStream
{
    public static final int WINDOW_UPDATE_THRESHOLD = 32768;
    private final SpdyConnection connection;
    private ErrorCode errorCode;
    private final int id;
    private final SpdyDataInputStream in;
    private final SpdyDataOutputStream out;
    private final int priority;
    private long readTimeoutMillis;
    private final List<String> requestHeaders;
    private List<String> responseHeaders;
    private int writeWindowSize;
    
    SpdyStream(final int id, final SpdyConnection connection, final boolean b, final boolean b2, final int priority, final List<String> requestHeaders, final Settings settings) {
        this.readTimeoutMillis = 0L;
        this.in = new SpdyDataInputStream((SpdyDataInputStream)null);
        this.out = new SpdyDataOutputStream((SpdyDataOutputStream)null);
        this.errorCode = null;
        if (connection == null) {
            throw new NullPointerException("connection == null");
        }
        if (requestHeaders == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.id = id;
        this.connection = connection;
        SpdyDataInputStream.access$1(this.in, b2);
        SpdyDataOutputStream.access$1(this.out, b);
        this.priority = priority;
        this.requestHeaders = requestHeaders;
        this.setSettings(settings);
    }
    
    private void cancelStreamIfNecessary() throws IOException {
        assert !Thread.holdsLock(this);
        while (true) {
            while (true) {
                Label_0112: {
                    final boolean open;
                    synchronized (this) {
                        if (!this.in.finished && this.in.closed && (this.out.finished || this.out.closed)) {
                            break Label_0112;
                        }
                        final int n = 0;
                        open = this.isOpen();
                        // monitorexit(this)
                        if (n != 0) {
                            this.close(ErrorCode.CANCEL);
                            return;
                        }
                    }
                    if (!open) {
                        break;
                    }
                    return;
                }
                final int n = 1;
                continue;
            }
        }
        this.connection.removeStream(this.id);
    }
    
    private boolean closeInternal(final ErrorCode errorCode) {
        assert !Thread.holdsLock(this);
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.in.finished && this.out.finished) {
                return false;
            }
        }
        this.errorCode = errorCode;
        this.notifyAll();
        // monitorexit(this)
        this.connection.removeStream(this.id);
        return true;
    }
    
    private void setSettings(final Settings settings) {
        int initialWindowSize = 65536;
        assert Thread.holdsLock(this.connection);
        if (settings != null) {
            initialWindowSize = settings.getInitialWindowSize(initialWindowSize);
        }
        this.writeWindowSize = initialWindowSize;
    }
    
    public void close(final ErrorCode errorCode) throws IOException {
        if (!this.closeInternal(errorCode)) {
            return;
        }
        this.connection.writeSynReset(this.id, errorCode);
    }
    
    public void closeLater(final ErrorCode errorCode) {
        if (!this.closeInternal(errorCode)) {
            return;
        }
        this.connection.writeSynResetLater(this.id, errorCode);
    }
    
    public SpdyConnection getConnection() {
        return this.connection;
    }
    
    public ErrorCode getErrorCode() {
        synchronized (this) {
            return this.errorCode;
        }
    }
    
    public InputStream getInputStream() {
        return this.in;
    }
    
    public OutputStream getOutputStream() {
        synchronized (this) {
            if (this.responseHeaders == null && !this.isLocallyInitiated()) {
                throw new IllegalStateException("reply before requesting the output stream");
            }
        }
        // monitorexit(this)
        return this.out;
    }
    
    int getPriority() {
        return this.priority;
    }
    
    public long getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }
    
    public List<String> getRequestHeaders() {
        return this.requestHeaders;
    }
    
    public List<String> getResponseHeaders() throws IOException {
        while (true) {
            // monitorenter(this)
            long readTimeoutMillis = 0L;
            long n = 0L;
            while (true) {
                Label_0105: {
                    try {
                        if (this.readTimeoutMillis != 0L) {
                            n = System.nanoTime() / 1000000L;
                            readTimeoutMillis = this.readTimeoutMillis;
                        }
                        try {
                            while (this.responseHeaders == null && this.errorCode == null) {
                                if (this.readTimeoutMillis != 0L) {
                                    break Label_0105;
                                }
                                this.wait();
                            }
                            if (this.responseHeaders != null) {
                                return this.responseHeaders;
                            }
                            throw new IOException("stream was reset: " + this.errorCode);
                        }
                        catch (InterruptedException cause) {
                            final InterruptedIOException ex = new InterruptedIOException();
                            ex.initCause(cause);
                            throw ex;
                        }
                    }
                    finally {
                    }
                    // monitorexit(this)
                }
                if (readTimeoutMillis > 0L) {
                    this.wait(readTimeoutMillis);
                    readTimeoutMillis = n + this.readTimeoutMillis - System.nanoTime() / 1000000L;
                    continue;
                }
                break;
            }
            throw new SocketTimeoutException("Read response header timeout. readTimeoutMillis: " + this.readTimeoutMillis);
        }
    }
    
    public boolean isLocallyInitiated() {
        return this.connection.client == (this.id % 2 == 1);
    }
    
    public boolean isOpen() {
        synchronized (this) {
            final ErrorCode errorCode = this.errorCode;
            boolean b = false;
            if (errorCode == null) {
                if ((this.in.finished || this.in.closed) && (this.out.finished || this.out.closed)) {
                    final List<String> responseHeaders = this.responseHeaders;
                    b = false;
                    if (responseHeaders != null) {
                        return b;
                    }
                }
                b = true;
            }
            return b;
        }
    }
    
    void receiveData(final InputStream inputStream, final int n) throws IOException {
        assert !Thread.holdsLock(this);
        this.in.receive(inputStream, n);
    }
    
    void receiveFin() {
        assert !Thread.holdsLock(this);
        synchronized (this) {
            SpdyDataInputStream.access$1(this.in, true);
            final boolean open = this.isOpen();
            this.notifyAll();
            // monitorexit(this)
            if (!open) {
                this.connection.removeStream(this.id);
            }
        }
    }
    
    void receiveHeaders(final List<String> responseHeaders, final HeadersMode headersMode) {
        assert !Thread.holdsLock(this);
        while (true) {
            boolean open = true;
        Label_0142:
            while (true) {
                synchronized (this) {
                    if (this.responseHeaders == null) {
                        ErrorCode errorCode;
                        if (headersMode.failIfHeadersAbsent()) {
                            errorCode = ErrorCode.PROTOCOL_ERROR;
                        }
                        else {
                            this.responseHeaders = responseHeaders;
                            open = this.isOpen();
                            this.notifyAll();
                            errorCode = null;
                        }
                        // monitorexit(this)
                        if (errorCode != null) {
                            this.closeLater(errorCode);
                            return;
                        }
                        break Label_0142;
                    }
                }
                if (headersMode.failIfHeadersPresent()) {
                    final ErrorCode errorCode = ErrorCode.STREAM_IN_USE;
                    continue;
                }
                final ArrayList<String> responseHeaders2 = new ArrayList<String>();
                responseHeaders2.addAll((Collection<?>)this.responseHeaders);
                responseHeaders2.addAll((Collection<?>)responseHeaders);
                this.responseHeaders = responseHeaders2;
                ErrorCode errorCode = null;
                continue;
            }
            if (!open) {
                break;
            }
            return;
        }
        this.connection.removeStream(this.id);
    }
    
    void receiveRstStream(final ErrorCode errorCode) {
        synchronized (this) {
            if (this.errorCode == null) {
                this.errorCode = errorCode;
                this.notifyAll();
            }
        }
    }
    
    void receiveSettings(final Settings settings) {
        assert Thread.holdsLock(this);
        this.setSettings(settings);
        this.notifyAll();
    }
    
    void receiveWindowUpdate(final int n) {
        synchronized (this) {
            final SpdyDataOutputStream out = this.out;
            SpdyDataOutputStream.access$5(out, out.unacknowledgedBytes - n);
            this.notifyAll();
        }
    }
    
    public void reply(final List<String> responseHeaders, final boolean b) throws IOException {
        assert !Thread.holdsLock(this);
        // monitorenter(this)
        if (responseHeaders == null) {
            try {
                throw new NullPointerException("responseHeaders == null");
            }
            finally {
            }
            // monitorexit(this)
        }
        if (this.isLocallyInitiated()) {
            throw new IllegalStateException("cannot reply to a locally initiated stream");
        }
        if (this.responseHeaders != null) {
            throw new IllegalStateException("reply already sent");
        }
        this.responseHeaders = responseHeaders;
        boolean b2 = false;
        if (!b) {
            SpdyDataOutputStream.access$1(this.out, true);
            b2 = true;
        }
        // monitorexit(this)
        this.connection.writeSynReply(this.id, b2, responseHeaders);
    }
    
    public void setReadTimeout(final long readTimeoutMillis) {
        this.readTimeoutMillis = readTimeoutMillis;
    }
    
    private final class SpdyDataInputStream extends InputStream
    {
        private final byte[] buffer;
        private boolean closed;
        private boolean finished;
        private int limit;
        private int pos;
        private int unacknowledgedBytes;
        
        private SpdyDataInputStream() {
            this.buffer = new byte[65536];
            this.pos = -1;
            this.unacknowledgedBytes = 0;
        }
        
        static /* synthetic */ void access$1(final SpdyDataInputStream spdyDataInputStream, final boolean finished) {
            spdyDataInputStream.finished = finished;
        }
        
        private void checkNotClosed() throws IOException {
            if (this.closed) {
                throw new IOException("stream closed");
            }
            if (SpdyStream.this.errorCode != null) {
                throw new IOException("stream was reset: " + SpdyStream.this.errorCode);
            }
        }
        
        private void waitUntilReadable() throws IOException {
            long n = 0L;
            long access$2 = 0L;
            if (SpdyStream.this.readTimeoutMillis != 0L) {
                n = System.nanoTime() / 1000000L;
                access$2 = SpdyStream.this.readTimeoutMillis;
            }
            while (true) {
                Label_0097: {
                    try {
                        while (this.pos == -1 && !this.finished && !this.closed) {
                            if (SpdyStream.this.errorCode != null) {
                                return;
                            }
                            if (SpdyStream.this.readTimeoutMillis != 0L) {
                                break Label_0097;
                            }
                            SpdyStream.this.wait();
                        }
                        return;
                    }
                    catch (InterruptedException ex) {
                        throw new InterruptedIOException();
                    }
                }
                if (access$2 > 0L) {
                    SpdyStream.this.wait(access$2);
                    access$2 = n + SpdyStream.this.readTimeoutMillis - System.nanoTime() / 1000000L;
                    continue;
                }
                throw new SocketTimeoutException();
            }
        }
        
        @Override
        public int available() throws IOException {
            synchronized (SpdyStream.this) {
                this.checkNotClosed();
                if (this.pos == -1) {
                    return 0;
                }
                if (this.limit > this.pos) {
                    return this.limit - this.pos;
                }
            }
            // monitorexit(spdyStream)
            return this.limit + (this.buffer.length - this.pos);
        }
        
        @Override
        public void close() throws IOException {
            synchronized (SpdyStream.this) {
                this.closed = true;
                SpdyStream.this.notifyAll();
                // monitorexit(this.this$0)
                SpdyStream.this.cancelStreamIfNecessary();
            }
        }
        
        @Override
        public int read() throws IOException {
            return Util.readSingleByte(this);
        }
        
        @Override
        public int read(final byte[] array, final int n, final int a) throws IOException {
            synchronized (SpdyStream.this) {
                Util.checkOffsetAndCount(array.length, n, a);
                this.waitUntilReadable();
                this.checkNotClosed();
                if (this.pos == -1) {
                    return -1;
                }
                final int limit = this.limit;
                final int pos = this.pos;
                int n2 = 0;
                if (limit <= pos) {
                    final int min = Math.min(a, this.buffer.length - this.pos);
                    System.arraycopy(this.buffer, this.pos, array, n, min);
                    this.pos += min;
                    n2 = 0 + min;
                    if (this.pos == this.buffer.length) {
                        this.pos = 0;
                    }
                }
                if (n2 < a) {
                    final int min2 = Math.min(this.limit - this.pos, a - n2);
                    System.arraycopy(this.buffer, this.pos, array, n + n2, min2);
                    this.pos += min2;
                    n2 += min2;
                }
                this.unacknowledgedBytes += n2;
                if (this.unacknowledgedBytes >= 32768) {
                    SpdyStream.this.connection.writeWindowUpdateLater(SpdyStream.this.id, this.unacknowledgedBytes);
                    this.unacknowledgedBytes = 0;
                }
                if (this.pos == this.limit) {
                    this.pos = -1;
                    this.limit = 0;
                }
                return n2;
            }
        }
        
        void receive(final InputStream inputStream, int a) throws IOException {
            assert !Thread.holdsLock(SpdyStream.this);
            if (a == 0) {
                return;
            }
            final boolean finished;
            final int pos;
            final int limit;
            int limit2;
            synchronized (SpdyStream.this) {
                finished = this.finished;
                pos = this.pos;
                limit = this.limit;
                limit2 = this.limit;
                int n;
                if (a > this.buffer.length - this.available()) {
                    n = 1;
                }
                else {
                    n = 0;
                }
                // monitorexit(this.this$0)
                if (n != 0) {
                    Util.skipByReading(inputStream, a);
                    SpdyStream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
            }
            if (finished) {
                Util.skipByReading(inputStream, a);
                return;
            }
            if (pos < limit2) {
                final int min = Math.min(a, this.buffer.length - limit2);
                Util.readFully(inputStream, this.buffer, limit2, min);
                limit2 += min;
                a -= min;
                if (limit2 == this.buffer.length) {
                    limit2 = 0;
                }
            }
            if (a > 0) {
                Util.readFully(inputStream, this.buffer, limit2, a);
                limit2 += a;
            }
            synchronized (SpdyStream.this) {
                this.limit = limit2;
                if (this.pos == -1) {
                    this.pos = limit;
                    SpdyStream.this.notifyAll();
                }
            }
        }
    }
    
    private final class SpdyDataOutputStream extends OutputStream
    {
        private final byte[] buffer;
        private boolean closed;
        private boolean finished;
        private int pos;
        private int unacknowledgedBytes;
        
        private SpdyDataOutputStream() {
            this.buffer = new byte[8192];
            this.pos = 0;
            this.unacknowledgedBytes = 0;
        }
        
        static /* synthetic */ void access$1(final SpdyDataOutputStream spdyDataOutputStream, final boolean finished) {
            spdyDataOutputStream.finished = finished;
        }
        
        static /* synthetic */ void access$5(final SpdyDataOutputStream spdyDataOutputStream, final int unacknowledgedBytes) {
            spdyDataOutputStream.unacknowledgedBytes = unacknowledgedBytes;
        }
        
        private void checkNotClosed() throws IOException {
            synchronized (SpdyStream.this) {
                if (this.closed) {
                    throw new IOException("stream closed");
                }
            }
            if (this.finished) {
                throw new IOException("stream finished");
            }
            if (SpdyStream.this.errorCode != null) {
                throw new IOException("stream was reset: " + SpdyStream.this.errorCode);
            }
        }
        // monitorexit(spdyStream)
        
        private void waitUntilWritable(final int n, final boolean b) throws IOException {
            while (true) {
                try {
                    if (n + this.unacknowledgedBytes < SpdyStream.this.writeWindowSize) {
                        return;
                    }
                    SpdyStream.this.wait();
                    if (!b && this.closed) {
                        throw new IOException("stream closed");
                    }
                }
                catch (InterruptedException ex) {
                    throw new InterruptedIOException();
                }
                if (this.finished) {
                    throw new IOException("stream finished");
                }
                if (SpdyStream.this.errorCode != null) {
                    throw new IOException("stream was reset: " + SpdyStream.this.errorCode);
                }
            }
        }
        
        private void writeFrame(final boolean b) throws IOException {
            assert !Thread.holdsLock(SpdyStream.this);
            final int pos = this.pos;
            synchronized (SpdyStream.this) {
                this.waitUntilWritable(pos, b);
                this.unacknowledgedBytes += pos;
                // monitorexit(this.this$0)
                SpdyStream.this.connection.writeData(SpdyStream.this.id, b, this.buffer, 0, this.pos);
                this.pos = 0;
            }
        }
        
        @Override
        public void close() throws IOException {
            assert !Thread.holdsLock(SpdyStream.this);
            synchronized (SpdyStream.this) {
                if (this.closed) {
                    return;
                }
                this.closed = true;
                // monitorexit(this.this$0)
                if (!SpdyStream.this.out.finished) {
                    this.writeFrame(true);
                }
                SpdyStream.this.connection.flush();
                SpdyStream.this.cancelStreamIfNecessary();
            }
        }
        
        @Override
        public void flush() throws IOException {
            assert !Thread.holdsLock(SpdyStream.this);
            this.checkNotClosed();
            if (this.pos > 0) {
                this.writeFrame(false);
                SpdyStream.this.connection.flush();
            }
        }
        
        @Override
        public void write(final int n) throws IOException {
            Util.writeSingleByte(this, n);
        }
        
        @Override
        public void write(final byte[] array, int n, int i) throws IOException {
            assert !Thread.holdsLock(SpdyStream.this);
            Util.checkOffsetAndCount(array.length, n, i);
            this.checkNotClosed();
            while (i > 0) {
                if (this.pos == this.buffer.length) {
                    this.writeFrame(false);
                }
                final int min = Math.min(i, this.buffer.length - this.pos);
                System.arraycopy(array, n, this.buffer, this.pos, min);
                this.pos += min;
                n += min;
                i -= min;
            }
        }
    }
}
