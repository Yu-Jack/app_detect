import org.json.JSONArray;
import java.util.AbstractList;

// 
// Decompiled by Procyon v0.5.29
// 

public final class xi extends AbstractList
{
    final JSONArray a;
    
    public xi() {
        this(new JSONArray());
    }
    
    public xi(final JSONArray a) {
        this.a = a;
    }
    
    @Override
    public final boolean add(final Object o) {
        this.a.put(xf.b(o));
        return true;
    }
    
    @Override
    public final Object get(final int n) {
        return xf.a(this.a, n);
    }
    
    @Override
    public final int size() {
        return this.a.length();
    }
    
    @Override
    public final String toString() {
        return this.a.toString();
    }
}
