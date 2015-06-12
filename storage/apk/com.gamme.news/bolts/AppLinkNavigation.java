// 
// Decompiled by Procyon v0.5.29
// 

package bolts;

import android.content.pm.PackageManager;
import android.content.Intent;
import java.net.URL;
import android.net.Uri;
import android.content.Context;
import android.util.SparseArray;
import org.json.JSONArray;
import java.util.List;
import org.json.JSONException;
import java.util.Iterator;
import org.json.JSONObject;
import android.os.Bundle;

public class AppLinkNavigation
{
    private static final String KEY_NAME_USER_AGENT = "user_agent";
    private static final String KEY_NAME_VERSION = "version";
    private static final String VERSION = "1.0";
    private static AppLinkResolver defaultResolver;
    private final AppLink appLink;
    private final Bundle appLinkData;
    private final Bundle extras;
    
    public AppLinkNavigation(final AppLink appLink, Bundle extras, Bundle appLinkData) {
        if (appLink == null) {
            throw new IllegalArgumentException("appLink must not be null.");
        }
        if (extras == null) {
            extras = new Bundle();
        }
        if (appLinkData == null) {
            appLinkData = new Bundle();
        }
        this.appLink = appLink;
        this.extras = extras;
        this.appLinkData = appLinkData;
    }
    
    private Bundle buildAppLinkDataForNavigation() {
        final Bundle bundle = new Bundle();
        bundle.putAll(this.getAppLinkData());
        bundle.putString("target_url", this.getAppLink().getSourceUrl().toString());
        bundle.putString("version", "1.0");
        bundle.putString("user_agent", "Bolts Android 1.1.0");
        bundle.putBundle("extras", this.getExtras());
        return bundle;
    }
    
    public static AppLinkResolver getDefaultResolver() {
        return AppLinkNavigation.defaultResolver;
    }
    
    private JSONObject getJSONForBundle(final Bundle bundle) throws JSONException {
        final JSONObject jsonObject = new JSONObject();
        for (final String s : bundle.keySet()) {
            jsonObject.put(s, this.getJSONValue(bundle.get(s)));
        }
        return jsonObject;
    }
    
    private Object getJSONValue(final Object o) throws JSONException {
        Object jsonForBundle;
        if (o instanceof Bundle) {
            jsonForBundle = this.getJSONForBundle((Bundle)o);
        }
        else {
            if (o instanceof CharSequence) {
                return o.toString();
            }
            if (o instanceof List) {
                jsonForBundle = new JSONArray();
                final Iterator<Object> iterator = (Iterator<Object>)((List)o).iterator();
                while (iterator.hasNext()) {
                    ((JSONArray)jsonForBundle).put(this.getJSONValue(iterator.next()));
                }
            }
            else if (o instanceof SparseArray) {
                jsonForBundle = new JSONArray();
                final SparseArray sparseArray = (SparseArray)o;
                for (int i = 0; i < sparseArray.size(); ++i) {
                    ((JSONArray)jsonForBundle).put(sparseArray.keyAt(i), this.getJSONValue(sparseArray.valueAt(i)));
                }
            }
            else {
                if (o instanceof Character) {
                    return o.toString();
                }
                if (o instanceof Boolean) {
                    return o;
                }
                if (o instanceof Number) {
                    if (o instanceof Double || o instanceof Float) {
                        return ((Number)o).doubleValue();
                    }
                    return ((Number)o).longValue();
                }
                else if (o instanceof boolean[]) {
                    jsonForBundle = new JSONArray();
                    final boolean[] array = (boolean[])o;
                    for (int length = array.length, j = 0; j < length; ++j) {
                        ((JSONArray)jsonForBundle).put(this.getJSONValue(array[j]));
                    }
                }
                else if (o instanceof char[]) {
                    jsonForBundle = new JSONArray();
                    final char[] array2 = (char[])o;
                    for (int length2 = array2.length, k = 0; k < length2; ++k) {
                        ((JSONArray)jsonForBundle).put(this.getJSONValue(array2[k]));
                    }
                }
                else if (o instanceof CharSequence[]) {
                    jsonForBundle = new JSONArray();
                    final CharSequence[] array3 = (CharSequence[])o;
                    for (int length3 = array3.length, l = 0; l < length3; ++l) {
                        ((JSONArray)jsonForBundle).put(this.getJSONValue(array3[l]));
                    }
                }
                else if (o instanceof double[]) {
                    jsonForBundle = new JSONArray();
                    final double[] array4 = (double[])o;
                    for (int length4 = array4.length, n = 0; n < length4; ++n) {
                        ((JSONArray)jsonForBundle).put(this.getJSONValue(array4[n]));
                    }
                }
                else if (o instanceof float[]) {
                    jsonForBundle = new JSONArray();
                    final float[] array5 = (float[])o;
                    for (int length5 = array5.length, n2 = 0; n2 < length5; ++n2) {
                        ((JSONArray)jsonForBundle).put(this.getJSONValue(array5[n2]));
                    }
                }
                else if (o instanceof int[]) {
                    jsonForBundle = new JSONArray();
                    final int[] array6 = (int[])o;
                    for (int length6 = array6.length, n3 = 0; n3 < length6; ++n3) {
                        ((JSONArray)jsonForBundle).put(this.getJSONValue(array6[n3]));
                    }
                }
                else if (o instanceof long[]) {
                    jsonForBundle = new JSONArray();
                    final long[] array7 = (long[])o;
                    for (int length7 = array7.length, n4 = 0; n4 < length7; ++n4) {
                        ((JSONArray)jsonForBundle).put(this.getJSONValue(array7[n4]));
                    }
                }
                else if (o instanceof short[]) {
                    jsonForBundle = new JSONArray();
                    final short[] array8 = (short[])o;
                    for (int length8 = array8.length, n5 = 0; n5 < length8; ++n5) {
                        ((JSONArray)jsonForBundle).put(this.getJSONValue(array8[n5]));
                    }
                }
                else {
                    if (!(o instanceof String[])) {
                        return null;
                    }
                    jsonForBundle = new JSONArray();
                    final String[] array9 = (String[])o;
                    for (int length9 = array9.length, n6 = 0; n6 < length9; ++n6) {
                        ((JSONArray)jsonForBundle).put(this.getJSONValue(array9[n6]));
                    }
                }
            }
        }
        return jsonForBundle;
    }
    
