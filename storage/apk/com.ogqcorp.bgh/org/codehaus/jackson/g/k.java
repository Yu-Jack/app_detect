// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.g;

import org.codehaus.jackson.p;
import java.util.List;
import java.util.ArrayList;
import org.codehaus.jackson.k;

public class k extends j
{
    protected final org.codehaus.jackson.k[] e;
    protected int f;
    
    protected k(final org.codehaus.jackson.k[] e) {
        super(e[0]);
        this.e = e;
        this.f = 1;
    }
    
    public static k a(final org.codehaus.jackson.k e, final org.codehaus.jackson.k e2) {
        if (!(e instanceof k) && !(e2 instanceof k)) {
            return new k(new org.codehaus.jackson.k[] { e, e2 });
        }
        final ArrayList<org.codehaus.jackson.k> list = new ArrayList<org.codehaus.jackson.k>();
        if (e instanceof k) {
            ((k)e).a(list);
        }
        else {
            list.add(e);
        }
        if (e2 instanceof k) {
            ((k)e2).a(list);
        }
        else {
            list.add(e2);
        }
        return new k(list.toArray(new org.codehaus.jackson.k[list.size()]));
    }
    
    protected boolean C() {
        if (this.f >= this.e.length) {
            return false;
        }
        this.d = this.e[this.f++];
        return true;
    }
    
    protected void a(final List<org.codehaus.jackson.k> list) {
        final int n = -1 + this.f;
        for (int length = this.e.length, i = n; i < length; ++i) {
            final org.codehaus.jackson.k k = this.e[i];
            if (k instanceof k) {
                ((k)k).a(list);
            }
            else {
                list.add(k);
            }
        }
    }
    
    @Override
    public p b() {
        final p b = this.d.b();
        if (b != null) {
            return b;
        }
        while (this.C()) {
            final p b2 = this.d.b();
            if (b2 != null) {
                return b2;
            }
        }
        return null;
    }
    
    @Override
    public void close() {
        do {
            this.d.close();
        } while (this.C());
    }
}
