// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;

public class b extends RuntimeException
{
    public b(final String str, final Parcel parcel) {
        super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
    }
}
