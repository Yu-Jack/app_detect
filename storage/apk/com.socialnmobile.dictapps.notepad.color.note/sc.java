import android.content.ContentValues;

// 
// Decompiled by Procyon v0.5.29
// 

public final class sc extends adg
{
    public static void a(final rx rx, final rv rv) {
        rv.v.a(rx.a);
        rv.w.a(rx.b);
    }
    
    public final rx a(final rv rv) {
        final xj xj = (xj)rv.u.c();
        final xj xj2 = (xj)rv.t.c();
        if (xj2 == null) {
            throw new sd(this);
        }
        if (xj == null) {
            throw new sd(this);
        }
        if (!xj.containsKey("authentication")) {
            throw new sd(this);
        }
        return new rx(si.a.a(xj2), ud.a.a(xj));
    }
}
