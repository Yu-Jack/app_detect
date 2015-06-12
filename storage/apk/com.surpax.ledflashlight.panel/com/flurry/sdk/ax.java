// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.io.Closeable;
import android.text.TextUtils;
import java.io.IOException;
import java.io.OutputStream;

public class ax extends as
{
    protected final aw a;
    protected final String b;
    protected aw$c c;
    
    public ax(final aw a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    protected OutputStream f() {
        if (this.c != null) {
            return this.c.a();
        }
        if (this.a == null) {
            throw new IOException("No cache specified");
        }
        if (TextUtils.isEmpty((CharSequence)this.b)) {
            throw new IOException("No cache key specified");
        }
        this.c = this.a.b(this.b);
        if (this.c == null) {
            throw new IOException("Could not open writer for key: " + this.b);
        }
        return this.c.a();
    }
    
    @Override
    protected void g() {
        fe.a(this.c);
        this.c = null;
    }
    
    @Override
    protected void h() {
        if (this.a != null && !TextUtils.isEmpty((CharSequence)this.b)) {
            this.a.c(this.b);
        }
    }
}
