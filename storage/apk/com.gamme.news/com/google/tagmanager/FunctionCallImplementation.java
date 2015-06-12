// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.Collection;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

abstract class FunctionCallImplementation
{
    private static final String FUNCTION_KEY = "function";
    private final String mFunctionId;
    private final Set<String> mRequiredKeys;
    
    public FunctionCallImplementation(final String mFunctionId, final String... array) {
        this.mFunctionId = mFunctionId;
        this.mRequiredKeys = new HashSet<String>(array.length);
        for (int length = array.length, i = 0; i < length; ++i) {
            this.mRequiredKeys.add(array[i]);
        }
    }
    
    public static String getFunctionKey() {
        return "function";
    }
    
    public abstract TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> p0);
    
    public String getInstanceFunctionId() {
        return this.mFunctionId;
    }
    
    public Set<String> getRequiredKeys() {
        return this.mRequiredKeys;
    }
    
    boolean hasRequiredKeys(final Set<String> set) {
        return set.containsAll(this.mRequiredKeys);
    }
    
    public abstract boolean isCacheable();
}
