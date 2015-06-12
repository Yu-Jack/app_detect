import android.database.sqlite.SQLiteDatabase;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ki
{
    static ReentrantReadWriteLock a;
    private kj b;
    private kl c;
    
    static {
        ki.a = new ReentrantReadWriteLock();
    }
    
    ki(final kj b) {
        this.b = b;
    }
    
    public ki(final kl c) {
        this.c = c;
    }
    
    private kj a(final SQLiteDatabase sqLiteDatabase) {
        if (this.b == null || this.b.a != sqLiteDatabase) {
            this.b = new kj(sqLiteDatabase);
        }
        return this.b;
    }
    
    public static void a() {
        ki.a.readLock().lock();
    }
    
    public static void b() {
        ki.a.readLock().unlock();
    }
    
    public static void c() {
        ki.a.writeLock().lock();
    }
    
    public static void d() {
        ki.a.writeLock().unlock();
    }
    
    public final kj e() {
        if (this.c != null) {
            return this.a(this.c.getReadableDatabase());
        }
        return this.b;
    }
    
    public final kj f() {
        if (this.c != null) {
            return this.a(this.c.getWritableDatabase());
        }
        return this.b;
    }
}
