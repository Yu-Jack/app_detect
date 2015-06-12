// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.spdy;

import java.io.OutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.BitSet;
import java.io.DataInputStream;
import java.util.Arrays;
import java.util.List;

final class Hpack
{
    static final List<HeaderEntry> INITIAL_CLIENT_TO_SERVER_HEADER_TABLE;
    static final int INITIAL_CLIENT_TO_SERVER_HEADER_TABLE_LENGTH = 1262;
    static final List<HeaderEntry> INITIAL_SERVER_TO_CLIENT_HEADER_TABLE;
    static final int INITIAL_SERVER_TO_CLIENT_HEADER_TABLE_LENGTH = 1304;
    static final int PREFIX_5_BITS = 31;
    static final int PREFIX_6_BITS = 63;
    static final int PREFIX_7_BITS = 127;
    static final int PREFIX_8_BITS = 255;
    
    static {
        INITIAL_CLIENT_TO_SERVER_HEADER_TABLE = Arrays.asList(new HeaderEntry(":scheme", "http"), new HeaderEntry(":scheme", "https"), new HeaderEntry(":host", ""), new HeaderEntry(":path", "/"), new HeaderEntry(":method", "GET"), new HeaderEntry("accept", ""), new HeaderEntry("accept-charset", ""), new HeaderEntry("accept-encoding", ""), new HeaderEntry("accept-language", ""), new HeaderEntry("cookie", ""), new HeaderEntry("if-modified-since", ""), new HeaderEntry("user-agent", ""), new HeaderEntry("referer", ""), new HeaderEntry("authorization", ""), new HeaderEntry("allow", ""), new HeaderEntry("cache-control", ""), new HeaderEntry("connection", ""), new HeaderEntry("content-length", ""), new HeaderEntry("content-type", ""), new HeaderEntry("date", ""), new HeaderEntry("expect", ""), new HeaderEntry("from", ""), new HeaderEntry("if-match", ""), new HeaderEntry("if-none-match", ""), new HeaderEntry("if-range", ""), new HeaderEntry("if-unmodified-since", ""), new HeaderEntry("max-forwards", ""), new HeaderEntry("proxy-authorization", ""), new HeaderEntry("range", ""), new HeaderEntry("via", ""));
        INITIAL_SERVER_TO_CLIENT_HEADER_TABLE = Arrays.asList(new HeaderEntry(":status", "200"), new HeaderEntry("age", ""), new HeaderEntry("cache-control", ""), new HeaderEntry("content-length", ""), new HeaderEntry("content-type", ""), new HeaderEntry("date", ""), new HeaderEntry("etag", ""), new HeaderEntry("expires", ""), new HeaderEntry("last-modified", ""), new HeaderEntry("server", ""), new HeaderEntry("set-cookie", ""), new HeaderEntry("vary", ""), new HeaderEntry("via", ""), new HeaderEntry("access-control-allow-origin", ""), new HeaderEntry("accept-ranges", ""), new HeaderEntry("allow", ""), new HeaderEntry("connection", ""), new HeaderEntry("content-disposition", ""), new HeaderEntry("content-encoding", ""), new HeaderEntry("content-language", ""), new HeaderEntry("content-location", ""), new HeaderEntry("content-range", ""), new HeaderEntry("link", ""), new HeaderEntry("location", ""), new HeaderEntry("proxy-authenticate", ""), new HeaderEntry("refresh", ""), new HeaderEntry("retry-after", ""), new HeaderEntry("strict-transport-security", ""), new HeaderEntry("transfer-encoding", ""), new HeaderEntry("www-authenticate", ""));
    }
    
    static class HeaderEntry
    {
        private final String name;
        private final String value;
        
        HeaderEntry(final String name, final String value) {
            this.name = name;
            this.value = value;
        }
        
        int length() {
            return 32 + this.name.length() + this.value.length();
        }
    }
    
    static class Reader
    {
        private long bufferSize;
        private long bytesLeft;
        private final List<String> emittedHeaders;
        private final List<HeaderEntry> headerTable;
        private final DataInputStream in;
        private final long maxBufferSize;
        private final BitSet referenceSet;
        
        Reader(final DataInputStream in, final boolean b) {
            this.maxBufferSize = 4096L;
            this.referenceSet = new BitSet();
            this.emittedHeaders = new ArrayList<String>();
            this.bufferSize = 0L;
            this.bytesLeft = 0L;
            this.in = in;
            if (b) {
                this.headerTable = new ArrayList<HeaderEntry>((Collection<? extends HeaderEntry>)Hpack.INITIAL_SERVER_TO_CLIENT_HEADER_TABLE);
                this.bufferSize = 1304L;
                return;
            }
            this.headerTable = new ArrayList<HeaderEntry>((Collection<? extends HeaderEntry>)Hpack.INITIAL_CLIENT_TO_SERVER_HEADER_TABLE);
            this.bufferSize = 1262L;
        }
        
        private String getName(final int n) {
            return this.headerTable.get(n).name;
        }
        
        private String getValue(final int n) {
            return this.headerTable.get(n).value;
        }
        
        private void insertIntoHeaderTable(int bitIndex, final HeaderEntry headerEntry) {
            int length = headerEntry.length();
            if (bitIndex != this.headerTable.size()) {
                length -= this.headerTable.get(bitIndex).length();
            }
            if (length > 4096L) {
                this.headerTable.clear();
                this.bufferSize = 0L;
                this.emittedHeaders.add(headerEntry.name);
                this.emittedHeaders.add(headerEntry.value);
                return;
            }
            while (this.bufferSize + length > 4096L) {
                this.remove(0);
                --bitIndex;
            }
            if (bitIndex < 0) {
                bitIndex = 0;
                this.headerTable.add(0, headerEntry);
            }
            else if (bitIndex == this.headerTable.size()) {
                this.headerTable.add(bitIndex, headerEntry);
            }
            else {
                this.headerTable.set(bitIndex, headerEntry);
            }
            this.bufferSize += length;
            this.referenceSet.set(bitIndex);
        }
        
