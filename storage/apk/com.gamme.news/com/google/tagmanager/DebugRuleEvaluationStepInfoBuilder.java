// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.Iterator;
import java.util.Set;
import com.google.analytics.containertag.proto.Debug;

class DebugRuleEvaluationStepInfoBuilder implements RuleEvaluationStepInfoBuilder
{
    private Debug.RuleEvaluationStepInfo ruleEvaluationStepInfo;
    
    public DebugRuleEvaluationStepInfoBuilder(final Debug.RuleEvaluationStepInfo ruleEvaluationStepInfo) {
        this.ruleEvaluationStepInfo = ruleEvaluationStepInfo;
    }
    
    @Override
    public ResolvedRuleBuilder createResolvedRuleBuilder() {
        final Debug.ResolvedRule resolvedRule = new Debug.ResolvedRule();
        this.ruleEvaluationStepInfo.rules = ArrayUtils.appendToArray(this.ruleEvaluationStepInfo.rules, resolvedRule);
        return new DebugResolvedRuleBuilder(resolvedRule);
    }
    
    @Override
    public void setEnabledFunctions(final Set<ResourceUtil.ExpandedFunctionCall> set) {
        final Iterator<ResourceUtil.ExpandedFunctionCall> iterator = set.iterator();
        while (iterator.hasNext()) {
            this.ruleEvaluationStepInfo.enabledFunctions = ArrayUtils.appendToArray(this.ruleEvaluationStepInfo.enabledFunctions, DebugResolvedRuleBuilder.translateExpandedFunctionCall(iterator.next()));
        }
    }
}
