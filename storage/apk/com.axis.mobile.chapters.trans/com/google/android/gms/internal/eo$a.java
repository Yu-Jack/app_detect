// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.view.Window;
import android.graphics.Rect;
import android.app.Activity;
import org.json.JSONException;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.net.UrlQuerySanitizer$ParameterValuePair;
import android.net.UrlQuerySanitizer;
import java.util.HashMap;
import android.net.Uri;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.math.BigInteger;
import java.util.UUID;
import android.content.pm.PackageManager;
import java.util.Arrays;
import org.json.JSONObject;
import java.util.Map;
import android.os.Bundle;
import android.os.Build$VERSION;
import android.webkit.WebView;
import java.net.HttpURLConnection;
import java.util.List;
import android.webkit.WebSettings;
import java.util.Iterator;
import org.json.JSONArray;
import java.util.Collection;
import java.nio.CharBuffer;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

final class eo$a extends BroadcastReceiver
{
    public void onReceive(final Context context, final Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            eo.sl = true;
        }
        else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            eo.sl = false;
        }
    }
}
