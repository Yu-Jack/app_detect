// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.widget;

import android.content.ComponentName;
import java.util.Collections;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.HashMap;
import android.content.Intent;
import android.os.Handler;
import android.content.Context;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import android.database.DataSetObservable;

class ActivityChooserModel extends DataSetObservable
{
    private static final String ATTRIBUTE_ACTIVITY = "activity";
    private static final String ATTRIBUTE_TIME = "time";
    private static final String ATTRIBUTE_WEIGHT = "weight";
    private static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = -1;
    private static final String LOG_TAG;
    private static final Executor SERIAL_EXECUTOR;
    private static final String TAG_HISTORICAL_RECORD = "historical-record";
    private static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private static final Map<String, ActivityChooserModel> sDataModelRegistry;
    private static final Object sRegistryLock;
    private final List<ActivityChooserModel$ActivityResolveInfo> mActivites;
    private ActivityChooserModel$OnChooseActivityListener mActivityChoserModelPolicy;
    private ActivityChooserModel$ActivitySorter mActivitySorter;
    private boolean mCanReadHistoricalData;
    private final Context mContext;
    private final Handler mHandler;
    private final List<ActivityChooserModel$HistoricalRecord> mHistoricalRecords;
    private boolean mHistoricalRecordsChanged;
    private final String mHistoryFileName;
    private int mHistoryMaxSize;
    private final Object mInstanceLock;
    private Intent mIntent;
    private boolean mReadShareHistoryCalled;
    
    static {
        LOG_TAG = ActivityChooserModel.class.getSimpleName();
        sRegistryLock = new Object();
        sDataModelRegistry = new HashMap<String, ActivityChooserModel>();
        SERIAL_EXECUTOR = Executors.newSingleThreadExecutor();
    }
    
    private ActivityChooserModel(final Context context, final String s) {
        this.mInstanceLock = new Object();
        this.mActivites = new ArrayList<ActivityChooserModel$ActivityResolveInfo>();
        this.mHistoricalRecords = new ArrayList<ActivityChooserModel$HistoricalRecord>();
        this.mActivitySorter = new ActivityChooserModel$DefaultSorter(this, null);
        this.mHistoryMaxSize = 50;
        this.mCanReadHistoricalData = true;
        this.mReadShareHistoryCalled = false;
        this.mHistoricalRecordsChanged = true;
        this.mHandler = new Handler();
        this.mContext = context.getApplicationContext();
        if (!TextUtils.isEmpty((CharSequence)s) && !s.endsWith(".xml")) {
            this.mHistoryFileName = s + ".xml";
            return;
        }
        this.mHistoryFileName = s;
    }
    
    private boolean addHisoricalRecord(final ActivityChooserModel$HistoricalRecord activityChooserModel$HistoricalRecord) {
        synchronized (this.mInstanceLock) {
            final boolean add = this.mHistoricalRecords.add(activityChooserModel$HistoricalRecord);
            if (add) {
                this.mHistoricalRecordsChanged = true;
                this.pruneExcessiveHistoricalRecordsLocked();
                this.persistHistoricalData();
                this.sortActivities();
            }
            return add;
        }
    }
    
    public static ActivityChooserModel get(final Context context, final String s) {
        synchronized (ActivityChooserModel.sRegistryLock) {
            ActivityChooserModel activityChooserModel = ActivityChooserModel.sDataModelRegistry.get(s);
            if (activityChooserModel == null) {
                activityChooserModel = new ActivityChooserModel(context, s);
                ActivityChooserModel.sDataModelRegistry.put(s, activityChooserModel);
            }
            activityChooserModel.readHistoricalData();
            return activityChooserModel;
        }
    }
    
    private void loadActivitiesLocked() {
        this.mActivites.clear();
        if (this.mIntent != null) {
            final List queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
            for (int size = queryIntentActivities.size(), i = 0; i < size; ++i) {
                this.mActivites.add(new ActivityChooserModel$ActivityResolveInfo(this, queryIntentActivities.get(i)));
            }
            this.sortActivities();
            return;
        }
        this.notifyChanged();
    }
    
    private void persistHistoricalData() {
        synchronized (this.mInstanceLock) {
            if (!this.mReadShareHistoryCalled) {
                throw new IllegalStateException("No preceding call to #readHistoricalData");
            }
        }
        if (!this.mHistoricalRecordsChanged) {
            // monitorexit(o)
            return;
        }
        this.mHistoricalRecordsChanged = false;
        this.mCanReadHistoricalData = true;
        if (!TextUtils.isEmpty((CharSequence)this.mHistoryFileName)) {
            ActivityChooserModel.SERIAL_EXECUTOR.execute(new ActivityChooserModel$HistoryPersister(this, null));
        }
    }
    // monitorexit(o)
    
    private void pruneExcessiveHistoricalRecordsLocked() {
        final List<ActivityChooserModel$HistoricalRecord> mHistoricalRecords = this.mHistoricalRecords;
        final int n = mHistoricalRecords.size() - this.mHistoryMaxSize;
        if (n > 0) {
            this.mHistoricalRecordsChanged = true;
            for (int i = 0; i < n; ++i) {
                final ActivityChooserModel$HistoricalRecord activityChooserModel$HistoricalRecord = mHistoricalRecords.remove(0);
            }
        }
    }
    
