// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

public final class h
{
    private static h e;
    private int a;
    private boolean b;
    private boolean c;
    private boolean d;
    
    public h() {
        this.a = 8;
        this.b = true;
        this.c = false;
        this.d = false;
    }
    
    public static h a() {
        if (h.e == null) {
            h.e = new h();
        }
        return h.e;
    }
    
    public int b() {
        return this.a--;
    }
    
    public boolean c() {
        return this.b;
    }
    
    public void d() {
        this.b = !this.b;
    }
    
    public boolean e() {
        return this.c;
    }
    
    public void f() {
        this.c = !this.c;
    }
    
    public boolean g() {
        return this.d;
    }
    
    public void h() {
        this.d = !this.d;
    }
    
    public String i() {
        final Object[] args = new Object[3];
        String s;
        if (this.b) {
            s = "Yes";
        }
        else {
            s = "No";
        }
        args[0] = s;
        String s2;
        if (this.c) {
            s2 = "Yes";
        }
        else {
            s2 = "No";
        }
        args[1] = s2;
        String s3;
        if (this.d) {
            s3 = "Yes";
        }
        else {
            s3 = "No";
        }
        args[2] = s3;
        return String.format("isShowAds: %s / isIgnoreWMSP: %s / isIgnoreSWI: %s", args);
    }
}
