// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import org.json.JSONException;
import org.json.JSONObject;

class AAXParameter$JSONObjectParameter extends AAXParameter
{
    AAXParameter$JSONObjectParameter(final String s, final String s2) {
        super(s, s2);
    }
    
    @Override
    protected JSONObject getFromDebugProperties() {
        return this.parseFromString(DebugProperties.getDebugPropertyAsString(this.getDebugName(), null));
    }
    
    @Override
    protected JSONObject parseFromString(final String s) {
        try {
            return new JSONObject(s);
        }
        catch (JSONException ex) {
            Log.e(AAXParameter.access$100(), "Unable to parse the following value into a JSONObject: %s", this.getName());
            return null;
        }
    }
}
