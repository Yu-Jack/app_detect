// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a.a;

import com.a.a.y;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import com.a.a.c;
import java.util.Map;

class d
{
    public long a;
    public String b;
    public String c;
    public long d;
    public long e;
    public long f;
    public Map<String, String> g;
    
    private d() {
    }
    
    public d(final String b, final c c) {
        this.b = b;
        this.a = c.a.length;
        this.c = c.b;
        this.d = c.c;
        this.e = c.d;
        this.f = c.e;
        this.g = c.f;
    }
    
    public static d a(final InputStream inputStream) {
        final d d = new d();
        if (com.a.a.a.c.a(inputStream) != 538051844) {
            throw new IOException();
        }
        d.b = com.a.a.a.c.c(inputStream);
        d.c = com.a.a.a.c.c(inputStream);
        if (d.c.equals("")) {
            d.c = null;
        }
        d.d = com.a.a.a.c.b(inputStream);
        d.e = com.a.a.a.c.b(inputStream);
        d.f = com.a.a.a.c.b(inputStream);
        d.g = com.a.a.a.c.d(inputStream);
        return d;
    }
    
    public c a(final byte[] a) {
        final c c = new c();
        c.a = a;
        c.b = this.c;
        c.c = this.d;
        c.d = this.e;
        c.e = this.f;
        c.f = this.g;
        return c;
    }
    
    public boolean a(final OutputStream outputStream) {
        try {
            com.a.a.a.c.a(outputStream, 538051844);
            com.a.a.a.c.a(outputStream, this.b);
            String c;
            if (this.c == null) {
                c = "";
            }
            else {
                c = this.c;
            }
            com.a.a.a.c.a(outputStream, c);
            com.a.a.a.c.a(outputStream, this.d);
            com.a.a.a.c.a(outputStream, this.e);
            com.a.a.a.c.a(outputStream, this.f);
            com.a.a.a.c.a(this.g, outputStream);
            outputStream.flush();
            return true;
        }
        catch (IOException ex) {
            y.b("%s", ex.toString());
            return false;
        }
    }
}
