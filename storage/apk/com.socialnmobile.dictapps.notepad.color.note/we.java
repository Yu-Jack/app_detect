import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.sync.errors.AuthRequired;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;
import java.util.HashSet;
import java.util.concurrent.Callable;

// 
// Decompiled by Procyon v0.5.29
// 

public final class we implements Callable
{
    final rt a;
    final xm b;
    final wf c;
    long d;
    final HashSet e;
    final xj f;
    final wg g;
    boolean h;
    xi i;
    final UUID j;
    final xj k;
    public int l;
    public int m;
    public int n;
    public int o;
    
    public we(final rt a, final xm b, final int i, final wf c) {
        this.d = -1L;
        this.e = new HashSet();
        this.f = new xj();
        this.g = new wg(this);
        this.h = false;
        this.i = new xi();
        this.j = UUID.randomUUID();
        this.k = new xj();
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.a = a;
        this.b = b;
        this.k.a("MAX_CHECKINS_PER_REQUEST", i);
        this.c = c;
        final xj f = this.f;
        final long n = lcmp(a.n(), 0L);
        boolean b2 = false;
        if (n == 0) {
            b2 = true;
        }
        f.a("firstcheckout", b2);
    }
    
    private static xx a(final Object o) {
        try {
            return (xx)xy.a.d(xf.c(o));
        }
        catch (xh xh) {
            throw new vx(xh);
        }
        catch (xg xg) {
            throw new vx(xg);
        }
        catch (ux ux) {
            throw new vx(ux);
        }
    }
    
    private xx a(final xx xx) {
        final long n = this.a.n();
        final tq a = this.a.a(this.k, this.e);
        while (true) {
            int n2 = 0;
            Label_0032: {
                if (xx == null) {
                    n2 = 1;
                    break Label_0032;
                }
                Label_0569: {
                    uc u;
                    xj a2 = null;
                    xj xj = null;
                    sl[] array;
                    int length;
                    int n3;
                    sl sl;
                    HashMap a3;
                    xj xj2;
                    vp c;
                    Label_0143_Outer:Label_0187_Outer:
                    while (true) {
                        while (true) {
                            while (true) {
                                try {
                                    if (a.c.getCount() > 0) {
                                        n2 = 1;
                                        break Label_0032;
                                    }
                                    if (this.i.size() > 0) {
                                        n2 = 1;
                                        break Label_0032;
                                    }
                                    if (n < xx.b) {
                                        n2 = 1;
                                        break Label_0032;
                                    }
                                    break Label_0569;
                                    while (true) {
                                        throw new IllegalStateException("CommitStage.c is null");
                                        u = this.a.u();
                                        a2 = this.a.a();
                                        a2.a("authentication", u.d, new tk());
                                        xj = new xj();
                                        array = new sl[] { sl.a, sl.c, sl.b };
                                        length = array.length;
                                        n3 = 0;
                                        continue Label_0143_Outer;
                                    }
                                }
                                // iftrue(Label_0344:, a.c != null)
                                // iftrue(Label_0222:, u.e != null)
                                // iftrue(Label_0228:, n3 < length)
                                finally {
                                    a.a();
                                }
                                Label_0222: {
                                    a2 = null;
                                }
                                continue Label_0187_Outer;
                            }
                            Label_0228: {
                                sl = array[n3];
                            }
                            a3 = this.a.a(sl);
                            xj2 = new xj();
                            for (final String key : a3.keySet()) {
                                c = ((sr)a3.get(key)).c;
                                if (c != null) {
                                    xj2.a(key, c.a);
                                }
                            }
                            xj.a(sl.e, xj2);
                            ++n3;
                            continue;
                        }
                    }
                    Label_0344: {
                        if (a.d == null) {
                            throw new IllegalStateException("CommitStage.nek is null");
                        }
                    }
                    final xi a4 = a.a(a.c, a.d);
                    final xi i = this.i;
                    this.i = new xi();
                    final xx a5 = a(this.b.a(new xw(this.j, this.f, (long)this.a.m.c(), a2, this.a.o(), this.a.p(), xj, n, a4, i)));
                    a.a(a5, this.e);
                    this.l += a.i;
                    this.n += a.k;
                    this.o += a.j;
                    if (this.o > 0) {
                        final xj xj3 = new xj();
                        xj3.a("badNotes", this.o);
                        adl.a.a(xj3);
                    }
                    a.a();
                    return a5;
                }
                n2 = 0;
            }
            if (n2 == 0) {
                a.a();
                return null;
            }
            continue;
        }
    }
    
    @Override
    public final Object call() {
        if (this.a.s() == null) {
            this.a.q.a(null);
            throw new AuthRequired("AuthToken is required");
        }
        xx xx = null;
        while (true) {
            final xx a = this.a(xx);
            if (a != null) {
                final xi d = a.d;
                if (d != null) {
                    this.m += this.a.d().a(a.a, d);
                }
                this.a.a(a);
            }
            if (a == null) {
                break;
            }
            final xi h = a.h;
            final wg g = this.g;
            final xi i = this.i;
            if (h != null) {
                for (final xj xj : h) {
                    final String h2 = xj.h("method");
                    final xj j = xj.j("params");
                    final xj xj2 = new xj();
                    xj2.a("method", h2);
                    try {
                        final Object a2 = g.a(h2, j);
                        if (a2 == null) {
                            continue;
                        }
                        xj2.a("result", a2);
                        i.add(xj2);
                    }
                    catch (Exception ex) {
                        xj2.a("error", adr.a.c(ex));
                        i.add(xj2);
                    }
                }
            }
            if (this.h) {
                break;
            }
            if (a.f.c == 2) {
                throw new uf();
            }
            final long b = a.b;
            final long a3 = a.a;
            if (this.i.size() == 0 && xx != null && a3 == xx.a) {
                break;
            }
            if (this.d == -1L) {
                this.d = a3;
            }
            final int k = (int)(a3 - this.d);
            final int l = (int)(b - this.d);
            new StringBuilder("Sync.onProgress: ").append(k).append('/').append(l).toString();
            ColorNote.a();
            if (this.c != null) {
                this.c.a(k, l);
            }
            xx = a;
        }
        return xx;
    }
}
