// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.os.Build$VERSION;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;

class OsVersionMacro extends FunctionCallImplementation
{
    private static final String ID;
    
    static {
        ID = FunctionType.OS_VERSION.toString();
    }
    
    public OsVersionMacro() {
        super(OsVersionMacro.ID, new String[0]);
    }
    
    public static String getFunctionId() {
        return OsVersionMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        return Types.objectToValue(Build$VERSION.RELEASE);
    }
    
    @Override
    public boolean isCacheable() {
        return true;
    }
}
