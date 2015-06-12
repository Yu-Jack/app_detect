// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.containertag.common.FunctionType;

class RandomMacro extends FunctionCallImplementation
{
    private static final String ID;
    private static final String MAX;
    private static final String MIN;
    
    static {
        ID = FunctionType.RANDOM.toString();
        MIN = Key.MIN.toString();
        MAX = Key.MAX.toString();
    }
    
    public RandomMacro() {
        super(RandomMacro.ID, new String[0]);
    }
    
    public static String getFunctionId() {
        return RandomMacro.ID;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        double n = 0.0;
        double n2 = 2.147483647E9;
        final TypeSystem.Value value = map.get(RandomMacro.MIN);
        final TypeSystem.Value value2 = map.get(RandomMacro.MAX);
        if (value != null && value != Types.getDefaultValue() && value2 != null && value2 != Types.getDefaultValue()) {
            final TypedNumber valueToNumber = Types.valueToNumber(value);
            final TypedNumber valueToNumber2 = Types.valueToNumber(value2);
            if (valueToNumber != Types.getDefaultNumber() && valueToNumber2 != Types.getDefaultNumber()) {
                final double doubleValue = valueToNumber.doubleValue();
                final double doubleValue2 = valueToNumber2.doubleValue();
                if (doubleValue <= doubleValue2) {
                    n = doubleValue;
                    n2 = doubleValue2;
                }
            }
        }
        return Types.objectToValue(Math.round(n + Math.random() * (n2 - n)));
    }
    
    @Override
    public boolean isCacheable() {
        return false;
    }
}
