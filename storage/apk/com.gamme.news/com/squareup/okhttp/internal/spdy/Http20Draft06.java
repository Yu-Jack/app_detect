// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.spdy;

import java.util.List;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

final class Http20Draft06 implements Variant
{
    private static final byte[] CONNECTION_HEADER;
    static final int FLAG_END_FLOW_CONTROL = 1;
    static final int FLAG_END_HEADERS = 4;
    static final int FLAG_END_STREAM = 1;
    static final int FLAG_PONG = 1;
    static final int FLAG_PRIORITY = 8;
    static final int TYPE_CONTINUATION = 10;
    static final int TYPE_DATA = 0;
    static final int TYPE_GOAWAY = 7;
    static final int TYPE_HEADERS = 1;
    static final int TYPE_PING = 6;
    static final int TYPE_PRIORITY = 2;
    static final int TYPE_PUSH_PROMISE = 5;
    static final int TYPE_RST_STREAM = 3;
    static final int TYPE_SETTINGS = 4;
    static final int TYPE_WINDOW_UPDATE = 9;
    
    static {
        try {
            CONNECTION_HEADER = "PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n".getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException ex) {
            throw new AssertionError();
        }
    }
    
    @Override
    public FrameReader newReader(final InputStream inputStream, final boolean b) {
        return new Reader(inputStream, b);
    }
    
    @Override
    public FrameWriter newWriter(final OutputStream outputStream, final boolean b) {
        return new Writer(outputStream, b);
    }
    
    static final class Reader implements FrameReader
    {
        private final boolean client;
        private final Hpack.Reader hpackReader;
        private final DataInputStream in;
        
        Reader(final InputStream in, final boolean client) {
            this.in = new DataInputStream(in);
            this.client = client;
            this.hpackReader = new Hpack.Reader(this.in, client);
        }
        
        private static IOException ioException(final String format, final Object... args) throws IOException {
            throw new IOException(String.format(format, args));
        }
        
        private void readData(final Handler handler, final int n, final int n2, final int n3) throws IOException {
            handler.data((n & 0x1) != 0x0, n3, this.in, n2);
        }
        
        private void readGoAway(final Handler handler, final int n, final int i, final int n2) throws IOException {
            if (i < 8) {
                throw ioException("TYPE_GOAWAY length < 8: %s", i);
            }
            final int int1 = this.in.readInt();
            final int int2 = this.in.readInt();
            final int n3 = i - 8;
            final ErrorCode fromHttp2 = ErrorCode.fromHttp2(int2);
            if (fromHttp2 == null) {
                throw ioException("TYPE_RST_STREAM unexpected error code: %d", int2);
            }
            if (Util.skipByReading(this.in, n3) != n3) {
                throw new IOException("TYPE_GOAWAY opaque data was truncated");
            }
            handler.goAway(int1, fromHttp2);
        }
        
        private void readHeaders(final Handler handler, int n, int n2, final int n3) throws IOException {
            if (n3 == 0) {
                throw ioException("TYPE_HEADERS streamId == 0", new Object[0]);
            }
            boolean b = (n & 0x1) != 0x0;
            int i;
            do {
                this.hpackReader.readHeaders(n2);
                if ((n & 0x4) != 0x0) {
                    this.hpackReader.emitReferenceSet();
                    handler.headers(false, b, n3, -1, -1, this.hpackReader.getAndReset(), HeadersMode.HTTP_20_HEADERS);
                    return;
                }
                final int int1 = this.in.readInt();
                final int int2 = this.in.readInt();
                n2 = (0xFFFF0000 & int1) >> 16;
                final int n4 = (0xFF00 & int1) >> 8;
                n = (int1 & 0xFF);
                b = ((n & 0x1) != 0x0);
                i = (int2 & Integer.MAX_VALUE);
                if (n4 != 10) {
                    throw ioException("TYPE_CONTINUATION didn't have FLAG_END_HEADERS", new Object[0]);
                }
            } while (i == n3);
            throw ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
        }
        
        private void readPing(final Handler handler, final int n, final int i, final int n2) throws IOException {
            int n3 = 1;
            if (i != 8) {
                final Object[] array = new Object[n3];
                array[0] = i;
                throw ioException("TYPE_PING length != 8: %s", array);
            }
            if (n2 != 0) {
                throw ioException("TYPE_PING streamId != 0", new Object[0]);
            }
            final int int1 = this.in.readInt();
            final int int2 = this.in.readInt();
            if ((n & 0x1) == 0x0) {
                n3 = 0;
            }
            handler.ping(n3 != 0, int1, int2);
        }
        
