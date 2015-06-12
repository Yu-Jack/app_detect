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

public final class bw extends bg
{
    @Override
    protected final aj a(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdUnit adUnit, final Bundle bundle) {
        if (context == null || flurryAdModule == null || e == null || adUnit == null || bundle == null) {
            return null;
        }
        return new bz(context, flurryAdModule, e, adUnit, bundle);
    }
    
    @Override
    protected final i a(final Context context, final FlurryAdModule flurryAdModule, final e e, final AdCreative adCreative, final Bundle bundle) {
        if (context == null || flurryAdModule == null || e == null || adCreative == null || bundle == null) {
            return null;
        }
        return new bx(context, flurryAdModule, e, adCreative, bundle);
    }
    
    @Override
    protected final String f() {
        return "Millennial Media";
    }
    
    @Override
    protected final List g() {
        final ArrayList<bc> list = new ArrayList<bc>();
        list.add(new bc("MMAdView", "5.1.0", "com.millennialmedia.android.MMInterstitial"));
        return list;
    }
    
    @Override
    protected final List h() {
        final ArrayList<String> list = new ArrayList<String>();
        list.add("com.flurry.millennial.MYAPIDINTERSTITIAL");
        return list;
    }
    
    @TargetApi(13)
    @Override
    protected final List j() {
        final ArrayList<ActivityInfo> list = new ArrayList<ActivityInfo>();
        final ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.name = "com.millennialmedia.android.MMActivity";
        activityInfo.configChanges = 3248;
        list.add(activityInfo);
        return list;
    }
    
    @Override
    protected final List k() {
        final ArrayList<bc> list = new ArrayList<bc>();
        list.add(new bc("MMAdView", "5.1.0", "com.millennialmedia.android.MMAdView"));
        return list;
    }
    
    @Override
    protected final List l() {
        final ArrayList<String> list = new ArrayList<String>();
        list.add("com.flurry.millennial.MYAPID");
        list.add("com.flurry.millennial.MYAPIDRECTANGLE");
        return list;
    }
    
    @Override
    protected final List n() {
        return new ArrayList();
    }
    
    @Override
    protected final List o() {
        final ArrayList<String> list = new ArrayList<String>();
        list.add("android.permission.INTERNET");
        list.add("android.permission.WRITE_EXTERNAL_STORAGE");
        list.add("android.permission.ACCESS_NETWORK_STATE");
        return list;
    }
}
