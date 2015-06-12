// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;

public abstract class ga
{
    private void a(final StringBuilder sb, final ga$a ga$a, final Object o) {
        if (ga$a.b() == 11) {
            sb.append(((ga)ga$a.h().cast(o)).toString());
            return;
        }
        if (ga$a.b() == 7) {
            sb.append("\"");
            sb.append(hw.a((String)o));
            sb.append("\"");
            return;
        }
        sb.append(o);
    }
    
    private void a(final StringBuilder sb, final ga$a ga$a, final ArrayList<Object> list) {
        sb.append("[");
        for (int i = 0; i < list.size(); ++i) {
            if (i > 0) {
                sb.append(",");
            }
            final Object value = list.get(i);
            if (value != null) {
                this.a(sb, ga$a, value);
            }
        }
        sb.append("]");
    }
    
    protected <O, I> I a(final ga$a<I, O> ga$a, Object a) {
        if (((ga$a<Object, Object>)ga$a).k != null) {
            a = ga$a.a(a);
        }
        return (I)a;
    }
    
    protected abstract Object a(final String p0);
    
    protected boolean a(final ga$a ga$a) {
        if (ga$a.d() != 11) {
            return this.b(ga$a.f());
        }
        if (ga$a.e()) {
            return this.d(ga$a.f());
        }
        return this.c(ga$a.f());
    }
    
    protected Object b(final ga$a ga$a) {
        boolean b = true;
        final String f = ga$a.f();
        if (ga$a.h() != null) {
            if (this.a(ga$a.f()) != null) {
                b = false;
            }
            gz.a(b, (Object)("Concrete field shouldn't be value object: " + ga$a.f()));
            HashMap<String, Object> hashMap;
            if (ga$a.e()) {
                hashMap = this.d();
            }
            else {
                hashMap = this.c();
            }
            if (hashMap != null) {
                return hashMap.get(f);
            }
            try {
                return this.getClass().getMethod("get" + Character.toUpperCase(f.charAt(0)) + f.substring(1), (Class<?>[])new Class[0]).invoke(this, new Object[0]);
            }
            catch (Exception cause) {
                throw new RuntimeException(cause);
            }
        }
        return this.a(ga$a.f());
    }
    
    public abstract HashMap<String, ga$a<?, ?>> b();
    
    protected abstract boolean b(final String p0);
    
    public HashMap<String, Object> c() {
        return null;
    }
    
    protected boolean c(final String s) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }
    
    public HashMap<String, Object> d() {
        return null;
    }
    
    protected boolean d(final String s) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }
    
    @Override
    public String toString() {
        final HashMap<String, ga$a<?, ?>> b = this.b();
        final StringBuilder sb = new StringBuilder(100);
        for (final String s : b.keySet()) {
            final ga$a<Object, Object> ga$a = b.get(s);
            if (this.a(ga$a)) {
                final HashMap<String, String> a = this.a((ga$a<HashMap<String, String>, Object>)ga$a, this.b(ga$a));
                if (sb.length() == 0) {
                    sb.append("{");
                }
                else {
                    sb.append(",");
                }
                sb.append("\"").append(s).append("\":");
                if (a == null) {
                    sb.append("null");
                }
                else {
                    switch (ga$a.d()) {
                        default: {
                            if (ga$a.c()) {
                                this.a(sb, ga$a, (ArrayList<Object>)a);
                                continue;
                            }
                            this.a(sb, ga$a, a);
                            continue;
                        }
                        case 8: {
                            sb.append("\"").append(ht.a((byte[])(Object)a)).append("\"");
                            continue;
                        }
                        case 9: {
                            sb.append("\"").append(ht.b((byte[])(Object)a)).append("\"");
                            continue;
                        }
                        case 10: {
                            hx.a(sb, a);
                            continue;
                        }
                    }
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        }
        else {
            sb.append("{}");
        }
        return sb.toString();
    }
}
