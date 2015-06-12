// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

final class dn$a extends Exception
{
    private final int pJ;
    
    public dn$a(final String message, final int pj) {
        super(message);
        this.pJ = pj;
    }
    
    public int getErrorCode() {
        return this.pJ;
    }
}
