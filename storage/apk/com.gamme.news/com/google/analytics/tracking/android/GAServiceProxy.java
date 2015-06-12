// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import android.content.Intent;
import com.google.android.gms.analytics.internal.Command;
import java.util.Collection;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;
import java.util.Timer;
import android.content.Context;

class GAServiceProxy implements ServiceProxy, OnConnectedListener, OnConnectionFailedListener
{
    private static final long FAILED_CONNECT_WAIT_TIME = 3000L;
    private static final int MAX_TRIES = 2;
    private static final long RECONNECT_WAIT_TIME = 5000L;
    private static final long SERVICE_CONNECTION_TIMEOUT = 300000L;
    private volatile AnalyticsClient client;
    private Clock clock;
    private volatile int connectTries;
    private final Context ctx;
    private volatile Timer disconnectCheckTimer;
    private volatile Timer failedConnectTimer;
    private boolean forceLocalDispatch;
    private final GoogleAnalytics gaInstance;
    private long idleTimeout;
    private volatile long lastRequestTime;
    private boolean pendingClearHits;
    private boolean pendingDispatch;
    private boolean pendingServiceDisconnect;
    private final Queue<HitParams> queue;
    private volatile Timer reConnectTimer;
    private volatile ConnectState state;
    private AnalyticsStore store;
    private AnalyticsStore testStore;
    private final AnalyticsThread thread;
    
    GAServiceProxy(final Context context, final AnalyticsThread analyticsThread) {
        this(context, analyticsThread, null, GoogleAnalytics.getInstance(context));
    }
    
