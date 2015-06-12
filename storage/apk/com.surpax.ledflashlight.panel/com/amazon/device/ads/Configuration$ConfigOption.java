// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

public class Configuration$ConfigOption
{
    public static final Configuration$ConfigOption AAX_HOSTNAME;
    public static final Configuration$ConfigOption AD_PREF_URL;
    public static final Configuration$ConfigOption MADS_HOSTNAME;
    public static final Configuration$ConfigOption SEND_GEO;
    public static final Configuration$ConfigOption SIS_DOMAIN;
    public static final Configuration$ConfigOption SIS_URL;
    public static final Configuration$ConfigOption[] configOptions;
    private final boolean allowEmpty;
    private final Class dataType;
    private final String debugProperty;
    private final String responseKey;
    private final String settingsName;
    
    static {
        AAX_HOSTNAME = new Configuration$ConfigOption("config-aaxHostname", String.class, "aaxHostname", "debug.aaxHostname");
        SIS_URL = new Configuration$ConfigOption("config-sisURL", String.class, "sisURL", "debug.sisURL");
        AD_PREF_URL = new Configuration$ConfigOption("config-adPrefURL", String.class, "adPrefURL", "debug.adPrefURL");
        MADS_HOSTNAME = new Configuration$ConfigOption("config-madsHostname", String.class, "madsHostname", "debug.madsHostname", true);
        SIS_DOMAIN = new Configuration$ConfigOption("config-sisDomain", String.class, "sisDomain", "debug.sisDomain");
        SEND_GEO = new Configuration$ConfigOption("config-sendGeo", Boolean.class, "sendGeo", "debug.sendGeo");
        configOptions = new Configuration$ConfigOption[] { Configuration$ConfigOption.AAX_HOSTNAME, Configuration$ConfigOption.SIS_URL, Configuration$ConfigOption.AD_PREF_URL, Configuration$ConfigOption.MADS_HOSTNAME, Configuration$ConfigOption.SIS_DOMAIN, Configuration$ConfigOption.SEND_GEO };
    }
    
    protected Configuration$ConfigOption(final String s, final Class clazz, final String s2, final String s3) {
        this(s, clazz, s2, s3, false);
    }
    
    protected Configuration$ConfigOption(final String settingsName, final Class dataType, final String responseKey, final String debugProperty, final boolean allowEmpty) {
        this.settingsName = settingsName;
        this.responseKey = responseKey;
        this.dataType = dataType;
        this.debugProperty = debugProperty;
        this.allowEmpty = allowEmpty;
    }
    
    boolean getAllowEmpty() {
        return this.allowEmpty;
    }
    
    Class getDataType() {
        return this.dataType;
    }
    
    String getDebugProperty() {
        return this.debugProperty;
    }
    
    String getResponseKey() {
        return this.responseKey;
    }
    
    String getSettingsName() {
        return this.settingsName;
    }
}
