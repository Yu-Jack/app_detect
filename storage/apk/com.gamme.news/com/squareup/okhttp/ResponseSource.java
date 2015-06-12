// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp;

public enum ResponseSource
{
    CACHE("CACHE", 0), 
    CONDITIONAL_CACHE("CONDITIONAL_CACHE", 1), 
    NETWORK("NETWORK", 2);
    
    private ResponseSource(final String name, final int ordinal) {
    }
    
    public boolean requiresConnection() {
        return this == ResponseSource.CONDITIONAL_CACHE || this == ResponseSource.NETWORK;
    }
}
