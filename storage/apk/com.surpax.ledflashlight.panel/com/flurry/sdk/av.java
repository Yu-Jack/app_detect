// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

public class av extends aw
{
    private static final String a;
    private final ex b;
    
    static {
        a = aw.class.getSimpleName();
    }
    
    public av(final ex b, final String s, final long n, final boolean b2) {
        super(s, n, b2);
        if (b == null) {
            throw new IllegalArgumentException("Serializer cannot be null");
        }
        this.b = b;
    }
}
