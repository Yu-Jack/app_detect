// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.GooglePlayServicesUtil;
import android.content.Context;

public final class dp
{
    public static em a(final Context context, final ds ds, final dp$a dp$a) {
        if (ds.kQ.sz) {
            return b(context, ds, dp$a);
        }
        return c(context, ds, dp$a);
    }
    
    private static em b(final Context context, final ds ds, final dp$a dp$a) {
        eu.z("Fetching ad response from local ad request service.");
        final dq$a dq$a = new dq$a(context, ds, dp$a);
        dq$a.start();
        return dq$a;
    }
    
    private static em c(final Context context, final ds ds, final dp$a dp$a) {
        eu.z("Fetching ad response from remote ad request service.");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) != 0) {
            eu.D("Failed to connect to remote ad request service.");
            return null;
        }
        return new dq$b(context, ds, dp$a);
    }
}
