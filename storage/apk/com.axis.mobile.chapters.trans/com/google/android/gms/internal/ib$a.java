// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ib$a implements SafeParcelable
{
    public static final id CREATOR;
    final ArrayList Ho;
    final String className;
    final int versionCode;
    
    static {
        CREATOR = new id();
    }
    
    ib$a(final int versionCode, final String className, final ArrayList ho) {
        this.versionCode = versionCode;
        this.className = className;
        this.Ho = ho;
    }
    
    ib$a(final String className, final HashMap hashMap) {
        this.versionCode = 1;
        this.className = className;
        this.Ho = a(hashMap);
    }
    
    private static ArrayList a(final HashMap hashMap) {
        if (hashMap == null) {
            return null;
        }
        final ArrayList<ib$b> list = new ArrayList<ib$b>();
        for (final String key : hashMap.keySet()) {
            list.add(new ib$b(key, (hy$a)hashMap.get(key)));
        }
        return list;
    }
    
    public int describeContents() {
        final id creator = ib$a.CREATOR;
        return 0;
    }
    
    HashMap fX() {
        final HashMap<String, hy$a> hashMap = new HashMap<String, hy$a>();
        for (int size = this.Ho.size(), i = 0; i < size; ++i) {
            final ib$b ib$b = this.Ho.get(i);
            hashMap.put(ib$b.eM, ib$b.Hp);
        }
        return hashMap;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final id creator = ib$a.CREATOR;
        id.a(this, parcel, n);
    }
}
