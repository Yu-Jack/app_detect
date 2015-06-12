// 
// Decompiled by Procyon v0.5.29
// 

package a.a.a.a.a;

public class i
{
    private final String a;
    private final String b;
    
    public i(final String a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    public String a() {
        return this.a;
    }
    
    public String b() {
        return this.b;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(": ");
        sb.append(this.b);
        return sb.toString();
    }
}
