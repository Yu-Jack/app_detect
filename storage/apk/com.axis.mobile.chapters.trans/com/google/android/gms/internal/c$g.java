// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

public final class c$g extends ma
{
    private static volatile c$g[] fm;
    public int[] fn;
    public int[] fo;
    public int[] fp;
    public int[] fq;
    public int[] fr;
    public int[] fs;
    public int[] ft;
    public int[] fu;
    public int[] fv;
    public int[] fw;
    
    public c$g() {
        this.m();
    }
    
    public static c$g[] l() {
        Label_0027: {
            if (c$g.fm != null) {
                break Label_0027;
            }
            synchronized (mc.ana) {
                if (c$g.fm == null) {
                    c$g.fm = new c$g[0];
                }
                return c$g.fm;
            }
        }
    }
    
    @Override
    public void a(final lz lz) {
        if (this.fn != null && this.fn.length > 0) {
            for (int i = 0; i < this.fn.length; ++i) {
                lz.p(1, this.fn[i]);
            }
        }
        if (this.fo != null && this.fo.length > 0) {
            for (int j = 0; j < this.fo.length; ++j) {
                lz.p(2, this.fo[j]);
            }
        }
        if (this.fp != null && this.fp.length > 0) {
            for (int k = 0; k < this.fp.length; ++k) {
                lz.p(3, this.fp[k]);
            }
        }
        if (this.fq != null && this.fq.length > 0) {
            for (int l = 0; l < this.fq.length; ++l) {
                lz.p(4, this.fq[l]);
            }
        }
        if (this.fr != null && this.fr.length > 0) {
            for (int n = 0; n < this.fr.length; ++n) {
                lz.p(5, this.fr[n]);
            }
        }
        if (this.fs != null && this.fs.length > 0) {
            for (int n2 = 0; n2 < this.fs.length; ++n2) {
                lz.p(6, this.fs[n2]);
            }
        }
        if (this.ft != null && this.ft.length > 0) {
            for (int n3 = 0; n3 < this.ft.length; ++n3) {
                lz.p(7, this.ft[n3]);
            }
        }
        if (this.fu != null && this.fu.length > 0) {
            for (int n4 = 0; n4 < this.fu.length; ++n4) {
                lz.p(8, this.fu[n4]);
            }
        }
        if (this.fv != null && this.fv.length > 0) {
            for (int n5 = 0; n5 < this.fv.length; ++n5) {
                lz.p(9, this.fv[n5]);
            }
        }
        if (this.fw != null) {
            final int length = this.fw.length;
            int n6 = 0;
            if (length > 0) {
                while (n6 < this.fw.length) {
                    lz.p(10, this.fw[n6]);
                    ++n6;
                }
            }
        }
        super.a(lz);
    }
    
