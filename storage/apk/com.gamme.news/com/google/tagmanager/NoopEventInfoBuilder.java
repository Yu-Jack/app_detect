// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

class NoopEventInfoBuilder implements EventInfoBuilder
{
    @Override
    public DataLayerEventEvaluationInfoBuilder createDataLayerEventEvaluationInfoBuilder() {
        return new NoopDataLayerEventEvaluationInfoBuilder();
    }
    
    @Override
    public MacroEvaluationInfoBuilder createMacroEvaluationInfoBuilder() {
        return new NoopMacroEvaluationInfoBuilder();
    }
    
    @Override
    public void processEventInfo() {
    }
}
