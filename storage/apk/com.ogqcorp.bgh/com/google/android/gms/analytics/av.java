// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import android.os.Message;
import android.os.Handler$Callback;
import android.os.Handler;
import android.content.Context;

class av extends v
{
    private static final Object a;
    private static av o;
    private Context b;
    private ah c;
    private volatile aj d;
    private int e;
    private boolean f;
    private boolean g;
    private String h;
    private boolean i;
    private boolean j;
    private ai k;
    private Handler l;
    private au m;
    private boolean n;
    
    static {
        a = new Object();
    }
    
    private av() {
        this.e = 1800;
        this.f = true;
        this.i = true;
        this.j = true;
        this.k = new ai() {
            @Override
            public void a(final boolean b) {
                av.this.a(b, av.this.i);
            }
        };
        this.n = false;
    }
    
    public static av c() {
        if (av.o == null) {
            av.o = new av();
        }
        return av.o;
    }
    
    private void g() {
        (this.m = new au(this)).a(this.b);
    }
    
    private void h() {
        this.l = new Handler(this.b.getMainLooper(), (Handler$Callback)new Handler$Callback() {
            public boolean handleMessage(final Message message) {
                if (1 == message.what && av.a.equals(message.obj)) {
                    bd.a().a(true);
                    av.this.a();
                    bd.a().a(false);
                    if (av.this.e > 0 && !av.this.n) {
                        av.this.l.sendMessageDelayed(av.this.l.obtainMessage(1, av.a), (long)(1000 * av.this.e));
                    }
                }
                return true;
            }
        });
        if (this.e > 0) {
            this.l.sendMessageDelayed(this.l.obtainMessage(1, av.a), (long)(1000 * this.e));
        }
    }
    
    @Override
    void a() {
        synchronized (this) {
            if (this.d == null) {
                p.c("Dispatch call queued. Dispatch will run once initialization is complete.");
                this.f = true;
            }
            else {
                bd.a().a(be.S);
                this.d.a();
            }
        }
    }
    
    @Override
    void a(final int n) {
        synchronized (this) {
            if (this.l == null) {
                p.c("Dispatch period set with null handler. Dispatch will run once initialization is complete.");
                this.e = n;
            }
            else {
                bd.a().a(be.T);
                if (!this.n && this.i && this.e > 0) {
                    this.l.removeMessages(1, av.a);
                }
                if ((this.e = n) > 0 && !this.n && this.i) {
                    this.l.sendMessageDelayed(this.l.obtainMessage(1, av.a), (long)(n * 1000));
                }
            }
        }
    }
    
    void a(final Context context, final aj d) {
        synchronized (this) {
            if (this.b == null) {
                this.b = context.getApplicationContext();
                if (this.d == null) {
                    this.d = d;
                    if (this.f) {
                        this.a();
                        this.f = false;
                    }
                    if (this.g) {
                        this.e();
                        this.g = false;
                    }
                }
            }
        }
    }
    
    @Override
    void a(final boolean b) {
        synchronized (this) {
            this.a(this.n, b);
        }
    }
    
    void a(final boolean n, final boolean i) {
        while (true) {
            while (true) {
                Label_0157: {
                    Label_0150: {
                        synchronized (this) {
                            if (this.n != n || this.i != i) {
                                if ((n || !i) && this.e > 0) {
                                    this.l.removeMessages(1, av.a);
                                }
                                if (!n && i && this.e > 0) {
                                    this.l.sendMessageDelayed(this.l.obtainMessage(1, av.a), (long)(1000 * this.e));
                                }
                                final StringBuilder append = new StringBuilder().append("PowerSaveMode ");
                                if (!n && i) {
                                    break Label_0150;
                                }
                                break Label_0157;
                            }
                            return;
                            final StringBuilder append;
                            final String str;
                            p.c(append.append(str).toString());
                            this.n = n;
                            this.i = i;
                            return;
                        }
                    }
                    final String str = "terminated.";
                    continue;
                }
                final String str = "initiated.";
                continue;
            }
        }
    }
    
    @Override
    void b() {
        synchronized (this) {
            if (!this.n && this.i && this.e > 0) {
                this.l.removeMessages(1, av.a);
                this.l.sendMessage(this.l.obtainMessage(1, av.a));
            }
        }
    }
    
    ah d() {
        Label_0080: {
            synchronized (this) {
                if (this.c != null) {
                    break Label_0080;
                }
                if (this.b == null) {
                    throw new IllegalStateException("Cant get a store unless we have a context");
                }
            }
            this.c = new r(this.k, this.b);
            if (this.h != null) {
                this.c.d().a(this.h);
                this.h = null;
            }
        }
        if (this.l == null) {
            this.h();
        }
        if (this.m == null && this.j) {
            this.g();
        }
        // monitorexit(this)
        return this.c;
    }
    
    void e() {
        if (this.d == null) {
            p.c("setForceLocalDispatch() queued. It will be called once initialization is complete.");
            this.g = true;
            return;
        }
        bd.a().a(be.af);
        this.d.b();
    }
}
