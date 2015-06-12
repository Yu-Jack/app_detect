import android.content.ContentValues;
import android.database.Cursor;

// 
// Decompiled by Procyon v0.5.29
// 

public final class acm implements acf, ack
{
    final acn a;
    acf b;
    
    public acm(final acn a) {
        this.a = a;
    }
    
    @Override
    public final void a(final Object o) {
        if (this.b == null) {
            throw new IllegalStateException();
        }
        this.b.a(o);
    }
    
    @Override
    public final Object b(final Cursor cursor) {
        this.b = this.a.c(cursor);
        return this;
    }
    
    @Override
    public final void b() {
        if (this.b == null) {
            throw new IllegalStateException();
        }
        this.b.b();
    }
    
    @Override
    public final Object c() {
        if (this.b == null) {
            throw new IllegalStateException("Field is not bound to any source");
        }
        return this.b.c();
    }
    
    @Override
    public final Object d(final ContentValues contentValues) {
        this.b = this.a.c(contentValues);
        return this;
    }
}
