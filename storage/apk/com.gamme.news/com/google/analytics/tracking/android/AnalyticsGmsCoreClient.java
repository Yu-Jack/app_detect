// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import android.os.IBinder;
import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;
import android.content.ComponentName;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.analytics.internal.IAnalyticsService;
import android.content.Context;
import android.content.ServiceConnection;

class AnalyticsGmsCoreClient implements AnalyticsClient
{
    private static final int BIND_ADJUST_WITH_ACTIVITY = 128;
    public static final int BIND_FAILED = 1;
    public static final String KEY_APP_PACKAGE_NAME = "app_package_name";
    public static final int REMOTE_EXECUTION_FAILED = 2;
    static final String SERVICE_ACTION = "com.google.android.gms.analytics.service.START";
    private static final String SERVICE_DESCRIPTOR = "com.google.android.gms.analytics.internal.IAnalyticsService";
    private ServiceConnection mConnection;
    private Context mContext;
    private OnConnectedListener mOnConnectedListener;
    private OnConnectionFailedListener mOnConnectionFailedListener;
    private IAnalyticsService mService;
    
    public AnalyticsGmsCoreClient(final Context mContext, final OnConnectedListener mOnConnectedListener, final OnConnectionFailedListener mOnConnectionFailedListener) {
        this.mContext = mContext;
        if (mOnConnectedListener == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.mOnConnectedListener = mOnConnectedListener;
        if (mOnConnectionFailedListener == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.mOnConnectionFailedListener = mOnConnectionFailedListener;
    }
    
    private IAnalyticsService getService() {
        this.checkConnected();
        return this.mService;
    }
    
    private void onConnectionSuccess() {
        this.mOnConnectedListener.onConnected();
    }
    
    private void onServiceBound() {
        this.onConnectionSuccess();
    }
    
    protected void checkConnected() {
        if (!this.isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }
    
    @Override
    public void clearHits() {
        try {
            this.getService().clearHits();
        }
        catch (RemoteException obj) {
            Log.e("clear hits failed: " + obj);
        }
    }
    
    @Override
    public void connect() {
        final Intent obj = new Intent("com.google.android.gms.analytics.service.START");
        obj.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        obj.putExtra("app_package_name", this.mContext.getPackageName());
        if (this.mConnection != null) {
            Log.e("Calling connect() while still connected, missing disconnect().");
        }
        else {
            this.mConnection = (ServiceConnection)new AnalyticsServiceConnection();
            final boolean bindService = this.mContext.bindService(obj, this.mConnection, 129);
            Log.v("connect: bindService returned " + bindService + " for " + obj);
            if (!bindService) {
                this.mConnection = null;
                this.mOnConnectionFailedListener.onConnectionFailed(1, null);
            }
        }
    }
    
    @Override
    public void disconnect() {
        this.mService = null;
        if (this.mConnection == null) {
            return;
        }
        while (true) {
            try {
                this.mContext.unbindService(this.mConnection);
                this.mConnection = null;
                this.mOnConnectedListener.onDisconnected();
            }
            catch (IllegalArgumentException ex) {
                continue;
            }
            catch (IllegalStateException ex2) {
                continue;
            }
            break;
        }
    }
    
    public boolean isConnected() {
        return this.mService != null;
    }
    
    @Override
    public void sendHit(final Map<String, String> map, final long n, final String s, final List<Command> list) {
        try {
            this.getService().sendHit(map, n, s, list);
        }
        catch (RemoteException obj) {
            Log.e("sendHit failed: " + obj);
        }
    }
    
    final class AnalyticsServiceConnection implements ServiceConnection
    {
        public void onServiceConnected(final ComponentName componentName, final IBinder obj) {
            Log.v("service connected, binder: " + obj);
            try {
                if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(obj.getInterfaceDescriptor())) {
                    Log.v("bound to service");
                    AnalyticsGmsCoreClient.this.mService = IAnalyticsService.Stub.asInterface(obj);
                    AnalyticsGmsCoreClient.this.onServiceBound();
                    return;
                }
            }
            catch (RemoteException ex) {}
            AnalyticsGmsCoreClient.this.mContext.unbindService((ServiceConnection)this);
            AnalyticsGmsCoreClient.this.mConnection = null;
            AnalyticsGmsCoreClient.this.mOnConnectionFailedListener.onConnectionFailed(2, null);
        }
        
        public void onServiceDisconnected(final ComponentName obj) {
            Log.v("service disconnected: " + obj);
            AnalyticsGmsCoreClient.this.mConnection = null;
            AnalyticsGmsCoreClient.this.mOnConnectedListener.onDisconnected();
        }
    }
    
    public interface OnConnectedListener
    {
        void onConnected();
        
        void onDisconnected();
    }
    
    public interface OnConnectionFailedListener
    {
        void onConnectionFailed(int p0, Intent p1);
    }
}
