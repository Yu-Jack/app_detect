// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Collection;
import java.util.Arrays;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.h;

public class ip extends h<DriveId>
{
    public static final ip a;
    
    static {
        a = new ip();
    }
    
    private ip() {
        super("driveId", Arrays.asList("sqlId", "resourceId"), 4100000);
    }
}
