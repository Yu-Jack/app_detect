// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.Iterator;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.Key;

abstract class Predicate extends FunctionCallImplementation
{
    private static final String ARG0;
    private static final String ARG1;
    
    static {
        ARG0 = Key.ARG0.toString();
        ARG1 = Key.ARG1.toString();
    }
    
    public Predicate(final String s) {
        super(s, new String[] { Predicate.ARG0, Predicate.ARG1 });
    }
    
    public static String getArg0Key() {
        return Predicate.ARG0;
    }
    
    public static String getArg1Key() {
        return Predicate.ARG1;
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        final Iterator<TypeSystem.Value> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == Types.getDefaultValue()) {
                return Types.objectToValue(false);
            }
        }
        final TypeSystem.Value value = map.get(Predicate.ARG0);
        final TypeSystem.Value value2 = map.get(Predicate.ARG1);
        boolean evaluateNoDefaultValues = false;
        if (value != null) {
            evaluateNoDefaultValues = false;
            if (value2 != null) {
                evaluateNoDefaultValues = this.evaluateNoDefaultValues(value, value2, map);
            }
        }
        return Types.objectToValue(evaluateNoDefaultValues);
    }
    
    protected abstract boolean evaluateNoDefaultValues(final TypeSystem.Value p0, final TypeSystem.Value p1, final Map<String, TypeSystem.Value> p2);
    
    @Override
    public boolean isCacheable() {
        return true;
    }
}
