// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class gd implements SafeParcelable
{
    public static final hn CREATOR;
    private final int a;
    private final HashMap<String, HashMap<String, ga$a<?, ?>>> b;
    private final ArrayList<gd$a> c;
    private final String d;
    
    static {
        CREATOR = new hn();
    }
    
    gd(final int a, final ArrayList<gd$a> list, final String s) {
        this.a = a;
        this.c = null;
        this.b = a(list);
        this.d = gz.a(s);
        this.a();
    }
    
    private static HashMap<String, HashMap<String, ga$a<?, ?>>> a(final ArrayList<gd$a> list) {
        final HashMap<String, HashMap<String, ga$a<?, ?>>> hashMap = new HashMap<String, HashMap<String, ga$a<?, ?>>>();
        for (int size = list.size(), i = 0; i < size; ++i) {
            final gd$a gd$a = list.get(i);
            hashMap.put(gd$a.b, gd$a.a());
        }
        return hashMap;
    }
    
    public HashMap<String, ga$a<?, ?>> a(final String key) {
        return this.b.get(key);
    }
    
    public void a() {
        final Iterator<String> iterator = this.b.keySet().iterator();
        while (iterator.hasNext()) {
            final HashMap<String, ga$a<?, ?>> hashMap = this.b.get(iterator.next());
            final Iterator<String> iterator2 = hashMap.keySet().iterator();
            while (iterator2.hasNext()) {
                hashMap.get(iterator2.next()).a(this);
            }
        }
    }
    
    int b() {
        return this.a;
    }
    
    ArrayList<gd$a> c() {
        final ArrayList<gd$a> list = new ArrayList<gd$a>();
        for (final String key : this.b.keySet()) {
            list.add(new gd$a(key, this.b.get(key)));
        }
        return list;
    }
    
    public String d() {
        return this.d;
    }
    
    public int describeContents() {
        final hn creator = gd.CREATOR;
        return 0;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final String s : this.b.keySet()) {
            sb.append(s).append(":\n");
            final HashMap<String, ga$a<?, ?>> hashMap = this.b.get(s);
            for (final String s2 : hashMap.keySet()) {
                sb.append("  ").append(s2).append(": ");
                sb.append(hashMap.get(s2));
            }
        }
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final hn creator = gd.CREATOR;
        hn.a(this, parcel, n);
    }
}
