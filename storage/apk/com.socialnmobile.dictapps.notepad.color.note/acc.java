import android.content.ContentValues;

// 
// Decompiled by Procyon v0.5.29
// 

final class acc implements acf
{
    final /* synthetic */ acb a;
    private final /* synthetic */ ContentValues b;
    private final /* synthetic */ acb c;
    
    acc(final acb a, final ContentValues b, final acb c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void a(final Object o) {
        this.a.a(this.b, o);
    }
    
    @Override
    public final void b() {
        this.a.b(this.b);
    }
    
    @Override
    public final Object c() {
        if (this.b.containsKey(this.a.a)) {
            return this.c.a(this.b);
        }
        throw new acg("Column " + this.a.a + " not exists");
    }
}
