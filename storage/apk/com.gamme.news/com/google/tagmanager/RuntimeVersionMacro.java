// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;

class RuntimeVersionMacro extends FunctionCallImplementation
{
    private static final String ID;
    public static final long VERSION_NUMBER = 62676326L;
    
    static {
        ID = FunctionType.RUNTIME_VERSION.toString();
    }
    
    public RuntimeVersionMacro() {
        super(RuntimeVersionMacro.ID, new String[0]);
    }
    
    public static String getFunctionId() {
        return RuntimeVersionMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        return Types.objectToValue(62676326L);
    }
    
    @Override
    public boolean isCacheable() {
        return true;
    }
}
