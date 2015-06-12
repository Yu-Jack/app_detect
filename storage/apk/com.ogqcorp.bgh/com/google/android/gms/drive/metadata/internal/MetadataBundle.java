// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import com.google.android.gms.internal.gw;
import java.util.HashSet;
import com.google.android.gms.drive.metadata.a;
import java.util.Set;
import java.util.Iterator;
import android.util.Log;
import java.util.ArrayList;
import com.google.android.gms.internal.gz;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class MetadataBundle implements SafeParcelable
{
    public static final Parcelable$Creator<MetadataBundle> CREATOR;
    final int a;
    final Bundle b;
    
    static {
        CREATOR = (Parcelable$Creator)new f();
    }
    
    MetadataBundle(final int a, final Bundle bundle) {
        this.a = a;
        (this.b = gz.a(bundle)).setClassLoader(this.getClass().getClassLoader());
        final ArrayList<String> list = new ArrayList<String>();
        for (final String str : this.b.keySet()) {
            if (c.a(str) == null) {
                list.add(str);
                Log.w("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
            }
        }
        final Iterator<Object> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            this.b.remove((String)iterator2.next());
        }
    }
    
    public Set<a<?>> a() {
        final HashSet<a<?>> set = new HashSet<a<?>>();
        final Iterator<String> iterator = this.b.keySet().iterator();
        while (iterator.hasNext()) {
            set.add(c.a(iterator.next()));
        }
        return set;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MetadataBundle)) {
            return false;
        }
        final MetadataBundle metadataBundle = (MetadataBundle)o;
        final Set keySet = this.b.keySet();
        if (!keySet.equals(metadataBundle.b.keySet())) {
            return false;
        }
        for (final String s : keySet) {
            if (!gw.a(this.b.get(s), metadataBundle.b.get(s))) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        final Iterator<String> iterator = this.b.keySet().iterator();
        int n = 1;
        while (iterator.hasNext()) {
            n = n * 31 + this.b.get((String)iterator.next()).hashCode();
        }
        return n;
    }
    
    @Override
    public String toString() {
        return "MetadataBundle [values=" + this.b + "]";
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        f.a(this, parcel, n);
    }
}
