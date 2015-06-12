// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;

class EqualsPredicate extends StringPredicate
{
    private static final String ID;
    
    static {
        ID = FunctionType.EQUALS.toString();
    }
    
    public EqualsPredicate() {
        super(EqualsPredicate.ID);
    }
    
    public static String getFunctionId() {
        return EqualsPredicate.ID;
    }
    
    @Override
    protected boolean evaluateString(final String s, final String anObject, final Map<String, TypeSystem.Value> map) {
        return s.equals(anObject);
    }
}
