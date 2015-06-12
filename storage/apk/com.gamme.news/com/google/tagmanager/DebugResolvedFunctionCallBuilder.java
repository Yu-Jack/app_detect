// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.analytics.containertag.proto.Debug;

class DebugResolvedFunctionCallBuilder implements ResolvedFunctionCallBuilder
{
    private Debug.ResolvedFunctionCall resolvedFunctionCall;
    
    public DebugResolvedFunctionCallBuilder(final Debug.ResolvedFunctionCall resolvedFunctionCall) {
        this.resolvedFunctionCall = resolvedFunctionCall;
    }
    
    @Override
    public ResolvedPropertyBuilder createResolvedPropertyBuilder(final String key) {
        final Debug.ResolvedProperty resolvedProperty = new Debug.ResolvedProperty();
        resolvedProperty.key = key;
        this.resolvedFunctionCall.properties = ArrayUtils.appendToArray(this.resolvedFunctionCall.properties, resolvedProperty);
        return new DebugResolvedPropertyBuilder(resolvedProperty);
    }
    
    @Override
    public void setFunctionResult(final TypeSystem.Value value) {
        this.resolvedFunctionCall.result = DebugValueBuilder.copyImmutableValue(value);
    }
}
