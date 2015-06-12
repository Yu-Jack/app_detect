// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;
import org.json.JSONObject;

class AAXParameter$UserInfoParameter extends AAXParameter$JSONObjectParameter
{
    AAXParameter$UserInfoParameter() {
        super("uinfo", "debug.ui");
    }
    
    @Override
    protected JSONObject getDerivedValue(final AAXParameter$ParameterData aaxParameter$ParameterData) {
        if (aaxParameter$ParameterData.adRequest.getAdTargetingOptions().hasAge()) {
            final int age = aaxParameter$ParameterData.adRequest.getAdTargetingOptions().getAge();
            final JSONObject jsonObject = new JSONObject();
            JSONUtils.put(jsonObject, "age", String.valueOf(age));
            return jsonObject;
        }
        return null;
    }
}
