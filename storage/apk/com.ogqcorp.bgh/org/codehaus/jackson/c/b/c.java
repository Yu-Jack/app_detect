// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.util.Iterator;
import org.codehaus.jackson.annotate.JsonTypeInfo$As;
import org.codehaus.jackson.c.z;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import org.codehaus.jackson.c.b.b.g;
import org.codehaus.jackson.c.n;
import org.codehaus.jackson.c.az;
import org.codehaus.jackson.g.m;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.e;
import java.util.List;
import org.codehaus.jackson.c.b.a.o;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import org.codehaus.jackson.c.b.a.p;
import org.codehaus.jackson.c.b.a.i;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.e.b;
import org.codehaus.jackson.c.a.c;
import org.codehaus.jackson.c.ar;
import org.codehaus.jackson.c.b.b.an;

@org.codehaus.jackson.c.a.c
public class c extends an<Object> implements ar
{
    protected final b a;
    protected final a b;
    protected final f c;
    protected final t d;
    protected x<Object> e;
    protected final i f;
    protected boolean g;
    protected final org.codehaus.jackson.c.b.a.a h;
    protected final p[] i;
    protected h j;
    protected final HashSet<String> k;
    protected final boolean l;
    protected final Map<String, org.codehaus.jackson.c.b.i> m;
    protected HashMap<org.codehaus.jackson.c.h.b, x<Object>> n;
    protected o o;
    protected org.codehaus.jackson.c.b.a.f p;
    
    protected c(final c c) {
        this(c, c.l);
    }
    
    protected c(final c c, final boolean l) {
        super(c.b);
        this.a = c.a;
        this.b = c.b;
        this.c = c.c;
        this.d = c.d;
        this.e = c.e;
        this.f = c.f;
        this.h = c.h;
        this.m = c.m;
        this.k = c.k;
        this.l = l;
        this.j = c.j;
        this.i = c.i;
        this.g = c.g;
        this.o = c.o;
    }
    
    protected c(final b a, final a b, final f c, final t d, final org.codehaus.jackson.c.b.a.a h, final Map<String, org.codehaus.jackson.c.b.i> m, final HashSet<String> k, final boolean l, final h j, final List<p> list) {
        super(b);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        if (d.j()) {
            this.f = new i(d);
        }
        else {
            this.f = null;
        }
        this.h = h;
        this.m = m;
        this.k = k;
        this.l = l;
        this.j = j;
        p[] i = null;
        if (list != null) {
            final boolean empty = list.isEmpty();
            i = null;
            if (!empty) {
                i = list.toArray(new p[list.size()]);
            }
        }
        this.i = i;
        this.g = (d.i() || this.f != null || !d.h() || this.o != null);
    }
    
    public c(final e e, final f f, final t t, final org.codehaus.jackson.c.b.a.a a, final Map<String, org.codehaus.jackson.c.b.i> map, final HashSet<String> set, final boolean b, final h h, final List<p> list) {
        this(e.c(), e.a(), f, t, a, map, set, b, h, list);
    }
    
    private final void b(final k k, final org.codehaus.jackson.c.p p4, final Object o, final String o2) {
        if (this.k != null && this.k.contains(o2)) {
            k.d();
            return;
        }
        if (this.j != null) {
            try {
                this.j.a(k, p4, o, o2);
                return;
            }
            catch (Exception ex) {
                this.a(ex, o, o2, p4);
                return;
            }
        }
        this.a(k, p4, o, o2);
    }
    
    protected Object a(final org.codehaus.jackson.c.p p3, final Object o, final m m) {
        m.e();
        final k h = m.h();
        while (h.b() != org.codehaus.jackson.p.c) {
            final String g = h.g();
            h.b();
            this.a(h, p3, o, g);
        }
        return o;
    }
    
    @Override
    public final Object a(final k k, final org.codehaus.jackson.c.p p2) {
        final org.codehaus.jackson.p e = k.e();
        if (e == org.codehaus.jackson.p.b) {
            k.b();
            return this.b(k, p2);
        }
        switch (c$1.a[e.ordinal()]) {
            default: {
                throw p2.b(this.d());
            }
            case 1: {
                return this.d(k, p2);
            }
            case 2: {
                return this.e(k, p2);
            }
            case 3: {
                return this.f(k, p2);
            }
            case 4: {
                return k.z();
            }
            case 5:
            case 6: {
                return this.g(k, p2);
            }
            case 7: {
                return this.h(k, p2);
            }
            case 8:
            case 9: {
                return this.b(k, p2);
            }
        }
    }
    
