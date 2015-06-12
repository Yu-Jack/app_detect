// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

public final class gw$a
{
    public final int FS;
    public final int FT;
    
    public gw$a(final int fs, final int ft) {
        this.FS = fs;
        this.FT = ft;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (!(o instanceof gw$a)) {
            b = false;
        }
        else if (this != o) {
            final gw$a gw$a = (gw$a)o;
            if (gw$a.FS != this.FS || gw$a.FT != this.FT) {
                return false;
            }
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        return hk.hashCode(this.FS, this.FT);
    }
}
