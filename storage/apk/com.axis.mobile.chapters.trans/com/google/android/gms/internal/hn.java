// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.os.IBinder;
import com.google.android.gms.dynamic.g$a;
import com.google.android.gms.dynamic.e;
import android.view.View;
import android.content.Context;
import com.google.android.gms.dynamic.g;

public final class hn extends g
{
    private static final hn GL;
    
    static {
        GL = new hn();
    }
    
    private hn() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }
    
    public static View b(final Context context, final int n, final int n2) {
        return hn.GL.c(context, n, n2);
    }
    
    private View c(final Context context, final int i, final int j) {
        try {
            return (View)e.e(((hj)this.G(context)).a(e.h(context), i, j));
        }
        catch (Exception ex) {
            throw new g$a("Could not get button with size " + i + " and color " + j, ex);
        }
    }
    
    public hj N(final IBinder binder) {
        return hj$a.M(binder);
    }
}
