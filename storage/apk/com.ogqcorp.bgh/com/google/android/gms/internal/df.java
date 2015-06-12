// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.RemoteException;

public abstract class df extends ed
{
    private final cx a;
    private final de b;
    
    public df(final cx a, final de b) {
        this.a = a;
        this.b = b;
    }
    
    private static cz a(final dm dm, final cx cx) {
        try {
            return dm.a(cx);
        }
        catch (RemoteException ex) {
            en.c("Could not fetch ad response from ad request service.", (Throwable)ex);
            return null;
        }
    }
    
    @Override
    public final void a() {
        try {
            final dm d = this.d();
            cz a;
            if (d == null) {
                a = new cz(0);
            }
            else {
                a = a(d, this.a);
                if (a == null) {
                    a = new cz(0);
                }
            }
            this.c();
            this.b.a(a);
        }
        finally {
            this.c();
        }
    }
    
    @Override
    public final void b() {
        this.c();
    }
    
    public abstract void c();
    
    public abstract dm d();
}
