import java.util.ArrayList;

// 
// Decompiled by Procyon v0.5.29
// 

public abstract class ca
{
    private final ArrayList a;
    
    public ca(final int initialCapacity) {
        this.a = new ArrayList(initialCapacity);
    }
    
    public final Object a(final int index) {
        return this.a.get(index);
    }
    
    public final void a(final Object e) {
        this.a.add(e);
    }
    
    public final void b(final Object o) {
        this.a.remove(o);
    }
    
    public final boolean c(final Object o) {
        return this.a.contains(o);
    }
    
    public final Object d() {
        return this.a.remove(0);
    }
    
    public final void e() {
        this.a.clear();
    }
    
    public final int f() {
        return this.a.size();
    }
}
