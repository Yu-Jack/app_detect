// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a;

import java.util.Collections;
import java.util.Map;

public class c
{
    public byte[] a;
    public String b;
    public long c;
    public long d;
    public long e;
    public Map<String, String> f;
    
    public c() {
        this.f = Collections.emptyMap();
    }
    
    public boolean a() {
        return this.d < System.currentTimeMillis();
    }
    
    public boolean b() {
        return this.e < System.currentTimeMillis();
    }
}
