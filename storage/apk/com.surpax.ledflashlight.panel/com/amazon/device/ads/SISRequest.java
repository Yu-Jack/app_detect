// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import org.json.JSONObject;
import java.util.HashMap;

interface SISRequest
{
    Metrics$MetricType getCallMetricType();
    
    String getLogTag();
    
    String getPath();
    
    HashMap getPostParameters();
    
    WebRequest$QueryStringParameters getQueryParameters();
    
    void onResponseReceived(JSONObject p0);
}
