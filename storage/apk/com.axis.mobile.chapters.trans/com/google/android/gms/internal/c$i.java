// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.List;

public final class c$i extends ma
{
    private static volatile c$i[] fG;
    public d$a fH;
    public c$d fI;
    public String name;
    
    public c$i() {
        this.p();
    }
    
    public static c$i[] o() {
        Label_0027: {
            if (c$i.fG != null) {
                break Label_0027;
            }
            synchronized (mc.ana) {
                if (c$i.fG == null) {
                    c$i.fG = new c$i[0];
                }
                return c$i.fG;
            }
        }
    }
    
    @Override
    public void a(final lz lz) {
        if (!this.name.equals("")) {
            lz.b(1, this.name);
        }
        if (this.fH != null) {
            lz.a(2, this.fH);
        }
        if (this.fI != null) {
            lz.a(3, this.fI);
        }
        super.a(lz);
    }
    
    @Override
    protected int c() {
        int c = super.c();
        if (!this.name.equals("")) {
            c += lz.h(1, this.name);
        }
        if (this.fH != null) {
            c += lz.b(2, this.fH);
        }
        if (this.fI != null) {
            c += lz.b(3, this.fI);
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
            final boolean b2 = o instanceof c$i;
            b = false;
            if (b2) {
                final c$i c$i = (c$i)o;
                if (this.name == null) {
                    final String name = c$i.name;
                    b = false;
                    if (name != null) {
                        return b;
                    }
                }
                else if (!this.name.equals(c$i.name)) {
                    return false;
                }
                if (this.fH == null) {
                    final d$a fh = c$i.fH;
                    b = false;
                    if (fh != null) {
                        return b;
                    }
                }
                else if (!this.fH.equals(c$i.fH)) {
                    return false;
                }
                if (this.fI == null) {
                    final c$d fi = c$i.fI;
                    b = false;
                    if (fi != null) {
                        return b;
                    }
                }
                else if (!this.fI.equals(c$i.fI)) {
                    return false;
                }
                if (this.amX == null || this.amX.isEmpty()) {
                    if (c$i.amX != null) {
                        final boolean empty = c$i.amX.isEmpty();
                        b = false;
                        if (!empty) {
                            return b;
                        }
                    }
                    return true;
                }
                return this.amX.equals(c$i.amX);
            }
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        int hashCode;
        if (this.name == null) {
            hashCode = 0;
        }
        else {
            hashCode = this.name.hashCode();
        }
        final int n = 31 * (hashCode + 527);
        int hashCode2;
        if (this.fH == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = this.fH.hashCode();
        }
        final int n2 = 31 * (hashCode2 + n);
        int hashCode3;
        if (this.fI == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = this.fI.hashCode();
        }
        final int n3 = 31 * (hashCode3 + n2);
        final List amX = this.amX;
        int hashCode4 = 0;
        if (amX != null) {
            final boolean empty = this.amX.isEmpty();
            hashCode4 = 0;
            if (!empty) {
                hashCode4 = this.amX.hashCode();
            }
        }
        return n3 + hashCode4;
    }
    
    public c$i j(final ly ly) {
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
                    this.name = ly.readString();
                    continue;
                }
                case 18: {
                    if (this.fH == null) {
                        this.fH = new d$a();
                    }
                    ly.a(this.fH);
                    continue;
                }
                case 26: {
                    if (this.fI == null) {
                        this.fI = new c$d();
                    }
                    ly.a(this.fI);
                    continue;
                }
            }
        }
        return this;
    }
    
    public c$i p() {
        this.name = "";
        this.fH = null;
        this.fI = null;
        this.amX = null;
        this.anb = -1;
        return this;
    }
}
