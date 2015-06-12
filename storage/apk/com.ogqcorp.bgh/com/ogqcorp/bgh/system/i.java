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

public final class i
{
    private static i a;
    private boolean b;
    private an c;
    private a<Background> d;
    
    private i() {
        (this.c = new an()).a(o.k, false);
        this.e();
    }
    
    public static i a() {
        if (i.a == null) {
            i.a = new i();
        }
        return i.a;
    }
    
    private void e() {
        final File e = com.ogqcorp.bgh.system.o.b().e();
        while (true) {
            try {
                this.d = (a<Background>)this.c.a(e, new b<a<Background>>() {});
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
        final File e = com.ogqcorp.bgh.system.o.b().e();
        try {
            this.c.a(e, this.d);
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
    
    public void b(final Background background) {
        synchronized (this) {
            background.setHistoryDate(System.currentTimeMillis());
            this.d.add(0, background);
            this.f();
            this.b = true;
        }
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
            this.d.remove(background);
            this.f();
            this.b = true;
        }
    }
    
    public boolean d() {
        return this.b;
    }
}
