// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import java.util.List;
import java.io.File;
import org.codehaus.jackson.f.b;
import org.codehaus.jackson.c.o;
import com.ogqcorp.bgh.item.Background;
import com.ogqcorp.commons.a;
import org.codehaus.jackson.c.an;

public final class g
{
    private static g a;
    private boolean b;
    private an c;
    private a<Background> d;
    
    private g() {
        (this.c = new an()).a(o.k, false);
        this.e();
    }
    
    public static g a() {
        if (g.a == null) {
            g.a = new g();
        }
        return g.a;
    }
    
    private void e() {
        final File d = com.ogqcorp.bgh.system.o.b().d();
        while (true) {
            try {
                this.d = (a<Background>)this.c.a(d, new b<a<Background>>() {});
                this.b = true;
            }
            catch (Exception ex) {
                this.d = new a<Background>();
                continue;
            }
            break;
        }
    }
    
    private void f() {
        final File d = com.ogqcorp.bgh.system.o.b().d();
        try {
            this.c.a(d, this.d);
        }
        catch (Exception ex) {
            l.c(ex);
        }
    }
    
    public void a(final boolean b) {
        this.b = b;
    }
    
    public boolean a(final Background background) {
        return this.d.contains(background);
    }
    
    public List<Background> b() {
        return this.d;
    }
    
    public boolean b(final Background background) {
        if (!this.a(background)) {
            this.c(background);
            return true;
        }
        this.d(background);
        return false;
    }
    
    public void c() {
        synchronized (this) {
            this.d.clear();
            this.f();
            this.b = true;
        }
    }
    
    public void c(final Background background) {
        synchronized (this) {
            this.d.add(0, background);
            this.f();
            this.b = true;
        }
    }
    
    public void d(final Background background) {
        synchronized (this) {
            this.d.remove(background);
            this.f();
            this.b = true;
        }
    }
    
    public boolean d() {
        return this.b;
    }
}
