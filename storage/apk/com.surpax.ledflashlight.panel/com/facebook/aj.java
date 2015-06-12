// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

public enum aj
{
    a("GET", 0), 
    b("POST", 1), 
    c("DELETE", 2);
    
    static {
        d = new aj[] { aj.a, aj.b, aj.c };
    }
    
    private aj(final String name, final int ordinal) {
    }
}
