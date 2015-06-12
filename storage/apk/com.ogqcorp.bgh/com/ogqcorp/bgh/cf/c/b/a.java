// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.c.b;

import java.io.IOException;
import com.a.a.y;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import com.a.a.x;
import com.a.a.m;
import com.a.a.a.h;
import com.a.a.q;
import com.a.a.k;
import java.util.Iterator;
import a.a.a.a.a.e;
import java.util.Map;
import java.io.File;
import a.a.a.a.a.j;
import org.codehaus.jackson.c.o;
import com.a.a.r;
import org.codehaus.jackson.f.a;
import com.a.a.s;
import a.a.a.d;
import java.util.HashMap;
import org.codehaus.jackson.c.an;
import com.a.a.n;

public class a<T> extends n<T>
{
    private static an a;
    private HashMap<String, String> b;
    private d c;
    private final s<T> d;
    private org.codehaus.jackson.f.a e;
    
    static {
        com.ogqcorp.bgh.cf.c.b.a.a = new an();
    }
    
    public a(final int n, final String s, final HashMap<String, Object> hashMap, final boolean b, final s<T> d, final org.codehaus.jackson.f.a e, final r r) {
        super(n, s, r);
        com.ogqcorp.bgh.cf.c.b.a.a.a(o.k, false);
        if (n == 1 || n == 2) {
            this.a(hashMap, b);
        }
        this.d = d;
        this.e = e;
    }
    
    private void a(final j j, final String s, final Object o) {
        if (o instanceof File) {
            j.a(s, (File)o);
            return;
        }
        j.a(s, o.toString());
    }
    
    private void a(final HashMap<String, Object> hashMap, final boolean b) {
        if (hashMap != null) {
            if (!b) {
                this.b = new HashMap<String, String>();
                for (final Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    final Object value = entry.getValue();
                    if (value != null) {
                        this.b.put(entry.getKey(), value.toString());
                    }
                }
            }
            else {
                final j a = a.a.a.a.a.j.a();
                a.a(a.a.a.a.a.e.b);
                for (final Map.Entry<String, Object> entry2 : hashMap.entrySet()) {
                    final Object value2 = entry2.getValue();
                    if (value2 != null) {
                        this.a(a, entry2.getKey(), value2);
                    }
                }
                this.c = a.c();
            }
        }
    }
    
    @Override
    protected q<T> a(final k k) {
        try {
            return q.a(com.ogqcorp.bgh.cf.c.b.a.a.a(k.b, this.e), com.a.a.a.h.a(k));
        }
        catch (Exception ex) {
            return q.a(new m(ex));
        }
    }
    
    @Override
    protected void a(final T t) {
        if (this.d != null) {
            this.d.a(t);
        }
    }
    
    @Override
    public Map<String, String> h() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("Accept", "application/json");
        return hashMap;
    }
    
    @Override
    protected Map<String, String> m() {
        if (this.b != null) {
            return this.b;
        }
        return null;
    }
    
    @Override
    public String o() {
        if (this.c != null) {
            return this.c.a().c();
        }
        return super.o();
    }
    
    @Override
    public byte[] p() {
        if (this.c != null) {
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                this.c.a(byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            }
            catch (IOException ex) {
                y.c("IOException writing to ByteArrayOutputStream", new Object[0]);
                return byteArrayOutputStream.toByteArray();
            }
        }
        return super.p();
    }
}
