// 
// Decompiled by Procyon v0.5.29
// 

package org.a.b.a.a;

import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

public class b implements Iterable<f>
{
    private final List<f> a;
    private final Map<String, List<f>> b;
    
    public b() {
        this.a = new LinkedList<f>();
        this.b = new HashMap<String, List<f>>();
    }
    
    public f a(final String s) {
        if (s == null) {
            return null;
        }
        final List<f> list = this.b.get(s.toLowerCase(Locale.US));
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }
    
    public void a(final f f) {
        if (f == null) {
            return;
        }
        final String lowerCase = f.a().toLowerCase(Locale.US);
        List<f> list = this.b.get(lowerCase);
        if (list == null) {
            list = new LinkedList<f>();
            this.b.put(lowerCase, list);
        }
        list.add(f);
        this.a.add(f);
    }
    
    @Override
    public Iterator<f> iterator() {
        return Collections.unmodifiableList((List<? extends f>)this.a).iterator();
    }
    
    @Override
    public String toString() {
        return this.a.toString();
    }
}
