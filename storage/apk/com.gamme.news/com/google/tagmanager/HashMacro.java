// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.containertag.common.FunctionType;

class HashMacro extends FunctionCallImplementation
{
    private static final String ALGORITHM;
    private static final String ARG0;
    private static final String DEFAULT_ALGORITHM = "MD5";
    private static final String DEFAULT_INPUT_FORMAT = "text";
    private static final String ID;
    private static final String INPUT_FORMAT;
    
    static {
        ID = FunctionType.HASH.toString();
        ARG0 = Key.ARG0.toString();
        ALGORITHM = Key.ALGORITHM.toString();
        INPUT_FORMAT = Key.INPUT_FORMAT.toString();
    }
    
    public HashMacro() {
        super(HashMacro.ID, new String[] { HashMacro.ARG0 });
    }
    
    public static String getFunctionId() {
        return HashMacro.ID;
    }
    
    private byte[] hash(final String algorithm, final byte[] input) throws NoSuchAlgorithmException {
        final MessageDigest instance = MessageDigest.getInstance(algorithm);
        instance.update(input);
        return instance.digest();
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        final TypeSystem.Value value = map.get(HashMacro.ARG0);
        if (value == null || value == Types.getDefaultValue()) {
            return Types.getDefaultValue();
        }
        final String valueToString = Types.valueToString(value);
        final TypeSystem.Value value2 = map.get(HashMacro.ALGORITHM);
        Label_0114: {
            if (value2 != null) {
                break Label_0114;
            }
            String valueToString2 = "MD5";
        Label_0079_Outer:
            while (true) {
                final TypeSystem.Value value3 = map.get(HashMacro.INPUT_FORMAT);
                Label_0124: {
                    if (value3 != null) {
                        break Label_0124;
                    }
                    String valueToString3 = "text";
                    while (true) {
                        Label_0134: {
                            if (!"text".equals(valueToString3)) {
                                break Label_0134;
                            }
                            byte[] array = valueToString.getBytes();
                            try {
                                return Types.objectToValue(Base16.encode(this.hash(valueToString2, array)));
                                // iftrue(Label_0153:, !"base16".equals((Object)valueToString3))
                                Block_6: {
                                    break Block_6;
                                    Label_0153: {
                                        Log.e("Hash: unknown input format: " + valueToString3);
                                    }
                                    return Types.getDefaultValue();
                                    valueToString3 = Types.valueToString(value3);
                                    continue;
                                }
                                array = Base16.decode(valueToString);
                                return Types.objectToValue(Base16.encode(this.hash(valueToString2, array)));
                                valueToString2 = Types.valueToString(value2);
                                continue Label_0079_Outer;
                            }
                            catch (NoSuchAlgorithmException ex) {
                                Log.e("Hash: unknown algorithm: " + valueToString2);
                                return Types.getDefaultValue();
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
    }
    
    @Override
    public boolean isCacheable() {
        return true;
    }
}
