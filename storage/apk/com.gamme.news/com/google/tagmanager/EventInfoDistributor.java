// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

interface EventInfoDistributor
{
    EventInfoBuilder createDataLayerEventEvaluationEventInfo(String p0);
    
    EventInfoBuilder createMacroEvalutionEventInfo(String p0);
    
    boolean debugMode();
}
