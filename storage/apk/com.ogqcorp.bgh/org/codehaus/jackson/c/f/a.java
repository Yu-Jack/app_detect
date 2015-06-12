// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.c.f;

public final class a
{
    protected final Class<?> a;
    protected final int b;
    protected String c;
    
    public a(final Class<?> a, final String s) {
        this.a = a;
        this.b = a.getName().hashCode();
        this.a(s);
    }
    
    public Class<?> a() {
        return this.a;
    }
    
    public void a(String c) {
        if (c == null || c.length() == 0) {
            c = null;
        }
        this.c = c;
    }
    
    public String b() {
        return this.c;
    }
    
    public boolean c() {
        return this.c != null;
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
            if (this.a != ((a)o).a) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return this.b;
    }
    
    @Override
    public String toString() {
        final StringBuilder append = new StringBuilder().append("[NamedType, class ").append(this.a.getName()).append(", name: ");
        String string;
        if (this.c == null) {
            string = "null";
        }
        else {
            string = "'" + this.c + "'";
        }
        return append.append(string).append("]").toString();
    }
}
