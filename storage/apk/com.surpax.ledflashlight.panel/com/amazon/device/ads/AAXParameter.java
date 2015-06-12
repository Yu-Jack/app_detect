// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;

abstract class AAXParameter
{
    static final AAXParameter ADVERTISING_IDENTIFIER;
    static final AAXParameter APP_KEY;
    static final AAXParameter CHANNEL;
    static final AAXParameter DEVICE_INFO;
    static final AAXParameter FLOOR_PRICE;
    static final AAXParameter GEOLOCATION;
    private static final String LOG_TAG;
    static final AAXParameter MAX_SIZE;
    static final AAXParameter MD5_UDID;
    static final AAXParameter OPT_OUT;
    static final AAXParameter PACKAGE_INFO;
    static final AAXParameter PAGE_TYPE;
    static final AAXParameter PUBLISHER_ASINS;
    static final AAXParameter PUBLISHER_KEYWORDS;
    static final AAXParameter SDK_VERSION;
    static final AAXParameter SHA1_UDID;
    static final AAXParameter SIS_DEVICE_IDENTIFIER;
    static final AAXParameter SIZE;
    static final AAXParameter SLOT;
    static final AAXParameter SLOTS;
    static final AAXParameter SLOT_ID;
    static final AAXParameter SLOT_POSITION;
    static final AAXParameter TEST;
    static final AAXParameter USER_AGENT;
    static final AAXParameter USER_INFO;
    private final String debugName;
    private final String name;
    
    static {
        LOG_TAG = AAXParameter.class.getSimpleName();
        APP_KEY = new AAXParameter$AppKeyParameter();
        CHANNEL = new AAXParameter$StringParameter("c", "debug.channel");
        PUBLISHER_KEYWORDS = new AAXParameter$JSONArrayParameter("pk", "debug.pk");
        PUBLISHER_ASINS = new AAXParameter$JSONArrayParameter("pa", "debug.pa");
        USER_AGENT = new AAXParameter$UserAgentParameter();
        SDK_VERSION = new AAXParameter$SDKVersionParameter();
        GEOLOCATION = new AAXParameter$GeoLocationParameter();
        USER_INFO = new AAXParameter$UserInfoParameter();
        DEVICE_INFO = new AAXParameter$DeviceInfoParameter();
        PACKAGE_INFO = new AAXParameter$PackageInfoParameter();
        TEST = new AAXParameter$TestParameter();
        SIS_DEVICE_IDENTIFIER = new AAXParameter$SISDeviceIdentifierParameter();
        SHA1_UDID = new AAXParameter$SHA1UDIDParameter();
        MD5_UDID = new AAXParameter$MD5UDIDParameter();
        SLOTS = new AAXParameter$JSONArrayParameter("slots", "debug.slots");
        ADVERTISING_IDENTIFIER = new AAXParameter$AdvertisingIdentifierParameter();
        OPT_OUT = new AAXParameter$OptOutParameter();
        SIZE = new AAXParameter$SizeParameter();
        PAGE_TYPE = new AAXParameter$StringParameter("pt", "debug.pt");
        SLOT = new AAXParameter$SlotParameter();
        SLOT_POSITION = new AAXParameter$StringParameter("sp", "debug.sp");
        MAX_SIZE = new AAXParameter$MaxSizeParameter();
        SLOT_ID = new AAXParameter$SlotIdParameter();
        FLOOR_PRICE = new AAXParameter$FloorPriceParameter();
    }
    
    AAXParameter(final String name, final String debugName) {
        this.name = name;
        this.debugName = debugName;
    }
    
    protected String getDebugName() {
        return this.debugName;
    }
    
    protected Object getDerivedValue(final AAXParameter$ParameterData aaxParameter$ParameterData) {
        return null;
    }
    
    protected abstract Object getFromDebugProperties();
    
    String getName() {
        return this.name;
    }
    
    Object getValue(final AAXParameter$ParameterData aaxParameter$ParameterData) {
        Object o;
        if (this.hasDebugPropertiesValue()) {
            o = this.getFromDebugProperties();
        }
        else if (aaxParameter$ParameterData.advancedOptions.containsKey(this.name)) {
            o = this.parseFromString(aaxParameter$ParameterData.advancedOptions.remove(this.name));
        }
        else {
            o = this.getDerivedValue(aaxParameter$ParameterData);
        }
        if (o instanceof String && Utils.isNullOrWhiteSpace((String)o)) {
            o = null;
        }
        return o;
    }
    
    protected boolean hasDebugPropertiesValue() {
        return DebugProperties.containsDebugProperty(this.debugName);
    }
    
    protected abstract Object parseFromString(final String p0);
}
