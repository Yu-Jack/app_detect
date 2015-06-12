// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug;

class DebugDataLayerEventEvaluationInfoBuilder implements DataLayerEventEvaluationInfoBuilder
{
    private Debug.DataLayerEventEvaluationInfo dataLayerEvent;
    
    public DebugDataLayerEventEvaluationInfoBuilder(final Debug.DataLayerEventEvaluationInfo dataLayerEvent) {
        this.dataLayerEvent = dataLayerEvent;
    }
    
    @Override
    public ResolvedFunctionCallBuilder createAndAddResult() {
        final Debug.ResolvedFunctionCall resolvedFunctionCall = new Debug.ResolvedFunctionCall();
        this.dataLayerEvent.results = ArrayUtils.appendToArray(this.dataLayerEvent.results, resolvedFunctionCall);
        return new DebugResolvedFunctionCallBuilder(resolvedFunctionCall);
    }
    
    @Override
    public RuleEvaluationStepInfoBuilder createRulesEvaluation() {
        this.dataLayerEvent.rulesEvaluation = new Debug.RuleEvaluationStepInfo();
        return new DebugRuleEvaluationStepInfoBuilder(this.dataLayerEvent.rulesEvaluation);
    }
}
