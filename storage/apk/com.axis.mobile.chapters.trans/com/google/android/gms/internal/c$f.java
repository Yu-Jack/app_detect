// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.List;

public final class c$f extends ma
{
    public String[] eV;
    public String[] eW;
    public d$a[] eX;
    public c$e[] eY;
    public c$b[] eZ;
    public c$b[] fa;
    public c$b[] fb;
    public c$g[] fc;
    public String fd;
    public String fe;
    public String ff;
    public String fg;
    public c$a fh;
    public float fi;
    public boolean fj;
    public String[] fk;
    public int fl;
    
    public c$f() {
        this.k();
    }
    
    public static c$f a(final byte[] array) {
        return (c$f)me.a(new c$f(), array);
    }
    
    @Override
    public void a(final lz lz) {
        if (this.eW != null && this.eW.length > 0) {
            for (int i = 0; i < this.eW.length; ++i) {
                final String s = this.eW[i];
                if (s != null) {
                    lz.b(1, s);
                }
            }
        }
        if (this.eX != null && this.eX.length > 0) {
            for (int j = 0; j < this.eX.length; ++j) {
                final d$a d$a = this.eX[j];
                if (d$a != null) {
                    lz.a(2, d$a);
                }
            }
        }
        if (this.eY != null && this.eY.length > 0) {
            for (int k = 0; k < this.eY.length; ++k) {
                final c$e c$e = this.eY[k];
                if (c$e != null) {
                    lz.a(3, c$e);
                }
            }
        }
        if (this.eZ != null && this.eZ.length > 0) {
            for (int l = 0; l < this.eZ.length; ++l) {
                final c$b c$b = this.eZ[l];
                if (c$b != null) {
                    lz.a(4, c$b);
                }
            }
        }
        if (this.fa != null && this.fa.length > 0) {
            for (int n = 0; n < this.fa.length; ++n) {
                final c$b c$b2 = this.fa[n];
                if (c$b2 != null) {
                    lz.a(5, c$b2);
                }
            }
        }
        if (this.fb != null && this.fb.length > 0) {
            for (int n2 = 0; n2 < this.fb.length; ++n2) {
                final c$b c$b3 = this.fb[n2];
                if (c$b3 != null) {
                    lz.a(6, c$b3);
                }
            }
        }
        if (this.fc != null && this.fc.length > 0) {
            for (int n3 = 0; n3 < this.fc.length; ++n3) {
                final c$g c$g = this.fc[n3];
                if (c$g != null) {
                    lz.a(7, c$g);
                }
            }
        }
        if (!this.fd.equals("")) {
            lz.b(9, this.fd);
        }
        if (!this.fe.equals("")) {
            lz.b(10, this.fe);
        }
        if (!this.ff.equals("0")) {
            lz.b(12, this.ff);
        }
        if (!this.fg.equals("")) {
            lz.b(13, this.fg);
        }
        if (this.fh != null) {
            lz.a(14, this.fh);
        }
        if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(0.0f)) {
            lz.b(15, this.fi);
        }
        if (this.fk != null && this.fk.length > 0) {
            for (int n4 = 0; n4 < this.fk.length; ++n4) {
                final String s2 = this.fk[n4];
                if (s2 != null) {
                    lz.b(16, s2);
                }
            }
        }
        if (this.fl != 0) {
            lz.p(17, this.fl);
        }
        if (this.fj) {
            lz.a(18, this.fj);
        }
        if (this.eV != null) {
            final int length = this.eV.length;
            int n5 = 0;
            if (length > 0) {
                while (n5 < this.eV.length) {
                    final String s3 = this.eV[n5];
                    if (s3 != null) {
                        lz.b(19, s3);
                    }
                    ++n5;
                }
            }
        }
        super.a(lz);
    }
    
    @Override
    protected int c() {
        int i = 0;
        final int c = super.c();
        int n3;
        if (this.eW != null && this.eW.length > 0) {
            int j = 0;
            int n = 0;
            int n2 = 0;
            while (j < this.eW.length) {
                final String s = this.eW[j];
                if (s != null) {
                    ++n2;
                    n += lz.cz(s);
                }
                ++j;
            }
            n3 = c + n + n2 * 1;
        }
        else {
            n3 = c;
        }
        if (this.eX != null && this.eX.length > 0) {
            int n4 = n3;
            for (int k = 0; k < this.eX.length; ++k) {
                final d$a d$a = this.eX[k];
                if (d$a != null) {
                    n4 += lz.b(2, d$a);
                }
            }
            n3 = n4;
        }
        if (this.eY != null && this.eY.length > 0) {
            int n5 = n3;
            for (int l = 0; l < this.eY.length; ++l) {
                final c$e c$e = this.eY[l];
                if (c$e != null) {
                    n5 += lz.b(3, c$e);
                }
            }
            n3 = n5;
        }
        if (this.eZ != null && this.eZ.length > 0) {
            int n6 = n3;
            for (int n7 = 0; n7 < this.eZ.length; ++n7) {
                final c$b c$b = this.eZ[n7];
                if (c$b != null) {
                    n6 += lz.b(4, c$b);
                }
            }
            n3 = n6;
        }
        if (this.fa != null && this.fa.length > 0) {
            int n8 = n3;
            for (int n9 = 0; n9 < this.fa.length; ++n9) {
                final c$b c$b2 = this.fa[n9];
                if (c$b2 != null) {
                    n8 += lz.b(5, c$b2);
                }
            }
            n3 = n8;
        }
        if (this.fb != null && this.fb.length > 0) {
            int n10 = n3;
            for (int n11 = 0; n11 < this.fb.length; ++n11) {
                final c$b c$b3 = this.fb[n11];
                if (c$b3 != null) {
                    n10 += lz.b(6, c$b3);
                }
            }
            n3 = n10;
        }
        if (this.fc != null && this.fc.length > 0) {
            int n12 = n3;
            for (int n13 = 0; n13 < this.fc.length; ++n13) {
                final c$g c$g = this.fc[n13];
                if (c$g != null) {
                    n12 += lz.b(7, c$g);
                }
            }
            n3 = n12;
        }
        if (!this.fd.equals("")) {
            n3 += lz.h(9, this.fd);
        }
        if (!this.fe.equals("")) {
            n3 += lz.h(10, this.fe);
        }
        if (!this.ff.equals("0")) {
            n3 += lz.h(12, this.ff);
        }
        if (!this.fg.equals("")) {
            n3 += lz.h(13, this.fg);
        }
        if (this.fh != null) {
            n3 += lz.b(14, this.fh);
        }
        if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(0.0f)) {
            n3 += lz.c(15, this.fi);
        }
        if (this.fk != null && this.fk.length > 0) {
            int n14 = 0;
            int n15 = 0;
            int n16 = 0;
            while (n14 < this.fk.length) {
                final String s2 = this.fk[n14];
                if (s2 != null) {
                    ++n16;
                    n15 += lz.cz(s2);
                }
                ++n14;
            }
            n3 = n3 + n15 + n16 * 2;
        }
        if (this.fl != 0) {
            n3 += lz.r(17, this.fl);
        }
        if (this.fj) {
            n3 += lz.b(18, this.fj);
        }
        if (this.eV != null && this.eV.length > 0) {
            int n17 = 0;
            int n18 = 0;
            while (i < this.eV.length) {
                final String s3 = this.eV[i];
                if (s3 != null) {
                    ++n18;
                    n17 += lz.cz(s3);
                }
                ++i;
            }
            n3 = n3 + n17 + n18 * 2;
        }
        return n3;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b;
        if (o == this) {
            b = true;
        }
        else {
            final boolean b2 = o instanceof c$f;
            b = false;
            if (b2) {
                final c$f c$f = (c$f)o;
                final boolean equals = mc.equals(this.eV, c$f.eV);
                b = false;
                if (equals) {
                    final boolean equals2 = mc.equals(this.eW, c$f.eW);
                    b = false;
                    if (equals2) {
                        final boolean equals3 = mc.equals(this.eX, c$f.eX);
                        b = false;
                        if (equals3) {
                            final boolean equals4 = mc.equals(this.eY, c$f.eY);
                            b = false;
                            if (equals4) {
                                final boolean equals5 = mc.equals(this.eZ, c$f.eZ);
                                b = false;
                                if (equals5) {
                                    final boolean equals6 = mc.equals(this.fa, c$f.fa);
                                    b = false;
                                    if (equals6) {
                                        final boolean equals7 = mc.equals(this.fb, c$f.fb);
                                        b = false;
                                        if (equals7) {
                                            final boolean equals8 = mc.equals(this.fc, c$f.fc);
                                            b = false;
                                            if (equals8) {
                                                if (this.fd == null) {
                                                    final String fd = c$f.fd;
                                                    b = false;
                                                    if (fd != null) {
                                                        return b;
                                                    }
                                                }
                                                else if (!this.fd.equals(c$f.fd)) {
                                                    return false;
                                                }
                                                if (this.fe == null) {
                                                    final String fe = c$f.fe;
                                                    b = false;
                                                    if (fe != null) {
                                                        return b;
                                                    }
                                                }
                                                else if (!this.fe.equals(c$f.fe)) {
                                                    return false;
                                                }
                                                if (this.ff == null) {
                                                    final String ff = c$f.ff;
                                                    b = false;
                                                    if (ff != null) {
                                                        return b;
                                                    }
                                                }
                                                else if (!this.ff.equals(c$f.ff)) {
                                                    return false;
                                                }
                                                if (this.fg == null) {
                                                    final String fg = c$f.fg;
                                                    b = false;
                                                    if (fg != null) {
                                                        return b;
                                                    }
                                                }
                                                else if (!this.fg.equals(c$f.fg)) {
                                                    return false;
                                                }
                                                if (this.fh == null) {
                                                    final c$a fh = c$f.fh;
                                                    b = false;
                                                    if (fh != null) {
                                                        return b;
                                                    }
                                                }
                                                else if (!this.fh.equals(c$f.fh)) {
                                                    return false;
                                                }
                                                final int floatToIntBits = Float.floatToIntBits(this.fi);
                                                final int floatToIntBits2 = Float.floatToIntBits(c$f.fi);
                                                b = false;
                                                if (floatToIntBits == floatToIntBits2) {
                                                    final boolean fj = this.fj;
                                                    final boolean fj2 = c$f.fj;
                                                    b = false;
                                                    if (fj == fj2) {
                                                        final boolean equals9 = mc.equals(this.fk, c$f.fk);
                                                        b = false;
                                                        if (equals9) {
                                                            final int fl = this.fl;
                                                            final int fl2 = c$f.fl;
                                                            b = false;
                                                            if (fl == fl2) {
                                                                if (this.amX == null || this.amX.isEmpty()) {
                                                                    if (c$f.amX != null) {
                                                                        final boolean empty = c$f.amX.isEmpty();
                                                                        b = false;
                                                                        if (!empty) {
                                                                            return b;
                                                                        }
                                                                    }
                                                                    return true;
                                                                }
                                                                return this.amX.equals(c$f.amX);
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
            }
        }
        return b;
    }
    
    public c$f g(final ly ly) {
    Label_0169:
        while (true) {
            final int nb = ly.nB();
            switch (nb) {
                default: {
                    if (!this.a(ly, nb)) {
                        break Label_0169;
                    }
                    continue;
                }
                case 0: {
                    break Label_0169;
                }
                case 10: {
                    final int b = mh.b(ly, 10);
                    int i;
                    if (this.eW == null) {
                        i = 0;
                    }
                    else {
                        i = this.eW.length;
                    }
                    final String[] ew = new String[b + i];
                    if (i != 0) {
                        System.arraycopy(this.eW, 0, ew, 0, i);
                    }
                    while (i < -1 + ew.length) {
                        ew[i] = ly.readString();
                        ly.nB();
                        ++i;
                    }
                    ew[i] = ly.readString();
                    this.eW = ew;
                    continue;
                }
                case 18: {
                    final int b2 = mh.b(ly, 18);
                    int j;
                    if (this.eX == null) {
                        j = 0;
                    }
                    else {
                        j = this.eX.length;
                    }
                    final d$a[] ex = new d$a[b2 + j];
                    if (j != 0) {
                        System.arraycopy(this.eX, 0, ex, 0, j);
                    }
                    while (j < -1 + ex.length) {
                        ly.a(ex[j] = new d$a());
                        ly.nB();
                        ++j;
                    }
                    ly.a(ex[j] = new d$a());
                    this.eX = ex;
                    continue;
                }
                case 26: {
                    final int b3 = mh.b(ly, 26);
                    int k;
                    if (this.eY == null) {
                        k = 0;
                    }
                    else {
                        k = this.eY.length;
                    }
                    final c$e[] ey = new c$e[b3 + k];
                    if (k != 0) {
                        System.arraycopy(this.eY, 0, ey, 0, k);
                    }
                    while (k < -1 + ey.length) {
                        ly.a(ey[k] = new c$e());
                        ly.nB();
                        ++k;
                    }
                    ly.a(ey[k] = new c$e());
                    this.eY = ey;
                    continue;
                }
                case 34: {
                    final int b4 = mh.b(ly, 34);
                    int l;
                    if (this.eZ == null) {
                        l = 0;
                    }
                    else {
                        l = this.eZ.length;
                    }
                    final c$b[] ez = new c$b[b4 + l];
                    if (l != 0) {
                        System.arraycopy(this.eZ, 0, ez, 0, l);
                    }
                    while (l < -1 + ez.length) {
                        ly.a(ez[l] = new c$b());
                        ly.nB();
                        ++l;
                    }
                    ly.a(ez[l] = new c$b());
                    this.eZ = ez;
                    continue;
                }
                case 42: {
                    final int b5 = mh.b(ly, 42);
                    int length;
                    if (this.fa == null) {
                        length = 0;
                    }
                    else {
                        length = this.fa.length;
                    }
                    final c$b[] fa = new c$b[b5 + length];
                    if (length != 0) {
                        System.arraycopy(this.fa, 0, fa, 0, length);
                    }
                    while (length < -1 + fa.length) {
                        ly.a(fa[length] = new c$b());
                        ly.nB();
                        ++length;
                    }
                    ly.a(fa[length] = new c$b());
                    this.fa = fa;
                    continue;
                }
                case 50: {
                    final int b6 = mh.b(ly, 50);
                    int length2;
                    if (this.fb == null) {
                        length2 = 0;
                    }
                    else {
                        length2 = this.fb.length;
                    }
                    final c$b[] fb = new c$b[b6 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.fb, 0, fb, 0, length2);
                    }
                    while (length2 < -1 + fb.length) {
                        ly.a(fb[length2] = new c$b());
                        ly.nB();
                        ++length2;
                    }
                    ly.a(fb[length2] = new c$b());
                    this.fb = fb;
                    continue;
                }
                case 58: {
                    final int b7 = mh.b(ly, 58);
                    int length3;
                    if (this.fc == null) {
                        length3 = 0;
                    }
                    else {
                        length3 = this.fc.length;
                    }
                    final c$g[] fc = new c$g[b7 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.fc, 0, fc, 0, length3);
                    }
                    while (length3 < -1 + fc.length) {
                        ly.a(fc[length3] = new c$g());
                        ly.nB();
                        ++length3;
                    }
                    ly.a(fc[length3] = new c$g());
                    this.fc = fc;
                    continue;
                }
                case 74: {
                    this.fd = ly.readString();
                    continue;
                }
                case 82: {
                    this.fe = ly.readString();
                    continue;
                }
                case 98: {
                    this.ff = ly.readString();
                    continue;
                }
                case 106: {
                    this.fg = ly.readString();
                    continue;
                }
                case 114: {
                    if (this.fh == null) {
                        this.fh = new c$a();
                    }
                    ly.a(this.fh);
                    continue;
                }
                case 125: {
                    this.fi = ly.readFloat();
                    continue;
                }
                case 130: {
                    final int b8 = mh.b(ly, 130);
                    int length4;
                    if (this.fk == null) {
                        length4 = 0;
                    }
                    else {
                        length4 = this.fk.length;
                    }
                    final String[] fk = new String[b8 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.fk, 0, fk, 0, length4);
                    }
                    while (length4 < -1 + fk.length) {
                        fk[length4] = ly.readString();
                        ly.nB();
                        ++length4;
                    }
                    fk[length4] = ly.readString();
                    this.fk = fk;
                    continue;
                }
                case 136: {
                    this.fl = ly.nE();
                    continue;
                }
                case 144: {
                    this.fj = ly.nF();
                    continue;
                }
                case 154: {
                    final int b9 = mh.b(ly, 154);
                    int length5;
                    if (this.eV == null) {
                        length5 = 0;
                    }
                    else {
                        length5 = this.eV.length;
                    }
                    final String[] ev = new String[b9 + length5];
                    if (length5 != 0) {
                        System.arraycopy(this.eV, 0, ev, 0, length5);
                    }
                    while (length5 < -1 + ev.length) {
                        ev[length5] = ly.readString();
                        ly.nB();
                        ++length5;
                    }
                    ev[length5] = ly.readString();
                    this.eV = ev;
                    continue;
                }
            }
        }
        return this;
    }
    
    @Override
    public int hashCode() {
        final int n = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + mc.hashCode(this.eV)) + mc.hashCode(this.eW)) + mc.hashCode(this.eX)) + mc.hashCode(this.eY)) + mc.hashCode(this.eZ)) + mc.hashCode(this.fa)) + mc.hashCode(this.fb)) + mc.hashCode(this.fc));
        int hashCode;
        if (this.fd == null) {
            hashCode = 0;
        }
        else {
            hashCode = this.fd.hashCode();
        }
        final int n2 = 31 * (hashCode + n);
        int hashCode2;
        if (this.fe == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.fe.hashCode();
        }
        final int n3 = 31 * (hashCode2 + n2);
        int hashCode3;
        if (this.ff == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.ff.hashCode();
        }
        final int n4 = 31 * (hashCode3 + n3);
        int hashCode4;
        if (this.fg == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = this.fg.hashCode();
        }
        final int n5 = 31 * (hashCode4 + n4);
        int hashCode5;
        if (this.fh == null) {
            hashCode5 = 0;
        }
        else {
            hashCode5 = this.fh.hashCode();
        }
        final int n6 = 31 * (31 * (hashCode5 + n5) + Float.floatToIntBits(this.fi));
        int n7;
        if (this.fj) {
            n7 = 1231;
        }
        else {
            n7 = 1237;
        }
        final int n8 = 31 * (31 * (31 * (n7 + n6) + mc.hashCode(this.fk)) + this.fl);
        final List amX = this.amX;
        int hashCode6 = 0;
        if (amX != null) {
            final boolean empty = this.amX.isEmpty();
            hashCode6 = 0;
            if (!empty) {
                hashCode6 = this.amX.hashCode();
            }
        }
        return n8 + hashCode6;
    }
    
    public c$f k() {
        this.eV = mh.ani;
        this.eW = mh.ani;
        this.eX = d$a.r();
        this.eY = c$e.i();
        this.eZ = c$b.d();
        this.fa = c$b.d();
        this.fb = c$b.d();
        this.fc = c$g.l();
        this.fd = "";
        this.fe = "";
        this.ff = "0";
        this.fg = "";
        this.fh = null;
        this.fi = 0.0f;
        this.fj = false;
        this.fk = mh.ani;
        this.fl = 0;
        this.amX = null;
        this.anb = -1;
        return this;
    }
}
