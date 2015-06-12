// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.spdy;

import java.util.Iterator;
import java.util.List;
import com.squareup.okhttp.internal.Platform;
import java.util.zip.Deflater;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;
import java.net.ProtocolException;
import java.io.Closeable;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import com.squareup.okhttp.internal.Util;

final class Spdy3 implements Variant
{
    static final byte[] DICTIONARY;
    static final int FLAG_FIN = 1;
    static final int FLAG_UNIDIRECTIONAL = 2;
    static final int TYPE_CREDENTIAL = 16;
    static final int TYPE_DATA = 0;
    static final int TYPE_GOAWAY = 7;
    static final int TYPE_HEADERS = 8;
    static final int TYPE_NOOP = 5;
    static final int TYPE_PING = 6;
    static final int TYPE_RST_STREAM = 3;
    static final int TYPE_SETTINGS = 4;
    static final int TYPE_SYN_REPLY = 2;
    static final int TYPE_SYN_STREAM = 1;
    static final int TYPE_WINDOW_UPDATE = 9;
    static final int VERSION = 3;
    
    static {
        try {
            DICTIONARY = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(Util.UTF_8.name());
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
        private final DataInputStream in;
        private final NameValueBlockReader nameValueBlockReader;
        
        Reader(final InputStream in, final boolean client) {
            this.in = new DataInputStream(in);
            this.nameValueBlockReader = new NameValueBlockReader(in);
            this.client = client;
        }
        
        private static IOException ioException(final String format, final Object... args) throws IOException {
            throw new IOException(String.format(format, args));
        }
        
        private void readGoAway(final Handler handler, final int n, final int i) throws IOException {
            if (i != 8) {
                throw ioException("TYPE_GOAWAY length: %d != 8", i);
            }
            final int n2 = Integer.MAX_VALUE & this.in.readInt();
            final int int1 = this.in.readInt();
            final ErrorCode fromSpdyGoAway = ErrorCode.fromSpdyGoAway(int1);
            if (fromSpdyGoAway == null) {
                throw ioException("TYPE_GOAWAY unexpected error code: %d", int1);
            }
            handler.goAway(n2, fromSpdyGoAway);
        }
        
        private void readHeaders(final Handler handler, final int n, final int n2) throws IOException {
            handler.headers(false, false, Integer.MAX_VALUE & this.in.readInt(), -1, -1, this.nameValueBlockReader.readNameValueBlock(n2 - 4), HeadersMode.SPDY_HEADERS);
        }
        
        private void readPing(final Handler handler, final int n, final int i) throws IOException {
            int n2 = 1;
            if (i != 4) {
                final Object[] array = new Object[n2];
                array[0] = i;
                throw ioException("TYPE_PING length: %d != 4", array);
            }
            final int int1 = this.in.readInt();
            if (this.client != (int1 % 2 == n2 && n2)) {
                n2 = 0;
            }
            handler.ping(n2 != 0, int1, 0);
        }
        
        private void readRstStream(final Handler handler, final int n, final int i) throws IOException {
            if (i != 8) {
                throw ioException("TYPE_RST_STREAM length: %d != 8", i);
            }
            final int n2 = Integer.MAX_VALUE & this.in.readInt();
            final int int1 = this.in.readInt();
            final ErrorCode fromSpdy3Rst = ErrorCode.fromSpdy3Rst(int1);
            if (fromSpdy3Rst == null) {
                throw ioException("TYPE_RST_STREAM unexpected error code: %d", int1);
            }
            handler.rstStream(n2, fromSpdy3Rst);
        }
        
        private void readSettings(final Handler handler, final int n, final int i) throws IOException {
            int n2 = 1;
            final int int1 = this.in.readInt();
            if (i != 4 + int1 * 8) {
                final Object[] array = { i, null };
                array[n2] = int1;
                throw ioException("TYPE_SETTINGS length: %d != 4 + 8 * %d", array);
            }
            final Settings settings = new Settings();
            for (int j = 0; j < int1; ++j) {
                final int int2 = this.in.readInt();
                settings.set(int2 & 0xFFFFFF, (0xFF000000 & int2) >>> 24, this.in.readInt());
            }
            if ((n & 0x1) == 0x0) {
                n2 = 0;
            }
            handler.settings(n2 != 0, settings);
        }
        
        private void readSynReply(final Handler handler, final int n, final int n2) throws IOException {
            handler.headers(false, (n & 0x1) != 0x0, Integer.MAX_VALUE & this.in.readInt(), -1, -1, this.nameValueBlockReader.readNameValueBlock(n2 - 4), HeadersMode.SPDY_REPLY);
        }
        
        private void readSynStream(final Handler handler, final int n, final int n2) throws IOException {
            handler.headers((n & 0x2) != 0x0, (n & 0x1) != 0x0, this.in.readInt() & Integer.MAX_VALUE, this.in.readInt() & Integer.MAX_VALUE, (0xE000 & this.in.readShort()) >>> 13, this.nameValueBlockReader.readNameValueBlock(n2 - 10), HeadersMode.SPDY_SYN_STREAM);
        }
        
        private void readWindowUpdate(final Handler handler, final int n, final int i) throws IOException {
            if (i != 8) {
                throw ioException("TYPE_WINDOW_UPDATE length: %d != 8", i);
            }
            handler.windowUpdate(this.in.readInt() & Integer.MAX_VALUE, this.in.readInt() & Integer.MAX_VALUE, false);
        }
        
        @Override
        public void close() throws IOException {
            Util.closeAll(this.in, this.nameValueBlockReader);
        }
        
        @Override
        public boolean nextFrame(final Handler handler) throws IOException {
            while (true) {
                int int1 = 0;
                int n2 = 0;
                int i = 0;
                Label_0339: {
                    int n3 = 0;
                Label_0104:
                    while (true) {
                        try {
                            int1 = this.in.readInt();
                            final int int2 = this.in.readInt();
                            if ((Integer.MIN_VALUE & int1) != 0x0) {
                                final int n = 1;
                                n2 = (0xFF000000 & int2) >>> 24;
                                i = (int2 & 0xFFFFFF);
                                if (n == 0) {
                                    break Label_0339;
                                }
                                final int j = (0x7FFF0000 & int1) >>> 16;
                                n3 = (int1 & 0xFFFF);
                                if (j != 3) {
                                    throw new ProtocolException("version != 3: " + j);
                                }
                                break Label_0104;
                            }
                        }
                        catch (IOException ex) {
                            return false;
                        }
                        final int n = 0;
                        continue;
                    }
                    switch (n3) {
                        default: {
                            throw new IOException("Unexpected frame");
                        }
                        case 1: {
                            this.readSynStream(handler, n2, i);
                            return true;
                        }
                        case 2: {
                            this.readSynReply(handler, n2, i);
                            return true;
                        }
                        case 3: {
                            this.readRstStream(handler, n2, i);
                            return true;
                        }
                        case 4: {
                            this.readSettings(handler, n2, i);
                            return true;
                        }
                        case 5: {
                            if (i != 0) {
                                throw ioException("TYPE_NOOP length: %d != 0", i);
                            }
                            handler.noop();
                            return true;
                        }
                        case 6: {
                            this.readPing(handler, n2, i);
                            return true;
                        }
                        case 7: {
                            this.readGoAway(handler, n2, i);
                            return true;
                        }
                        case 8: {
                            this.readHeaders(handler, n2, i);
                            return true;
                        }
                        case 9: {
                            this.readWindowUpdate(handler, n2, i);
                            return true;
                        }
                        case 16: {
                            Util.skipByReading(this.in, i);
                            throw new UnsupportedOperationException("TODO");
                        }
                    }
                }
                final int n4 = int1 & Integer.MAX_VALUE;
                final int n5 = n2 & 0x1;
                boolean b = false;
                if (n5 != 0) {
                    b = true;
                }
                handler.data(b, n4, this.in, i);
                return true;
            }
        }
        
        @Override
        public void readConnectionHeader() {
        }
    }
    
    static final class Writer implements FrameWriter
    {
        private final boolean client;
        private final ByteArrayOutputStream nameValueBlockBuffer;
        private final DataOutputStream nameValueBlockOut;
        private final DataOutputStream out;
        
        Writer(final OutputStream out, final boolean client) {
            this.out = new DataOutputStream(out);
            this.client = client;
            final Deflater deflater = new Deflater();
            deflater.setDictionary(Spdy3.DICTIONARY);
            this.nameValueBlockBuffer = new ByteArrayOutputStream();
            this.nameValueBlockOut = new DataOutputStream(Platform.get().newDeflaterOutputStream(this.nameValueBlockBuffer, deflater, true));
        }
        
        private void writeNameValueBlockToBuffer(final List<String> list) throws IOException {
            this.nameValueBlockBuffer.reset();
            this.nameValueBlockOut.writeInt(list.size() / 2);
            for (final String s : list) {
                this.nameValueBlockOut.writeInt(s.length());
                this.nameValueBlockOut.write(s.getBytes("UTF-8"));
            }
            this.nameValueBlockOut.flush();
        }
        
        @Override
        public void close() throws IOException {
            Util.closeAll(this.out, this.nameValueBlockOut);
        }
        
        @Override
        public void connectionHeader() {
        }
        // monitorenter(this)
        // monitorexit(this)
        
        @Override
        public void data(final boolean b, final int n, final byte[] array) throws IOException {
            synchronized (this) {
                this.data(b, n, array, 0, array.length);
            }
        }
        
        @Override
        public void data(final boolean b, final int n, final byte[] b2, final int off, final int len) throws IOException {
            // monitorenter(this)
            Label_0057: {
                if (!b) {
                    break Label_0057;
                }
                int n2 = 1;
                try {
                    while (true) {
                        this.out.writeInt(Integer.MAX_VALUE & n);
                        this.out.writeInt((n2 & 0xFF) << 24 | (0xFFFFFF & len));
                        this.out.write(b2, off, len);
                        return;
                        n2 = 0;
                        continue;
                    }
                }
                finally {
                }
                // monitorexit(this)
            }
        }
        
        @Override
        public void flush() throws IOException {
            synchronized (this) {
                this.out.flush();
            }
        }
        
        @Override
        public void goAway(final int v, final ErrorCode errorCode) throws IOException {
            synchronized (this) {
                if (errorCode.spdyGoAwayCode == -1) {
                    throw new IllegalArgumentException();
                }
            }
            this.out.writeInt(-2147287033);
            this.out.writeInt(8);
            this.out.writeInt(v);
            this.out.writeInt(errorCode.spdyGoAwayCode);
            this.out.flush();
        }
        // monitorexit(this)
        
        @Override
        public void headers(final int n, final List<String> list) throws IOException {
            synchronized (this) {
                this.writeNameValueBlockToBuffer(list);
                final int n2 = 4 + this.nameValueBlockBuffer.size();
                this.out.writeInt(-2147287032);
                this.out.writeInt(0x0 | (0xFFFFFF & n2));
                this.out.writeInt(Integer.MAX_VALUE & n);
                this.nameValueBlockBuffer.writeTo(this.out);
                this.out.flush();
            }
        }
        
        @Override
        public void noop() throws IOException {
            synchronized (this) {
                this.out.writeInt(-2147287035);
                this.out.writeInt(0);
                this.out.flush();
            }
        }
        
        @Override
        public void ping(final boolean b, final int v, final int n) throws IOException {
            while (true) {
                int n2 = true ? 1 : 0;
                while (true) {
                    synchronized (this) {
                        final boolean client = this.client;
                        if (v % 2 == n2) {
                            if ((b ? 1 : 0) != ((client ? 1 : 0) ^ n2)) {
                                throw new IllegalArgumentException("payload != reply");
                            }
                            break;
                        }
                    }
                    n2 = (false ? 1 : 0);
                    continue;
                }
            }
            this.out.writeInt(-2147287034);
            this.out.writeInt(4);
            this.out.writeInt(v);
            this.out.flush();
        }
        // monitorexit(this)
        
        @Override
        public void rstStream(final int n, final ErrorCode errorCode) throws IOException {
            synchronized (this) {
                if (errorCode.spdyRstCode == -1) {
                    throw new IllegalArgumentException();
                }
            }
            this.out.writeInt(-2147287037);
            this.out.writeInt(8);
            this.out.writeInt(Integer.MAX_VALUE & n);
            this.out.writeInt(errorCode.spdyRstCode);
            this.out.flush();
        }
        // monitorexit(this)
        
        @Override
        public void settings(final Settings settings) throws IOException {
            while (true) {
                while (true) {
                    int n2;
                    synchronized (this) {
                        final int size = settings.size();
                        final int n = 4 + size * 8;
                        this.out.writeInt(-2147287036);
                        this.out.writeInt(0x0 | (n & 0xFFFFFF));
                        this.out.writeInt(size);
                        n2 = 0;
                        if (n2 > 10) {
                            this.out.flush();
                            return;
                        }
                        if (settings.isSet(n2)) {
                            this.out.writeInt((settings.flags(n2) & 0xFF) << 24 | (n2 & 0xFFFFFF));
                            this.out.writeInt(settings.get(n2));
                        }
                    }
                    ++n2;
                    continue;
                }
            }
        }
        
        @Override
        public void synReply(final boolean b, final int n, final List<String> list) throws IOException {
            synchronized (this) {
                this.writeNameValueBlockToBuffer(list);
                boolean b2;
                if (b) {
                    b2 = true;
                }
                else {
                    b2 = false;
                }
                final int n2 = 4 + this.nameValueBlockBuffer.size();
                this.out.writeInt(-2147287038);
                this.out.writeInt(((b2 ? 1 : 0) & 0xFF) << 24 | (0xFFFFFF & n2));
                this.out.writeInt(Integer.MAX_VALUE & n);
                this.nameValueBlockBuffer.writeTo(this.out);
                this.out.flush();
            }
        }
        
        @Override
        public void synStream(final boolean b, final boolean b2, final int n, final int n2, final int n3, final int n4, final List<String> list) throws IOException {
            while (true) {
                while (true) {
                    Label_0149: {
                        synchronized (this) {
                            this.writeNameValueBlockToBuffer(list);
                            final int n5 = 10 + this.nameValueBlockBuffer.size();
                            if (b) {
                                final boolean b3 = true;
                                break Label_0149;
                            }
                            final boolean b3 = false;
                            break Label_0149;
                            final int n6;
                            final boolean b4 = ((b3 ? 1 : 0) | n6) != 0x0;
                            this.out.writeInt(-2147287039);
                            this.out.writeInt(((b4 ? 1 : 0) & 0xFF) << 24 | (0xFFFFFF & n5));
                            this.out.writeInt(n & Integer.MAX_VALUE);
                            this.out.writeInt(n2 & Integer.MAX_VALUE);
                            this.out.writeShort(0x0 | (n3 & 0x7) << 13 | (n4 & 0xFF));
                            this.nameValueBlockBuffer.writeTo(this.out);
                            this.out.flush();
                            return;
                        }
                    }
                    int n6 = false ? 1 : 0;
                    if (b2) {
                        n6 = 2;
                        continue;
                    }
                    continue;
                }
            }
        }
        
        @Override
        public void windowUpdate(final int v, final int v2) throws IOException {
            synchronized (this) {
                this.out.writeInt(-2147287031);
                this.out.writeInt(8);
                this.out.writeInt(v);
                this.out.writeInt(v2);
                this.out.flush();
            }
        }
    }
}
