// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.List;
import com.google.analytics.midtier.proto.containertag.TypeSystem;

class NoopResolvedRuleBuilder implements ResolvedRuleBuilder
{
    @Override
    public ResolvedFunctionCallBuilder createNegativePredicate() {
        return new NoopResolvedFunctionCallBuilder();
    }
    
    @Override
    public ResolvedFunctionCallBuilder createPositivePredicate() {
        return new NoopResolvedFunctionCallBuilder();
    }
    
    @Override
    public ResolvedFunctionCallTranslatorList getAddedMacroFunctions() {
        return new NoopResolvedFunctionCallTranslatorList();
    }
    
    @Override
    public ResolvedFunctionCallTranslatorList getAddedTagFunctions() {
        return new NoopResolvedFunctionCallTranslatorList();
    }
    
    @Override
    public ResolvedFunctionCallTranslatorList getRemovedMacroFunctions() {
        return new NoopResolvedFunctionCallTranslatorList();
    }
    
    @Override
    public ResolvedFunctionCallTranslatorList getRemovedTagFunctions() {
        return new NoopResolvedFunctionCallTranslatorList();
    }
    
    @Override
    public void setValue(final TypeSystem.Value value) {
    }
    
    public class NoopResolvedFunctionCallTranslatorList implements ResolvedFunctionCallTranslatorList
    {
        @Override
        public void translateAndAddAll(final List<ResourceUtil.ExpandedFunctionCall> list, final List<String> list2) {
        }
    }
}
