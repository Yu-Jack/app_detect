// 
// Decompiled by Procyon v0.5.29
// 

package a.a.a.a.a;

import a.a.a.c.a;
import a.a.a.a.a.a.b;

public class b
{
    private final String a;
    private final c b;
    private final a.a.a.a.a.a.b c;
    
    public b(final String a, final a.a.a.a.a.a.b c) {
        a.a.a.c.a.a(a, "Name");
        a.a.a.c.a.a(c, "Body");
        this.a = a;
        this.c = c;
        this.b = new c();
        this.a(c);
        this.b(c);
        this.c(c);
    }
    
    public String a() {
        return this.a;
    }
    
    protected void a(final a.a.a.a.a.a.b b) {
        final StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=\"");
        sb.append(this.a());
        sb.append("\"");
        if (b.c() != null) {
            sb.append("; filename=\"");
            sb.append(b.c());
            sb.append("\"");
        }
        this.a("Content-Disposition", sb.toString());
    }
    
    public void a(final String s, final String s2) {
        a.a.a.c.a.a(s, "Field name");
        this.b.a(new i(s, s2));
    }
    
    public a.a.a.a.a.a.b b() {
        return this.c;
    }
    
    protected void b(final a.a.a.a.a.a.b b) {
        final StringBuilder sb = new StringBuilder();
        sb.append(b.a());
        if (b.b() != null) {
            sb.append("; charset=");
            sb.append(b.b());
        }
        this.a("Content-Type", sb.toString());
    }
    
    public c c() {
        return this.b;
    }
    
    protected void c(final a.a.a.a.a.a.b b) {
        this.a("Content-Transfer-Encoding", b.d());
    }
}
