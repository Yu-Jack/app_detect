// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;

class JSONUtils
{
    protected static boolean getBooleanFromJSON(final JSONObject jsonObject, final String s, final boolean b) {
        return jsonObject.optBoolean(s, b);
    }
    
    protected static int getIntegerFromJSON(final JSONObject jsonObject, final String s, final int n) {
        return jsonObject.optInt(s, n);
    }
    
    protected static int getIntegerFromJSONArray(final JSONArray jsonArray, final int n, final int n2) {
        return jsonArray.optInt(n, n2);
    }
    
    protected static JSONArray getJSONArrayFromJSON(final JSONObject jsonObject, final String s) {
        return jsonObject.optJSONArray(s);
    }
    
    protected static JSONObject getJSONObjectFromJSONArray(final JSONArray jsonArray, final int n) {
        try {
            return jsonArray.getJSONObject(n);
        }
        catch (JSONException ex) {
            return null;
        }
    }
    
    protected static JSONObject getJSONObjectFromString(final String s) {
        try {
            return new JSONObject(s);
        }
        catch (JSONException ex) {
            return null;
        }
    }
    
    protected static long getLongFromJSON(final JSONObject jsonObject, final String s, final long n) {
        return jsonObject.optLong(s, n);
    }
    
    protected static String getStringFromJSON(final JSONObject jsonObject, final String s, final String s2) {
        return jsonObject.optString(s, s2);
    }
    
    protected static void put(final JSONObject jsonObject, final String s, final int n) {
        try {
            jsonObject.put(s, n);
        }
        catch (JSONException ex) {}
    }
    
    protected static void put(final JSONObject jsonObject, final String s, final long n) {
        try {
            jsonObject.put(s, n);
        }
        catch (JSONException ex) {}
    }
    
    protected static void put(final JSONObject jsonObject, final String s, final String s2) {
        if (s2 == null || s2.equals("")) {
            return;
        }
        try {
            jsonObject.put(s, (Object)s2);
        }
        catch (JSONException ex) {}
    }
}
