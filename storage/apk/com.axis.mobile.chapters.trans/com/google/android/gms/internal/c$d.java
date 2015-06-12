// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

public final class c$d extends ma
{
    public d$a[] eR;
    public d$a[] eS;
    public c$c[] eT;
    
    public c$d() {
        this.h();
    }
    
    @Override
    public void a(final lz lz) {
        if (this.eR != null && this.eR.length > 0) {
            for (int i = 0; i < this.eR.length; ++i) {
                final d$a d$a = this.eR[i];
                if (d$a != null) {
                    lz.a(1, d$a);
                }
            }
        }
        if (this.eS != null && this.eS.length > 0) {
            for (int j = 0; j < this.eS.length; ++j) {
                final d$a d$a2 = this.eS[j];
                if (d$a2 != null) {
                    lz.a(2, d$a2);
                }
            }
        }
        if (this.eT != null) {
            final int length = this.eT.length;
            int k = 0;
            if (length > 0) {
                while (k < this.eT.length) {
                    final c$c c$c = this.eT[k];
                    if (c$c != null) {
                        lz.a(3, c$c);
                    }
                    ++k;
                }
            }
        }
        super.a(lz);
    }
    
    @Override
    protected int c() {
        int c = super.c();
        if (this.eR != null && this.eR.length > 0) {
            int n = c;
            for (int i = 0; i < this.eR.length; ++i) {
                final d$a d$a = this.eR[i];
                if (d$a != null) {
                    n += lz.b(1, d$a);
                }
            }
            c = n;
        }
        if (this.eS != null && this.eS.length > 0) {
            int n2 = c;
            for (int j = 0; j < this.eS.length; ++j) {
                final d$a d$a2 = this.eS[j];
                if (d$a2 != null) {
                    n2 += lz.b(2, d$a2);
                }
            }
            c = n2;
        }
        if (this.eT != null) {
            final int length = this.eT.length;
            int k = 0;
            if (length > 0) {
                while (k < this.eT.length) {
                    final c$c c$c = this.eT[k];
                    if (c$c != null) {
                        c += lz.b(3, c$c);
                    }
                    ++k;
                }
            }
        }
        return c;
    }
    
    public c$d e(final ly ly) {
    Label_0057:
        while (true) {
            final int nb = ly.nB();
            switch (nb) {
                default: {
                    if (!this.a(ly, nb)) {
                        break Label_0057;
                    }
                    continue;
                }
                case 0: {
                    break Label_0057;
                }
                case 10: {
                    final int b = mh.b(ly, 10);
                    int i;
                    if (this.eR == null) {
                        i = 0;
                    }
                    else {
                        i = this.eR.length;
                    }
                    final d$a[] er = new d$a[b + i];
                    if (i != 0) {
                        System.arraycopy(this.eR, 0, er, 0, i);
                    }
                    while (i < -1 + er.length) {
                        ly.a(er[i] = new d$a());
                        ly.nB();
                        ++i;
                    }
                    ly.a(er[i] = new d$a());
                    this.eR = er;
                    continue;
                }
                case 18: {
                    final int b2 = mh.b(ly, 18);
                    int j;
                    if (this.eS == null) {
                        j = 0;
                    }
                    else {
                        j = this.eS.length;
                    }
                    final d$a[] es = new d$a[b2 + j];
                    if (j != 0) {
                        System.arraycopy(this.eS, 0, es, 0, j);
                    }
                    while (j < -1 + es.length) {
                        ly.a(es[j] = new d$a());
                        ly.nB();
                        ++j;
                    }
                    ly.a(es[j] = new d$a());
                    this.eS = es;
                    continue;
                }
                case 26: {
                    final int b3 = mh.b(ly, 26);
                    int k;
                    if (this.eT == null) {
                        k = 0;
                    }
                    else {
                        k = this.eT.length;
                    }
                    final c$c[] et = new c$c[b3 + k];
                    if (k != 0) {
                        System.arraycopy(this.eT, 0, et, 0, k);
                    }
                    while (k < -1 + et.length) {
                        ly.a(et[k] = new c$c());
                        ly.nB();
                        ++k;
                    }
                    ly.a(et[k] = new c$c());
                    this.eT = et;
                    continue;
                }
            }
        }
        return this;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b;
        if (o == this) {
            b = true;
        }
        else {
            final boolean b2 = o instanceof c$d;
            b = false;
            if (b2) {
                final c$d c$d = (c$d)o;
                final boolean equals = mc.equals(this.eR, c$d.eR);
                b = false;
                if (equals) {
                    final boolean equals2 = mc.equals(this.eS, c$d.eS);
                    b = false;
                    if (equals2) {
                        final boolean equals3 = mc.equals(this.eT, c$d.eT);
                        b = false;
                        if (equals3) {
                            if (this.amX == null || this.amX.isEmpty()) {
                                if (c$d.amX != null) {
                                    final boolean empty = c$d.amX.isEmpty();
                                    b = false;
                                    if (!empty) {
                                        return b;
                                    }
                                }
                                return true;
                            }
                            return this.amX.equals(c$d.amX);
                        }
                    }
                }
            }
        }
        return b;
    }
    
    public c$d h() {
        this.eR = d$a.r();
        this.eS = d$a.r();
        this.eT = c$c.f();
        this.amX = null;
        this.anb = -1;
        return this;
    }
    
    @Override
    public int hashCode() {
        final int n = 31 * (31 * (31 * (527 + mc.hashCode(this.eR)) + mc.hashCode(this.eS)) + mc.hashCode(this.eT));
        int hashCode;
        if (this.amX == null || this.amX.isEmpty()) {
            hashCode = 0;
        }
        else {
            hashCode = this.amX.hashCode();
        }
        return hashCode + n;
    }
}
