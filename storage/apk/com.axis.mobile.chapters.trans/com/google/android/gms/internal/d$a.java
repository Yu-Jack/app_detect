// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.List;

public final class d$a extends ma
{
    private static volatile d$a[] fM;
    public String fN;
    public d$a[] fO;
    public d$a[] fP;
    public d$a[] fQ;
    public String fR;
    public String fS;
    public long fT;
    public boolean fU;
    public d$a[] fV;
    public int[] fW;
    public boolean fX;
    public int type;
    
    public d$a() {
        this.s();
    }
    
    public static d$a[] r() {
        Label_0027: {
            if (d$a.fM != null) {
                break Label_0027;
            }
            synchronized (mc.ana) {
                if (d$a.fM == null) {
                    d$a.fM = new d$a[0];
                }
                return d$a.fM;
            }
        }
    }
    
    @Override
    public void a(final lz lz) {
        lz.p(1, this.type);
        if (!this.fN.equals("")) {
            lz.b(2, this.fN);
        }
        if (this.fO != null && this.fO.length > 0) {
            for (int i = 0; i < this.fO.length; ++i) {
                final d$a d$a = this.fO[i];
                if (d$a != null) {
                    lz.a(3, d$a);
                }
            }
        }
        if (this.fP != null && this.fP.length > 0) {
            for (int j = 0; j < this.fP.length; ++j) {
                final d$a d$a2 = this.fP[j];
                if (d$a2 != null) {
                    lz.a(4, d$a2);
                }
            }
        }
        if (this.fQ != null && this.fQ.length > 0) {
            for (int k = 0; k < this.fQ.length; ++k) {
                final d$a d$a3 = this.fQ[k];
                if (d$a3 != null) {
                    lz.a(5, d$a3);
                }
            }
        }
        if (!this.fR.equals("")) {
            lz.b(6, this.fR);
        }
        if (!this.fS.equals("")) {
            lz.b(7, this.fS);
        }
        if (this.fT != 0L) {
            lz.b(8, this.fT);
        }
        if (this.fX) {
            lz.a(9, this.fX);
        }
        if (this.fW != null && this.fW.length > 0) {
            for (int l = 0; l < this.fW.length; ++l) {
                lz.p(10, this.fW[l]);
            }
        }
        if (this.fV != null) {
            final int length = this.fV.length;
            int n = 0;
            if (length > 0) {
                while (n < this.fV.length) {
                    final d$a d$a4 = this.fV[n];
                    if (d$a4 != null) {
                        lz.a(11, d$a4);
                    }
                    ++n;
                }
            }
        }
        if (this.fU) {
            lz.a(12, this.fU);
        }
        super.a(lz);
    }
    
