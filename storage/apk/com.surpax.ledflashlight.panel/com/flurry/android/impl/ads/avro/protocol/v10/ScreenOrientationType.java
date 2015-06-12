// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fn$q;
import com.flurry.sdk.fn;

public enum ScreenOrientationType
{
    public static final fn SCHEMA$;
    
    a("PORTRAIT", 0), 
    b("LANDSCAPE", 1), 
    c("UNKNOWN", 2);
    
    static {
        SCHEMA$ = new fn$q().a("{\"type\":\"enum\",\"name\":\"ScreenOrientationType\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"symbols\":[\"PORTRAIT\",\"LANDSCAPE\",\"UNKNOWN\"]}");
    }
    
    private ScreenOrientationType(final String name, final int ordinal) {
    }
}