    @Override
    protected int c() {
        int i = 0;
        final int c = super.c();
        int n2;
        if (this.fn != null && this.fn.length > 0) {
            int j = 0;
            int n = 0;
            while (j < this.fn.length) {
                n += lz.eE(this.fn[j]);
                ++j;
            }
            n2 = c + n + 1 * this.fn.length;
        }
        else {
            n2 = c;
        }
        if (this.fo != null && this.fo.length > 0) {
            int k = 0;
            int n3 = 0;
            while (k < this.fo.length) {
                n3 += lz.eE(this.fo[k]);
                ++k;
            }
            n2 = n2 + n3 + 1 * this.fo.length;
        }
        if (this.fp != null && this.fp.length > 0) {
            int l = 0;
            int n4 = 0;
            while (l < this.fp.length) {
                n4 += lz.eE(this.fp[l]);
                ++l;
            }
            n2 = n2 + n4 + 1 * this.fp.length;
        }
        if (this.fq != null && this.fq.length > 0) {
            int n5 = 0;
            int n6 = 0;
            while (n5 < this.fq.length) {
                n6 += lz.eE(this.fq[n5]);
                ++n5;
            }
            n2 = n2 + n6 + 1 * this.fq.length;
        }
        if (this.fr != null && this.fr.length > 0) {
            int n7 = 0;
            int n8 = 0;
            while (n7 < this.fr.length) {
                n8 += lz.eE(this.fr[n7]);
                ++n7;
            }
            n2 = n2 + n8 + 1 * this.fr.length;
        }
        if (this.fs != null && this.fs.length > 0) {
            int n9 = 0;
            int n10 = 0;
            while (n9 < this.fs.length) {
                n10 += lz.eE(this.fs[n9]);
                ++n9;
            }
            n2 = n2 + n10 + 1 * this.fs.length;
        }
        if (this.ft != null && this.ft.length > 0) {
            int n11 = 0;
            int n12 = 0;
            while (n11 < this.ft.length) {
                n12 += lz.eE(this.ft[n11]);
                ++n11;
            }
            n2 = n2 + n12 + 1 * this.ft.length;
        }
        if (this.fu != null && this.fu.length > 0) {
            int n13 = 0;
            int n14 = 0;
            while (n13 < this.fu.length) {
                n14 += lz.eE(this.fu[n13]);
                ++n13;
            }
            n2 = n2 + n14 + 1 * this.fu.length;
        }
        if (this.fv != null && this.fv.length > 0) {
            int n15 = 0;
            int n16 = 0;
            while (n15 < this.fv.length) {
                n16 += lz.eE(this.fv[n15]);
                ++n15;
            }
            n2 = n2 + n16 + 1 * this.fv.length;
        }
        if (this.fw != null && this.fw.length > 0) {
            int n17 = 0;
            while (i < this.fw.length) {
                n17 += lz.eE(this.fw[i]);
                ++i;
            }
            n2 = n2 + n17 + 1 * this.fw.length;
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
            final boolean b2 = o instanceof c$g;
            b = false;
            if (b2) {
                final c$g c$g = (c$g)o;
                final boolean equals = mc.equals(this.fn, c$g.fn);
                b = false;
                if (equals) {
                    final boolean equals2 = mc.equals(this.fo, c$g.fo);
                    b = false;
                    if (equals2) {
                        final boolean equals3 = mc.equals(this.fp, c$g.fp);
                        b = false;
                        if (equals3) {
                            final boolean equals4 = mc.equals(this.fq, c$g.fq);
                            b = false;
                            if (equals4) {
                                final boolean equals5 = mc.equals(this.fr, c$g.fr);
                                b = false;
                                if (equals5) {
                                    final boolean equals6 = mc.equals(this.fs, c$g.fs);
                                    b = false;
                                    if (equals6) {
                                        final boolean equals7 = mc.equals(this.ft, c$g.ft);
                                        b = false;
                                        if (equals7) {
                                            final boolean equals8 = mc.equals(this.fu, c$g.fu);
                                            b = false;
                                            if (equals8) {
                                                final boolean equals9 = mc.equals(this.fv, c$g.fv);
                                                b = false;
                                                if (equals9) {
                                                    final boolean equals10 = mc.equals(this.fw, c$g.fw);
                                                    b = false;
                                                    if (equals10) {
                                                        if (this.amX == null || this.amX.isEmpty()) {
                                                            if (c$g.amX != null) {
                                                                final boolean empty = c$g.amX.isEmpty();
                                                                b = false;
                                                                if (!empty) {
                                                                    return b;
                                                                }
                                                            }
                                                            return true;
                                                        }
                                                        return this.amX.equals(c$g.amX);
                                                    }
                                                }
                                            }
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
    
    public c$g h(final ly ly) {
    Label_0193:
        while (true) {
            final int nb = ly.nB();
            switch (nb) {
                default: {
                    if (!this.a(ly, nb)) {
                        break Label_0193;
                    }
                    continue;
                }
                case 0: {
                    break Label_0193;
                }
                case 8: {
                    final int b = mh.b(ly, 8);
                    int i;
                    if (this.fn == null) {
                        i = 0;
                    }
                    else {
                        i = this.fn.length;
                    }
                    final int[] fn = new int[b + i];
                    if (i != 0) {
                        System.arraycopy(this.fn, 0, fn, 0, i);
                    }
                    while (i < -1 + fn.length) {
                        fn[i] = ly.nE();
                        ly.nB();
                        ++i;
                    }
                    fn[i] = ly.nE();
                    this.fn = fn;
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
                    if (this.fn == null) {
                        j = 0;
                    }
                    else {
                        j = this.fn.length;
                    }
                    final int[] fn2 = new int[n + j];
                    if (j != 0) {
                        System.arraycopy(this.fn, 0, fn2, 0, j);
                    }
                    while (j < fn2.length) {
                        fn2[j] = ly.nE();
                        ++j;
                    }
                    this.fn = fn2;
                    ly.ey(ex);
                    continue;
                }
                case 16: {
                    final int b2 = mh.b(ly, 16);
                    int k;
                    if (this.fo == null) {
                        k = 0;
                    }
                    else {
                        k = this.fo.length;
                    }
                    final int[] fo = new int[b2 + k];
                    if (k != 0) {
                        System.arraycopy(this.fo, 0, fo, 0, k);
                    }
                    while (k < -1 + fo.length) {
                        fo[k] = ly.nE();
                        ly.nB();
                        ++k;
                    }
                    fo[k] = ly.nE();
                    this.fo = fo;
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
                    if (this.fo == null) {
                        l = 0;
                    }
                    else {
                        l = this.fo.length;
                    }
                    final int[] fo2 = new int[n2 + l];
                    if (l != 0) {
                        System.arraycopy(this.fo, 0, fo2, 0, l);
                    }
                    while (l < fo2.length) {
                        fo2[l] = ly.nE();
                        ++l;
                    }
                    this.fo = fo2;
                    ly.ey(ex2);
                    continue;
                }
                case 24: {
                    final int b3 = mh.b(ly, 24);
                    int length;
                    if (this.fp == null) {
                        length = 0;
                    }
                    else {
                        length = this.fp.length;
                    }
                    final int[] fp = new int[b3 + length];
                    if (length != 0) {
                        System.arraycopy(this.fp, 0, fp, 0, length);
                    }
                    while (length < -1 + fp.length) {
                        fp[length] = ly.nE();
                        ly.nB();
                        ++length;
                    }
                    fp[length] = ly.nE();
                    this.fp = fp;
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
                    if (this.fp == null) {
                        length2 = 0;
                    }
                    else {
                        length2 = this.fp.length;
                    }
                    final int[] fp2 = new int[n3 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.fp, 0, fp2, 0, length2);
                    }
                    while (length2 < fp2.length) {
                        fp2[length2] = ly.nE();
                        ++length2;
                    }
                    this.fp = fp2;
                    ly.ey(ex3);
                    continue;
                }
                case 32: {
                    final int b4 = mh.b(ly, 32);
                    int length3;
                    if (this.fq == null) {
                        length3 = 0;
                    }
                    else {
                        length3 = this.fq.length;
                    }
                    final int[] fq = new int[b4 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.fq, 0, fq, 0, length3);
                    }
                    while (length3 < -1 + fq.length) {
                        fq[length3] = ly.nE();
                        ly.nB();
                        ++length3;
                    }
                    fq[length3] = ly.nE();
                    this.fq = fq;
                    continue;
                }
                case 34: {
                    final int ex4 = ly.ex(ly.nI());
                    final int position4 = ly.getPosition();
                    int n4 = 0;
                    while (ly.nN() > 0) {
                        ly.nE();
                        ++n4;
                    }
                    ly.ez(position4);
                    int length4;
                    if (this.fq == null) {
                        length4 = 0;
                    }
                    else {
                        length4 = this.fq.length;
                    }
                    final int[] fq2 = new int[n4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.fq, 0, fq2, 0, length4);
                    }
                    while (length4 < fq2.length) {
                        fq2[length4] = ly.nE();
                        ++length4;
                    }
                    this.fq = fq2;
                    ly.ey(ex4);
                    continue;
                }
                case 40: {
                    final int b5 = mh.b(ly, 40);
                    int length5;
                    if (this.fr == null) {
                        length5 = 0;
                    }
                    else {
                        length5 = this.fr.length;
                    }
                    final int[] fr = new int[b5 + length5];
                    if (length5 != 0) {
                        System.arraycopy(this.fr, 0, fr, 0, length5);
                    }
                    while (length5 < -1 + fr.length) {
                        fr[length5] = ly.nE();
                        ly.nB();
                        ++length5;
                    }
                    fr[length5] = ly.nE();
                    this.fr = fr;
                    continue;
                }
                case 42: {
                    final int ex5 = ly.ex(ly.nI());
                    final int position5 = ly.getPosition();
                    int n5 = 0;
                    while (ly.nN() > 0) {
                        ly.nE();
                        ++n5;
                    }
                    ly.ez(position5);
                    int length6;
                    if (this.fr == null) {
                        length6 = 0;
                    }
                    else {
                        length6 = this.fr.length;
                    }
                    final int[] fr2 = new int[n5 + length6];
                    if (length6 != 0) {
                        System.arraycopy(this.fr, 0, fr2, 0, length6);
                    }
                    while (length6 < fr2.length) {
                        fr2[length6] = ly.nE();
                        ++length6;
                    }
                    this.fr = fr2;
                    ly.ey(ex5);
                    continue;
                }
                case 48: {
                    final int b6 = mh.b(ly, 48);
                    int length7;
                    if (this.fs == null) {
                        length7 = 0;
                    }
                    else {
                        length7 = this.fs.length;
                    }
                    final int[] fs = new int[b6 + length7];
                    if (length7 != 0) {
                        System.arraycopy(this.fs, 0, fs, 0, length7);
                    }
                    while (length7 < -1 + fs.length) {
                        fs[length7] = ly.nE();
                        ly.nB();
                        ++length7;
                    }
                    fs[length7] = ly.nE();
                    this.fs = fs;
                    continue;
                }
                case 50: {
                    final int ex6 = ly.ex(ly.nI());
                    final int position6 = ly.getPosition();
                    int n6 = 0;
                    while (ly.nN() > 0) {
                        ly.nE();
                        ++n6;
                    }
                    ly.ez(position6);
                    int length8;
                    if (this.fs == null) {
                        length8 = 0;
                    }
                    else {
                        length8 = this.fs.length;
                    }
                    final int[] fs2 = new int[n6 + length8];
                    if (length8 != 0) {
                        System.arraycopy(this.fs, 0, fs2, 0, length8);
                    }
                    while (length8 < fs2.length) {
                        fs2[length8] = ly.nE();
                        ++length8;
                    }
                    this.fs = fs2;
                    ly.ey(ex6);
                    continue;
                }
                case 56: {
                    final int b7 = mh.b(ly, 56);
                    int length9;
                    if (this.ft == null) {
                        length9 = 0;
                    }
                    else {
                        length9 = this.ft.length;
                    }
                    final int[] ft = new int[b7 + length9];
                    if (length9 != 0) {
                        System.arraycopy(this.ft, 0, ft, 0, length9);
                    }
                    while (length9 < -1 + ft.length) {
                        ft[length9] = ly.nE();
                        ly.nB();
                        ++length9;
                    }
                    ft[length9] = ly.nE();
                    this.ft = ft;
                    continue;
                }
                case 58: {
                    final int ex7 = ly.ex(ly.nI());
                    final int position7 = ly.getPosition();
                    int n7 = 0;
                    while (ly.nN() > 0) {
                        ly.nE();
                        ++n7;
                    }
                    ly.ez(position7);
                    int length10;
                    if (this.ft == null) {
                        length10 = 0;
                    }
                    else {
                        length10 = this.ft.length;
                    }
                    final int[] ft2 = new int[n7 + length10];
                    if (length10 != 0) {
                        System.arraycopy(this.ft, 0, ft2, 0, length10);
                    }
                    while (length10 < ft2.length) {
                        ft2[length10] = ly.nE();
                        ++length10;
                    }
                    this.ft = ft2;
                    ly.ey(ex7);
                    continue;
                }
                case 64: {
                    final int b8 = mh.b(ly, 64);
                    int length11;
                    if (this.fu == null) {
                        length11 = 0;
                    }
                    else {
                        length11 = this.fu.length;
                    }
                    final int[] fu = new int[b8 + length11];
                    if (length11 != 0) {
                        System.arraycopy(this.fu, 0, fu, 0, length11);
                    }
                    while (length11 < -1 + fu.length) {
                        fu[length11] = ly.nE();
                        ly.nB();
                        ++length11;
                    }
                    fu[length11] = ly.nE();
                    this.fu = fu;
                    continue;
                }
                case 66: {
                    final int ex8 = ly.ex(ly.nI());
                    final int position8 = ly.getPosition();
                    int n8 = 0;
                    while (ly.nN() > 0) {
                        ly.nE();
                        ++n8;
                    }
                    ly.ez(position8);
                    int length12;
                    if (this.fu == null) {
                        length12 = 0;
                    }
                    else {
                        length12 = this.fu.length;
                    }
                    final int[] fu2 = new int[n8 + length12];
                    if (length12 != 0) {
                        System.arraycopy(this.fu, 0, fu2, 0, length12);
                    }
                    while (length12 < fu2.length) {
                        fu2[length12] = ly.nE();
                        ++length12;
                    }
                    this.fu = fu2;
                    ly.ey(ex8);
                    continue;
                }
                case 72: {
                    final int b9 = mh.b(ly, 72);
                    int length13;
                    if (this.fv == null) {
                        length13 = 0;
                    }
                    else {
                        length13 = this.fv.length;
                    }
                    final int[] fv = new int[b9 + length13];
                    if (length13 != 0) {
                        System.arraycopy(this.fv, 0, fv, 0, length13);
                    }
                    while (length13 < -1 + fv.length) {
                        fv[length13] = ly.nE();
                        ly.nB();
                        ++length13;
                    }
                    fv[length13] = ly.nE();
                    this.fv = fv;
                    continue;
                }
                case 74: {
                    final int ex9 = ly.ex(ly.nI());
                    final int position9 = ly.getPosition();
                    int n9 = 0;
                    while (ly.nN() > 0) {
                        ly.nE();
                        ++n9;
                    }
                    ly.ez(position9);
                    int length14;
                    if (this.fv == null) {
                        length14 = 0;
                    }
                    else {
                        length14 = this.fv.length;
                    }
                    final int[] fv2 = new int[n9 + length14];
                    if (length14 != 0) {
                        System.arraycopy(this.fv, 0, fv2, 0, length14);
                    }
                    while (length14 < fv2.length) {
                        fv2[length14] = ly.nE();
                        ++length14;
                    }
                    this.fv = fv2;
                    ly.ey(ex9);
                    continue;
                }
                case 80: {
                    final int b10 = mh.b(ly, 80);
                    int length15;
                    if (this.fw == null) {
                        length15 = 0;
                    }
                    else {
                        length15 = this.fw.length;
                    }
                    final int[] fw = new int[b10 + length15];
                    if (length15 != 0) {
                        System.arraycopy(this.fw, 0, fw, 0, length15);
                    }
                    while (length15 < -1 + fw.length) {
                        fw[length15] = ly.nE();
                        ly.nB();
                        ++length15;
                    }
                    fw[length15] = ly.nE();
                    this.fw = fw;
                    continue;
                }
                case 82: {
                    final int ex10 = ly.ex(ly.nI());
                    final int position10 = ly.getPosition();
                    int n10 = 0;
                    while (ly.nN() > 0) {
                        ly.nE();
                        ++n10;
                    }
                    ly.ez(position10);
                    int length16;
                    if (this.fw == null) {
                        length16 = 0;
                    }
                    else {
                        length16 = this.fw.length;
                    }
                    final int[] fw2 = new int[n10 + length16];
                    if (length16 != 0) {
                        System.arraycopy(this.fw, 0, fw2, 0, length16);
                    }
                    while (length16 < fw2.length) {
                        fw2[length16] = ly.nE();
                        ++length16;
                    }
                    this.fw = fw2;
                    ly.ey(ex10);
                    continue;
                }
            }
        }
        return this;
    }
    
    @Override
    public int hashCode() {
        final int n = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + mc.hashCode(this.fn)) + mc.hashCode(this.fo)) + mc.hashCode(this.fp)) + mc.hashCode(this.fq)) + mc.hashCode(this.fr)) + mc.hashCode(this.fs)) + mc.hashCode(this.ft)) + mc.hashCode(this.fu)) + mc.hashCode(this.fv)) + mc.hashCode(this.fw));
        int hashCode;
        if (this.amX == null || this.amX.isEmpty()) {
            hashCode = 0;
        }
        else {
            hashCode = this.amX.hashCode();
        }
        return hashCode + n;
    }
    
    public c$g m() {
        this.fn = mh.and;
        this.fo = mh.and;
        this.fp = mh.and;
        this.fq = mh.and;
        this.fr = mh.and;
        this.fs = mh.and;
        this.ft = mh.and;
        this.fu = mh.and;
        this.fv = mh.and;
        this.fw = mh.and;
        this.amX = null;
        this.anb = -1;
        return this;
    }
}
