// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

public final class c$a extends ma
{
    public int eE;
    public int eF;
    public int level;
    
    public c$a() {
        this.b();
    }
    
    public c$a a(final ly ly) {
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
                case 8: {
                    final int ne = ly.nE();
                    switch (ne) {
                        default: {
                            continue;
                        }
                        case 1:
                        case 2:
                        case 3: {
                            this.level = ne;
                            continue;
                        }
                    }
                    break;
                }
                case 16: {
                    this.eE = ly.nE();
                    continue;
                }
                case 24: {
                    this.eF = ly.nE();
                    continue;
                }
            }
        }
        return this;
    }
    
    @Override
    public void a(final lz lz) {
        if (this.level != 1) {
            lz.p(1, this.level);
        }
        if (this.eE != 0) {
            lz.p(2, this.eE);
        }
        if (this.eF != 0) {
            lz.p(3, this.eF);
        }
        super.a(lz);
    }
    
    public c$a b() {
        this.level = 1;
        this.eE = 0;
        this.eF = 0;
        this.amX = null;
        this.anb = -1;
        return this;
    }
    
    @Override
    protected int c() {
        int c = super.c();
        if (this.level != 1) {
            c += lz.r(1, this.level);
        }
        if (this.eE != 0) {
            c += lz.r(2, this.eE);
        }
        if (this.eF != 0) {
            c += lz.r(3, this.eF);
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
            final boolean b2 = o instanceof c$a;
            b = false;
            if (b2) {
                final c$a c$a = (c$a)o;
                final int level = this.level;
                final int level2 = c$a.level;
                b = false;
                if (level == level2) {
                    final int ee = this.eE;
                    final int ee2 = c$a.eE;
                    b = false;
                    if (ee == ee2) {
                        final int ef = this.eF;
                        final int ef2 = c$a.eF;
                        b = false;
                        if (ef == ef2) {
                            if (this.amX == null || this.amX.isEmpty()) {
                                if (c$a.amX != null) {
                                    final boolean empty = c$a.amX.isEmpty();
                                    b = false;
                                    if (!empty) {
                                        return b;
                                    }
                                }
                                return true;
                            }
                            return this.amX.equals(c$a.amX);
                        }
                    }
                }
            }
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        final int n = 31 * (31 * (31 * (527 + this.level) + this.eE) + this.eF);
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
