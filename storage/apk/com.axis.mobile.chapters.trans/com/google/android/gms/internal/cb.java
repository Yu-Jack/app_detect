// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.ads.AdRequest$Gender;
import java.util.Set;
import java.util.Date;
import java.util.Collection;
import java.util.HashSet;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.a;
import com.google.ads.AdSize;
import com.google.ads.AdRequest$ErrorCode;

public final class cb
{
    public static int a(final AdRequest$ErrorCode adRequest$ErrorCode) {
        switch (cb$1.nZ[adRequest$ErrorCode.ordinal()]) {
            default: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 4: {
                return 3;
            }
        }
    }
    
    public static AdSize b(final al al) {
        int i = 0;
        for (AdSize[] array = { AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER }; i < array.length; ++i) {
            if (array[i].getWidth() == al.width && array[i].getHeight() == al.height) {
                return array[i];
            }
        }
        return new AdSize(a.a(al.width, al.height, al.me));
    }
    
    public static MediationAdRequest e(final ai ai) {
        HashSet set;
        if (ai.lU != null) {
            set = new HashSet(ai.lU);
        }
        else {
            set = null;
        }
        return new MediationAdRequest(new Date(ai.lS), h(ai.lT), set, ai.lV, ai.ma);
    }
    
    public static AdRequest$Gender h(final int n) {
        switch (n) {
            default: {
                return AdRequest$Gender.UNKNOWN;
            }
            case 2: {
                return AdRequest$Gender.FEMALE;
            }
            case 1: {
                return AdRequest$Gender.MALE;
            }
        }
    }
}
