// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;

class TimeMacro extends FunctionCallImplementation
{
    private static final String ID;
    
    static {
        ID = FunctionType.TIME.toString();
    }
    
    public TimeMacro() {
        super(TimeMacro.ID, new String[0]);
    }
    
    public static String getFunctionId() {
        return TimeMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        return Types.objectToValue(System.currentTimeMillis());
    }
    
    @Override
    public boolean isCacheable() {
        return false;
    }
}
