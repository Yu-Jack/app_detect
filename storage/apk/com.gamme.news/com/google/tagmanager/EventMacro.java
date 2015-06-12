// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;

class EventMacro extends FunctionCallImplementation
{
    private static final String ID;
    private final Runtime mRuntime;
    
    static {
        ID = FunctionType.EVENT.toString();
    }
    
    public EventMacro(final Runtime mRuntime) {
        super(EventMacro.ID, new String[0]);
        this.mRuntime = mRuntime;
    }
    
    public static String getFunctionId() {
        return EventMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        final String currentEventName = this.mRuntime.getCurrentEventName();
        if (currentEventName == null) {
            return Types.getDefaultValue();
        }
        return Types.objectToValue(currentEventName);
    }
    
    @Override
    public boolean isCacheable() {
        return false;
    }
}
