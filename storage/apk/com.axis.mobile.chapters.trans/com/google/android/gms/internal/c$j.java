// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.List;

public final class c$j extends ma
{
    public c$i[] fJ;
    public c$f fK;
    public String fL;
    
    public c$j() {
        this.q();
    }
    
    public static c$j b(final byte[] array) {
        return (c$j)me.a(new c$j(), array);
    }
    
    @Override
    public void a(final lz lz) {
        if (this.fJ != null && this.fJ.length > 0) {
            for (int i = 0; i < this.fJ.length; ++i) {
                final c$i c$i = this.fJ[i];
                if (c$i != null) {
                    lz.a(1, c$i);
                }
            }
        }
        if (this.fK != null) {
            lz.a(2, this.fK);
        }
        if (!this.fL.equals("")) {
            lz.b(3, this.fL);
        }
        super.a(lz);
    }
    
    @Override
    protected int c() {
        int c = super.c();
        if (this.fJ != null && this.fJ.length > 0) {
            for (int i = 0; i < this.fJ.length; ++i) {
                final c$i c$i = this.fJ[i];
                if (c$i != null) {
                    c += lz.b(1, c$i);
                }
            }
        }
        if (this.fK != null) {
            c += lz.b(2, this.fK);
        }
        if (!this.fL.equals("")) {
            c += lz.h(3, this.fL);
        }
        return c;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b;
        if (o == this) {
            b = true;
        }
        else {
            final boolean b2 = o instanceof c$j;
            b = false;
            if (b2) {
                final c$j c$j = (c$j)o;
                final boolean equals = mc.equals(this.fJ, c$j.fJ);
                b = false;
                if (equals) {
                    if (this.fK == null) {
                        final c$f fk = c$j.fK;
                        b = false;
                        if (fk != null) {
                            return b;
                        }
                    }
                    else if (!this.fK.equals(c$j.fK)) {
                        return false;
                    }
                    if (this.fL == null) {
                        final String fl = c$j.fL;
                        b = false;
                        if (fl != null) {
                            return b;
                        }
                    }
                    else if (!this.fL.equals(c$j.fL)) {
                        return false;
                    }
                    if (this.amX == null || this.amX.isEmpty()) {
                        if (c$j.amX != null) {
                            final boolean empty = c$j.amX.isEmpty();
                            b = false;
                            if (!empty) {
                                return b;
                            }
                        }
                        return true;
                    }
                    return this.amX.equals(c$j.amX);
                }
            }
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        final int n = 31 * (527 + mc.hashCode(this.fJ));
        int hashCode;
        if (this.fK == null) {
            hashCode = 0;
        }
        else {
            hashCode = this.fK.hashCode();
        }
        final int n2 = 31 * (hashCode + n);
        int hashCode2;
        if (this.fL == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.fL.hashCode();
        }
        final int n3 = 31 * (hashCode2 + n2);
        final List amX = this.amX;
        int hashCode3 = 0;
        if (amX != null) {
            final boolean empty = this.amX.isEmpty();
            hashCode3 = 0;
            if (!empty) {
                hashCode3 = this.amX.hashCode();
            }
        }
        return n3 + hashCode3;
    }
    
    public c$j k(final ly ly) {
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
                    if (this.fJ == null) {
                        i = 0;
                    }
                    else {
                        i = this.fJ.length;
                    }
                    final c$i[] fj = new c$i[b + i];
                    if (i != 0) {
                        System.arraycopy(this.fJ, 0, fj, 0, i);
                    }
                    while (i < -1 + fj.length) {
                        ly.a(fj[i] = new c$i());
                        ly.nB();
                        ++i;
                    }
                    ly.a(fj[i] = new c$i());
                    this.fJ = fj;
                    continue;
                }
                case 18: {
                    if (this.fK == null) {
                        this.fK = new c$f();
                    }
                    ly.a(this.fK);
                    continue;
                }
                case 26: {
                    this.fL = ly.readString();
                    continue;
                }
            }
        }
        return this;
    }
    
    public c$j q() {
        this.fJ = c$i.o();
        this.fK = null;
        this.fL = "";
        this.amX = null;
        this.anb = -1;
        return this;
    }
}
