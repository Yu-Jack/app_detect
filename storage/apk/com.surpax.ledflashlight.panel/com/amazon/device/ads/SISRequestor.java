// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

class SISRequestor
{
    protected static final String API_LEVEL_ENDPOINT = "/api3";
    private final SISRequestorCallback sisRequestorCallback;
    private final SISRequest[] sisRequests;
    
    public SISRequestor(final SISRequestorCallback sisRequestorCallback, final SISRequest... sisRequests) {
        this.sisRequestorCallback = sisRequestorCallback;
        this.sisRequests = sisRequests;
    }
    
    public SISRequestor(final SISRequest... array) {
        this((SISRequestorCallback)null, array);
    }
    
    protected static String getEndpoint(final SISRequest sisRequest) {
        String str = Configuration.getInstance().getString(Configuration$ConfigOption.SIS_URL);
        if (str != null) {
            final int index = str.indexOf("/");
            if (index >= 0) {
                str = str.substring(index);
            }
            else {
                str = "";
            }
        }
        return str + "/api3" + sisRequest.getPath();
    }
    
    protected static String getHostname() {
        String s = Configuration.getInstance().getString(Configuration$ConfigOption.SIS_URL);
        if (s != null) {
            final int index = s.indexOf("/");
            if (index >= 0) {
                s = s.substring(0, index);
            }
        }
        return s;
    }
    
    protected void callSIS() {
        final SISRequest[] sisRequests = this.sisRequests;
        for (int length = sisRequests.length, i = 0; i < length; ++i) {
            this.callSIS(sisRequests[i]);
        }
    }
    
    protected void callSIS(final SISRequest sisRequest) {
        final WebRequest webRequest = this.getWebRequest(sisRequest);
        try {
            final JSONObject jsonObjectBody = webRequest.makeCall().getJSONObjectBody();
            if (jsonObjectBody == null) {
                return;
            }
            final int integerFromJSON = JSONUtils.getIntegerFromJSON(jsonObjectBody, "rcode", 0);
            final String stringFromJSON = JSONUtils.getStringFromJSON(jsonObjectBody, "msg", "");
            if (integerFromJSON == 1) {
                Log.i(sisRequest.getLogTag(), "Result - code: %d, msg: %s", integerFromJSON, stringFromJSON);
                sisRequest.onResponseReceived(jsonObjectBody);
                return;
            }
            Log.w(sisRequest.getLogTag(), "Result - code: %d, msg: %s", integerFromJSON, stringFromJSON);
        }
        catch (WebRequest$WebRequestException ex) {}
    }
    
    protected SISRequestorCallback getSisRequestorCallback() {
        return this.sisRequestorCallback;
    }
    
    protected WebRequest getWebRequest(final SISRequest sisRequest) {
        final WebRequest newWebRequest = WebRequest.createNewWebRequest();
        newWebRequest.setExternalLogTag(sisRequest.getLogTag());
        newWebRequest.setHttpMethod(WebRequest$HttpMethod.POST);
        newWebRequest.setHost(getHostname());
        newWebRequest.setPath(getEndpoint(sisRequest));
        newWebRequest.enableLog(true);
        if (sisRequest.getPostParameters() != null) {
            for (final Map.Entry<String, V> entry : sisRequest.getPostParameters().entrySet()) {
                newWebRequest.putPostParameter(entry.getKey(), (String)entry.getValue());
            }
        }
        final WebRequest$QueryStringParameters queryParameters = sisRequest.getQueryParameters();
        queryParameters.putUrlEncoded("appId", InternalAdRegistration.getInstance().getRegistrationInfo().getAppKey());
        queryParameters.putUrlEncoded("sdkVer", Version.getSDKVersion());
        newWebRequest.setQueryStringParameters(queryParameters);
        newWebRequest.setMetricsCollector(Metrics.getInstance().getMetricsCollector());
        newWebRequest.setServiceCallLatencyMetric(sisRequest.getCallMetricType());
        return newWebRequest;
    }
    
    public void startCallSIS() {
        this.callSIS();
        final SISRequestorCallback sisRequestorCallback = this.getSisRequestorCallback();
        if (sisRequestorCallback != null) {
            sisRequestorCallback.onSISCallComplete();
        }
    }
}
