// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.e;

final class e
{
    private final String a;
    private final e b;
    private final int c;
    
    public e(final String a, final e b) {
        this.a = a;
        this.b = b;
        int c;
        if (b == null) {
            c = 1;
        }
        else {
            c = 1 + b.c;
        }
        this.c = c;
    }
    
    public String a() {
        return this.a;
    }
    
    public String a(final char[] array, final int n, final int n2) {
        String s = this.a;
        e e = this.b;
        while (true) {
            if (s.length() == n2) {
                int index = 0;
                while (s.charAt(index) == array[n + index] && ++index < n2) {}
                if (index == n2) {
                    return s;
                }
            }
            if (e == null) {
                return null;
            }
            s = e.a();
            e = e.b();
        }
    }
    
    public e b() {
        return this.b;
    }
    
    public int c() {
        return this.c;
    }
}
