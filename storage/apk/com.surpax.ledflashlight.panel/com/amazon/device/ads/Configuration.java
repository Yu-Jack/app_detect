// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class Configuration
{
    private static final String AAX_MSDK_CONFIG_ENDPOINT = "/e/msdk/cfg";
    private static final String AAX_PROD_US_HOSTNAME = "aax-us-east.amazon-adsystem.com";
    protected static final String CONFIG_APP_DEFINED_MARKETPLACE = "config-appDefinedMarketplace";
    protected static final String CONFIG_LASTFETCHTIME = "config-lastFetchTime";
    protected static final String CONFIG_TTL = "config-ttl";
    protected static final String CONFIG_VERSION_NAME = "configVersion";
    protected static final int CURRENT_CONFIG_VERSION = 1;
    private static final String LOG_TAG;
    protected static final int MAX_CONFIG_TTL = 172800;
    protected static final int MAX_NO_RETRY_TTL = 300000;
    protected static Configuration instance;
    private String appDefinedMarketplace;
    private boolean isAppDefinedMarketplaceSet;
    private AtomicBoolean isFetching;
    private boolean isFirstParty;
    private Boolean lastTestModeValue;
    private List listeners;
    private PreferredMarketplaceRetriever pfmRetriever;
    
    static {
        LOG_TAG = Configuration.class.getSimpleName();
        Configuration.instance = new Configuration();
    }
    
    protected Configuration() {
        this.appDefinedMarketplace = null;
        this.isAppDefinedMarketplaceSet = false;
        this.listeners = null;
        this.isFetching = null;
        this.lastTestModeValue = null;
        this.isFirstParty = false;
        this.pfmRetriever = new PreferredMarketplaceRetriever$NullPreferredMarketplaceRetriever();
        this.listeners = new ArrayList(5);
        this.isFetching = new AtomicBoolean(false);
    }
    
    public static final Configuration getInstance() {
        return Configuration.instance;
    }
    
    public static int getMaxNoRetryTtl() {
        return DebugProperties.getDebugPropertyAsInteger("debug.noRetryTTLMax", 300000);
    }
    
    private String getPreferredMarketplace() {
        return this.pfmRetriever.retrievePreferredMarketplace();
    }
    
    private boolean hasAppDefinedMarketplaceChanged() {
        final Settings instance = Settings.getInstance();
        final String string = instance.getString("config-appDefinedMarketplace", null);
        if (this.isAppDefinedMarketplaceSet) {
            this.isAppDefinedMarketplaceSet = false;
            if (this.appDefinedMarketplace != null && !this.appDefinedMarketplace.equals(string)) {
                instance.putLongWithNoFlush("config-lastFetchTime", 0L);
                instance.putStringWithNoFlush("config-appDefinedMarketplace", this.appDefinedMarketplace);
                instance.flush();
                InternalAdRegistration.getInstance().getRegistrationInfo().requestNewSISDeviceIdentifier();
                Log.d(Configuration.LOG_TAG, "New application-defined marketplace set. A new configuration will be retrieved.");
                return true;
            }
            if (string != null && this.appDefinedMarketplace == null) {
                instance.remove("config-appDefinedMarketplace");
                InternalAdRegistration.getInstance().getRegistrationInfo().requestNewSISDeviceIdentifier();
                Log.d(Configuration.LOG_TAG, "Application-defined marketplace removed. A new configuration will be retrieved.");
                return true;
            }
        }
        return false;
    }
    
    private void writeSettingFromConfigOption(final Configuration$ConfigOption configuration$ConfigOption, final JSONObject jsonObject) {
        if (configuration$ConfigOption.getDataType().equals(String.class)) {
            final String string = jsonObject.getString(configuration$ConfigOption.getResponseKey());
            if (!configuration$ConfigOption.getAllowEmpty() && Utils.isNullOrWhiteSpace(string)) {
                throw new IllegalArgumentException("The configuration value must not be empty or contain only white spaces.");
            }
            Settings.getInstance().putStringWithNoFlush(configuration$ConfigOption.getSettingsName(), string);
        }
        else {
            if (configuration$ConfigOption.getDataType().equals(Boolean.class)) {
                Settings.getInstance().putBooleanWithNoFlush(configuration$ConfigOption.getSettingsName(), jsonObject.getBoolean(configuration$ConfigOption.getResponseKey()));
                return;
            }
            throw new IllegalArgumentException("Undefined configuration option type.");
        }
    }
    
    protected void beginFetch() {
        ThreadUtils.executeRunnable(new Runnable() {
            @Override
            public void run() {
                Configuration.this.fetchConfigurationOnBackgroundThread();
            }
        });
    }
    
    AdvertisingIdentifier$Info createAdvertisingIdentifierInfo() {
        final AdvertisingIdentifier advertisingIdentifier = new AdvertisingIdentifier();
        final int int1 = Settings.getInstance().getInt("configVersion", 0);
        boolean shouldSetCurrentAdvertisingIdentifier = false;
        if (int1 != 0) {
            shouldSetCurrentAdvertisingIdentifier = true;
        }
        return advertisingIdentifier.setShouldSetCurrentAdvertisingIdentifier(shouldSetCurrentAdvertisingIdentifier).getAdvertisingIdentifierInfo();
    }
    
    protected WebRequest createWebRequest(final AdvertisingIdentifier$Info advertisingIdentifier$Info) {
        final WebRequest jsonGetWebRequest = WebRequest.createJSONGetWebRequest();
        jsonGetWebRequest.setExternalLogTag(Configuration.LOG_TAG);
        jsonGetWebRequest.enableLogUrl(true);
        jsonGetWebRequest.setHost(DebugProperties.getDebugPropertyAsString("debug.aaxConfigHostname", "aax-us-east.amazon-adsystem.com"));
        jsonGetWebRequest.setPath("/e/msdk/cfg");
        jsonGetWebRequest.setMetricsCollector(Metrics.getInstance().getMetricsCollector());
        jsonGetWebRequest.setServiceCallLatencyMetric(Metrics$MetricType.AAX_CONFIG_DOWNLOAD_LATENCY);
        jsonGetWebRequest.setUseSecure(DebugProperties.getDebugPropertyAsBoolean("debug.aaxConfigUseSecure", true));
        final RegistrationInfo registrationInfo = InternalAdRegistration.getInstance().getRegistrationInfo();
        final DeviceInfo deviceInfo = InternalAdRegistration.getInstance().getDeviceInfo();
        jsonGetWebRequest.putUnencodedQueryParameter("appId", registrationInfo.getAppKey());
        jsonGetWebRequest.putUnencodedQueryParameter("dinfo", deviceInfo.getDInfoProperty().toString());
        jsonGetWebRequest.putUnencodedQueryParameter("adId", advertisingIdentifier$Info.getSISDeviceIdentifier());
        jsonGetWebRequest.putUnencodedQueryParameter("sdkVer", Version.getSDKVersion());
        jsonGetWebRequest.putUnencodedQueryParameter("fp", Boolean.toString(this.isFirstParty));
        jsonGetWebRequest.putUnencodedQueryParameter("mkt", Settings.getInstance().getString("config-appDefinedMarketplace", null));
        jsonGetWebRequest.putUnencodedQueryParameter("pfm", this.getPreferredMarketplace());
        final boolean boolean1 = Settings.getInstance().getBoolean("testingEnabled", false);
        this.setLastTestModeValue(boolean1);
        if (boolean1) {
            jsonGetWebRequest.putUnencodedQueryParameter("testMode", "true");
        }
        jsonGetWebRequest.setAdditionalQueryParamsString(DebugProperties.getDebugPropertyAsString("debug.aaxConfigParams", null));
        return jsonGetWebRequest;
    }
    
    protected void fetchConfigurationOnBackgroundThread() {
        int n = 172800;
        Log.d(Configuration.LOG_TAG, "In configuration fetcher background thread.");
        if (!PermissionChecker.getInstance().passesInternetPermissionCheck(InternalAdRegistration.getInstance().getApplicationContext(), Configuration.LOG_TAG)) {
            this.onFetchFailure();
            return;
        }
        final AdvertisingIdentifier$Info advertisingIdentifierInfo = this.createAdvertisingIdentifierInfo();
        if (!advertisingIdentifierInfo.canDo()) {
            this.onFetchFailure();
            return;
        }
        final WebRequest webRequest = this.createWebRequest(advertisingIdentifierInfo);
        JSONObject jsonObjectBody = null;
        Settings instance = null;
        Label_0273: {
            try {
                final WebRequest$WebResponse call = webRequest.makeCall();
                Log.d(Configuration.LOG_TAG, "Response Body: %s", call.getBody());
                jsonObjectBody = call.getJSONObjectBody();
                instance = Settings.getInstance();
                try {
                    final Configuration$ConfigOption[] configOptions = this.getConfigOptions();
                    final int length = configOptions.length;
                    final int n2 = 0;
                    if (n2 >= length) {
                        break Label_0273;
                    }
                    final Configuration$ConfigOption configuration$ConfigOption = configOptions[n2];
                    if (jsonObjectBody.isNull(configuration$ConfigOption.getResponseKey()) && !configuration$ConfigOption.getAllowEmpty()) {
                        throw new Exception("The configuration value must be present and not null.");
                    }
                    goto Label_0225;
                }
                catch (JSONException ex) {
                    Log.e(Configuration.LOG_TAG, "Unable to parse JSON response: %s", ex.getMessage());
                    this.onFetchFailure();
                    return;
                }
                catch (Exception ex2) {
                    Log.e(Configuration.LOG_TAG, "Unexpected error during parsing: %s", ex2.getMessage());
                    this.onFetchFailure();
                    return;
                }
            }
            catch (WebRequest$WebRequestException ex3) {}
        }
        if (jsonObjectBody.isNull("ttl")) {
            throw new Exception("The configuration value must be present and not null.");
        }
        final int int1 = jsonObjectBody.getInt("ttl");
        if (int1 <= n) {
            n = int1;
        }
        instance.putIntWithNoFlush("config-ttl", n);
        instance.putLongWithNoFlush("config-lastFetchTime", this.nanoTime());
        instance.putIntWithNoFlush("configVersion", 1);
        instance.flush();
        Log.d(Configuration.LOG_TAG, "Configuration fetched and saved.");
        this.onFetchSuccess();
    }
    
    protected Configuration$ConfigurationListener[] getAndClearListeners() {
        synchronized (this) {
            final Configuration$ConfigurationListener[] array = this.listeners.toArray(new Configuration$ConfigurationListener[this.listeners.size()]);
            this.listeners.clear();
            return array;
        }
    }
    
    public String getAppDefinedMarketplace() {
        return this.appDefinedMarketplace;
    }
    
    public boolean getBoolean(final Configuration$ConfigOption configuration$ConfigOption) {
        return this.getBooleanWithDefault(configuration$ConfigOption, false);
    }
    
    public boolean getBooleanWithDefault(final Configuration$ConfigOption configuration$ConfigOption, final boolean b) {
        if (DebugProperties.containsDebugProperty(configuration$ConfigOption.getDebugProperty())) {
            return DebugProperties.getDebugPropertyAsBoolean(configuration$ConfigOption.getDebugProperty(), b);
        }
        return Settings.getInstance().getBoolean(configuration$ConfigOption.getSettingsName(), b);
    }
    
    protected Configuration$ConfigOption[] getConfigOptions() {
        return Configuration$ConfigOption.configOptions;
    }
    
    PreferredMarketplaceRetriever getPreferredMarketplaceRetriever() {
        return this.pfmRetriever;
    }
    
    public String getString(final Configuration$ConfigOption configuration$ConfigOption) {
        String s = DebugProperties.getDebugPropertyAsString(configuration$ConfigOption.getDebugProperty(), null);
        if (s == null) {
            s = Settings.getInstance().getString(configuration$ConfigOption.getSettingsName(), null);
        }
        return s;
    }
    
    protected boolean isFetching() {
        return this.isFetching.get();
    }
    
    boolean isFirstParty() {
        return this.isFirstParty;
    }
    
    protected long nanoTime() {
        return System.nanoTime();
    }
    
    protected void onFetchFailure() {
        int i = 0;
        synchronized (this) {
            Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics$MetricType.AAX_CONFIG_DOWNLOAD_FAILED);
            this.setIsFetching(false);
            for (Configuration$ConfigurationListener[] andClearListeners = this.getAndClearListeners(); i < andClearListeners.length; ++i) {
                andClearListeners[i].onConfigurationFailure();
            }
        }
    }
    
    protected void onFetchSuccess() {
        int i = 0;
        synchronized (this) {
            this.setIsFetching(false);
            for (Configuration$ConfigurationListener[] andClearListeners = this.getAndClearListeners(); i < andClearListeners.length; ++i) {
                andClearListeners[i].onConfigurationReady();
            }
        }
    }
    
    public void queueConfigurationListener(final Configuration$ConfigurationListener configuration$ConfigurationListener) {
        synchronized (this) {
            this.queueConfigurationListener(configuration$ConfigurationListener, true);
        }
    }
    
    public void queueConfigurationListener(final Configuration$ConfigurationListener configuration$ConfigurationListener, final boolean b) {
        while (true) {
            Label_0071: {
                synchronized (this) {
                    if (this.isFetching()) {
                        this.listeners.add(configuration$ConfigurationListener);
                    }
                    else {
                        if (!this.shouldFetch()) {
                            break Label_0071;
                        }
                        this.listeners.add(configuration$ConfigurationListener);
                        if (b) {
                            Log.d(Configuration.LOG_TAG, "Starting configuration fetching...");
                            this.setIsFetching(true);
                            this.beginFetch();
                        }
                    }
                    return;
                }
            }
            configuration$ConfigurationListener.onConfigurationReady();
        }
    }
    
    public void setAppDefinedMarketplace(final String appDefinedMarketplace) {
        this.appDefinedMarketplace = appDefinedMarketplace;
        this.isAppDefinedMarketplaceSet = true;
    }
    
    protected void setIsFetching(final boolean newValue) {
        this.isFetching.set(newValue);
    }
    
    public void setIsFirstParty(final boolean isFirstParty) {
        this.isFirstParty = isFirstParty;
    }
    
    protected void setLastTestModeValue(final boolean b) {
        this.lastTestModeValue = b;
    }
    
    public void setPreferredMarketplaceRetriever(final PreferredMarketplaceRetriever pfmRetriever) {
        this.pfmRetriever = pfmRetriever;
    }
    
    protected boolean shouldFetch() {
        final Settings instance = Settings.getInstance();
        if (!this.hasAppDefinedMarketplaceChanged() && Settings.getInstance().getInt("configVersion", 0) == 1) {
            final long nanoTime = this.nanoTime();
            final long long1 = instance.getLong("config-lastFetchTime", 0L);
            final long n = instance.getInt("config-ttl", 172800);
            if (long1 == 0L) {
                Log.d(Configuration.LOG_TAG, "No configuration found. A new configuration will be retrieved.");
                return true;
            }
            if (nanoTime - long1 > Utils.convertToNsFromS(n)) {
                Log.d(Configuration.LOG_TAG, "The configuration has expired. A new configuration will be retrieved.");
                return true;
            }
            if (this.lastTestModeValue != null && this.lastTestModeValue != instance.getBoolean("testingEnabled", false)) {
                Log.d(Configuration.LOG_TAG, "The testing mode has changed. A new configuration will be retrieved.");
                return true;
            }
            if (!DebugProperties.getDebugPropertyAsBoolean("debug.shouldFetchConfig", false)) {
                return false;
            }
        }
        return true;
    }
}
