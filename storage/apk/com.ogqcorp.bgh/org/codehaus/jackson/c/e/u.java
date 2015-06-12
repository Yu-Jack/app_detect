// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.e;

import java.util.AbstractSequentialList;
import org.codehaus.jackson.c.i.k;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import org.codehaus.jackson.c.h;
import java.util.List;
import org.codehaus.jackson.c.ao;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.ai;

public class u
{
    protected final ai<?> a;
    protected final boolean b;
    protected final a c;
    protected final b d;
    protected final x<?> e;
    protected final org.codehaus.jackson.c.b f;
    protected final LinkedHashMap<String, v> g;
    protected LinkedList<v> h;
    protected LinkedList<f> i;
    protected LinkedList<f> j;
    protected LinkedList<f> k;
    protected Set<String> l;
    protected Set<String> m;
    protected LinkedHashMap<Object, e> n;
    
    protected u(final ai<?> a, final boolean b, final a c, final b d) {
        this.g = new LinkedHashMap<String, v>();
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        final boolean b2 = a.b();
        org.codehaus.jackson.c.b a2 = null;
        if (b2) {
            a2 = this.a.a();
        }
        this.f = a2;
        if (this.f == null) {
            this.e = this.a.e();
            return;
        }
        this.e = this.f.a(d, this.a.e());
    }
    
    private Set<String> a(Set<String> set, final String s) {
        if (set == null) {
            set = new HashSet<String>();
        }
        set.add(s);
        return set;
    }
    
    private void a(final v v) {
        if (!this.b) {
            final String a = v.a();
            this.l = this.a(this.l, a);
            if (v.u()) {
                this.m = this.a(this.m, a);
            }
        }
    }
    
    public ai<?> a() {
        return this.a;
    }
    
    protected void a(final Object o, final e value) {
        if (o != null) {
            if (this.n == null) {
                this.n = new LinkedHashMap<Object, e>();
            }
            if (this.n.put(o, value) != null) {
                String name;
                if (o == null) {
                    name = "[null]";
                }
                else {
                    name = o.getClass().getName();
                }
                throw new IllegalArgumentException("Duplicate injectable value with id '" + String.valueOf(o) + "' (of type " + name + ")");
            }
        }
    }
    
    protected void a(final String str) {
        throw new IllegalArgumentException("Problem with definition of " + this.d + ": " + str);
    }
    
    protected void a(final ao ao) {
        final v[] array = this.g.values().toArray(new v[this.g.size()]);
        this.g.clear();
        final int length = array.length;
        int i = 0;
    Label_0090_Outer:
        while (i < length) {
            v a = array[i];
            final String a2 = a.a();
            while (true) {
                Label_0300: {
                    String s;
                    if (this.b) {
                        if (a.c()) {
                            s = ao.a(this.a, a.h(), a2);
                        }
                        else {
                            if (!a.e()) {
                                break Label_0300;
                            }
                            s = ao.a(this.a, a.j(), a2);
                        }
                    }
                    else if (a.d()) {
                        s = ao.b(this.a, a.i(), a2);
                    }
                    else if (a.f()) {
                        s = ao.a(this.a, a.n(), a2);
                    }
                    else if (a.e()) {
                        s = ao.a(this.a, a.j(), a2);
                    }
                    else {
                        if (!a.c()) {
                            break Label_0300;
                        }
                        s = ao.a(this.a, a.h(), a2);
                    }
                    if (!s.equals(a.a())) {
                        a = a.a(s);
                    }
                    final v v = this.g.get(s);
                    if (v == null) {
                        this.g.put(s, a);
                    }
                    else {
                        v.b(a);
                    }
                    ++i;
                    continue Label_0090_Outer;
                }
                String s = a2;
                continue;
            }
        }
    }
    
    protected v b(final String s) {
        v value = this.g.get(s);
        if (value == null) {
            value = new v(s);
            this.g.put(s, value);
        }
        return value;
    }
    
    public a b() {
        return this.c;
    }
    
    public b c() {
        return this.d;
    }
    
    public List<h> d() {
        return new ArrayList<h>(this.g.values());
    }
    
    public Map<Object, e> e() {
        return this.n;
    }
    
    public f f() {
        if (this.k != null) {
            if (this.k.size() > 1) {
                this.a("Multiple value properties defined (" + this.k.get(0) + " vs " + this.k.get(1) + ")");
            }
            return this.k.get(0);
        }
        return null;
    }
    
