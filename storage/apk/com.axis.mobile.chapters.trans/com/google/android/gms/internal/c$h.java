// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

public final class c$h extends ma
{
    public static final mb fx;
    private static final c$h[] fy;
    public int[] fA;
    public int[] fB;
    public int fC;
    public int[] fD;
    public int fE;
    public int fF;
    public int[] fz;
    
    static {
        fx = mb.a(11, c$h.class, 810);
        fy = new c$h[0];
    }
    
    public c$h() {
        this.n();
    }
    
    @Override
    public void a(final lz lz) {
        if (this.fz != null && this.fz.length > 0) {
            for (int i = 0; i < this.fz.length; ++i) {
                lz.p(1, this.fz[i]);
            }
        }
        if (this.fA != null && this.fA.length > 0) {
            for (int j = 0; j < this.fA.length; ++j) {
                lz.p(2, this.fA[j]);
            }
        }
        if (this.fB != null && this.fB.length > 0) {
            for (int k = 0; k < this.fB.length; ++k) {
                lz.p(3, this.fB[k]);
            }
        }
        if (this.fC != 0) {
            lz.p(4, this.fC);
        }
        if (this.fD != null) {
            final int length = this.fD.length;
            int l = 0;
            if (length > 0) {
                while (l < this.fD.length) {
                    lz.p(5, this.fD[l]);
                    ++l;
                }
            }
        }
        if (this.fE != 0) {
            lz.p(6, this.fE);
        }
        if (this.fF != 0) {
            lz.p(7, this.fF);
        }
        super.a(lz);
    }
    
