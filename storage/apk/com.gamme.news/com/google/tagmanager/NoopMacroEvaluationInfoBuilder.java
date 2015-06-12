// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

class NoopMacroEvaluationInfoBuilder implements MacroEvaluationInfoBuilder
{
    @Override
    public ResolvedFunctionCallBuilder createResult() {
        return new NoopResolvedFunctionCallBuilder();
    }
    
    @Override
    public RuleEvaluationStepInfoBuilder createRulesEvaluation() {
        return new NoopRuleEvaluationStepInfoBuilder();
    }
}
