// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import org.json.JSONArray;
import java.util.Set;
import java.util.Collection;
import java.util.HashSet;
import org.json.JSONObject;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;
import android.annotation.SuppressLint;

@SuppressLint({ "UseSparseArrays" })
class AdLoader
{
    public static final int AD_FAILED = -1;
    public static final int AD_NOT_READY = 1;
    public static final int AD_QUEUED;
    protected static final String LOG_TAG;
    private static AdLoader$AdLoaderFactory adLoaderFactory;
    protected final AdRequest adRequest;
    protected MetricsCollector$CompositeMetricsCollector compositeMetricsCollector;
    protected AdError error;
    protected final Map slots;
    protected int timeout;
    
    static {
        LOG_TAG = AdLoader.class.getSimpleName();
        AdLoader.adLoaderFactory = new AdLoader$AdLoaderFactory();
    }
    
    public AdLoader(final AdRequest adRequest, final Map slots) {
        this.timeout = 20000;
        this.error = null;
        this.compositeMetricsCollector = null;
        this.adRequest = adRequest;
        this.slots = slots;
    }
    
    protected static void adFailedToBeReady(final int n, final AtomicInteger atomicInteger, final AdTargetingOptions adTargetingOptions, final AdSlot[] array, final int n2) {
        array[n2].setSlotNumber(-1);
        decrementCount(n, atomicInteger, adTargetingOptions, array);
    }
    
    private static void beginFetchAds(final int timeout, final AdTargetingOptions adTargetingOptions, final AdSlot[] array) {
        final AdvertisingIdentifier$Info advertisingIdentifierInfo = new AdvertisingIdentifier().getAdvertisingIdentifierInfo();
        if (!advertisingIdentifierInfo.canDo()) {
            failAds(new AdError(AdError$ErrorCode.INTERNAL_ERROR, "An internal request was not made on a background thread."), array);
        }
        else {
            final AdRequest setAdvertisingIdentifierInfo = new AdRequest(adTargetingOptions).setAdvertisingIdentifierInfo(advertisingIdentifierInfo);
            final HashMap<Integer, AdSlot> hashMap = new HashMap<Integer, AdSlot>();
            for (final AdSlot value : array) {
                if (value.getSlotNumber() != -1) {
                    hashMap.put(value.getSlotNumber(), value);
                    value.getAdData().setSlotId(value.getSlotNumber());
                    setAdvertisingIdentifierInfo.putSlot(value.getAdData(), value.getAdTargetingOptions());
                }
            }
            if (hashMap.size() > 0) {
                final AdLoader adLoader = AdLoader.adLoaderFactory.createAdLoader(setAdvertisingIdentifierInfo, hashMap);
                adLoader.setTimeout(timeout);
                adLoader.beginFetchAd();
            }
        }
    }
    
