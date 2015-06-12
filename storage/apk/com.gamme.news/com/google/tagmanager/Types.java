// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import java.util.List;

class Types
{
    private static Boolean DEFAULT_BOOLEAN;
    private static Double DEFAULT_DOUBLE;
    private static Long DEFAULT_INT64;
    private static List<Object> DEFAULT_LIST;
    private static Map<Object, Object> DEFAULT_MAP;
    private static TypedNumber DEFAULT_NUMBER;
    private static final Object DEFAULT_OBJECT;
    private static String DEFAULT_STRING;
    private static TypeSystem.Value DEFAULT_VALUE;
    
    static {
        DEFAULT_OBJECT = null;
        Types.DEFAULT_INT64 = new Long(0L);
        Types.DEFAULT_DOUBLE = new Double(0.0);
        Types.DEFAULT_NUMBER = TypedNumber.numberWithInt64(0L);
        Types.DEFAULT_STRING = new String("");
        Types.DEFAULT_BOOLEAN = new Boolean(false);
        Types.DEFAULT_LIST = new ArrayList<Object>(0);
        Types.DEFAULT_MAP = new HashMap<Object, Object>();
        Types.DEFAULT_VALUE = objectToValue(Types.DEFAULT_STRING);
    }
    
    public static TypeSystem.Value functionIdToValue(final String functionId) {
        final TypeSystem.Value value = new TypeSystem.Value();
        value.type = 5;
        value.functionId = functionId;
        return value;
    }
    
    public static Boolean getDefaultBoolean() {
        return Types.DEFAULT_BOOLEAN;
    }
    
    public static Double getDefaultDouble() {
        return Types.DEFAULT_DOUBLE;
    }
    
    public static Long getDefaultInt64() {
        return Types.DEFAULT_INT64;
    }
    
    public static List<Object> getDefaultList() {
        return Types.DEFAULT_LIST;
    }
    
    public static Map<Object, Object> getDefaultMap() {
        return Types.DEFAULT_MAP;
    }
    
    public static TypedNumber getDefaultNumber() {
        return Types.DEFAULT_NUMBER;
    }
    
    public static Object getDefaultObject() {
        return Types.DEFAULT_OBJECT;
    }
    
    public static String getDefaultString() {
        return Types.DEFAULT_STRING;
    }
    
    public static TypeSystem.Value getDefaultValue() {
        return Types.DEFAULT_VALUE;
    }
    
    private static double getDouble(final Object o) {
        if (o instanceof Number) {
            return ((Number)o).doubleValue();
        }
        Log.e("getDouble received non-Number");
        return 0.0;
    }
    
    private static long getInt64(final Object o) {
        if (o instanceof Number) {
            return ((Number)o).longValue();
        }
        Log.e("getInt64 received non-Number");
        return 0L;
    }
    
    private static boolean isDoubleableNumber(final Object o) {
        return o instanceof Double || o instanceof Float || (o instanceof TypedNumber && ((TypedNumber)o).isDouble());
    }
    
    private static boolean isInt64ableNumber(final Object o) {
        return o instanceof Byte || o instanceof Short || o instanceof Integer || o instanceof Long || (o instanceof TypedNumber && ((TypedNumber)o).isInt64());
    }
    
    public static TypeSystem.Value macroReferenceToValue(final String macroReference, final int... array) {
        final TypeSystem.Value value = new TypeSystem.Value();
        value.type = 4;
        value.macroReference = macroReference;
        value.containsReferences = true;
        value.escaping = array.clone();
        return value;
    }
    
    public static Boolean objectToBoolean(final Object o) {
        if (o instanceof Boolean) {
            return (Boolean)o;
        }
        return parseBoolean(objectToString(o));
    }
    
    public static Double objectToDouble(final Object o) {
        if (isDoubleableNumber(o)) {
            return getDouble(o);
        }
        return parseDouble(objectToString(o));
    }
    
    public static Long objectToInt64(final Object o) {
        if (isInt64ableNumber(o)) {
            return getInt64(o);
        }
        return parseInt64(objectToString(o));
    }
    
