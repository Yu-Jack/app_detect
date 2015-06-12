// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.common;

import android.content.Intent;

public class h extends Exception
{
    private final Intent a;
    
    public h(final String message, final Intent a) {
        super(message);
        this.a = a;
    }
}
