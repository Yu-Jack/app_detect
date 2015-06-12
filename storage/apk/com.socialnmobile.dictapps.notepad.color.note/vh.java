import java.util.Iterator;
import java.util.Map;
import android.util.SparseArray;
import java.util.HashMap;

// 
// Decompiled by Procyon v0.5.29
// 

public final class vh
{
    public static final HashMap a;
    public static final SparseArray b;
    public static final vh c;
    
    static {
        final HashMap<String, Integer> a2 = new HashMap<String, Integer>();
        a2.put("none", 0);
        a2.put("type1", 1);
        a2.put("type2", 2);
        a2.put("type3", 3);
        a = a2;
        b = a();
        c = new vh();
    }
    
    private static int a(final xj xj, final String s) {
        final String h = xj.h(s);
        if (h != null) {
            final Integer n = vh.a.get(h);
            if (n != null) {
                return n;
            }
        }
        try {
            return xj.c(s).intValue();
        }
        catch (xg xg) {
            throw new ux(xg);
        }
        catch (xh xh) {
            throw new ux(xh);
        }
    }
    
    private static SparseArray a() {
        final SparseArray sparseArray = new SparseArray();
        for (final Map.Entry<K, Integer> entry : vh.a.entrySet()) {
            sparseArray.put((int)entry.getValue(), (Object)entry.getKey());
        }
        return sparseArray;
    }
    
    public static void a(final vf vf, final xj xj) {
        xj.a("content", vf.b.c());
        xj.a("title", vf.a.c());
        xj.a("modified", vf.d.c(), tw.d);
        final int intValue = (int)vf.c.c();
        final String s = (String)vh.b.get(intValue);
        if (s != null) {
            xj.a("locked", s);
            return;
        }
        xj.a("locked", intValue);
    }
    
    public static void b(final vf vf, final xj xj) {
        try {
            vf.b.a(xj.d("content"));
            vf.a.a(xj.d("title"));
            vf.d.a(xj.a("modified", tw.d));
            vf.c.a(a(xj, "locked"));
        }
        catch (xg xg) {
            throw new ux(xg);
        }
        catch (xh xh) {
            throw new ux(xh);
        }
    }
}
