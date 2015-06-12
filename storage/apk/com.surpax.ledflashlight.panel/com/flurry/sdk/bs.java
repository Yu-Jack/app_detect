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

public final class bs extends bg
{
    @Override
    protected final aj a(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdUnit adUnit, final Bundle bundle) {
        if (context == null || flurryAdModule == null || e == null || adUnit == null || bundle == null) {
            return null;
        }
        return new bv(context, flurryAdModule, e, adUnit, bundle);
    }
    
    @Override
    protected final i a(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdCreative adCreative, final Bundle bundle) {
        if (context == null || flurryAdModule == null || e == null || adCreative == null || bundle == null) {
            return null;
        }
        return new bt(context, flurryAdModule, e, adCreative, bundle);
    }
    
    @Override
    protected final String f() {
        return "InMobi";
    }
    
    @Override
    protected final List g() {
        final ArrayList<bc> list = new ArrayList<bc>();
        list.add(new bc("InMobiAndroidSDK", "4.1.0", "com.inmobi.monetization.IMInterstitial"));
        return list;
    }
    
    @TargetApi(13)
    @Override
    protected final List j() {
        final ArrayList<ActivityInfo> list = new ArrayList<ActivityInfo>();
        final ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.name = "com.inmobi.androidsdk.IMBrowserActivity";
        activityInfo.configChanges = 3248;
        list.add(activityInfo);
        return list;
    }
    
    @Override
    protected final List k() {
        final ArrayList<bc> list = new ArrayList<bc>();
        list.add(new bc("InMobiAndroidSDK", "4.1.0", "com.inmobi.monetization.IMBanner"));
        return list;
    }
    
    @Override
    protected final List n() {
        final ArrayList<String> list = new ArrayList<String>();
        list.add("com.flurry.inmobi.MY_APP_ID");
        return list;
    }
    
    @Override
    protected final List o() {
        final ArrayList<String> list = new ArrayList<String>();
        list.add("android.permission.INTERNET");
        return list;
    }
}
