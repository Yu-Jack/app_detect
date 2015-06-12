// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api$b;
import com.google.android.gms.common.api.Api$c;

public final class ff
{
    public static final Api$c xI;
    private static final Api$b xJ;
    public static final Api xK;
    public static final ft xL;
    
    static {
        xI = new Api$c();
        xJ = new ff$1();
        xK = new Api(ff.xJ, ff.xI, new Scope[0]);
        xL = new fy();
    }
}
