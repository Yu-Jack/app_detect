// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import android.os.Message;
import android.os.Handler$Callback;
import com.google.android.gms.common.util.VisibleForTesting;
import android.os.Handler;
import android.content.Context;

public class GAServiceManager extends ServiceManager
{
    private static final int MSG_KEY = 1;
    private static final Object MSG_OBJECT;
    private static GAServiceManager instance;
    private boolean connected;
    private Context ctx;
    private int dispatchPeriodInSeconds;
    private Handler handler;
    private boolean listenForNetwork;
    private AnalyticsStoreStateListener listener;
    private GANetworkReceiver networkReceiver;
    private boolean pendingDispatch;
    private boolean pendingForceLocalDispatch;
    private String pendingHostOverride;
    private AnalyticsStore store;
    private boolean storeIsEmpty;
    private volatile AnalyticsThread thread;
    
    static {
        MSG_OBJECT = new Object();
    }
    
    private GAServiceManager() {
        this.dispatchPeriodInSeconds = 1800;
        this.pendingDispatch = true;
        this.connected = true;
        this.listenForNetwork = true;
        this.listener = new AnalyticsStoreStateListener() {
            @Override
            public void reportStoreIsEmpty(final boolean b) {
                GAServiceManager.this.updatePowerSaveMode(b, GAServiceManager.this.connected);
            }
        };
        this.storeIsEmpty = false;
    }
    
    GAServiceManager(final Context context, final AnalyticsThread thread, final AnalyticsStore store, final boolean listenForNetwork) {
        this.dispatchPeriodInSeconds = 1800;
        this.pendingDispatch = true;
        this.connected = true;
        this.listenForNetwork = true;
        this.listener = new AnalyticsStoreStateListener() {
            @Override
            public void reportStoreIsEmpty(final boolean b) {
                GAServiceManager.this.updatePowerSaveMode(b, GAServiceManager.this.connected);
            }
        };
        this.storeIsEmpty = false;
        this.store = store;
        this.thread = thread;
        this.listenForNetwork = listenForNetwork;
        this.initialize(context, thread);
    }
    
    @VisibleForTesting
    static void clearInstance() {
        GAServiceManager.instance = null;
    }
    
    public static GAServiceManager getInstance() {
        if (GAServiceManager.instance == null) {
            GAServiceManager.instance = new GAServiceManager();
        }
        return GAServiceManager.instance;
    }
    
