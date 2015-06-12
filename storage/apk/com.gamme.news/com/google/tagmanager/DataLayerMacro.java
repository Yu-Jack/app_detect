// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.containertag.common.FunctionType;

class DataLayerMacro extends FunctionCallImplementation
{
    private static final String DEFAULT_VALUE;
    private static final String ID;
    private static final String NAME;
    private final DataLayer mDataLayer;
    
    static {
        ID = FunctionType.CUSTOM_VAR.toString();
        NAME = Key.NAME.toString();
        DEFAULT_VALUE = Key.DEFAULT_VALUE.toString();
    }
    
    public DataLayerMacro(final DataLayer mDataLayer) {
        super(DataLayerMacro.ID, new String[] { DataLayerMacro.NAME });
        this.mDataLayer = mDataLayer;
    }
    
    public static String getDefaultValueKey() {
        return DataLayerMacro.DEFAULT_VALUE;
    }
    
    public static String getFunctionId() {
        return DataLayerMacro.ID;
    }
    
    public static String getNameKey() {
        return DataLayerMacro.NAME;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        final Object value = this.mDataLayer.get(Types.valueToString(map.get(DataLayerMacro.NAME)));
        if (value != null) {
            return Types.objectToValue(value);
        }
        final TypeSystem.Value value2 = map.get(DataLayerMacro.DEFAULT_VALUE);
        if (value2 != null) {
            return value2;
        }
        return Types.getDefaultValue();
    }
    
    @Override
    public boolean isCacheable() {
        return false;
    }
}
