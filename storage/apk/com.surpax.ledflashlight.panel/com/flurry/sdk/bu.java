// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import android.graphics.Point;
import android.util.SparseArray;
import java.util.List;

public final class bu
{
    private static final List a;
    private static final SparseArray b;
    
    static {
        a = a();
        b = b();
    }
    
    public static int a(final Point point) {
        if (point == null) {
            return -1;
        }
        for (final Integer n : bu.a) {
            final Point a = a(n);
            if (a != null && point.x >= a.x && point.y >= a.y) {
                return n;
            }
        }
        return -1;
    }
    
    public static Point a(final int n) {
        return (Point)bu.b.get(n);
    }
    
    private static List a() {
        final ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(11);
        list.add(12);
        list.add(15);
        list.add(10);
        list.add(13);
        return Collections.unmodifiableList((List<?>)list);
    }
    
    private static SparseArray b() {
        final SparseArray sparseArray = new SparseArray();
        sparseArray.put(11, (Object)new Point(728, 90));
        sparseArray.put(12, (Object)new Point(468, 60));
        sparseArray.put(15, (Object)new Point(320, 50));
        sparseArray.put(10, (Object)new Point(300, 250));
        sparseArray.put(13, (Object)new Point(120, 600));
        return sparseArray;
    }
}
