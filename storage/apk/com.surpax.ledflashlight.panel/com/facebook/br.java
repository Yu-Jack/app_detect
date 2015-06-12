// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.content.SharedPreferences$Editor;
import java.util.List;
import java.util.Iterator;
import org.json.JSONException;
import com.facebook.b.v;
import org.json.JSONArray;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;
import android.os.Bundle;
import com.facebook.b.aj;
import com.facebook.b.al;
import android.content.Context;
import android.content.SharedPreferences;

public class br extends bs
{
    private static final String a;
    private String b;
    private SharedPreferences c;
    
    static {
        a = br.class.getSimpleName();
    }
    
    public br(final Context context) {
        this(context, (byte)0);
    }
    
    private br(Context context, final byte b) {
        al.a(context, "context");
        final boolean a = aj.a((String)null);
        String b2 = null;
        if (a) {
            b2 = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
        }
        this.b = b2;
        final Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        this.c = context.getSharedPreferences(this.b, 0);
    }
    
    private void a(final String s, final Bundle bundle) {
        int i = 0;
        final JSONObject jsonObject = new JSONObject(this.c.getString(s, "{}"));
        final String string = jsonObject.getString("valueType");
        if (string.equals("bool")) {
            bundle.putBoolean(s, jsonObject.getBoolean("value"));
        }
        else {
            if (string.equals("bool[]")) {
                final JSONArray jsonArray = jsonObject.getJSONArray("value");
                boolean[] array;
                for (array = new boolean[jsonArray.length()]; i < array.length; ++i) {
                    array[i] = jsonArray.getBoolean(i);
                }
                bundle.putBooleanArray(s, array);
                return;
            }
            if (string.equals("byte")) {
                bundle.putByte(s, (byte)jsonObject.getInt("value"));
                return;
            }
            if (string.equals("byte[]")) {
                final JSONArray jsonArray2 = jsonObject.getJSONArray("value");
                byte[] array2;
                for (array2 = new byte[jsonArray2.length()]; i < array2.length; ++i) {
                    array2[i] = (byte)jsonArray2.getInt(i);
                }
                bundle.putByteArray(s, array2);
                return;
            }
            if (string.equals("short")) {
                bundle.putShort(s, (short)jsonObject.getInt("value"));
                return;
            }
            if (string.equals("short[]")) {
                final JSONArray jsonArray3 = jsonObject.getJSONArray("value");
                short[] array3;
                for (array3 = new short[jsonArray3.length()]; i < array3.length; ++i) {
                    array3[i] = (short)jsonArray3.getInt(i);
                }
                bundle.putShortArray(s, array3);
                return;
            }
            if (string.equals("int")) {
                bundle.putInt(s, jsonObject.getInt("value"));
                return;
            }
            if (string.equals("int[]")) {
                final JSONArray jsonArray4 = jsonObject.getJSONArray("value");
                int[] array4;
                for (array4 = new int[jsonArray4.length()]; i < array4.length; ++i) {
                    array4[i] = jsonArray4.getInt(i);
                }
                bundle.putIntArray(s, array4);
                return;
            }
            if (string.equals("long")) {
                bundle.putLong(s, jsonObject.getLong("value"));
                return;
            }
            if (string.equals("long[]")) {
                final JSONArray jsonArray5 = jsonObject.getJSONArray("value");
                long[] array5;
                for (array5 = new long[jsonArray5.length()]; i < array5.length; ++i) {
                    array5[i] = jsonArray5.getLong(i);
                }
                bundle.putLongArray(s, array5);
                return;
            }
            if (string.equals("float")) {
                bundle.putFloat(s, (float)jsonObject.getDouble("value"));
                return;
            }
            if (string.equals("float[]")) {
                final JSONArray jsonArray6 = jsonObject.getJSONArray("value");
                float[] array6;
                for (array6 = new float[jsonArray6.length()]; i < array6.length; ++i) {
                    array6[i] = (float)jsonArray6.getDouble(i);
                }
                bundle.putFloatArray(s, array6);
                return;
            }
            if (string.equals("double")) {
                bundle.putDouble(s, jsonObject.getDouble("value"));
                return;
            }
            if (string.equals("double[]")) {
                final JSONArray jsonArray7 = jsonObject.getJSONArray("value");
                double[] array7;
                for (array7 = new double[jsonArray7.length()]; i < array7.length; ++i) {
                    array7[i] = jsonArray7.getDouble(i);
                }
                bundle.putDoubleArray(s, array7);
                return;
            }
            if (string.equals("char")) {
                final String string2 = jsonObject.getString("value");
                if (string2 != null && string2.length() == 1) {
                    bundle.putChar(s, string2.charAt(0));
                }
            }
            else {
                if (string.equals("char[]")) {
                    final JSONArray jsonArray8 = jsonObject.getJSONArray("value");
                    final char[] array8 = new char[jsonArray8.length()];
                    for (int j = 0; j < array8.length; ++j) {
                        final String string3 = jsonArray8.getString(j);
                        if (string3 != null && string3.length() == 1) {
                            array8[j] = string3.charAt(0);
                        }
                    }
                    bundle.putCharArray(s, array8);
                    return;
                }
                if (string.equals("string")) {
                    bundle.putString(s, jsonObject.getString("value"));
                    return;
                }
                if (string.equals("stringList")) {
                    final JSONArray jsonArray9 = jsonObject.getJSONArray("value");
                    final int length = jsonArray9.length();
                    final ArrayList list = new ArrayList<String>(length);
                    for (int k = 0; k < length; ++k) {
                        final Object value = jsonArray9.get(k);
                        String element;
                        if (value == JSONObject.NULL) {
                            element = null;
                        }
                        else {
                            element = (String)value;
                        }
                        list.add(k, element);
                    }
                    bundle.putStringArrayList(s, list);
                    return;
                }
                if (string.equals("enum")) {
                    try {
                        bundle.putSerializable(s, Enum.valueOf(Class.forName(jsonObject.getString("enumType")), jsonObject.getString("value")));
                    }
                    catch (ClassNotFoundException ex) {}
                    catch (IllegalArgumentException ex2) {}
                }
            }
        }
    }
    
