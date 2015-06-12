// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;

class EndsWithPredicate extends StringPredicate
{
    private static final String ID;
    
    static {
        ID = FunctionType.ENDS_WITH.toString();
    }
    
    public EndsWithPredicate() {
        super(EndsWithPredicate.ID);
    }
    
    public static String getFunctionId() {
        return EndsWithPredicate.ID;
    }
    
    @Override
    protected boolean evaluateString(final String s, final String suffix, final Map<String, TypeSystem.Value> map) {
        return s.endsWith(suffix);
    }
}
