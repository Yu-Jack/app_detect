import java.util.Map;

// 
// Decompiled by Procyon v0.5.29
// 

final class xk implements Entry
{
    final xj a;
    final String b;
    
    xk(final xj a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final boolean equals(final Object o) {
        return this == o || (o instanceof xk && this.b.equals(((xk)o).b));
    }
    
    @Override
    public final Object getValue() {
        return this.a.get(this.b);
    }
    
    @Override
    public final int hashCode() {
        return 527 + this.b.hashCode();
    }
    
    @Override
    public final Object setValue(final Object o) {
        throw new UnsupportedOperationException();
    }
}
