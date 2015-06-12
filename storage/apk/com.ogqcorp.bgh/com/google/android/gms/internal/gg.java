// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.c;
import java.util.Set;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class gg extends ga implements SafeParcelable
{
    public static final hq CREATOR;
    private final int a;
    private final Parcel b;
    private final int c;
    private final gd d;
    private final String e;
    private int f;
    private int g;
    
    static {
        CREATOR = new hq();
    }
    
    gg(final int a, final Parcel parcel, final gd d) {
        this.a = a;
        this.b = gz.a(parcel);
        this.c = 2;
        this.d = d;
        if (this.d == null) {
            this.e = null;
        }
        else {
            this.e = this.d.d();
        }
        this.f = 2;
    }
    
    public static HashMap<String, String> a(final Bundle bundle) {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        for (final String key : bundle.keySet()) {
            hashMap.put(key, bundle.getString(key));
        }
        return hashMap;
    }
    
    private static HashMap<Integer, Map.Entry<String, ga$a<?, ?>>> a(final HashMap<String, ga$a<?, ?>> hashMap) {
        final HashMap<Integer, Map.Entry<K, ga$a>> hashMap2 = (HashMap<Integer, Map.Entry<K, ga$a>>)new HashMap<Integer, Map.Entry<String, ga$a<?, ?>>>();
        for (final Map.Entry<String, ga$a<?, ?>> value : hashMap.entrySet()) {
            hashMap2.put(value.getValue().g(), value);
        }
        return (HashMap<Integer, Map.Entry<String, ga$a<?, ?>>>)hashMap2;
    }
    
    private void a(final StringBuilder sb, final int i, final Object obj) {
        switch (i) {
            default: {
                throw new IllegalArgumentException("Unknown type = " + i);
            }
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6: {
                sb.append(obj);
            }
            case 7: {
                sb.append("\"").append(hw.a(obj.toString())).append("\"");
            }
            case 8: {
                sb.append("\"").append(ht.a((byte[])obj)).append("\"");
            }
            case 9: {
                sb.append("\"").append(ht.b((byte[])obj));
                sb.append("\"");
            }
            case 10: {
                hx.a(sb, (HashMap<String, String>)obj);
            }
            case 11: {
                throw new IllegalArgumentException("Method does not accept concrete type.");
            }
        }
    }
    
    private void a(final StringBuilder sb, final ga$a<?, ?> ga$a, final Parcel parcel, final int n) {
        switch (ga$a.d()) {
            default: {
                throw new IllegalArgumentException("Unknown field out type = " + ga$a.d());
            }
            case 0: {
                this.a(sb, ga$a, this.a(ga$a, com.google.android.gms.common.internal.safeparcel.a.g(parcel, n)));
            }
            case 1: {
                this.a(sb, ga$a, this.a(ga$a, com.google.android.gms.common.internal.safeparcel.a.j(parcel, n)));
            }
            case 2: {
                this.a(sb, ga$a, this.a(ga$a, com.google.android.gms.common.internal.safeparcel.a.i(parcel, n)));
            }
            case 3: {
                this.a(sb, ga$a, this.a(ga$a, com.google.android.gms.common.internal.safeparcel.a.k(parcel, n)));
            }
            case 4: {
                this.a(sb, ga$a, this.a(ga$a, com.google.android.gms.common.internal.safeparcel.a.l(parcel, n)));
            }
            case 5: {
                this.a(sb, ga$a, this.a(ga$a, com.google.android.gms.common.internal.safeparcel.a.m(parcel, n)));
            }
            case 6: {
                this.a(sb, ga$a, this.a(ga$a, com.google.android.gms.common.internal.safeparcel.a.c(parcel, n)));
            }
            case 7: {
                this.a(sb, ga$a, this.a(ga$a, com.google.android.gms.common.internal.safeparcel.a.n(parcel, n)));
            }
            case 8:
            case 9: {
                this.a(sb, ga$a, this.a(ga$a, com.google.android.gms.common.internal.safeparcel.a.q(parcel, n)));
            }
            case 10: {
                this.a(sb, ga$a, this.a(ga$a, a(com.google.android.gms.common.internal.safeparcel.a.p(parcel, n))));
            }
            case 11: {
                throw new IllegalArgumentException("Method does not accept concrete type.");
            }
        }
    }
    
    private void a(final StringBuilder sb, final ga$a<?, ?> ga$a, final Object o) {
        if (ga$a.c()) {
            this.a(sb, ga$a, (ArrayList<?>)o);
            return;
        }
        this.a(sb, ga$a.b(), o);
    }
    
    private void a(final StringBuilder sb, final ga$a<?, ?> ga$a, final ArrayList<?> list) {
        sb.append("[");
        for (int size = list.size(), i = 0; i < size; ++i) {
            if (i != 0) {
                sb.append(",");
            }
            this.a(sb, ga$a.b(), list.get(i));
        }
        sb.append("]");
    }
    
    private void a(final StringBuilder sb, final String str, final ga$a<?, ?> ga$a, final Parcel parcel, final int n) {
        sb.append("\"").append(str).append("\":");
        if (ga$a.j()) {
            this.a(sb, ga$a, parcel, n);
            return;
        }
        this.b(sb, ga$a, parcel, n);
    }
    
    private void a(final StringBuilder sb, final HashMap<String, ga$a<?, ?>> hashMap, final Parcel parcel) {
        final HashMap<Integer, Map.Entry<String, ga$a<?, ?>>> a = a(hashMap);
        sb.append('{');
        final int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int n = 0;
        while (parcel.dataPosition() < b) {
            final int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            final Map.Entry<String, V> entry = (Map.Entry<String, V>)a.get(com.google.android.gms.common.internal.safeparcel.a.a(a2));
            if (entry != null) {
                if (n != 0) {
                    sb.append(",");
                }
                this.a(sb, entry.getKey(), (ga$a<?, ?>)entry.getValue(), parcel, a2);
                n = 1;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new b("Overread allowed size end=" + b, parcel);
        }
        sb.append('}');
    }
    
    private void b(final StringBuilder sb, final ga$a<?, ?> ga$a, final Parcel parcel, final int n) {
        if (ga$a.e()) {
            sb.append("[");
            switch (ga$a.d()) {
                default: {
                    throw new IllegalStateException("Unknown field type out.");
                }
                case 0: {
                    hr.a(sb, com.google.android.gms.common.internal.safeparcel.a.t(parcel, n));
                    break;
                }
                case 1: {
                    hr.a(sb, com.google.android.gms.common.internal.safeparcel.a.v(parcel, n));
                    break;
                }
                case 2: {
                    hr.a(sb, com.google.android.gms.common.internal.safeparcel.a.u(parcel, n));
                    break;
                }
                case 3: {
                    hr.a(sb, com.google.android.gms.common.internal.safeparcel.a.w(parcel, n));
                    break;
                }
                case 4: {
                    hr.a(sb, com.google.android.gms.common.internal.safeparcel.a.x(parcel, n));
                    break;
                }
                case 5: {
                    hr.a(sb, com.google.android.gms.common.internal.safeparcel.a.y(parcel, n));
                    break;
                }
                case 6: {
                    hr.a(sb, com.google.android.gms.common.internal.safeparcel.a.s(parcel, n));
                    break;
                }
                case 7: {
                    hr.a(sb, com.google.android.gms.common.internal.safeparcel.a.z(parcel, n));
                    break;
                }
                case 8:
                case 9:
                case 10: {
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                }
                case 11: {
                    final Parcel[] c = com.google.android.gms.common.internal.safeparcel.a.C(parcel, n);
                    for (int length = c.length, i = 0; i < length; ++i) {
                        if (i > 0) {
                            sb.append(",");
                        }
                        c[i].setDataPosition(0);
                        this.a(sb, ga$a.l(), c[i]);
                    }
                    break;
                }
            }
            sb.append("]");
            return;
        }
        switch (ga$a.d()) {
            default: {
                throw new IllegalStateException("Unknown field type out");
            }
            case 0: {
                sb.append(com.google.android.gms.common.internal.safeparcel.a.g(parcel, n));
            }
            case 1: {
                sb.append(com.google.android.gms.common.internal.safeparcel.a.j(parcel, n));
            }
            case 2: {
                sb.append(com.google.android.gms.common.internal.safeparcel.a.i(parcel, n));
            }
            case 3: {
                sb.append(com.google.android.gms.common.internal.safeparcel.a.k(parcel, n));
            }
            case 4: {
                sb.append(com.google.android.gms.common.internal.safeparcel.a.l(parcel, n));
            }
            case 5: {
                sb.append(com.google.android.gms.common.internal.safeparcel.a.m(parcel, n));
            }
            case 6: {
                sb.append(com.google.android.gms.common.internal.safeparcel.a.c(parcel, n));
            }
            case 7: {
                sb.append("\"").append(hw.a(com.google.android.gms.common.internal.safeparcel.a.n(parcel, n))).append("\"");
            }
            case 8: {
                sb.append("\"").append(ht.a(com.google.android.gms.common.internal.safeparcel.a.q(parcel, n))).append("\"");
            }
            case 9: {
                sb.append("\"").append(ht.b(com.google.android.gms.common.internal.safeparcel.a.q(parcel, n)));
                sb.append("\"");
            }
            case 10: {
                final Bundle p4 = com.google.android.gms.common.internal.safeparcel.a.p(parcel, n);
                final Set keySet = p4.keySet();
                keySet.size();
                sb.append("{");
                final Iterator<String> iterator = keySet.iterator();
                int n2 = 1;
                while (iterator.hasNext()) {
                    final String str = iterator.next();
                    if (n2 == 0) {
                        sb.append(",");
                    }
                    sb.append("\"").append(str).append("\"");
                    sb.append(":");
                    sb.append("\"").append(hw.a(p4.getString(str))).append("\"");
                    n2 = 0;
                }
                sb.append("}");
            }
            case 11: {
                final Parcel b = com.google.android.gms.common.internal.safeparcel.a.B(parcel, n);
                b.setDataPosition(0);
                this.a(sb, ga$a.l(), b);
            }
        }
    }
    
    public int a() {
        return this.a;
    }
    
    @Override
    protected Object a(final String s) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }
    
    @Override
    public HashMap<String, ga$a<?, ?>> b() {
        if (this.d == null) {
            return null;
        }
        return this.d.a(this.e);
    }
    
    @Override
    protected boolean b(final String s) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }
    
    public int describeContents() {
        final hq creator = gg.CREATOR;
        return 0;
    }
    
    public Parcel e() {
        switch (this.f) {
            case 0: {
                this.g = com.google.android.gms.common.internal.safeparcel.c.a(this.b);
                com.google.android.gms.common.internal.safeparcel.c.a(this.b, this.g);
                this.f = 2;
                break;
            }
            case 1: {
                com.google.android.gms.common.internal.safeparcel.c.a(this.b, this.g);
                this.f = 2;
                break;
            }
        }
        return this.b;
    }
    
    gd f() {
        switch (this.c) {
            default: {
                throw new IllegalStateException("Invalid creation type: " + this.c);
            }
            case 0: {
                return null;
            }
            case 1: {
                return this.d;
            }
            case 2: {
                return this.d;
            }
        }
    }
    
    @Override
    public String toString() {
        gz.a(this.d, "Cannot convert to JSON on client side.");
        final Parcel e = this.e();
        e.setDataPosition(0);
        final StringBuilder sb = new StringBuilder(100);
        this.a(sb, this.d.a(this.e), e);
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final hq creator = gg.CREATOR;
        hq.a(this, parcel, n);
    }
}
