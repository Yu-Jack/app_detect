// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.b;

import org.codehaus.jackson.f.a;
import org.codehaus.jackson.c.z;

public abstract class t
{
    public Object a(final double n) {
        throw new z("Can not instantiate value of type " + this.a() + " from JSON floating-point number");
    }
    
    public Object a(final int n) {
        throw new z("Can not instantiate value of type " + this.a() + " from JSON int number");
    }
    
    public Object a(final long n) {
        throw new z("Can not instantiate value of type " + this.a() + " from JSON long number");
    }
    
    public Object a(final Object o) {
        throw new z("Can not instantiate value of type " + this.a() + " using delegate");
    }
    
    public Object a(final String s) {
        throw new z("Can not instantiate value of type " + this.a() + " from JSON String");
    }
    
    public Object a(final boolean b) {
        throw new z("Can not instantiate value of type " + this.a() + " from JSON boolean value");
    }
    
    public Object a(final Object[] array) {
        throw new z("Can not instantiate value of type " + this.a() + " with arguments");
    }
    
    public abstract String a();
    
    public boolean b() {
        return this.h() || this.i() || this.j() || this.c() || this.d() || this.e() || this.f() || this.g();
    }
    
    public boolean c() {
        return false;
    }
    
    public boolean d() {
        return false;
    }
    
    public boolean e() {
        return false;
    }
    
    public boolean f() {
        return false;
    }
    
    public boolean g() {
        return false;
    }
    
    public boolean h() {
        return this.n() != null;
    }
    
    public boolean i() {
        return this.l() != null;
    }
    
    public boolean j() {
        return false;
    }
    
    public i[] k() {
        return null;
    }
    
    public a l() {
        return null;
    }
    
    public Object m() {
        throw new z("Can not instantiate value of type " + this.a() + "; no default creator found");
    }
    
    public org.codehaus.jackson.c.e.i n() {
        return null;
    }
    
    public org.codehaus.jackson.c.e.i o() {
        return null;
    }
}
