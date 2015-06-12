// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons;

import java.util.HashMap;
import org.codehaus.jackson.f.b;
import android.content.Context;
import org.codehaus.jackson.c.o;
import org.codehaus.jackson.c.an;

public abstract class ProtocolBase
{
    private an a;
    
    protected ProtocolBase() {
        (this.a = new an()).a(o.k, false);
    }
    
    public <T> T a(final Context context, final String s, final long n, final String s2, final b<ProtocolBase$InnerData<T>> b) {
        return this.b(new f().a(context, s, n, s2), b);
    }
    
    public <T> T a(final String s, final int n, final b<ProtocolBase$InnerData<T>> b) {
        return this.b(new e().a(s, n), b);
    }
    
    public <T> T a(final String s, final HashMap<String, Object> hashMap, final int n, final b<ProtocolBase$InnerData<T>> b) {
        return this.b(new e().a(s, hashMap, n), b);
    }
    
    public <T> T a(final String s, final b<ProtocolBase$InnerData<T>> b) {
        return (T)this.b(new e().a(s), (b<ProtocolBase$InnerData<Object>>)b);
    }
    
    protected <T> T b(final String s, final b<ProtocolBase$InnerData<T>> b) {
        final ProtocolBase$InnerData protocolBase$InnerData = this.a.a(s, b);
        if (!protocolBase$InnerData.isSucceeded) {
            throw new q(protocolBase$InnerData.cause);
        }
        return (T)protocolBase$InnerData.data;
    }
}
