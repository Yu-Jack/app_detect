// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Map;

public class a
{
    public final String a;
    public final Map b;
    public final q c;
    
    public a(final String a, final Map b, final q c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("action=");
        sb.append(this.a);
        sb.append(",params=");
        sb.append(this.b);
        sb.append(",");
        sb.append(this.c);
        return sb.toString();
    }
}
