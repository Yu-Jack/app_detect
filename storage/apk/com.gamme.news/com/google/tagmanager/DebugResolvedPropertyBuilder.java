// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.analytics.containertag.proto.Debug;

class DebugResolvedPropertyBuilder implements ResolvedPropertyBuilder
{
    private Debug.ResolvedProperty resolvedProperty;
    
    public DebugResolvedPropertyBuilder(final Debug.ResolvedProperty resolvedProperty) {
        this.resolvedProperty = resolvedProperty;
    }
    
    @Override
    public ValueBuilder createPropertyValueBuilder(final TypeSystem.Value value) {
        final TypeSystem.Value copyImmutableValue = DebugValueBuilder.copyImmutableValue(value);
        this.resolvedProperty.value = copyImmutableValue;
        return new DebugValueBuilder(copyImmutableValue);
    }
}
