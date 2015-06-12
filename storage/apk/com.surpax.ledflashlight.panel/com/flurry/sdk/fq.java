// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Arrays;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class fq
{
    private static final ConcurrentMap a;
    private static final fn$f[] b;
    private final fn c;
    private final fn$f[] d;
    private final boolean[] e;
    private final ft f;
    private gc g;
    private gb h;
    
    static {
        a = new ConcurrentHashMap();
        b = new fn$f[0];
    }
    
    protected fq(final fn c, final ft f) {
        this.g = null;
        this.h = null;
        this.c = c;
        this.f = f;
        this.d = c.b().toArray(fq.b);
        this.e = new boolean[this.d.length];
    }
    
    protected static boolean b(final fn$f fn$f, final Object o) {
        if (o != null) {
            return true;
        }
        final fn c = fn$f.c();
        final fn$v a = c.a();
        if (a == fn$v.n) {
            return true;
        }
        if (a == fn$v.e) {
            final Iterator iterator = c.k().iterator();
            while (iterator.hasNext()) {
                if (iterator.next().a() == fn$v.n) {
                    return true;
                }
            }
        }
        return false;
    }
    
    protected Object a(final fn$f obj) {
        final hh e = obj.e();
        if (e == null) {
            throw new fk("Field " + obj + " not set and has no default value");
        }
        if (e.h() && (obj.c().a() == fn$v.n || (obj.c().a() == fn$v.e && obj.c().k().get(0).a() == fn$v.n))) {
            return null;
        }
        ConcurrentMap concurrentMap = (ConcurrentMap)fq.a.get(this.c.g());
        if (concurrentMap == null) {
            fq.a.putIfAbsent(this.c.g(), new ConcurrentHashMap(this.d.length));
            concurrentMap = (ConcurrentMap)fq.a.get(this.c.g());
        }
        Object o = concurrentMap.get(obj.b());
        if (o == null) {
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            go.a(this.g = gj.a().a(byteArrayOutputStream, this.g), obj.c(), e);
            this.g.flush();
            this.h = gg.a().a(byteArrayOutputStream.toByteArray(), this.h);
            o = this.f.a(obj.c()).a(null, this.h);
            concurrentMap.putIfAbsent(obj.b(), o);
        }
        return this.f.b(obj.c(), o);
    }
    
    protected void a(final fn$f obj, final Object o) {
        if (!b(obj, o) && obj.e() == null) {
            throw new fk("Field " + obj + " does not accept null values");
        }
    }
    
    protected final fn$f[] b() {
        return this.d;
    }
    
    protected final boolean[] c() {
        return this.e;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o == null) {
                return false;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }
            final fq fq = (fq)o;
            if (!Arrays.equals(this.e, fq.e)) {
                return false;
            }
            if (this.c == null) {
                if (fq.c != null) {
                    return false;
                }
            }
            else if (!this.c.equals(fq.c)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        final int n = 31 * (31 + Arrays.hashCode(this.e));
        int hashCode;
        if (this.c == null) {
            hashCode = 0;
        }
        else {
            hashCode = this.c.hashCode();
        }
        return hashCode + n;
    }
}
