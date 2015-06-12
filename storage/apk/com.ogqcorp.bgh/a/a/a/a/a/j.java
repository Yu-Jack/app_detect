// 
// Decompiled by Procyon v0.5.29
// 

package a.a.a.a.a;

import java.util.Collections;
import java.util.Collection;
import a.a.a.a.a.a.d;
import java.io.File;
import a.a.a.c.a;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.nio.charset.Charset;

public class j
{
    private static final char[] a;
    private String b;
    private e c;
    private String d;
    private Charset e;
    private List<b> f;
    
    static {
        a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }
    
    j() {
        this.b = "form-data";
        this.c = a.a.a.a.a.e.a;
        this.d = null;
        this.e = null;
        this.f = null;
    }
    
    public static j a() {
        return new j();
    }
    
    private String a(final String str, final Charset charset) {
        final StringBuilder sb = new StringBuilder();
        sb.append("multipart/form-data; boundary=");
        sb.append(str);
        if (charset != null) {
            sb.append("; charset=");
            sb.append(charset.name());
        }
        return sb.toString();
    }
    
    private String d() {
        final StringBuilder sb = new StringBuilder();
        final Random random = new Random();
        for (int n = 30 + random.nextInt(11), i = 0; i < n; ++i) {
            sb.append(j.a[random.nextInt(j.a.length)]);
        }
        return sb.toString();
    }
    
    j a(final b b) {
        if (b == null) {
            return this;
        }
        if (this.f == null) {
            this.f = new ArrayList<b>();
        }
        this.f.add(b);
        return this;
    }
    
    public j a(final e c) {
        this.c = c;
        return this;
    }
    
    public j a(final String s, final a.a.a.a.a.a.b b) {
        a.a.a.c.a.a(s, "Name");
        a.a.a.c.a.a(b, "Content body");
        return this.a(new b(s, b));
    }
    
    public j a(final String s, final File file) {
        final a.a.a.a.a n = a.a.a.a.a.n;
        String name;
        if (file != null) {
            name = file.getName();
        }
        else {
            name = null;
        }
        return this.a(s, file, n, name);
    }
    
    public j a(final String s, final File file, final a.a.a.a.a a, final String s2) {
        return this.a(s, new d(file, a, s2));
    }
    
    public j a(final String s, final String s2) {
        return this.a(s, s2, a.a.a.a.a.m);
    }
    
    public j a(final String s, final String s2, final a.a.a.a.a a) {
        return this.a(s, new a.a.a.a.a.a.e(s2, a));
    }
    
    k b() {
        String b;
        if (this.b != null) {
            b = this.b;
        }
        else {
            b = "form-data";
        }
        final Charset e = this.e;
        String s;
        if (this.d != null) {
            s = this.d;
        }
        else {
            s = this.d();
        }
        List<b> emptyList;
        if (this.f != null) {
            emptyList = new ArrayList<b>(this.f);
        }
        else {
            emptyList = Collections.emptyList();
        }
        e e2;
        if (this.c != null) {
            e2 = this.c;
        }
        else {
            e2 = a.a.a.a.a.e.a;
        }
        a.a.a.a.a.a a = null;
        switch (j$1.a[e2.ordinal()]) {
            default: {
                a = new g(b, e, s, emptyList);
                break;
            }
            case 1: {
                a = new a.a.a.a.a.d(b, e, s, emptyList);
                break;
            }
            case 2: {
                a = new f(b, e, s, emptyList);
                break;
            }
        }
        return new k(a, this.a(s, e), a.c());
    }
    
    public a.a.a.d c() {
        return this.b();
    }
}
