// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug;

class DebugMacroEvaluationInfoBuilder implements MacroEvaluationInfoBuilder
{
    private Debug.MacroEvaluationInfo macroEvaluationInfo;
    
    public DebugMacroEvaluationInfoBuilder(final Debug.MacroEvaluationInfo macroEvaluationInfo) {
        this.macroEvaluationInfo = macroEvaluationInfo;
    }
    
    @Override
    public ResolvedFunctionCallBuilder createResult() {
        this.macroEvaluationInfo.result = new Debug.ResolvedFunctionCall();
        return new DebugResolvedFunctionCallBuilder(this.macroEvaluationInfo.result);
    }
    
    @Override
    public RuleEvaluationStepInfoBuilder createRulesEvaluation() {
        this.macroEvaluationInfo.rulesEvaluation = new Debug.RuleEvaluationStepInfo();
        return new DebugRuleEvaluationStepInfoBuilder(this.macroEvaluationInfo.rulesEvaluation);
    }
}
