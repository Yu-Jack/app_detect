import java.util.Iterator;
import java.util.HashMap;

// 
// Decompiled by Procyon v0.5.29
// 

public final class sj extends adi
{
    final vd a;
    final vq b;
    
    public sj() {
        this.a = new vd();
        this.b = new vq();
    }
    
    private HashMap a(final sl sl, final xj xj) {
        if (xj == null) {
            return null;
        }
        final HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (final String key : xj.keySet()) {
            final xj j = xj.j(key);
            Object value;
            if (j == null) {
                value = null;
            }
            else {
                value = new sr(sl, j.d("id"), (vp)this.b.d(j.j("profile")));
            }
            hashMap.put(key, value);
        }
        return hashMap;
    }
    
    private xj a(final HashMap hashMap) {
        if (hashMap == null) {
            return null;
        }
        final xj xj = new xj();
        for (final String key : hashMap.keySet()) {
            final sr sr = (sr)hashMap.get(key);
            Object o;
            if (sr == null) {
                o = null;
            }
            else {
                final xj xj2 = new xj();
                xj2.a("id", sr.b);
                if (sr.c != null) {
                    xj2.a("profile", sr.c, this.b);
                }
                o = xj2;
            }
            xj.a(key, o);
        }
        return xj;
    }
    
    public final sh a(final xj xj) {
        final long longValue = xj.c("id").longValue();
        final vc vc = (vc)xj.a("nek", this.a);
        final tw tw = (tw)xj.a("created", tw.d);
        final tw tw2 = (tw)xj.a("modified", tw.d);
        final tw tw3 = (tw)xj.a("repository_built", tw.d);
        final xj j = xj.j("identities");
        sq sq;
        if (j == null) {
            sq = null;
        }
        else {
            sq = new sq(this.a(sl.a, j.j("email")), this.a(sl.c, j.j("google")), this.a(sl.b, j.j("facebook")), this.a(sl.d, j.j("colornote")));
        }
        return new sh(longValue, vc, tw, tw2, tw3, xj.c("notes_count").intValue(), sq);
    }
    
    public final void a(final sh sh, final xj xj) {
        xj.a("id", sh.a);
        xj.a("nek", sh.b, this.a);
        xj.a("created", sh.c, tw.d);
        xj.a("modified", sh.d, tw.d);
        xj.a("repository_built", sh.e, tw.d);
        final sq g = sh.g;
        xj xj2;
        if (g == null) {
            xj2 = null;
        }
        else {
            xj2 = new xj();
            final xj a = this.a(g.a);
            final xj a2 = this.a(g.b);
            final xj a3 = this.a(g.c);
            final xj a4 = this.a(g.d);
            xj2.a("email", a);
            xj2.a("google", a2);
            xj2.a("facebook", a3);
            xj2.a("colornote", a4);
        }
        xj.a("identities", xj2);
        xj.a("notes_count", sh.f);
    }
}
