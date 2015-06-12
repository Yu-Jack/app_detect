// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;
import android.content.Context;
import com.google.analytics.containertag.proto.Serving;

class ResourceLoaderSchedulerImpl implements ResourceLoaderScheduler
{
    private static final boolean MAY_INTERRUPT_IF_RUNNING = true;
    private LoadCallback<Serving.SupplementedResource> mCallback;
    private boolean mClosed;
    private final String mContainerId;
    private final Context mContext;
    private CtfeHost mCtfeHost;
    private String mCtfeUrlPathAndQuery;
    private final ScheduledExecutorService mExecutor;
    private ScheduledFuture<?> mFuture;
    private final ResourceLoaderFactory mResourceLoaderFactory;
    
    public ResourceLoaderSchedulerImpl(final Context context, final String s, final CtfeHost ctfeHost) {
        this(context, s, ctfeHost, null, null);
    }
    
    ResourceLoaderSchedulerImpl(final Context mContext, final String mContainerId, final CtfeHost mCtfeHost, ScheduledExecutorServiceFactory scheduledExecutorServiceFactory, final ResourceLoaderFactory mResourceLoaderFactory) {
        this.mCtfeHost = mCtfeHost;
        this.mContext = mContext;
        this.mContainerId = mContainerId;
        if (scheduledExecutorServiceFactory == null) {
            scheduledExecutorServiceFactory = (ScheduledExecutorServiceFactory)new ScheduledExecutorServiceFactory() {
                @Override
                public ScheduledExecutorService createExecutorService() {
                    return Executors.newSingleThreadScheduledExecutor();
                }
            };
        }
        this.mExecutor = scheduledExecutorServiceFactory.createExecutorService();
        if (mResourceLoaderFactory == null) {
            this.mResourceLoaderFactory = (ResourceLoaderFactory)new ResourceLoaderFactory() {
                @Override
                public ResourceLoader createResourceLoader(final CtfeHost ctfeHost) {
                    return new ResourceLoader(ResourceLoaderSchedulerImpl.this.mContext, ResourceLoaderSchedulerImpl.this.mContainerId, ctfeHost);
                }
            };
            return;
        }
        this.mResourceLoaderFactory = mResourceLoaderFactory;
    }
    
    private ResourceLoader createResourceLoader(final String previousVersion) {
        final ResourceLoader resourceLoader = this.mResourceLoaderFactory.createResourceLoader(this.mCtfeHost);
        resourceLoader.setLoadCallback(this.mCallback);
        resourceLoader.setCtfeURLPathAndQuery(this.mCtfeUrlPathAndQuery);
        resourceLoader.setPreviousVersion(previousVersion);
        return resourceLoader;
    }
    
    private void ensureNotClosed() {
        synchronized (this) {
            if (this.mClosed) {
                throw new IllegalStateException("called method after closed");
            }
        }
    }
    // monitorexit(this)
    
    @Override
    public void close() {
        synchronized (this) {
            this.ensureNotClosed();
            if (this.mFuture != null) {
                this.mFuture.cancel(false);
            }
            this.mExecutor.shutdown();
            this.mClosed = true;
        }
    }
    
    @Override
    public void loadAfterDelay(final long lng, final String s) {
        synchronized (this) {
            Log.v("loadAfterDelay: containerId=" + this.mContainerId + " delay=" + lng);
            this.ensureNotClosed();
            if (this.mCallback == null) {
                throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
            }
        }
        if (this.mFuture != null) {
            this.mFuture.cancel(false);
        }
        this.mFuture = this.mExecutor.schedule(this.createResourceLoader(s), lng, TimeUnit.MILLISECONDS);
    }
    // monitorexit(this)
    
    @Override
    public void setCtfeURLPathAndQuery(final String mCtfeUrlPathAndQuery) {
        synchronized (this) {
            this.ensureNotClosed();
            this.mCtfeUrlPathAndQuery = mCtfeUrlPathAndQuery;
        }
    }
    
    @Override
    public void setLoadCallback(final LoadCallback<Serving.SupplementedResource> mCallback) {
        synchronized (this) {
            this.ensureNotClosed();
            this.mCallback = mCallback;
        }
    }
    
    interface ResourceLoaderFactory
    {
        ResourceLoader createResourceLoader(CtfeHost p0);
    }
    
    interface ScheduledExecutorServiceFactory
    {
        ScheduledExecutorService createExecutorService();
    }
}
