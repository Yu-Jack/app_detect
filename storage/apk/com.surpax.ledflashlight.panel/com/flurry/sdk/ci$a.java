// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Map;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class ci$a
{
    private ci a;
    
    public ci$a() {
        this.a = new ci(null);
    }
    
    public ci$a a() {
        this.a.d = true;
        return this;
    }
    
    public ci$a a(final int n) {
        this.a.a = n;
        return this;
    }
    
    public ci$a a(final List list) {
        this.a.b = list;
        return this;
    }
    
    public ci$a a(final boolean b) {
        this.a.c = b;
        return this;
    }
    
    public ci b() {
        return this.a;
    }
}
