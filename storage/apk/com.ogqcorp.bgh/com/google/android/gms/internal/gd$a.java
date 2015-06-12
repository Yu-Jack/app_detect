// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class gd$a implements SafeParcelable
{
    public static final hp CREATOR;
    final int a;
    final String b;
    final ArrayList<gd$b> c;
    
    static {
        CREATOR = new hp();
    }
    
    gd$a(final int a, final String b, final ArrayList<gd$b> c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    gd$a(final String b, final HashMap<String, ga$a<?, ?>> hashMap) {
        this.a = 1;
        this.b = b;
        this.c = a(hashMap);
    }
    
    private static ArrayList<gd$b> a(final HashMap<String, ga$a<?, ?>> hashMap) {
        if (hashMap == null) {
            return null;
        }
        final ArrayList<gd$b> list = new ArrayList<gd$b>();
        for (final String key : hashMap.keySet()) {
            list.add(new gd$b(key, hashMap.get(key)));
        }
        return list;
    }
    
    HashMap<String, ga$a<?, ?>> a() {
        final HashMap<String, ga$a<?, ?>> hashMap = new HashMap<String, ga$a<?, ?>>();
        for (int size = this.c.size(), i = 0; i < size; ++i) {
            final gd$b gd$b = this.c.get(i);
            hashMap.put(gd$b.b, gd$b.c);
        }
        return hashMap;
    }
    
    public int describeContents() {
        final hp creator = gd$a.CREATOR;
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final hp creator = gd$a.CREATOR;
        hp.a(this, parcel, n);
    }
}
