// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.content.ActivityNotFoundException;
import android.content.Intent;

abstract class s extends o
{
    final /* synthetic */ m c;
    
    s(final m c) {
        this.c = c;
        super(c);
    }
    
    protected final boolean a(final Intent intent, final int n) {
        if (intent == null) {
            return false;
        }
        try {
            this.c.c().a(intent, n);
            return true;
        }
        catch (ActivityNotFoundException ex) {
            return false;
        }
    }
}
