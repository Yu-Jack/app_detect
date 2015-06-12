// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.Map;

abstract class TrackingTag extends FunctionCallImplementation
{
    public TrackingTag(final String s, final String... array) {
        super(s, array);
    }
    
    @Override
    public TypeSystem.Value evaluate(final Map<String, TypeSystem.Value> map) {
        this.evaluateTrackingTag(map);
        return Types.getDefaultValue();
    }
    
    public abstract void evaluateTrackingTag(final Map<String, TypeSystem.Value> p0);
    
    @Override
    public boolean isCacheable() {
        return false;
    }
}
