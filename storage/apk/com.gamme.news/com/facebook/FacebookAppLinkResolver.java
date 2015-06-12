// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import org.json.JSONArray;
import java.util.Iterator;
import com.facebook.model.GraphObject;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Map;
import bolts.Continuation;
import java.util.List;
import java.util.ArrayList;
import bolts.Task;
import org.json.JSONException;
import org.json.JSONObject;
import bolts.AppLink;
import android.net.Uri;
import java.util.HashMap;
import bolts.AppLinkResolver;

public class FacebookAppLinkResolver implements AppLinkResolver
{
    private static final String APP_LINK_ANDROID_TARGET_KEY = "android";
    private static final String APP_LINK_TARGET_APP_NAME_KEY = "app_name";
    private static final String APP_LINK_TARGET_CLASS_KEY = "class";
    private static final String APP_LINK_TARGET_PACKAGE_KEY = "package";
    private static final String APP_LINK_TARGET_SHOULD_FALLBACK_KEY = "should_fallback";
    private static final String APP_LINK_TARGET_URL_KEY = "url";
    private static final String APP_LINK_WEB_TARGET_KEY = "web";
    private final HashMap<Uri, AppLink> cachedAppLinks;
    
    public FacebookAppLinkResolver() {
        this.cachedAppLinks = new HashMap<Uri, AppLink>();
    }
    
    private static AppLink.Target getAndroidTargetFromJson(final JSONObject jsonObject) {
        final String tryGetStringFromJson = tryGetStringFromJson(jsonObject, "package", null);
        if (tryGetStringFromJson == null) {
            return null;
        }
        final String tryGetStringFromJson2 = tryGetStringFromJson(jsonObject, "class", null);
        final String tryGetStringFromJson3 = tryGetStringFromJson(jsonObject, "app_name", null);
        final String tryGetStringFromJson4 = tryGetStringFromJson(jsonObject, "url", null);
        Uri parse = null;
        if (tryGetStringFromJson4 != null) {
            parse = Uri.parse(tryGetStringFromJson4);
        }
        return new AppLink.Target(tryGetStringFromJson, tryGetStringFromJson2, parse, tryGetStringFromJson3);
    }
    
    private static Uri getWebFallbackUriFromJson(final Uri uri, final JSONObject jsonObject) {
        Uri parse;
        try {
            final JSONObject jsonObject2 = jsonObject.getJSONObject("web");
            if (!tryGetBooleanFromJson(jsonObject2, "should_fallback", true)) {
                return null;
            }
            final String tryGetStringFromJson = tryGetStringFromJson(jsonObject2, "url", null);
            parse = null;
            if (tryGetStringFromJson != null) {
                parse = Uri.parse(tryGetStringFromJson);
            }
            if (parse == null) {
                return uri;
            }
        }
        catch (JSONException ex) {
            parse = uri;
        }
        return parse;
    }
    
    private static boolean tryGetBooleanFromJson(final JSONObject jsonObject, final String s, final boolean b) {
        try {
            return jsonObject.getBoolean(s);
        }
        catch (JSONException ex) {
            return b;
        }
    }
    
    private static String tryGetStringFromJson(final JSONObject jsonObject, final String s, final String s2) {
        try {
            return jsonObject.getString(s);
        }
        catch (JSONException ex) {
            return s2;
        }
    }
    
    @Override
    public Task<AppLink> getAppLinkFromUrlInBackground(final Uri e) {
        final ArrayList<Uri> list = new ArrayList<Uri>();
        list.add(e);
        return this.getAppLinkFromUrlsInBackground(list).onSuccess((Continuation<Map<Uri, AppLink>, AppLink>)new Continuation<Map<Uri, AppLink>, AppLink>() {
            @Override
            public AppLink then(final Task<Map<Uri, AppLink>> task) throws Exception {
                return task.getResult().get(e);
            }
        });
    }
    
    public Task<Map<Uri, AppLink>> getAppLinkFromUrlsInBackground(final List<Uri> list) {
        final HashMap<Uri, AppLink> hashMap = new HashMap<Uri, AppLink>();
        final HashSet<Uri> set = new HashSet<Uri>();
        final StringBuilder sb = new StringBuilder();
        for (final Uri uri : list) {
            synchronized (this.cachedAppLinks) {
                final AppLink appLink = this.cachedAppLinks.get(uri);
                // monitorexit(this.cachedAppLinks)
                if (appLink != null) {
                    hashMap.put(uri, appLink);
                    continue;
                }
            }
            if (!set.isEmpty()) {
                sb.append(',');
            }
            sb.append(uri.toString());
            set.add(uri);
        }
        if (set.isEmpty()) {
            return (Task<Map<Uri, AppLink>>)Task.forResult(hashMap);
        }
        final Task.TaskCompletionSource create = Task.create();
        final Bundle bundle = new Bundle();
        bundle.putString("type", "al");
        bundle.putString("ids", sb.toString());
        bundle.putString("fields", String.format("%s,%s", "android", "web"));
        new Request(null, "", bundle, null, (Request.Callback)new Request.Callback() {
            @Override
            public void onCompleted(final Response response) {
                final FacebookRequestError error = response.getError();
                if (error != null) {
                    create.setError(error.getException());
                    return;
                }
                final GraphObject graphObject = response.getGraphObject();
                JSONObject innerJSONObject;
                if (graphObject != null) {
                    innerJSONObject = graphObject.getInnerJSONObject();
                }
                else {
                    innerJSONObject = null;
                }
                if (innerJSONObject == null) {
                    create.setResult(hashMap);
                    return;
                }
                for (final Uri key : set) {
                    if (innerJSONObject.has(key.toString())) {
                        try {
                            final JSONObject jsonObject = innerJSONObject.getJSONObject(key.toString());
                            final JSONArray jsonArray = jsonObject.getJSONArray("android");
                            final int length = jsonArray.length();
                            final ArrayList list = new ArrayList<AppLink.Target>(length);
                            int n = 0;
                            while (true) {
                                if (n >= length) {
                                    final AppLink value = new AppLink(key, (List<AppLink.Target>)list, getWebFallbackUriFromJson(key, jsonObject));
                                    hashMap.put(key, value);
                                    synchronized (FacebookAppLinkResolver.this.cachedAppLinks) {
                                        FacebookAppLinkResolver.this.cachedAppLinks.put(key, value);
                                        break;
                                    }
                                }
                                final AppLink.Target access$0 = getAndroidTargetFromJson(jsonArray.getJSONObject(n));
                                if (access$0 != null) {
                                    list.add(access$0);
                                }
                                ++n;
                            }
                        }
                        catch (JSONException ex) {}
                    }
                }
                create.setResult(hashMap);
            }
        }).executeAsync();
        return (Task<Map<Uri, AppLink>>)create.getTask();
    }
}