    @Override
    protected int c() {
        int n = super.c() + lz.r(1, this.type);
        if (!this.fN.equals("")) {
            n += lz.h(2, this.fN);
        }
        if (this.fO != null && this.fO.length > 0) {
            int n2 = n;
            for (int i = 0; i < this.fO.length; ++i) {
                final d$a d$a = this.fO[i];
                if (d$a != null) {
                    n2 += lz.b(3, d$a);
                }
            }
            n = n2;
        }
        if (this.fP != null && this.fP.length > 0) {
            int n3 = n;
            for (int j = 0; j < this.fP.length; ++j) {
                final d$a d$a2 = this.fP[j];
                if (d$a2 != null) {
                    n3 += lz.b(4, d$a2);
                }
            }
            n = n3;
        }
        if (this.fQ != null && this.fQ.length > 0) {
            int n4 = n;
            for (int k = 0; k < this.fQ.length; ++k) {
                final d$a d$a3 = this.fQ[k];
                if (d$a3 != null) {
                    n4 += lz.b(5, d$a3);
                }
            }
            n = n4;
        }
        if (!this.fR.equals("")) {
            n += lz.h(6, this.fR);
        }
        if (!this.fS.equals("")) {
            n += lz.h(7, this.fS);
        }
        if (this.fT != 0L) {
            n += lz.d(8, this.fT);
        }
        if (this.fX) {
            n += lz.b(9, this.fX);
        }
        if (this.fW != null && this.fW.length > 0) {
            int l = 0;
            int n5 = 0;
            while (l < this.fW.length) {
                n5 += lz.eE(this.fW[l]);
                ++l;
            }
            n = n + n5 + 1 * this.fW.length;
        }
        if (this.fV != null) {
            final int length = this.fV.length;
            int n6 = 0;
            if (length > 0) {
                while (n6 < this.fV.length) {
                    final d$a d$a4 = this.fV[n6];
                    if (d$a4 != null) {
                        n += lz.b(11, d$a4);
                    }
                    ++n6;
                }
            }
        }
        if (this.fU) {
            n += lz.b(12, this.fU);
        }
        return n;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b;
        if (o == this) {
            b = true;
        }
        else {
            final boolean b2 = o instanceof d$a;
            b = false;
            if (b2) {
                final d$a d$a = (d$a)o;
                final int type = this.type;
                final int type2 = d$a.type;
                b = false;
                if (type == type2) {
                    if (this.fN == null) {
                        final String fn = d$a.fN;
                        b = false;
                        if (fn != null) {
                            return b;
                        }
                    }
                    else if (!this.fN.equals(d$a.fN)) {
                        return false;
                    }
                    final boolean equals = mc.equals(this.fO, d$a.fO);
                    b = false;
                    if (equals) {
                        final boolean equals2 = mc.equals(this.fP, d$a.fP);
                        b = false;
                        if (equals2) {
                            final boolean equals3 = mc.equals(this.fQ, d$a.fQ);
                            b = false;
                            if (equals3) {
                                if (this.fR == null) {
                                    final String fr = d$a.fR;
                                    b = false;
                                    if (fr != null) {
                                        return b;
                                    }
                                }
                                else if (!this.fR.equals(d$a.fR)) {
                                    return false;
                                }
                                if (this.fS == null) {
                                    final String fs = d$a.fS;
                                    b = false;
                                    if (fs != null) {
                                        return b;
                                    }
                                }
                                else if (!this.fS.equals(d$a.fS)) {
                                    return false;
                                }
                                final long n = lcmp(this.fT, d$a.fT);
                                b = false;
                                if (n == 0) {
                                    final boolean fu = this.fU;
                                    final boolean fu2 = d$a.fU;
                                    b = false;
                                    if (fu == fu2) {
                                        final boolean equals4 = mc.equals(this.fV, d$a.fV);
                                        b = false;
                                        if (equals4) {
                                            final boolean equals5 = mc.equals(this.fW, d$a.fW);
                                            b = false;
                                            if (equals5) {
                                                final boolean fx = this.fX;
                                                final boolean fx2 = d$a.fX;
                                                b = false;
                                                if (fx == fx2) {
                                                    if (this.amX == null || this.amX.isEmpty()) {
                                                        if (d$a.amX != null) {
                                                            final boolean empty = d$a.amX.isEmpty();
                                                            b = false;
                                                            if (!empty) {
                                                                return b;
                                                            }
                                                        }
                                                        return true;
                                                    }
                                                    return this.amX.equals(d$a.amX);
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
    
    @Override
    public int hashCode() {
        int n = 1231;
        final int n2 = 31 * (527 + this.type);
        int hashCode;
        if (this.fN == null) {
            hashCode = 0;
        }
        else {
            hashCode = this.fN.hashCode();
        }
        final int n3 = 31 * (31 * (31 * (31 * (hashCode + n2) + mc.hashCode(this.fO)) + mc.hashCode(this.fP)) + mc.hashCode(this.fQ));
        int hashCode2;
        if (this.fR == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.fR.hashCode();
        }
        final int n4 = 31 * (hashCode2 + n3);
        int hashCode3;
        if (this.fS == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.fS.hashCode();
        }
        final int n5 = 31 * (31 * (hashCode3 + n4) + (int)(this.fT ^ this.fT >>> 32));
        int n6;
        if (this.fU) {
            n6 = n;
        }
        else {
            n6 = 1237;
        }
        final int n7 = 31 * (31 * (31 * (n6 + n5) + mc.hashCode(this.fV)) + mc.hashCode(this.fW));
        if (!this.fX) {
            n = 1237;
        }
        final int n8 = 31 * (n7 + n);
        final List amX = this.amX;
        int hashCode4 = 0;
        if (amX != null) {
            final boolean empty = this.amX.isEmpty();
            hashCode4 = 0;
            if (!empty) {
                hashCode4 = this.amX.hashCode();
            }
        }
        return n8 + hashCode4;
    }
    
    public d$a l(final ly ly) {
    Label_0137:
        while (true) {
            final int nb = ly.nB();
            switch (nb) {
                default: {
                    if (!this.a(ly, nb)) {
                        break Label_0137;
                    }
                    continue;
                }
                case 0: {
                    break Label_0137;
                }
                case 8: {
                    final int ne = ly.nE();
                    switch (ne) {
                        default: {
                            continue;
                        }
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8: {
                            this.type = ne;
                            continue;
                        }
                    }
                    break;
                }
                case 18: {
                    this.fN = ly.readString();
                    continue;
                }
                case 26: {
                    final int b = mh.b(ly, 26);
                    int i;
                    if (this.fO == null) {
                        i = 0;
                    }
                    else {
                        i = this.fO.length;
                    }
                    final d$a[] fo = new d$a[b + i];
                    if (i != 0) {
                        System.arraycopy(this.fO, 0, fo, 0, i);
                    }
                    while (i < -1 + fo.length) {
                        ly.a(fo[i] = new d$a());
                        ly.nB();
                        ++i;
                    }
                    ly.a(fo[i] = new d$a());
                    this.fO = fo;
                    continue;
                }
                case 34: {
                    final int b2 = mh.b(ly, 34);
                    int j;
                    if (this.fP == null) {
                        j = 0;
                    }
                    else {
                        j = this.fP.length;
                    }
                    final d$a[] fp = new d$a[b2 + j];
                    if (j != 0) {
                        System.arraycopy(this.fP, 0, fp, 0, j);
                    }
                    while (j < -1 + fp.length) {
                        ly.a(fp[j] = new d$a());
                        ly.nB();
                        ++j;
                    }
                    ly.a(fp[j] = new d$a());
                    this.fP = fp;
                    continue;
                }
                case 42: {
                    final int b3 = mh.b(ly, 42);
                    int k;
                    if (this.fQ == null) {
                        k = 0;
                    }
                    else {
                        k = this.fQ.length;
                    }
                    final d$a[] fq = new d$a[b3 + k];
                    if (k != 0) {
                        System.arraycopy(this.fQ, 0, fq, 0, k);
                    }
                    while (k < -1 + fq.length) {
                        ly.a(fq[k] = new d$a());
                        ly.nB();
                        ++k;
                    }
                    ly.a(fq[k] = new d$a());
                    this.fQ = fq;
                    continue;
                }
                case 50: {
                    this.fR = ly.readString();
                    continue;
                }
                case 58: {
                    this.fS = ly.readString();
                    continue;
                }
                case 64: {
                    this.fT = ly.nD();
                    continue;
                }
                case 72: {
                    this.fX = ly.nF();
                    continue;
                }
                case 80: {
                    final int b4 = mh.b(ly, 80);
                    final int[] fw = new int[b4];
                    int l = 0;
                    int n = 0;
                    while (l < b4) {
                        if (l != 0) {
                            ly.nB();
                        }
                        final int ne2 = ly.nE();
                        int n2 = 0;
                        switch (ne2) {
                            default: {
                                n2 = n;
                                break;
                            }
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17: {
                                n2 = n + 1;
                                fw[n] = ne2;
                                break;
                            }
                        }
                        ++l;
                        n = n2;
                    }
                    if (n == 0) {
                        continue;
                    }
                    int length;
                    if (this.fW == null) {
                        length = 0;
                    }
                    else {
                        length = this.fW.length;
                    }
                    if (length == 0 && n == fw.length) {
                        this.fW = fw;
                        continue;
                    }
                    final int[] fw2 = new int[length + n];
                    if (length != 0) {
                        System.arraycopy(this.fW, 0, fw2, 0, length);
                    }
                    System.arraycopy(fw, 0, fw2, length, n);
                    this.fW = fw2;
                    continue;
                }
                case 82: {
                    final int ex = ly.ex(ly.nI());
                    final int position = ly.getPosition();
                    int n3 = 0;
                    while (ly.nN() > 0) {
                        switch (ly.nE()) {
                            default: {
                                continue;
                            }
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17: {
                                ++n3;
                                continue;
                            }
                        }
                    }
                    if (n3 != 0) {
                        ly.ez(position);
                        int length2;
                        if (this.fW == null) {
                            length2 = 0;
                        }
                        else {
                            length2 = this.fW.length;
                        }
                        final int[] fw3 = new int[n3 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.fW, 0, fw3, 0, length2);
                        }
                        while (ly.nN() > 0) {
                            final int ne3 = ly.nE();
                            switch (ne3) {
                                default: {
                                    continue;
                                }
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17: {
                                    final int n4 = length2 + 1;
                                    fw3[length2] = ne3;
                                    length2 = n4;
                                    continue;
                                }
                            }
                        }
                        this.fW = fw3;
                    }
                    ly.ey(ex);
                    continue;
                }
                case 90: {
                    final int b5 = mh.b(ly, 90);
                    int length3;
                    if (this.fV == null) {
                        length3 = 0;
                    }
                    else {
                        length3 = this.fV.length;
                    }
                    final d$a[] fv = new d$a[b5 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.fV, 0, fv, 0, length3);
                    }
                    while (length3 < -1 + fv.length) {
                        ly.a(fv[length3] = new d$a());
                        ly.nB();
                        ++length3;
                    }
                    ly.a(fv[length3] = new d$a());
                    this.fV = fv;
                    continue;
                }
                case 96: {
                    this.fU = ly.nF();
                    continue;
                }
            }
        }
        return this;
    }
    
    public d$a s() {
        this.type = 1;
        this.fN = "";
        this.fO = r();
        this.fP = r();
        this.fQ = r();
        this.fR = "";
        this.fS = "";
        this.fT = 0L;
        this.fU = false;
        this.fV = r();
        this.fW = mh.and;
        this.fX = false;
        this.amX = null;
        this.anb = -1;
        return this;
    }
}
