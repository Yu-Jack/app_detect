// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager.protobuf.nano;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class CodedOutputByteBufferNano
{
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    public static final int LITTLE_ENDIAN_64_SIZE = 8;
    private final byte[] buffer;
    private final int limit;
    private int position;
    
    private CodedOutputByteBufferNano(final byte[] buffer, final int position, final int n) {
        this.buffer = buffer;
        this.position = position;
        this.limit = position + n;
    }
    
    public static int computeBoolSize(final int n, final boolean b) {
        return computeTagSize(n) + computeBoolSizeNoTag(b);
    }
    
    public static int computeBoolSizeNoTag(final boolean b) {
        return 1;
    }
    
    public static int computeByteArraySize(final int n, final byte[] array) {
        return computeTagSize(n) + computeByteArraySizeNoTag(array);
    }
    
    public static int computeByteArraySizeNoTag(final byte[] array) {
        return computeRawVarint32Size(array.length) + array.length;
    }
    
    public static int computeBytesSize(final int n, final byte[] array) {
        return computeTagSize(n) + computeBytesSizeNoTag(array);
    }
    
    public static int computeBytesSizeNoTag(final byte[] array) {
        return computeRawVarint32Size(array.length) + array.length;
    }
    
    public static int computeDoubleSize(final int n, final double n2) {
        return computeTagSize(n) + computeDoubleSizeNoTag(n2);
    }
    
    public static int computeDoubleSizeNoTag(final double n) {
        return 8;
    }
    
    public static int computeEnumSize(final int n, final int n2) {
        return computeTagSize(n) + computeEnumSizeNoTag(n2);
    }
    
    public static int computeEnumSizeNoTag(final int n) {
        return computeRawVarint32Size(n);
    }
    
    public static int computeFixed32Size(final int n, final int n2) {
        return computeTagSize(n) + computeFixed32SizeNoTag(n2);
    }
    
    public static int computeFixed32SizeNoTag(final int n) {
        return 4;
    }
    
    public static int computeFixed64Size(final int n, final long n2) {
        return computeTagSize(n) + computeFixed64SizeNoTag(n2);
    }
    
    public static int computeFixed64SizeNoTag(final long n) {
        return 8;
    }
    
    public static int computeFloatSize(final int n, final float n2) {
        return computeTagSize(n) + computeFloatSizeNoTag(n2);
    }
    
    public static int computeFloatSizeNoTag(final float n) {
        return 4;
    }
    
    public static int computeGroupSize(final int n, final MessageNano messageNano) {
        return 2 * computeTagSize(n) + computeGroupSizeNoTag(messageNano);
    }
    
    public static int computeGroupSizeNoTag(final MessageNano messageNano) {
        return messageNano.getSerializedSize();
    }
    
    public static int computeInt32Size(final int n, final int n2) {
        return computeTagSize(n) + computeInt32SizeNoTag(n2);
    }
    
    public static int computeInt32SizeNoTag(final int n) {
        if (n >= 0) {
            return computeRawVarint32Size(n);
        }
        return 10;
    }
    
    public static int computeInt64Size(final int n, final long n2) {
        return computeTagSize(n) + computeInt64SizeNoTag(n2);
    }
    
    public static int computeInt64SizeNoTag(final long n) {
        return computeRawVarint64Size(n);
    }
    
    public static int computeMessageSize(final int n, final MessageNano messageNano) {
        return computeTagSize(n) + computeMessageSizeNoTag(messageNano);
    }
    
    public static int computeMessageSizeNoTag(final MessageNano messageNano) {
        final int serializedSize = messageNano.getSerializedSize();
        return serializedSize + computeRawVarint32Size(serializedSize);
    }
    
    public static int computeRawVarint32Size(final int n) {
        if ((n & 0xFFFFFF80) == 0x0) {
            return 1;
        }
        if ((n & 0xFFFFC000) == 0x0) {
            return 2;
        }
        if ((0xFFE00000 & n) == 0x0) {
            return 3;
        }
        if ((0xF0000000 & n) == 0x0) {
            return 4;
        }
        return 5;
    }
    
    public static int computeRawVarint64Size(final long n) {
        if ((0xFFFFFFFFFFFFFF80L & n) == 0x0L) {
            return 1;
        }
        if ((0xFFFFFFFFFFFFC000L & n) == 0x0L) {
            return 2;
        }
        if ((0xFFFFFFFFFFE00000L & n) == 0x0L) {
            return 3;
        }
        if ((0xFFFFFFFFF0000000L & n) == 0x0L) {
            return 4;
        }
        if ((0xFFFFFFF800000000L & n) == 0x0L) {
            return 5;
        }
        if ((0xFFFFFC0000000000L & n) == 0x0L) {
            return 6;
        }
        if ((0xFFFE000000000000L & n) == 0x0L) {
            return 7;
        }
        if ((0xFF00000000000000L & n) == 0x0L) {
            return 8;
        }
        if ((Long.MIN_VALUE & n) == 0x0L) {
            return 9;
        }
        return 10;
    }
    
    public static int computeSFixed32Size(final int n, final int n2) {
        return computeTagSize(n) + computeSFixed32SizeNoTag(n2);
    }
    
    public static int computeSFixed32SizeNoTag(final int n) {
        return 4;
    }
    
    public static int computeSFixed64Size(final int n, final long n2) {
        return computeTagSize(n) + computeSFixed64SizeNoTag(n2);
    }
    
    public static int computeSFixed64SizeNoTag(final long n) {
        return 8;
    }
    
    public static int computeSInt32Size(final int n, final int n2) {
        return computeTagSize(n) + computeSInt32SizeNoTag(n2);
    }
    
    public static int computeSInt32SizeNoTag(final int n) {
        return computeRawVarint32Size(encodeZigZag32(n));
    }
    
    public static int computeSInt64Size(final int n, final long n2) {
        return computeTagSize(n) + computeSInt64SizeNoTag(n2);
    }
    
    public static int computeSInt64SizeNoTag(final long n) {
        return computeRawVarint64Size(encodeZigZag64(n));
    }
    
    public static int computeStringSize(final int n, final String s) {
        return computeTagSize(n) + computeStringSizeNoTag(s);
    }
    
    public static int computeStringSizeNoTag(final String s) {
        try {
            final byte[] bytes = s.getBytes("UTF-8");
            return computeRawVarint32Size(bytes.length) + bytes.length;
        }
        catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }
    
    public static int computeTagSize(final int n) {
        return computeRawVarint32Size(WireFormatNano.makeTag(n, 0));
    }
    
    public static int computeUInt32Size(final int n, final int n2) {
        return computeTagSize(n) + computeUInt32SizeNoTag(n2);
    }
    
    public static int computeUInt32SizeNoTag(final int n) {
        return computeRawVarint32Size(n);
    }
    
    public static int computeUInt64Size(final int n, final long n2) {
        return computeTagSize(n) + computeUInt64SizeNoTag(n2);
    }
    
    public static int computeUInt64SizeNoTag(final long n) {
        return computeRawVarint64Size(n);
    }
    
    public static int encodeZigZag32(final int n) {
        return n << 1 ^ n >> 31;
    }
    
    public static long encodeZigZag64(final long n) {
        return n << 1 ^ n >> 63;
    }
    
    public static CodedOutputByteBufferNano newInstance(final byte[] array) {
        return newInstance(array, 0, array.length);
    }
    
    public static CodedOutputByteBufferNano newInstance(final byte[] array, final int n, final int n2) {
        return new CodedOutputByteBufferNano(array, n, n2);
    }
    
    public void checkNoSpaceLeft() {
        if (this.spaceLeft() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }
    
    public int spaceLeft() {
        return this.limit - this.position;
    }
    
    public void writeBool(final int n, final boolean b) throws IOException {
        this.writeTag(n, 0);
        this.writeBoolNoTag(b);
    }
    
    public void writeBoolNoTag(final boolean b) throws IOException {
        int n;
        if (b) {
            n = 1;
        }
        else {
            n = 0;
        }
        this.writeRawByte(n);
    }
    
    public void writeByteArray(final int n, final byte[] array) throws IOException {
        this.writeTag(n, 2);
        this.writeByteArrayNoTag(array);
    }
    
    public void writeByteArrayNoTag(final byte[] array) throws IOException {
        this.writeRawVarint32(array.length);
        this.writeRawBytes(array);
    }
    
    public void writeBytes(final int n, final byte[] array) throws IOException {
        this.writeTag(n, 2);
        this.writeBytesNoTag(array);
    }
    
    public void writeBytesNoTag(final byte[] array) throws IOException {
        this.writeRawVarint32(array.length);
        this.writeRawBytes(array);
    }
    
    public void writeDouble(final int n, final double n2) throws IOException {
        this.writeTag(n, 1);
        this.writeDoubleNoTag(n2);
    }
    
    public void writeDoubleNoTag(final double value) throws IOException {
        this.writeRawLittleEndian64(Double.doubleToLongBits(value));
    }
    
    public void writeEnum(final int n, final int n2) throws IOException {
        this.writeTag(n, 0);
        this.writeEnumNoTag(n2);
    }
    
    public void writeEnumNoTag(final int n) throws IOException {
        this.writeRawVarint32(n);
    }
    
    public void writeFixed32(final int n, final int n2) throws IOException {
        this.writeTag(n, 5);
        this.writeFixed32NoTag(n2);
    }
    
    public void writeFixed32NoTag(final int n) throws IOException {
        this.writeRawLittleEndian32(n);
    }
    
    public void writeFixed64(final int n, final long n2) throws IOException {
        this.writeTag(n, 1);
        this.writeFixed64NoTag(n2);
    }
    
    public void writeFixed64NoTag(final long n) throws IOException {
        this.writeRawLittleEndian64(n);
    }
    
    public void writeFloat(final int n, final float n2) throws IOException {
        this.writeTag(n, 5);
        this.writeFloatNoTag(n2);
    }
    
    public void writeFloatNoTag(final float value) throws IOException {
        this.writeRawLittleEndian32(Float.floatToIntBits(value));
    }
    
    public void writeGroup(final int n, final MessageNano messageNano) throws IOException {
        this.writeTag(n, 3);
        this.writeGroupNoTag(messageNano);
        this.writeTag(n, 4);
    }
    
    public void writeGroupNoTag(final MessageNano messageNano) throws IOException {
        messageNano.writeTo(this);
    }
    
    public void writeInt32(final int n, final int n2) throws IOException {
        this.writeTag(n, 0);
        this.writeInt32NoTag(n2);
    }
    
    public void writeInt32NoTag(final int n) throws IOException {
        if (n >= 0) {
            this.writeRawVarint32(n);
            return;
        }
        this.writeRawVarint64(n);
    }
    
    public void writeInt64(final int n, final long n2) throws IOException {
        this.writeTag(n, 0);
        this.writeInt64NoTag(n2);
    }
    
    public void writeInt64NoTag(final long n) throws IOException {
        this.writeRawVarint64(n);
    }
    
    public void writeMessage(final int n, final MessageNano messageNano) throws IOException {
        this.writeTag(n, 2);
        this.writeMessageNoTag(messageNano);
    }
    
    public void writeMessageNoTag(final MessageNano messageNano) throws IOException {
        this.writeRawVarint32(messageNano.getCachedSize());
        messageNano.writeTo(this);
    }
    
    public void writeRawByte(final byte b) throws IOException {
        if (this.position == this.limit) {
            throw new OutOfSpaceException(this.position, this.limit);
        }
        this.buffer[this.position++] = b;
    }
    
    public void writeRawByte(final int n) throws IOException {
        this.writeRawByte((byte)n);
    }
    
    public void writeRawBytes(final byte[] array) throws IOException {
        this.writeRawBytes(array, 0, array.length);
    }
    
    public void writeRawBytes(final byte[] array, final int n, final int n2) throws IOException {
        if (this.limit - this.position >= n2) {
            System.arraycopy(array, n, this.buffer, this.position, n2);
            this.position += n2;
            return;
        }
        throw new OutOfSpaceException(this.position, this.limit);
    }
    
    public void writeRawLittleEndian32(final int n) throws IOException {
        this.writeRawByte(n & 0xFF);
        this.writeRawByte(0xFF & n >> 8);
        this.writeRawByte(0xFF & n >> 16);
        this.writeRawByte(0xFF & n >> 24);
    }
    
    public void writeRawLittleEndian64(final long n) throws IOException {
        this.writeRawByte(0xFF & (int)n);
        this.writeRawByte(0xFF & (int)(n >> 8));
        this.writeRawByte(0xFF & (int)(n >> 16));
        this.writeRawByte(0xFF & (int)(n >> 24));
        this.writeRawByte(0xFF & (int)(n >> 32));
        this.writeRawByte(0xFF & (int)(n >> 40));
        this.writeRawByte(0xFF & (int)(n >> 48));
        this.writeRawByte(0xFF & (int)(n >> 56));
    }
    
    public void writeRawVarint32(int n) throws IOException {
        while ((n & 0xFFFFFF80) != 0x0) {
            this.writeRawByte(0x80 | (n & 0x7F));
            n >>>= 7;
        }
        this.writeRawByte(n);
    }
    
    public void writeRawVarint64(long n) throws IOException {
        while ((0xFFFFFFFFFFFFFF80L & n) != 0x0L) {
            this.writeRawByte(0x80 | (0x7F & (int)n));
            n >>>= 7;
        }
        this.writeRawByte((int)n);
    }
    
    public void writeSFixed32(final int n, final int n2) throws IOException {
        this.writeTag(n, 5);
        this.writeSFixed32NoTag(n2);
    }
    
    public void writeSFixed32NoTag(final int n) throws IOException {
        this.writeRawLittleEndian32(n);
    }
    
    public void writeSFixed64(final int n, final long n2) throws IOException {
        this.writeTag(n, 1);
        this.writeSFixed64NoTag(n2);
    }
    
    public void writeSFixed64NoTag(final long n) throws IOException {
        this.writeRawLittleEndian64(n);
    }
    
    public void writeSInt32(final int n, final int n2) throws IOException {
        this.writeTag(n, 0);
        this.writeSInt32NoTag(n2);
    }
    
    public void writeSInt32NoTag(final int n) throws IOException {
        this.writeRawVarint32(encodeZigZag32(n));
    }
    
    public void writeSInt64(final int n, final long n2) throws IOException {
        this.writeTag(n, 0);
        this.writeSInt64NoTag(n2);
    }
    
    public void writeSInt64NoTag(final long n) throws IOException {
        this.writeRawVarint64(encodeZigZag64(n));
    }
    
    public void writeString(final int n, final String s) throws IOException {
        this.writeTag(n, 2);
        this.writeStringNoTag(s);
    }
    
    public void writeStringNoTag(final String s) throws IOException {
        final byte[] bytes = s.getBytes("UTF-8");
        this.writeRawVarint32(bytes.length);
        this.writeRawBytes(bytes);
    }
    
    public void writeTag(final int n, final int n2) throws IOException {
        this.writeRawVarint32(WireFormatNano.makeTag(n, n2));
    }
    
    public void writeUInt32(final int n, final int n2) throws IOException {
        this.writeTag(n, 0);
        this.writeUInt32NoTag(n2);
    }
    
    public void writeUInt32NoTag(final int n) throws IOException {
        this.writeRawVarint32(n);
    }
    
    public void writeUInt64(final int n, final long n2) throws IOException {
        this.writeTag(n, 0);
        this.writeUInt64NoTag(n2);
    }
    
    public void writeUInt64NoTag(final long n) throws IOException {
        this.writeRawVarint64(n);
    }
    
    public static class OutOfSpaceException extends IOException
    {
        private static final long serialVersionUID = -6947486886997889499L;
        
        OutOfSpaceException(final int i, final int j) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + j + ").");
        }
    }
}
