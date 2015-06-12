// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.Intent;
import android.app.Activity;
import com.google.android.gms.common.api.a$b;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.List;
import android.net.Uri$Builder;
import android.net.Uri;
import com.google.android.gms.appindexing.AppIndexApi;

public final class fy implements AppIndexApi, ft
{
    static Uri a(final String s, final Uri obj) {
        if (!"android-app".equals(obj.getScheme())) {
            throw new IllegalArgumentException("Uri scheme must be android-app: " + obj);
        }
        if (!s.equals(obj.getHost())) {
            throw new IllegalArgumentException("Uri host must match package name: " + obj);
        }
        final List pathSegments = obj.getPathSegments();
        if (pathSegments.isEmpty() || pathSegments.get(0).isEmpty()) {
            throw new IllegalArgumentException("Uri path must exist: " + obj);
        }
        final String s2 = pathSegments.get(0);
        final Uri$Builder uri$Builder = new Uri$Builder();
        uri$Builder.scheme(s2);
        if (pathSegments.size() > 1) {
            uri$Builder.authority((String)pathSegments.get(1));
            for (int i = 2; i < pathSegments.size(); ++i) {
                uri$Builder.appendPath((String)pathSegments.get(i));
            }
        }
        uri$Builder.encodedQuery(obj.getEncodedQuery());
        uri$Builder.encodedFragment(obj.getEncodedFragment());
        return uri$Builder.build();
    }
    
    public PendingResult a(final GoogleApiClient googleApiClient, final fr... array) {
        return googleApiClient.a(new fy$2(this, ((fx)googleApiClient.a(ff.xI)).getContext().getPackageName(), array));
    }
    
    @Override
    public PendingResult view(final GoogleApiClient googleApiClient, final Activity activity, final Intent intent, final String s, final Uri uri, final List list) {
        return this.a(googleApiClient, new fr(((fx)googleApiClient.a(ff.xI)).getContext().getPackageName(), intent, s, uri, null, list));
    }
    
    @Override
    public PendingResult view(final GoogleApiClient googleApiClient, final Activity activity, final Uri uri, final String s, final Uri uri2, final List list) {
        return this.view(googleApiClient, activity, new Intent("android.intent.action.VIEW", a(((fx)googleApiClient.a(ff.xI)).getContext().getPackageName(), uri)), s, uri2, list);
    }
    
    @Override
    public PendingResult viewEnd(final GoogleApiClient googleApiClient, final Activity activity, final Intent intent) {
        return this.a(googleApiClient, new fr(fr.a(((fx)googleApiClient.a(ff.xI)).getContext().getPackageName(), intent), System.currentTimeMillis(), 3));
    }
    
    @Override
    public PendingResult viewEnd(final GoogleApiClient googleApiClient, final Activity activity, final Uri uri) {
        return this.viewEnd(googleApiClient, activity, new Intent("android.intent.action.VIEW", a(((fx)googleApiClient.a(ff.xI)).getContext().getPackageName(), uri)));
    }
}
