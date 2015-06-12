// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import com.google.analytics.containertag.proto.Serving;
import java.util.Map;
import com.google.tagmanager.proto.Resource;
import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;

public class Container
{
    static final boolean ENABLE_CONTAINER_DEBUG_MODE = false;
    @VisibleForTesting
    static final int MAX_NUMBER_OF_TOKENS = 30;
    static final int MINIMUM_REFRESH_PERIOD_BURST_MODE_MS = 5000;
    static final long MINIMUM_REFRESH_PERIOD_MS = 900000L;
    static final long REFRESH_PERIOD_ON_FAILURE_MS = 3600000L;
    static final long REFRESH_PERIOD_ON_SUCCESS_MS = 43200000L;
    private Clock mClock;
    private final String mContainerId;
    private final Context mContext;
    private CtfeHost mCtfeHost;
    private volatile String mCtfeServerAddress;
    private volatile String mCtfeUrlPathAndQuery;
    @VisibleForTesting
    LoadCallback<Resource.ResourceWithMetadata> mDiskLoadCallback;
    private Map<String, FunctionCallMacroHandler> mFunctionCallMacroHandlers;
    private Map<String, FunctionCallTagHandler> mFunctionCallTagHandlers;
    private Serving.SupplementedResource mLastLoadedSupplementedResource;
    private volatile long mLastRefreshMethodCalledTime;
    private volatile long mLastRefreshTime;
    @VisibleForTesting
    LoadCallback<Serving.SupplementedResource> mNetworkLoadCallback;
    private ResourceLoaderScheduler mNetworkLoadScheduler;
    private volatile int mNumTokens;
    private volatile int mResourceFormatVersion;
    private ResourceStorage mResourceStorage;
    private volatile String mResourceVersion;
    private Runtime mRuntime;
    private final TagManager mTagManager;
    private Callback mUserCallback;
    
    Container(final Context context, final String s, final TagManager tagManager) {
        this(context, s, tagManager, (ResourceStorage)new ResourceStorageImpl(context, s));
    }
    
    Container(final Context mContext, final String mContainerId, final TagManager mTagManager, final ResourceStorage mResourceStorage) {
        this.mResourceVersion = "";
        this.mResourceFormatVersion = 0;
        this.mCtfeHost = new CtfeHost();
        this.mContext = mContext;
        this.mContainerId = mContainerId;
        this.mTagManager = mTagManager;
        this.mLastLoadedSupplementedResource = new Serving.SupplementedResource();
        this.mResourceStorage = mResourceStorage;
        this.mNumTokens = 30;
        this.mFunctionCallMacroHandlers = new HashMap<String, FunctionCallMacroHandler>();
        this.mFunctionCallTagHandlers = new HashMap<String, FunctionCallTagHandler>();
        this.createInitialContainer();
    }
    
    private void callRefreshBegin(final RefreshType refreshType) {
        synchronized (this) {
            if (this.mUserCallback != null) {
                this.mUserCallback.containerRefreshBegin(this, refreshType);
            }
        }
    }
    
    private void callRefreshFailure(final RefreshType refreshType, final RefreshFailure refreshFailure) {
        synchronized (this) {
            if (this.mUserCallback != null) {
                this.mUserCallback.containerRefreshFailure(this, refreshType, refreshFailure);
            }
        }
    }
    
    private void callRefreshSuccess(final RefreshType obj) {
        synchronized (this) {
            Log.v("calling containerRefreshSuccess(" + obj + "): mUserCallback = " + this.mUserCallback);
            if (this.mUserCallback != null) {
                this.mUserCallback.containerRefreshSuccess(this, obj);
            }
        }
    }
    
    private void createInitialContainer() {
        final String string = "tagmanager/" + this.mContainerId;
        final Serving.Resource loadResourceFromContainerAsset = this.mResourceStorage.loadResourceFromContainerAsset(string);
        if (loadResourceFromContainerAsset != null) {
            this.initEvaluators(loadResourceFromContainerAsset);
            return;
        }
        ResourceUtil.ExpandedResource expandedResource = this.mResourceStorage.loadExpandedResourceFromJsonAsset(string + ".json");
        if (expandedResource == null) {
            Log.w("No default container found; creating an empty container.");
            expandedResource = ResourceUtil.ExpandedResource.newBuilder().build();
        }
        this.initEvaluatorsWithExpandedResource(expandedResource);
    }
    
    private Runtime getRuntime() {
        synchronized (this) {
            return this.mRuntime;
        }
    }
    
