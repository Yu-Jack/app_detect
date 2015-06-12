// 
// Decompiled by Procyon v0.5.29
// 

package com.plugins.shortcut;

import org.json.JSONException;
import android.content.pm.PackageManager;
import android.content.Context;
import org.json.JSONObject;
import android.os.Parcelable;
import android.content.Intent$ShortcutIconResource;
import android.content.Intent;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.apache.cordova.CordovaPlugin;

public class ShortcutPlugin extends CordovaPlugin
{
    public static final String ACTION_ADD_SHORTCUT = "addShortcut";
    public static final String ACTION_DEL_SHORTCUT = "delShortcut";
    
    @Override
    public boolean execute(final String s, final JSONArray jsonArray, final CallbackContext callbackContext) throws JSONException {
        try {
            if ("addShortcut".equals(s)) {
                final JSONObject jsonObject = jsonArray.getJSONObject(0);
                final Context applicationContext = this.cordova.getActivity().getApplicationContext();
                final PackageManager packageManager = applicationContext.getPackageManager();
                final Intent intent = new Intent();
                intent.setClassName(this.cordova.getActivity().getPackageName(), this.cordova.getActivity().getClass().getName());
                intent.setFlags(268435456);
                intent.addFlags(67108864);
                final Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
                intent2.putExtra("duplicate", false);
                intent2.putExtra("android.intent.extra.shortcut.NAME", jsonObject.getString("shortcuttext"));
                intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", (Parcelable)Intent$ShortcutIconResource.fromContext(applicationContext, packageManager.resolveActivity(intent, 0).activityInfo.applicationInfo.icon));
                intent2.putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)intent);
                applicationContext.sendBroadcast(intent2);
                callbackContext.success();
                return true;
            }
            if ("delShortcut".equals(s)) {
                final JSONObject jsonObject2 = jsonArray.getJSONObject(0);
                final Context applicationContext2 = this.cordova.getActivity().getApplicationContext();
                final Intent intent3 = new Intent();
                intent3.setClassName(this.cordova.getActivity().getPackageName(), this.cordova.getActivity().getClass().getName());
                intent3.setFlags(268435456);
                intent3.addFlags(67108864);
                final Intent intent4 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
                intent4.putExtra("android.intent.extra.shortcut.NAME", jsonObject2.getString("shortcuttext"));
                intent4.putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)intent3);
                applicationContext2.sendBroadcast(intent4);
                callbackContext.success();
            }
            callbackContext.error("Invalid action");
            return false;
        }
        catch (Exception ex) {
            System.err.println("Exception: " + ex.getMessage());
            callbackContext.error(ex.getMessage());
            return false;
        }
    }
}
