// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;

class StartsWithPredicate extends StringPredicate
{
    private static final String ID;
    
    static {
        ID = FunctionType.STARTS_WITH.toString();
    }
    
    public StartsWithPredicate() {
        super(StartsWithPredicate.ID);
    }
    
    public static String getFunctionId() {
        return StartsWithPredicate.ID;
    }
    
    @Override
    protected boolean evaluateString(final String s, final String prefix, final Map<String, TypeSystem.Value> map) {
        return s.startsWith(prefix);
    }
}
