// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public final class c
{
    private static final b<?, ?> a(final FragmentManager fragmentManager, final Object o) {
        if (o instanceof Integer) {
            return (b<?, ?>)fragmentManager.findFragmentById((int)o);
        }
        if (o instanceof String) {
            return (b<?, ?>)fragmentManager.findFragmentByTag((String)o);
        }
        if (o instanceof b) {
            return (b<?, ?>)o;
        }
        throw new IllegalArgumentException();
    }
    
    public static final <Progress, Result> u<Result> a(final b<Progress, Result>... array) {
        return new u<Result>() {
            @Override
            public void a(final Result result) {
                final b[] a = array;
                for (int length = a.length, i = 0; i < length; ++i) {
                    a[i].a(result);
                }
            }
        };
    }
    
    public static final <Progress, Result> void a(final FragmentActivity fragmentActivity, final int n, final String s, final long n2, final String s2, final r r, final org.codehaus.jackson.f.b<ProtocolBase$InnerData<Result>> b, final Object... array) {
        final b<Object, Object>[] a = a(fragmentActivity, array);
        r.a((Context)fragmentActivity, n, s, n2, s2, b, (u<Result>)a((b<Object, T>[])a), b(a));
    }
    
    public static final <Progress, Result> void a(final FragmentActivity fragmentActivity, final int n, final String s, final r r, final org.codehaus.jackson.f.b<ProtocolBase$InnerData<Result>> b, final Object... array) {
        final b<Object, Object>[] a = a(fragmentActivity, array);
        r.a((Context)fragmentActivity, n, s, b, (u<Result>)a((b<Object, T>[])a), b(a));
    }
    
    private static final <Progress, Result> b<Progress, Result>[] a(final FragmentActivity fragmentActivity, final Object... array) {
        final FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        final b[] array2 = new b[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = a(supportFragmentManager, array[i]);
        }
        return (b<Progress, Result>[])array2;
    }
    
    public static final <Progress, Result> u<Exception> b(final b<Progress, Result>... array) {
        return new u<Exception>() {
            @Override
            public void a(final Exception ex) {
                final b[] a = array;
                for (int length = a.length, i = 0; i < length; ++i) {
                    a[i].a(ex);
                }
            }
        };
    }
}
