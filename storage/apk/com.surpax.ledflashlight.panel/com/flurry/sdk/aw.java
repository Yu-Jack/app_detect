// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.io.IOException;
import java.io.Closeable;

public class aw
{
    private static final String a;
    private final String b;
    private final long c;
    private final boolean d;
    private fh e;
    
    static {
        a = aw.class.getSimpleName();
    }
    
    public aw(final String b, final long c, final boolean d) {
        if (b == null || b.length() == 0) {
            throw new IllegalArgumentException("The cache must have a name");
        }
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public aw$b a(final String str) {
        if (this.e == null || str == null) {
            return null;
        }
        while (true) {
            try {
                final fh$c a = this.e.a(ce.c(str));
                if (a != null) {
                    return new aw$b(this, a, this.d, null);
                }
            }
            catch (IOException ex) {
                eo.a(3, aw.a, "Exception during get for cache: " + this.b + " key: " + str, ex);
                fe.a((Closeable)null);
                return null;
            }
            return null;
        }
    }
    
    public void a() {
        try {
            this.e = fh.a(ce.a(this.b), 1, 1, this.c);
        }
        catch (IOException ex) {
            eo.a(3, aw.a, "Could not open cache: " + this.b);
        }
    }
    
    public aw$c b(final String str) {
        if (this.e == null || str == null) {
            return null;
        }
        while (true) {
            try {
                final fh$a b = this.e.b(ce.c(str));
                if (b != null) {
                    return new aw$c(this, b, this.d, null);
                }
            }
            catch (IOException ex) {
                eo.a(3, aw.a, "Exception during get for cache: " + this.b + " key: " + str, ex);
                fe.a((Closeable)null);
                return null;
            }
            return null;
        }
    }
    
    public void b() {
        fe.a(this.e);
    }
    
    public void c() {
        this.d();
        this.a();
    }
    
    public boolean c(final String str) {
        if (this.e == null || str == null) {
            return false;
        }
        try {
            return this.e.c(ce.c(str));
        }
        catch (IOException ex) {
            eo.a(3, aw.a, "Exception during remove for cache: " + this.b + " key: " + str, ex);
            return false;
        }
    }
    
    public void d() {
        if (this.e == null) {
            return;
        }
        try {
            this.e.a();
        }
        catch (IOException ex) {
            eo.a(3, aw.a, "Exception during delete for cache: " + this.b, ex);
        }
    }
    
    public boolean d(final String s) {
        if (this.e == null || s == null) {
            return false;
        }
        try {
            final fh$c a = this.e.a(ce.c(s));
            boolean b = false;
            if (a != null) {
                b = true;
            }
            fe.a(a);
            return b;
        }
        catch (IOException ex) {
            eo.a(3, aw.a, "Exception during exists for cache: " + this.b, ex);
            return false;
        }
        finally {
            fe.a((Closeable)null);
        }
    }
    
    @Override
    protected void finalize() {
        super.finalize();
        this.b();
    }
}
