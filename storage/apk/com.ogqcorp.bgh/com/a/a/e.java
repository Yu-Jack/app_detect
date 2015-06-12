// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a;

public class e implements u
{
    private int a;
    private int b;
    private final int c;
    private final float d;
    
    public e() {
        this(2500, 1, 1.0f);
    }
    
    public e(final int a, final int c, final float d) {
        this.a = a;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public int a() {
        return this.a;
    }
    
    @Override
    public void a(final x x) {
        ++this.b;
        this.a += (int)(this.a * this.d);
        if (!this.c()) {
            throw x;
        }
    }
    
    @Override
    public int b() {
        return this.b;
    }
    
    protected boolean c() {
        return this.b <= this.c;
    }
}