    @Override
    public Object a(final k k, final org.codehaus.jackson.c.p p3, Object b) {
        if (this.i != null) {
            this.a(p3, b);
        }
        if (this.o != null) {
            b = this.b(k, p3, b);
        }
        else {
            if (this.p != null) {
                return this.c(k, p3, b);
            }
            org.codehaus.jackson.p p4 = k.e();
            if (p4 == org.codehaus.jackson.p.b) {
                p4 = k.b();
            }
        Label_0108_Outer:
            while (p4 == org.codehaus.jackson.p.f) {
                final String g = k.g();
                k.b();
                final org.codehaus.jackson.c.b.i a = this.h.a(g);
                while (true) {
                    Label_0132: {
                        if (a == null) {
                            break Label_0132;
                        }
                        try {
                            a.a(k, p3, b);
                            p4 = k.b();
                            continue Label_0108_Outer;
                        }
                        catch (Exception ex) {
                            this.a(ex, b, g, p3);
                            continue;
                        }
                    }
                    if (this.k != null && this.k.contains(g)) {
                        k.d();
                        continue;
                    }
                    if (this.j != null) {
                        this.j.a(k, p3, b, g);
                        continue;
                    }
                    this.a(k, p3, b, g);
                    continue;
                }
            }
        }
        return b;
    }
    
    protected Object a(final k k, final org.codehaus.jackson.c.p p4, final Object o, final m m) {
        final x<Object> b = this.b(p4, o, m);
        Object o2;
        if (b != null) {
            if (m != null) {
                m.e();
                final k h = m.h();
                h.b();
                o2 = b.a(h, p4, o);
            }
            else {
                o2 = o;
            }
            if (k != null) {
                o2 = b.a(k, p4, o2);
            }
        }
        else {
            if (m != null) {
                o2 = this.a(p4, o, m);
            }
            else {
                o2 = o;
            }
            if (k != null) {
                return this.a(k, p4, o2);
            }
        }
        return o2;
    }
    
    @Override
    public Object a(final k k, final org.codehaus.jackson.c.p p3, final az az) {
        return az.a(k, p3);
    }
    
    public org.codehaus.jackson.c.b.i a(final String s) {
        if (this.m == null) {
            return null;
        }
        return this.m.get(s);
    }
    
    protected org.codehaus.jackson.c.b.i a(final n n, final org.codehaus.jackson.c.b.i i) {
        final String e = i.e();
        if (e == null) {
            return i;
        }
        final x<Object> h = i.h();
        boolean b = false;
        org.codehaus.jackson.c.b.i j;
        if (h instanceof c) {
            j = ((c)h).a(e);
        }
        else if (h instanceof g) {
            final x<Object> d = ((g<Object>)h).d();
            if (!(d instanceof c)) {
                throw new IllegalArgumentException("Can not handle managed/back reference '" + e + "': value deserializer is of type ContainerDeserializerBase, but content type is not handled by a BeanDeserializer " + " (instead it's of type " + d.getClass().getName() + ")");
            }
            j = ((c)d).a(e);
            b = true;
        }
        else {
            if (h instanceof org.codehaus.jackson.c.b.a) {
                throw new IllegalArgumentException("Can not handle managed/back reference for abstract types (property " + this.b.p().getName() + "." + i.c() + ")");
            }
            throw new IllegalArgumentException("Can not handle managed/back reference '" + e + "': type for value deserializer is not BeanDeserializer or ContainerDeserializerBase, but " + ((g<Object>)h).getClass().getName());
        }
        if (j == null) {
            throw new IllegalArgumentException("Can not handle managed/back reference '" + e + "': no back reference property found from type " + i.a());
        }
        final a b2 = this.b;
        final a a = j.a();
        if (!a.p().isAssignableFrom(b2.p())) {
            throw new IllegalArgumentException("Can not handle managed/back reference '" + e + "': back reference type (" + a.p().getName() + ") not compatible with managed type (" + b2.p().getName() + ")");
        }
        return new l(e, i, j, this.a.f(), b);
    }
    
