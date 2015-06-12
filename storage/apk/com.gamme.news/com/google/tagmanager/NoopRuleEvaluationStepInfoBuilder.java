// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.Set;

class NoopRuleEvaluationStepInfoBuilder implements RuleEvaluationStepInfoBuilder
{
    @Override
    public ResolvedRuleBuilder createResolvedRuleBuilder() {
        return new NoopResolvedRuleBuilder();
    }
    
    @Override
    public void setEnabledFunctions(final Set<ResourceUtil.ExpandedFunctionCall> set) {
    }
}
