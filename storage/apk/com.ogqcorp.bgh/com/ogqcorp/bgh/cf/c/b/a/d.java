// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.c.b.a;

import java.util.LinkedList;
import com.a.a.n;
import com.a.a.r;
import android.graphics.Bitmap$Config;
import com.a.a.s;
import java.util.Iterator;
import com.a.a.x;
import android.os.Looper;
import android.os.Handler;
import java.util.HashMap;
import com.a.a.p;
import android.graphics.drawable.Drawable;

public class d
{
    final /* synthetic */ a a;
    private Drawable b;
    private final e c;
    private final String d;
    private final String e;
    
    public d(final a a, final Drawable b, final String e, final String d, final e c) {
        this.a = a;
        this.b = b;
        this.e = e;
        this.d = d;
        this.c = c;
    }
    
    public void a() {
        if (this.c != null) {
            final b b = this.a.d.get(this.d);
            if (b != null) {
                if (b.b(this)) {
                    this.a.d.remove(this.d);
                }
            }
            else {
                final b b2 = this.a.e.get(this.d);
                if (b2 != null) {
                    b2.b(this);
                    if (b2.e.size() == 0) {
                        this.a.e.remove(this.d);
                    }
                }
            }
        }
    }
    
    public Drawable b() {
        return this.b;
    }
    
    public String c() {
        return this.e;
    }
}
