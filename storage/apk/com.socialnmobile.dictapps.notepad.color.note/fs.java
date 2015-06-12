import java.util.Iterator;
import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

// 
// Decompiled by Procyon v0.5.29
// 

public final class fs
{
    private Map a;
    private Map b;
    
    fs() {
        this.a = new HashMap();
        this.b = new HashMap();
    }
    
    public final Object a(final String s) {
        synchronized (this) {
            return this.a.get(s);
        }
    }
    
    public final void a(final String s, final ft ft) {
        // monitorenter(this)
        if (ft != null) {
            try {
                List<ft> list = this.b.get(s);
                if (list == null) {
                    list = new LinkedList<ft>();
                }
                list.add(ft);
                this.b.put(s, list);
            }
            finally {
            }
            // monitorexit(this)
        }
    }
    // monitorexit(this)
    
    public final void a(final String s, final Object o) {
        while (true) {
        Label_0070_Outer:
            while (true) {
                Label_0159: {
                    while (true) {
                        Label_0138: {
                            synchronized (this) {
                                if (!TextUtils.isEmpty((CharSequence)s)) {
                                    final Object value = this.a.get(s);
                                    if (o != value && (o == null || !o.equals(value))) {
                                        break Label_0138;
                                    }
                                    break Label_0159;
                                }
                                Label_0013: {
                                    return;
                                }
                                // iftrue(Label_0013:, n != 0)
                                // iftrue(Label_0013:, this.b.get((Object)s) == null)
                                // iftrue(Label_0013:, !iterator.hasNext())
                                while (true) {
                                    Block_6: {
                                        break Block_6;
                                        this.a.remove(s);
                                        while (true) {
                                            Label_0103: {
                                                Block_8: {
                                                    break Block_8;
                                                    final Iterator<ft> iterator;
                                                    iterator.next().a(s, o);
                                                    break Label_0103;
                                                }
                                                final Iterator<ft> iterator = this.b.get(s).iterator();
                                            }
                                            continue;
                                        }
                                    }
                                    continue Label_0070_Outer;
                                }
                            }
                            // iftrue(Label_0144:, o != null)
                        }
                        final int n = 0;
                        continue Label_0070_Outer;
                        Label_0144: {
                            this.a.put(s, o);
                        }
                        continue;
                    }
                }
                final int n = 1;
                continue;
            }
        }
    }
    
    public final boolean b(final String s, final ft ft) {
        // monitorenter(this)
        boolean b;
        if (ft == null) {
            b = false;
        }
        else {
            try {
                final List list = this.b.get(s);
                b = (list != null && list.remove(ft));
            }
            finally {
            }
            // monitorexit(this)
        }
        // monitorexit(this)
        return b;
    }
}
