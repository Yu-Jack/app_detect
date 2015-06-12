// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.util.Log;
import android.os.Parcelable;
import android.content.IntentFilter;
import android.os.Bundle;
import java.util.UUID;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;
import com.facebook.widget.FacebookDialog;
import android.support.v4.content.LocalBroadcastManager;
import android.app.Activity;

public class UiLifecycleHelper
{
    private static final String ACTIVITY_NULL_MESSAGE = "activity cannot be null";
    private static final String DIALOG_CALL_BUNDLE_SAVE_KEY = "com.facebook.UiLifecycleHelper.pendingFacebookDialogCallKey";
    private final Activity activity;
    private AppEventsLogger appEventsLogger;
    private final LocalBroadcastManager broadcastManager;
    private final Session.StatusCallback callback;
    private FacebookDialog.PendingCall pendingFacebookDialogCall;
    private final BroadcastReceiver receiver;
    
    public UiLifecycleHelper(final Activity activity, final Session.StatusCallback callback) {
        if (activity == null) {
            throw new IllegalArgumentException("activity cannot be null");
        }
        this.activity = activity;
        this.callback = callback;
        this.receiver = new ActiveSessionBroadcastReceiver((ActiveSessionBroadcastReceiver)null);
        this.broadcastManager = LocalBroadcastManager.getInstance((Context)activity);
        Settings.loadDefaultsFromMetadataIfNeeded((Context)activity);
    }
    
    private void cancelPendingAppCall(final FacebookDialog.Callback callback) {
        if (callback != null) {
            final Intent requestIntent = this.pendingFacebookDialogCall.getRequestIntent();
            final Intent intent = new Intent();
            intent.putExtra("com.facebook.platform.protocol.CALL_ID", requestIntent.getStringExtra("com.facebook.platform.protocol.CALL_ID"));
            intent.putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", requestIntent.getStringExtra("com.facebook.platform.protocol.PROTOCOL_ACTION"));
            intent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", requestIntent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0));
            intent.putExtra("com.facebook.platform.status.ERROR_TYPE", "UnknownError");
            FacebookDialog.handleActivityResult((Context)this.activity, this.pendingFacebookDialogCall, this.pendingFacebookDialogCall.getRequestCode(), intent, callback);
        }
        this.pendingFacebookDialogCall = null;
    }
    
    private boolean handleFacebookDialogActivityResult(final int n, final int n2, final Intent intent, final FacebookDialog.Callback callback) {
        if (this.pendingFacebookDialogCall == null || this.pendingFacebookDialogCall.getRequestCode() != n) {
            return false;
        }
        if (intent == null) {
            this.cancelPendingAppCall(callback);
            return true;
        }
        final String stringExtra = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        Object fromString = null;
        while (true) {
            if (stringExtra == null) {
                break Label_0059;
            }
            try {
                fromString = UUID.fromString(stringExtra);
                if (fromString != null && this.pendingFacebookDialogCall.getCallId().equals(fromString)) {
                    FacebookDialog.handleActivityResult((Context)this.activity, this.pendingFacebookDialogCall, n, intent, callback);
                }
                else {
                    this.cancelPendingAppCall(callback);
                }
                this.pendingFacebookDialogCall = null;
                return true;
            }
            catch (IllegalArgumentException ex) {
                fromString = null;
                continue;
            }
            break;
        }
    }
    
    public AppEventsLogger getAppEventsLogger() {
        final Session activeSession = Session.getActiveSession();
        if (activeSession == null) {
            return null;
        }
        if (this.appEventsLogger == null || !this.appEventsLogger.isValidForSession(activeSession)) {
            if (this.appEventsLogger != null) {
                AppEventsLogger.onContextStop();
            }
            this.appEventsLogger = AppEventsLogger.newLogger((Context)this.activity, activeSession);
        }
        return this.appEventsLogger;
    }
    
    public void onActivityResult(final int n, final int n2, final Intent intent) {
        this.onActivityResult(n, n2, intent, null);
    }
    
    public void onActivityResult(final int n, final int n2, final Intent intent, final FacebookDialog.Callback callback) {
        final Session activeSession = Session.getActiveSession();
        if (activeSession != null) {
            activeSession.onActivityResult(this.activity, n, n2, intent);
        }
        this.handleFacebookDialogActivityResult(n, n2, intent, callback);
    }
    
    public void onCreate(final Bundle bundle) {
        Session activeSession = Session.getActiveSession();
        if (activeSession == null) {
            if (bundle != null) {
                activeSession = Session.restoreSession((Context)this.activity, null, this.callback, bundle);
            }
            if (activeSession == null) {
                activeSession = new Session((Context)this.activity);
            }
            Session.setActiveSession(activeSession);
        }
        if (bundle != null) {
            this.pendingFacebookDialogCall = (FacebookDialog.PendingCall)bundle.getParcelable("com.facebook.UiLifecycleHelper.pendingFacebookDialogCallKey");
        }
    }
    
    public void onDestroy() {
    }
    
    public void onPause() {
        this.broadcastManager.unregisterReceiver(this.receiver);
        if (this.callback != null) {
            final Session activeSession = Session.getActiveSession();
            if (activeSession != null) {
                activeSession.removeCallback(this.callback);
            }
        }
    }
    
    public void onResume() {
        final Session activeSession = Session.getActiveSession();
        if (activeSession != null) {
            if (this.callback != null) {
                activeSession.addCallback(this.callback);
            }
            if (SessionState.CREATED_TOKEN_LOADED.equals(activeSession.getState())) {
                activeSession.openForRead(null);
            }
        }
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_SET");
        intentFilter.addAction("com.facebook.sdk.ACTIVE_SESSION_UNSET");
        this.broadcastManager.registerReceiver(this.receiver, intentFilter);
    }
    
    public void onSaveInstanceState(final Bundle bundle) {
        Session.saveSession(Session.getActiveSession(), bundle);
        bundle.putParcelable("com.facebook.UiLifecycleHelper.pendingFacebookDialogCallKey", (Parcelable)this.pendingFacebookDialogCall);
    }
    
    public void onStop() {
        AppEventsLogger.onContextStop();
    }
    
    public void trackPendingDialogCall(final FacebookDialog.PendingCall pendingFacebookDialogCall) {
        if (this.pendingFacebookDialogCall != null) {
            Log.i("Facebook", "Tracking new app call while one is still pending; canceling pending call.");
            this.cancelPendingAppCall(null);
        }
        this.pendingFacebookDialogCall = pendingFacebookDialogCall;
    }
    
    private class ActiveSessionBroadcastReceiver extends BroadcastReceiver
    {
        public void onReceive(final Context context, final Intent intent) {
            if ("com.facebook.sdk.ACTIVE_SESSION_SET".equals(intent.getAction())) {
                final Session activeSession = Session.getActiveSession();
                if (activeSession != null && UiLifecycleHelper.this.callback != null) {
                    activeSession.addCallback(UiLifecycleHelper.this.callback);
                }
            }
            else if ("com.facebook.sdk.ACTIVE_SESSION_UNSET".equals(intent.getAction())) {
                final Session activeSession2 = Session.getActiveSession();
                if (activeSession2 != null && UiLifecycleHelper.this.callback != null) {
                    activeSession2.removeCallback(UiLifecycleHelper.this.callback);
                }
            }
        }
    }
}
