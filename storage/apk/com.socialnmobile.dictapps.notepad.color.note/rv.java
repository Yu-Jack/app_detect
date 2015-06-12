import java.util.UUID;
import java.util.Iterator;
import java.util.Set;
import java.util.HashMap;

// 
// Decompiled by Procyon v0.5.29
// 

public class rv extends acl implements se
{
    public final acf d;
    public final acf e;
    public final acf f;
    public final acf g;
    public final acf h;
    public final acf i;
    public final acf j;
    public final acf k;
    public final acf l;
    public final acf m;
    public final acf n;
    public final acf o;
    public final acf p;
    public final acf q;
    public final acf r;
    public final acf s;
    public final acf t;
    public final acf u;
    public final acf v;
    public final acf w;
    public final ry x;
    
    public rv() {
        this.d = this.a(rv.y);
        this.e = this.a(rv.C);
        this.f = this.a(rv.z);
        this.g = this.a(rv.A);
        this.h = this.a(rv.B);
        this.i = this.a(rv.D);
        this.j = this.a(rv.E);
        this.k = this.a(rv.F);
        this.l = this.a(rv.G);
        this.m = this.d;
        this.n = new acj(this.f, adf.a);
        this.o = new acj(this.g, tw.e);
        this.p = this.h;
        this.q = new ach(this.e, td.a);
        this.r = this.i;
        this.s = this.j;
        this.t = new acj(this.l, ade.a);
        this.u = new acj(this.k, ade.a);
        this.v = new acj(this.t, si.a);
        this.w = new acj(this.u, ud.a);
        this.x = new ry(this);
    }
    
    private void a() {
        ux.a(this.m.c());
        final sh sh = (sh)this.v.c();
        ux.a(sh);
        ux.a(sh.c);
        ux.a(sh.d);
        ux.a(sh.e);
        ux.a(sh.g);
        final uc uc = (uc)this.w.c();
        ux.a(uc);
        ux.a(uc.d);
        ux.a(uc.a);
        ux.a(uc.b);
    }
    
    public final HashMap a(final sl sl) {
        return this.x.a().a.g.a(sl);
    }
    
    final void b(final xt xt, final xu xu) {
        sh a;
        sq g;
        Iterator iterator;
        String s;
        tj d;
        String b;
        sh a2;
        sq g2;
        Iterator iterator2;
        Iterator iterator3;
        Label_0289_Outer:Label_0294_Outer:
        while (true) {
            while (true) {
            Label_0347:
                while (true) {
                Label_0341:
                    while (true) {
                        Label_0335: {
                            try {
                                ux.a(xu.a);
                                ux.a(xu.a.b);
                                ux.a(xu.a.g);
                                ux.a(xu.b);
                                ux.a(xu.b.e);
                                ux.a(xu.b.d);
                                ux.a(xu.b.d.a);
                                ux.a(xu.b.d.b);
                                xu.b.d.c = xt.d;
                                this.m.a(xu.a.a);
                                this.q.a(xu.b.e);
                                this.v.a(xu.a);
                                this.w.a(xu.b);
                                this.o.a(xu.a.e);
                                a = xu.a;
                                if (a.g == null) {
                                    break Label_0335;
                                }
                                g = a.g;
                                if (g.d != null) {
                                    iterator = sq.a(g.d.keySet()).iterator();
                                    if (iterator.hasNext()) {
                                        s = iterator.next();
                                        this.s.a(s);
                                        d = xu.b.d;
                                        if (d.a != sl.a && d.a != sl.c) {
                                            break Label_0341;
                                        }
                                        b = d.b;
                                        if (b != null) {
                                            this.r.a(b);
                                            return;
                                        }
                                        break Label_0347;
                                    }
                                }
                            }
                            catch (ux ux) {
                                try {
                                    throw new vs(ux, this);
                                }
                                catch (Exception ex) {
                                    adl.a.a(ux);
                                }
                            }
                            s = null;
                            continue Label_0289_Outer;
                        }
                        s = null;
                        continue Label_0289_Outer;
                    }
                    b = null;
                    continue Label_0294_Outer;
                }
                a2 = xu.a;
                if (a2.g != null) {
                    g2 = a2.g;
                    if (g2.b != null) {
                        iterator2 = sq.a(g2.b.keySet()).iterator();
                        if (iterator2.hasNext()) {
                            b = iterator2.next();
                            continue;
                        }
                    }
                    if (g2.a != null) {
                        iterator3 = sq.a(g2.a.keySet()).iterator();
                        if (iterator3.hasNext()) {
                            b = iterator3.next();
                            continue;
                        }
                    }
                    b = null;
                    continue;
                }
                b = null;
                continue;
            }
        }
    }
    
    public final void h() {
        if (this.m.c() == null) {
            throw new vs("Account.id is null", this);
        }
        if (this.q.c() == null) {
            throw new vs("Account.authToken is null", this);
        }
    }
    
    public final String i() {
        final tj d = this.u().d;
        String s;
        if (d.a == sl.a) {
            s = d.b;
        }
        else {
            final sl a = d.a;
            final String b = d.b;
            sr sr;
            if (b != null) {
                sr = this.a(a).get(b);
            }
            else {
                sr = null;
            }
            if (sr == null) {
                return d.b;
            }
            final vp c = sr.c;
            if (c == null) {
                return d.b;
            }
            s = c.b;
            if (s == null) {
                return d.b;
            }
        }
        return s;
    }
    
    public final sl j() {
        return this.u().d.a;
    }
    
    public final void k() {
        try {
            this.a();
        }
        catch (ux ux) {
            try {
                throw new vs("verification for db failed", ux, this);
            }
            catch (Exception ex) {
                adl.a.a(ex);
            }
        }
    }
    
    public final void l() {
        try {
            this.a();
            ux.a(((sh)this.v.c()).b);
            ux.a(((uc)this.w.c()).e);
        }
        catch (ux ux) {
            try {
                throw new vs("verification for db failed", ux, this);
            }
            catch (Exception ex) {
                adl.a.a(ex);
            }
        }
    }
    
    public final long m() {
        final Long n = (Long)this.m.c();
        if (n == null) {
            throw new vs("id is null", this);
        }
        return n;
    }
    
    public final long n() {
        final Long n = (Long)this.p.c();
        if (n == null) {
            return 0L;
        }
        return n;
    }
    
    public final UUID o() {
        return (UUID)this.n.c();
    }
    
    public final tw p() {
        return (tw)this.o.c();
    }
    
    public final td q() {
        return (td)this.q.c();
    }
    
    public final boolean r() {
        final td q = this.q();
        return q != null && !q.a();
    }
    
    public final vc s() {
        return this.x.a().a.b;
    }
    
    public final boolean t() {
        return this.x.a().a.h;
    }
    
    public final uc u() {
        return this.x.a().b;
    }
}
