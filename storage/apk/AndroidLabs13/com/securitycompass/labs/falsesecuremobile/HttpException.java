// 
// Decompiled by Procyon v0.5.29
// 

package com.securitycompass.labs.falsesecuremobile;

public class HttpException extends Exception
{
    private int mStatusCode;
    
    public HttpException(final int mStatusCode) {
        this.mStatusCode = mStatusCode;
    }
    
    public int getStatusCode() {
        return this.mStatusCode;
    }
}
