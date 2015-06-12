// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;

class NoopResolvedFunctionCallBuilder implements ResolvedFunctionCallBuilder
{
    @Override
    public ResolvedPropertyBuilder createResolvedPropertyBuilder(final String s) {
        return new NoopResolvedPropertyBuilder();
    }
    
    @Override
    public void setFunctionResult(final TypeSystem.Value value) {
    }
}
