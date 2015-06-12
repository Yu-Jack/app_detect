// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.d;

import org.codehaus.jackson.c.ba;
import java.util.Iterator;
import org.codehaus.jackson.c.ax;
import org.codehaus.jackson.i;
import java.util.ArrayList;

public final class a extends f
{
    protected ArrayList<i> c;
    
    public a(final k k) {
        super(k);
    }
    
    private boolean a(final ArrayList<i> list) {
        final int size = list.size();
        if (this.b() != size) {
            return false;
        }
        for (int i = 0; i < size; ++i) {
            if (!this.c.get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }
    
    private void b(final i e) {
        if (this.c == null) {
            this.c = new ArrayList<i>();
        }
        this.c.add(e);
    }
    
    @Override
    public i a(final String s) {
        return null;
    }
    
    @Override
    public final void a(final org.codehaus.jackson.f f, final ax ax) {
        f.b();
        if (this.c != null) {
            final Iterator<i> iterator = this.c.iterator();
            while (iterator.hasNext()) {
                ((b)iterator.next()).a(f, ax);
            }
        }
        f.c();
    }
    
    @Override
    public void a(final org.codehaus.jackson.f f, final ax ax, final ba ba) {
        ba.c(this, f);
        if (this.c != null) {
            final Iterator<i> iterator = this.c.iterator();
            while (iterator.hasNext()) {
                ((b)iterator.next()).a(f, ax);
            }
        }
        ba.f(this, f);
    }
    
    public void a(i d) {
        if (d == null) {
            d = this.d();
        }
        this.b(d);
    }
    
    @Override
    public int b() {
        if (this.c == null) {
            return 0;
        }
        return this.c.size();
    }
    
    @Override
    public Iterator<i> c() {
        if (this.c == null) {
            return g.a();
        }
        return this.c.iterator();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o != this) {
            if (o == null) {
                return false;
            }
            if (o.getClass() != this.getClass()) {
                return false;
            }
            final a a = (a)o;
            if (this.c != null && this.c.size() != 0) {
                return a.a(this.c);
            }
            if (a.b() != 0) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int n;
        if (this.c == null) {
            n = 1;
        }
        else {
            final int size = this.c.size();
            final Iterator<i> iterator = this.c.iterator();
            n = size;
            while (iterator.hasNext()) {
                final i i = iterator.next();
                int n2;
                if (i != null) {
                    n2 = (n ^ i.hashCode());
                }
                else {
                    n2 = n;
                }
                n = n2;
            }
        }
        return n;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(16 + (this.b() << 4));
        sb.append('[');
        if (this.c != null) {
            for (int size = this.c.size(), i = 0; i < size; ++i) {
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(this.c.get(i).toString());
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
