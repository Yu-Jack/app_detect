// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.Set;

interface RuleEvaluationStepInfoBuilder
{
    ResolvedRuleBuilder createResolvedRuleBuilder();
    
    void setEnabledFunctions(Set<ResourceUtil.ExpandedFunctionCall> p0);
}
