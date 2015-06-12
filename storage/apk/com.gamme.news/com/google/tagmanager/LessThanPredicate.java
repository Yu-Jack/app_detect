// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;

class LessThanPredicate extends NumberPredicate
{
    private static final String ID;
    
    static {
        ID = FunctionType.LESS_THAN.toString();
    }
    
    public LessThanPredicate() {
        super(LessThanPredicate.ID);
    }
    
    public static String getFunctionId() {
        return LessThanPredicate.ID;
    }
    
    @Override
    protected boolean evaluateNumber(final TypedNumber typedNumber, final TypedNumber typedNumber2, final Map<String, TypeSystem.Value> map) {
        return typedNumber.compareTo(typedNumber2) < 0;
    }
}
