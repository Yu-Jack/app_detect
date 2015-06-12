// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view.a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class m extends n
{
    @Override
    public Object a(final j j) {
        return q.a(new r() {
            @Override
            public Object a(final int n) {
                final a a = j.a(n);
                if (a == null) {
                    return null;
                }
                return a.a();
            }
            
            @Override
            public List<Object> a(final String s, final int n) {
                final List<a> a = j.a(s, n);
                final ArrayList<Object> list = new ArrayList<Object>();
                for (int size = a.size(), i = 0; i < size; ++i) {
                    list.add(a.get(i).a());
                }
                return list;
            }
            
            @Override
            public boolean a(final int n, final int n2, final Bundle bundle) {
                return j.a(n, n2, bundle);
            }
            
            @Override
            public Object b(final int n) {
                final a b = j.b(n);
                if (b == null) {
                    return null;
                }
                return b.a();
            }
        });
    }
}
