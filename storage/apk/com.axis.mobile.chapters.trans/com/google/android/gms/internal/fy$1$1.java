// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a$d;

class fy$1$1 extends fw
{
    final /* synthetic */ fy$1 yv;
    
    fy$1$1(final fy$1 yv, final a$d a$d) {
        this.yv = yv;
        super(a$d);
    }
    
    @Override
    public void a(final Status status, final ParcelFileDescriptor parcelFileDescriptor) {
        this.yu.a(new fy$b(status, parcelFileDescriptor));
    }
}
