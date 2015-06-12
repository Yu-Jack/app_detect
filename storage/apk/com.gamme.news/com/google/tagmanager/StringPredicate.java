// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.Map;
import com.google.analytics.midtier.proto.containertag.TypeSystem;

abstract class StringPredicate extends Predicate
{
    public StringPredicate(final String s) {
        super(s);
    }
    
    @Override
    protected boolean evaluateNoDefaultValues(final TypeSystem.Value value, final TypeSystem.Value value2, final Map<String, TypeSystem.Value> map) {
        final String valueToString = Types.valueToString(value);
        final String valueToString2 = Types.valueToString(value2);
        return valueToString != Types.getDefaultString() && valueToString2 != Types.getDefaultString() && this.evaluateString(valueToString, valueToString2, map);
    }
    
    protected abstract boolean evaluateString(final String p0, final String p1, final Map<String, TypeSystem.Value> p2);
}
