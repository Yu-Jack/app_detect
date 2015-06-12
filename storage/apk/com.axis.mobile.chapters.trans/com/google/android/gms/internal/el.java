// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Locale;
import java.math.BigInteger;
import android.text.TextUtils;
import android.content.Context;

public final class el
{
    private static final Object qp;
    private static String se;
    
    static {
        qp = new Object();
    }
    
    public static String a(final Context context, final String s, final String s2) {
        synchronized (el.qp) {
            if (el.se == null && !TextUtils.isEmpty((CharSequence)s)) {
                b(context, s, s2);
            }
            return el.se;
        }
    }
    
    private static void b(final Context context, final String s, final String s2) {
        BigInteger setBit;
        try {
            final ClassLoader classLoader = context.createPackageContext(s2, 3).getClassLoader();
            final Class<?> forName = Class.forName("com.google.ads.mediation.MediationAdapter", false, classLoader);
            final BigInteger bigInteger = new BigInteger(new byte[1]);
            final String[] split = s.split(",");
            setBit = bigInteger;
            for (int i = 0; i < split.length; ++i) {
                if (eo.a(classLoader, forName, split[i])) {
                    setBit = setBit.setBit(i);
                }
            }
        }
        catch (Throwable t) {
            el.se = "err";
            return;
        }
        el.se = String.format(Locale.US, "%X", setBit);
    }
    
    public static String bP() {
        synchronized (el.qp) {
            return el.se;
        }
    }
}
