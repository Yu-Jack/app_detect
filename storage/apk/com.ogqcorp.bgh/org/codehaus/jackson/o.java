// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson;

public abstract class o
{
    protected int a;
    protected int b;
    
    public final boolean a() {
        return this.a == 1;
    }
    
    public final boolean b() {
        return this.a == 0;
    }
    
    public final boolean c() {
        return this.a == 2;
    }
    
    public final String d() {
        switch (this.a) {
            default: {
                return "?";
            }
            case 0: {
                return "ROOT";
            }
            case 1: {
                return "ARRAY";
            }
            case 2: {
                return "OBJECT";
            }
        }
    }
    
    public final int e() {
        return 1 + this.b;
    }
    
    public final int f() {
        if (this.b < 0) {
            return 0;
        }
        return this.b;
    }
}
