// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;

final class fd$1 implements Parcelable$Creator
{
    @Deprecated
    public fd[] C(final int n) {
        return new fd[n];
    }
    
    @Deprecated
    public fd k(final Parcel parcel) {
        return new fd(parcel);
    }
}
