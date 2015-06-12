import android.database.Cursor;

// 
// Decompiled by Procyon v0.5.29
// 

public abstract class acd extends aci
{
    final acb a;
    final Cursor b;
    final int c;
    
    public acd(final Cursor b, final acb a) {
        this.a = a;
        this.b = b;
        this.c = b.getColumnIndex(a.a);
    }
    
    public abstract Object a(final int p0);
    
    public final String a() {
        return this.a.a;
    }
    
    @Override
    public final Object c() {
        if (this.c >= 0) {
            return this.a(this.c);
        }
        throw new acg("Column " + this.a.a + " not exists");
    }
}