    private void beginFinalizeFetchAd() {
        new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
            @Override
            public void run() {
                AdLoader.this.finalizeFetchAd();
            }
        });
    }
    
    protected static void decrementCount(final int n, final AtomicInteger atomicInteger, final AdTargetingOptions adTargetingOptions, final AdSlot[] array) {
        if (atomicInteger.decrementAndGet() == 0) {
            new StartUpWaiter() {
                @Override
                protected final void startUpFailed() {
                    new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                        @Override
                        public void run() {
                            failAds(new AdError(AdError$ErrorCode.NETWORK_ERROR, "The configuration was unable to be loaded"), array);
                        }
                    });
                }
                
                @Override
                protected final void startUpReady() {
                    InternalAdRegistration.getInstance().register();
                    beginFetchAds(n, adTargetingOptions, array);
                }
            }.start();
        }
    }
    
    private static void failAds(final AdError adError, final AdSlot[] array) {
        final int length = array.length;
        int i = 0;
        int n = 0;
        while (i < length) {
            final AdSlot adSlot = array[i];
            if (adSlot.getSlotNumber() != -1) {
                adSlot.getAdLoaderCallback().adFailed(adError);
                ++n;
            }
            ++i;
        }
        if (n > 0) {
            Log.w(AdLoader.LOG_TAG, "%s; code: %s", adError.getMessage(), adError.getCode());
        }
    }
    
    private WebRequest getAdRequest() {
        this.getCompositeMetricsCollector().startMetric(Metrics$MetricType.AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL);
        final WebRequest webRequest = this.adRequest.getWebRequest();
        this.getCompositeMetricsCollector().stopMetric(Metrics$MetricType.AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL);
        return webRequest;
    }
    
    private MetricsCollector getCompositeMetricsCollector() {
        if (this.compositeMetricsCollector == null) {
            final ArrayList<MetricsCollector> list = new ArrayList<MetricsCollector>();
            final Iterator<Map.Entry<K, AdSlot>> iterator = this.slots.entrySet().iterator();
            while (iterator.hasNext()) {
                list.add(iterator.next().getValue().getAdData().getMetricsCollector());
            }
            this.compositeMetricsCollector = new MetricsCollector$CompositeMetricsCollector(list);
        }
        return this.compositeMetricsCollector;
    }
    
    private static boolean isNoRetry(final AdSlot[] array) {
        int i = 0;
        final int noRetryTtlRemainingMillis = InternalAdRegistration.getInstance().getNoRetryTtlRemainingMillis();
        if (noRetryTtlRemainingMillis > 0) {
            final int j = noRetryTtlRemainingMillis / 1000;
            String s;
            AdError$ErrorCode adError$ErrorCode;
            if (InternalAdRegistration.getInstance().getIsAppDisabled()) {
                s = "SDK Message: " + Utils.getDisabledAppServerMessage();
                adError$ErrorCode = AdError$ErrorCode.INTERNAL_ERROR;
            }
            else {
                s = "SDK Message: " + "no results. Try again in " + j + " seconds.";
                adError$ErrorCode = AdError$ErrorCode.NO_FILL;
            }
            Log.e(AdLoader.LOG_TAG, s);
            final AdError adError = new AdError(adError$ErrorCode, s);
            while (i < array.length) {
                final AdSlot adSlot = array[i];
                if (adSlot.getAdData() != null && adSlot.getAdData().getMetricsCollector() != null) {
                    adSlot.getAdData().getMetricsCollector().incrementMetric(Metrics$MetricType.AD_COUNTER_FAILED_DUE_TO_NO_RETRY);
                }
                if (adSlot.getAdLoaderCallback() != null) {
                    adSlot.getAdLoaderCallback().adFailed(adError);
                }
                ++i;
            }
            return true;
        }
        return false;
    }
    
    protected static boolean[] loadAds(final int n, final AdTargetingOptions adTargetingOptions, final Ad... array) {
        final AdSlot[] array2 = new AdSlot[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = new AdSlot(array[i], new AdTargetingOptions());
        }
        return loadAds(n, adTargetingOptions, array2);
    }
    
    protected static boolean[] loadAds(final int n, AdTargetingOptions adTargetingOptions, final AdSlot... array) {
        if (adTargetingOptions == null) {
            adTargetingOptions = new AdTargetingOptions();
        }
        final boolean[] a = new boolean[array.length];
        if (isNoRetry(array)) {
            Arrays.fill(a, true);
        }
        else {
            final AtomicInteger atomicInteger = new AtomicInteger(array.length);
            final AdLoader$AdReadyToLoadListener adLoader$AdReadyToLoadListener = new AdLoader$AdReadyToLoadListener(n, atomicInteger, adTargetingOptions, array);
            final int length = array.length;
            int i = 0;
            int n2 = 0;
            while (i < length) {
                final AdSlot adSlot = array[i];
                adSlot.setSlotNumber(n2 + 1);
                final int prepareAd = adSlot.getAdWrapper().prepareAd(adLoader$AdReadyToLoadListener);
                if (prepareAd != 0) {
                    adFailedToBeReady(n, atomicInteger, adTargetingOptions, array, n2);
                    if (prepareAd == -1) {
                        a[n2] = false;
                    }
                    else {
                        a[n2] = true;
                    }
                }
                else {
                    a[n2] = true;
                }
                ++n2;
                ++i;
            }
        }
        return a;
    }
    
    private void parseResponse(final JSONObject jsonObject) {
        final long currentTimeMillis = System.currentTimeMillis();
        final String stringFromJSON = JSONUtils.getStringFromJSON(jsonObject, "status", null);
        final HashSet<Integer> set = new HashSet<Integer>(this.slots.keySet());
        final AdError adError = this.getAdError(jsonObject);
        final String stringFromJSON2 = JSONUtils.getStringFromJSON(jsonObject, "errorCode", "No Ad Received");
        this.adRequest.setInstrumentationPixelURL(JSONUtils.getStringFromJSON(jsonObject, "instrPixelURL", null));
        if (stringFromJSON != null && stringFromJSON.equals("ok")) {
            final JSONArray jsonArrayFromJSON = JSONUtils.getJSONArrayFromJSON(jsonObject, "ads");
            for (int i = 0; i < jsonArrayFromJSON.length(); ++i) {
                final JSONObject jsonObjectFromJSONArray = JSONUtils.getJSONObjectFromJSONArray(jsonArrayFromJSON, i);
                if (jsonObjectFromJSONArray != null) {
                    final int integerFromJSON = JSONUtils.getIntegerFromJSON(jsonObjectFromJSONArray, "slotId", -1);
                    final AdSlot adSlot = this.slots.get(integerFromJSON);
                    if (adSlot != null) {
                        set.remove(integerFromJSON);
                        adSlot.getAdData().setInstrumentationPixelUrl(JSONUtils.getStringFromJSON(jsonObjectFromJSONArray, "instrPixelURL", this.adRequest.getInstrumentationPixelURL()));
                        adSlot.getAdData().setImpressionPixelUrl(JSONUtils.getStringFromJSON(jsonObjectFromJSONArray, "impPixelURL", null));
                        if (adSlot.getAdData().getRequestedAdSize().isAuto()) {
                            adSlot.getAdData().getMetricsCollector().incrementMetric(Metrics$MetricType.AD_COUNTER_AUTO_AD_SIZE);
                        }
                        final String stringFromJSON3 = JSONUtils.getStringFromJSON(jsonObjectFromJSONArray, "html", "");
                        final JSONArray jsonArrayFromJSON2 = JSONUtils.getJSONArrayFromJSON(jsonObjectFromJSONArray, "creativeTypes");
                        final HashSet<AdData$AAXCreative> creativeTypes = new HashSet<AdData$AAXCreative>();
                        if (jsonArrayFromJSON2 != null) {
                            for (int j = 0; j < jsonArrayFromJSON2.length(); ++j) {
                                final AdData$AAXCreative creative = AdData$AAXCreative.getCreative(JSONUtils.getIntegerFromJSONArray(jsonArrayFromJSON2, j, 0));
                                if (creative != null) {
                                    creativeTypes.add(creative);
                                }
                            }
                        }
                        if (creativeTypes.isEmpty()) {
                            adSlot.setAdError(new AdError(AdError$ErrorCode.INTERNAL_ERROR, "No valid creative types found"));
                            Log.e(AdLoader.LOG_TAG, "No valid creative types found");
                        }
                        else {
                            final String stringFromJSON4 = JSONUtils.getStringFromJSON(jsonObjectFromJSONArray, "size", "");
                            final boolean contains = creativeTypes.contains(AdData$AAXCreative.INTERSTITIAL);
                            int int1 = 0;
                            int int2 = 0;
                            if (!contains) {
                                String[] split;
                                if (stringFromJSON4 != null) {
                                    split = stringFromJSON4.split("x");
                                }
                                else {
                                    split = null;
                                }
                                int n;
                                if (split == null || split.length != 2) {
                                    n = 1;
                                }
                                else {
                                    try {
                                        int2 = Integer.parseInt(split[0]);
                                        int1 = Integer.parseInt(split[1]);
                                        n = 0;
                                    }
                                    catch (NumberFormatException ex) {
                                        n = 1;
                                        int1 = 0;
                                    }
                                }
                                if (n != 0) {
                                    adSlot.setAdError(new AdError(AdError$ErrorCode.INTERNAL_ERROR, "Server returned an invalid ad size"));
                                    Log.e(AdLoader.LOG_TAG, "Server returned an invalid ad size");
                                    continue;
                                }
                            }
                            final long longFromJSON = JSONUtils.getLongFromJSON(jsonObjectFromJSONArray, "cacheTTL", -1L);
                            if (longFromJSON > -1L) {
                                adSlot.getAdData().setExpirationTimeMillis(currentTimeMillis + longFromJSON * 1000L);
                            }
                            final AdProperties properties = new AdProperties(jsonArrayFromJSON2);
                            adSlot.getAdData().setHeight(int1);
                            adSlot.getAdData().setWidth(int2);
                            adSlot.getAdData().setCreative(stringFromJSON3);
                            adSlot.getAdData().setCreativeTypes(creativeTypes);
                            adSlot.getAdData().setProperties(properties);
                            adSlot.getAdData().setFetched(true);
                        }
                    }
                }
            }
        }
        for (final Integer n2 : set) {
            ((AdSlot)this.slots.get(n2)).setAdError(adError);
            ((AdSlot)this.slots.get(n2)).getAdData().setInstrumentationPixelUrl(this.adRequest.getInstrumentationPixelURL());
            Log.w(AdLoader.LOG_TAG, "%s; code: %s", adError.getMessage(), stringFromJSON2);
        }
    }
    
    protected static void setAdLoaderFactory(final AdLoader$AdLoaderFactory adLoaderFactory) {
        AdLoader.adLoaderFactory = adLoaderFactory;
    }
    
    private void setErrorForAllSlots(final AdError adError) {
        final Iterator<AdSlot> iterator = this.slots.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().setAdError(adError);
        }
    }
    
    public void beginFetchAd() {
        this.getCompositeMetricsCollector().stopMetric(Metrics$MetricType.AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START);
        this.getCompositeMetricsCollector().startMetric(Metrics$MetricType.AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP);
        this.startFetchAdThread();
    }
    
    protected void fetchAd() {
        this.getCompositeMetricsCollector().stopMetric(Metrics$MetricType.AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP);
        this.getCompositeMetricsCollector().startMetric(Metrics$MetricType.AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START);
        if (!Assets.getInstance().ensureAssetsCreated()) {
            this.error = new AdError(AdError$ErrorCode.REQUEST_ERROR, "Unable to create the assets needed to display ads");
            Log.e(AdLoader.LOG_TAG, "Unable to create the assets needed to display ads");
            this.setErrorForAllSlots(this.error);
            return;
        }
        WebRequest$WebResponse fetchResponseFromNetwork;
        try {
            fetchResponseFromNetwork = this.fetchResponseFromNetwork();
            if (!fetchResponseFromNetwork.isHttpStatusCodeOK()) {
                final String string = fetchResponseFromNetwork.getHttpStatusCode() + " - " + fetchResponseFromNetwork.getHttpStatus();
                this.error = new AdError(AdError$ErrorCode.NETWORK_ERROR, string);
                Log.e(AdLoader.LOG_TAG, string);
                this.setErrorForAllSlots(this.error);
                return;
            }
        }
        catch (AdLoader$AdFetchException ex) {
            this.error = ex.getAdError();
            Log.e(AdLoader.LOG_TAG, ex.getAdError().getMessage());
            this.setErrorForAllSlots(this.error);
            return;
        }
        final JSONObject jsonObjectBody = fetchResponseFromNetwork.getJSONObjectBody();
        if (jsonObjectBody == null) {
            this.error = new AdError(AdError$ErrorCode.INTERNAL_ERROR, "Unable to parse response");
            Log.e(AdLoader.LOG_TAG, "Unable to parse response");
            this.setErrorForAllSlots(this.error);
            return;
        }
        this.parseResponse(jsonObjectBody);
        this.getCompositeMetricsCollector().stopMetric(Metrics$MetricType.AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END);
        this.getCompositeMetricsCollector().startMetric(Metrics$MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP);
    }
    
    protected WebRequest$WebResponse fetchResponseFromNetwork() {
        final WebRequest adRequest = this.getAdRequest();
        adRequest.setMetricsCollector(this.getCompositeMetricsCollector());
        adRequest.setServiceCallLatencyMetric(Metrics$MetricType.AAX_LATENCY_GET_AD);
        adRequest.setTimeout(this.timeout);
        this.getCompositeMetricsCollector().stopMetric(Metrics$MetricType.AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START);
        this.getCompositeMetricsCollector().incrementMetric(Metrics$MetricType.TLS_ENABLED);
        try {
            final WebRequest$WebResponse call = adRequest.makeCall();
            this.getCompositeMetricsCollector().startMetric(Metrics$MetricType.AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END);
            return call;
        }
        catch (WebRequest$WebRequestException ex) {
            AdError adError;
            if (ex.getStatus() == WebRequest$WebRequestStatus.NETWORK_FAILURE) {
                adError = new AdError(AdError$ErrorCode.NETWORK_ERROR, "Could not contact Ad Server");
            }
            else if (ex.getStatus() == WebRequest$WebRequestStatus.NETWORK_TIMEOUT) {
                adError = new AdError(AdError$ErrorCode.NETWORK_TIMEOUT, "Connection to Ad Server timed out");
            }
            else {
                adError = new AdError(AdError$ErrorCode.INTERNAL_ERROR, ex.getMessage());
            }
            throw new AdLoader$AdFetchException(this, adError);
        }
    }
    
    protected void finalizeFetchAd() {
        final Iterator<Map.Entry<K, AdSlot>> iterator = this.slots.entrySet().iterator();
        while (iterator.hasNext()) {
            final AdSlot adSlot = iterator.next().getValue();
            final IAdLoaderCallback adLoaderCallback = adSlot.getAdLoaderCallback();
            final AdData adData = adSlot.getAdData();
            adData.getMetricsCollector().stopMetric(Metrics$MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP);
            if (!adData.getIsFetched()) {
                adData.getMetricsCollector().startMetric(Metrics$MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE);
                if (adSlot.getAdError() != null) {
                    adLoaderCallback.adFailed(adSlot.getAdError());
                }
                else {
                    adLoaderCallback.adFailed(new AdError(AdError$ErrorCode.INTERNAL_ERROR, "Unknown error occurred."));
                }
            }
            else {
                adData.getMetricsCollector().startMetric(Metrics$MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START);
                adLoaderCallback.handleResponse();
            }
        }
    }
    
    protected AdError getAdError(final JSONObject jsonObject) {
        final int retrieveNoRetryTtlSeconds = this.retrieveNoRetryTtlSeconds(jsonObject);
        InternalAdRegistration.getInstance().setNoRetryTtl(retrieveNoRetryTtlSeconds);
        final String stringFromJSON = JSONUtils.getStringFromJSON(jsonObject, "errorMessage", "No Ad Received");
        InternalAdRegistration.getInstance().setIsAppDisabled(stringFromJSON.equalsIgnoreCase(Utils.getDisabledAppServerMessage()));
        final String string = "Server Message: " + stringFromJSON;
        if (retrieveNoRetryTtlSeconds > 0) {
            this.getCompositeMetricsCollector().publishMetricInMilliseconds(Metrics$MetricType.AD_NO_RETRY_TTL_RECEIVED, retrieveNoRetryTtlSeconds * 1000);
        }
        if (retrieveNoRetryTtlSeconds > 0 && !InternalAdRegistration.getInstance().getIsAppDisabled()) {
            return new AdError(AdError$ErrorCode.NO_FILL, string + ". Try again in " + retrieveNoRetryTtlSeconds + " seconds");
        }
        if (stringFromJSON.equals("no results")) {
            return new AdError(AdError$ErrorCode.NO_FILL, string);
        }
        return new AdError(AdError$ErrorCode.INTERNAL_ERROR, string);
    }
    
    protected int retrieveNoRetryTtlSeconds(final JSONObject jsonObject) {
        return DebugProperties.getDebugPropertyAsInteger("debug.noRetryTTL", JSONUtils.getIntegerFromJSON(jsonObject, "noretryTTL", 0));
    }
    
    public void setTimeout(final int timeout) {
        this.timeout = timeout;
    }
    
    protected void startFetchAdThread() {
        ThreadUtils.executeRunnable(new Runnable() {
            @Override
            public void run() {
                AdLoader.this.fetchAd();
                AdLoader.this.beginFinalizeFetchAd();
            }
        });
    }
}
