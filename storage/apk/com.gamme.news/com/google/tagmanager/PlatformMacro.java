// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;

class PlatformMacro extends FunctionCallImplementation
{
    private static final String ID;
    private static final TypeSystem.Value PLATFORM;
    
    static {
        ID = FunctionType.PLATFORM.toString();
        PLATFORM = Types.objectToValue("Android");
    }
    
    public PlatformMacro() {
        super(PlatformMacro.ID, new String[0]);
    }
    
    public static String getFunctionId() {
        return PlatformMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        return PlatformMacro.PLATFORM;
    }
    
    @Override
    public boolean isCacheable() {
        return true;
    }
}
