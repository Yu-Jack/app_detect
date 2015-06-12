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

public final class by
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
        for (final Integer n : by.a) {
            final Point a = a(n);
            if (a != null && point.x >= a.x && point.y >= a.y) {
                return n;
            }
        }
        return -1;
    }
    
    public static Point a(final int n) {
        return (Point)by.b.get(n);
    }
    
    private static List a() {
        final ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(3);
        list.add(1);
        list.add(2);
        return Collections.unmodifiableList((List<?>)list);
    }
    
    private static SparseArray b() {
        final SparseArray sparseArray = new SparseArray();
        sparseArray.put(4, (Object)new Point(728, 90));
        sparseArray.put(3, (Object)new Point(480, 60));
        sparseArray.put(1, (Object)new Point(320, 50));
        sparseArray.put(2, (Object)new Point(300, 250));
        return sparseArray;
    }
}
