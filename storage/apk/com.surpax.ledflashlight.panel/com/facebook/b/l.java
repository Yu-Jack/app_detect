// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import android.graphics.Bitmap;
import java.io.InputStream;
import java.net.URI;
import java.io.Closeable;
import android.graphics.BitmapFactory;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import android.os.Handler;
import android.content.Context;

final class l implements Runnable
{
    private Context a;
    private o b;
    private boolean c;
    
    l(final Context a, final o b, final boolean c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void run() {
        k.a(this.b, this.a, this.c);
    }
}
