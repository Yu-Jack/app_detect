// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

class NoopDataLayerEventEvaluationInfoBuilder implements DataLayerEventEvaluationInfoBuilder
{
    @Override
    public ResolvedFunctionCallBuilder createAndAddResult() {
        return new NoopResolvedFunctionCallBuilder();
    }
    
    @Override
    public RuleEvaluationStepInfoBuilder createRulesEvaluation() {
        return new NoopRuleEvaluationStepInfoBuilder();
    }
}
