// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager.protobuf.nano;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class WireFormatNano
{
    public static final boolean[] EMPTY_BOOLEAN_ARRAY;
    public static final Boolean[] EMPTY_BOOLEAN_REF_ARRAY;
    public static final byte[] EMPTY_BYTES;
    public static final byte[][] EMPTY_BYTES_ARRAY;
    public static final double[] EMPTY_DOUBLE_ARRAY;
    public static final Double[] EMPTY_DOUBLE_REF_ARRAY;
    public static final float[] EMPTY_FLOAT_ARRAY;
    public static final Float[] EMPTY_FLOAT_REF_ARRAY;
    public static final int[] EMPTY_INT_ARRAY;
    public static final Integer[] EMPTY_INT_REF_ARRAY;
    public static final long[] EMPTY_LONG_ARRAY;
    public static final Long[] EMPTY_LONG_REF_ARRAY;
    public static final String[] EMPTY_STRING_ARRAY;
    static final int MESSAGE_SET_ITEM = 1;
    static final int MESSAGE_SET_ITEM_END_TAG = 0;
    static final int MESSAGE_SET_ITEM_TAG = 0;
    static final int MESSAGE_SET_MESSAGE = 3;
    static final int MESSAGE_SET_MESSAGE_TAG = 0;
    static final int MESSAGE_SET_TYPE_ID = 2;
    static final int MESSAGE_SET_TYPE_ID_TAG = 0;
    static final int TAG_TYPE_BITS = 3;
    static final int TAG_TYPE_MASK = 7;
    static final int WIRETYPE_END_GROUP = 4;
    static final int WIRETYPE_FIXED32 = 5;
    static final int WIRETYPE_FIXED64 = 1;
    static final int WIRETYPE_LENGTH_DELIMITED = 2;
    static final int WIRETYPE_START_GROUP = 3;
    static final int WIRETYPE_VARINT;
    
    static {
        EMPTY_INT_ARRAY = new int[0];
        EMPTY_LONG_ARRAY = new long[0];
        EMPTY_FLOAT_ARRAY = new float[0];
        EMPTY_DOUBLE_ARRAY = new double[0];
        EMPTY_BOOLEAN_ARRAY = new boolean[0];
        EMPTY_STRING_ARRAY = new String[0];
        EMPTY_BYTES_ARRAY = new byte[0][];
        EMPTY_BYTES = new byte[0];
        EMPTY_INT_REF_ARRAY = new Integer[0];
        EMPTY_LONG_REF_ARRAY = new Long[0];
        EMPTY_FLOAT_REF_ARRAY = new Float[0];
        EMPTY_DOUBLE_REF_ARRAY = new Double[0];
        EMPTY_BOOLEAN_REF_ARRAY = new Boolean[0];
    }
    
    public static int computeWireSize(final List<UnknownFieldData> list) {
        int n;
        if (list == null) {
            n = 0;
        }
        else {
            n = 0;
            for (final UnknownFieldData unknownFieldData : list) {
                n = n + CodedOutputByteBufferNano.computeRawVarint32Size(unknownFieldData.tag) + unknownFieldData.bytes.length;
            }
        }
        return n;
    }
    
    public static <T> T getExtension(final Extension<T> extension, final List<UnknownFieldData> list) {
        if (list != null) {
            final ArrayList<UnknownFieldData> list2 = new ArrayList<UnknownFieldData>();
            for (final UnknownFieldData unknownFieldData : list) {
                if (getTagFieldNumber(unknownFieldData.tag) == extension.fieldNumber) {
                    list2.add(unknownFieldData);
                }
            }
            if (!list2.isEmpty()) {
                if (extension.isRepeatedField) {
                    final ArrayList obj = new ArrayList<T>(list2.size());
                    final Iterator<Object> iterator2 = list2.iterator();
                    while (iterator2.hasNext()) {
                        obj.add(readData(extension.fieldType, iterator2.next().bytes));
                    }
                    return extension.listType.cast(obj);
                }
                return readData(extension.fieldType, ((UnknownFieldData)list2.get(-1 + list2.size())).bytes);
            }
        }
        return null;
    }
    
    public static final int getRepeatedFieldArrayLength(final CodedInputByteBufferNano codedInputByteBufferNano, final int n) throws IOException {
        int n2 = 1;
        final int position = codedInputByteBufferNano.getPosition();
        codedInputByteBufferNano.skipField(n);
        while (codedInputByteBufferNano.getBytesUntilLimit() > 0 && codedInputByteBufferNano.readTag() == n) {
            codedInputByteBufferNano.skipField(n);
            ++n2;
        }
        codedInputByteBufferNano.rewindToPosition(position);
        return n2;
    }
    
    public static int getTagFieldNumber(final int n) {
        return n >>> 3;
    }
    
    static int getTagWireType(final int n) {
        return n & 0x7;
    }
    
    static int makeTag(final int n, final int n2) {
        return n2 | n << 3;
    }
    
    public static boolean parseUnknownField(final CodedInputByteBufferNano codedInputByteBufferNano, final int n) throws IOException {
        return codedInputByteBufferNano.skipField(n);
    }
    
    private static <T> T readData(final Class<T> obj, final byte[] array) {
        if (array.length == 0) {
            return null;
        }
        final CodedInputByteBufferNano instance = CodedInputByteBufferNano.newInstance(array);
        while (true) {
            if (obj == String.class) {
                try {
                    return (T)obj.cast(instance.readString());
                    // iftrue(Label_0099:, obj != Float.class)
                    // iftrue(Label_0045:, obj != Integer.class)
                    // iftrue(Label_0132:, obj != byte[].class)
                    // iftrue(Label_0249:, !MessageNano.class.isAssignableFrom((Class<?>)obj))
                    while (true) {
                        try {
                            final MessageNano obj2 = (MessageNano)obj.newInstance();
                            instance.readMessage(obj2);
                            return (T)obj.cast(obj2);
                        }
                        catch (IllegalAccessException cause) {
                            throw new IllegalArgumentException("Error creating instance of class " + obj, cause);
                        }
                        catch (InstantiationException cause2) {
                            throw new IllegalArgumentException("Error creating instance of class " + obj, cause2);
                        }
                        return (T)obj.cast(instance.readInt32());
                        Label_0081: {
                            return (T)obj.cast(instance.readFloat());
                        }
                        return (T)obj.cast(instance.readInt32());
                        Label_0117:
                        return (T)obj.cast(instance.readBytes());
                        Label_0132:
                        continue;
                    }
                    Label_0045: {
                        return (T)obj.cast(instance.readInt64());
                    }
                    // iftrue(Label_0063:, obj != Long.class)
                    Label_0099: {
                        return (T)obj.cast(instance.readDouble());
                    }
                    // iftrue(Label_0117:, obj != Double.class)
                    Label_0063: {
                        return (T)obj.cast(instance.readBool());
                    }
                }
                // iftrue(Label_0081:, obj != Boolean.class)
                catch (IOException ex) {}
                Label_0249: {
                    throw new IllegalArgumentException("Unhandled extension field type: " + obj);
                }
            }
            continue;
        }
    }
    
    public static <T> void setExtension(final Extension<T> extension, final T t, final List<UnknownFieldData> list) {
        final Iterator<UnknownFieldData> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (extension.fieldNumber == getTagFieldNumber(iterator.next().tag)) {
                iterator.remove();
            }
        }
        if (t != null) {
            if (!(t instanceof List)) {
                list.add(write(extension.fieldNumber, t));
                return;
            }
            final Iterator<Object> iterator2 = ((List)t).iterator();
            while (iterator2.hasNext()) {
                list.add(write(extension.fieldNumber, iterator2.next()));
            }
        }
    }
    
    public static boolean storeUnknownField(final List<UnknownFieldData> list, final CodedInputByteBufferNano codedInputByteBufferNano, final int n) throws IOException {
        final int position = codedInputByteBufferNano.getPosition();
        final boolean skipField = codedInputByteBufferNano.skipField(n);
        list.add(new UnknownFieldData(n, codedInputByteBufferNano.getData(position, codedInputByteBufferNano.getPosition() - position)));
        return skipField;
    }
    
    private static UnknownFieldData write(final int n, final Object o) {
        final Class<?> class1 = o.getClass();
        Label_0063: {
            if (class1 != String.class) {
                break Label_0063;
            }
            try {
                final String s = (String)o;
                byte[] array = new byte[CodedOutputByteBufferNano.computeStringSizeNoTag(s)];
                CodedOutputByteBufferNano.newInstance(array).writeStringNoTag(s);
                int n2 = makeTag(n, 2);
                return new UnknownFieldData(n2, array);
                // iftrue(Label_0298:, class1 != Double.class)
                // iftrue(Label_0411:, !MessageNano.class.isAssignableFrom(class1))
                // iftrue(Label_0204:, class1 != Boolean.class)
                // iftrue(Label_0342:, class1 != byte[].class)
                // iftrue(Label_0157:, class1 != Long.class)
                // iftrue(Label_0251:, class1 != Float.class)
                // iftrue(Label_0110:, class1 != Integer.class)
                Block_9: {
                    while (true) {
                        Block_8: {
                            while (true) {
                            Block_5_Outer:
                                while (true) {
                                    while (true) {
                                        Block_7: {
                                            break Block_7;
                                            Label_0342: {
                                                break Block_9;
                                            }
                                            final Long n3 = (Long)o;
                                            array = new byte[CodedOutputByteBufferNano.computeInt64SizeNoTag(n3)];
                                            CodedOutputByteBufferNano.newInstance(array).writeInt64NoTag(n3);
                                            n2 = makeTag(n, 0);
                                            return new UnknownFieldData(n2, array);
                                            final Boolean b = (Boolean)o;
                                            array = new byte[CodedOutputByteBufferNano.computeBoolSizeNoTag(b)];
                                            CodedOutputByteBufferNano.newInstance(array).writeBoolNoTag(b);
                                            n2 = makeTag(n, 0);
                                            return new UnknownFieldData(n2, array);
                                        }
                                        final Double n4 = (Double)o;
                                        array = new byte[CodedOutputByteBufferNano.computeDoubleSizeNoTag(n4)];
                                        CodedOutputByteBufferNano.newInstance(array).writeDoubleNoTag(n4);
                                        n2 = makeTag(n, 1);
                                        return new UnknownFieldData(n2, array);
                                        Label_0157: {
                                            continue;
                                        }
                                    }
                                    final Float n5 = (Float)o;
                                    array = new byte[CodedOutputByteBufferNano.computeFloatSizeNoTag(n5)];
                                    CodedOutputByteBufferNano.newInstance(array).writeFloatNoTag(n5);
                                    n2 = makeTag(n, 5);
                                    return new UnknownFieldData(n2, array);
                                    Label_0298: {
                                        break Block_8;
                                    }
                                    Label_0110:
                                    continue Block_5_Outer;
                                }
                                Label_0204: {
                                    continue;
                                }
                            }
                            final Integer n6 = (Integer)o;
                            array = new byte[CodedOutputByteBufferNano.computeInt32SizeNoTag(n6)];
                            CodedOutputByteBufferNano.newInstance(array).writeInt32NoTag(n6);
                            n2 = makeTag(n, 0);
                            return new UnknownFieldData(n2, array);
                        }
                        final byte[] array2 = (byte[])o;
                        array = new byte[CodedOutputByteBufferNano.computeByteArraySizeNoTag(array2)];
                        CodedOutputByteBufferNano.newInstance(array).writeByteArrayNoTag(array2);
                        n2 = makeTag(n, 2);
                        return new UnknownFieldData(n2, array);
                        continue;
                    }
                }
                final MessageNano messageNano = (MessageNano)o;
                final int serializedSize = messageNano.getSerializedSize();
                array = new byte[serializedSize + CodedOutputByteBufferNano.computeRawVarint32Size(serializedSize)];
                final CodedOutputByteBufferNano instance = CodedOutputByteBufferNano.newInstance(array);
                instance.writeRawVarint32(serializedSize);
                instance.writeRawBytes(MessageNano.toByteArray(messageNano));
                n2 = makeTag(n, 2);
                return new UnknownFieldData(n2, array);
                Label_0411: {
                    throw new IllegalArgumentException("Unhandled extension field type: " + class1);
                }
            }
            catch (IOException cause) {
                throw new IllegalArgumentException(cause);
            }
        }
    }
    
    public static void writeUnknownFields(final List<UnknownFieldData> list, final CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (list != null) {
            for (final UnknownFieldData unknownFieldData : list) {
                codedOutputByteBufferNano.writeTag(getTagFieldNumber(unknownFieldData.tag), getTagWireType(unknownFieldData.tag));
                codedOutputByteBufferNano.writeRawBytes(unknownFieldData.bytes);
            }
        }
    }
}