    @Override
    public x<Object> a() {
        if (this.getClass() != c.class) {
            return this;
        }
        return new c(this, true);
    }
    
    public void a(final Throwable t, final Object o, final String s, final org.codehaus.jackson.c.p p4) {
        Throwable cause;
        for (cause = t; cause instanceof InvocationTargetException && cause.getCause() != null; cause = cause.getCause()) {}
        if (cause instanceof Error) {
            throw (Error)cause;
        }
        boolean b;
        if (p4 == null || p4.a(org.codehaus.jackson.c.o.n)) {
            b = true;
        }
        else {
            b = false;
        }
        if (cause instanceof IOException) {
            if (!b || !(cause instanceof z)) {
                throw (IOException)cause;
            }
        }
        else if (!b && cause instanceof RuntimeException) {
            throw (RuntimeException)cause;
        }
        throw z.a(cause, o, s);
    }
    
    protected void a(final Throwable t, final org.codehaus.jackson.c.p p2) {
        Throwable cause;
        for (cause = t; cause instanceof InvocationTargetException && cause.getCause() != null; cause = cause.getCause()) {}
        if (cause instanceof Error) {
            throw (Error)cause;
        }
        final boolean b = p2 == null || p2.a(org.codehaus.jackson.c.o.n);
        if (cause instanceof IOException) {
            throw (IOException)cause;
        }
        if (!b && cause instanceof RuntimeException) {
            throw (RuntimeException)cause;
        }
        throw p2.a(this.b.p(), cause);
    }
    
