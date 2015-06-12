// 
// Decompiled by Procyon v0.5.29
// 

package a.a.a.a.a;

import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

public class c implements Iterable<i>
{
    private final List<i> a;
    private final Map<String, List<i>> b;
    
    public c() {
        this.a = new LinkedList<i>();
        this.b = new HashMap<String, List<i>>();
    }
    
    public i a(final String s) {
        if (s == null) {
            return null;
        }
        final List<i> list = this.b.get(s.toLowerCase(Locale.US));
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }
    
    public void a(final i i) {
        if (i == null) {
            return;
        }
        final String lowerCase = i.a().toLowerCase(Locale.US);
        List<i> list = this.b.get(lowerCase);
        if (list == null) {
            list = new LinkedList<i>();
            this.b.put(lowerCase, list);
        }
        list.add(i);
        this.a.add(i);
    }
    
    @Override
    public Iterator<i> iterator() {
        return Collections.unmodifiableList((List<? extends i>)this.a).iterator();
    }
    
    @Override
    public String toString() {
        return this.a.toString();
    }
}
