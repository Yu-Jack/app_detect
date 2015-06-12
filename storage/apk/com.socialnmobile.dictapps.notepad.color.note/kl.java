import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import com.socialnmobile.colornote.ColorNote;
import android.database.sqlite.SQLiteException;
import android.preference.PreferenceManager;
import com.socialnmobile.colornote.data.NoteProvider;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

// 
// Decompiled by Procyon v0.5.29
// 

public final class kl extends SQLiteOpenHelper
{
    Context a;
    
    public kl(final Context a, final String s) {
        super(a, s, (SQLiteDatabase$CursorFactory)null, 6);
        this.a = a;
    }
    
    public final void onCreate(final SQLiteDatabase sqLiteDatabase) {
        final kj kj = new kj(sqLiteDatabase);
        NoteProvider.a(kj);
        NoteProvider.b(kj);
    }
    
    public final void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
        Block_2: {
            while (true) {
                switch (n) {
                    default: {}
                    case 1: {
                        sqLiteDatabase.execSQL("ALTER TABLE notes ADD COLUMN status INTEGER DEFAULT 0;");
                    }
                    case 2: {
                        sqLiteDatabase.execSQL("UPDATE notes SET color_index=color_index+1 WHERE color_index <= 5");
                        final SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a);
                        final int int1 = defaultSharedPreferences.getInt("pref_default_color", 100);
                        if (int1 <= 5) {
                            final SharedPreferences$Editor edit = defaultSharedPreferences.edit();
                            edit.putInt("pref_default_color", int1 + 1);
                            edit.commit();
                        }
                        sqLiteDatabase.execSQL("ALTER TABLE notes ADD COLUMN folder_id INTEGER DEFAULT 0;");
                        sqLiteDatabase.execSQL("ALTER TABLE notes ADD COLUMN importance INTEGER DEFAULT 0;");
                        sqLiteDatabase.execSQL("ALTER TABLE notes ADD COLUMN note_ext TEXT DEFAULT '';");
                        sqLiteDatabase.execSQL("ALTER TABLE notes ADD COLUMN active_state INTEGER DEFAULT 0;");
                        sqLiteDatabase.execSQL("ALTER TABLE notes ADD COLUMN reminder_type INTEGER DEFAULT 0;");
                        sqLiteDatabase.execSQL("ALTER TABLE notes ADD COLUMN reminder_option INTEGER DEFAULT 0;");
                        sqLiteDatabase.execSQL("ALTER TABLE notes ADD COLUMN reminder_base INTEGER DEFAULT 0;");
                        sqLiteDatabase.execSQL("ALTER TABLE notes ADD COLUMN reminder_last INTEGER DEFAULT 0;");
                        sqLiteDatabase.execSQL("ALTER TABLE notes ADD COLUMN reminder_duration INTEGER DEFAULT 0;");
                        sqLiteDatabase.execSQL("ALTER TABLE notes ADD COLUMN reminder_repeat INTEGER DEFAULT 0;");
                        final long a = gw.a(System.currentTimeMillis());
                        sqLiteDatabase.execSQL("UPDATE notes SET reminder_type = 32, reminder_repeat = 0, reminder_base = reminder_date WHERE reminder_date > 0");
                        sqLiteDatabase.execSQL("UPDATE notes SET reminder_type = 16, reminder_repeat = 144, reminder_base = " + a + ", reminder_date = " + a + ", reminder_last = " + a + " WHERE reminder_date = -1");
                        sqLiteDatabase.execSQL("UPDATE notes SET status = 16 WHERE status = 1");
                        sqLiteDatabase.execSQL("UPDATE notes SET type = 16 WHERE type = 1");
                    }
                    case 3: {
                        sqLiteDatabase.execSQL("ALTER TABLE notes ADD COLUMN account_id INTEGER DEFAULT 0;");
                        sqLiteDatabase.execSQL("ALTER TABLE notes ADD COLUMN space INTEGER DEFAULT 0;");
                        sqLiteDatabase.execSQL("ALTER TABLE notes ADD COLUMN latitude DOUBLE DEFAULT 0;");
                        sqLiteDatabase.execSQL("ALTER TABLE notes ADD COLUMN longitude DOUBLE DEFAULT 0;");
                        sqLiteDatabase.execSQL("ALTER TABLE notes ADD COLUMN minor_modified_date INTEGER DEFAULT 0;");
                        sqLiteDatabase.execSQL("ALTER TABLE notes ADD COLUMN dirty INTEGER DEFAULT 1");
                        sqLiteDatabase.execSQL("ALTER TABLE notes ADD COLUMN staged INTEGER DEFAULT 0");
                        sqLiteDatabase.execSQL("ALTER TABLE notes ADD COLUMN uuid TEXT");
                        sqLiteDatabase.execSQL("ALTER TABLE notes ADD COLUMN revision INTEGER DEFAULT 0");
                        sqLiteDatabase.execSQL("UPDATE notes SET minor_modified_date = modified_date");
                        sqLiteDatabase.execSQL("CREATE TABLE SyncAccount(_id INTEGER PRIMARY KEY NOT NULL,client_uuid TEXT,repository_built INTEGER DEFAULT 0 NOT NULL,base_revision INTEGER DEFAULT 0 NOT NULL,auth_token TEXT,email TEXT,colornote_id TEXT,fb_access TEXT,fb_user_name TEXT)");
                        sqLiteDatabase.execSQL("CREATE INDEX idx_note1 ON notes(active_state,account_id,folder_id,space)");
                        sqLiteDatabase.execSQL("CREATE INDEX idx_note2 ON notes(reminder_type,reminder_date)");
                        sqLiteDatabase.execSQL("CREATE INDEX idx_note3 ON notes(reminder_repeat,reminder_base)");
                        sqLiteDatabase.execSQL("CREATE INDEX idx_note4 ON notes(title)");
                        sqLiteDatabase.execSQL("CREATE INDEX idx_note_s1 ON notes(dirty)");
                        sqLiteDatabase.execSQL("CREATE INDEX idx_note_s2 ON notes(staged)");
                    }
                    case 4: {
                        if (n == 4) {
                            break Block_2;
                        }
                        break Label_0353;
                    }
                    case 5: {
                        Label_0378: {
                            break Label_0378;
                            try {
                                sqLiteDatabase.execSQL("ALTER TABLE SyncAccount ADD COLUMN auth_token TEXT;");
                                new ko(new ki(new kj(sqLiteDatabase))).a();
                                sqLiteDatabase.execSQL("DELETE FROM SyncAccount");
                                sqLiteDatabase.execSQL("UPDATE notes SET dirty = 1,staged = 0,revision = 0");
                                try {
                                    sqLiteDatabase.execSQL("ALTER TABLE notes ADD COLUMN reminder_repeat_ends INTEGER DEFAULT 0;");
                                    return;
                                }
                                catch (SQLiteException ex) {
                                    return;
                                }
                            }
                            catch (Exception ex2) {
                                ColorNote.a("Column already exists");
                                continue;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
    }
}
