// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons;

import java.util.Iterator;
import android.graphics.Bitmap;
import android.os.Handler;
import android.graphics.Bitmap$Config;
import android.view.View;
import java.io.File;
import java.util.LinkedList;

class h extends Thread
{
    final /* synthetic */ g a;
    
    public h(final g a) {
        this.a = a;
        super("DecodeThread");
    }
    
    private void a(final j j) {
        j.g = k.b(j.c, j.e, -1);
        if (j.g == null) {
            this.a.a(j);
            return;
        }
        j.f.sendMessage(j.f.obtainMessage(0, (Object)j));
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                synchronized (this.a.c) {
                    while (this.a.c.isEmpty()) {
                        this.a.c.wait();
                    }
                }
            }
            catch (InterruptedException ex) {
                n.a("Release DecodeThread", new Object[0]);
                return;
            }
            final j j = this.a.c.removeFirst();
            // monitorexit(list)
            this.a(j);
        }
    }
}
