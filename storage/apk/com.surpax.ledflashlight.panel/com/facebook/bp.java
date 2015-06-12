// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

enum bp
{
    a("CREATED_CATEGORY", 0), 
    b("OPENED_CATEGORY", 1), 
    c("CLOSED_CATEGORY", 2);
    
    static {
        d = new bp[] { bp.a, bp.b, bp.c };
    }
    
    private bp(final String name, final int ordinal) {
    }
}
