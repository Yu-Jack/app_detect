// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.analytics.containertag.proto.Debug;

class DebugEventInfoBuilder implements EventInfoBuilder
{
    private DebugDataLayerEventEvaluationInfoBuilder dataLayerEventBuilder;
    @VisibleForTesting
    Debug.EventInfo eventInfoBuilder;
    private DebugInformationHandler handler;
    private DebugMacroEvaluationInfoBuilder macroBuilder;
    
    public DebugEventInfoBuilder(final int eventType, final String containerVersion, final String containerId, final String key, final DebugInformationHandler handler) {
        this.eventInfoBuilder = new Debug.EventInfo();
        this.eventInfoBuilder.eventType = eventType;
        this.eventInfoBuilder.containerVersion = containerVersion;
        this.eventInfoBuilder.containerId = containerId;
        this.eventInfoBuilder.key = key;
        this.handler = handler;
        if (eventType == 1) {
            this.eventInfoBuilder.dataLayerEventResult = new Debug.DataLayerEventEvaluationInfo();
            this.dataLayerEventBuilder = new DebugDataLayerEventEvaluationInfoBuilder(this.eventInfoBuilder.dataLayerEventResult);
            return;
        }
        this.eventInfoBuilder.macroResult = new Debug.MacroEvaluationInfo();
        this.macroBuilder = new DebugMacroEvaluationInfoBuilder(this.eventInfoBuilder.macroResult);
    }
    
    @Override
    public DataLayerEventEvaluationInfoBuilder createDataLayerEventEvaluationInfoBuilder() {
        return this.dataLayerEventBuilder;
    }
    
    @Override
    public MacroEvaluationInfoBuilder createMacroEvaluationInfoBuilder() {
        return this.macroBuilder;
    }
    
    @Override
    public void processEventInfo() {
        this.handler.receiveEventInfo(this.eventInfoBuilder);
    }
}