    public static TypedNumber objectToNumber(final Object o) {
        if (o instanceof TypedNumber) {
            return (TypedNumber)o;
        }
        if (isInt64ableNumber(o)) {
            return TypedNumber.numberWithInt64(getInt64(o));
        }
        if (isDoubleableNumber(o)) {
            return TypedNumber.numberWithDouble(getDouble(o));
        }
        return parseNumber(objectToString(o));
    }
    
    public static String objectToString(final Object o) {
        if (o == null) {
            return Types.DEFAULT_STRING;
        }
        return o.toString();
    }
    
    public static TypeSystem.Value objectToValue(final Object o) {
        final TypeSystem.Value value = new TypeSystem.Value();
        boolean containsReferences = false;
        if (o instanceof TypeSystem.Value) {
            return (TypeSystem.Value)o;
        }
        if (o instanceof String) {
            value.type = 1;
            value.string = (String)o;
        }
        else if (o instanceof List) {
            value.type = 2;
            final List list = (List)o;
            final ArrayList list2 = new ArrayList<TypeSystem.Value>(list.size());
            final Iterator<Object> iterator = list.iterator();
            while (iterator.hasNext()) {
                final TypeSystem.Value objectToValue = objectToValue(iterator.next());
                if (objectToValue == Types.DEFAULT_VALUE) {
                    return Types.DEFAULT_VALUE;
                }
                containsReferences = (containsReferences || objectToValue.containsReferences);
                list2.add(objectToValue);
            }
            value.listItem = list2.toArray(new TypeSystem.Value[0]);
        }
        else if (o instanceof Map) {
            value.type = 3;
            final Set<Map.Entry<Object, V>> entrySet = (Set<Map.Entry<Object, V>>)((Map)o).entrySet();
            final ArrayList list3 = new ArrayList<TypeSystem.Value>(entrySet.size());
            final ArrayList list4 = new ArrayList<TypeSystem.Value>(entrySet.size());
            for (final Map.Entry<Object, V> entry : entrySet) {
                final TypeSystem.Value objectToValue2 = objectToValue(entry.getKey());
                final TypeSystem.Value objectToValue3 = objectToValue(entry.getValue());
                if (objectToValue2 == Types.DEFAULT_VALUE || objectToValue3 == Types.DEFAULT_VALUE) {
                    return Types.DEFAULT_VALUE;
                }
                containsReferences = (containsReferences || objectToValue2.containsReferences || objectToValue3.containsReferences);
                list3.add(objectToValue2);
                list4.add(objectToValue3);
            }
            value.mapKey = list3.toArray(new TypeSystem.Value[0]);
            value.mapValue = list4.toArray(new TypeSystem.Value[0]);
        }
        else if (isDoubleableNumber(o)) {
            value.type = 1;
            value.string = o.toString();
            containsReferences = false;
        }
        else if (isInt64ableNumber(o)) {
            value.type = 6;
            value.integer = getInt64(o);
            containsReferences = false;
        }
        else {
            if (!(o instanceof Boolean)) {
                final StringBuilder append = new StringBuilder().append("Converting to Value from unknown object type: ");
                String string;
                if (o == null) {
                    string = "null";
                }
                else {
                    string = o.getClass().toString();
                }
                Log.e(append.append(string).toString());
                return Types.DEFAULT_VALUE;
            }
            value.type = 8;
            value.boolean_ = (boolean)o;
            containsReferences = false;
        }
        value.containsReferences = containsReferences;
        return value;
    }
    
    private static Boolean parseBoolean(final String s) {
        if ("true".equalsIgnoreCase(s)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(s)) {
            return Boolean.FALSE;
        }
        return Types.DEFAULT_BOOLEAN;
    }
    
    private static Double parseDouble(final String s) {
        final TypedNumber number = parseNumber(s);
        if (number == Types.DEFAULT_NUMBER) {
            return Types.DEFAULT_DOUBLE;
        }
        return number.doubleValue();
    }
    
    private static Long parseInt64(final String s) {
        final TypedNumber number = parseNumber(s);
        if (number == Types.DEFAULT_NUMBER) {
            return Types.DEFAULT_INT64;
        }
        return number.longValue();
    }
    