    @Override
    protected int c() {
        int i = 0;
        final int c = super.c();
        int n2;
        if (this.fz != null && this.fz.length > 0) {
            int j = 0;
            int n = 0;
            while (j < this.fz.length) {
                n += lz.eE(this.fz[j]);
                ++j;
            }
            n2 = c + n + 1 * this.fz.length;
        }
        else {
            n2 = c;
        }
        if (this.fA != null && this.fA.length > 0) {
            int k = 0;
            int n3 = 0;
            while (k < this.fA.length) {
                n3 += lz.eE(this.fA[k]);
                ++k;
            }
            n2 = n2 + n3 + 1 * this.fA.length;
        }
        if (this.fB != null && this.fB.length > 0) {
            int l = 0;
            int n4 = 0;
            while (l < this.fB.length) {
                n4 += lz.eE(this.fB[l]);
                ++l;
            }
            n2 = n2 + n4 + 1 * this.fB.length;
        }
        if (this.fC != 0) {
            n2 += lz.r(4, this.fC);
        }
        if (this.fD != null && this.fD.length > 0) {
            int n5 = 0;
            while (i < this.fD.length) {
                n5 += lz.eE(this.fD[i]);
                ++i;
            }
            n2 = n2 + n5 + 1 * this.fD.length;
        }
        if (this.fE != 0) {
            n2 += lz.r(6, this.fE);
        }
        if (this.fF != 0) {
            n2 += lz.r(7, this.fF);
        }
        return n2;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b;
        if (o == this) {
            b = true;
        }
        else {
            final boolean b2 = o instanceof c$h;
            b = false;
            if (b2) {
                final c$h c$h = (c$h)o;
                final boolean equals = mc.equals(this.fz, c$h.fz);
                b = false;
                if (equals) {
                    final boolean equals2 = mc.equals(this.fA, c$h.fA);
                    b = false;
                    if (equals2) {
                        final boolean equals3 = mc.equals(this.fB, c$h.fB);
                        b = false;
                        if (equals3) {
                            final int fc = this.fC;
                            final int fc2 = c$h.fC;
                            b = false;
                            if (fc == fc2) {
                                final boolean equals4 = mc.equals(this.fD, c$h.fD);
                                b = false;
                                if (equals4) {
                                    final int fe = this.fE;
                                    final int fe2 = c$h.fE;
                                    b = false;
                                    if (fe == fe2) {
                                        final int ff = this.fF;
                                        final int ff2 = c$h.fF;
                                        b = false;
                                        if (ff == ff2) {
                                            if (this.amX == null || this.amX.isEmpty()) {
                                                if (c$h.amX != null) {
                                                    final boolean empty = c$h.amX.isEmpty();
                                                    b = false;
                                                    if (!empty) {
                                                        return b;
                                                    }
                                                }
                                                return true;
                                            }
                                            return this.amX.equals(c$h.amX);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        final int n = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + mc.hashCode(this.fz)) + mc.hashCode(this.fA)) + mc.hashCode(this.fB)) + this.fC) + mc.hashCode(this.fD)) + this.fE) + this.fF);
        int hashCode;
        if (this.amX == null || this.amX.isEmpty()) {
            hashCode = 0;
        }
        else {
            hashCode = this.amX.hashCode();
        }
        return hashCode + n;
    }
    
    public c$h i(final ly ly) {
    Label_0121:
        while (true) {
            final int nb = ly.nB();
            switch (nb) {
                default: {
                    if (!this.a(ly, nb)) {
                        break Label_0121;
                    }
                    continue;
                }
                case 0: {
                    break Label_0121;
                }
                case 8: {
                    final int b = mh.b(ly, 8);
                    int i;
                    if (this.fz == null) {
                        i = 0;
                    }
                    else {
                        i = this.fz.length;
                    }
                    final int[] fz = new int[b + i];
                    if (i != 0) {
                        System.arraycopy(this.fz, 0, fz, 0, i);
                    }
                    while (i < -1 + fz.length) {
                        fz[i] = ly.nE();
                        ly.nB();
                        ++i;
                    }
                    fz[i] = ly.nE();
                    this.fz = fz;
                    continue;
                }
                case 10: {
                    final int ex = ly.ex(ly.nI());
                    final int position = ly.getPosition();
                    int n = 0;
                    while (ly.nN() > 0) {
                        ly.nE();
                        ++n;
                    }
                    ly.ez(position);
                    int j;
                    if (this.fz == null) {
                        j = 0;
                    }
                    else {
                        j = this.fz.length;
                    }
                    final int[] fz2 = new int[n + j];
                    if (j != 0) {
                        System.arraycopy(this.fz, 0, fz2, 0, j);
                    }
                    while (j < fz2.length) {
                        fz2[j] = ly.nE();
                        ++j;
                    }
                    this.fz = fz2;
                    ly.ey(ex);
                    continue;
                }
                case 16: {
                    final int b2 = mh.b(ly, 16);
                    int k;
                    if (this.fA == null) {
                        k = 0;
                    }
                    else {
                        k = this.fA.length;
                    }
                    final int[] fa = new int[b2 + k];
                    if (k != 0) {
                        System.arraycopy(this.fA, 0, fa, 0, k);
                    }
                    while (k < -1 + fa.length) {
                        fa[k] = ly.nE();
                        ly.nB();
                        ++k;
                    }
                    fa[k] = ly.nE();
                    this.fA = fa;
                    continue;
                }
                case 18: {
                    final int ex2 = ly.ex(ly.nI());
                    final int position2 = ly.getPosition();
                    int n2 = 0;
                    while (ly.nN() > 0) {
                        ly.nE();
                        ++n2;
                    }
                    ly.ez(position2);
                    int l;
                    if (this.fA == null) {
                        l = 0;
                    }
                    else {
                        l = this.fA.length;
                    }
                    final int[] fa2 = new int[n2 + l];
                    if (l != 0) {
                        System.arraycopy(this.fA, 0, fa2, 0, l);
                    }
                    while (l < fa2.length) {
                        fa2[l] = ly.nE();
                        ++l;
                    }
                    this.fA = fa2;
                    ly.ey(ex2);
                    continue;
                }
                case 24: {
                    final int b3 = mh.b(ly, 24);
                    int length;
                    if (this.fB == null) {
                        length = 0;
                    }
                    else {
                        length = this.fB.length;
                    }
                    final int[] fb = new int[b3 + length];
                    if (length != 0) {
                        System.arraycopy(this.fB, 0, fb, 0, length);
                    }
                    while (length < -1 + fb.length) {
                        fb[length] = ly.nE();
                        ly.nB();
                        ++length;
                    }
                    fb[length] = ly.nE();
                    this.fB = fb;
                    continue;
                }
                case 26: {
                    final int ex3 = ly.ex(ly.nI());
                    final int position3 = ly.getPosition();
                    int n3 = 0;
                    while (ly.nN() > 0) {
                        ly.nE();
                        ++n3;
                    }
                    ly.ez(position3);
                    int length2;
                    if (this.fB == null) {
                        length2 = 0;
                    }
                    else {
                        length2 = this.fB.length;
                    }
                    final int[] fb2 = new int[n3 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.fB, 0, fb2, 0, length2);
                    }
                    while (length2 < fb2.length) {
                        fb2[length2] = ly.nE();
                        ++length2;
                    }
                    this.fB = fb2;
                    ly.ey(ex3);
                    continue;
                }
                case 32: {
                    this.fC = ly.nE();
                    continue;
                }
                case 40: {
                    final int b4 = mh.b(ly, 40);
                    int length3;
                    if (this.fD == null) {
                        length3 = 0;
                    }
                    else {
                        length3 = this.fD.length;
                    }
                    final int[] fd = new int[b4 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.fD, 0, fd, 0, length3);
                    }
                    while (length3 < -1 + fd.length) {
                        fd[length3] = ly.nE();
                        ly.nB();
                        ++length3;
                    }
                    fd[length3] = ly.nE();
                    this.fD = fd;
                    continue;
                }
                case 42: {
                    final int ex4 = ly.ex(ly.nI());
                    final int position4 = ly.getPosition();
                    int n4 = 0;
                    while (ly.nN() > 0) {
                        ly.nE();
                        ++n4;
                    }
                    ly.ez(position4);
                    int length4;
                    if (this.fD == null) {
                        length4 = 0;
                    }
                    else {
                        length4 = this.fD.length;
                    }
                    final int[] fd2 = new int[n4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.fD, 0, fd2, 0, length4);
                    }
                    while (length4 < fd2.length) {
                        fd2[length4] = ly.nE();
                        ++length4;
                    }
                    this.fD = fd2;
                    ly.ey(ex4);
                    continue;
                }
                case 48: {
                    this.fE = ly.nE();
                    continue;
                }
                case 56: {
                    this.fF = ly.nE();
                    continue;
                }
            }
        }
        return this;
    }
    
    public c$h n() {
        this.fz = mh.and;
        this.fA = mh.and;
        this.fB = mh.and;
        this.fC = 0;
        this.fD = mh.and;
        this.fE = 0;
        this.fF = 0;
        this.amX = null;
        this.anb = -1;
        return this;
    }
}
