// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import com.google.analytics.containertag.common.FunctionType;

class ContainsPredicate extends StringPredicate
{
    private static final String ID;
    
    static {
        ID = FunctionType.CONTAINS.toString();
    }
    
    public ContainsPredicate() {
        super(ContainsPredicate.ID);
    }
    
    public static String getFunctionId() {
        return ContainsPredicate.ID;
    }
    
    @Override
    protected boolean evaluateString(final String s, final String s2, final Map<String, TypeSystem.Value> map) {
        return s.contains(s2);
    }
}
