// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.g;

import java.util.Iterator;
import java.util.LinkedList;
import java.io.OutputStream;

public final class d extends OutputStream
{
    private static final byte[] a;
    private final a b;
    private final LinkedList<byte[]> c;
    private int d;
    private byte[] e;
    private int f;
    
    static {
        a = new byte[0];
    }
    
    public d() {
        this(null);
    }
    
    public d(final int n) {
        this(null, n);
    }
    
    public d(final a a) {
        this(a, 500);
    }
    
    public d(final a b, final int n) {
        this.c = new LinkedList<byte[]>();
        this.b = b;
        if (b == null) {
            this.e = new byte[n];
            return;
        }
        this.e = b.a(org.codehaus.jackson.g.b.c);
    }
    
    private void g() {
        int n = 262144;
        this.d += this.e.length;
        final int max = Math.max(this.d >> 1, 1000);
        if (max <= n) {
            n = max;
        }
        this.c.add(this.e);
        this.e = new byte[n];
        this.f = 0;
    }
    
    public void a() {
        this.d = 0;
        this.f = 0;
        if (!this.c.isEmpty()) {
            this.c.clear();
        }
    }
    
    public void a(final int n) {
        if (this.f >= this.e.length) {
            this.g();
        }
        this.e[this.f++] = (byte)n;
    }
    
    public void b(final int n) {
        if (1 + this.f < this.e.length) {
            this.e[this.f++] = (byte)(n >> 8);
            this.e[this.f++] = (byte)n;
            return;
        }
        this.a(n >> 8);
        this.a(n);
    }
    
    public byte[] b() {
        final int i = this.d + this.f;
        if (i == 0) {
            return org.codehaus.jackson.g.d.a;
        }
        final byte[] array = new byte[i];
        final Iterator<byte[]> iterator = this.c.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            final byte[] array2 = iterator.next();
            final int length = array2.length;
            System.arraycopy(array2, 0, array, n, length);
            n += length;
        }
        System.arraycopy(this.e, 0, array, n, this.f);
        final int j = n + this.f;
        if (j != i) {
            throw new RuntimeException("Internal error: total len assumed to be " + i + ", copied " + j + " bytes");
        }
        if (!this.c.isEmpty()) {
            this.a();
        }
        return array;
    }
    
    public void c(final int n) {
        if (2 + this.f < this.e.length) {
            this.e[this.f++] = (byte)(n >> 16);
            this.e[this.f++] = (byte)(n >> 8);
            this.e[this.f++] = (byte)n;
            return;
        }
        this.a(n >> 16);
        this.a(n >> 8);
        this.a(n);
    }
    
    public byte[] c() {
        this.a();
        return this.e;
    }
    
    @Override
    public void close() {
    }
    
    public byte[] d() {
        this.g();
        return this.e;
    }
    
    public byte[] d(final int f) {
        this.f = f;
        return this.b();
    }
    
    public void e(final int f) {
        this.f = f;
    }
    
    public byte[] e() {
        return this.e;
    }
    
    public int f() {
        return this.f;
    }
    
    @Override
    public void flush() {
    }
    
    @Override
    public void write(final int n) {
        this.a(n);
    }
    
    @Override
    public void write(final byte[] array) {
        this.write(array, 0, array.length);
    }
    
    @Override
    public void write(final byte[] array, int n, int b) {
        while (true) {
            final int min = Math.min(this.e.length - this.f, b);
            if (min > 0) {
                System.arraycopy(array, n, this.e, this.f, min);
                n += min;
                this.f += min;
                b -= min;
            }
            if (b <= 0) {
                break;
            }
            this.g();
        }
    }
}
