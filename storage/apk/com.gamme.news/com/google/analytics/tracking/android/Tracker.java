// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Locale;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class Tracker
{
    private final AppFieldsDefaultProvider mAppFieldsDefaultProvider;
    private final ClientIdDefaultProvider mClientIdDefaultProvider;
    private final TrackerHandler mHandler;
    private final String mName;
    private final Map<String, String> mParams;
    private RateLimiter mRateLimiter;
    private final ScreenResolutionDefaultProvider mScreenResolutionDefaultProvider;
    
    Tracker(final String s, final String s2, final TrackerHandler trackerHandler) {
        this(s, s2, trackerHandler, ClientIdDefaultProvider.getProvider(), ScreenResolutionDefaultProvider.getProvider(), AppFieldsDefaultProvider.getProvider(), new SendHitRateLimiter());
    }
    
    Tracker(final String mName, final String s, final TrackerHandler mHandler, final ClientIdDefaultProvider mClientIdDefaultProvider, final ScreenResolutionDefaultProvider mScreenResolutionDefaultProvider, final AppFieldsDefaultProvider mAppFieldsDefaultProvider, final RateLimiter mRateLimiter) {
        this.mParams = new HashMap<String, String>();
        if (TextUtils.isEmpty((CharSequence)mName)) {
            throw new IllegalArgumentException("Tracker name cannot be empty.");
        }
        this.mName = mName;
        this.mHandler = mHandler;
        this.mParams.put("&tid", s);
        this.mParams.put("useSecure", "1");
        this.mClientIdDefaultProvider = mClientIdDefaultProvider;
        this.mScreenResolutionDefaultProvider = mScreenResolutionDefaultProvider;
        this.mAppFieldsDefaultProvider = mAppFieldsDefaultProvider;
        this.mRateLimiter = mRateLimiter;
    }
    
    public String get(final String s) {
        GAUsage.getInstance().setUsage(GAUsage.Field.GET);
        if (!TextUtils.isEmpty((CharSequence)s)) {
            if (this.mParams.containsKey(s)) {
                return this.mParams.get(s);
            }
            if (s.equals("&ul")) {
                return Utils.getLanguage(Locale.getDefault());
            }
            if (this.mClientIdDefaultProvider != null && this.mClientIdDefaultProvider.providesField(s)) {
                return this.mClientIdDefaultProvider.getValue(s);
            }
            if (this.mScreenResolutionDefaultProvider != null && this.mScreenResolutionDefaultProvider.providesField(s)) {
                return this.mScreenResolutionDefaultProvider.getValue(s);
            }
            if (this.mAppFieldsDefaultProvider != null && this.mAppFieldsDefaultProvider.providesField(s)) {
                return this.mAppFieldsDefaultProvider.getValue(s);
            }
        }
        return null;
    }
    
    public String getName() {
        GAUsage.getInstance().setUsage(GAUsage.Field.GET_TRACKER_NAME);
        return this.mName;
    }
    
    @VisibleForTesting
    RateLimiter getRateLimiter() {
        return this.mRateLimiter;
    }
    
    public void send(final Map<String, String> map) {
        GAUsage.getInstance().setUsage(GAUsage.Field.SEND);
        final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.putAll(this.mParams);
        if (map != null) {
            hashMap.putAll(map);
        }
        if (TextUtils.isEmpty((CharSequence)hashMap.get("&tid"))) {
            Log.w(String.format("Missing tracking id (%s) parameter.", "&tid"));
        }
        String s = hashMap.get("&t");
        if (TextUtils.isEmpty((CharSequence)s)) {
            Log.w(String.format("Missing hit type (%s) parameter.", "&t"));
            s = "";
        }
        if (!s.equals("transaction") && !s.equals("item") && !this.mRateLimiter.tokenAvailable()) {
            Log.w("Too many hits sent too quickly, rate limiting invoked.");
            return;
        }
        this.mHandler.sendHit((Map<String, String>)hashMap);
    }
    
    public void set(final String s, final String s2) {
        GAUsage.getInstance().setUsage(GAUsage.Field.SET);
        if (s2 == null) {
            this.mParams.remove(s);
            return;
        }
        this.mParams.put(s, s2);
    }
}
