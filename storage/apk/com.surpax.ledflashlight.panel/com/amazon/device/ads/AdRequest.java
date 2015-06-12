// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import org.json.JSONObject;
import java.util.Iterator;
import org.json.JSONArray;
import java.util.HashMap;
import java.util.Map;

class AdRequest
{
    private static final String AAX_ENDPOINT = "/e/msdk/ads";
    private static final String LOG_TAG;
    private static final AAXParameter[] PARAMETERS;
    private AdvertisingIdentifier$Info advertisingIdentifierInfo;
    private final String connectionType;
    private String instrPixelUrl;
    private final AdRequest$JSONObjectBuilder jsonObjectBuilder;
    private final AdTargetingOptions opt;
    private final String orientation;
    private final Size screenSize;
    protected final Map slots;
    
    static {
        LOG_TAG = AdRequest.class.getSimpleName();
        PARAMETERS = new AAXParameter[] { AAXParameter.APP_KEY, AAXParameter.CHANNEL, AAXParameter.PUBLISHER_KEYWORDS, AAXParameter.PUBLISHER_ASINS, AAXParameter.USER_AGENT, AAXParameter.SDK_VERSION, AAXParameter.GEOLOCATION, AAXParameter.USER_INFO, AAXParameter.DEVICE_INFO, AAXParameter.PACKAGE_INFO, AAXParameter.TEST, AAXParameter.SIS_DEVICE_IDENTIFIER, AAXParameter.SHA1_UDID, AAXParameter.MD5_UDID, AAXParameter.ADVERTISING_IDENTIFIER, AAXParameter.OPT_OUT };
    }
    
    AdRequest(final AdTargetingOptions opt) {
        this.opt = opt;
        this.slots = new HashMap();
        final DeviceInfo deviceInfo = InternalAdRegistration.getInstance().getDeviceInfo();
        this.orientation = deviceInfo.getOrientation();
        this.screenSize = deviceInfo.getScreenSize(this.orientation);
        this.connectionType = deviceInfo.getConnectionType();
        final HashMap copyOfAdvancedOptions = this.opt.getCopyOfAdvancedOptions();
        this.jsonObjectBuilder = new AdRequest$JSONObjectBuilder().setAAXParameters(AdRequest.PARAMETERS).setAdvancedOptions(copyOfAdvancedOptions).setParameterData(new AAXParameter$ParameterData().setAdvancedOptions(copyOfAdvancedOptions).setAdRequest(this));
    }
    
    AdTargetingOptions getAdTargetingOptions() {
        return this.opt;
    }
    
    AdvertisingIdentifier$Info getAdvertisingIdentifierInfo() {
        return this.advertisingIdentifierInfo;
    }
    
    public String getInstrumentationPixelURL() {
        return this.instrPixelUrl;
    }
    
    String getOrientation() {
        return this.orientation;
    }
    
    protected JSONArray getSlots() {
        final JSONArray jsonArray = new JSONArray();
        final Iterator<AdRequest$LOISlot> iterator = this.slots.values().iterator();
        while (iterator.hasNext()) {
            jsonArray.put((Object)iterator.next().getJSON());
        }
        return jsonArray;
    }
    
    public WebRequest getWebRequest() {
        final WebRequest newWebRequest = WebRequest.createNewWebRequest();
        newWebRequest.setExternalLogTag(AdRequest.LOG_TAG);
        newWebRequest.setHttpMethod(WebRequest$HttpMethod.POST);
        newWebRequest.setHost(Configuration.getInstance().getString(Configuration$ConfigOption.AAX_HOSTNAME));
        newWebRequest.setPath("/e/msdk/ads");
        newWebRequest.enableLog(true);
        newWebRequest.setContentType("application/json");
        this.setParametersInWebRequest(newWebRequest);
        return newWebRequest;
    }
    
    public void putSlot(final AdData adData, final AdTargetingOptions adTargetingOptions) {
        adData.setConnectionType(this.connectionType);
        adData.setScreenHeight(this.screenSize.getHeight());
        adData.setScreenWidth(this.screenSize.getWidth());
        if (this.getAdvertisingIdentifierInfo().hasSISDeviceIdentifier()) {
            adData.getMetricsCollector().incrementMetric(Metrics$MetricType.AD_COUNTER_IDENTIFIED_DEVICE);
        }
        final AdRequest$LOISlot adRequest$LOISlot = new AdRequest$LOISlot(adData, adTargetingOptions, this);
        this.slots.put(adRequest$LOISlot.getAdData().getSlotId(), adRequest$LOISlot);
    }
    
    AdRequest setAdvertisingIdentifierInfo(final AdvertisingIdentifier$Info advertisingIdentifierInfo) {
        this.advertisingIdentifierInfo = advertisingIdentifierInfo;
        return this;
    }
    
    public void setInstrumentationPixelURL(final String instrPixelUrl) {
        this.instrPixelUrl = instrPixelUrl;
    }
    
    protected void setParametersInWebRequest(final WebRequest webRequest) {
        this.jsonObjectBuilder.build();
        Object o = AAXParameter.SLOTS.getValue(this.jsonObjectBuilder.getParameterData());
        if (o == null) {
            o = this.getSlots();
        }
        this.jsonObjectBuilder.putIntoJSON(AAXParameter.SLOTS, o);
        final JSONObject json = this.jsonObjectBuilder.getJSON();
        final String debugPropertyAsString = DebugProperties.getDebugPropertyAsString("debug.aaxAdParams", null);
        if (!Utils.isNullOrEmpty(debugPropertyAsString)) {
            webRequest.setAdditionalQueryParamsString(debugPropertyAsString);
        }
        this.setRequestBodyString(webRequest, json);
    }
    
    protected void setRequestBodyString(final WebRequest webRequest, final JSONObject jsonObject) {
        webRequest.setRequestBodyString(jsonObject.toString());
    }
}
