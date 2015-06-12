// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

public enum WebRequest$HttpMethod
{
    GET("GET", 0, "GET"), 
    POST("POST", 1, "POST");
    
    private final String methodString;
    
    private WebRequest$HttpMethod(final String name, final int ordinal, final String methodString) {
        this.methodString = methodString;
    }
    
    @Override
    public final String toString() {
        return this.methodString;
    }
}
