// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Locale;
import java.math.BigInteger;
import android.text.TextUtils;
import android.content.Context;

public final class ec
{
    private static final Object a;
    private static String b;
    
    static {
        a = new Object();
    }
    
    public static String a() {
        synchronized (ec.a) {
            return ec.b;
        }
    }
    
    public static String a(final Context context, final String s, final String s2) {
        synchronized (ec.a) {
            if (ec.b == null && !TextUtils.isEmpty((CharSequence)s)) {
                b(context, s, s2);
            }
            return ec.b;
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
                if (eg.a(classLoader, forName, split[i])) {
                    setBit = setBit.setBit(i);
                }
            }
        }
        catch (Throwable t) {
            ec.b = "err";
            return;
        }
        ec.b = String.format(Locale.US, "%X", setBit);
    }
}
