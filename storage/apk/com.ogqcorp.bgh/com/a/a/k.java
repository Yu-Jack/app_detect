// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a;

import java.util.Map;

public class k
{
    public final int a;
    public final byte[] b;
    public final Map<String, String> c;
    public final boolean d;
    
    public k(final int a, final byte[] b, final Map<String, String> c, final boolean d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public k(final byte[] array, final Map<String, String> map) {
        this(200, array, map, false);
    }
}
