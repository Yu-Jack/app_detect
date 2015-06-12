import com.socialnmobile.colornote.ColorNote;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

// 
// Decompiled by Procyon v0.5.29
// 

public final class kb extends SQLiteOpenHelper
{
    kb(final Context context) {
        super(context, "internal.db", (SQLiteDatabase$CursorFactory)null, 3);
    }
    
    public final void onCreate(final SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE widget (_id INTEGER PRIMARY KEY,note_id INTEGER NOT NULL,widget_type INTEGER DEFAULT 0);");
    }
    
    public final void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
        switch (n) {
            default: {}
            case 1:
            case 2: {
                while (true) {
                    try {
                        sqLiteDatabase.execSQL("ALTER TABLE widget ADD COLUMN widget_type INTEGER DEFAULT 0;");
                        sqLiteDatabase.execSQL("UPDATE widget SET widget_type = 1");
                        return;
                    }
                    catch (Exception ex) {
                        ColorNote.a("Column already exists");
                        continue;
                    }
                    break;
                }
                break;
            }
        }
    }
}
