// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.b;

final class b
{
    static final int[] a;
    static final long[] b;
    static final Object[] c;
    
    static {
        a = new int[0];
        b = new long[0];
        c = new Object[0];
    }
    
    public static int a() {
        return 13;
    }
    
    static int a(final int[] array, final int n, final int n2) {
        int n3 = n - 1;
        int i = 0;
        while (i <= n3) {
            final int n4 = i + n3 >>> 1;
            final int n5 = array[n4];
            if (n5 < n2) {
                i = n4 + 1;
            }
            else {
                if (n5 <= n2) {
                    return n4;
                }
                n3 = n4 - 1;
            }
        }
        return ~i;
    }
    
    public static boolean a(final Object o, final Object obj) {
        return o == obj || (o != null && o.equals(obj));
    }
}
