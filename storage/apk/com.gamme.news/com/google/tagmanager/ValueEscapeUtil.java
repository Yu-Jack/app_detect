// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;
import com.google.analytics.midtier.proto.containertag.TypeSystem;

class ValueEscapeUtil
{
    private static ObjectAndStatic<TypeSystem.Value> applyEscaping(final ObjectAndStatic<TypeSystem.Value> objectAndStatic, final int i) {
        if (!isValidStringType(objectAndStatic.getObject())) {
            Log.e("Escaping can only be applied to strings.");
            return objectAndStatic;
        }
        switch (i) {
            default: {
                Log.e("Unsupported Value Escaping: " + i);
                return objectAndStatic;
            }
            case 12: {
                return escapeUri(objectAndStatic);
            }
        }
    }
    
    static ObjectAndStatic<TypeSystem.Value> applyEscapings(final ObjectAndStatic<TypeSystem.Value> objectAndStatic, final int... array) {
        ObjectAndStatic<TypeSystem.Value> applyEscaping = objectAndStatic;
        for (int length = array.length, i = 0; i < length; ++i) {
            applyEscaping = applyEscaping(applyEscaping, array[i]);
        }
        return applyEscaping;
    }
    
    private static ObjectAndStatic<TypeSystem.Value> escapeUri(final ObjectAndStatic<TypeSystem.Value> objectAndStatic) {
        try {
            return new ObjectAndStatic<TypeSystem.Value>(Types.objectToValue(urlEncode(Types.valueToString(objectAndStatic.getObject()))), objectAndStatic.isStatic());
        }
        catch (UnsupportedEncodingException ex) {
            Log.e("Escape URI: unsupported encoding", ex);
            return objectAndStatic;
        }
    }
    
    private static boolean isValidStringType(final TypeSystem.Value value) {
        return Types.valueToObject(value) instanceof String;
    }
    
    static String urlEncode(final String s) throws UnsupportedEncodingException {
        return URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
    }
}
