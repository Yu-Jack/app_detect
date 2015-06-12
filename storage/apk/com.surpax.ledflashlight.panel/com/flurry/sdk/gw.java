// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

public abstract class gw implements gv, Comparable
{
    public int a(final gv gv) {
        return gs.b().a(this, gv, this.a());
    }
    
    @Override
    public abstract fn a();
    
    @Override
    public boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof gv)) {
                return false;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }
            if (this.a((gv)o) != 0) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return gs.b().b(this, this.a());
    }
    
    @Override
    public String toString() {
        return gs.b().a(this);
    }
}
