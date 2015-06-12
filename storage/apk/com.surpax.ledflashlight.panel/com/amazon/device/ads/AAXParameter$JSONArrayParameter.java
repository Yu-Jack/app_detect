// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import org.json.JSONException;
import org.json.JSONArray;

class AAXParameter$JSONArrayParameter extends AAXParameter
{
    AAXParameter$JSONArrayParameter(final String s, final String s2) {
        super(s, s2);
    }
    
    @Override
    protected JSONArray getFromDebugProperties() {
        return this.parseFromString(DebugProperties.getDebugPropertyAsString(this.getDebugName(), null));
    }
    
    @Override
    protected JSONArray parseFromString(final String s) {
        try {
            return new JSONArray(s);
        }
        catch (JSONException ex) {
            Log.e(AAXParameter.access$100(), "Unable to parse the following value into a JSONArray: %s", this.getName());
            return null;
        }
    }
}