    private void initEvaluators(final Serving.Resource obj) {
        try {
            this.initEvaluatorsWithExpandedResource(ResourceUtil.getExpandedResource(obj));
        }
        catch (ResourceUtil.InvalidResourceException ex) {
            Log.e("Not loading resource: " + obj + " because it is invalid: " + ex.toString());
        }
    }
    
    private void initEvaluatorsWithExpandedResource(final ResourceUtil.ExpandedResource expandedResource) {
        this.mResourceVersion = expandedResource.getVersion();
        this.mResourceFormatVersion = expandedResource.getResourceFormatVersion();
        this.setRuntime(new Runtime(this.mContext, expandedResource, this.mTagManager.getDataLayer(), new FunctionCallMacroHandlerAdapter(), new FunctionCallTagHandlerAdapter(), this.createEventInfoDistributor(this.mResourceVersion)));
    }
    
    private boolean isContainerPreview() {
        final PreviewManager instance = PreviewManager.getInstance();
        return (instance.getPreviewMode() == PreviewManager.PreviewMode.CONTAINER || instance.getPreviewMode() == PreviewManager.PreviewMode.CONTAINER_DEBUG) && this.mContainerId.equals(instance.getContainerId());
    }
    
    private boolean isDefaultContainerRefreshMode() {
        return this.mTagManager.getRefreshMode() == TagManager.RefreshMode.DEFAULT_CONTAINER;
    }
    
    private void saveResourceToDisk(final Serving.SupplementedResource supplementedResource) {
        synchronized (this) {
            if (this.mResourceStorage != null) {
                final Resource.ResourceWithMetadata resourceWithMetadata = new Resource.ResourceWithMetadata();
                resourceWithMetadata.timeStamp = this.getLastRefreshTime();
                resourceWithMetadata.resource = new Serving.Resource();
                resourceWithMetadata.supplementedResource = supplementedResource;
                this.mResourceStorage.saveResourceToDiskInBackground(resourceWithMetadata);
            }
        }
    }
    
    private void setRuntime(final Runtime mRuntime) {
        synchronized (this) {
            this.mRuntime = mRuntime;
        }
    }
    
    private void setSupplementals(final Serving.Supplemental[] array) {
        final ArrayList<Serving.Supplemental> supplementals = new ArrayList<Serving.Supplemental>();
        for (int length = array.length, i = 0; i < length; ++i) {
            supplementals.add(array[i]);
        }
        this.getRuntime().setSupplementals(supplementals);
    }
    
    private boolean useAvailableToken(final long n) {
        if (this.mLastRefreshMethodCalledTime == 0L) {
            --this.mNumTokens;
            return true;
        }
        final long n2 = n - this.mLastRefreshMethodCalledTime;
        if (n2 < 5000L) {
            return false;
        }
        if (this.mNumTokens < 30) {
            this.mNumTokens = Math.min(30, (int)Math.floor(n2 / 900000L) + this.mNumTokens);
        }
        if (this.mNumTokens > 0) {
            --this.mNumTokens;
            return true;
        }
        return false;
    }
    
    public void close() {
        synchronized (this) {
            while (true) {
                try {
                    if (this.mNetworkLoadScheduler != null) {
                        this.mNetworkLoadScheduler.close();
                    }
                    this.mNetworkLoadScheduler = null;
                    if (this.mResourceStorage != null) {
                        this.mResourceStorage.close();
                    }
                    this.mResourceStorage = null;
                    this.mUserCallback = null;
                    this.mTagManager.removeContainer(this.mContainerId);
                    this.mRuntime = null;
                }
                catch (Exception ex) {
                    Log.e("Calling close() threw an exception: " + ex.getMessage());
                    continue;
                }
                break;
            }
        }
    }
    
    @VisibleForTesting
    EventInfoDistributor createEventInfoDistributor(final String s) {
        if (PreviewManager.getInstance().getPreviewMode().equals(PreviewManager.PreviewMode.CONTAINER_DEBUG)) {
            return new NoopEventInfoDistributor();
        }
        return new NoopEventInfoDistributor();
    }
    
    @VisibleForTesting
    void evaluateTags(final String s) {
        this.getRuntime().evaluateTags(s);
    }
    
    public boolean getBoolean(final String s) {
        final Runtime runtime = this.getRuntime();
        if (runtime == null) {
            Log.e("getBoolean called for closed container.");
            return Types.getDefaultBoolean();
        }
        try {
            return Types.valueToBoolean(runtime.evaluateMacroReference(s).getObject());
        }
        catch (Exception ex) {
            Log.e("Calling getBoolean() threw an exception: " + ex.getMessage() + " Returning default value.");
            return Types.getDefaultBoolean();
        }
    }
    
