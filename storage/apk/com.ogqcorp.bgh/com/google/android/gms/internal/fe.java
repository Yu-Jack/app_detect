// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class fe implements SafeParcelable
{
    private static final Object a;
    private static ClassLoader b;
    private static Integer c;
    private boolean d;
    
    static {
        a = new Object();
        fe.b = null;
        fe.c = null;
    }
    
    public fe() {
        this.d = false;
    }
    
    protected static ClassLoader A() {
        synchronized (fe.a) {
            return fe.b;
        }
    }
    
    protected static Integer B() {
        synchronized (fe.a) {
            return fe.c;
        }
    }
    
    private static boolean a(final Class<?> clazz) {
        try {
            return "SAFE_PARCELABLE_NULL_STRING".equals(clazz.getField("NULL").get(null));
        }
        catch (IllegalAccessException ex) {
            return false;
        }
        catch (NoSuchFieldException ex2) {
            return false;
        }
    }
    
    protected static boolean b(final String name) {
        final ClassLoader a = A();
        if (a == null) {
            return true;
        }
        try {
            return a(a.loadClass(name));
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    protected boolean C() {
        return this.d;
    }
}
