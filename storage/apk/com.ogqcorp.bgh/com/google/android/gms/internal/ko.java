// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

public class ko
{
    private final byte[] a;
    private int b;
    private int c;
    
    public ko(final byte[] array) {
        this.a = new byte[256];
        for (int i = 0; i < 256; ++i) {
            this.a[i] = (byte)i;
        }
        int n = 0;
        for (int j = 0; j < 256; ++j) {
            n = (0xFF & n + this.a[j] + array[j % array.length]);
            final byte b = this.a[j];
            this.a[j] = this.a[n];
            this.a[n] = b;
        }
        this.b = 0;
        this.c = 0;
    }
    
    public void a(final byte[] array) {
        int b = this.b;
        int c = this.c;
        for (int i = 0; i < array.length; ++i) {
            b = (0xFF & b + 1);
            c = (0xFF & c + this.a[b]);
            final byte b2 = this.a[b];
            this.a[b] = this.a[c];
            this.a[c] = b2;
            array[i] ^= this.a[0xFF & this.a[b] + this.a[c]];
        }
        this.b = b;
        this.c = c;
    }
}
