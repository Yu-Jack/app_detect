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

final class m implements Runnable
{
    private Context a;
    private o b;
    
    m(final Context a, final o b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        k.a(this.b, this.a);
    }
}
