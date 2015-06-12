// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.spdy;

enum HeadersMode
{
    HTTP_20_HEADERS("HTTP_20_HEADERS", 3), 
    SPDY_HEADERS("SPDY_HEADERS", 2), 
    SPDY_REPLY("SPDY_REPLY", 1), 
    SPDY_SYN_STREAM("SPDY_SYN_STREAM", 0);
    
    private HeadersMode(final String name, final int ordinal) {
    }
    
    public boolean failIfHeadersAbsent() {
        return this == HeadersMode.SPDY_HEADERS;
    }
    
    public boolean failIfHeadersPresent() {
        return this == HeadersMode.SPDY_REPLY;
    }
    
    public boolean failIfStreamAbsent() {
        return this == HeadersMode.SPDY_REPLY || this == HeadersMode.SPDY_HEADERS;
    }
    
    public boolean failIfStreamPresent() {
        return this == HeadersMode.SPDY_SYN_STREAM;
    }
}
