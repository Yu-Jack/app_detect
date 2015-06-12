// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;

class GtmVersionMacro extends FunctionCallImplementation
{
    private static final String ID;
    
    static {
        ID = FunctionType.GTM_VERSION.toString();
    }
    
    public GtmVersionMacro() {
        super(GtmVersionMacro.ID, new String[0]);
    }
    
    public static String getFunctionId() {
        return GtmVersionMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        return Types.objectToValue("3.02");
    }
    
    @Override
    public boolean isCacheable() {
        return true;
    }
}
