// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager.protobuf.nano;

import java.util.Arrays;
import java.io.IOException;

public abstract class MessageNano
{
    protected int cachedSize;
    
    public MessageNano() {
        this.cachedSize = -1;
    }
    
    public static final <T extends MessageNano> T mergeFrom(final T t, final byte[] array) throws InvalidProtocolBufferNanoException {
        return mergeFrom(t, array, 0, array.length);
    }
    
    public static final <T extends MessageNano> T mergeFrom(final T t, final byte[] array, final int n, final int n2) throws InvalidProtocolBufferNanoException {
        try {
            final CodedInputByteBufferNano instance = CodedInputByteBufferNano.newInstance(array, n, n2);
            t.mergeFrom(instance);
            instance.checkLastTagWas(0);
            return t;
        }
        catch (InvalidProtocolBufferNanoException ex) {
            throw ex;
        }
        catch (IOException ex2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }
    
    public static final boolean messageNanoEquals(final MessageNano messageNano, final MessageNano messageNano2) {
        boolean b;
        if (messageNano == messageNano2) {
            b = true;
        }
        else {
            b = false;
            if (messageNano != null) {
                b = false;
                if (messageNano2 != null) {
                    final Class<? extends MessageNano> class1 = messageNano.getClass();
                    final Class<? extends MessageNano> class2 = messageNano2.getClass();
                    b = false;
                    if (class1 == class2) {
                        final int serializedSize = messageNano.getSerializedSize();
                        final int serializedSize2 = messageNano2.getSerializedSize();
                        b = false;
                        if (serializedSize2 == serializedSize) {
                            final byte[] a = new byte[serializedSize];
                            final byte[] a2 = new byte[serializedSize];
                            toByteArray(messageNano, a, 0, serializedSize);
                            toByteArray(messageNano2, a2, 0, serializedSize);
                            return Arrays.equals(a, a2);
                        }
                    }
                }
            }
        }
        return b;
    }
    
    public static final void toByteArray(final MessageNano messageNano, final byte[] array, final int n, final int n2) {
        try {
            final CodedOutputByteBufferNano instance = CodedOutputByteBufferNano.newInstance(array, n, n2);
            messageNano.writeTo(instance);
            instance.checkNoSpaceLeft();
        }
        catch (IOException cause) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", cause);
        }
    }
    
    public static final byte[] toByteArray(final MessageNano messageNano) {
        final byte[] array = new byte[messageNano.getSerializedSize()];
        toByteArray(messageNano, array, 0, array.length);
        return array;
    }
    
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            this.getSerializedSize();
        }
        return this.cachedSize;
    }
    
    public int getSerializedSize() {
        return this.cachedSize = 0;
    }
    
    public abstract MessageNano mergeFrom(final CodedInputByteBufferNano p0) throws IOException;
    
    @Override
    public String toString() {
        return MessageNanoPrinter.print(this);
    }
    
    public abstract void writeTo(final CodedOutputByteBufferNano p0) throws IOException;
}
