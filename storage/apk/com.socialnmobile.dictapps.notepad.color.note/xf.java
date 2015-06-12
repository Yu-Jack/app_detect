import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;

// 
// Decompiled by Procyon v0.5.29
// 

public final class xf
{
    public static final xc a;
    public static final xc b;
    public static final xc c;
    
    static {
        a = new xl();
        b = new xe();
        c = new xd();
    }
    
    public static Object a(Object obj) {
        if (JSONObject.NULL.equals(obj)) {
            obj = null;
        }
        else {
            if (obj instanceof JSONObject) {
                return new xj((JSONObject)obj);
            }
            if (obj instanceof JSONArray) {
                return new xi((JSONArray)obj);
            }
        }
        return obj;
    }
    
    public static Object a(final String str, final Object o) {
        if (o == null) {
            throw new xh("not null expected: " + str);
        }
        return o;
    }
    
    public static Object a(final String str, final String s, final ada ada) {
        try {
            return ada.a(s);
        }
        catch (ux ux) {
            throw new xh("can't parse: " + str, ux);
        }
    }
    
    public static Object a(final JSONArray jsonArray, final int i) {
        try {
            return a(jsonArray.get(i));
        }
        catch (JSONException ex) {
            throw new IndexOutOfBoundsException(String.valueOf(i) + " of " + jsonArray.length() + " has been referenced");
        }
    }
    
    public static Object a(final JSONObject jsonObject, final String str) {
        try {
            return a(jsonObject.get(str));
        }
        catch (JSONException ex) {
            throw new xg("Member Not Found: " + str);
        }
    }
    
    public static void a(final JSONObject jsonObject, final String s, final Object o) {
        jsonObject.put(s, b(o));
    }
    
    public static Number b(final String str, final Object o) {
        try {
            return (Number)o;
        }
        catch (ClassCastException ex) {
            throw new xh("Number expected: " + str, ex);
        }
    }
    
    public static Object b(Object null) {
        if (null == null) {
            null = JSONObject.NULL;
        }
        else {
            if (null instanceof xj) {
                return ((xj)null).a;
            }
            if (null instanceof xi) {
                return ((xi)null).a;
            }
        }
        return null;
    }
    
    public static String c(final String str, final Object o) {
        try {
            return (String)o;
        }
        catch (ClassCastException ex) {
            throw new xh("String expected: " + str, ex);
        }
    }
    
    public static xj c(final Object o) {
        if (o == null) {
            return null;
        }
        return e(o.toString(), o);
    }
    
    public static xi d(final String str, final Object o) {
        try {
            return (xi)o;
        }
        catch (ClassCastException ex) {
            throw new xh("JsonList expected: " + str, ex);
        }
    }
    
    public static xj e(final String str, final Object o) {
        try {
            return (xj)o;
        }
        catch (ClassCastException ex) {
            throw new xh("JsonMap expected: " + str, ex);
        }
    }
}
