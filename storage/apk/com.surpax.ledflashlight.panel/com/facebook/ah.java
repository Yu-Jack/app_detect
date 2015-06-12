// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

public final class ah extends ab
{
    private final ae a;
    
    public ah(final ae a, final String s) {
        super(s);
        this.a = a;
    }
    
    public final ae a() {
        return this.a;
    }
    
    @Override
    public final String toString() {
        return "{FacebookServiceException: httpResponseCode: " + this.a.a() + ", facebookErrorCode: " + this.a.b() + ", facebookErrorType: " + this.a.c() + ", message: " + this.a.d() + "}";
    }
}
