// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import android.os.IInterface;

public interface fv extends IInterface
{
    void a(Status p0);
    
    void a(Status p0, ParcelFileDescriptor p1);
    
    void a(Status p0, boolean p1);
}