    public String getContainerId() {
        return this.mContainerId;
    }
    
    String getCtfeUrlPathAndQuery() {
        return this.mCtfeUrlPathAndQuery;
    }
    
    public double getDouble(final String s) {
        final Runtime runtime = this.getRuntime();
        if (runtime == null) {
            Log.e("getDouble called for closed container.");
            return Types.getDefaultDouble();
        }
        try {
            return Types.valueToDouble(runtime.evaluateMacroReference(s).getObject());
        }
        catch (Exception ex) {
            Log.e("Calling getDouble() threw an exception: " + ex.getMessage() + " Returning default value.");
            return Types.getDefaultDouble();
        }
    }
    
    public FunctionCallMacroHandler getFunctionCallMacroHandler(final String s) {
        synchronized (this) {
            return this.mFunctionCallMacroHandlers.get(s);
        }
    }
    
    public FunctionCallTagHandler getFunctionCallTagHandler(final String s) {
        synchronized (this) {
            return this.mFunctionCallTagHandlers.get(s);
        }
    }
    
    public long getLastRefreshTime() {
        return this.mLastRefreshTime;
    }
    
    public long getLong(final String s) {
        final Runtime runtime = this.getRuntime();
        if (runtime == null) {
            Log.e("getLong called for closed container.");
            return Types.getDefaultInt64();
        }
        try {
            return Types.valueToInt64(runtime.evaluateMacroReference(s).getObject());
        }
        catch (Exception ex) {
            Log.e("Calling getLong() threw an exception: " + ex.getMessage() + " Returning default value.");
            return Types.getDefaultInt64();
        }
    }
    
    @VisibleForTesting
    String getResourceVersion() {
        return this.mResourceVersion;
    }
    
    public String getString(final String s) {
        final Runtime runtime = this.getRuntime();
        if (runtime == null) {
            Log.e("getString called for closed container.");
            return Types.getDefaultString();
        }
        try {
            return Types.valueToString(runtime.evaluateMacroReference(s).getObject());
        }
        catch (Exception ex) {
            Log.e("Calling getString() threw an exception: " + ex.getMessage() + " Returning default value.");
            return Types.getDefaultString();
        }
    }
    
    public boolean isDefault() {
        return this.getLastRefreshTime() == 0L;
    }
    