    GAServiceProxy(final Context ctx, final AnalyticsThread thread, final AnalyticsStore testStore, final GoogleAnalytics gaInstance) {
        this.queue = new ConcurrentLinkedQueue<HitParams>();
        this.idleTimeout = 300000L;
        this.testStore = testStore;
        this.ctx = ctx;
        this.thread = thread;
        this.gaInstance = gaInstance;
        this.clock = new Clock() {
            @Override
            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }
        };
        this.connectTries = 0;
        this.state = ConnectState.DISCONNECTED;
    }
    
    private Timer cancelTimer(final Timer timer) {
        if (timer != null) {
            timer.cancel();
        }
        return null;
    }
    
    private void clearAllTimers() {
        this.reConnectTimer = this.cancelTimer(this.reConnectTimer);
        this.failedConnectTimer = this.cancelTimer(this.failedConnectTimer);
        this.disconnectCheckTimer = this.cancelTimer(this.disconnectCheckTimer);
    }
    
    private void connectToService() {
        while (true) {
            synchronized (this) {
                if (!this.forceLocalDispatch && this.client != null && this.state != ConnectState.CONNECTED_LOCAL) {
                    try {
                        ++this.connectTries;
                        this.cancelTimer(this.failedConnectTimer);
                        this.state = ConnectState.CONNECTING;
                        (this.failedConnectTimer = new Timer("Failed Connect")).schedule(new FailedConnectTask(), 3000L);
                        Log.v("connecting to Analytics service");
                        this.client.connect();
                        return;
                    }
                    catch (SecurityException ex) {
                        Log.w("security exception on connectToService");
                        this.useStore();
                    }
                }
            }
            Log.w("client not initialized.");
            this.useStore();
        }
    }
    
    private void disconnectFromService() {
        synchronized (this) {
            if (this.client != null && this.state == ConnectState.CONNECTED_SERVICE) {
                this.state = ConnectState.PENDING_DISCONNECT;
                this.client.disconnect();
            }
        }
    }
    
    private void dispatchToStore() {
        this.store.dispatch();
        this.pendingDispatch = false;
    }
    
    private void fireReconnectAttempt() {
        this.reConnectTimer = this.cancelTimer(this.reConnectTimer);
        (this.reConnectTimer = new Timer("Service Reconnect")).schedule(new ReconnectTask(), 5000L);
    }
    
    private void sendQueue() {
        while (true) {
            Label_0326: {
                Label_0191: {
                    Label_0205: {
                        synchronized (this) {
                            if (!Thread.currentThread().equals(this.thread.getThread())) {
                                this.thread.getQueue().add(new Runnable() {
                                    @Override
                                    public void run() {
                                        GAServiceProxy.this.sendQueue();
                                    }
                                });
                                return;
                            }
                            if (this.pendingClearHits) {
                                this.clearHits();
                            }
                            switch (this.state) {
                                case CONNECTED_LOCAL: {
                                    while (!this.queue.isEmpty()) {
                                        final HitParams obj = this.queue.poll();
                                        Log.v("Sending hit to store  " + obj);
                                        this.store.putHit(obj.getWireFormatParams(), obj.getHitTimeInMilliseconds(), obj.getPath(), obj.getCommands());
                                    }
                                    break;
                                }
                                case CONNECTED_SERVICE: {
                                    break Label_0205;
                                }
                                case DISCONNECTED: {
                                    break Label_0326;
                                }
                                default: {
                                    return;
                                }
                            }
                        }
                        break Label_0191;
                    }
                    while (!this.queue.isEmpty()) {
                        final HitParams obj2 = this.queue.peek();
                        Log.v("Sending hit to service   " + obj2);
                        if (!this.gaInstance.isDryRunEnabled()) {
                            this.client.sendHit(obj2.getWireFormatParams(), obj2.getHitTimeInMilliseconds(), obj2.getPath(), obj2.getCommands());
                        }
                        else {
                            Log.v("Dry run enabled. Hit not actually sent to service.");
                        }
                        this.queue.poll();
                    }
                    this.lastRequestTime = this.clock.currentTimeMillis();
                    return;
                }
                if (this.pendingDispatch) {
                    this.dispatchToStore();
                    return;
                }
                return;
            }
            Log.v("Need to reconnect");
            if (!this.queue.isEmpty()) {
                this.connectToService();
            }
        }
    }
    
    private void useStore() {
        while (true) {
            while (true) {
                Label_0063: {
                    synchronized (this) {
                        if (this.state != ConnectState.CONNECTED_LOCAL) {
                            this.clearAllTimers();
                            Log.v("falling back to local store");
                            if (this.testStore == null) {
                                break Label_0063;
                            }
                            this.store = this.testStore;
                            this.state = ConnectState.CONNECTED_LOCAL;
                            this.sendQueue();
                        }
                        return;
                    }
                }
                final GAServiceManager instance = GAServiceManager.getInstance();
                instance.initialize(this.ctx, this.thread);
                this.store = instance.getStore();
                continue;
            }
        }
    }
    
    @Override
    public void clearHits() {
        Log.v("clearHits called");
        this.queue.clear();
        switch (this.state) {
            default: {
                this.pendingClearHits = true;
            }
            case CONNECTED_LOCAL: {
                this.store.clearHits(0L);
                this.pendingClearHits = false;
            }
            case CONNECTED_SERVICE: {
                this.client.clearHits();
                this.pendingClearHits = false;
            }
        }
    }
    
    @Override
    public void createService() {
        if (this.client != null) {
            return;
        }
        this.client = new AnalyticsGmsCoreClient(this.ctx, (AnalyticsGmsCoreClient.OnConnectedListener)this, (AnalyticsGmsCoreClient.OnConnectionFailedListener)this);
        this.connectToService();
    }
    
    void createService(final AnalyticsClient client) {
        if (this.client != null) {
            return;
        }
        this.client = client;
        this.connectToService();
    }
    
    @Override
    public void dispatch() {
        switch (this.state) {
            default: {
                this.pendingDispatch = true;
            }
            case CONNECTED_SERVICE: {}
            case CONNECTED_LOCAL: {
                this.dispatchToStore();
            }
        }
    }
    
    @Override
    public void onConnected() {
        synchronized (this) {
            this.failedConnectTimer = this.cancelTimer(this.failedConnectTimer);
            this.connectTries = 0;
            Log.v("Connected to service");
            this.state = ConnectState.CONNECTED_SERVICE;
            if (this.pendingServiceDisconnect) {
                this.disconnectFromService();
                this.pendingServiceDisconnect = false;
            }
            else {
                this.sendQueue();
                this.disconnectCheckTimer = this.cancelTimer(this.disconnectCheckTimer);
                (this.disconnectCheckTimer = new Timer("disconnect check")).schedule(new DisconnectCheckTask(), this.idleTimeout);
            }
        }
    }
    
    @Override
    public void onConnectionFailed(final int n, final Intent intent) {
        synchronized (this) {
            this.state = ConnectState.PENDING_CONNECTION;
            if (this.connectTries < 2) {
                Log.w("Service unavailable (code=" + n + "), will retry.");
                this.fireReconnectAttempt();
            }
            else {
                Log.w("Service unavailable (code=" + n + "), using local store.");
                this.useStore();
            }
        }
    }
    
    @Override
    public void onDisconnected() {
        while (true) {
            Label_0065: {
                synchronized (this) {
                    if (this.state == ConnectState.PENDING_DISCONNECT) {
                        Log.v("Disconnected from service");
                        this.clearAllTimers();
                        this.state = ConnectState.DISCONNECTED;
                    }
                    else {
                        Log.v("Unexpected disconnect.");
                        this.state = ConnectState.PENDING_CONNECTION;
                        if (this.connectTries >= 2) {
                            break Label_0065;
                        }
                        this.fireReconnectAttempt();
                    }
                    return;
                }
            }
            this.useStore();
        }
    }
    
    @Override
    public void putHit(final Map<String, String> map, final long n, final String s, final List<Command> list) {
        Log.v("putHit called");
        this.queue.add(new HitParams(map, n, s, list));
        this.sendQueue();
    }
    
    void setClock(final Clock clock) {
        this.clock = clock;
    }
    
    @Override
    public void setForceLocalDispatch() {
        while (true) {
            Label_0088: {
                synchronized (this) {
                    if (!this.forceLocalDispatch) {
                        Log.v("setForceLocalDispatch called.");
                        this.forceLocalDispatch = true;
                        switch (this.state) {
                            case CONNECTED_SERVICE: {
                                this.disconnectFromService();
                            }
                            case CONNECTED_LOCAL:
                            case PENDING_CONNECTION:
                            case PENDING_DISCONNECT:
                            case DISCONNECTED: {
                                break;
                            }
                            case CONNECTING: {
                                break Label_0088;
                            }
                            default: {}
                        }
                    }
                    return;
                }
            }
            this.pendingServiceDisconnect = true;
        }
    }
    
    public void setIdleTimeout(final long idleTimeout) {
        this.idleTimeout = idleTimeout;
    }
    
    private enum ConnectState
    {
        BLOCKED, 
        CONNECTED_LOCAL, 
        CONNECTED_SERVICE, 
        CONNECTING, 
        DISCONNECTED, 
        PENDING_CONNECTION, 
        PENDING_DISCONNECT;
    }
    
    private class DisconnectCheckTask extends TimerTask
    {
        @Override
        public void run() {
            if (GAServiceProxy.this.state == ConnectState.CONNECTED_SERVICE && GAServiceProxy.this.queue.isEmpty() && GAServiceProxy.this.lastRequestTime + GAServiceProxy.this.idleTimeout < GAServiceProxy.this.clock.currentTimeMillis()) {
                Log.v("Disconnecting due to inactivity");
                GAServiceProxy.this.disconnectFromService();
                return;
            }
            GAServiceProxy.this.disconnectCheckTimer.schedule(new DisconnectCheckTask(), GAServiceProxy.this.idleTimeout);
        }
    }
    
    private class FailedConnectTask extends TimerTask
    {
        @Override
        public void run() {
            if (GAServiceProxy.this.state == ConnectState.CONNECTING) {
                GAServiceProxy.this.useStore();
            }
        }
    }
    
    private static class HitParams
    {
        private final List<Command> commands;
        private final long hitTimeInMilliseconds;
        private final String path;
        private final Map<String, String> wireFormatParams;
        
        public HitParams(final Map<String, String> wireFormatParams, final long hitTimeInMilliseconds, final String path, final List<Command> commands) {
            this.wireFormatParams = wireFormatParams;
            this.hitTimeInMilliseconds = hitTimeInMilliseconds;
            this.path = path;
            this.commands = commands;
        }
        
        public List<Command> getCommands() {
            return this.commands;
        }
        
        public long getHitTimeInMilliseconds() {
            return this.hitTimeInMilliseconds;
        }
        
        public String getPath() {
            return this.path;
        }
        
        public Map<String, String> getWireFormatParams() {
            return this.wireFormatParams;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("PATH: ");
            sb.append(this.path);
            if (this.wireFormatParams != null) {
                sb.append("  PARAMS: ");
                for (final Map.Entry<String, String> entry : this.wireFormatParams.entrySet()) {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append(",  ");
                }
            }
            return sb.toString();
        }
    }
    
    private class ReconnectTask extends TimerTask
    {
        @Override
        public void run() {
            GAServiceProxy.this.connectToService();
        }
    }
}
