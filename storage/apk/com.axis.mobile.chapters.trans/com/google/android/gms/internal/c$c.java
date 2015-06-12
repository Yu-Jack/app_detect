// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.List;

public final class c$c extends ma
{
    private static volatile c$c[] eL;
    public String eM;
    public long eN;
    public long eO;
    public boolean eP;
    public long eQ;
    
    public c$c() {
        this.g();
    }
    
    public static c$c[] f() {
        Label_0027: {
            if (c$c.eL != null) {
                break Label_0027;
            }
            synchronized (mc.ana) {
                if (c$c.eL == null) {
                    c$c.eL = new c$c[0];
                }
                return c$c.eL;
            }
        }
    }
    
    @Override
    public void a(final lz lz) {
        if (!this.eM.equals("")) {
            lz.b(1, this.eM);
        }
        if (this.eN != 0L) {
            lz.b(2, this.eN);
        }
        if (this.eO != 2147483647L) {
            lz.b(3, this.eO);
        }
        if (this.eP) {
            lz.a(4, this.eP);
        }
        if (this.eQ != 0L) {
            lz.b(5, this.eQ);
        }
        super.a(lz);
    }
    
    @Override
    protected int c() {
        int c = super.c();
        if (!this.eM.equals("")) {
            c += lz.h(1, this.eM);
        }
        if (this.eN != 0L) {
            c += lz.d(2, this.eN);
        }
        if (this.eO != 2147483647L) {
            c += lz.d(3, this.eO);
        }
        if (this.eP) {
            c += lz.b(4, this.eP);
        }
        if (this.eQ != 0L) {
            c += lz.d(5, this.eQ);
        }
        return c;
    }
    
    public c$c d(final ly ly) {
    Label_0073:
        while (true) {
            final int nb = ly.nB();
            switch (nb) {
                default: {
                    if (!this.a(ly, nb)) {
                        break Label_0073;
                    }
                    continue;
                }
                case 0: {
                    break Label_0073;
                }
                case 10: {
                    this.eM = ly.readString();
                    continue;
                }
                case 16: {
                    this.eN = ly.nD();
                    continue;
                }
                case 24: {
                    this.eO = ly.nD();
                    continue;
                }
                case 32: {
                    this.eP = ly.nF();
                    continue;
                }
                case 40: {
                    this.eQ = ly.nD();
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
            final boolean b2 = o instanceof c$c;
            b = false;
            if (b2) {
                final c$c c$c = (c$c)o;
                if (this.eM == null) {
                    final String em = c$c.eM;
                    b = false;
                    if (em != null) {
                        return b;
                    }
                }
                else if (!this.eM.equals(c$c.eM)) {
                    return false;
                }
                final long n = lcmp(this.eN, c$c.eN);
                b = false;
                if (n == 0) {
                    final long n2 = lcmp(this.eO, c$c.eO);
                    b = false;
                    if (n2 == 0) {
                        final boolean ep = this.eP;
                        final boolean ep2 = c$c.eP;
                        b = false;
                        if (ep == ep2) {
                            final long n3 = lcmp(this.eQ, c$c.eQ);
                            b = false;
                            if (n3 == 0) {
                                if (this.amX == null || this.amX.isEmpty()) {
                                    if (c$c.amX != null) {
                                        final boolean empty = c$c.amX.isEmpty();
                                        b = false;
                                        if (!empty) {
                                            return b;
                                        }
                                    }
                                    return true;
                                }
                                return this.amX.equals(c$c.amX);
                            }
                        }
                    }
                }
            }
        }
        return b;
    }
    
    public c$c g() {
        this.eM = "";
        this.eN = 0L;
        this.eO = 2147483647L;
        this.eP = false;
        this.eQ = 0L;
        this.amX = null;
        this.anb = -1;
        return this;
    }
    
    @Override
    public int hashCode() {
        int hashCode;
        if (this.eM == null) {
            hashCode = 0;
        }
        else {
            hashCode = this.eM.hashCode();
        }
        final int n = 31 * (31 * (31 * (hashCode + 527) + (int)(this.eN ^ this.eN >>> 32)) + (int)(this.eO ^ this.eO >>> 32));
        int n2;
        if (this.eP) {
            n2 = 1231;
        }
        else {
            n2 = 1237;
        }
        final int n3 = 31 * (31 * (n2 + n) + (int)(this.eQ ^ this.eQ >>> 32));
        final List amX = this.amX;
        int hashCode2 = 0;
        if (amX != null) {
            final boolean empty = this.amX.isEmpty();
            hashCode2 = 0;
            if (!empty) {
                hashCode2 = this.amX.hashCode();
            }
        }
        return n3 + hashCode2;
    }
}
