// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import org.json.JSONObject;
import android.util.Base64;
import org.json.JSONException;
import org.json.JSONArray;

public class CordovaArgs
{
    private JSONArray baseArgs;
    
    public CordovaArgs(final JSONArray baseArgs) {
        this.baseArgs = baseArgs;
    }
    
    public Object get(final int n) throws JSONException {
        return this.baseArgs.get(n);
    }
    
    public byte[] getArrayBuffer(final int n) throws JSONException {
        return Base64.decode(this.baseArgs.getString(n), 0);
    }
    
    public boolean getBoolean(final int n) throws JSONException {
        return this.baseArgs.getBoolean(n);
    }
    
    public double getDouble(final int n) throws JSONException {
        return this.baseArgs.getDouble(n);
    }
    
    public int getInt(final int n) throws JSONException {
        return this.baseArgs.getInt(n);
    }
    
    public JSONArray getJSONArray(final int n) throws JSONException {
        return this.baseArgs.getJSONArray(n);
    }
    
    public JSONObject getJSONObject(final int n) throws JSONException {
        return this.baseArgs.getJSONObject(n);
    }
    
    public long getLong(final int n) throws JSONException {
        return this.baseArgs.getLong(n);
    }
    
    public String getString(final int n) throws JSONException {
        return this.baseArgs.getString(n);
    }
    
    public boolean isNull(final int n) {
        return this.baseArgs.isNull(n);
    }
    
    public Object opt(final int n) {
        return this.baseArgs.opt(n);
    }
    
    public boolean optBoolean(final int n) {
        return this.baseArgs.optBoolean(n);
    }
    
    public double optDouble(final int n) {
        return this.baseArgs.optDouble(n);
    }
    
    public int optInt(final int n) {
        return this.baseArgs.optInt(n);
    }
    
    public JSONArray optJSONArray(final int n) {
        return this.baseArgs.optJSONArray(n);
    }
    
    public JSONObject optJSONObject(final int n) {
        return this.baseArgs.optJSONObject(n);
    }
    
    public long optLong(final int n) {
        return this.baseArgs.optLong(n);
    }
    
    public String optString(final int n) {
        return this.baseArgs.optString(n);
    }
}
