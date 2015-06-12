// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.ads.g;
import com.google.a.c;
import com.google.a.b;
import java.util.Set;
import java.util.Date;
import java.util.Collection;
import java.util.HashSet;
import com.google.a.a.a;

public final class bp
{
    public static a a(final ah ah) {
        HashSet<String> set;
        if (ah.e != null) {
            set = new HashSet<String>(ah.e);
        }
        else {
            set = null;
        }
        return new a(new Date(ah.b), a(ah.d), set, ah.f, ah.k);
    }
    
    public static b a(final int n) {
        switch (n) {
            default: {
                return b.a;
            }
            case 2: {
                return b.c;
            }
            case 1: {
                return b.b;
            }
        }
    }
    
    public static c a(final ak ak) {
        int i = 0;
        for (c[] array = { c.a, c.b, c.c, c.d, c.e, c.f }; i < array.length; ++i) {
            if (array[i].a() == ak.f && array[i].b() == ak.c) {
                return array[i];
            }
        }
        return new c(g.a(ak.f, ak.c, ak.b));
    }
}
