// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

class NoopEventInfoDistributor implements EventInfoDistributor
{
    @Override
    public EventInfoBuilder createDataLayerEventEvaluationEventInfo(final String s) {
        return new NoopEventInfoBuilder();
    }
    
    @Override
    public EventInfoBuilder createMacroEvalutionEventInfo(final String s) {
        return new NoopEventInfoBuilder();
    }
    
    @Override
    public boolean debugMode() {
        return false;
    }
}