    private static TypedNumber parseNumber(final String str) {
        try {
            return TypedNumber.numberWithString(str);
        }
        catch (NumberFormatException ex) {
            Log.e("Failed to convert '" + str + "' to a number.");
            return Types.DEFAULT_NUMBER;
        }
    }
    
    public static TypeSystem.Value templateToValue(final TypeSystem.Value... array) {
        final TypeSystem.Value value = new TypeSystem.Value();
        value.type = 7;
        boolean containsReferences = false;
        value.templateToken = new TypeSystem.Value[array.length];
        for (int i = 0; i < array.length; ++i) {
            value.templateToken[i] = array[i];
            containsReferences = (containsReferences || array[i].containsReferences);
        }
        value.containsReferences = containsReferences;
        return value;
    }
    
    public static Boolean valueToBoolean(final TypeSystem.Value value) {
        return objectToBoolean(valueToObject(value));
    }
    
    public static Double valueToDouble(final TypeSystem.Value value) {
        return objectToDouble(valueToObject(value));
    }
    
    public static Long valueToInt64(final TypeSystem.Value value) {
        return objectToInt64(valueToObject(value));
    }
    
    public static TypedNumber valueToNumber(final TypeSystem.Value value) {
        return objectToNumber(valueToObject(value));
    }
    
    public static Object valueToObject(final TypeSystem.Value value) {
        Object default_OBJECT = null;
        if (value == null) {
            default_OBJECT = Types.DEFAULT_OBJECT;
        }
        else {
            switch (value.type) {
                default: {
                    Log.e("Failed to convert a value of type: " + value.type);
                    return Types.DEFAULT_OBJECT;
                }
                case 1: {
                    return value.string;
                }
                case 2: {
                    default_OBJECT = new ArrayList<Object>(value.listItem.length);
                    final TypeSystem.Value[] listItem = value.listItem;
                    for (int length = listItem.length, i = 0; i < length; ++i) {
                        final Object valueToObject = valueToObject(listItem[i]);
                        if (valueToObject == Types.DEFAULT_OBJECT) {
                            return Types.DEFAULT_OBJECT;
                        }
                        ((ArrayList<Object>)default_OBJECT).add(valueToObject);
                    }
                    break;
                }
                case 3: {
                    if (value.mapKey.length != value.mapValue.length) {
                        Log.e("Converting an invalid value to object: " + value.toString());
                        return Types.DEFAULT_OBJECT;
                    }
                    final LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(value.mapValue.length);
                    for (int j = 0; j < value.mapKey.length; ++j) {
                        final Object valueToObject2 = valueToObject(value.mapKey[j]);
                        final Object valueToObject3 = valueToObject(value.mapValue[j]);
                        if (valueToObject2 == Types.DEFAULT_OBJECT || valueToObject3 == Types.DEFAULT_OBJECT) {
                            return Types.DEFAULT_OBJECT;
                        }
                        linkedHashMap.put(valueToObject2, valueToObject3);
                    }
                    return linkedHashMap;
                }
                case 4: {
                    Log.e("Trying to convert a macro reference to object");
                    return Types.DEFAULT_OBJECT;
                }
                case 5: {
                    Log.e("Trying to convert a function id to object");
                    return Types.DEFAULT_OBJECT;
                }
                case 6: {
                    return value.integer;
                }
                case 7: {
                    final StringBuffer sb = new StringBuffer();
                    final TypeSystem.Value[] templateToken = value.templateToken;
                    for (int length2 = templateToken.length, k = 0; k < length2; ++k) {
                        final String valueToString = valueToString(templateToken[k]);
                        if (valueToString == Types.DEFAULT_STRING) {
                            return Types.DEFAULT_OBJECT;
                        }
                        sb.append(valueToString);
                    }
                    return sb.toString();
                }
                case 8: {
                    return value.boolean_;
                }
            }
        }
        return default_OBJECT;
    }
    
    public static String valueToString(final TypeSystem.Value value) {
        return objectToString(valueToObject(value));
    }
}
