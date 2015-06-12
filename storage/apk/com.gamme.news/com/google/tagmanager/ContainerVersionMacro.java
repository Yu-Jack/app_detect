// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;

class ContainerVersionMacro extends FunctionCallImplementation
{
    private static final String ID;
    private final Runtime mRuntime;
    
    static {
        ID = FunctionType.CONTAINER_VERSION.toString();
    }
    
    public ContainerVersionMacro(final Runtime mRuntime) {
        super(ContainerVersionMacro.ID, new String[0]);
        this.mRuntime = mRuntime;
    }
    
    public static String getFunctionId() {
        return ContainerVersionMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        final String version = this.mRuntime.getResource().getVersion();
        if (version == null) {
            return Types.getDefaultValue();
        }
        return Types.objectToValue(version);
    }
    
    @Override
    public boolean isCacheable() {
        return true;
    }
}
