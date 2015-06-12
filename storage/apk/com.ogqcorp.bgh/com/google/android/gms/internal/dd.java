// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.g;
import android.content.Context;

public final class dd
{
    public static ed a(final Context context, final cx cx, final de de) {
        if (cx.k.e) {
            return b(context, cx, de);
        }
        return c(context, cx, de);
    }
    
    private static ed b(final Context context, final cx cx, final de de) {
        en.a("Fetching ad response from local ad request service.");
        final dg dg = new dg(context, cx, de);
        dg.e();
        return dg;
    }
    
    private static ed c(final Context context, final cx cx, final de de) {
        en.a("Fetching ad response from remote ad request service.");
        if (g.a(context) != 0) {
            en.e("Failed to connect to remote ad request service.");
            return null;
        }
        return new dh(context, cx, de);
    }
}
