// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

class DebugEventInfoDistributor implements EventInfoDistributor
{
    private String containerId;
    private String containerVersion;
    private DebugInformationHandler handler;
    
    public DebugEventInfoDistributor(final DebugInformationHandler handler, final String containerVersion, final String containerId) {
        this.handler = handler;
        this.containerVersion = containerVersion;
        this.containerId = containerId;
    }
    
    @Override
    public EventInfoBuilder createDataLayerEventEvaluationEventInfo(final String s) {
        return new DebugEventInfoBuilder(1, this.containerVersion, this.containerId, s, this.handler);
    }
    
    @Override
    public EventInfoBuilder createMacroEvalutionEventInfo(final String s) {
        return new DebugEventInfoBuilder(2, this.containerVersion, this.containerId, s, this.handler);
    }
    
    @Override
    public boolean debugMode() {
        return true;
    }
}
