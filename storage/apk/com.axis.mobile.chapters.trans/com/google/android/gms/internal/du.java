// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.Collections;
import java.util.List;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class du implements SafeParcelable
{
    public static final dv CREATOR;
    public final int errorCode;
    public final List nt;
    public final List nu;
    public final long nx;
    public final String oA;
    public final int orientation;
    public final String qe;
    public final long qf;
    public final boolean qg;
    public final long qh;
    public final List qi;
    public final String qj;
    public final long qk;
    public final String ql;
    public final boolean qm;
    public final String qn;
    public final String qo;
    public final int versionCode;
    
    static {
        CREATOR = new dv();
    }
    
    public du(final int n) {
        this(7, null, null, null, n, null, -1L, false, -1L, null, -1L, -1, null, -1L, null, false, null, null);
    }
    
    public du(final int n, final long n2) {
        this(7, null, null, null, n, null, -1L, false, -1L, null, n2, -1, null, -1L, null, false, null, null);
    }
    
    du(final int versionCode, final String oa, final String qe, final List list, final int errorCode, final List list2, final long qf, final boolean qg, final long qh, final List list3, final long nx, final int orientation, final String qj, final long qk, final String ql, final boolean qm, final String qn, final String qo) {
        this.versionCode = versionCode;
        this.oA = oa;
        this.qe = qe;
        List<Object> unmodifiableList;
        if (list != null) {
            unmodifiableList = Collections.unmodifiableList((List<?>)list);
        }
        else {
            unmodifiableList = null;
        }
        this.nt = unmodifiableList;
        this.errorCode = errorCode;
        List<Object> unmodifiableList2;
        if (list2 != null) {
            unmodifiableList2 = Collections.unmodifiableList((List<?>)list2);
        }
        else {
            unmodifiableList2 = null;
        }
        this.nu = unmodifiableList2;
        this.qf = qf;
        this.qg = qg;
        this.qh = qh;
        List<Object> unmodifiableList3;
        if (list3 != null) {
            unmodifiableList3 = Collections.unmodifiableList((List<?>)list3);
        }
        else {
            unmodifiableList3 = null;
        }
        this.qi = unmodifiableList3;
        this.nx = nx;
        this.orientation = orientation;
        this.qj = qj;
        this.qk = qk;
        this.ql = ql;
        this.qm = qm;
        this.qn = qn;
        this.qo = qo;
    }
    
    public du(final String s, final String s2, final List list, final List list2, final long n, final boolean b, final long n2, final List list3, final long n3, final int n4, final String s3, final long n5, final String s4, final String s5) {
        this(7, s, s2, list, -2, list2, n, b, n2, list3, n3, n4, s3, n5, s4, false, null, s5);
    }
    
    public du(final String s, final String s2, final List list, final List list2, final long n, final boolean b, final long n2, final List list3, final long n3, final int n4, final String s3, final long n5, final String s4, final boolean b2, final String s5, final String s6) {
        this(7, s, s2, list, -2, list2, n, b, n2, list3, n3, n4, s3, n5, s4, b2, s5, s6);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        dv.a(this, parcel, n);
    }
}
