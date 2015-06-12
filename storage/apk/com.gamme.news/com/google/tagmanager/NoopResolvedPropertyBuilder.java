// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;

class NoopResolvedPropertyBuilder implements ResolvedPropertyBuilder
{
    @Override
    public ValueBuilder createPropertyValueBuilder(final TypeSystem.Value value) {
        return new NoopValueBuilder();
    }
}
