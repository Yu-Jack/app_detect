// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.c.b;

import java.io.File;
import com.a.a.a.c;

class g extends c
{
    final /* synthetic */ e a;
    
    public g(final e a, final File file) {
        this.a = a;
        super(file, 52428800);
    }
    
    @Override
    public void a(final String s, final com.a.a.c c) {
        synchronized (this) {
            if (c.d == 0L) {
                final long n = 300000L + System.currentTimeMillis();
                c.e = n;
                c.d = n;
            }
            super.a(s, c);
        }
    }
}
