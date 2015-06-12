// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b;

import org.codehaus.jackson.c.i.r;
import org.codehaus.jackson.c.q;
import org.codehaus.jackson.c.x;
import org.codehaus.jackson.c.c.a;
import org.codehaus.jackson.c.z;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import org.codehaus.jackson.c.f;
import org.codehaus.jackson.c.n;
import java.text.DateFormat;
import org.codehaus.jackson.c.i.s;
import org.codehaus.jackson.c.i.b;
import org.codehaus.jackson.c.w;
import org.codehaus.jackson.c.t;
import org.codehaus.jackson.k;
import org.codehaus.jackson.c.p;

public class p extends org.codehaus.jackson.c.p
{
    protected k c;
    protected final t d;
    protected final w e;
    protected b f;
    protected s g;
    protected DateFormat h;
    
    public p(final n n, final k c, final t d, final w e) {
        super(n);
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    @Override
    public Object a(final Object obj, final f f, final Object o) {
        if (this.e == null) {
            throw new IllegalStateException("No 'injectableValues' configured, can not inject value with id [" + obj + "]");
        }
        return this.e.a(obj, this, f, o);
    }
    
    @Override
    public Calendar a(final Date time) {
        final Calendar instance = Calendar.getInstance();
        instance.setTime(time);
        return instance;
    }
    
    @Override
    public Date a(final String source) {
        try {
            return this.i().parse(source);
        }
        catch (ParseException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
    
    @Override
    public z a(final Class<?> clazz, final String str) {
        return z.a(this.c, "Can not construct instance of " + clazz.getName() + ", problem: " + str);
    }
    
    @Override
    public z a(final Class<?> clazz, final String s, final String str) {
        return z.a(this.c, "Can not construct Map key of type " + clazz.getName() + " from String \"" + this.c(s) + "\": " + str);
    }
    
    @Override
    public z a(final Class<?> clazz, final Throwable t) {
        return z.a(this.c, "Can not construct instance of " + clazz.getName() + ", problem: " + t.getMessage(), t);
    }
    
    @Override
    public z a(final Class<?> clazz, final org.codehaus.jackson.p obj) {
        return z.a(this.c, "Can not deserialize instance of " + this.c(clazz) + " out of " + obj + " token");
    }
    
    @Override
    public z a(final Object o, final String s) {
        return org.codehaus.jackson.c.c.a.a(this.c, o, s);
    }
    
    @Override
    public z a(final org.codehaus.jackson.f.a obj, final String str) {
        return z.a(this.c, "Could not resolve type id '" + str + "' into a subtype of " + obj);
    }
    
    @Override
    public z a(final k k, final org.codehaus.jackson.p obj, final String str) {
        return z.a(k, "Unexpected token (" + k.e() + "), expected " + obj + ": " + str);
    }
    
    @Override
    public final void a(final s g) {
        if (this.g == null || g.b() >= this.g.b()) {
            this.g = g;
        }
    }
    
    @Override
    public boolean a(final k c, final x<?> x, final Object o, final String s) {
        final r<q> f = this.a.f();
        if (f == null) {
            return false;
        }
        final k c2 = this.c;
        this.c = c;
        r<q> a = f;
        while (true) {
            if (a == null) {
                return false;
            }
            try {
                if (a.b().a(this, x, o, s)) {
                    return true;
                }
                a = a.a();
                continue;
            }
            finally {
                this.c = c2;
            }
            break;
        }
    }
    
    @Override
    public t b() {
        return this.d;
    }
    
    @Override
    public z b(final Class<?> clazz) {
        return this.a(clazz, this.c.e());
    }
    
    @Override
    public z b(final Class<?> clazz, final String str) {
        return z.a(this.c, "Can not construct instance of " + clazz.getName() + " from String value '" + this.j() + "': " + str);
    }
    
    protected String c(final Class<?> clazz) {
        if (clazz.isArray()) {
            return this.c(clazz.getComponentType()) + "[]";
        }
        return clazz.getName();
    }
    
    protected String c(String string) {
        if (string.length() > 500) {
            string = string.substring(0, 500) + "]...[" + string.substring(-500 + string.length());
        }
        return string;
    }
    
    @Override
    public z c(final Class<?> clazz, final String str) {
        return z.a(this.c, "Can not construct instance of " + clazz.getName() + " from number value (" + this.j() + "): " + str);
    }
    
    @Override
    public k d() {
        return this.c;
    }
    
    @Override
    public final s g() {
        final s g = this.g;
        if (g == null) {
            return new s();
        }
        this.g = null;
        return g;
    }
    
    @Override
    public final b h() {
        if (this.f == null) {
            this.f = new b();
        }
        return this.f;
    }
    
    protected DateFormat i() {
        if (this.h == null) {
            this.h = (DateFormat)this.a.n().clone();
        }
        return this.h;
    }
    
    protected String j() {
        try {
            return this.c(this.c.k());
        }
        catch (Exception ex) {
            return "[N/A]";
        }
    }
}
