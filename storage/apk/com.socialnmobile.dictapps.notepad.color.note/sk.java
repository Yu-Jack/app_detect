import android.database.Cursor;
import android.database.DatabaseUtils;
import android.content.ContentValues;
import com.socialnmobile.colornote.sync.AccountColumns;

// 
// Decompiled by Procyon v0.5.29
// 

public final class sk implements AccountColumns
{
    final ki a;
    
    public sk(final ki a) {
        this.a = a;
    }
    
    public final int a(final ContentValues contentValues, aco aco) {
        if (aco == null) {
            aco = new aco();
        }
        return this.a.f().a("SyncAccount", contentValues, aco.a, aco.b);
    }
    
    public final ContentValues a(aco aco) {
        if (aco == null) {
            aco = new aco();
        }
        final Cursor a = this.a.e().a("SyncAccount", null, aco.a, aco.b, null);
        try {
            if (a.moveToFirst()) {
                final ContentValues contentValues = new ContentValues();
                DatabaseUtils.cursorRowToContentValues(a, contentValues);
                return contentValues;
            }
            return null;
        }
        finally {
            a.close();
        }
    }
}
