// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.View;
import java.util.Comparator;

class bo implements Comparator<View>
{
    public int a(final View view, final View view2) {
        final bi bi = (bi)view.getLayoutParams();
        final bi bi2 = (bi)view2.getLayoutParams();
        if (bi.a == bi2.a) {
            return bi.e - bi2.e;
        }
        if (bi.a) {
            return 1;
        }
        return -1;
    }
}
