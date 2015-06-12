// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.view.Window;
import android.graphics.Rect;
import android.app.Activity;
import org.json.JSONException;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.content.Intent;
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
import android.content.Context;
import java.util.Iterator;
import org.json.JSONArray;
import java.util.Collection;
import java.nio.CharBuffer;

public final class eo
{
    private static final Object qp;
    private static boolean sl;
    private static String sm;
    private static boolean sn;
    
    static {
        qp = new Object();
        eo.sl = true;
        eo.sn = false;
    }
    
    public static String a(final Readable readable) {
        final StringBuilder sb = new StringBuilder();
        final CharBuffer allocate = CharBuffer.allocate(2048);
        while (true) {
            final int read = readable.read(allocate);
            if (read == -1) {
                break;
            }
            allocate.flip();
            sb.append(allocate, 0, read);
        }
        return sb.toString();
    }
    
    private static JSONArray a(final Collection collection) {
        final JSONArray jsonArray = new JSONArray();
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            a(jsonArray, iterator.next());
        }
        return jsonArray;
    }
    
    static JSONArray a(final Object[] array) {
        final JSONArray jsonArray = new JSONArray();
        for (int length = array.length, i = 0; i < length; ++i) {
            a(jsonArray, array[i]);
        }
        return jsonArray;
    }
    
    public static void a(final Context context, final String s, final WebSettings webSettings) {
        webSettings.setUserAgentString(c(context, s));
    }
    
    public static void a(final Context context, final String s, final List list) {
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            new es(context, s, iterator.next()).start();
        }
    }
    
    public static void a(final Context context, final String s, final boolean instanceFollowRedirects, final HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(instanceFollowRedirects);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", c(context, s));
        httpURLConnection.setUseCaches(false);
    }
    
    public static void a(final WebView webView) {
        if (Build$VERSION.SDK_INT >= 11) {
            eq.a(webView);
        }
    }
    
    private static void a(final JSONArray jsonArray, final Object o) {
        if (o instanceof Bundle) {
            jsonArray.put((Object)b((Bundle)o));
            return;
        }
        if (o instanceof Map) {
            jsonArray.put((Object)o((Map)o));
            return;
        }
        if (o instanceof Collection) {
            jsonArray.put((Object)a((Collection)o));
            return;
        }
        if (o instanceof Object[]) {
            jsonArray.put((Object)a((Object[])o));
            return;
        }
        jsonArray.put(o);
    }
    
    private static void a(final JSONObject jsonObject, String s, final Object o) {
        if (o instanceof Bundle) {
            jsonObject.put(s, (Object)b((Bundle)o));
            return;
        }
        if (o instanceof Map) {
            jsonObject.put(s, (Object)o((Map)o));
            return;
        }
        if (o instanceof Collection) {
            if (s == null) {
                s = "null";
            }
            jsonObject.put(s, (Object)a((Collection)o));
            return;
        }
        if (o instanceof Object[]) {
            jsonObject.put(s, (Object)a(Arrays.asList((Object[])o)));
            return;
        }
        jsonObject.put(s, o);
    }
    
    public static boolean a(final PackageManager packageManager, final String s, final String s2) {
        return packageManager.checkPermission(s2, s) == 0;
    }
    
    public static boolean a(final ClassLoader loader, final Class clazz, final String name) {
        try {
            return clazz.isAssignableFrom(Class.forName(name, false, loader));
        }
        catch (Throwable t) {
            return false;
        }
    }
    
    private static JSONObject b(final Bundle bundle) {
        final JSONObject jsonObject = new JSONObject();
        for (final String s : bundle.keySet()) {
            a(jsonObject, s, bundle.get(s));
        }
        return jsonObject;
    }
    
    public static void b(final WebView webView) {
        if (Build$VERSION.SDK_INT >= 11) {
            eq.b(webView);
        }
    }
    
    public static boolean bQ() {
        return eo.sl;
    }
    
    public static int bR() {
        if (Build$VERSION.SDK_INT >= 9) {
            return 6;
        }
        return 0;
    }
    
    public static int bS() {
        if (Build$VERSION.SDK_INT >= 9) {
            return 7;
        }
        return 1;
    }
    
    public static String bT() {
        final UUID randomUUID = UUID.randomUUID();
        final byte[] byteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        final byte[] byteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String s = new BigInteger(1, byteArray).toString();
        int n = 0;
    Label_0105_Outer:
        while (true) {
            if (n >= 2) {
                return s;
            }
            while (true) {
                try {
                    final MessageDigest instance = MessageDigest.getInstance("MD5");
                    instance.update(byteArray);
                    instance.update(byteArray2);
                    final byte[] magnitude = new byte[8];
                    System.arraycopy(instance.digest(), 0, magnitude, 0, 8);
                    s = new BigInteger(1, magnitude).toString();
                    ++n;
                    continue Label_0105_Outer;
                }
                catch (NoSuchAlgorithmException ex) {
                    continue;
                }
                break;
            }
        }
    }
    
    private static String c(final Context context, final String str) {
    Label_0037_Outer:
        while (true) {
            while (true) {
                synchronized (eo.qp) {
                    if (eo.sm != null) {
                        return eo.sm;
                    }
                    if (Build$VERSION.SDK_INT >= 17) {
                        eo.sm = er.getDefaultUserAgent(context);
                        return eo.sm = eo.sm + " (Mobile; " + str + ")";
                    }
                }
                Label_0139: {
                    if (!et.bW()) {
                        et.sv.post((Runnable)new eo$1(context));
                        while (eo.sm == null) {
                            try {
                                eo.qp.wait();
                                continue Label_0037_Outer;
                            }
                            catch (InterruptedException ex) {
                                // monitorexit(o)
                                return eo.sm;
                            }
                            break Label_0139;
                        }
                        continue;
                    }
                }
                eo.sm = o(context);
                continue;
            }
        }
    }
    
    public static Map c(final Uri uri) {
        if (uri == null) {
            return null;
        }
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        final UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
        urlQuerySanitizer.setAllowUnregisteredParamaters(true);
        urlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
        urlQuerySanitizer.parseUrl(uri.toString());
        for (final UrlQuerySanitizer$ParameterValuePair urlQuerySanitizer$ParameterValuePair : urlQuerySanitizer.getParameterList()) {
            hashMap.put(urlQuerySanitizer$ParameterValuePair.mParameter, urlQuerySanitizer$ParameterValuePair.mValue);
        }
        return hashMap;
    }
    
    public static boolean m(final Context context) {
        final Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        final ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            eu.D("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        boolean b;
        if ((0x10 & resolveActivity.activityInfo.configChanges) == 0x0) {
            eu.D(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "keyboard"));
            b = false;
        }
        else {
            b = true;
        }
        if ((0x20 & resolveActivity.activityInfo.configChanges) == 0x0) {
            eu.D(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "keyboardHidden"));
            b = false;
        }
        if ((0x80 & resolveActivity.activityInfo.configChanges) == 0x0) {
            eu.D(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "orientation"));
            b = false;
        }
        if ((0x100 & resolveActivity.activityInfo.configChanges) == 0x0) {
            eu.D(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "screenLayout"));
            b = false;
        }
        if ((0x200 & resolveActivity.activityInfo.configChanges) == 0x0) {
            eu.D(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "uiMode"));
            b = false;
        }
        if ((0x400 & resolveActivity.activityInfo.configChanges) == 0x0) {
            eu.D(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "screenSize"));
            b = false;
        }
        if ((0x800 & resolveActivity.activityInfo.configChanges) == 0x0) {
            eu.D(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "smallestScreenSize"));
            return false;
        }
        return b;
    }
    
    public static void n(final Context context) {
        if (eo.sn) {
            return;
        }
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver((BroadcastReceiver)new eo$a(null), intentFilter);
        eo.sn = true;
    }
    
    private static String o(final Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }
    
    public static JSONObject o(final Map map) {
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject();
            for (final String s : map.keySet()) {
                a(jsonObject, s, map.get(s));
            }
        }
        catch (ClassCastException ex) {
            throw new JSONException("Could not convert map to JSON: " + ex.getMessage());
        }
        return jsonObject;
    }
    
    public static int p(final Context context) {
        int top;
        int n;
        if (context instanceof Activity) {
            final Window window = ((Activity)context).getWindow();
            final Rect rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            top = rect.top;
            n = window.findViewById(16908290).getTop() - top;
        }
        else {
            n = 0;
            top = 0;
        }
        return n + top;
    }
    
    public static String v(final String s) {
        return Uri.parse(s).buildUpon().query((String)null).build().toString();
    }
}
