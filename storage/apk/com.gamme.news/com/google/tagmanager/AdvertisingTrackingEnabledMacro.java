// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;

class AdvertisingTrackingEnabledMacro extends FunctionCallImplementation
{
    private static final String ID;
    
    static {
        ID = FunctionType.ADVERTISING_TRACKING_ENABLED.toString();
    }
    
    public AdvertisingTrackingEnabledMacro() {
        super(AdvertisingTrackingEnabledMacro.ID, new String[0]);
    }
    
    public static String getFunctionId() {
        return AdvertisingTrackingEnabledMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        return Types.objectToValue(true);
    }
    
    @Override
    public boolean isCacheable() {
        return true;
    }
}
