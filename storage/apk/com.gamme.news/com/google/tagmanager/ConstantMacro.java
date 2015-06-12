// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.containertag.common.FunctionType;

class ConstantMacro extends FunctionCallImplementation
{
    private static final String ID;
    private static final String VALUE;
    
    static {
        ID = FunctionType.CONSTANT.toString();
        VALUE = Key.VALUE.toString();
    }
    
    public ConstantMacro() {
        super(ConstantMacro.ID, new String[] { ConstantMacro.VALUE });
    }
    
    public static String getFunctionId() {
        return ConstantMacro.ID;
    }
    
    public static String getValueKey() {
        return ConstantMacro.VALUE;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        return map.get(ConstantMacro.VALUE);
    }
    
    @Override
    public boolean isCacheable() {
        return true;
    }
}
