// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;

interface ResolvedRuleBuilder
{
    ResolvedFunctionCallBuilder createNegativePredicate();
    
    ResolvedFunctionCallBuilder createPositivePredicate();
    
    ResolvedFunctionCallTranslatorList getAddedMacroFunctions();
    
    ResolvedFunctionCallTranslatorList getAddedTagFunctions();
    
    ResolvedFunctionCallTranslatorList getRemovedMacroFunctions();
    
    ResolvedFunctionCallTranslatorList getRemovedTagFunctions();
    
    void setValue(TypeSystem.Value p0);
}
