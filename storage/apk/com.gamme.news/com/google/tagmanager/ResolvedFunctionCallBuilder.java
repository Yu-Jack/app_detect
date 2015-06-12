// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;

interface ResolvedFunctionCallBuilder
{
    ResolvedPropertyBuilder createResolvedPropertyBuilder(String p0);
    
    void setFunctionResult(TypeSystem.Value p0);
}
