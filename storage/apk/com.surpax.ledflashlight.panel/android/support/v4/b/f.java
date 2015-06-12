// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.b;

import java.util.Map;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Set;

abstract class f
{
    h b;
    i c;
    k d;
    
    public static boolean a(final Set set, final Object o) {
        if (set != o) {
            if (o instanceof Set) {
                final Set set2 = (Set)o;
                try {
                    if (set.size() != set2.size() || !set.containsAll(set2)) {
                        return false;
                    }
                    return true;
                }
                catch (NullPointerException ex) {
                    return false;
                }
                catch (ClassCastException ex2) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }
    
    protected abstract int a();
    
    protected abstract int a(final Object p0);
    
    protected abstract Object a(final int p0, final int p1);
    
    protected abstract Object a(final int p0, final Object p1);
    
    protected abstract void a(final int p0);
    
    protected abstract void a(final Object p0, final Object p1);
    
    public final Object[] a(final Object[] array, final int n) {
        final int a = this.a();
        Object[] array2;
        if (array.length < a) {
            array2 = (Object[])Array.newInstance(array.getClass().getComponentType(), a);
        }
        else {
            array2 = array;
        }
        for (int i = 0; i < a; ++i) {
            array2[i] = this.a(i, n);
        }
        if (array2.length > a) {
            array2[a] = null;
        }
        return array2;
    }
    
    protected abstract int b(final Object p0);
    
    protected abstract Map b();
    
    public final Object[] b(final int n) {
        final int a = this.a();
        final Object[] array = new Object[a];
        for (int i = 0; i < a; ++i) {
            array[i] = this.a(i, n);
        }
        return array;
    }
    
    protected abstract void c();
}
