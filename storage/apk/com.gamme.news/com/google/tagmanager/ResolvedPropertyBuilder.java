// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;

interface ResolvedPropertyBuilder
{
    ValueBuilder createPropertyValueBuilder(TypeSystem.Value p0);
}