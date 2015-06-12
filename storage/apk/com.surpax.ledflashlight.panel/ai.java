import java.util.Vector;
import com.nuance.nmdp.speechkit.recognitionresult.b;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ai
{
    private static final z a;
    private final aa b;
    private final af c;
    private cc d;
    private final Object e;
    private final bz f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private final Object k;
    private final Object l;
    
    static {
        a = new z();
    }
    
    public ai(final dn dn, final boolean b, final boolean b2, final Object e, final Object l, final af c) {
        this.f = new bz() {
            private int a = 0;
            private boolean b = false;
            
            private void a() {
                synchronized (ai.this.k) {
                    ai.this.i = true;
                    if (ai.this.j) {
                        ai.this.k.notify();
                        ai.this.j = false;
                    }
                }
            }
            
            @Override
            public final void a(final cc cc, final String str, final Object o) {
                if (cc != ai.this.d) {
                    com.nuance.nmdp.speechkit.recognitionresult.b.b(ai.this, "Event " + str + " received for invalid recorder");
                }
                else if (str == "BUFFER_RECORDED") {
                    if (o instanceof Float) {
                        final af h = ai.this.c;
                        ai.this.e;
                        h.a((float)o);
                    }
                }
                else {
                    if (str == "STARTED") {
                        this.b = true;
                        final af h2 = ai.this.c;
                        ai.this.e;
                        h2.a();
                        return;
                    }
                    if (str == "STOPPED") {
                        com.nuance.nmdp.speechkit.recognitionresult.b.a(ai.this, "Recorder stopped");
                        this.a();
                        final af h3 = ai.this.c;
                        ai.this.e;
                        h3.a(this.a);
                        return;
                    }
                    if (str == "RECORD_ERROR") {
                        com.nuance.nmdp.speechkit.recognitionresult.b.c(ai.this, "Recorder error");
                        this.a = 4;
                        if (!this.b) {
                            this.a();
                            final af h4 = ai.this.c;
                            ai.this.e;
                            h4.a(this.a);
                        }
                    }
                    else {
                        if (str == "END_OF_SPEECH") {
                            com.nuance.nmdp.speechkit.recognitionresult.b.a(ai.this, "Recorder event (end of speech)");
                            this.a = 2;
                            return;
                        }
                        if (str == "CAPTURE_TIMEOUT") {
                            com.nuance.nmdp.speechkit.recognitionresult.b.a(ai.this, "Recorder event (timeout)");
                            this.a = 3;
                        }
                    }
                }
            }
        };
        this.c = c;
        this.e = e;
        this.g = false;
        this.h = false;
        this.j = false;
        this.i = false;
        this.k = new Object();
        this.l = l;
        while (true) {
            Label_0217: {
                if (ai.a.f() != 0) {
                    break Label_0217;
                }
                final aa a = null;
                this.b = a;
                final z z = new z();
                if (this.b == null) {
                    if (b) {
                        z.a(new df("ep.enable", "TRUE".getBytes(), dg.a));
                    }
                    else if (b2) {
                        z.a(new df("ep.enable", "TRUE".getBytes(), dg.a));
                        z.a(new df("ep.VadLongUtterance", "TRUE".getBytes(), dg.a));
                    }
                }
                z.a(new df("USE_ENERGY_LEVEL", "TRUE".getBytes(), dg.a));
                z.a(new df("Android_Context", this.l, dg.a));
                bz f = null;
                Vector c2 = null;
                ak a2 = null;
                Label_0282: {
                    try {
                        f = this.f;
                        c2 = z.c();
                        a2 = ak.a;
                        if (f == null) {
                            throw new NullPointerException("NMSPAudioRecordListener can not be null!");
                        }
                        break Label_0282;
                    }
                    catch (Throwable t) {
                        com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error creating recorder", t);
                        this.d = null;
                        return;
                    }
                    break Label_0217;
                }
                if (dn == null) {
                    throw new NullPointerException("Manager can not be null!");
                }
                this.d = new dm(f, dn, c2, a2);
                return;
            }
            final aa a = ai.a.b().a();
            continue;
        }
    }
    
    static /* synthetic */ z c() {
        return null;
    }
    
    public final void a() {
        if (!this.g) {
            this.g = true;
            if (this.d != null) {
                try {
                    com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Starting recorder");
                    this.d.f();
                    return;
                }
                catch (Throwable t) {
                    com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error starting recorder", t);
                }
            }
        }
        else {
            com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Recorder already started");
        }
        final af c = this.c;
        final Object e = this.e;
        c.a(4);
    }
    
    public final void a(final dd dd) {
        com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Capturing audio from recorder");
        if (this.b != null) {
            this.d.a(new dd() {
                @Override
                public final void a(final byte[] array, final int n, final int n2, final boolean b) {
                    if (ai.this.b == null) {
                        dd.a(array, n, n2, b);
                    }
                    else if (ai.this.b.a()) {
                        final byte[] array2 = (byte[])ai.this.b.b();
                        final boolean b2 = !ai.this.b.a();
                        dd.a(array2, 0, array2.length, b2);
                        if (b2) {
                            y.a(new Runnable() {
                                @Override
                                public final void run() {
                                    ai.this.b();
                                }
                            });
                        }
                    }
                    final ai a = ai.this;
                    ai.c();
                }
            });
            return;
        }
        this.d.a(dd);
    }
    
    public final void b() {
        if (this.g && !this.h) {
            this.h = true;
            Label_0106: {
                if (this.d == null) {
                    break Label_0106;
                }
                synchronized (this.k) {
                    try {
                        if (!this.i) {
                            com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Stopping recorder");
                            this.d.g();
                            this.j = true;
                            while (!this.i) {
                                try {
                                    this.k.wait();
                                }
                                catch (InterruptedException ex) {}
                            }
                        }
                        return;
                    }
                    catch (Throwable t) {
                        com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error stopping recorder", t);
                        this.i = true;
                    }
                    com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Can't stop recorder because it wasn't started");
                    final af c = this.c;
                    final Object e = this.e;
                    c.a(4);
                }
            }
        }
    }
}
