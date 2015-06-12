// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Collection;
import java.util.ArrayList;
import android.util.Pair;
import java.util.List;
import com.flurry.android.impl.ads.avro.protocol.v10.ScreenOrientationType;

public class au
{
    private static final String a;
    private final ds b;
    
    static {
        a = au.class.getSimpleName();
    }
    
    public au() {
        this.b = new ds();
    }
    
    public List a(final String s, final ScreenOrientationType screenOrientationType) {
        synchronized (this) {
            final List a = this.b.a(Pair.create((Object)s, (Object)screenOrientationType));
            List list;
            if (a == null) {
                list = null;
            }
            else {
                list = new ArrayList(a);
            }
            return list;
        }
    }
    
    public void a() {
        synchronized (this) {
            final HashSet<Object> set = new HashSet<Object>();
            final Iterator<Pair> iterator = (Iterator<Pair>)this.b.c().iterator();
            while (iterator.hasNext()) {
                set.add(iterator.next().first);
            }
        }
        this.b.a();
    }
    // monitorexit(this)
    
    public void a(final String s) {
        synchronized (this) {
            this.b.b(Pair.create((Object)s, (Object)ScreenOrientationType.a));
            this.b.b(Pair.create((Object)s, (Object)ScreenOrientationType.b));
        }
    }
    
    public void a(final String s, final ScreenOrientationType screenOrientationType, final int n) {
        while (true) {
            final List a;
            Label_0063: {
                synchronized (this) {
                    final Pair create = Pair.create((Object)s, (Object)screenOrientationType);
                    a = this.b.a(create);
                    if (a != null) {
                        if (n >= 0 && n <= a.size()) {
                            break Label_0063;
                        }
                        this.b.b(create);
                    }
                    return;
                }
            }
            if (n > 0) {
                a.subList(0, n).clear();
            }
        }
    }
    
    public void a(final String s, final ScreenOrientationType screenOrientationType, final String anObject) {
        synchronized (this) {
            final List a = this.b.a(Pair.create((Object)s, (Object)screenOrientationType));
            if (a != null) {
                final Iterator<AdUnit> iterator = a.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().f().toString().equals(anObject)) {
                        iterator.remove();
                    }
                }
            }
        }
    }
    
    public void a(final String str, final List list) {
        // monitorenter(this)
        if (list != null) {
            try {
                eo.a(3, au.a, "putting " + list.size() + " adSpace: " + str);
                for (final AdUnit adUnit : list) {
                    this.b.a(Pair.create((Object)str, (Object)adUnit.u()), adUnit);
                }
            }
            finally {
            }
            // monitorexit(this)
        }
    }
    // monitorexit(this)
    
    public boolean a(final String s, final ScreenOrientationType screenOrientationType, final AdUnit adUnit) {
        // monitorenter(this)
        boolean remove = false;
        if (adUnit != null) {
            try {
                final List a = this.b.a(Pair.create((Object)s, (Object)screenOrientationType));
                remove = false;
                if (a != null) {
                    remove = a.remove(adUnit);
                }
            }
            finally {
            }
            // monitorexit(this)
        }
        // monitorexit(this)
        return remove;
    }
    
    public boolean a(final String s, final ScreenOrientationType screenOrientationType, final List list) {
        // monitorenter(this)
        boolean removeAll = false;
        if (list != null) {
            try {
                final List a = this.b.a(Pair.create((Object)s, (Object)screenOrientationType));
                removeAll = false;
                if (a != null) {
                    removeAll = a.removeAll(list);
                }
            }
            finally {
            }
            // monitorexit(this)
        }
        // monitorexit(this)
        return removeAll;
    }
    
    public int b(final String s, final ScreenOrientationType screenOrientationType) {
        synchronized (this) {
            final List a = this.b.a(Pair.create((Object)s, (Object)screenOrientationType));
            int size;
            if (a == null) {
                size = 0;
            }
            else {
                size = a.size();
            }
            return size;
        }
    }
}
