// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.b;

import java.util.Map;
import java.util.Iterator;

final class j implements Iterator, Entry
{
    int a;
    int b;
    boolean c;
    final /* synthetic */ f d;
    
    j(final f d) {
        this.d = d;
        this.c = false;
        this.a = -1 + d.a();
        this.b = -1;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (o instanceof Entry) {
            final Entry entry = (Entry)o;
            if (android.support.v4.b.b.a(entry.getKey(), this.d.a(this.b, 0)) && android.support.v4.b.b.a(entry.getValue(), this.d.a(this.b, 1))) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public final Object getKey() {
        if (!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return this.d.a(this.b, 0);
    }
    
    @Override
    public final Object getValue() {
        if (!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return this.d.a(this.b, 1);
    }
    
    @Override
    public final boolean hasNext() {
        return this.b < this.a;
    }
    
    @Override
    public final int hashCode() {
        if (!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        final Object a = this.d.a(this.b, 0);
        final Object a2 = this.d.a(this.b, 1);
        int hashCode;
        if (a == null) {
            hashCode = 0;
        }
        else {
            hashCode = a.hashCode();
        }
        int hashCode2 = 0;
        if (a2 != null) {
            hashCode2 = a2.hashCode();
        }
        return hashCode2 ^ hashCode;
    }
    
    @Override
    public final void remove() {
        if (!this.c) {
            throw new IllegalStateException();
        }
        this.d.a(this.b);
        --this.b;
        --this.a;
        this.c = false;
    }
    
    @Override
    public final Object setValue(final Object o) {
        if (!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return this.d.a(this.b, o);
    }
    
    @Override
    public final String toString() {
        return this.getKey() + "=" + this.getValue();
    }
}
