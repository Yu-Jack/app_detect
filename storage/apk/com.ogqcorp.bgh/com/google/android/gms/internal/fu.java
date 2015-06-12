// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

public final class fu
{
    public final int a;
    public final int b;
    
    public fu(final int a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (!(o instanceof fu)) {
            b = false;
        }
        else if (this != o) {
            final fu fu = (fu)o;
            if (fu.a != this.a || fu.b != this.b) {
                return false;
            }
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        return gw.a(this.a, this.b);
    }
}
