// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import java.util.HashMap;
import java.util.Map;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;

class FlowMonitor
{
    static final String HITS_DISPATCHED = "hitsDispatched";
    static final String HITS_DISPATCHED_PARAM = "_s";
    static final String HITS_GENERATED = "hitsGenerated";
    static final String HITS_GENERATED_PARAM = "_g";
    static final String HITS_PAST_PROXY = "hitsPastProxy";
    static final String HITS_PAST_PROXY_PARAM = "_p";
    static final String HITS_STORED_IN_DB = "hitsStoredInDb";
    static final String HITS_STORED_IN_DB_PARAM = "_d";
    private static final int HIT_INTERVAL = 50;
    static final String LAST_QUERY_TIMESTAMP = "lastQueryTimestamp";
    static final String LAST_QUERY_TIMESTAMP_PARAM = "_ts";
    static final String MONITOR_TYPE = "flow";
    static final String MONITOR_TYPE_PARAM = "_t";
    static final String PREFERENCES_LABEL = "GoogleAnalytics";
    private static final long TIME_INTERVAL = 14400000L;
    private static FlowMonitor sInstance;
    SharedPreferences$Editor mEditor;
    private int mHitsDispatched;
    private int mHitsGenerated;
    private int mHitsPastProxy;
    private int mHitsStoredInDb;
    private long mLastQueryTimeStamp;
    SharedPreferences mPersistentStore;
    
    FlowMonitor(final Context context) {
        this.mPersistentStore = context.getSharedPreferences("GoogleAnalytics", 0);
        this.mEditor = this.mPersistentStore.edit();
        this.mHitsGenerated = this.mPersistentStore.getInt("hitsGenerated", 0);
        this.mHitsPastProxy = this.mPersistentStore.getInt("hitsPastProxy", 0);
        this.mHitsStoredInDb = this.mPersistentStore.getInt("hitsStoredInDb", 0);
        this.mHitsDispatched = this.mPersistentStore.getInt("hitsDispatched", 0);
        this.mLastQueryTimeStamp = this.mPersistentStore.getLong("lastQueryTimestamp", 0L);
        if (this.mLastQueryTimeStamp == 0L) {
            this.mLastQueryTimeStamp = System.currentTimeMillis();
            this.mEditor.putLong("lastQueryTimestamp", this.mLastQueryTimeStamp);
            this.mEditor.commit();
        }
    }
    
    public static FlowMonitor getInstance(final Context context) {
        if (FlowMonitor.sInstance == null) {
            FlowMonitor.sInstance = new FlowMonitor(context);
        }
        return FlowMonitor.sInstance;
    }
    
    public String buildAndResetHitsDispatched() {
        final StringBuilder sb = new StringBuilder();
        sb.append("_s").append("=").append(this.mHitsDispatched);
        this.mHitsDispatched = 0;
        this.mEditor.putInt("hitsDispatched", this.mHitsDispatched);
        this.mEditor.commit();
        return sb.toString();
    }
    
    public Map<String, String> generateHit() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("_t", "flow");
        hashMap.put("_ts", String.valueOf(this.mLastQueryTimeStamp));
        this.mLastQueryTimeStamp = System.currentTimeMillis();
        this.mEditor.putLong("lastQueryTimestamp", this.mLastQueryTimeStamp);
        hashMap.put("_g", this.getAndResetHitsGeneratedParameter());
        return hashMap;
    }
    
    String getAndResetHitsGeneratedParameter() {
        final String value = String.valueOf(this.mHitsGenerated);
        this.mHitsGenerated = 0;
        this.mEditor.putInt("hitsGenerated", 0);
        this.mEditor.commit();
        return value;
    }
    
    public String getAndResetHitsPastProxy() {
        final String value = String.valueOf(this.mHitsPastProxy);
        this.mHitsPastProxy = 0;
        this.mEditor.putInt("hitsPastProxy", this.mHitsPastProxy);
        this.mEditor.commit();
        return value;
    }
    
    public String getAndResetHitsStoredInDb() {
        final String value = String.valueOf(this.mHitsStoredInDb);
        this.mHitsStoredInDb = 0;
        this.mEditor.putInt("hitsStoredInDb", this.mHitsStoredInDb);
        this.mEditor.commit();
        return value;
    }
    
    public void incrementHitsDispatched(final int n) {
        this.mHitsDispatched += n;
        this.mEditor.putInt("hitsDispatched", n);
        this.mEditor.commit();
    }
    
    public void incrementHitsGenerated(final int n) {
        this.mHitsGenerated += n;
        this.mEditor.putInt("hitsGenerated", n);
        this.mEditor.commit();
    }
    
    public void incrementHitsPastProxy(final int n) {
        this.mHitsPastProxy += n;
        this.mEditor.putInt("hitsPastProxy", n);
        this.mEditor.commit();
    }
    
    public void incrementHitsStoredInDb(final int n) {
        this.mHitsStoredInDb += n;
        this.mEditor.putInt("hitsStoredInDb", n);
        this.mEditor.commit();
    }
    
    public boolean shouldReport() {
        return this.mHitsGenerated >= 50 && System.currentTimeMillis() - this.mLastQueryTimeStamp >= 14400000L;
    }
}
