// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Iterator;
import android.content.Context;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public final class be implements bf
{
    private final List a;
    
    public be() {
        final ArrayList<bh> list = new ArrayList<bh>();
        list.add(new bd());
        list.add((bd)new bi());
        list.add((bd)new bb());
        list.add((bd)new bh());
        this.a = Collections.unmodifiableList((List<?>)list);
    }
    
    @Override
    public final boolean a(final Context context, final bj bj) {
        boolean b;
        if (context == null || bj == null) {
            b = false;
        }
        else {
            final Iterator<bf> iterator = this.a.iterator();
            b = true;
            while (iterator.hasNext()) {
                b = (iterator.next().a(context, bj) && b);
            }
        }
        return b;
    }
}
