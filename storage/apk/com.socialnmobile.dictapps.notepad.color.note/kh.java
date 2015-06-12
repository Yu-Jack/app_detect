import android.content.Context;
import java.security.GeneralSecurityException;
import com.socialnmobile.colornote.ColorNote;
import android.text.format.Time;
import android.database.Cursor;

// 
// Decompiled by Procyon v0.5.29
// 

public final class kh
{
    public long a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public String g;
    public long h;
    public long i;
    public int j;
    public int k;
    public long l;
    public int m;
    public int n;
    public long o;
    private String p;
    private String q;
    private long r;
    private long s;
    private long t;
    private double u;
    private double v;
    
    public kh() {
    }
    
    public kh(final Cursor cursor) {
        this.a(cursor);
    }
    
    public static long a(final int n, final long n2) {
        if (n2 <= 0L) {
            return n2;
        }
        if (n == 16) {
            final Time time = new Time("UTC");
            time.set(n2);
            final Time time2 = new Time();
            time2.set(59, 59, 23, time.monthDay, time.month, time.year);
            return jk.a(time2, true);
        }
        final Time time3 = new Time();
        time3.set(n2);
        return jk.a(time3, false);
    }
    
    private String a(final String s) {
        try {
            final jz a = jz.a(this.k);
            if (this.k == 1) {
                a.a("ColorNote Password");
            }
            else {
                a.b(s);
            }
            a.c(2);
            return a.d(this.p);
        }
        catch (GeneralSecurityException ex) {
            ColorNote.a("Error Decryption");
            return "";
        }
    }
    
    public final String a(final Context context) {
        if (this.k == 1) {
            return this.a((String)null);
        }
        if (this.k == 2) {
            return this.a(jq.c(context));
        }
        return this.p;
    }
    
    public final void a(final Cursor cursor) {
        this.a = cursor.getLong(cursor.getColumnIndex("_id"));
        this.b = cursor.getInt(cursor.getColumnIndex("folder_id"));
        this.c = cursor.getInt(cursor.getColumnIndex("active_state"));
        this.d = cursor.getInt(cursor.getColumnIndex("status"));
        this.e = cursor.getInt(cursor.getColumnIndex("space"));
        this.f = cursor.getInt(cursor.getColumnIndex("type"));
        this.g = cursor.getString(cursor.getColumnIndex("title"));
        this.p = cursor.getString(cursor.getColumnIndex("note"));
        this.q = cursor.getString(cursor.getColumnIndex("note_ext"));
        this.h = cursor.getLong(cursor.getColumnIndex("created_date"));
        this.i = cursor.getLong(cursor.getColumnIndex("modified_date"));
        this.j = cursor.getInt(cursor.getColumnIndex("color_index"));
        this.k = cursor.getInt(cursor.getColumnIndex("encrypted"));
        this.r = cursor.getLong(cursor.getColumnIndex("reminder_date"));
        this.s = cursor.getLong(cursor.getColumnIndex("reminder_base"));
        this.l = cursor.getLong(cursor.getColumnIndex("reminder_last"));
        this.m = cursor.getInt(cursor.getColumnIndex("reminder_type"));
        this.n = cursor.getInt(cursor.getColumnIndex("reminder_repeat"));
        this.t = cursor.getLong(cursor.getColumnIndex("reminder_repeat_ends"));
        this.u = cursor.getDouble(cursor.getColumnIndex("latitude"));
        this.v = cursor.getDouble(cursor.getColumnIndex("longitude"));
        this.o = cursor.getLong(cursor.getColumnIndex("revision"));
    }
    
    public final boolean a() {
        return (0x10 & this.d) != 0x0;
    }
    
    public final boolean b() {
        return (0x1000 & this.d) != 0x0;
    }
    
    public final String c() {
        if (this.e()) {
            return "";
        }
        return this.p;
    }
    
    public final String d() {
        if (this.e()) {
            return "";
        }
        return this.p.substring(0, Math.min(800, this.p.length()));
    }
    
    public final boolean e() {
        return this.k != 0;
    }
    
    public final long f() {
        return a(this.m, this.s);
    }
    
    public final long g() {
        return a(this.m, this.r);
    }
    
    public final long h() {
        return a(this.m, this.l);
    }
    
    public final long i() {
        return a(this.m, this.t);
    }
}