        private void readPriority(final Handler handler, final int n, final int i, final int n2) throws IOException {
            if (i != 4) {
                throw ioException("TYPE_PRIORITY length: %d != 4", i);
            }
            if (n2 == 0) {
                throw ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
            handler.priority(n2, Integer.MAX_VALUE & this.in.readInt());
        }
        
        private void readPushPromise(final Handler handler, final int n, final int n2, final int n3) {
        }
        
        private void readRstStream(final Handler handler, final int n, final int i, final int n2) throws IOException {
            if (i != 4) {
                throw ioException("TYPE_RST_STREAM length: %d != 4", i);
            }
            if (n2 == 0) {
                throw ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            final int int1 = this.in.readInt();
            final ErrorCode fromHttp2 = ErrorCode.fromHttp2(int1);
            if (fromHttp2 == null) {
                throw ioException("TYPE_RST_STREAM unexpected error code: %d", int1);
            }
            handler.rstStream(n2, fromHttp2);
        }
        
        private void readSettings(final Handler handler, final int n, final int i, final int n2) throws IOException {
            if (i % 8 != 0) {
                throw ioException("TYPE_SETTINGS length %% 8 != 0: %s", i);
            }
            if (n2 != 0) {
                throw ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            final Settings settings = new Settings();
            for (int j = 0; j < i; j += 8) {
                settings.set(this.in.readInt() & 0xFFFFFF, 0, this.in.readInt());
            }
            handler.settings(false, settings);
        }
        
        private void readWindowUpdate(final Handler handler, final int n, final int n2, final int n3) throws IOException {
            handler.windowUpdate(n3, Integer.MAX_VALUE & this.in.readInt(), (n & 0x1) != 0x0);
        }
        
        @Override
        public void close() throws IOException {
            this.in.close();
        }
        
        @Override
        public boolean nextFrame(final Handler handler) throws IOException {
            int n = 0;
            int n3 = 0;
            int n4 = 0;
            Label_0221: {
                Label_0208: {
                    Label_0195: {
                        Label_0182: {
                            Label_0169: {
                                Label_0156: {
                                    Label_0143: {
                                        Label_0130: {
                                            try {
                                                final int int1 = this.in.readInt();
                                                final int int2 = this.in.readInt();
                                                n = (0xFFFF0000 & int1) >> 16;
                                                final int n2 = (0xFF00 & int1) >> 8;
                                                n3 = (int1 & 0xFF);
                                                n4 = (int2 & Integer.MAX_VALUE);
                                                switch (n2) {
                                                    default: {
                                                        throw new UnsupportedOperationException("TODO");
                                                    }
                                                    case 0: {
                                                        break;
                                                    }
                                                    case 1: {
                                                        break Label_0130;
                                                    }
                                                    case 2: {
                                                        break Label_0143;
                                                    }
                                                    case 3: {
                                                        break Label_0156;
                                                    }
                                                    case 4: {
                                                        break Label_0169;
                                                    }
                                                    case 5: {
                                                        break Label_0182;
                                                    }
                                                    case 6: {
                                                        break Label_0195;
                                                    }
                                                    case 7: {
                                                        break Label_0208;
                                                    }
                                                    case 9: {
                                                        break Label_0221;
                                                    }
                                                }
                                            }
                                            catch (IOException ex) {
                                                return false;
                                            }
                                            this.readData(handler, n3, n, n4);
                                            return true;
                                        }
                                        this.readHeaders(handler, n3, n, n4);
                                        return true;
                                    }
                                    this.readPriority(handler, n3, n, n4);
                                    return true;
                                }
                                this.readRstStream(handler, n3, n, n4);
                                return true;
                            }
                            this.readSettings(handler, n3, n, n4);
                            return true;
                        }
                        this.readPushPromise(handler, n3, n, n4);
                        return true;
                    }
                    this.readPing(handler, n3, n, n4);
                    return true;
                }
                this.readGoAway(handler, n3, n, n4);
                return true;
            }
            this.readWindowUpdate(handler, n3, n, n4);
            return true;
        }
        
        @Override
        public void readConnectionHeader() throws IOException {
            if (!this.client) {
                final byte[] a = new byte[Http20Draft06.CONNECTION_HEADER.length];
                this.in.readFully(a);
                if (!Arrays.equals(a, Http20Draft06.CONNECTION_HEADER)) {
                    throw ioException("Expected a connection header but was " + Arrays.toString(a), new Object[0]);
                }
            }
        }
    }
    
    static final class Writer implements FrameWriter
    {
        private final boolean client;
        private final ByteArrayOutputStream hpackBuffer;
        private final Hpack.Writer hpackWriter;
        private final DataOutputStream out;
        
        Writer(final OutputStream out, final boolean client) {
            this.out = new DataOutputStream(out);
            this.client = client;
            this.hpackBuffer = new ByteArrayOutputStream();
            this.hpackWriter = new Hpack.Writer(this.hpackBuffer);
        }
        
        private void headers(final boolean b, final int n, final int n2, final List<String> list) throws IOException {
            this.hpackBuffer.reset();
            this.hpackWriter.writeHeaders(list);
            final int size = this.hpackBuffer.size();
            int n3 = 4;
            if (b) {
                n3 |= 0x1;
            }
            if (n2 != -1) {
                n3 |= 0x8;
            }
            this.out.writeInt(0x100 | (0xFFFF & size) << 16 | (n3 & 0xFF));
            this.out.writeInt(n & Integer.MAX_VALUE);
            if (n2 != -1) {
                this.out.writeInt(n2 & Integer.MAX_VALUE);
            }
            this.hpackBuffer.writeTo(this.out);
        }
        
        @Override
        public void close() throws IOException {
            this.out.close();
        }
        
        @Override
        public void connectionHeader() throws IOException {
            synchronized (this) {
                if (this.client) {
                    this.out.write(Http20Draft06.CONNECTION_HEADER);
                }
            }
        }
        
        @Override
        public void data(final boolean b, final int n, final byte[] array) throws IOException {
            this.data(b, n, array, 0, array.length);
        }
        
        @Override
        public void data(final boolean b, final int n, final byte[] b2, final int off, final int len) throws IOException {
            // monitorenter(this)
            boolean b3 = false;
            if (b) {
                b3 = (false | true);
            }
            try {
                this.out.writeInt(0x0 | (0xFFFF & len) << 16 | ((b3 ? 1 : 0) & 0xFF));
                this.out.writeInt(Integer.MAX_VALUE & n);
                this.out.write(b2, off, len);
            }
            finally {
            }
            // monitorexit(this)
        }
        
        @Override
        public void flush() throws IOException {
            synchronized (this) {
                this.out.flush();
            }
        }
        
        @Override
        public void goAway(final int n, final ErrorCode errorCode) throws IOException {
        }
        // monitorenter(this)
        // monitorexit(this)
        
        @Override
        public void headers(final int n, final List<String> list) throws IOException {
            synchronized (this) {
                this.headers(false, n, -1, list);
            }
        }
        
        @Override
        public void noop() throws IOException {
            synchronized (this) {
                throw new UnsupportedOperationException();
            }
        }
        
        @Override
        public void ping(final boolean b, final int n, final int n2) throws IOException {
        }
        // monitorenter(this)
        // monitorexit(this)
        
        @Override
        public void rstStream(final int n, final ErrorCode errorCode) throws IOException {
            synchronized (this) {
                throw new UnsupportedOperationException("TODO");
            }
        }
        
        @Override
        public void settings(final Settings settings) throws IOException {
            while (true) {
                while (true) {
                    int n;
                    synchronized (this) {
                        this.out.writeInt(0x0 | (0x400 | (0xFFFF & 8 * settings.size()) << 16));
                        this.out.writeInt(0);
                        n = 0;
                        if (n >= 10) {
                            return;
                        }
                        if (settings.isSet(n)) {
                            this.out.writeInt(0xFFFFFF & n);
                            this.out.writeInt(settings.get(n));
                        }
                    }
                    ++n;
                    continue;
                }
            }
        }
        
        @Override
        public void synReply(final boolean b, final int n, final List<String> list) throws IOException {
            synchronized (this) {
                this.headers(b, n, -1, list);
            }
        }
        
        @Override
        public void synStream(final boolean b, final boolean b2, final int n, final int n2, final int n3, final int n4, final List<String> list) throws IOException {
            // monitorenter(this)
            if (b2) {
                try {
                    throw new UnsupportedOperationException();
                }
                finally {
                }
                // monitorexit(this)
            }
            this.headers(b, n, n3, list);
        }
        // monitorexit(this)
        
        @Override
        public void windowUpdate(final int n, final int n2) throws IOException {
        }
        // monitorenter(this)
        // monitorexit(this)
    }
}
