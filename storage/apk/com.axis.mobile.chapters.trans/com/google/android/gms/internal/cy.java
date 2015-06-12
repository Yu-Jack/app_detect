// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;
import android.content.Intent;
import android.os.Bundle;

public final class cy
{
    public static int a(final Bundle bundle) {
        final Object value = bundle.get("RESPONSE_CODE");
        if (value == null) {
            eu.D("Bundle with null response code, assuming OK (known issue)");
            return 0;
        }
        if (value instanceof Integer) {
            return (int)value;
        }
        if (value instanceof Long) {
            return (int)(long)value;
        }
        eu.D("Unexpected type for intent response code. " + ((Long)value).getClass().getName());
        return 5;
    }
    
    public static int c(final Intent intent) {
        final Object value = intent.getExtras().get("RESPONSE_CODE");
        if (value == null) {
            eu.D("Intent with no response code, assuming OK (known issue)");
            return 0;
        }
        if (value instanceof Integer) {
            return (int)value;
        }
        if (value instanceof Long) {
            return (int)(long)value;
        }
        eu.D("Unexpected type for intent response code. " + ((Long)value).getClass().getName());
        return 5;
    }
    
    public static String d(final Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra("INAPP_PURCHASE_DATA");
    }
    
    public static String e(final Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra("INAPP_DATA_SIGNATURE");
    }
    
    public static String p(final String s) {
        if (s == null) {
            return null;
        }
        try {
            return new JSONObject(s).getString("developerPayload");
        }
        catch (JSONException ex) {
            eu.D("Fail to parse purchase data");
            return null;
        }
    }
    
    public static String q(final String s) {
        if (s == null) {
            return null;
        }
        try {
            return new JSONObject(s).getString("purchaseToken");
        }
        catch (JSONException ex) {
            eu.D("Fail to parse purchase data");
            return null;
        }
    }
}
