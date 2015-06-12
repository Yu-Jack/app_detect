// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import java.util.Iterator;
import com.google.android.gms.internal.ef;
import java.util.List;
import java.util.Map;

class ba
{
    private final Map<String, String> a;
    private final long b;
    private final String c;
    private final List<ef> d;
    
    public ba(final Map<String, String> a, final long b, final String c, final List<ef> d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public Map<String, String> a() {
        return this.a;
    }
    
    public long b() {
        return this.b;
    }
    
    public String c() {
        return this.c;
    }
    
    public List<ef> d() {
        return this.d;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PATH: ");
        sb.append(this.c);
        if (this.a != null) {
            sb.append("  PARAMS: ");
            for (final Map.Entry<String, String> entry : this.a.entrySet()) {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append(",  ");
            }
        }
        return sb.toString();
    }
}
