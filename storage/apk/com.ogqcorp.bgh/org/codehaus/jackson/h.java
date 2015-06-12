// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson;

import org.codehaus.jackson.annotate.JsonProperty;
import java.io.Serializable;

public class h implements Serializable
{
    public static final h a;
    final long b;
    final long c;
    final int d;
    final int e;
    final Object f;
    
    static {
        a = new h("N/A", -1L, -1L, -1, -1);
    }
    
    public h(final Object o, final long n, final int n2, final int n3) {
        this(o, -1L, n, n2, n3);
    }
    
    public h(@JsonProperty("sourceRef") final Object f, @JsonProperty("byteOffset") final long b, @JsonProperty("charOffset") final long c, @JsonProperty("lineNr") final int d, @JsonProperty("columnNr") final int e) {
        this.f = f;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public long a() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        boolean b2;
        if (o == this) {
            b2 = b;
        }
        else {
            b2 = false;
            if (o != null) {
                final boolean b3 = o instanceof h;
                b2 = false;
                if (b3) {
                    final h h = (h)o;
                    if (this.f == null) {
                        final Object f = h.f;
                        b2 = false;
                        if (f != null) {
                            return b2;
                        }
                    }
                    else if (!this.f.equals(h.f)) {
                        return false;
                    }
                    if (this.d != h.d || this.e != h.e || this.c != h.c || this.a() != h.a()) {
                        b = false;
                    }
                    return b;
                }
            }
        }
        return b2;
    }
    
    @Override
    public int hashCode() {
        int hashCode;
        if (this.f == null) {
            hashCode = 1;
        }
        else {
            hashCode = this.f.hashCode();
        }
        return ((hashCode ^ this.d) + this.e ^ (int)this.c) + (int)this.b;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(80);
        sb.append("[Source: ");
        if (this.f == null) {
            sb.append("UNKNOWN");
        }
        else {
            sb.append(this.f.toString());
        }
        sb.append("; line: ");
        sb.append(this.d);
        sb.append(", column: ");
        sb.append(this.e);
        sb.append(']');
        return sb.toString();
    }
}
