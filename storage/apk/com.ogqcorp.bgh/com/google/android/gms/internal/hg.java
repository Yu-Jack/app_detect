// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Collection;
import java.util.HashSet;
import java.util.Collections;
import java.util.Set;
import java.util.List;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class hg implements SafeParcelable
{
    public static final it CREATOR;
    final int a;
    final List<hm> b;
    private final String c;
    private final boolean d;
    private final Set<hm> e;
    
    static {
        CREATOR = new it();
    }
    
    hg(final int a, final List<hm> list, String c, final boolean d) {
        this.a = a;
        List<hm> b;
        if (list == null) {
            b = Collections.emptyList();
        }
        else {
            b = Collections.unmodifiableList((List<? extends hm>)list);
        }
        this.b = b;
        if (c == null) {
            c = "";
        }
        this.c = c;
        this.d = d;
        if (this.b.isEmpty()) {
            this.e = Collections.emptySet();
            return;
        }
        this.e = Collections.unmodifiableSet((Set<? extends hm>)new HashSet<hm>(this.b));
    }
    
    @Deprecated
    public String a() {
        return this.c;
    }
    
    public boolean b() {
        return this.d;
    }
    
    public int describeContents() {
        final it creator = hg.CREATOR;
        return 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof hg)) {
                return false;
            }
            final hg hg = (hg)o;
            if (!this.e.equals(hg.e) || this.d != hg.d) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        return gw.a(new Object[] { this.e, this.d });
    }
    
    @Override
    public String toString() {
        return gw.a(this).a("types", this.e).a("requireOpenNow", this.d).toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final it creator = hg.CREATOR;
        it.a(this, parcel, n);
    }
}
