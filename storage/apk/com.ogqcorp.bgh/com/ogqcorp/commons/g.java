// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons;

import java.util.Iterator;
import android.os.Handler;
import android.graphics.Bitmap$Config;
import android.view.View;
import java.io.File;
import java.util.LinkedList;

public final class g
{
    private static final g a;
    private LinkedList<Thread> b;
    private LinkedList<j> c;
    private LinkedList<j> d;
    
    static {
        a = new g();
    }
    
    public g() {
        this.b = new LinkedList<Thread>();
        this.c = new LinkedList<j>();
        this.d = new LinkedList<j>();
    }
    
    public static g a() {
        return g.a;
    }
    
    private void a(final j e) {
        synchronized (this.d) {
            this.d.addFirst(e);
            this.d.notifyAll();
        }
    }
    
    public void a(final Object o, final String s, final File file, final View view, final Bitmap$Config bitmap$Config, final Handler handler) {
        synchronized (this.c) {
            this.c.addFirst(new j(o, s, file, view, bitmap$Config, handler));
            this.c.notifyAll();
        }
    }
    
    public void b() {
        synchronized (this) {
            if (this.b.isEmpty()) {
                int n = 0;
                int i;
                while (true) {
                    i = 0;
                    if (n >= 2) {
                        break;
                    }
                    this.b.add(new h(this));
                    ++n;
                }
                while (i < 4) {
                    this.b.add(new i(this));
                    ++i;
                }
                for (final Thread thread : this.b) {
                    thread.setPriority(3);
                    thread.start();
                }
            }
        }
    }
    // monitorexit(this)
    
    public void c() {
        synchronized (this) {
            for (final Thread thread : this.b) {
                thread.interrupt();
                try {
                    thread.join(1000L);
                }
                catch (InterruptedException ex) {
                    n.c(ex);
                }
            }
        }
        this.b.clear();
    }
    // monitorexit(this)
}