    @Override
    public final Bundle a() {
        final Bundle bundle = new Bundle();
        for (final String str : this.c.getAll().keySet()) {
            try {
                this.a(str, bundle);
            }
            catch (JSONException obj) {
                v.a(ak.d, 5, br.a, "Error reading cached value for key: '" + str + "' -- " + obj);
                return null;
            }
        }
        return bundle;
    }
    
    @Override
    public final void a(final Bundle bundle) {
        al.a(bundle, "bundle");
        final SharedPreferences$Editor edit = this.c.edit();
        final Iterator<String> iterator = (Iterator<String>)bundle.keySet().iterator();
        while (iterator.hasNext()) {
            while (true) {
                final String str = iterator.next();
                while (true) {
                    Object value;
                    JSONObject jsonObject;
                    try {
                        value = bundle.get(str);
                        if (value == null) {
                            break;
                        }
                        jsonObject = new JSONObject();
                        if (value instanceof Byte) {
                            final String s = "byte";
                            jsonObject.put("value", (int)value);
                            final Object o = null;
                            if (s != null) {
                                jsonObject.put("valueType", (Object)s);
                                if (o != null) {
                                    jsonObject.putOpt("value", o);
                                }
                                edit.putString(str, jsonObject.toString());
                                break;
                            }
                            break;
                        }
                    }
                    catch (JSONException obj) {
                        v.a(ak.d, 5, br.a, "Error processing value for key: '" + str + "' -- " + obj);
                        return;
                    }
                    if (value instanceof Short) {
                        final String s = "short";
                        jsonObject.put("value", (int)value);
                        final Object o = null;
                        continue;
                    }
                    if (value instanceof Integer) {
                        final String s = "int";
                        jsonObject.put("value", (int)value);
                        final Object o = null;
                        continue;
                    }
                    if (value instanceof Long) {
                        final String s = "long";
                        jsonObject.put("value", (long)value);
                        final Object o = null;
                        continue;
                    }
                    if (value instanceof Float) {
                        final String s = "float";
                        jsonObject.put("value", (double)value);
                        final Object o = null;
                        continue;
                    }
                    if (value instanceof Double) {
                        final String s = "double";
                        jsonObject.put("value", (double)value);
                        final Object o = null;
                        continue;
                    }
                    if (value instanceof Boolean) {
                        final String s = "bool";
                        jsonObject.put("value", (boolean)value);
                        final Object o = null;
                        continue;
                    }
                    if (value instanceof Character) {
                        final String s = "char";
                        jsonObject.put("value", (Object)value.toString());
                        final Object o = null;
                        continue;
                    }
                    if (value instanceof String) {
                        final String s = "string";
                        jsonObject.put("value", (Object)value);
                        final Object o = null;
                        continue;
                    }
                    if (value instanceof Enum) {
                        final String s = "enum";
                        jsonObject.put("value", (Object)value.toString());
                        jsonObject.put("enumType", (Object)((List<String>)value).getClass().getName());
                        final Object o = null;
                        continue;
                    }
                    final JSONArray jsonArray = new JSONArray();
                    if (value instanceof byte[]) {
                        final byte[] array = (byte[])value;
                        for (int length = array.length, i = 0; i < length; ++i) {
                            jsonArray.put((int)array[i]);
                        }
                        final Object o = jsonArray;
                        final String s = "byte[]";
                        continue;
                    }
                    if (value instanceof short[]) {
                        final short[] array2 = (short[])value;
                        for (int length2 = array2.length, j = 0; j < length2; ++j) {
                            jsonArray.put((int)array2[j]);
                        }
                        final Object o = jsonArray;
                        final String s = "short[]";
                        continue;
                    }
                    if (value instanceof int[]) {
                        final int[] array3 = (int[])value;
                        for (int length3 = array3.length, k = 0; k < length3; ++k) {
                            jsonArray.put(array3[k]);
                        }
                        final Object o = jsonArray;
                        final String s = "int[]";
                        continue;
                    }
                    if (value instanceof long[]) {
                        final long[] array4 = (long[])value;
                        for (int length4 = array4.length, l = 0; l < length4; ++l) {
                            jsonArray.put(array4[l]);
                        }
                        final Object o = jsonArray;
                        final String s = "long[]";
                        continue;
                    }
                    if (value instanceof float[]) {
                        final float[] array5 = (float[])value;
                        for (int length5 = array5.length, n = 0; n < length5; ++n) {
                            jsonArray.put((double)array5[n]);
                        }
                        final Object o = jsonArray;
                        final String s = "float[]";
                        continue;
                    }
                    if (value instanceof double[]) {
                        final double[] array6 = (double[])value;
                        for (int length6 = array6.length, n2 = 0; n2 < length6; ++n2) {
                            jsonArray.put(array6[n2]);
                        }
                        final Object o = jsonArray;
                        final String s = "double[]";
                        continue;
                    }
                    if (value instanceof boolean[]) {
                        final boolean[] array7 = (boolean[])value;
                        for (int length7 = array7.length, n3 = 0; n3 < length7; ++n3) {
                            jsonArray.put(array7[n3]);
                        }
                        final Object o = jsonArray;
                        final String s = "bool[]";
                        continue;
                    }
                    if (value instanceof char[]) {
                        final char[] array8 = (char[])value;
                        for (int length8 = array8.length, n4 = 0; n4 < length8; ++n4) {
                            jsonArray.put((Object)String.valueOf(array8[n4]));
                        }
                        final Object o = jsonArray;
                        final String s = "char[]";
                        continue;
                    }
                    if (value instanceof List) {
                        for (Object null : (List<String>)value) {
                            if (null == null) {
                                null = JSONObject.NULL;
                            }
                            jsonArray.put(null);
                        }
                        final Object o = jsonArray;
                        final String s = "stringList";
                        continue;
                    }
                    final Object o = null;
                    final String s = null;
                    continue;
                }
            }
        }
        if (!edit.commit()) {
            v.a(ak.d, 5, br.a, "SharedPreferences.Editor.commit() was not successful");
        }
    }
    
    @Override
    public final void b() {
        this.c.edit().clear().commit();
    }
}