    public f g() {
        if (this.i != null) {
            if (this.i.size() > 1) {
                this.a("Multiple 'any-getters' defined (" + this.i.get(0) + " vs " + this.i.get(1) + ")");
            }
            return this.i.getFirst();
        }
        return null;
    }
    
    public f h() {
        if (this.j != null) {
            if (this.j.size() > 1) {
                this.a("Multiple 'any-setters' defined (" + this.j.get(0) + " vs " + this.j.get(1) + ")");
            }
            return this.j.getFirst();
        }
        return null;
    }
    
    public Set<String> i() {
        return this.l;
    }
    
    public Set<String> j() {
        return this.m;
    }
    
    public u k() {
        this.g.clear();
        this.m();
        this.o();
        this.n();
        this.p();
        this.q();
        this.r();
        final ao j = this.a.j();
        if (j != null) {
            this.a(j);
        }
        final Iterator<v> iterator = this.g.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().q();
        }
        final Iterator<v> iterator2 = this.g.values().iterator();
        while (iterator2.hasNext()) {
            iterator2.next().a(this.b);
        }
        this.l();
        return this;
    }
    
    protected void l() {
        final org.codehaus.jackson.c.b a = this.a.a();
        final Boolean i = a.i(this.d);
        boolean b;
        if (i == null) {
            b = this.a.d();
        }
        else {
            b = i;
        }
        final String[] h = a.h(this.d);
        if (!b && this.h == null && h == null) {
            return;
        }
        final int size = this.g.size();
        Cloneable cloneable;
        if (b) {
            cloneable = new TreeMap<Object, Object>();
        }
        else {
            cloneable = new LinkedHashMap<Object, Object>(size + size);
        }
        for (final v v : this.g.values()) {
            ((Map<String, v>)cloneable).put(v.a(), v);
        }
        final LinkedHashMap m = new LinkedHashMap<String, v>(size + size);
        if (h != null) {
            final int length = h.length;
            int j = 0;
        Label_0277_Outer:
            while (j < length) {
                final String s = h[j];
                v v2 = ((Map<String, v>)cloneable).get(s);
            Label_0277:
                while (true) {
                    if (v2 == null) {
                        for (final v v3 : this.g.values()) {
                            if (s.equals(v3.m())) {
                                final String a2 = v3.a();
                                v2 = v3;
                                break Label_0277;
                            }
                        }
                    }
                    Label_0382: {
                        break Label_0382;
                        if (v2 != null) {
                            final String a2;
                            m.put(a2, v2);
                        }
                        ++j;
                        continue Label_0277_Outer;
                    }
                    final String a2 = s;
                    continue Label_0277;
                }
            }
        }
        if (this.h != null) {
            for (final v v4 : this.h) {
                m.put(v4.a(), v4);
            }
        }
        m.putAll((Map<?, ?>)cloneable);
        this.g.clear();
        this.g.putAll((Map<?, ?>)m);
    }
    
    protected void m() {
        final org.codehaus.jackson.c.b f = this.f;
        for (final d d : this.d.l()) {
            final String b = d.b();
            String anObject;
            if (f == null) {
                anObject = null;
            }
            else if (this.b) {
                anObject = f.b(d);
            }
            else {
                anObject = f.c(d);
            }
            String s;
            if ("".equals(anObject)) {
                s = b;
            }
            else {
                s = anObject;
            }
            final boolean b2 = s != null;
            boolean a;
            if (!b2) {
                a = this.e.a(d);
            }
            else {
                a = b2;
            }
            this.b(b).a(d, s, a, f != null && f.c((e)d));
        }
    }
    
    protected void n() {
        final org.codehaus.jackson.c.b f = this.f;
        if (f != null) {
            for (final c c : this.d.i()) {
                if (this.h == null) {
                    this.h = new LinkedList<v>();
                }
                for (int f2 = c.f(), i = 0; i < f2; ++i) {
                    final org.codehaus.jackson.c.e.h c2 = c.c(i);
                    final String a = f.a(c2);
                    if (a != null) {
                        final v b = this.b(a);
                        b.a(c2, a, true, false);
                        this.h.add(b);
                    }
                }
            }
            for (final f f3 : this.d.j()) {
                if (this.h == null) {
                    this.h = new LinkedList<v>();
                }
                for (int f4 = f3.f(), j = 0; j < f4; ++j) {
                    final org.codehaus.jackson.c.e.h c3 = f3.c(j);
                    final String a2 = f.a(c3);
                    if (a2 != null) {
                        final v b2 = this.b(a2);
                        b2.a(c3, a2, true, false);
                        this.h.add(b2);
                    }
                }
            }
        }
    }
    
    protected void o() {
        final org.codehaus.jackson.c.b f = this.f;
        for (final f e : this.d.k()) {
            final int f2 = e.f();
            if (f2 == 0) {
                if (f != null) {
                    if (f.f(e)) {
                        if (this.i == null) {
                            this.i = new LinkedList<f>();
                        }
                        this.i.add(e);
                        continue;
                    }
                    if (f.c(e)) {
                        if (this.k == null) {
                            this.k = new LinkedList<f>();
                        }
                        this.k.add(e);
                        continue;
                    }
                }
                String b;
                if (f == null) {
                    b = null;
                }
                else {
                    b = f.b(e);
                }
                String s;
                String s2;
                boolean b3;
                if (b == null) {
                    s = org.codehaus.jackson.c.i.k.a(e, e.b());
                    if (s == null) {
                        s = org.codehaus.jackson.c.i.k.b(e, e.b());
                        if (s == null) {
                            continue;
                        }
                        final boolean b2 = this.e.b(e);
                        s2 = b;
                        b3 = b2;
                    }
                    else {
                        final boolean a = this.e.a(e);
                        s2 = b;
                        b3 = a;
                    }
                }
                else {
                    String s3 = org.codehaus.jackson.c.i.k.a(e);
                    if (s3 == null) {
                        s3 = e.b();
                    }
                    if (b.length() == 0) {
                        b = s3;
                    }
                    s = s3;
                    s2 = b;
                    b3 = true;
                }
                this.b(s).a(e, s2, b3, f != null && f.c((e)e));
            }
            else if (f2 == 1) {
                String d;
                if (f == null) {
                    d = null;
                }
                else {
                    d = f.d(e);
                }
                String b4;
                String s4;
                boolean b5;
                if (d == null) {
                    b4 = org.codehaus.jackson.c.i.k.b(e);
                    if (b4 == null) {
                        continue;
                    }
                    final boolean c = this.e.c(e);
                    s4 = d;
                    b5 = c;
                }
                else {
                    String s5 = org.codehaus.jackson.c.i.k.b(e);
                    if (s5 == null) {
                        s5 = e.b();
                    }
                    if (d.length() == 0) {
                        d = s5;
                    }
                    b4 = s5;
                    s4 = d;
                    b5 = true;
                }
                this.b(b4).b(e, s4, b5, f != null && f.c((e)e));
            }
            else {
                if (f2 != 2 || f == null || !f.e(e)) {
                    continue;
                }
                if (this.j == null) {
                    this.j = new LinkedList<f>();
                }
                this.j.add(e);
            }
        }
    }
    
    protected void p() {
        final org.codehaus.jackson.c.b f = this.f;
        if (f != null) {
            for (final d d : this.d.l()) {
                this.a(f.d(d), d);
            }
            for (final f f2 : this.d.k()) {
                if (f2.f() == 1) {
                    this.a(f.d((e)f2), f2);
                }
            }
        }
    }
    
    protected void q() {
        final Iterator<Map.Entry<Object, Object>> iterator = this.g.entrySet().iterator();
        while (iterator.hasNext()) {
            final v v = iterator.next().getValue();
            if (!v.s()) {
                iterator.remove();
            }
            else {
                if (v.t()) {
                    this.a(v);
                    if (!v.r()) {
                        iterator.remove();
                        continue;
                    }
                    v.o();
                }
                v.p();
            }
        }
    }
    
    protected void r() {
        final Iterator<Map.Entry<Object, Object>> iterator = this.g.entrySet().iterator();
        AbstractSequentialList<v> list = null;
        while (iterator.hasNext()) {
            final v v = iterator.next().getValue();
            final String v2 = v.v();
            if (v2 != null) {
                if (list == null) {
                    list = new LinkedList<v>();
                }
                ((LinkedList<v>)list).add(v.a(v2));
                iterator.remove();
            }
        }
        if (list != null) {
            for (final v value : list) {
                final String a = value.a();
                final v v3 = this.g.get(a);
                if (v3 == null) {
                    this.g.put(a, value);
                }
                else {
                    v3.b(value);
                }
            }
        }
    }
}
