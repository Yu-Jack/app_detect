// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import java.net.URLConnection;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.io.BufferedInputStream;

final class u extends BufferedInputStream
{
    HttpURLConnection a;
    
    u(final InputStream in, final HttpURLConnection a) {
        super(in, 8192);
        this.a = a;
    }
    
    @Override
    public final void close() {
        super.close();
        aj.a(this.a);
    }
}
