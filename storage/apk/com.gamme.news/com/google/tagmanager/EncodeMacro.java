// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.containertag.common.FunctionType;

class EncodeMacro extends FunctionCallImplementation
{
    private static final String ARG0;
    private static final String DEFAULT_INPUT_FORMAT = "text";
    private static final String DEFAULT_OUTPUT_FORMAT = "base16";
    private static final String ID;
    private static final String INPUT_FORMAT;
    private static final String NO_PADDING;
    private static final String OUTPUT_FORMAT;
    
    static {
        ID = FunctionType.ENCODE.toString();
        ARG0 = Key.ARG0.toString();
        NO_PADDING = Key.NO_PADDING.toString();
        INPUT_FORMAT = Key.INPUT_FORMAT.toString();
        OUTPUT_FORMAT = Key.OUTPUT_FORMAT.toString();
    }
    
    public EncodeMacro() {
        super(EncodeMacro.ID, new String[] { EncodeMacro.ARG0 });
    }
    
    public static String getFunctionId() {
        return EncodeMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        final TypeSystem.Value value = map.get(EncodeMacro.ARG0);
        if (value == null || value == Types.getDefaultValue()) {
            return Types.getDefaultValue();
        }
        final String valueToString = Types.valueToString(value);
        final TypeSystem.Value value2 = map.get(EncodeMacro.INPUT_FORMAT);
    Label_0190_Outer:
        while (true) {
            Label_0079: {
                while (true) {
                    Label_0056: {
                        if (value2 == null) {
                            final String valueToString2 = "text";
                            break Label_0056;
                        }
                        String valueToString3 = null;
                        Label_0180: {
                            break Label_0180;
                            while (true) {
                                while (true) {
                                    byte[] array = null;
                                    final int n;
                                    Label_0305: {
                                        try {
                                            final String valueToString2;
                                            if ("text".equals(valueToString2)) {
                                                array = valueToString.getBytes();
                                            }
                                            else if ("base16".equals(valueToString2)) {
                                                array = Base16.decode(valueToString);
                                            }
                                            else if ("base64".equals(valueToString2)) {
                                                array = Base64Encoder.decode(valueToString, n);
                                            }
                                            else {
                                                if (!"base64url".equals(valueToString2)) {
                                                    Log.e("Encode: unknown input format: " + valueToString2);
                                                    return Types.getDefaultValue();
                                                }
                                                array = Base64Encoder.decode(valueToString, n | 0x2);
                                            }
                                            if ("base16".equals(valueToString3)) {
                                                final String s = Base16.encode(array);
                                                return Types.objectToValue(s);
                                            }
                                            break Label_0305;
                                            final TypeSystem.Value value3;
                                            valueToString3 = Types.valueToString(value3);
                                            break Label_0079;
                                            valueToString2 = Types.valueToString(value2);
                                            break Label_0056;
                                        }
                                        catch (IllegalArgumentException ex) {
                                            Log.e("Encode: invalid input:");
                                            return Types.getDefaultValue();
                                        }
                                    }
                                    if ("base64".equals(valueToString3)) {
                                        final String s = Base64Encoder.encodeToString(array, n);
                                        continue Label_0190_Outer;
                                    }
                                    if ("base64url".equals(valueToString3)) {
                                        final String s = Base64Encoder.encodeToString(array, n | 0x2);
                                        continue Label_0190_Outer;
                                    }
                                    break;
                                }
                                break;
                            }
                        }
                        Log.e("Encode: unknown output format: " + valueToString3);
                        return Types.getDefaultValue();
                    }
                    final TypeSystem.Value value3 = map.get(EncodeMacro.OUTPUT_FORMAT);
                    if (value3 != null) {
                        continue;
                    }
                    break;
                }
                String valueToString3 = "base16";
            }
            final TypeSystem.Value value4 = map.get(EncodeMacro.INPUT_FORMAT);
            final TypeSystem.Value value5 = map.get(EncodeMacro.NO_PADDING);
            int n = 0;
            if (value5 == null) {
                continue Label_0190_Outer;
            }
            final boolean booleanValue = Types.valueToBoolean(value5);
            n = 0;
            if (booleanValue) {
                n = ((false | true) ? 1 : 0);
            }
            continue Label_0190_Outer;
        }
    }
    
    @Override
    public boolean isCacheable() {
        return true;
    }
}
