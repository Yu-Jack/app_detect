// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import org.json.JSONObject;

class AAXParameter$PackageInfoParameter extends AAXParameter$JSONObjectParameter
{
    AAXParameter$PackageInfoParameter() {
        super("pkg", "debug.pkg");
    }
    
    @Override
    protected JSONObject getDerivedValue(final AAXParameter$ParameterData aaxParameter$ParameterData) {
        return InternalAdRegistration.getInstance().getAppInfo().getPackageInfoJSON();
    }
}
