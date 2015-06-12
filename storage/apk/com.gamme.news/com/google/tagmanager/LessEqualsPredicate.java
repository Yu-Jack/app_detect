// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;

class LessEqualsPredicate extends NumberPredicate
{
    private static final String ID;
    
    static {
        ID = FunctionType.LESS_EQUALS.toString();
    }
    
    public LessEqualsPredicate() {
        super(LessEqualsPredicate.ID);
    }
    
    public static String getFunctionId() {
        return LessEqualsPredicate.ID;
    }
    
    @Override
    protected boolean evaluateNumber(final TypedNumber typedNumber, final TypedNumber typedNumber2, final Map<String, TypeSystem.Value> map) {
        return typedNumber.compareTo(typedNumber2) <= 0;
    }
}
