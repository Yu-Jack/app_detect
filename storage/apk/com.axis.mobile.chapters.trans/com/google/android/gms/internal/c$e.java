// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

public final class c$e extends ma
{
    private static volatile c$e[] eU;
    public int key;
    public int value;
    
    public c$e() {
        this.j();
    }
    
    public static c$e[] i() {
        Label_0027: {
            if (c$e.eU != null) {
                break Label_0027;
            }
            synchronized (mc.ana) {
                if (c$e.eU == null) {
                    c$e.eU = new c$e[0];
                }
                return c$e.eU;
            }
        }
    }
    
    @Override
    public void a(final lz lz) {
        lz.p(1, this.key);
        lz.p(2, this.value);
        super.a(lz);
    }
    
    @Override
    protected int c() {
        return super.c() + lz.r(1, this.key) + lz.r(2, this.value);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b;
        if (o == this) {
            b = true;
        }
        else {
            final boolean b2 = o instanceof c$e;
            b = false;
            if (b2) {
                final c$e c$e = (c$e)o;
                final int key = this.key;
                final int key2 = c$e.key;
                b = false;
                if (key == key2) {
                    final int value = this.value;
                    final int value2 = c$e.value;
                    b = false;
                    if (value == value2) {
                        if (this.amX == null || this.amX.isEmpty()) {
                            if (c$e.amX != null) {
                                final boolean empty = c$e.amX.isEmpty();
                                b = false;
                                if (!empty) {
                                    return b;
                                }
                            }
                            return true;
                        }
                        return this.amX.equals(c$e.amX);
                    }
                }
            }
        }
        return b;
    }
    
    public c$e f(final ly ly) {
    Label_0049:
        while (true) {
            final int nb = ly.nB();
            switch (nb) {
                default: {
                    if (!this.a(ly, nb)) {
                        break Label_0049;
                    }
                    continue;
                }
                case 0: {
                    break Label_0049;
                }
                case 8: {
                    this.key = ly.nE();
                    continue;
                }
                case 16: {
                    this.value = ly.nE();
                    continue;
                }
            }
        }
        return this;
    }
    
    @Override
    public int hashCode() {
        final int n = 31 * (31 * (527 + this.key) + this.value);
        int hashCode;
        if (this.amX == null || this.amX.isEmpty()) {
            hashCode = 0;
        }
        else {
            hashCode = this.amX.hashCode();
        }
        return hashCode + n;
    }
    
    public c$e j() {
        this.key = 0;
        this.value = 0;
        this.amX = null;
        this.anb = -1;
        return this;
    }
}
