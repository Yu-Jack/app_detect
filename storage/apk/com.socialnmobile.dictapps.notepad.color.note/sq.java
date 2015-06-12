import java.util.Collections;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

// 
// Decompiled by Procyon v0.5.29
// 

public final class sq
{
    public final HashMap a;
    public final HashMap b;
    public final HashMap c;
    public final HashMap d;
    
    public sq() {
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
    }
    
    public sq(final HashMap m, final HashMap i, final HashMap j, final HashMap k) {
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        if (m != null) {
            this.a.putAll(m);
        }
        if (i != null) {
            this.b.putAll(i);
        }
        if (j != null) {
            this.c.putAll(j);
        }
        if (k != null) {
            this.d.putAll(k);
        }
    }
    
    public static List a(final Set c) {
        final ArrayList<Comparable> list = new ArrayList<Comparable>(c);
        Collections.sort(list);
        return list;
    }
    
    public final HashMap a(final sl obj) {
        if (obj == sl.a) {
            return this.a;
        }
        if (obj == sl.c) {
            return this.b;
        }
        if (obj == sl.b) {
            return this.c;
        }
        if (obj == sl.d) {
            return this.d;
        }
        throw new IllegalArgumentException("unsupported authority: " + obj);
    }
}
