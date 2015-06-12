// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import org.json.JSONArray;
import java.util.HashMap;
import org.json.JSONException;
import java.util.Iterator;
import org.json.JSONObject;
import java.util.Map;

class AdRequest$JSONObjectBuilder
{
    private AAXParameter[] aaxParameters;
    private Map advancedOptions;
    private final JSONObject json;
    private AAXParameter$ParameterData parameterData;
    
    AdRequest$JSONObjectBuilder() {
        this.json = new JSONObject();
    }
    
    void build() {
        for (final AAXParameter aaxParameter : this.aaxParameters) {
            this.putIntoJSON(aaxParameter, aaxParameter.getValue(this.parameterData));
        }
        if (this.advancedOptions != null) {
            for (final Map.Entry<K, String> entry : this.advancedOptions.entrySet()) {
                if (!Utils.isNullOrWhiteSpace(entry.getValue())) {
                    this.putIntoJSON((String)entry.getKey(), entry.getValue());
                }
            }
        }
    }
    
    JSONObject getJSON() {
        return this.json;
    }
    
    AAXParameter$ParameterData getParameterData() {
        return this.parameterData;
    }
    
    void putIntoJSON(final AAXParameter aaxParameter, final Object o) {
        this.putIntoJSON(aaxParameter.getName(), o);
    }
    
    void putIntoJSON(final String s, final Object o) {
        if (o == null) {
            return;
        }
        try {
            this.json.put(s, o);
        }
        catch (JSONException ex) {
            Log.d(AdRequest.LOG_TAG, "Could not add parameter to JSON %s: %s", s, o);
        }
    }
    
    AdRequest$JSONObjectBuilder setAAXParameters(final AAXParameter[] aaxParameters) {
        this.aaxParameters = aaxParameters;
        return this;
    }
    
    AdRequest$JSONObjectBuilder setAdvancedOptions(final Map advancedOptions) {
        this.advancedOptions = advancedOptions;
        return this;
    }
    
    AdRequest$JSONObjectBuilder setParameterData(final AAXParameter$ParameterData parameterData) {
        this.parameterData = parameterData;
        return this;
    }
}
