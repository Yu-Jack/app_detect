// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.location.Location;
import java.util.Set;
import java.util.Date;
import com.google.android.gms.ads.c.b;
import com.google.a.a.a.a;
import java.util.List;
import java.util.Collections;
import java.util.Collection;
import java.util.ArrayList;
import android.content.Context;

public class j
{
    public static final j a;
    
    static {
        a = new j();
    }
    
    public static j a() {
        return j.a;
    }
    
    public ah a(final Context context, final z z) {
        final Date a = z.a();
        long time;
        if (a != null) {
            time = a.getTime();
        }
        else {
            time = -1L;
        }
        final String b = z.b();
        final int c = z.c();
        final Set<String> d = z.d();
        Object unmodifiableList;
        if (!d.isEmpty()) {
            unmodifiableList = Collections.unmodifiableList((List<?>)new ArrayList<Object>(d));
        }
        else {
            unmodifiableList = null;
        }
        final boolean a2 = z.a(context);
        final int k = z.k();
        final Location e = z.e();
        final Bundle a3 = z.a(a.class);
        final boolean f = z.f();
        final String g = z.g();
        final com.google.android.gms.ads.e.a h = z.h();
        av av;
        if (h != null) {
            av = new av(h);
        }
        else {
            av = null;
        }
        return new ah(3, time, a3, c, (List<String>)unmodifiableList, a2, k, f, g, av, e, b);
    }
}
