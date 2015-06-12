import android.content.ContentValues;
import android.database.Cursor;

// 
// Decompiled by Procyon v0.5.29
// 

public final class acp extends acb
{
    public acp(final String s) {
        super(s);
    }
    
    @Override
    public final acd a(final Cursor cursor) {
        return new acq(this, cursor, this, cursor);
    }
}
