// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.common.images;

import java.util.Map;
import com.google.android.gms.internal.ft;
import java.util.concurrent.ExecutorService;
import android.os.Handler;
import android.content.Context;
import java.util.HashSet;
import android.os.ParcelFileDescriptor;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.gms.internal.fw;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import android.graphics.Bitmap;
import android.net.Uri;

final class d implements Runnable
{
    final /* synthetic */ ImageManager a;
    private final Uri b;
    private final Bitmap c;
    private final CountDownLatch d;
    private boolean e;
    
    public d(final ImageManager a, final Uri b, final Bitmap c, final boolean e, final CountDownLatch d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.e = e;
        this.d = d;
    }
    
    private void a(final ImageManager$ImageReceiver imageManager$ImageReceiver, final boolean b) {
        final ArrayList a = imageManager$ImageReceiver.c;
        for (int size = a.size(), i = 0; i < size; ++i) {
            final e e = a.get(i);
            if (b) {
                e.a(this.a.c, this.c, false);
            }
            else {
                e.a(this.a.c, this.a.g, false);
            }
            if (!(e instanceof g)) {
                this.a.h.remove(e);
            }
        }
    }
    
    @Override
    public void run() {
        fw.a("OnBitmapLoadedRunnable must be executed in the main thread");
        final boolean b = this.c != null;
        if (this.a.f != null) {
            if (this.e) {
                this.a.f.a();
                System.gc();
                this.e = false;
                this.a.d.post((Runnable)this);
                return;
            }
            if (b) {
                this.a.f.b(new f(this.b), this.c);
            }
        }
        final ImageManager$ImageReceiver imageManager$ImageReceiver = this.a.i.remove(this.b);
        if (imageManager$ImageReceiver != null) {
            this.a(imageManager$ImageReceiver, b);
        }
        this.d.countDown();
        synchronized (ImageManager.a) {
            ImageManager.b.remove(this.b);
        }
    }
}