    @Override
    public void a(final n n, final org.codehaus.jackson.c.t t) {
        final Iterator<org.codehaus.jackson.c.b.i> c = this.h.c();
        org.codehaus.jackson.c.b.a.g g = null;
        o o = null;
        while (c.hasNext()) {
            final org.codehaus.jackson.c.b.i i = c.next();
            org.codehaus.jackson.c.b.i a;
            if (!i.f()) {
                a = i.a(this.a(n, t, i.a(), i));
            }
            else {
                a = i;
            }
            final org.codehaus.jackson.c.b.i a2 = this.a(n, a);
            org.codehaus.jackson.c.b.i b = this.b(n, a2);
            if (b != null) {
                if (o == null) {
                    o = new o();
                }
                o.a(b);
            }
            else {
                b = a2;
            }
            final org.codehaus.jackson.c.b.i c2 = this.c(n, b);
            if (c2 != i) {
                this.h.a(c2);
            }
            if (c2.g()) {
                final az j = c2.i();
                if (j.a() != JsonTypeInfo$As.EXTERNAL_PROPERTY) {
                    continue;
                }
                org.codehaus.jackson.c.b.a.g g2;
                if (g == null) {
                    g2 = new org.codehaus.jackson.c.b.a.g();
                }
                else {
                    g2 = g;
                }
                g2.a(c2, j.b());
                this.h.b(c2);
                g = g2;
            }
        }
        if (this.j != null && !this.j.b()) {
            this.j = this.j.a(this.a(n, t, this.j.c(), this.j.a()));
        }
        if (this.d.i()) {
            final a l = this.d.l();
            if (l == null) {
                throw new IllegalArgumentException("Invalid delegate-creator definition for " + this.b + ": value instantiator (" + this.d.getClass().getName() + ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'");
            }
            this.e = this.a(n, t, l, new org.codehaus.jackson.c.g(null, l, this.a.f(), this.d.o()));
        }
        if (this.f != null) {
            for (final org.codehaus.jackson.c.b.i k : this.f.a()) {
                if (!k.f()) {
                    this.f.a(k, this.a(n, t, k.a(), k));
                }
            }
        }
        if (g != null) {
            this.p = g.a();
            this.g = true;
        }
        if ((this.o = o) != null) {
            this.g = true;
        }
    }
    
    protected void a(final org.codehaus.jackson.c.p p2, final Object o) {
        final p[] i = this.i;
        for (int length = i.length, j = 0; j < length; ++j) {
            i[j].b(p2, o);
        }
    }
    
    @Override
    protected void a(final k k, final org.codehaus.jackson.c.p p4, final Object o, final String o2) {
        if (this.l || (this.k != null && this.k.contains(o2))) {
            k.d();
            return;
        }
        super.a(k, p4, o, o2);
    }
    
    public Object b(final k k, final org.codehaus.jackson.c.p p2) {
        Object o;
        if (this.g) {
            if (this.o != null) {
                o = this.j(k, p2);
            }
            else {
                if (this.p != null) {
                    return this.l(k, p2);
                }
                return this.c(k, p2);
            }
        }
        else {
            o = this.d.m();
            if (this.i != null) {
                this.a(p2, o);
            }
        Label_0110_Outer:
            while (k.e() != org.codehaus.jackson.p.c) {
                final String g = k.g();
                k.b();
                final org.codehaus.jackson.c.b.i a = this.h.a(g);
                while (true) {
                    Label_0133: {
                        if (a == null) {
                            break Label_0133;
                        }
                        try {
                            a.a(k, p2, o);
                            k.b();
                            continue Label_0110_Outer;
                        }
                        catch (Exception ex) {
                            this.a(ex, o, g, p2);
                            continue;
                        }
                    }
                    this.b(k, p2, o, g);
                    continue;
                }
            }
        }
        return o;
    }
    
    protected Object b(final k k, final org.codehaus.jackson.c.p p3, final Object o) {
        org.codehaus.jackson.p p4 = k.e();
        if (p4 == org.codehaus.jackson.p.b) {
            p4 = k.b();
        }
        final m m = new m(k.a());
        m.d();
    Label_0081_Outer:
        while (p4 == org.codehaus.jackson.p.f) {
            final String g = k.g();
            final org.codehaus.jackson.c.b.i a = this.h.a(g);
            k.b();
            while (true) {
                Label_0105: {
                    if (a == null) {
                        break Label_0105;
                    }
                    try {
                        a.a(k, p3, o);
                        p4 = k.b();
                        continue Label_0081_Outer;
                    }
                    catch (Exception ex) {
                        this.a(ex, o, g, p3);
                        continue;
                    }
                }
                if (this.k != null && this.k.contains(g)) {
                    k.d();
                    continue;
                }
                m.a(g);
                m.c(k);
                if (this.j != null) {
                    this.j.a(k, p3, o, g);
                    continue;
                }
                continue;
            }
        }
        m.e();
        this.o.a(k, p3, o, m);
        return o;
    }
    
    protected org.codehaus.jackson.c.b.i b(final n n, final org.codehaus.jackson.c.b.i i) {
        final org.codehaus.jackson.c.e.e b = i.b();
        if (b != null && n.a().b(b) == Boolean.TRUE) {
            final x<Object> h = i.h();
            final x<Object> a = h.a();
            if (a != h && a != null) {
                return i.a(a);
            }
        }
        return null;
    }
    
    protected x<Object> b(final org.codehaus.jackson.c.p p3, final Object o, final m m) {
        x<Object> a;
        synchronized (this) {
            if (this.n == null) {
                a = null;
            }
            else {
                a = this.n.get(new org.codehaus.jackson.c.h.b(o.getClass()));
            }
            // monitorexit(this)
            if (a != null) {
                return a;
            }
        }
        final org.codehaus.jackson.c.t b = p3.b();
        if (b != null) {
            a = b.a(p3.a(), p3.a(o.getClass()), this.c);
            if (a != null) {
                synchronized (this) {
                    if (this.n == null) {
                        this.n = new HashMap<org.codehaus.jackson.c.h.b, x<Object>>();
                    }
                    this.n.put(new org.codehaus.jackson.c.h.b(o.getClass()), a);
                    return a;
                }
            }
        }
        return a;
    }
    
    protected Object c(final k k, final org.codehaus.jackson.c.p p2) {
        if (this.e != null) {
            return this.d.a(this.e.a(k, p2));
        }
        if (this.f != null) {
            return this.i(k, p2);
        }
        if (this.b.c()) {
            throw z.a(k, "Can not instantiate abstract type " + this.b + " (need to add/enable type information?)");
        }
        throw z.a(k, "No suitable constructor found for type " + this.b + ": can not instantiate from JSON object (need to add/enable type information?)");
    }
    
    protected Object c(final k k, final org.codehaus.jackson.c.p p3, final Object o) {
        final org.codehaus.jackson.c.b.a.f a = this.p.a();
    Label_0075_Outer:
        while (k.e() != org.codehaus.jackson.p.c) {
            final String g = k.g();
            k.b();
            final org.codehaus.jackson.c.b.i a2 = this.h.a(g);
            while (true) {
                Label_0098: {
                    if (a2 == null) {
                        break Label_0098;
                    }
                    if (k.e().d()) {
                        a.a(k, p3, g, o);
                    }
                    try {
                        a2.a(k, p3, o);
                        k.b();
                        continue Label_0075_Outer;
                    }
                    catch (Exception ex) {
                        this.a(ex, o, g, p3);
                        continue;
                    }
                }
                if (this.k != null && this.k.contains(g)) {
                    k.d();
                    continue;
                }
                if (a.b(k, p3, g, o)) {
                    continue;
                }
                if (this.j != null) {
                    try {
                        this.j.a(k, p3, o, g);
                        continue;
                    }
                    catch (Exception ex2) {
                        this.a(ex2, o, g, p3);
                        continue;
                    }
                    continue;
                }
                this.a(k, p3, o, g);
                continue;
            }
        }
        return a.a(k, p3, o);
    }
    
    protected org.codehaus.jackson.c.b.i c(final n n, org.codehaus.jackson.c.b.i i) {
        final x<Object> h = i.h();
        if (h instanceof c && !((c)h).e().h()) {
            final Class<?> p = i.a().p();
            final Class<?> b = org.codehaus.jackson.c.i.l.b(p);
            if (b != null && b == this.b.p()) {
                for (final Constructor constructor : p.getConstructors()) {
                    final Class[] parameterTypes = constructor.getParameterTypes();
                    if (parameterTypes.length == 1 && parameterTypes[0] == b) {
                        if (n.a(org.codehaus.jackson.c.o.f)) {
                            org.codehaus.jackson.c.i.l.a(constructor);
                        }
                        i = new org.codehaus.jackson.c.b.k(i, constructor);
                        break;
                    }
                }
            }
        }
        return i;
    }
    
    public final Class<?> d() {
        return this.b.p();
    }
    
    public Object d(final k k, final org.codehaus.jackson.c.p p2) {
        if (this.e != null && !this.d.c()) {
            final Object a = this.d.a(this.e.a(k, p2));
            if (this.i != null) {
                this.a(p2, a);
            }
            return a;
        }
        return this.d.a(k.k());
    }
    
    public Object e(final k k, final org.codehaus.jackson.c.p p2) {
        Object o = null;
        switch (c$1.b[k.q().ordinal()]) {
            default: {
                if (this.e == null) {
                    throw p2.a(this.d(), "no suitable creator method found to deserialize from JSON integer number");
                }
                o = this.d.a(this.e.a(k, p2));
                if (this.i != null) {
                    this.a(p2, o);
                    break;
                }
                break;
            }
            case 1: {
                if (this.e == null || this.d.d()) {
                    return this.d.a(k.t());
                }
                o = this.d.a(this.e.a(k, p2));
                if (this.i != null) {
                    this.a(p2, o);
                    return o;
                }
                break;
            }
            case 2: {
                if (this.e == null || this.d.d()) {
                    return this.d.a(k.u());
                }
                o = this.d.a(this.e.a(k, p2));
                if (this.i != null) {
                    this.a(p2, o);
                    return o;
                }
                break;
            }
        }
        return o;
    }
    
    public t e() {
        return this.d;
    }
    
    public Object f(final k k, final org.codehaus.jackson.c.p p2) {
        Object o = null;
        switch (c$1.b[k.q().ordinal()]) {
            default: {
                if (this.e != null) {
                    o = this.d.a(this.e.a(k, p2));
                    break;
                }
                throw p2.a(this.d(), "no suitable creator method found to deserialize from JSON floating-point number");
            }
            case 3:
            case 4: {
                if (this.e == null || this.d.f()) {
                    return this.d.a(k.x());
                }
                o = this.d.a(this.e.a(k, p2));
                if (this.i != null) {
                    this.a(p2, o);
                    return o;
                }
                break;
            }
        }
        return o;
    }
    
    public Object g(final k k, final org.codehaus.jackson.c.p p2) {
        if (this.e != null && !this.d.g()) {
            final Object a = this.d.a(this.e.a(k, p2));
            if (this.i != null) {
                this.a(p2, a);
            }
            return a;
        }
        return this.d.a(k.e() == org.codehaus.jackson.p.k);
    }
    
    public Object h(final k k, final org.codehaus.jackson.c.p p2) {
        if (this.e != null) {
            try {
                final Object a = this.d.a(this.e.a(k, p2));
                if (this.i != null) {
                    this.a(p2, a);
                }
                return a;
            }
            catch (Exception ex) {
                this.a(ex, p2);
            }
        }
        throw p2.b(this.d());
    }
    
    protected final Object i(final k k, final org.codehaus.jackson.c.p p2) {
        final i f = this.f;
        final org.codehaus.jackson.c.b.a.n a = f.a(k, p2);
        org.codehaus.jackson.p p3 = k.e();
        m m = null;
        while (p3 == org.codehaus.jackson.p.f) {
            final String g = k.g();
            k.b();
            final org.codehaus.jackson.c.b.i a2 = f.a(g);
            Label_0135: {
                if (a2 != null) {
                    if (a.a(a2.j(), a2.a(k, p2))) {
                        k.b();
                        Object a3 = null;
                        Label_0144: {
                            try {
                                a3 = f.a(a);
                                if (a3.getClass() != this.b.p()) {
                                    return this.a(k, p2, a3, m);
                                }
                                break Label_0144;
                            }
                            catch (Exception ex) {
                                this.a(ex, this.b.p(), g, p2);
                            }
                            break Label_0135;
                        }
                        Object a4;
                        if (m != null) {
                            a4 = this.a(p2, a3, m);
                        }
                        else {
                            a4 = a3;
                        }
                        return this.a(k, p2, a4);
                    }
                }
                else {
                    final org.codehaus.jackson.c.b.i a5 = this.h.a(g);
                    if (a5 != null) {
                        a.a(a5, a5.a(k, p2));
                    }
                    else if (this.k != null && this.k.contains(g)) {
                        k.d();
                    }
                    else if (this.j != null) {
                        a.a(this.j, g, this.j.a(k, p2));
                    }
                    else {
                        if (m == null) {
                            m = new m(k.a());
                        }
                        m.a(g);
                        m.c(k);
                    }
                }
            }
            p3 = k.b();
        }
        Object a6;
        try {
            a6 = f.a(a);
            if (m == null) {
                return a6;
            }
            if (a6.getClass() != this.b.p()) {
                return this.a(null, p2, a6, m);
            }
        }
        catch (Exception ex2) {
            this.a(ex2, p2);
            return null;
        }
        return this.a(p2, a6, m);
    }
    
    protected Object j(final k k, final org.codehaus.jackson.c.p p2) {
        if (this.e != null) {
            return this.d.a(this.e.a(k, p2));
        }
        if (this.f != null) {
            return this.k(k, p2);
        }
        final m m = new m(k.a());
        m.d();
        final Object i = this.d.m();
        if (this.i != null) {
            this.a(p2, i);
        }
    Label_0123_Outer:
        while (k.e() != org.codehaus.jackson.p.c) {
            final String g = k.g();
            k.b();
            final org.codehaus.jackson.c.b.i a = this.h.a(g);
            while (true) {
                Label_0147: {
                    if (a == null) {
                        break Label_0147;
                    }
                    try {
                        a.a(k, p2, i);
                        k.b();
                        continue Label_0123_Outer;
                    }
                    catch (Exception ex) {
                        this.a(ex, i, g, p2);
                        continue;
                    }
                }
                if (this.k != null && this.k.contains(g)) {
                    k.d();
                    continue;
                }
                m.a(g);
                m.c(k);
                if (this.j != null) {
                    try {
                        this.j.a(k, p2, i, g);
                        continue;
                    }
                    catch (Exception ex2) {
                        this.a(ex2, i, g, p2);
                        continue;
                    }
                    continue;
                }
                continue;
            }
        }
        m.e();
        this.o.a(k, p2, i, m);
        return i;
    }
    
    protected Object k(final k k, final org.codehaus.jackson.c.p p2) {
        final i f = this.f;
        final org.codehaus.jackson.c.b.a.n a = f.a(k, p2);
        final m m = new m(k.a());
        m.d();
        for (org.codehaus.jackson.p p3 = k.e(); p3 == org.codehaus.jackson.p.f; p3 = k.b()) {
            final String g = k.g();
            k.b();
            final org.codehaus.jackson.c.b.i a2 = f.a(g);
            if (a2 != null) {
                if (a.a(a2.j(), a2.a(k, p2))) {
                    org.codehaus.jackson.p p4 = k.b();
                    Object a3 = null;
                    Label_0162: {
                        try {
                            a3 = f.a(a);
                            while (p4 == org.codehaus.jackson.p.f) {
                                k.b();
                                m.c(k);
                                p4 = k.b();
                            }
                            break Label_0162;
                        }
                        catch (Exception ex) {
                            this.a(ex, this.b.p(), g, p2);
                        }
                        continue;
                    }
                    m.e();
                    if (a3.getClass() != this.b.p()) {
                        throw p2.b("Can not create polymorphic instances with unwrapped values");
                    }
                    return this.o.a(k, p2, a3, m);
                }
            }
            else {
                final org.codehaus.jackson.c.b.i a4 = this.h.a(g);
                if (a4 != null) {
                    a.a(a4, a4.a(k, p2));
                }
                else if (this.k != null && this.k.contains(g)) {
                    k.d();
                }
                else {
                    m.a(g);
                    m.c(k);
                    if (this.j != null) {
                        a.a(this.j, g, this.j.a(k, p2));
                    }
                }
            }
        }
        try {
            return this.o.a(k, p2, f.a(a), m);
        }
        catch (Exception ex2) {
            this.a(ex2, p2);
            return null;
        }
    }
    
    protected Object l(final k k, final org.codehaus.jackson.c.p p2) {
        if (this.f != null) {
            return this.m(k, p2);
        }
        return this.c(k, p2, this.d.m());
    }
    
    protected Object m(final k k, final org.codehaus.jackson.c.p p2) {
        final org.codehaus.jackson.c.b.a.f a = this.p.a();
        final i f = this.f;
        final org.codehaus.jackson.c.b.a.n a2 = f.a(k, p2);
        final m m = new m(k.a());
        m.d();
        for (org.codehaus.jackson.p p3 = k.e(); p3 == org.codehaus.jackson.p.f; p3 = k.b()) {
            final String g = k.g();
            k.b();
            final org.codehaus.jackson.c.b.i a3 = f.a(g);
            if (a3 != null) {
                if (a2.a(a3.j(), a3.a(k, p2))) {
                    org.codehaus.jackson.p p4 = k.b();
                    Object a4 = null;
                    Label_0174: {
                        try {
                            a4 = f.a(a2);
                            while (p4 == org.codehaus.jackson.p.f) {
                                k.b();
                                m.c(k);
                                p4 = k.b();
                            }
                            break Label_0174;
                        }
                        catch (Exception ex) {
                            this.a(ex, this.b.p(), g, p2);
                        }
                        continue;
                    }
                    if (a4.getClass() != this.b.p()) {
                        throw p2.b("Can not create polymorphic instances with unwrapped values");
                    }
                    return a.a(k, p2, a4);
                }
            }
            else {
                final org.codehaus.jackson.c.b.i a5 = this.h.a(g);
                if (a5 != null) {
                    a2.a(a5, a5.a(k, p2));
                }
                else if (!a.b(k, p2, g, null)) {
                    if (this.k != null && this.k.contains(g)) {
                        k.d();
                    }
                    else if (this.j != null) {
                        a2.a(this.j, g, this.j.a(k, p2));
                    }
                }
            }
        }
        try {
            return a.a(k, p2, f.a(a2));
        }
        catch (Exception ex2) {
            this.a(ex2, p2);
            return null;
        }
    }
}
