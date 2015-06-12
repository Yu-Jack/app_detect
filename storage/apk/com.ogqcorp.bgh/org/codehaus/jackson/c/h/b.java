// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.h;

public final class b implements Comparable<b>
{
    private String a;
    private Class<?> b;
    private int c;
    
    public b() {
        this.b = null;
        this.a = null;
        this.c = 0;
    }
    
    public b(final Class<?> b) {
        this.b = b;
        this.a = b.getName();
        this.c = this.a.hashCode();
    }
    
    public int a(final b b) {
        return this.a.compareTo(b.a);
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o != this) {
            if (o == null) {
                return false;
            }
            if (o.getClass() != this.getClass()) {
                return false;
            }
            if (((b)o).b != this.b) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return this.c;
    }
    
    @Override
    public String toString() {
        return this.a;
    }
}
