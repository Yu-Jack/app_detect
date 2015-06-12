import java.util.ArrayList;
import java.util.Iterator;

// 
// Decompiled by Procyon v0.5.29
// 

public abstract class cb
{
    private final Iterator a;
    
    public cb(final ca ca) {
        this.a = ca.a.iterator();
    }
    
    public final boolean a() {
        return this.a.hasNext();
    }
    
    public final Object b() {
        return this.a.next();
    }
}
