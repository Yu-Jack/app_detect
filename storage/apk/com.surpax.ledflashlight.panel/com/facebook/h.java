// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

enum h
{
    a("EXPLICIT", 0), 
    b("TIMER", 1), 
    c("SESSION_CHANGE", 2), 
    d("PERSISTED_EVENTS", 3), 
    e("EVENT_THRESHOLD", 4), 
    f("EAGER_FLUSHING_EVENT", 5);
    
    static {
        g = new h[] { h.a, h.b, h.c, h.d, h.e, h.f };
    }
    
    private h(final String name, final int ordinal) {
    }
}
