// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.Intent;
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
import android.content.Context;

public final class eg
{
    private static final Object a;
    private static boolean b;
    private static String c;
    private static boolean d;
    
    static {
        a = new Object();
        eg.b = true;
        eg.d = false;
    }
    
    private static String a(final Context context, final String str) {
    Label_0037_Outer:
        while (true) {
            while (true) {
                synchronized (eg.a) {
                    if (eg.c != null) {
                        return eg.c;
                    }
                    if (Build$VERSION.SDK_INT >= 17) {
                        eg.c = ek.a(context);
                        return eg.c = eg.c + " (Mobile; " + str + ")";
                    }
                }
                Label_0137: {
                    if (!em.b()) {
                        em.a.post((Runnable)new Runnable() {
                            @Override
                            public void run() {
                                synchronized (eg.a) {
                                    eg.c = d(context);
                                    eg.a.notifyAll();
                                }
                            }
                        });
                        while (eg.c == null) {
                            try {
                                eg.a.wait();
                                continue Label_0037_Outer;
                            }
                            catch (InterruptedException ex) {
                                // monitorexit(o)
                                return eg.c;
                            }
                            break Label_0137;
                        }
                        continue;
                    }
                }
                eg.c = d(context);
                continue;
            }
        }
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
    
    public static String a(final String s) {
        return Uri.parse(s).buildUpon().query((String)null).build().toString();
    }
    
    public static Map<String, String> a(final Uri uri) {
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
    
    private static JSONArray a(final Collection<?> collection) {
        final JSONArray jsonArray = new JSONArray();
        final Iterator<?> iterator = collection.iterator();
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
    
    private static JSONObject a(final Bundle bundle) {
        final JSONObject jsonObject = new JSONObject();
        for (final String s : bundle.keySet()) {
            a(jsonObject, s, bundle.get(s));
        }
        return jsonObject;
    }
    
    public static JSONObject a(final Map<String, ?> map) {
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
    
    public static void a(final Context context, final String s, final WebSettings webSettings) {
        webSettings.setUserAgentString(a(context, s));
    }
    
    public static void a(final Context context, final String s, final List<String> list) {
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            new el(context, s, iterator.next()).e();
        }
    }
    
    public static void a(final Context context, final String s, final boolean instanceFollowRedirects, final HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(instanceFollowRedirects);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", a(context, s));
        httpURLConnection.setUseCaches(false);
    }
    
    public static void a(final WebView webView) {
        if (Build$VERSION.SDK_INT >= 11) {
            ej.a(webView);
        }
    }
    
    private static void a(final JSONArray jsonArray, final Object o) {
        if (o instanceof Bundle) {
            jsonArray.put((Object)a((Bundle)o));
            return;
        }
        if (o instanceof Map) {
            jsonArray.put((Object)a((Map<String, ?>)o));
            return;
        }
        if (o instanceof Collection) {
            jsonArray.put((Object)a((Collection<?>)o));
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
            jsonObject.put(s, (Object)a((Bundle)o));
            return;
        }
        if (o instanceof Map) {
            jsonObject.put(s, (Object)a((Map<String, ?>)o));
            return;
        }
        if (o instanceof Collection) {
            if (s == null) {
                s = "null";
            }
            jsonObject.put(s, (Object)a((Collection<?>)o));
            return;
        }
        if (o instanceof Object[]) {
            jsonObject.put(s, (Object)a(Arrays.asList((Object[])o)));
            return;
        }
        jsonObject.put(s, o);
    }
    
    public static boolean a() {
        return eg.b;
    }
    
    public static boolean a(final Context context) {
        final Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        final ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            en.e("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        boolean b;
        if ((0x10 & resolveActivity.activityInfo.configChanges) == 0x0) {
            en.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "keyboard"));
            b = false;
        }
        else {
            b = true;
        }
        if ((0x20 & resolveActivity.activityInfo.configChanges) == 0x0) {
            en.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "keyboardHidden"));
            b = false;
        }
        if ((0x80 & resolveActivity.activityInfo.configChanges) == 0x0) {
            en.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "orientation"));
            b = false;
        }
        if ((0x100 & resolveActivity.activityInfo.configChanges) == 0x0) {
            en.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "screenLayout"));
            b = false;
        }
        if ((0x200 & resolveActivity.activityInfo.configChanges) == 0x0) {
            en.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "uiMode"));
            b = false;
        }
        if ((0x400 & resolveActivity.activityInfo.configChanges) == 0x0) {
            en.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "screenSize"));
            b = false;
        }
        if ((0x800 & resolveActivity.activityInfo.configChanges) == 0x0) {
            en.e(String.format("com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".", "smallestScreenSize"));
            return false;
        }
        return b;
    }
    
    public static boolean a(final PackageManager packageManager, final String s, final String s2) {
        return packageManager.checkPermission(s2, s) == 0;
    }
    
    public static boolean a(final ClassLoader loader, final Class<?> clazz, final String name) {
        try {
            return clazz.isAssignableFrom(Class.forName(name, false, loader));
        }
        catch (Throwable t) {
            return false;
        }
    }
    
    public static int b() {
        if (Build$VERSION.SDK_INT >= 9) {
            return 6;
        }
        return 0;
    }
    
    public static void b(final Context context) {
        if (eg.d) {
            return;
        }
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.getApplicationContext().registerReceiver((BroadcastReceiver)new eh(null), intentFilter);
        eg.d = true;
    }
    
    public static void b(final WebView webView) {
        if (Build$VERSION.SDK_INT >= 11) {
            ej.b(webView);
        }
    }
    
    public static int c() {
        if (Build$VERSION.SDK_INT >= 9) {
            return 7;
        }
        return 1;
    }
    
    private static String d(final Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }
}
