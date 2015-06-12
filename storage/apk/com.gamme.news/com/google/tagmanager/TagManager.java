// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.net.Uri;
import java.util.Iterator;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import android.content.Context;
import java.util.concurrent.ConcurrentMap;

public class TagManager
{
    private static TagManager sInstance;
    private final ContainerProvider mContainerProvider;
    private final ConcurrentMap<String, Container> mContainers;
    private final Context mContext;
    private volatile String mCtfeServerAddr;
    private final DataLayer mDataLayer;
    private volatile RefreshMode mRefreshMode;
    
    TagManager(final Context context, final ContainerProvider mContainerProvider, final DataLayer mDataLayer) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.mContainerProvider = mContainerProvider;
        this.mRefreshMode = RefreshMode.STANDARD;
        this.mContainers = new ConcurrentHashMap<String, Container>();
        (this.mDataLayer = mDataLayer).registerListener((DataLayer.Listener)new DataLayer.Listener() {
            @Override
            public void changed(final Map<Object, Object> map) {
                final Object value = map.get("event");
                if (value != null) {
                    TagManager.this.refreshTagsInAllContainers(value.toString());
                }
            }
        });
        this.mDataLayer.registerListener((DataLayer.Listener)new AdwordsClickReferrerListener(this.mContext));
    }
    
    @VisibleForTesting
    static void clearInstance() {
        synchronized (TagManager.class) {
            TagManager.sInstance = null;
        }
    }
    
    public static TagManager getInstance(final Context context) {
        Label_0065: {
            synchronized (TagManager.class) {
                if (TagManager.sInstance != null) {
                    break Label_0065;
                }
                if (context == null) {
                    Log.e("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
            }
            TagManager.sInstance = new TagManager(context, (ContainerProvider)new ContainerProvider() {
                @Override
                public Container newContainer(final Context context, final String s, final TagManager tagManager) {
                    return new Container(context, s, tagManager);
                }
            }, new DataLayer((DataLayer.PersistentStore)new DataLayerPersistentStoreImpl(context)));
        }
        // monitorexit(TagManager.class)
        return TagManager.sInstance;
    }
    
    private void refreshTagsInAllContainers(final String s) {
        final Iterator<Container> iterator = this.mContainers.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().evaluateTags(s);
        }
    }
    
    public Container getContainer(final String s) {
        return this.mContainers.get(s);
    }
    
    public Context getContext() {
        return this.mContext;
    }
    
    public DataLayer getDataLayer() {
        return this.mDataLayer;
    }
    
    public com.google.tagmanager.Logger getLogger() {
        return Log.getLogger();
    }
    
    public RefreshMode getRefreshMode() {
        return this.mRefreshMode;
    }
    
    public Container openContainer(final String str, final Container.Callback callback) {
        final Container container = this.mContainerProvider.newContainer(this.mContext, str, this);
        if (this.mContainers.putIfAbsent(str, container) != null) {
            throw new IllegalArgumentException("Container id:" + str + " has already been opened.");
        }
        if (this.mCtfeServerAddr != null) {
            container.setCtfeServerAddress(this.mCtfeServerAddr);
        }
        container.load(callback);
        return container;
    }
    
    boolean removeContainer(final String s) {
        return this.mContainers.remove(s) != null;
    }
    
    @VisibleForTesting
    void setCtfeServerAddress(final String mCtfeServerAddr) {
        this.mCtfeServerAddr = mCtfeServerAddr;
    }
    
    public void setLogger(final com.google.tagmanager.Logger logger) {
        Log.setLogger(logger);
    }
    
    boolean setPreviewData(final Uri previewData) {
    Label_0060_Outer:
        while (true) {
            while (true) {
                final PreviewManager instance;
                final String containerId;
                Label_0108: {
                    synchronized (this) {
                        instance = PreviewManager.getInstance();
                        if (instance.setPreviewData(previewData)) {
                            containerId = instance.getContainerId();
                            switch (instance.getPreviewMode()) {
                                case NONE: {
                                    final Container container = this.mContainers.get(containerId);
                                    if (container != null) {
                                        container.setCtfeUrlPathAndQuery(null);
                                        container.refresh();
                                        break;
                                    }
                                    break;
                                }
                                case CONTAINER:
                                case CONTAINER_DEBUG: {
                                    break Label_0108;
                                }
                            }
                            return true;
                        }
                        return false;
                    }
                }
                for (final Map.Entry<Object, Object> entry : this.mContainers.entrySet()) {
                    final Container container2 = entry.getValue();
                    if (entry.getKey().equals(containerId)) {
                        container2.setCtfeUrlPathAndQuery(instance.getCTFEUrlPath());
                        container2.refresh();
                    }
                    else {
                        if (container2.getCtfeUrlPathAndQuery() == null) {
                            continue Label_0060_Outer;
                        }
                        container2.setCtfeUrlPathAndQuery(null);
                        container2.refresh();
                    }
                }
                continue;
            }
            return false;
        }
    }
    
    public void setRefreshMode(final RefreshMode mRefreshMode) {
        this.mRefreshMode = mRefreshMode;
    }
    
    static class ContainerOpenException extends RuntimeException
    {
        private final String mContainerId;
        
        private ContainerOpenException(final String s) {
            super("Container already open: " + s);
            this.mContainerId = s;
        }
        
        public String getContainerId() {
            return this.mContainerId;
        }
    }
    
    @VisibleForTesting
    interface ContainerProvider
    {
        Container newContainer(Context p0, String p1, TagManager p2);
    }
    
    @Deprecated
    public interface Logger extends com.google.tagmanager.Logger
    {
    }
    
    public enum RefreshMode
    {
        DEFAULT_CONTAINER, 
        STANDARD;
    }
}
