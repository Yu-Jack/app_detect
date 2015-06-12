// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Collections;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import java.util.Iterator;
import java.util.ArrayList;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.avro.protocol.v10.ScreenOrientationType;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class an
{
    private static final String a;
    private au b;
    private int c;
    private final Map d;
    
    static {
        a = an.class.getSimpleName();
    }
    
    public an() {
        this.c = 0;
        this.d = new HashMap();
        this.b = new au();
    }
    
    public List a(final String s, final int n, final int n2) {
        ArrayList<AdUnit> list = null;
    Label_0132_Outer:
        while (true) {
            while (true) {
                ScreenOrientationType screenOrientationType = null;
                List a3 = null;
                Label_0349: {
                    while (true) {
                        ScreenOrientationType a = null;
                        AdUnit adUnit = null;
                    Label_0278:
                        while (true) {
                            synchronized (this) {
                                a = cc.a();
                                final List<AdUnit> a2 = (List<AdUnit>)this.b.a(s, a);
                                if (this.b(a2)) {
                                    eo.a(3, an.a, "no valid ad units in cache for current orientation for " + s);
                                    if (ScreenOrientationType.a.equals(a)) {
                                        screenOrientationType = ScreenOrientationType.b;
                                        a3 = this.b.a(s, screenOrientationType);
                                        if (this.b(a3) || !this.a(a3.get(0))) {
                                            eo.a(3, an.a, "no valid ad units in cache for other orientation for " + s);
                                        }
                                        break Label_0349;
                                    }
                                }
                                else {
                                    list = new ArrayList<AdUnit>();
                                    if (a2 != null) {
                                        final Iterator<AdUnit> iterator = a2.iterator();
                                        while (iterator.hasNext() && list.size() < n2) {
                                            adUnit = iterator.next();
                                            if (!fe.a(adUnit.c()) || adUnit.e() != 1 || adUnit.d().size() <= 0) {
                                                break Label_0278;
                                            }
                                            list.add(adUnit);
                                            eo.a(3, an.a, "Found combinable ad unit for " + s);
                                        }
                                        break;
                                    }
                                    break;
                                }
                            }
                            screenOrientationType = ScreenOrientationType.a;
                            continue Label_0132_Outer;
                        }
                        if (!fe.a(adUnit.c()) || adUnit.d().size() <= 0) {
                            this.b.a(s, a, adUnit);
                            eo.a(3, an.a, "Removed invalid or expired ad unit for " + s);
                            continue;
                        }
                        continue;
                    }
                }
                final List<AdUnit> a2 = (List<AdUnit>)a3;
                ScreenOrientationType a = screenOrientationType;
                continue;
            }
        }
        // monitorexit(this)
        return list;
    }
    
    public void a() {
        synchronized (this) {
            this.b.a();
        }
    }
    
    public void a(final String s) {
        synchronized (this) {
            this.b.a(s);
        }
    }
    
    public void a(final String s, final int n) {
        synchronized (this) {
            this.b.a(s, cc.a(), n);
        }
    }
    
    public void a(final String s, final AdUnit adUnit) {
        synchronized (this) {
            this.b.a(s, cc.a(), adUnit);
        }
    }
    
    public void a(final String s, final String s2) {
        synchronized (this) {
            this.b.a(s, cc.a(), s2);
        }
    }
    
    public void a(final String s, final List list) {
        synchronized (this) {
            this.b.a(s, cc.a(), list);
        }
    }
    
    public void a(final List list) {
        final ds ds;
        synchronized (this) {
            ds = new ds();
            for (final AdUnit adUnit : list) {
                if (adUnit.g().length() > 0) {
                    y.a().a(new x(adUnit.g().toString(), adUnit.h(), adUnit.l(), adUnit.i(), adUnit.j(), adUnit.k()));
                }
                final String string = adUnit.b().toString();
                if (string != null) {
                    ds.a(string, adUnit);
                }
            }
        }
        for (final String s : ds.c()) {
            this.b.a(s, ds.a(s));
        }
    }
    // monitorexit(this)
    
    public boolean a(final AdUnit adUnit) {
        return adUnit.d().get(0).e().e().equals("takeover");
    }
    
    public void b(final String s) {
        // monitorenter(this)
        if (s == null) {
            return;
        }
        try {
            if (s.length() > 0) {
                this.c = this.b.b(s, cc.a());
                this.d.put(s, this.c);
            }
        }
        finally {
        }
        // monitorexit(this)
    }
    
    public boolean b(final List list) {
        return list == null || list.size() == 0 || list.get(0).d().size() == 0 || list.get(0).d().get(0).e() == null;
    }
    
    public int c(final String s) {
        while (true) {
            synchronized (this) {
                final Integer n = this.d.get(s);
                if (n != null) {
                    return n;
                }
            }
            return 0;
        }
    }
    
    public List d(final String str) {
        while (true) {
            List a2 = null;
        Label_0227:
            while (true) {
                final ScreenOrientationType a;
                final Iterator<AdUnit> iterator;
                AdUnit adUnit = null;
                Label_0167: {
                    synchronized (this) {
                        a = cc.a();
                        a2 = this.b.a(str, a);
                        if (this.b(a2)) {
                            eo.a(3, an.a, "no valid ad units in cache for current orientation for " + str);
                            final Object o = Collections.emptyList();
                            return (List)o;
                        }
                        if (!this.b(a2)) {
                            iterator = a2.iterator();
                            while (iterator.hasNext()) {
                                adUnit = iterator.next();
                                if (adUnit.d().size() > 0) {
                                    break Label_0167;
                                }
                                iterator.remove();
                                this.b.a(str, a, adUnit);
                                eo.a(3, an.a, "Removed invalid ad unit -- adspace: " + str);
                            }
                        }
                        break Label_0227;
                    }
                }
                if (!fe.a(adUnit.c())) {
                    iterator.remove();
                    this.b.a(str, a, adUnit);
                    eo.a(3, an.a, "Removed expired ad unit -- adspace: " + str);
                    continue;
                }
                continue;
            }
            if (!this.b(a2)) {
                eo.a(3, an.a, "found valid ad units for " + str);
                final Object o = a2;
                return (List)o;
            }
            eo.a(3, an.a, "no valid ad units for " + str);
            final Object o = Collections.emptyList();
            return (List)o;
        }
    }
}
