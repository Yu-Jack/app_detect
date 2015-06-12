// 
// Decompiled by Procyon v0.5.29
// 

package org.a.b.a.a;

public class a
{
    private final String a;
    private final b b;
    private final org.a.b.a.a.a.b c;
    
    public a(final String a, final org.a.b.a.a.a.b c) {
        if (a == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        if (c == null) {
            throw new IllegalArgumentException("Body may not be null");
        }
        this.a = a;
        this.c = c;
        this.b = new b();
        this.a(c);
        this.b(c);
        this.c(c);
    }
    
    public String a() {
        return this.a;
    }
    
    public void a(final String s, final String s2) {
        if (s == null) {
            throw new IllegalArgumentException("Field name may not be null");
        }
        this.b.a(new f(s, s2));
    }
    
    protected void a(final org.a.b.a.a.a.b b) {
        final StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=\"");
        sb.append(this.a());
        sb.append("\"");
        if (b.b() != null) {
            sb.append("; filename=\"");
            sb.append(b.b());
            sb.append("\"");
        }
        this.a("Content-Disposition", sb.toString());
    }
    
    public org.a.b.a.a.a.b b() {
        return this.c;
    }
    
    protected void b(final org.a.b.a.a.a.b b) {
        final StringBuilder sb = new StringBuilder();
        sb.append(b.a());
        if (b.c() != null) {
            sb.append("; charset=");
            sb.append(b.c());
        }
        this.a("Content-Type", sb.toString());
    }
    
    public b c() {
        return this.b;
    }
    
    protected void c(final org.a.b.a.a.a.b b) {
        this.a("Content-Transfer-Encoding", b.d());
    }
}
