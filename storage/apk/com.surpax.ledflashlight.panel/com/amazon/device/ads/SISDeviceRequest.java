// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.HashMap;

abstract class SISDeviceRequest implements SISRequest
{
    private AdvertisingIdentifier$Info advertisingIdentifierInfo;
    private Metrics$MetricType callMetricType;
    private String logTag;
    private String path;
    
    private static String convertOptOutBooleanToStringInt(final boolean b) {
        if (b) {
            return "1";
        }
        return "0";
    }
    
    public static String getDInfoProperty() {
        return String.format("{\"make\":\"%s\",\"model\":\"%s\",\"os\":\"%s\",\"osVersion\":\"%s\"}", DeviceInfo.getMake(), DeviceInfo.getModel(), DeviceInfo.getOS(), DeviceInfo.getOSVersion());
    }
    
    protected AdvertisingIdentifier$Info getAdvertisingIdentifierInfo() {
        return this.advertisingIdentifierInfo;
    }
    
    @Override
    public Metrics$MetricType getCallMetricType() {
        return this.callMetricType;
    }
    
    @Override
    public String getLogTag() {
        return this.logTag;
    }
    
    @Override
    public String getPath() {
        return this.path;
    }
    
    @Override
    public HashMap getPostParameters() {
        return null;
    }
    
    @Override
    public WebRequest$QueryStringParameters getQueryParameters() {
        final WebRequest$QueryStringParameters webRequest$QueryStringParameters = new WebRequest$QueryStringParameters();
        webRequest$QueryStringParameters.putUrlEncoded("dt", DeviceInfo.getDeviceType());
        webRequest$QueryStringParameters.putUrlEncoded("app", InternalAdRegistration.getInstance().getRegistrationInfo().getAppName());
        webRequest$QueryStringParameters.putUrlEncoded("aud", Configuration.getInstance().getString(Configuration$ConfigOption.SIS_DOMAIN));
        webRequest$QueryStringParameters.putUrlEncoded("ua", Utils.getURLEncodedString(DeviceInfo.getUserAgentString()));
        webRequest$QueryStringParameters.putUrlEncoded("dinfo", Utils.getURLEncodedString(getDInfoProperty()));
        webRequest$QueryStringParameters.putUrlEncoded("pkg", Utils.getURLEncodedString(InternalAdRegistration.getInstance().getAppInfo().getPackageInfoJSONString()));
        if (this.advertisingIdentifierInfo.hasAdvertisingIdentifier()) {
            webRequest$QueryStringParameters.putUrlEncoded("idfa", this.advertisingIdentifierInfo.getAdvertisingIdentifier());
            webRequest$QueryStringParameters.putUrlEncoded("oo", convertOptOutBooleanToStringInt(this.advertisingIdentifierInfo.isLimitAdTrackingEnabled()));
        }
        else {
            final DeviceInfo deviceInfo = InternalAdRegistration.getInstance().getDeviceInfo();
            webRequest$QueryStringParameters.putUrlEncoded("sha1_mac", deviceInfo.getMacSha1());
            webRequest$QueryStringParameters.putUrlEncoded("sha1_serial", deviceInfo.getSerialSha1());
            webRequest$QueryStringParameters.putUrlEncoded("sha1_udid", deviceInfo.getUdidSha1());
            webRequest$QueryStringParameters.putUrlEncodedIfTrue("badMac", "true", deviceInfo.isMacBad());
            webRequest$QueryStringParameters.putUrlEncodedIfTrue("badSerial", "true", deviceInfo.isSerialBad());
            webRequest$QueryStringParameters.putUrlEncodedIfTrue("badUdid", "true", deviceInfo.isUdidBad());
        }
        final String andClearTransition = AdvertisingIdentifier.getAndClearTransition();
        webRequest$QueryStringParameters.putUrlEncodedIfTrue("aidts", andClearTransition, andClearTransition != null);
        return webRequest$QueryStringParameters;
    }
    
    public SISDeviceRequest setAdvertisingIdentifierInfo(final AdvertisingIdentifier$Info advertisingIdentifierInfo) {
        this.advertisingIdentifierInfo = advertisingIdentifierInfo;
        return this;
    }
    
    public SISDeviceRequest setCallMetricType(final Metrics$MetricType callMetricType) {
        this.callMetricType = callMetricType;
        return this;
    }
    
    public SISDeviceRequest setLogTag(final String logTag) {
        this.logTag = logTag;
        return this;
    }
    
    public SISDeviceRequest setPath(final String path) {
        this.path = path;
        return this;
    }
}
