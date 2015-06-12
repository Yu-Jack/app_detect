// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import java.util.Locale;

public final class aa extends Exception
{
    private int a;
    private int b;
    
    public aa(final int a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public String toString() {
        return String.format(Locale.US, "%s: %dx%d", this.getClass().getSimpleName(), this.a, this.b);
    }
}
