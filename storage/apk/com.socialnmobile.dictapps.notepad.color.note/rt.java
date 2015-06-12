import java.util.Set;
import com.socialnmobile.colornote.data.NoteProvider;
import android.database.Cursor;
import com.socialnmobile.colornote.ColorNote;
import java.util.UUID;
import android.content.ContentValues;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class rt extends rv
{
    final Context a;
    final ki b;
    final sk c;
    
    private rt(final Context a, final ki b, final ContentValues contentValues) {
        this.a = a;
        this.b = b;
        this.c = new sk(b);
        this.d(contentValues);
        this.x.a(a);
    }
    
    public static rt a(final Context context, final ki ki) {
        rt c = c(context, ki);
        if (c == null || c.t()) {
            c = null;
        }
        return c;
    }
    
    static rt a(final Context context, final ki ki, final xt xt, final xu xu) {
        final rt rt = new rt(context, ki, new ContentValues());
        rt.p.a(0L);
        rt.n.a(UUID.randomUUID());
        rt.b(xt, xu);
        rt.h();
        rt.l();
        final kj f = rt.b.f();
        f.a.beginTransaction();
        try {
            final long m = rt.m();
            final ContentValues v = rt.v();
            final sk c = rt.c;
            long a;
            if (v.getAsLong("_id") == null) {
                ColorNote.a("insert into SyncAccount requires explicit _ID");
                a = -1L;
            }
            else {
                a = c.a.f().a("SyncAccount", "colornote_id", v);
            }
            if (a == m) {
                final ContentValues a2 = rt.c.a(rt.x());
                if (a2 != null) {
                    rt.d(a2);
                    rt.h();
                    rt.l();
                    f.a.setTransactionSuccessful();
                    final ContentValues a3 = rt.c.a(rt.x());
                    final rv rv = new rv();
                    rv.d(a3);
                    rv.h();
                    rv.l();
                    return rt;
                }
            }
            throw new vs("Account insert failed", rt);
        }
        finally {
            f.a.endTransaction();
        }
    }
    
    private xi a(final aco aco) {
        final ko ko = new ko(this.b);
        final xi xi = new xi();
        final Cursor a = ko.a(new String[] { "_id", "uuid", "revision" }, aco);
        if (a == null) {
            return xi;
        }
        int i = 0;
        try {
            while (i < a.getCount()) {
                xj xj;
                if (a.moveToPosition(i)) {
                    xj = new xj();
                    xj.a("_id", a.getLong(0));
                    xj.a("uuid", a.getString(1) != null);
                    xj.a("rev", a.getLong(2));
                }
                else {
                    xj = null;
                }
                xi.add(xj);
                ++i;
            }
            return xi;
        }
        finally {
            a.close();
        }
    }
    
    public static boolean a(final Context context) {
        return c(context) != null;
    }
    
    public static rt b(final Context context, final ki ki) {
        rt c = c(context, ki);
        if (c == null || !c.t()) {
            c = null;
        }
        return c;
    }
    
    public static boolean b(final Context context) {
        if (a(context)) {
            c(context);
        }
        return false;
    }
    
    public static rt c(final Context context) {
        rt e = e(context);
        if (e == null || e.t()) {
            e = null;
        }
        return e;
    }
    
    private static rt c(final Context context, final ki ki) {
        final ContentValues a = new sk(ki).a(null);
        rt rt = null;
        if (a != null) {
            rt = new rt(context, ki, a);
        }
        return rt;
    }
    
    public static boolean d(final Context context) {
        final rt c = c(context);
        return c != null && new ko(c.b).b() > 0;
    }
    
    public static rt e(final Context context) {
        return c(context, NoteProvider.b(context));
    }
    
    private ru w() {
        return new ru(this);
    }
    
    private aco x() {
        return new aco("_id=?", new Object[] { this.m() });
    }
    
    private void y() {
        this.k();
        final kj f = this.b.f();
        f.a.beginTransaction();
        try {
            if (this.c.a(this.v(), this.x()) == 1) {
                final ContentValues a = this.c.a(this.x());
                final rv rv = new rv();
                rv.d(a);
                rv.k();
                f.a.setTransactionSuccessful();
                final ContentValues a2 = this.c.a(this.x());
                final rv rv2 = new rv();
                rv2.d(a2);
                rv2.k();
                return;
            }
            throw new vs("Account update failed", this);
        }
        finally {
            f.a.endTransaction();
        }
    }
    
    public final tq a(final xj xj, final Set set) {
        return new tq(this.b, xj, set, this.s());
    }
    
    public final xj a() {
        final xj xj = new xj();
        final Context a = this.a;
        final String a2 = ua.a(ua.a());
        final ub a3 = ub.a(this.a);
        xj.a("id", a2);
        xj.a("info", a3.a());
        return xj;
    }
    
    public final void a(final long n) {
        final ru w = this.w();
        w.p.a(n);
        if (w.a()) {
            this.p.a(n);
        }
    }
    
    public final void a(final tw tw) {
        final ru w = this.w();
        w.p.a(0L);
        w.o.a(tw);
        if (w.a()) {
            this.p.a(0L);
            this.o.a(tw);
        }
        new ko(this.b).e();
    }
    
    final void a(final xt xt, final xu xu) {
        this.b(xt, xu);
        this.y();
    }
    
    final void a(final xx xx) {
        final rx a = super.x.a();
        final sh e = xx.e;
        if (e.a != a.a.a) {
            throw new vx("account id mismatch");
        }
        if (e.b == null) {
            e.b = a.a.b;
        }
        if (e.g == null) {
            e.g = a.a.g;
        }
        final uc f = xx.f;
        if (f.d.c == null) {
            f.d.c = a.b.d.c;
        }
        super.q.a(f.e);
        super.v.a(e);
        super.w.a(f);
        this.y();
    }
    
    final boolean a(final ContentValues contentValues) {
        final kj f = this.b.f();
        f.a.beginTransaction();
        try {
            if (this.c.a(contentValues, this.x()) == 1) {
                f.a.setTransactionSuccessful();
                return true;
            }
            return false;
        }
        finally {
            f.a.endTransaction();
        }
    }
    
    public final boolean b() {
        final UUID randomUUID = UUID.randomUUID();
        final ru w = this.w();
        w.n.a(randomUUID);
        w.q.a(null);
        if (w.a()) {
            this.n.a(randomUUID);
            this.q.a(null);
            return true;
        }
        return false;
    }
    
    public final void c() {
        final kj f = this.b.f();
        f.a.beginTransaction();
        try {
            new ko(this.b).e();
            final sk c = this.c;
            aco x = this.x();
            if (x == null) {
                x = new aco();
            }
            c.a.f().a("SyncAccount", x.a, x.b);
            f.a.setTransactionSuccessful();
        }
        finally {
            f.a.endTransaction();
        }
    }
    
    public final tl d() {
        return new tl(this, this.b);
    }
    
    public final void e() {
        final rx a = this.x.a();
        a.a.h = true;
        final ru w = this.w();
        w.x.a(a);
        w.a();
    }
    
    public final xi f() {
        return this.a((aco)null);
    }
    
    public final xi g() {
        return this.a(new aco("_id=0", new String[0]));
    }
}
