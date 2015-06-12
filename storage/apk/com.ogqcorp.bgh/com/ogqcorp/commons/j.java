// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons;

import android.graphics.Bitmap;
import android.os.Handler;
import android.graphics.Bitmap$Config;
import android.view.View;
import java.io.File;

public class j
{
    public final Object a;
    public final String b;
    public final File c;
    public final View d;
    public final Bitmap$Config e;
    public final Handler f;
    private Bitmap g;
    private int h;
    
    public j(final Object a, final String b, final File c, final View d, final Bitmap$Config e, final Handler f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public Bitmap a() {
        return this.g;
    }
    
    public void b() {
        if (this.g != null) {
            this.g.recycle();
            this.g = null;
        }
    }
}
