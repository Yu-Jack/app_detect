// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.Map;
import com.google.analytics.midtier.proto.containertag.TypeSystem;

abstract class NumberPredicate extends Predicate
{
    public NumberPredicate(final String s) {
        super(s);
    }
    
    @Override
    protected boolean evaluateNoDefaultValues(final TypeSystem.Value value, final TypeSystem.Value value2, final Map<String, TypeSystem.Value> map) {
        final TypedNumber valueToNumber = Types.valueToNumber(value);
        final TypedNumber valueToNumber2 = Types.valueToNumber(value2);
        return valueToNumber != Types.getDefaultNumber() && valueToNumber2 != Types.getDefaultNumber() && this.evaluateNumber(valueToNumber, valueToNumber2, map);
    }
    
    protected abstract boolean evaluateNumber(final TypedNumber p0, final TypedNumber p1, final Map<String, TypeSystem.Value> p2);
}
