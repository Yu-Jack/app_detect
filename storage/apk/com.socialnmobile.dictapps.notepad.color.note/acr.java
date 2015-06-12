import android.content.ContentValues;
import android.database.Cursor;

// 
// Decompiled by Procyon v0.5.29
// 

public final class acr extends acb
{
    public acr(final String s) {
        super(s);
    }
    
    @Override
    public final acd a(final Cursor cursor) {
        return new acs(this, cursor, this, cursor);
    }
}
