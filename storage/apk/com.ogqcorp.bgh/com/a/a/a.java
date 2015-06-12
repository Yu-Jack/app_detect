// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a;

import android.content.Intent;

public class a extends x
{
    private Intent b;
    
    public a() {
    }
    
    public a(final k k) {
        super(k);
    }
    
    @Override
    public String getMessage() {
        if (this.b != null) {
            return "User needs to (re)enter credentials.";
        }
        return super.getMessage();
    }
}
