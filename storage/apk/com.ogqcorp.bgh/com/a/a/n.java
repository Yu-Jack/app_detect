// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a;

import java.util.Collections;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import android.net.Uri;
import android.text.TextUtils;

public abstract class n<T> implements Comparable<n<T>>
{
    private final z a;
    private final int b;
    private final String c;
    private final int d;
    private final r e;
    private Integer f;
    private p g;
    private boolean h;
    private boolean i;
    private boolean j;
    private long k;
    private u l;
    private c m;
    
    public n(final int b, final String c, final r e) {
        z a;
        if (z.a) {
            a = new z();
        }
        else {
            a = null;
        }
        this.a = a;
        this.h = true;
        this.i = false;
        this.j = false;
        this.k = 0L;
        this.m = null;
        this.b = b;
        this.c = c;
        this.e = e;
        this.a(new e());
        int hashCode;
        if (TextUtils.isEmpty((CharSequence)c)) {
            hashCode = 0;
        }
        else {
            hashCode = Uri.parse(c).getHost().hashCode();
        }
        this.d = hashCode;
    }
    
    private byte[] a(final Map<String, String> map, final String s) {
        final StringBuilder sb = new StringBuilder();
        try {
            for (final Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(URLEncoder.encode(entry.getKey(), s));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), s));
                sb.append('&');
            }
        }
        catch (UnsupportedEncodingException cause) {
            throw new RuntimeException("Encoding not supported: " + s, cause);
        }
        return sb.toString().getBytes(s);
    }
    
    public int a() {
        return this.b;
    }
    
    public int a(final n<T> n) {
        final o r = this.r();
        final o r2 = n.r();
        if (r == r2) {
            return this.f - n.f;
        }
        return r2.ordinal() - r.ordinal();
    }
    
    public final n<?> a(final int i) {
        this.f = i;
        return this;
    }
    
    public n<?> a(final c m) {
        this.m = m;
        return this;
    }
    
    public n<?> a(final p g) {
        this.g = g;
        return this;
    }
    
    public n<?> a(final u l) {
        this.l = l;
        return this;
    }
    
    protected abstract q<T> a(final k p0);
    
    protected x a(final x x) {
        return x;
    }
    
    protected abstract void a(final T p0);
    
    public void a(final String s) {
        if (z.a) {
            this.a.a(s, Thread.currentThread().getId());
        }
        else if (this.k == 0L) {
            this.k = SystemClock.elapsedRealtime();
        }
    }
    
    public int b() {
        return this.d;
    }
    
    public void b(final x x) {
        if (this.e != null) {
            this.e.a(x);
        }
    }
    
    void b(final String s) {
        if (this.g != null) {
            this.g.b(this);
        }
        if (z.a) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.a.a(s, id);
                this.a.a(this.toString());
                return;
            }
            new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                @Override
                public void run() {
                    n.this.a.a(s, id);
                    n.this.a.a(this.toString());
                }
            });
        }
        else {
            final long l = SystemClock.elapsedRealtime() - this.k;
            if (l >= 3000L) {
                y.b("%d ms: %s", l, this.toString());
            }
        }
    }
    
    public String c() {
        return this.c;
    }
    
    public String d() {
        return this.c();
    }
    
    public c e() {
        return this.m;
    }
    
    public void f() {
        this.i = true;
    }
    
    public boolean g() {
        return this.i;
    }
    
    public Map<String, String> h() {
        return Collections.emptyMap();
    }
    
    @Deprecated
    protected Map<String, String> i() {
        return this.m();
    }
    
    @Deprecated
    protected String j() {
        return this.n();
    }
    
    @Deprecated
    public String k() {
        return this.o();
    }
    
    @Deprecated
    public byte[] l() {
        final Map<String, String> i = this.i();
        if (i != null && i.size() > 0) {
            return this.a(i, this.j());
        }
        return null;
    }
    
    protected Map<String, String> m() {
        return null;
    }
    
    protected String n() {
        return "UTF-8";
    }
    
    public String o() {
        return "application/x-www-form-urlencoded; charset=" + this.n();
    }
    
    public byte[] p() {
        final Map<String, String> m = this.m();
        if (m != null && m.size() > 0) {
            return this.a(m, this.n());
        }
        return null;
    }
    
    public final boolean q() {
        return this.h;
    }
    
    public o r() {
        return o.b;
    }
    
    public final int s() {
        return this.l.a();
    }
    
    public u t() {
        return this.l;
    }
    
    @Override
    public String toString() {
        final String string = "0x" + Integer.toHexString(this.b());
        final StringBuilder sb = new StringBuilder();
        String str;
        if (this.i) {
            str = "[X] ";
        }
        else {
            str = "[ ] ";
        }
        return sb.append(str).append(this.c()).append(" ").append(string).append(" ").append(this.r()).append(" ").append(this.f).toString();
    }
    
    public void u() {
        this.j = true;
    }
    
    public boolean v() {
        return this.j;
    }
}