    private void initializeHandler() {
        this.handler = new Handler(this.ctx.getMainLooper(), (Handler$Callback)new Handler$Callback() {
            public boolean handleMessage(final Message message) {
                if (1 == message.what && GAServiceManager.MSG_OBJECT.equals(message.obj)) {
                    GAUsage.getInstance().setDisableUsage(true);
                    GAServiceManager.this.dispatchLocalHits();
                    GAUsage.getInstance().setDisableUsage(false);
                    if (GAServiceManager.this.dispatchPeriodInSeconds > 0 && !GAServiceManager.this.storeIsEmpty) {
                        GAServiceManager.this.handler.sendMessageDelayed(GAServiceManager.this.handler.obtainMessage(1, GAServiceManager.MSG_OBJECT), (long)(1000 * GAServiceManager.this.dispatchPeriodInSeconds));
                    }
                }
                return true;
            }
        });
        if (this.dispatchPeriodInSeconds > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1, GAServiceManager.MSG_OBJECT), (long)(1000 * this.dispatchPeriodInSeconds));
        }
    }
    
    private void initializeNetworkReceiver() {
        (this.networkReceiver = new GANetworkReceiver(this)).register(this.ctx);
    }
    
    @Deprecated
    @Override
    public void dispatchLocalHits() {
        synchronized (this) {
            if (this.thread == null) {
                Log.v("Dispatch call queued. Dispatch will run once initialization is complete.");
                this.pendingDispatch = true;
            }
            else {
                GAUsage.getInstance().setUsage(GAUsage.Field.DISPATCH);
                this.thread.dispatch();
            }
        }
    }
    
    @VisibleForTesting
    AnalyticsStoreStateListener getListener() {
        return this.listener;
    }
    
    AnalyticsStore getStore() {
        Label_0080: {
            synchronized (this) {
                if (this.store != null) {
                    break Label_0080;
                }
                if (this.ctx == null) {
                    throw new IllegalStateException("Cant get a store unless we have a context");
                }
            }
            this.store = new PersistentAnalyticsStore(this.listener, this.ctx);
            if (this.pendingHostOverride != null) {
                this.store.getDispatcher().overrideHostUrl(this.pendingHostOverride);
                this.pendingHostOverride = null;
            }
        }
        if (this.handler == null) {
            this.initializeHandler();
        }
        if (this.networkReceiver == null && this.listenForNetwork) {
            this.initializeNetworkReceiver();
        }
        // monitorexit(this)
        return this.store;
    }
    
    void initialize(final Context context, final AnalyticsThread thread) {
        synchronized (this) {
            if (this.ctx == null) {
                this.ctx = context.getApplicationContext();
                if (this.thread == null) {
                    this.thread = thread;
                    if (this.pendingDispatch) {
                        this.dispatchLocalHits();
                        this.pendingDispatch = false;
                    }
                    if (this.pendingForceLocalDispatch) {
                        this.setForceLocalDispatch();
                        this.pendingForceLocalDispatch = false;
                    }
                }
            }
        }
    }
    
    @Override
    void onRadioPowered() {
        synchronized (this) {
            if (!this.storeIsEmpty && this.connected && this.dispatchPeriodInSeconds > 0) {
                this.handler.removeMessages(1, GAServiceManager.MSG_OBJECT);
                this.handler.sendMessage(this.handler.obtainMessage(1, GAServiceManager.MSG_OBJECT));
            }
        }
    }
    
    @VisibleForTesting
    void overrideHostUrl(final String pendingHostOverride) {
        synchronized (this) {
            if (this.store == null) {
                this.pendingHostOverride = pendingHostOverride;
            }
            else {
                this.store.getDispatcher().overrideHostUrl(pendingHostOverride);
            }
        }
    }
    
    @Deprecated
    @Override
    public void setForceLocalDispatch() {
        if (this.thread == null) {
            Log.v("setForceLocalDispatch() queued. It will be called once initialization is complete.");
            this.pendingForceLocalDispatch = true;
            return;
        }
        GAUsage.getInstance().setUsage(GAUsage.Field.SET_FORCE_LOCAL_DISPATCH);
        this.thread.setForceLocalDispatch();
    }
    
    @Deprecated
    @Override
    public void setLocalDispatchPeriod(final int n) {
        synchronized (this) {
            if (this.handler == null) {
                Log.v("Dispatch period set with null handler. Dispatch will run once initialization is complete.");
                this.dispatchPeriodInSeconds = n;
            }
            else {
                GAUsage.getInstance().setUsage(GAUsage.Field.SET_DISPATCH_PERIOD);
                if (!this.storeIsEmpty && this.connected && this.dispatchPeriodInSeconds > 0) {
                    this.handler.removeMessages(1, GAServiceManager.MSG_OBJECT);
                }
                if ((this.dispatchPeriodInSeconds = n) > 0 && !this.storeIsEmpty && this.connected) {
                    this.handler.sendMessageDelayed(this.handler.obtainMessage(1, GAServiceManager.MSG_OBJECT), (long)(n * 1000));
                }
            }
        }
    }
    
    @Override
    void updateConnectivityStatus(final boolean b) {
        synchronized (this) {
            this.updatePowerSaveMode(this.storeIsEmpty, b);
        }
    }
    
    @VisibleForTesting
    void updatePowerSaveMode(final boolean storeIsEmpty, final boolean connected) {
        while (true) {
            while (true) {
                Label_0157: {
                    Label_0150: {
                        synchronized (this) {
                            if (this.storeIsEmpty != storeIsEmpty || this.connected != connected) {
                                if ((storeIsEmpty || !connected) && this.dispatchPeriodInSeconds > 0) {
                                    this.handler.removeMessages(1, GAServiceManager.MSG_OBJECT);
                                }
                                if (!storeIsEmpty && connected && this.dispatchPeriodInSeconds > 0) {
                                    this.handler.sendMessageDelayed(this.handler.obtainMessage(1, GAServiceManager.MSG_OBJECT), (long)(1000 * this.dispatchPeriodInSeconds));
                                }
                                final StringBuilder append = new StringBuilder().append("PowerSaveMode ");
                                if (!storeIsEmpty && connected) {
                                    break Label_0150;
                                }
                                break Label_0157;
                            }
                            return;
                            final StringBuilder append;
                            final String str;
                            Log.v(append.append(str).toString());
                            this.storeIsEmpty = storeIsEmpty;
                            this.connected = connected;
                            return;
                        }
                    }
                    final String str = "terminated.";
                    continue;
                }
                final String str = "initiated.";
                continue;
            }
        }
    }
}
