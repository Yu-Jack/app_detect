import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteProgram;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.content.ContentValues;
import java.util.concurrent.locks.ReentrantLock;
import android.database.sqlite.SQLiteDatabase;

// 
// Decompiled by Procyon v0.5.29
// 

public final class kj
{
    public SQLiteDatabase a;
    ReentrantLock b;
    
    public kj(final SQLiteDatabase a) {
        this.a = a;
        this.b = new ReentrantLock(true);
    }
    
    public final int a(final String s, final ContentValues contentValues, final String s2, final String[] array) {
        this.b.lock();
        try {
            return this.a.update(s, contentValues, s2, array);
        }
        finally {
            this.b.unlock();
        }
    }
    
    public final int a(final String s, final String s2, final String[] array) {
        this.b.lock();
        try {
            return this.a.delete(s, s2, array);
        }
        finally {
            this.b.unlock();
        }
    }
    
    public final int a(final String s, final Object[] array) {
        this.b.lock();
        try {
            this.a.execSQL(s, array);
            return (int)DatabaseUtils.longForQuery(this.a, "SELECT changes()", (String[])null);
        }
        finally {
            this.b.unlock();
        }
    }
    
    public final long a(final String s, final String s2, final ContentValues contentValues) {
        this.b.lock();
        try {
            return this.a.insert(s, s2, contentValues);
        }
        finally {
            this.b.unlock();
        }
    }
    
    public final Cursor a(final String s, final String[] array) {
        return this.a.rawQuery(s, array);
    }
    
    public final Cursor a(final String s, final String[] array, final String s2, final String[] array2, final String s3) {
        return this.a.query(s, array, s2, array2, (String)null, (String)null, s3);
    }
    
    public final void a(final String s) {
        this.b.lock();
        try {
            this.a.execSQL(s);
        }
        finally {
            this.b.unlock();
        }
    }
    
    public final long b(final String s, final String s2, final ContentValues contentValues) {
        this.b.lock();
        try {
            return this.a.insertOrThrow(s, s2, contentValues);
        }
        finally {
            this.b.unlock();
        }
    }
    
    public final long b(final String s, final Object[] array) {
        this.b.lock();
        final SQLiteStatement compileStatement = this.a.compileStatement(s);
    Label_0030:
        while (true) {
            if (array == null) {
                break Label_0030;
            }
            while (true) {
                while (true) {
                    int length = 0;
                    int n = 0;
                    Label_0088: {
                        try {
                            length = array.length;
                            n = 0;
                            break Label_0088;
                            return compileStatement.executeInsert();
                            DatabaseUtils.bindObjectToProgram((SQLiteProgram)compileStatement, n + 1, array[n]);
                            ++n;
                        }
                        finally {
                            compileStatement.close();
                            this.b.unlock();
                        }
                    }
                    if (n >= length) {
                        continue Label_0030;
                    }
                    continue;
                }
            }
            break;
        }
    }
}
