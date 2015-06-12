// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.Arrays;
import android.webkit.WebView;
import java.net.HttpURLConnection;
import java.util.List;
import android.webkit.WebSettings;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.Bundle;
import org.json.JSONArray;
import java.util.Collection;
import java.util.Iterator;
import android.net.UrlQuerySanitizer$ParameterValuePair;
import android.net.UrlQuerySanitizer;
import java.util.HashMap;
import java.util.Map;
import android.net.Uri;
import java.nio.CharBuffer;
import android.os.Build$VERSION;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

final class eh extends BroadcastReceiver
{
    public void onReceive(final Context context, final Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            eg.b = true;
        }
        else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            eg.b = false;
        }
    }
}
