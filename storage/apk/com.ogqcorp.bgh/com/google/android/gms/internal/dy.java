// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.util.UUID;
import android.os.Bundle;
import java.util.HashMap;
import java.util.HashSet;
import java.math.BigInteger;

public class dy
{
    public static final String a;
    private static final dy c;
    public final String b;
    private final Object d;
    private final dz e;
    private BigInteger f;
    private final HashSet<dv> g;
    private final HashMap<String, eb> h;
    
    static {
        c = new dy();
        a = dy.c.b;
    }
    
    private dy() {
        this.d = new Object();
        this.f = BigInteger.ONE;
        this.g = new HashSet<dv>();
        this.h = new HashMap<String, eb>();
        this.b = f();
        this.e = new dz(this.b);
    }
    
    public static Bundle a(final ea ea, final String s) {
        return dy.c.b(ea, s);
    }
    
    public static dy a() {
        return dy.c;
    }
    
    public static void a(final HashSet<dv> set) {
        dy.c.b(set);
    }
    
    public static String b() {
        return dy.c.c();
    }
    
    public static dz d() {
        return dy.c.e();
    }
    
    private static String f() {
        final UUID randomUUID = UUID.randomUUID();
        final byte[] byteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        final byte[] byteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String s = new BigInteger(1, byteArray).toString();
        int n = 0;
    Label_0105_Outer:
        while (true) {
            if (n >= 2) {
                return s;
            }
            while (true) {
                try {
                    final MessageDigest instance = MessageDigest.getInstance("MD5");
                    instance.update(byteArray);
                    instance.update(byteArray2);
                    final byte[] magnitude = new byte[8];
                    System.arraycopy(instance.digest(), 0, magnitude, 0, 8);
                    s = new BigInteger(1, magnitude).toString();
                    ++n;
                    continue Label_0105_Outer;
                }
                catch (NoSuchAlgorithmException ex) {
                    continue;
                }
                break;
            }
        }
    }
    
    public void a(final dv e) {
        synchronized (this.d) {
            this.g.add(e);
        }
    }
    
    public void a(final String key, final eb value) {
        synchronized (this.d) {
            this.h.put(key, value);
        }
    }
    
    public Bundle b(final ea ea, final String s) {
        final Bundle bundle;
        final Bundle bundle2;
        synchronized (this.d) {
            bundle = new Bundle();
            bundle.putBundle("app", this.e.a(s));
            bundle2 = new Bundle();
            for (final String key : this.h.keySet()) {
                bundle2.putBundle(key, this.h.get(key).a());
            }
        }
        bundle.putBundle("slots", bundle2);
        final ArrayList<Bundle> list = new ArrayList<Bundle>();
        final Iterator<dv> iterator2 = this.g.iterator();
        while (iterator2.hasNext()) {
            list.add(iterator2.next().d());
        }
        bundle.putParcelableArrayList("ads", (ArrayList)list);
        ea.a(this.g);
        this.g.clear();
        // monitorexit(o)
        return bundle;
    }
    
    public void b(final HashSet<dv> c) {
        synchronized (this.d) {
            this.g.addAll((Collection<?>)c);
        }
    }
    
    public String c() {
        synchronized (this.d) {
            final String string = this.f.toString();
            this.f = this.f.add(BigInteger.ONE);
            return string;
        }
    }
    
    public dz e() {
        synchronized (this.d) {
            return this.e;
        }
    }
}