        private int readByte() throws IOException {
            --this.bytesLeft;
            return 0xFF & this.in.readByte();
        }
        
        private void readIndexedHeader(final int bitIndex) {
            if (this.referenceSet.get(bitIndex)) {
                this.referenceSet.clear(bitIndex);
                return;
            }
            this.referenceSet.set(bitIndex);
        }
        
        private void readLiteralHeaderWithIncrementalIndexingIndexedName(final int n) throws IOException {
            this.insertIntoHeaderTable(this.headerTable.size(), new HeaderEntry(this.getName(n), this.readString()));
        }
        
        private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            this.insertIntoHeaderTable(this.headerTable.size(), new HeaderEntry(this.readString(), this.readString()));
        }
        
        private void readLiteralHeaderWithSubstitutionIndexingIndexedName(final int n) throws IOException {
            this.insertIntoHeaderTable(this.readInt(this.readByte(), 255), new HeaderEntry(this.getName(n), this.readString()));
        }
        
        private void readLiteralHeaderWithSubstitutionIndexingNewName() throws IOException {
            this.insertIntoHeaderTable(this.readInt(this.readByte(), 255), new HeaderEntry(this.readString(), this.readString()));
        }
        
        private void readLiteralHeaderWithoutIndexingIndexedName(final int n) throws IOException {
            final String name = this.getName(n);
            final String string = this.readString();
            this.emittedHeaders.add(name);
            this.emittedHeaders.add(string);
        }
        
        private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            final String string = this.readString();
            final String string2 = this.readString();
            this.emittedHeaders.add(string);
            this.emittedHeaders.add(string2);
        }
        
        private void remove(final int n) {
            this.bufferSize -= this.headerTable.remove(n).length();
        }
        
        public void emitReferenceSet() {
            for (int i = this.referenceSet.nextSetBit(0); i != -1; i = this.referenceSet.nextSetBit(i + 1)) {
                this.emittedHeaders.add(this.getName(i));
                this.emittedHeaders.add(this.getValue(i));
            }
        }
        
        public List<String> getAndReset() {
            final ArrayList<String> list = new ArrayList<String>(this.emittedHeaders);
            this.emittedHeaders.clear();
            return list;
        }
        
        public void readHeaders(final int n) throws IOException {
            this.bytesLeft += n;
            while (this.bytesLeft > 0L) {
                final int byte1 = this.readByte();
                if ((byte1 & 0x80) != 0x0) {
                    this.readIndexedHeader(this.readInt(byte1, 127));
                }
                else if (byte1 == 96) {
                    this.readLiteralHeaderWithoutIndexingNewName();
                }
                else if ((byte1 & 0xE0) == 0x60) {
                    this.readLiteralHeaderWithoutIndexingIndexedName(-1 + this.readInt(byte1, 31));
                }
                else if (byte1 == 64) {
                    this.readLiteralHeaderWithIncrementalIndexingNewName();
                }
                else if ((byte1 & 0xE0) == 0x40) {
                    this.readLiteralHeaderWithIncrementalIndexingIndexedName(-1 + this.readInt(byte1, 31));
                }
                else if (byte1 == 0) {
                    this.readLiteralHeaderWithSubstitutionIndexingNewName();
                }
                else {
                    if ((byte1 & 0xC0) != 0x0) {
                        throw new AssertionError();
                    }
                    this.readLiteralHeaderWithSubstitutionIndexingIndexedName(-1 + this.readInt(byte1, 63));
                }
            }
        }
        
        int readInt(final int n, final int n2) throws IOException {
            final int n3 = n & n2;
            if (n3 < n2) {
                return n3;
            }
            int n4 = n2;
            int n5 = 0;
            int byte1;
            while (true) {
                byte1 = this.readByte();
                if ((byte1 & 0x80) == 0x0) {
                    break;
                }
                n4 += (byte1 & 0x7F) << n5;
                n5 += 7;
            }
            return n4 + (byte1 << n5);
        }
        
        public String readString() throws IOException {
            final int int1 = this.readInt(this.readByte(), 255);
            final byte[] array = new byte[int1];
            this.bytesLeft -= int1;
            this.in.readFully(array);
            return new String(array, "UTF-8");
        }
    }
    
    static class Writer
    {
        private final OutputStream out;
        
        Writer(final OutputStream out) {
            this.out = out;
        }
        
        public void writeHeaders(final List<String> list) throws IOException {
            for (int i = 0; i < list.size(); i += 2) {
                this.out.write(96);
                this.writeString(list.get(i));
                this.writeString(list.get(i + 1));
            }
        }
        
        public void writeInt(final int n, final int n2, final int n3) throws IOException {
            if (n < n2) {
                this.out.write(n3 | n);
                return;
            }
            this.out.write(n3 | n2);
            int i;
            for (i = n - n2; i >= 128; i >>>= 7) {
                this.out.write((i & 0x7F) | 0x80);
            }
            this.out.write(i);
        }
        
        public void writeString(final String s) throws IOException {
            final byte[] bytes = s.getBytes("UTF-8");
            this.writeInt(bytes.length, 255, 0);
            this.out.write(bytes);
        }
    }
}
