// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.c.b.a;

import java.util.LinkedList;
import com.a.a.x;
import android.graphics.drawable.Drawable;
import com.a.a.n;

class b
{
    final /* synthetic */ a a;
    private final n<?> b;
    private Drawable c;
    private x d;
    private final LinkedList<d> e;
    
    public b(final a a, final n<?> b, final d e) {
        this.a = a;
        this.e = new LinkedList<d>();
        this.b = b;
        this.e.add(e);
    }
    
    public x a() {
        return this.d;
    }
    
    public void a(final x d) {
        this.d = d;
    }
    
    public void a(final d e) {
        this.e.add(e);
    }
    
    public boolean b(final d o) {
        this.e.remove(o);
        if (this.e.size() == 0) {
            this.b.f();
            return true;
        }
        return false;
    }
}
