import android.content.ContentValues;
import android.database.Cursor;

// 
// Decompiled by Procyon v0.5.29
// 

public final class acv extends acb
{
    public acv(final String s) {
        super(s);
    }
    
    @Override
    public final acd a(final Cursor cursor) {
        return new acw(this, cursor, this, cursor);
    }
}