    private static AppLinkResolver getResolver(final Context context) {
        if (getDefaultResolver() != null) {
            return getDefaultResolver();
        }
        return new WebViewAppLinkResolver(context);
    }
    
    public static NavigationResult navigate(final Context context, final AppLink appLink) {
        return new AppLinkNavigation(appLink, null, null).navigate(context);
    }
    
    public static Task<NavigationResult> navigateInBackground(final Context context, final Uri uri) {
        return navigateInBackground(context, uri, getResolver(context));
    }
    
    public static Task<NavigationResult> navigateInBackground(final Context context, final Uri uri, final AppLinkResolver appLinkResolver) {
        return appLinkResolver.getAppLinkFromUrlInBackground(uri).onSuccess((Continuation<AppLink, NavigationResult>)new Continuation<AppLink, NavigationResult>() {
            @Override
            public NavigationResult then(final Task<AppLink> task) throws Exception {
                return AppLinkNavigation.navigate(context, task.getResult());
            }
        }, Task.UI_THREAD_EXECUTOR);
    }
    
    public static Task<NavigationResult> navigateInBackground(final Context context, final String s) {
        return navigateInBackground(context, s, getResolver(context));
    }
    
    public static Task<NavigationResult> navigateInBackground(final Context context, final String s, final AppLinkResolver appLinkResolver) {
        return navigateInBackground(context, Uri.parse(s), appLinkResolver);
    }
    
    public static Task<NavigationResult> navigateInBackground(final Context context, final URL url) {
        return navigateInBackground(context, url, getResolver(context));
    }
    
    public static Task<NavigationResult> navigateInBackground(final Context context, final URL url, final AppLinkResolver appLinkResolver) {
        return navigateInBackground(context, Uri.parse(url.toString()), appLinkResolver);
    }
    
    public static void setDefaultResolver(final AppLinkResolver defaultResolver) {
        AppLinkNavigation.defaultResolver = defaultResolver;
    }
    
    public AppLink getAppLink() {
        return this.appLink;
    }
    
    public Bundle getAppLinkData() {
        return this.appLinkData;
    }
    
    public Bundle getExtras() {
        return this.extras;
    }
    
    public NavigationResult navigate(final Context context) {
        final PackageManager packageManager = context.getPackageManager();
        final Bundle buildAppLinkDataForNavigation = this.buildAppLinkDataForNavigation();
        final Iterator<AppLink.Target> iterator = this.getAppLink().getTargets().iterator();
        Intent intent;
        while (true) {
            final boolean hasNext = iterator.hasNext();
            intent = null;
            if (!hasNext) {
                break;
            }
            final AppLink.Target target = iterator.next();
            final Intent intent2 = new Intent("android.intent.action.VIEW");
            if (target.getUrl() != null) {
                intent2.setData(target.getUrl());
            }
            else {
                intent2.setData(this.appLink.getSourceUrl());
            }
            intent2.setPackage(target.getPackageName());
            if (target.getClassName() != null) {
                intent2.setClassName(target.getPackageName(), target.getClassName());
            }
            intent2.putExtra("al_applink_data", buildAppLinkDataForNavigation);
            if (packageManager.resolveActivity(intent2, 65536) != null) {
                intent = intent2;
                break;
            }
        }
        if (intent != null) {
            context.startActivity(intent);
            return NavigationResult.APP;
        }
        final Uri webUrl = this.getAppLink().getWebUrl();
        if (webUrl != null) {
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", webUrl.buildUpon().appendQueryParameter("al_applink_data", this.getJSONForBundle(buildAppLinkDataForNavigation).toString()).build()));
                return NavigationResult.WEB;
            }
            catch (JSONException cause) {
                throw new RuntimeException((Throwable)cause);
            }
        }
        return NavigationResult.FAILED;
    }
    
    public enum NavigationResult
    {
        APP, 
        FAILED, 
        WEB;
    }
}
