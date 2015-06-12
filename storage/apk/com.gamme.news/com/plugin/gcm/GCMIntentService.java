// 
// Decompiled by Procyon v0.5.29
// 

package com.plugin.gcm;

import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;
import android.support.v4.app.NotificationCompat;
import android.app.PendingIntent;
import android.content.Intent;
import android.app.NotificationManager;
import android.os.Bundle;
import android.content.Context;
import android.annotation.SuppressLint;
import com.google.android.gcm.GCMBaseIntentService;

@SuppressLint({ "NewApi" })
public class GCMIntentService extends GCMBaseIntentService
{
    private static final String TAG = "GCMIntentService";
    
    public GCMIntentService() {
        super(new String[] { "GCMIntentService" });
    }
    
    private static String getAppName(final Context context) {
        return (String)context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
    }
    
    public void createNotification(final Context context, final Bundle bundle) {
        final NotificationManager notificationManager = (NotificationManager)this.getSystemService("notification");
        final String appName = getAppName((Context)this);
        final Intent intent = new Intent((Context)this, (Class)PushHandlerActivity.class);
        intent.addFlags(603979776);
        intent.putExtra("pushBundle", bundle);
        final PendingIntent activity = PendingIntent.getActivity((Context)this, 0, intent, 134217728);
        int int1 = -1;
        while (true) {
            if (bundle.getString("defaults") == null) {
                break Label_0083;
            }
            try {
                int1 = Integer.parseInt(bundle.getString("defaults"));
                final NotificationCompat.Builder setAutoCancel = new NotificationCompat.Builder(context).setDefaults(int1).setSmallIcon(context.getApplicationInfo().icon).setWhen(System.currentTimeMillis()).setContentTitle(bundle.getString("title")).setTicker(bundle.getString("title")).setContentIntent(activity).setAutoCancel(true);
                final String string = bundle.getString("message");
                Label_0215: {
                    if (string == null) {
                        break Label_0215;
                    }
                    setAutoCancel.setContentText(string);
                    final String string2 = bundle.getString("msgcnt");
                    if (string2 != null) {
                        setAutoCancel.setNumber(Integer.parseInt(string2));
                    }
                    try {
                        final int int2 = Integer.parseInt(bundle.getString("notId"));
                        notificationManager.notify(appName, int2, setAutoCancel.build());
                        return;
                        setAutoCancel.setContentText("<missing message content>");
                    }
                    catch (NumberFormatException ex) {
                        Log.e("GCMIntentService", "Number format exception - Error parsing Notification ID: " + ex.getMessage());
                        final int int2 = 0;
                    }
                    catch (Exception ex2) {
                        Log.e("GCMIntentService", "Number format exception - Error parsing Notification ID" + ex2.getMessage());
                        final int int2 = 0;
                    }
                }
            }
            catch (NumberFormatException ex3) {
                continue;
            }
            break;
        }
    }
    
    public void onError(final Context context, final String str) {
        Log.e("GCMIntentService", "onError - errorId: " + str);
    }
    
    @Override
    protected void onMessage(final Context obj, final Intent intent) {
        Log.d("GCMIntentService", "onMessage - context: " + obj);
        final Bundle extras = intent.getExtras();
        if (extras != null) {
            if (PushPlugin.isInForeground()) {
                extras.putBoolean("foreground", true);
                PushPlugin.sendExtras(extras);
            }
            else {
                extras.putBoolean("foreground", false);
                if (extras.getString("message") != null && extras.getString("message").length() != 0) {
                    this.createNotification(obj, extras);
                }
            }
        }
    }
    
    public void onRegistered(final Context context, final String str) {
        Log.v("GCMIntentService", "onRegistered: " + str);
        try {
            final JSONObject put = new JSONObject().put("event", (Object)"registered");
            put.put("regid", (Object)str);
            Log.v("GCMIntentService", "onRegistered: " + put.toString());
            PushPlugin.sendJavascript(put);
        }
        catch (JSONException ex) {
            Log.e("GCMIntentService", "onRegistered: JSON exception");
        }
    }
    
    public void onUnregistered(final Context context, final String str) {
        Log.d("GCMIntentService", "onUnregistered - regId: " + str);
    }
}
