// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import android.graphics.Point;
import android.content.Context;

public final class z
{
    private static final int[] a;
    private int[] b;
    
    static {
        a = new int[] { 360, 720, 1280 };
    }
    
    public z() {
        this.b = z.a;
    }
    
    private int[] a(final Context context, final Point point) {
        final int[] intArray = context.getResources().getIntArray(2131558401);
        final int[] intArray2 = context.getResources().getIntArray(2131558402);
        for (int i = 0; i < intArray.length; ++i) {
            if (point.x == intArray[i] && point.y == intArray2[i]) {
                return new int[] { context.getResources().getIntArray(2131558403)[i], context.getResources().getIntArray(2131558404)[i], context.getResources().getIntArray(2131558405)[i] };
            }
        }
        return null;
    }
    
    private Point b(final Context context) {
        final Point c = ac.c(context);
        if (c.x > c.y) {
            return new Point(c.y, c.x);
        }
        return c;
    }
    
    public void a(final Context context) {
        synchronized (this) {
            final Point b = this.b(context);
            this.b = this.a(context, b);
            if (this.b == null) {
                this.b = z.a;
                throw new aa(b.x, b.y);
            }
        }
    }
    // monitorexit(this)
    
    public int[] a() {
        synchronized (this) {
            return this.b;
        }
    }
}
