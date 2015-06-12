// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a.a;

import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public final class g extends HttpEntityEnclosingRequestBase
{
    public g() {
    }
    
    public g(final String str) {
        this.setURI(URI.create(str));
    }
    
    public String getMethod() {
        return "PATCH";
    }
}