    void load(final Callback callback) {
        this.load(callback, (ResourceLoaderScheduler)new ResourceLoaderSchedulerImpl(this.mContext, this.mContainerId, this.mCtfeHost), new Clock() {
            @Override
            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }
        });
    }
    
    @VisibleForTesting
    void load(final Callback mUserCallback, final ResourceLoaderScheduler mNetworkLoadScheduler, final Clock mClock) {
        synchronized (this) {
            if (this.mDiskLoadCallback != null) {
                throw new RuntimeException("Container already loaded: container ID: " + this.mContainerId);
            }
        }
        this.mClock = mClock;
        this.mUserCallback = mUserCallback;
        this.mDiskLoadCallback = new LoadCallback<Resource.ResourceWithMetadata>() {
            private RefreshFailure failureToRefreshFailure(final Failure failure) {
                switch (failure) {
                    default: {
                        return RefreshFailure.UNKNOWN_ERROR;
                    }
                    case NOT_AVAILABLE: {
                        return RefreshFailure.NO_SAVED_CONTAINER;
                    }
                    case IO_ERROR: {
                        return RefreshFailure.IO_ERROR;
                    }
                    case SERVER_ERROR: {
                        return RefreshFailure.SERVER_ERROR;
                    }
                }
            }
            
            @Override
            public void onFailure(final Failure failure) {
                Container.this.callRefreshFailure(RefreshType.SAVED, this.failureToRefreshFailure(failure));
                if (Container.this.isDefault()) {
                    Container.this.loadAfterDelay(0L);
                }
            }
            
            @Override
            public void onSuccess(final Resource.ResourceWithMetadata resourceWithMetadata) {
                if (Container.this.isDefault()) {
                    Serving.Resource resource;
                    if (resourceWithMetadata.supplementedResource != null) {
                        resource = resourceWithMetadata.supplementedResource.resource;
                        Container.this.mLastLoadedSupplementedResource = resourceWithMetadata.supplementedResource;
                    }
                    else {
                        resource = resourceWithMetadata.resource;
                        Container.this.mLastLoadedSupplementedResource.resource = resource;
                        Container.this.mLastLoadedSupplementedResource.supplemental = null;
                        Container.this.mLastLoadedSupplementedResource.fingerprint = resource.version;
                    }
                    Container.this.initEvaluators(resource);
                    if (Container.this.mLastLoadedSupplementedResource.supplemental != null) {
                        Container.this.setSupplementals(Container.this.mLastLoadedSupplementedResource.supplemental);
                    }
                    Log.v("setting refresh time to saved time: " + resourceWithMetadata.timeStamp);
                    Container.this.mLastRefreshTime = resourceWithMetadata.timeStamp;
                    Container.this.loadAfterDelay(Math.max(0L, Math.min(43200000L, 43200000L + Container.this.mLastRefreshTime - mClock.currentTimeMillis())));
                }
                Container.this.callRefreshSuccess(RefreshType.SAVED);
            }
            
            @Override
            public void startLoad() {
                Container.this.callRefreshBegin(RefreshType.SAVED);
            }
        };
        if (this.isDefaultContainerRefreshMode()) {
            Log.i("Container is in DEFAULT_CONTAINER mode. Use default container.");
        }
        else {
            this.mResourceStorage.setLoadCallback(this.mDiskLoadCallback);
            mNetworkLoadScheduler.setLoadCallback(this.mNetworkLoadCallback = new LoadCallback<Serving.SupplementedResource>() {
                private RefreshFailure failureToRefreshFailure(final Failure failure) {
                    switch (failure) {
                        default: {
                            return RefreshFailure.UNKNOWN_ERROR;
                        }
                        case NOT_AVAILABLE: {
                            return RefreshFailure.NO_NETWORK;
                        }
                        case IO_ERROR: {
                            return RefreshFailure.NETWORK_ERROR;
                        }
                        case SERVER_ERROR: {
                            return RefreshFailure.SERVER_ERROR;
                        }
                    }
                }
                
                @Override
                public void onFailure(final Failure failure) {
                    Container.this.loadAfterDelay(3600000L);
                    Container.this.callRefreshFailure(RefreshType.NETWORK, this.failureToRefreshFailure(failure));
                }
                
                @Override
                public void onSuccess(final Serving.SupplementedResource supplementedResource) {
                    synchronized (Container.this) {
                        final Serving.Resource resource = supplementedResource.resource;
                        if (resource != null) {
                            Container.this.initEvaluators(resource);
                            Container.this.mLastLoadedSupplementedResource.resource = resource;
                        }
                        else if (Container.this.mLastLoadedSupplementedResource.resource == null) {
                            this.onFailure(Failure.SERVER_ERROR);
                            return;
                        }
                        if (supplementedResource.supplemental.length > 0) {
                            Container.this.setSupplementals(supplementedResource.supplemental);
                            Container.this.mLastLoadedSupplementedResource.supplemental = supplementedResource.supplemental;
                        }
                        Container.this.mLastRefreshTime = mClock.currentTimeMillis();
                        Container.this.mLastLoadedSupplementedResource.fingerprint = supplementedResource.fingerprint;
                        if (Container.this.mLastLoadedSupplementedResource.fingerprint.length() == 0) {
                            Container.this.mLastLoadedSupplementedResource.fingerprint = Container.this.mLastLoadedSupplementedResource.resource.version;
                        }
                        Log.v("setting refresh time to current time: " + Container.this.mLastRefreshTime);
                        if (!Container.this.isContainerPreview()) {
                            Container.this.saveResourceToDisk(Container.this.mLastLoadedSupplementedResource);
                        }
                        Container.this.loadAfterDelay(43200000L);
                        // monitorexit(this.this$0)
                        Container.this.callRefreshSuccess(RefreshType.NETWORK);
                    }
                }
                
                @Override
                public void startLoad() {
                    Container.this.callRefreshBegin(RefreshType.NETWORK);
                }
            });
            if (this.isContainerPreview()) {
                mNetworkLoadScheduler.setCtfeURLPathAndQuery(this.mCtfeUrlPathAndQuery = PreviewManager.getInstance().getCTFEUrlPath());
            }
            if (this.mCtfeServerAddress != null) {
                this.mCtfeHost.setCtfeServerAddress(this.mCtfeServerAddress);
            }
            this.mNetworkLoadScheduler = mNetworkLoadScheduler;
            this.mResourceStorage.loadResourceFromDiskInBackground();
        }
    }
    // monitorexit(this)
    
    @VisibleForTesting
    void loadAfterDelay(final long n) {
        synchronized (this) {
            if (this.mNetworkLoadScheduler != null && !this.isDefaultContainerRefreshMode()) {
                this.mNetworkLoadScheduler.loadAfterDelay(n, this.mLastLoadedSupplementedResource.fingerprint);
            }
        }
    }
    
    public void refresh() {
        while (true) {
            Label_0069: {
                synchronized (this) {
                    if (this.getRuntime() == null) {
                        Log.w("refresh called for closed container");
                    }
                    else {
                        try {
                            if (!this.isDefaultContainerRefreshMode()) {
                                break Label_0069;
                            }
                            Log.w("Container is in DEFAULT_CONTAINER mode. Refresh request is ignored.");
                        }
                        catch (Exception ex) {
                            Log.e("Calling refresh() throws an exception: " + ex.getMessage());
                        }
                    }
                    return;
                }
            }
            final long currentTimeMillis = this.mClock.currentTimeMillis();
            if (this.useAvailableToken(currentTimeMillis)) {
                Log.v("Container refresh requested");
                this.loadAfterDelay(0L);
                this.mLastRefreshMethodCalledTime = currentTimeMillis;
                return;
            }
            Log.v("Container refresh was called too often. Ignored.");
        }
    }
    
    public void registerFunctionCallMacroHandler(final String s, final FunctionCallMacroHandler functionCallMacroHandler) {
        synchronized (this) {
            this.mFunctionCallMacroHandlers.put(s, functionCallMacroHandler);
        }
    }
    
    public void registerFunctionCallTagHandler(final String s, final FunctionCallTagHandler functionCallTagHandler) {
        synchronized (this) {
            this.mFunctionCallTagHandlers.put(s, functionCallTagHandler);
        }
    }
    
    @VisibleForTesting
    void setCtfeServerAddress(final String s) {
        synchronized (this) {
            this.mCtfeServerAddress = s;
            if (s != null) {
                this.mCtfeHost.setCtfeServerAddress(s);
            }
        }
    }
    
    @VisibleForTesting
    void setCtfeUrlPathAndQuery(final String s) {
        synchronized (this) {
            this.mCtfeUrlPathAndQuery = s;
            if (this.mNetworkLoadScheduler != null) {
                this.mNetworkLoadScheduler.setCtfeURLPathAndQuery(s);
            }
        }
    }
    
    public interface Callback
    {
        void containerRefreshBegin(Container p0, RefreshType p1);
        
        void containerRefreshFailure(Container p0, RefreshType p1, RefreshFailure p2);
        
        void containerRefreshSuccess(Container p0, RefreshType p1);
    }
    
    public interface FunctionCallMacroHandler
    {
        Object getValue(String p0, Map<String, Object> p1);
    }
    
    private class FunctionCallMacroHandlerAdapter implements CustomEvaluator
    {
        @Override
        public Object evaluate(final String s, final Map<String, Object> map) {
            final FunctionCallMacroHandler functionCallMacroHandler = Container.this.getFunctionCallMacroHandler(s);
            if (functionCallMacroHandler == null) {
                return null;
            }
            return functionCallMacroHandler.getValue(s, map);
        }
    }
    
    public interface FunctionCallTagHandler
    {
        void execute(String p0, Map<String, Object> p1);
    }
    
    private class FunctionCallTagHandlerAdapter implements CustomEvaluator
    {
        @Override
        public Object evaluate(final String s, final Map<String, Object> map) {
            Container.this.getFunctionCallTagHandler(s).execute(s, map);
            return Types.getDefaultString();
        }
    }
    
    public enum RefreshFailure
    {
        IO_ERROR, 
        NETWORK_ERROR, 
        NO_NETWORK, 
        NO_SAVED_CONTAINER, 
        SERVER_ERROR, 
        UNKNOWN_ERROR;
    }
    
    public enum RefreshType
    {
        NETWORK, 
        SAVED;
    }
    
    interface ResourceLoaderScheduler
    {
        void close();
        
        void loadAfterDelay(long p0, String p1);
        
        void setCtfeURLPathAndQuery(String p0);
        
        void setLoadCallback(LoadCallback<Serving.SupplementedResource> p0);
    }
    
    interface ResourceStorage
    {
        void close();
        
        ResourceUtil.ExpandedResource loadExpandedResourceFromJsonAsset(String p0);
        
        Serving.Resource loadResourceFromContainerAsset(String p0);
        
        void loadResourceFromDiskInBackground();
        
        void saveResourceToDiskInBackground(Resource.ResourceWithMetadata p0);
        
        void setLoadCallback(LoadCallback<Resource.ResourceWithMetadata> p0);
    }
}