    private void readHistoricalData() {
        synchronized (this.mInstanceLock) {
            if (!this.mCanReadHistoricalData || !this.mHistoricalRecordsChanged) {
                return;
            }
            this.mCanReadHistoricalData = false;
            this.mReadShareHistoryCalled = true;
            if (!TextUtils.isEmpty((CharSequence)this.mHistoryFileName)) {
                ActivityChooserModel.SERIAL_EXECUTOR.execute(new ActivityChooserModel$HistoryLoader(this, null));
            }
        }
    }
    
    private void sortActivities() {
        synchronized (this.mInstanceLock) {
            if (this.mActivitySorter != null && !this.mActivites.isEmpty()) {
                this.mActivitySorter.sort(this.mIntent, this.mActivites, Collections.unmodifiableList((List<? extends ActivityChooserModel$HistoricalRecord>)this.mHistoricalRecords));
                this.notifyChanged();
            }
        }
    }
    
    public Intent chooseActivity(final int n) {
        final ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo = this.mActivites.get(n);
        final ComponentName component = new ComponentName(activityChooserModel$ActivityResolveInfo.resolveInfo.activityInfo.packageName, activityChooserModel$ActivityResolveInfo.resolveInfo.activityInfo.name);
        final Intent intent = new Intent(this.mIntent);
        intent.setComponent(component);
        if (this.mActivityChoserModelPolicy != null && this.mActivityChoserModelPolicy.onChooseActivity(this, new Intent(intent))) {
            return null;
        }
        this.addHisoricalRecord(new ActivityChooserModel$HistoricalRecord(component, System.currentTimeMillis(), 1.0f));
        return intent;
    }
    
    public ResolveInfo getActivity(final int n) {
        synchronized (this.mInstanceLock) {
            return this.mActivites.get(n).resolveInfo;
        }
    }
    
    public int getActivityCount() {
        synchronized (this.mInstanceLock) {
            return this.mActivites.size();
        }
    }
    
    public int getActivityIndex(final ResolveInfo resolveInfo) {
        final List<ActivityChooserModel$ActivityResolveInfo> mActivites = this.mActivites;
        for (int size = mActivites.size(), i = 0; i < size; ++i) {
            if (mActivites.get(i).resolveInfo == resolveInfo) {
                return i;
            }
        }
        return -1;
    }
    
    public ResolveInfo getDefaultActivity() {
        synchronized (this.mInstanceLock) {
            if (!this.mActivites.isEmpty()) {
                return this.mActivites.get(0).resolveInfo;
            }
            return null;
        }
    }
    
    public int getHistoryMaxSize() {
        synchronized (this.mInstanceLock) {
            return this.mHistoryMaxSize;
        }
    }
    
    public int getHistorySize() {
        synchronized (this.mInstanceLock) {
            return this.mHistoricalRecords.size();
        }
    }
    
    public Intent getIntent() {
        synchronized (this.mInstanceLock) {
            return this.mIntent;
        }
    }
    
    public void setActivitySorter(final ActivityChooserModel$ActivitySorter mActivitySorter) {
        synchronized (this.mInstanceLock) {
            if (this.mActivitySorter == mActivitySorter) {
                return;
            }
            this.mActivitySorter = mActivitySorter;
            this.sortActivities();
        }
    }
    
    public void setDefaultActivity(final int n) {
        final ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo = this.mActivites.get(n);
        final ActivityChooserModel$ActivityResolveInfo activityChooserModel$ActivityResolveInfo2 = this.mActivites.get(0);
        float n2;
        if (activityChooserModel$ActivityResolveInfo2 != null) {
            n2 = 5.0f + (activityChooserModel$ActivityResolveInfo2.weight - activityChooserModel$ActivityResolveInfo.weight);
        }
        else {
            n2 = 1.0f;
        }
        this.addHisoricalRecord(new ActivityChooserModel$HistoricalRecord(new ComponentName(activityChooserModel$ActivityResolveInfo.resolveInfo.activityInfo.packageName, activityChooserModel$ActivityResolveInfo.resolveInfo.activityInfo.name), System.currentTimeMillis(), n2));
    }
    
    public void setHistoryMaxSize(final int mHistoryMaxSize) {
        synchronized (this.mInstanceLock) {
            if (this.mHistoryMaxSize == mHistoryMaxSize) {
                return;
            }
            this.mHistoryMaxSize = mHistoryMaxSize;
            this.pruneExcessiveHistoricalRecordsLocked();
            this.sortActivities();
        }
    }
    
    public void setIntent(final Intent mIntent) {
        synchronized (this.mInstanceLock) {
            if (this.mIntent == mIntent) {
                return;
            }
            this.mIntent = mIntent;
            this.loadActivitiesLocked();
        }
    }
    
    public void setOnChooseActivityListener(final ActivityChooserModel$OnChooseActivityListener mActivityChoserModelPolicy) {
        this.mActivityChoserModelPolicy = mActivityChoserModelPolicy;
    }
}
