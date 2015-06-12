// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.os.Build$VERSION;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;

class SdkVersionMacro extends FunctionCallImplementation
{
    private static final String ID;
    
    static {
        ID = FunctionType.SDK_VERSION.toString();
    }
    
    public SdkVersionMacro() {
        super(SdkVersionMacro.ID, new String[0]);
    }
    
    public static String getFunctionId() {
        return SdkVersionMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        return Types.objectToValue(Build$VERSION.SDK_INT);
    }
    
    @Override
    public boolean isCacheable() {
        return true;
    }
}
