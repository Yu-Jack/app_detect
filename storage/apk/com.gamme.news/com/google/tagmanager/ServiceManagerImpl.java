// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.os.Message;
import android.os.Handler$Callback;
import com.google.android.gms.common.util.VisibleForTesting;
import android.os.Handler;
import android.content.Context;

class ServiceManagerImpl extends ServiceManager
{
    private static final int MSG_KEY = 1;
    private static final Object MSG_OBJECT;
    private static ServiceManagerImpl instance;
    private boolean connected;
    private Context ctx;
    private int dispatchPeriodInSeconds;
    private Handler handler;
    private boolean listenForNetwork;
    private HitStoreStateListener listener;
    private NetworkReceiver networkReceiver;
    private boolean pendingDispatch;
    private boolean readyToDispatch;
    private HitStore store;
    private boolean storeIsEmpty;
    private volatile HitSendingThread thread;
    
    static {
        MSG_OBJECT = new Object();
    }
    
    private ServiceManagerImpl() {
        this.dispatchPeriodInSeconds = 1800;
        this.pendingDispatch = true;
        this.readyToDispatch = false;
        this.connected = true;
        this.listenForNetwork = true;
        this.listener = new HitStoreStateListener() {
            @Override
            public void reportStoreIsEmpty(final boolean b) {
                ServiceManagerImpl.this.updatePowerSaveMode(b, ServiceManagerImpl.this.connected);
            }
        };
        this.storeIsEmpty = false;
    }
    
    ServiceManagerImpl(final Context context, final HitSendingThread thread, final HitStore store, final boolean listenForNetwork) {
        this.dispatchPeriodInSeconds = 1800;
        this.pendingDispatch = true;
        this.readyToDispatch = false;
        this.connected = true;
        this.listenForNetwork = true;
        this.listener = new HitStoreStateListener() {
            @Override
            public void reportStoreIsEmpty(final boolean b) {
                ServiceManagerImpl.this.updatePowerSaveMode(b, ServiceManagerImpl.this.connected);
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
        ServiceManagerImpl.instance = null;
    }
    
    public static ServiceManagerImpl getInstance() {
        if (ServiceManagerImpl.instance == null) {
            ServiceManagerImpl.instance = new ServiceManagerImpl();
        }
        return ServiceManagerImpl.instance;
    }
    
    private void initializeHandler() {
        this.handler = new Handler(this.ctx.getMainLooper(), (Handler$Callback)new Handler$Callback() {
            public boolean handleMessage(final Message message) {
                if (1 == message.what && ServiceManagerImpl.MSG_OBJECT.equals(message.obj)) {
                    ServiceManagerImpl.this.dispatch();
                    if (ServiceManagerImpl.this.dispatchPeriodInSeconds > 0 && !ServiceManagerImpl.this.storeIsEmpty) {
                        ServiceManagerImpl.this.handler.sendMessageDelayed(ServiceManagerImpl.this.handler.obtainMessage(1, ServiceManagerImpl.MSG_OBJECT), (long)(1000 * ServiceManagerImpl.this.dispatchPeriodInSeconds));
                    }
                }
                return true;
            }
        });
        if (this.dispatchPeriodInSeconds > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1, ServiceManagerImpl.MSG_OBJECT), (long)(1000 * this.dispatchPeriodInSeconds));
        }
    }
    
    private void initializeNetworkReceiver() {
        (this.networkReceiver = new NetworkReceiver(this)).register(this.ctx);
    }
    
    public void dispatch() {
        synchronized (this) {
            if (!this.readyToDispatch) {
                Log.v("Dispatch call queued. Dispatch will run once initialization is complete.");
                this.pendingDispatch = true;
            }
            else {
                this.thread.queueToThread(new Runnable() {
                    @Override
                    public void run() {
                        ServiceManagerImpl.this.store.dispatch();
                    }
                });
            }
        }
    }
    
    @VisibleForTesting
    HitStoreStateListener getListener() {
        return this.listener;
    }
    
    HitStore getStore() {
        Label_0050: {
            synchronized (this) {
                if (this.store != null) {
                    break Label_0050;
                }
                if (this.ctx == null) {
                    throw new IllegalStateException("Cant get a store unless we have a context");
                }
            }
            this.store = new PersistentHitStore(this.listener, this.ctx);
        }
        if (this.handler == null) {
            this.initializeHandler();
        }
        this.readyToDispatch = true;
        if (this.pendingDispatch) {
            this.dispatch();
            this.pendingDispatch = false;
        }
        if (this.networkReceiver == null && this.listenForNetwork) {
            this.initializeNetworkReceiver();
        }
        // monitorexit(this)
        return this.store;
    }
    
    void initialize(final Context context, final HitSendingThread thread) {
        synchronized (this) {
            if (this.ctx == null) {
                this.ctx = context.getApplicationContext();
                if (this.thread == null) {
                    this.thread = thread;
                }
            }
        }
    }
    
    @Override
    void onRadioPowered() {
        synchronized (this) {
            if (!this.storeIsEmpty && this.connected && this.dispatchPeriodInSeconds > 0) {
                this.handler.removeMessages(1, ServiceManagerImpl.MSG_OBJECT);
                this.handler.sendMessage(this.handler.obtainMessage(1, ServiceManagerImpl.MSG_OBJECT));
            }
        }
    }
    
    public void setDispatchPeriod(final int n) {
        synchronized (this) {
            if (this.handler == null) {
                Log.v("Dispatch period set with null handler. Dispatch will run once initialization is complete.");
                this.dispatchPeriodInSeconds = n;
            }
            else {
                if (!this.storeIsEmpty && this.connected && this.dispatchPeriodInSeconds > 0) {
                    this.handler.removeMessages(1, ServiceManagerImpl.MSG_OBJECT);
                }
                if ((this.dispatchPeriodInSeconds = n) > 0 && !this.storeIsEmpty && this.connected) {
                    this.handler.sendMessageDelayed(this.handler.obtainMessage(1, ServiceManagerImpl.MSG_OBJECT), (long)(n * 1000));
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
                                    this.handler.removeMessages(1, ServiceManagerImpl.MSG_OBJECT);
                                }
                                if (!storeIsEmpty && connected && this.dispatchPeriodInSeconds > 0) {
                                    this.handler.sendMessageDelayed(this.handler.obtainMessage(1, ServiceManagerImpl.MSG_OBJECT), (long)(1000 * this.dispatchPeriodInSeconds));
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
