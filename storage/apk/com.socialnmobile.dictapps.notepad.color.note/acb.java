import android.content.ContentValues;
import android.database.Cursor;

// 
// Decompiled by Procyon v0.5.29
// 

public abstract class acb implements acn
{
    protected final String a;
    
    public acb(final String a) {
        this.a = a;
    }
    
    public abstract acd a(final Cursor p0);
    
    public abstract Object a(final ContentValues p0);
    
    public final String a() {
        return this.a;
    }
    
    public abstract void a(final ContentValues p0, final Object p1);
    
    public final void b(final ContentValues contentValues) {
        contentValues.remove(this.a);
    }
    
    @Override
    public final acf c(final ContentValues contentValues) {
        return new acc(this, contentValues, this);
    }
}
