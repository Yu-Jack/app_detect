// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Map;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class ci
{
    private int a;
    private List b;
    private boolean c;
    private boolean d;
    
    public static ci a(final ci ci, final ci ci2) {
        if (ci == null || ci2 == null) {
            return null;
        }
        final List a = ci.a();
        final List a2 = ci2.a();
        if (a == null || a.isEmpty() || a2 == null || a2.isEmpty()) {
            return null;
        }
        final cq cq = a.get(0);
        final cq cq2 = a2.get(0);
        final cs c = cq.c();
        final cs c2 = cq2.c();
        if (c == null || c2 == null) {
            return null;
        }
        if (!cl.c.equals(c.a()) || (!cl.b.equals(c2.a()) && !cl.c.equals(c2.a()))) {
            return null;
        }
        final List g = c.g();
        final List g2 = c2.g();
        if (g2 == null || g2.isEmpty()) {
            return null;
        }
        final ArrayList<Object> list = new ArrayList<Object>(1);
        if (g == null || g.isEmpty()) {
            list.addAll(g2);
        }
        else {
            final ct ct = g.get(0);
            final ct ct2 = (ct)g2.get(0);
            final cu d = ct.d();
            final cu d2 = ct2.d();
            if (d == null || d2 == null) {
                return null;
            }
            final cu a3 = cu.a(d, d2);
            if (a3 == null) {
                return null;
            }
            final ct$a ct$a = new ct$a();
            ct$a.a(ct2.a());
            ct$a.a(ct2.b());
            ct$a.a(ct2.c());
            ct$a.a(a3);
            list.add(ct$a.a());
        }
        final cs$a cs$a = new cs$a();
        cs$a.a(cl.c);
        cs$a.a(c2.b());
        cs$a.a(c.c());
        final ArrayList list2 = new ArrayList();
        final List d3 = c.d();
        if (d3 != null) {
            list2.addAll(d3);
        }
        final List d4 = c2.d();
        if (d4 != null) {
            final Iterator<String> iterator = d4.iterator();
            while (iterator.hasNext()) {
                if (list2.contains(iterator.next())) {
                    return null;
                }
            }
            list2.addAll(d4);
        }
        cs$a.a(list2);
        final ArrayList list3 = new ArrayList();
        final List e = c.e();
        if (e != null) {
            list3.addAll(e);
        }
        final List e2 = c2.e();
        if (e2 != null) {
            list3.addAll(e2);
        }
        cs$a.b(list3);
        final ArrayList list4 = new ArrayList();
        final List f = c.f();
        if (f != null) {
            list4.addAll(f);
        }
        final List f2 = c2.f();
        if (f2 != null) {
            list4.addAll(f2);
        }
        cs$a.c(list4);
        cs$a.d(list);
        final cs a4 = cs$a.a();
        final cq$a cq$a = new cq$a();
        cq$a.a(cq.a());
        cq$a.a(cq.b());
        cq$a.a(a4);
        final cq a5 = cq$a.a();
        final ArrayList<cq> list5 = new ArrayList<cq>(1);
        list5.add(a5);
        final ci$a ci$a = new ci$a();
        ci$a.a(list5);
        ci$a.a(ci.b());
        ci$a.a(cl.b.equals(c2.a()));
        return ci$a.b();
    }
    
    public String a(final cp cp) {
        final List a = this.a();
        if (a != null && !a.isEmpty()) {
            final cs c = a.get(0).c();
            if (c != null) {
                final List g = c.g();
                if (g != null && !g.isEmpty()) {
                    final cu d = g.get(0).d();
                    if (d != null) {
                        final Map d2 = d.d();
                        if (d2 != null) {
                            return d2.get(cp);
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public List a() {
        return this.b;
    }
    
    public List a(final co co) {
        final List a = this.a();
        if (a != null && !a.isEmpty()) {
            final cs c = a.get(0).c();
            if (c != null) {
                final List g = c.g();
                if (g != null && !g.isEmpty()) {
                    final cu d = g.get(0).d();
                    if (d != null) {
                        final ds c2 = d.c();
                        if (c2 != null) {
                            return c2.a(co);
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public int b() {
        return this.a;
    }
    
    public boolean c() {
        return this.c;
    }
    
    public boolean d() {
        return this.d;
    }
    
    public String e() {
        final List a = this.a();
        if (a != null && !a.isEmpty()) {
            final cs c = a.get(0).c();
            if (c != null) {
                final List d = c.d();
                if (d != null && !d.isEmpty()) {
                    return d.get(-1 + d.size());
                }
            }
        }
        return null;
    }
    
    public String f() {
        final List a = this.a();
        if (a != null && !a.isEmpty()) {
            final cs c = a.get(0).c();
            if (c != null) {
                final List g = c.g();
                if (g != null && !g.isEmpty()) {
                    final cu d = g.get(0).d();
                    if (d != null) {
                        final cv e = d.e();
                        if (e != null && e.a() != null) {
                            return e.a();
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public List g() {
        final List a = this.a();
        if (a != null && !a.isEmpty()) {
            final cs c = a.get(0).c();
            if (c != null) {
                return c.f();
            }
        }
        return null;
    }
    
    public List h() {
        final List a = this.a();
        if (a != null && !a.isEmpty()) {
            final cs c = a.get(0).c();
            if (c != null) {
                return c.e();
            }
        }
        return null;
    }
}
