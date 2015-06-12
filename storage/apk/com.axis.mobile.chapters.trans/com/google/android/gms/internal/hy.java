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

public abstract class hy
{
    private void a(final StringBuilder sb, final hy$a hy$a, final Object o) {
        if (hy$a.fE() == 11) {
            sb.append(hy$a.fO().cast(o).toString());
            return;
        }
        if (hy$a.fE() == 7) {
            sb.append("\"");
            sb.append(in.aK((String)o));
            sb.append("\"");
            return;
        }
        sb.append(o);
    }
    
    private void a(final StringBuilder sb, final hy$a hy$a, final ArrayList list) {
        sb.append("[");
        for (int i = 0; i < list.size(); ++i) {
            if (i > 0) {
                sb.append(",");
            }
            final Object value = list.get(i);
            if (value != null) {
                this.a(sb, hy$a, value);
            }
        }
        sb.append("]");
    }
    
    protected Object a(final hy$a hy$a, Object g) {
        if (hy$a.Hk != null) {
            g = hy$a.g(g);
        }
        return g;
    }
    
    protected boolean a(final hy$a hy$a) {
        if (hy$a.fF() != 11) {
            return this.aG(hy$a.fM());
        }
        if (hy$a.fL()) {
            return this.aI(hy$a.fM());
        }
        return this.aH(hy$a.fM());
    }
    
    protected abstract Object aF(final String p0);
    
    protected abstract boolean aG(final String p0);
    
    protected boolean aH(final String s) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }
    
    protected boolean aI(final String s) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }
    
    protected Object b(final hy$a hy$a) {
        final String fm = hy$a.fM();
        if (hy$a.fO() != null) {
            hm.a(this.aF(hy$a.fM()) == null, "Concrete field shouldn't be value object: %s", hy$a.fM());
            HashMap hashMap;
            if (hy$a.fL()) {
                hashMap = this.fI();
            }
            else {
                hashMap = this.fH();
            }
            if (hashMap != null) {
                return hashMap.get(fm);
            }
            try {
                return this.getClass().getMethod("get" + Character.toUpperCase(fm.charAt(0)) + fm.substring(1), (Class<?>[])new Class[0]).invoke(this, new Object[0]);
            }
            catch (Exception cause) {
                throw new RuntimeException(cause);
            }
        }
        return this.aF(hy$a.fM());
    }
    
    public abstract HashMap fG();
    
    public HashMap fH() {
        return null;
    }
    
    public HashMap fI() {
        return null;
    }
    
    @Override
    public String toString() {
        final HashMap fg = this.fG();
        final StringBuilder sb = new StringBuilder(100);
        for (final String s : fg.keySet()) {
            final hy$a hy$a = (hy$a)fg.get(s);
            if (this.a(hy$a)) {
                final Object a = this.a(hy$a, this.b(hy$a));
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
                    switch (hy$a.fF()) {
                        default: {
                            if (hy$a.fK()) {
                                this.a(sb, hy$a, (ArrayList)a);
                                continue;
                            }
                            this.a(sb, hy$a, a);
                            continue;
                        }
                        case 8: {
                            sb.append("\"").append(ih.d((byte[])a)).append("\"");
                            continue;
                        }
                        case 9: {
                            sb.append("\"").append(ih.e((byte[])a)).append("\"");
                            continue;
                        }
                        case 10: {
                            io.a(sb, (HashMap)a);
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
