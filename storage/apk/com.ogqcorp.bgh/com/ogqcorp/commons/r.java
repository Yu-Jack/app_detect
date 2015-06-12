// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons;

import org.codehaus.jackson.f.b;
import android.content.Context;

public abstract class r extends ProtocolBase
{
    private d<Object, Object, Object> a;
    
    public <T> void a(final Context context, final int n, final String s, final long l, final String s2, final b<ProtocolBase$InnerData<T>> b, final u<T> u, final u<Exception> u2) {
        this.a = new s<T>(u, u2) {
            @Override
            protected Object a(final Object... array) {
                return r.this.a((Context)array[0], (String)array[1], (long)array[2], (String)array[3], (b<ProtocolBase$InnerData<Object>>)array[4]);
            }
        };
        final Context applicationContext = context.getApplicationContext();
        this.a.a(applicationContext, n, applicationContext, s, l, s2, b);
    }
    
    public <T> void a(final Context context, final int n, final String s, final b<ProtocolBase$InnerData<T>> b, final u<T> u, final u<Exception> u2) {
        (this.a = new s<T>(u, u2) {
            @Override
            protected Object a(final Object... array) {
                return r.this.a((String)array[0], (b<ProtocolBase$InnerData<Object>>)array[1]);
            }
        }).a(context.getApplicationContext(), n, s, b);
    }
    
    public void a(final boolean b) {
        if (this.a != null) {
            this.a.cancel(b);
            this.a = null;
        }
    }
}
