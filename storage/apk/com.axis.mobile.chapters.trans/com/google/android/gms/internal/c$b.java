// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

public final class c$b extends ma
{
    private static volatile c$b[] eG;
    public int[] eH;
    public int eI;
    public boolean eJ;
    public boolean eK;
    public int name;
    
    public c$b() {
        this.e();
    }
    
    public static c$b[] d() {
        Label_0027: {
            if (c$b.eG != null) {
                break Label_0027;
            }
            synchronized (mc.ana) {
                if (c$b.eG == null) {
                    c$b.eG = new c$b[0];
                }
                return c$b.eG;
            }
        }
    }
    
    @Override
    public void a(final lz lz) {
        if (this.eK) {
            lz.a(1, this.eK);
        }
        lz.p(2, this.eI);
        if (this.eH != null && this.eH.length > 0) {
            for (int i = 0; i < this.eH.length; ++i) {
                lz.p(3, this.eH[i]);
            }
        }
        if (this.name != 0) {
            lz.p(4, this.name);
        }
        if (this.eJ) {
            lz.a(6, this.eJ);
        }
        super.a(lz);
    }
    
    @Override
    protected int c() {
        int n = 0;
        int c = super.c();
        if (this.eK) {
            c += lz.b(1, this.eK);
        }
        final int n2 = c + lz.r(2, this.eI);
        int n3;
        if (this.eH != null && this.eH.length > 0) {
            for (int i = 0; i < this.eH.length; ++i) {
                n += lz.eE(this.eH[i]);
            }
            n3 = n2 + n + 1 * this.eH.length;
        }
        else {
            n3 = n2;
        }
        if (this.name != 0) {
            n3 += lz.r(4, this.name);
        }
        if (this.eJ) {
            n3 += lz.b(6, this.eJ);
        }
        return n3;
    }
    
    public c$b c(final ly ly) {
    Label_0081:
        while (true) {
            final int nb = ly.nB();
            switch (nb) {
                default: {
                    if (!this.a(ly, nb)) {
                        break Label_0081;
                    }
                    continue;
                }
                case 0: {
                    break Label_0081;
                }
                case 8: {
                    this.eK = ly.nF();
                    continue;
                }
                case 16: {
                    this.eI = ly.nE();
                    continue;
                }
                case 24: {
                    final int b = mh.b(ly, 24);
                    int i;
                    if (this.eH == null) {
                        i = 0;
                    }
                    else {
                        i = this.eH.length;
                    }
                    final int[] eh = new int[b + i];
                    if (i != 0) {
                        System.arraycopy(this.eH, 0, eh, 0, i);
                    }
                    while (i < -1 + eh.length) {
                        eh[i] = ly.nE();
                        ly.nB();
                        ++i;
                    }
                    eh[i] = ly.nE();
                    this.eH = eh;
                    continue;
                }
                case 26: {
                    final int ex = ly.ex(ly.nI());
                    final int position = ly.getPosition();
                    int n = 0;
                    while (ly.nN() > 0) {
                        ly.nE();
                        ++n;
                    }
                    ly.ez(position);
                    int j;
                    if (this.eH == null) {
                        j = 0;
                    }
                    else {
                        j = this.eH.length;
                    }
                    final int[] eh2 = new int[n + j];
                    if (j != 0) {
                        System.arraycopy(this.eH, 0, eh2, 0, j);
                    }
                    while (j < eh2.length) {
                        eh2[j] = ly.nE();
                        ++j;
                    }
                    this.eH = eh2;
                    ly.ey(ex);
                    continue;
                }
                case 32: {
                    this.name = ly.nE();
                    continue;
                }
                case 48: {
                    this.eJ = ly.nF();
                    continue;
                }
            }
        }
        return this;
    }
    
    public c$b e() {
        this.eH = mh.and;
        this.eI = 0;
        this.name = 0;
        this.eJ = false;
        this.eK = false;
        this.amX = null;
        this.anb = -1;
        return this;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b;
        if (o == this) {
            b = true;
        }
        else {
            final boolean b2 = o instanceof c$b;
            b = false;
            if (b2) {
                final c$b c$b = (c$b)o;
                final boolean equals = mc.equals(this.eH, c$b.eH);
                b = false;
                if (equals) {
                    final int ei = this.eI;
                    final int ei2 = c$b.eI;
                    b = false;
                    if (ei == ei2) {
                        final int name = this.name;
                        final int name2 = c$b.name;
                        b = false;
                        if (name == name2) {
                            final boolean ej = this.eJ;
                            final boolean ej2 = c$b.eJ;
                            b = false;
                            if (ej == ej2) {
                                final boolean ek = this.eK;
                                final boolean ek2 = c$b.eK;
                                b = false;
                                if (ek == ek2) {
                                    if (this.amX == null || this.amX.isEmpty()) {
                                        if (c$b.amX != null) {
                                            final boolean empty = c$b.amX.isEmpty();
                                            b = false;
                                            if (!empty) {
                                                return b;
                                            }
                                        }
                                        return true;
                                    }
                                    return this.amX.equals(c$b.amX);
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
        int n = 1231;
        final int n2 = 31 * (31 * (31 * (527 + mc.hashCode(this.eH)) + this.eI) + this.name);
        int n3;
        if (this.eJ) {
            n3 = n;
        }
        else {
            n3 = 1237;
        }
        final int n4 = 31 * (n3 + n2);
        if (!this.eK) {
            n = 1237;
        }
        final int n5 = 31 * (n4 + n);
        int hashCode;
        if (this.amX == null || this.amX.isEmpty()) {
            hashCode = 0;
        }
        else {
            hashCode = this.amX.hashCode();
        }
        return hashCode + n5;
    }
}
