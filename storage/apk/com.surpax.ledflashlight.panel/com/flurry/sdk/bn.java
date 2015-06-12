// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import android.annotation.TargetApi;
import android.content.pm.ActivityInfo;
import java.util.ArrayList;
import java.util.List;
import com.flurry.android.AdCreative;
import android.os.Bundle;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.FlurryAdModule;
import android.content.Context;

public class bn extends bg
{
    @Override
    protected aj a(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdUnit adUnit, final Bundle bundle) {
        if (context == null || flurryAdModule == null || e == null || adUnit == null || bundle == null) {
            return null;
        }
        return new bo(context, flurryAdModule, e, adUnit, bundle);
    }
    
    @Override
    protected i a(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdCreative adCreative, final Bundle bundle) {
        if (context == null || flurryAdModule == null || e == null || adCreative == null || bundle == null) {
            return null;
        }
        return new bm(context, flurryAdModule, e, adCreative, bundle);
    }
    
    @Override
    protected String f() {
        return "Facebook Audience Network";
    }
    
    @Override
    protected List g() {
        final ArrayList<bc> list = new ArrayList<bc>();
        list.add(new bc("AudienceNetwork", "3.14.+", "com.facebook.ads.InterstitialAd"));
        return list;
    }
    
    @TargetApi(13)
    @Override
    protected List j() {
        final ArrayList<ActivityInfo> list = new ArrayList<ActivityInfo>();
        final ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.name = "com.facebook.ads.InterstitialAdActivity";
        activityInfo.configChanges = 4016;
        list.add(activityInfo);
        return list;
    }
    
    @Override
    protected List k() {
        final ArrayList<bc> list = new ArrayList<bc>();
        list.add(new bc("AudienceNetwork", "3.14.+", "com.facebook.ads.Ad"));
        return list;
    }
    
    @Override
    protected List n() {
        final ArrayList<String> list = new ArrayList<String>();
        list.add("com.flurry.fan.MY_APP_ID");
        return list;
    }
    
    @Override
    protected List o() {
        final ArrayList<String> list = new ArrayList<String>();
        list.add("android.permission.INTERNET");
        list.add("android.permission.ACCESS_NETWORK_STATE");
        return list;
    }
}
