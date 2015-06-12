// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a.a;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import android.util.Log;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.ComponentName;
import com.facebook.ads.a.i;
import com.facebook.ads.a.ab;
import android.content.Intent;
import com.facebook.ads.a.w;
import android.net.Uri;
import android.content.Context;

public class c extends a
{
    private static final String a;
    private final Context b;
    private final Uri c;
    
    static {
        a = c.class.getSimpleName();
    }
    
    public c(final Context b, final Uri c) {
        this.b = b;
        this.c = c;
    }
    
    private Intent a(final w w) {
        if (ab.a(w.a())) {
            return null;
        }
        if (!i.a(this.b, w.a())) {
            return null;
        }
        final String c = w.c();
        if (!ab.a(c) && (c.startsWith("tel:") || c.startsWith("telprompt:"))) {
            return new Intent("android.intent.action.CALL", Uri.parse(c));
        }
        final PackageManager packageManager = this.b.getPackageManager();
        if (ab.a(w.b()) && ab.a(c)) {
            return packageManager.getLaunchIntentForPackage(w.a());
        }
        final Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        if (!ab.a(w.a()) && !ab.a(w.b())) {
            intent.setComponent(new ComponentName(w.a(), w.b()));
        }
        if (!ab.a(w.c())) {
            intent.setData(Uri.parse(w.c()));
        }
        final List queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (intent.getComponent() == null) {
            for (final ResolveInfo resolveInfo : queryIntentActivities) {
                if (resolveInfo.activityInfo.packageName.equals(w.a())) {
                    intent.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
                    break;
                }
            }
        }
        if (queryIntentActivities.isEmpty() || intent.getComponent() == null) {
            return null;
        }
        return intent;
    }
    
    private List c() {
        final String queryParameter = this.c.getQueryParameter("appsite_data");
        List<w> list;
        if (ab.a(queryParameter) || "[]".equals(queryParameter)) {
            list = null;
        }
        else {
            list = new ArrayList<w>();
            try {
                final JSONArray optJSONArray = new JSONObject(queryParameter).optJSONArray("android");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); ++i) {
                        final w a = w.a(optJSONArray.optJSONObject(i));
                        if (a != null) {
                            list.add(a);
                        }
                    }
                }
            }
            catch (JSONException ex) {
                Log.w(com.facebook.ads.a.a.c.a, "Error parsing appsite_data", (Throwable)ex);
                return list;
            }
        }
        return list;
    }
    
    protected final Uri a() {
        return Uri.parse(String.format("market://details?id=%s", this.c.getQueryParameter("store_id")));
    }
    
    @Override
    public void a(final Map map) {
        com.facebook.ads.a.a.a.a(this.b, this.c);
        final List c = this.c();
        final ArrayList<Intent> list = new ArrayList<Intent>();
        if (c != null) {
            final Iterator<w> iterator = c.iterator();
            while (iterator.hasNext()) {
                final Intent a = this.a(iterator.next());
                if (a != null) {
                    list.add(a);
                }
            }
        }
        for (final Intent intent : list) {
            try {
                this.b.startActivity(intent);
                return;
            }
            catch (Exception ex) {
                Log.d(com.facebook.ads.a.a.c.a, "Failed to open app intent, falling back", (Throwable)ex);
                continue;
            }
            break;
        }
        this.b();
    }
    
    public final void b() {
        final Intent intent = new Intent("android.intent.action.VIEW", this.a());
        try {
            this.b.startActivity(intent);
        }
        catch (Exception ex) {
            Log.d(com.facebook.ads.a.a.c.a, "Failed to open market url: " + this.c.toString(), (Throwable)ex);
            final String queryParameter = this.c.getQueryParameter("store_url_web_fallback");
            if (queryParameter == null || queryParameter.length() <= 0) {
                return;
            }
            final Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(queryParameter));
            try {
                this.b.startActivity(intent2);
            }
            catch (Exception ex2) {
                Log.d(com.facebook.ads.a.a.c.a, "Failed to open fallback url: " + queryParameter, (Throwable)ex2);
            }
        }
    }
}
