import java.util.Vector;
import com.nuance.nmdp.speechkit.recognitionresult.b;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ag
{
    private final by a;
    private final ab b;
    private final dn c;
    private hb d;
    private final Object e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private Object j;
    private final Object k;
    
    public ag(final dn c, final Object e, final Object k, final ab b) {
        this.a = new by() {
            private boolean a = false;
            
            private void a() {
                synchronized (ag.this.j) {
                    ag.this.h = true;
                    if (ag.this.i) {
                        ag.this.j.notify();
                        ag.this.i = false;
                    }
                }
            }
            
            @Override
            public final void a(final String s) {
                if (s == "BUFFER_PLAYED") {
                    if (!this.a) {
                        com.nuance.nmdp.speechkit.recognitionresult.b.a(ag.this, "First audio buffer played");
                        ag.this.b.b(ag.this.e);
                        this.a = true;
                    }
                }
                else if (s != "BUFFERING") {
                    if (s == "STARTED") {
                        com.nuance.nmdp.speechkit.recognitionresult.b.a(ag.this, "Audio playback started");
                        return;
                    }
                    if (s == "STOPPED") {
                        com.nuance.nmdp.speechkit.recognitionresult.b.a(ag.this, "Audio playback stopped");
                        this.a();
                        ag.this.b.c(ag.this.e);
                        return;
                    }
                    if (s == "PLAYBACK_ERROR") {
                        com.nuance.nmdp.speechkit.recognitionresult.b.c(ag.this, "Audio playback error");
                        this.a();
                        ag.this.b.a(ag.this.e);
                    }
                }
            }
        };
        this.b = b;
        this.c = c;
        this.e = e;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = new Object();
        this.k = k;
        final z z = new z();
        z.a(new df("Android_Context", this.k, dg.a));
        by a;
        dn c2;
        Vector c3;
        al a2;
        try {
            a = this.a;
            c2 = this.c;
            c3 = z.c();
            a2 = al.a;
            if (a == null) {
                throw new NullPointerException("NMSPAudioPlaybackListener can not be null!");
            }
        }
        catch (Throwable t) {
            com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error creating player", t);
            this.d = null;
            return;
        }
        if (c2 == null) {
            throw new NullPointerException("Manager can not be null!");
        }
        this.d = new dl(a, c2, c3, a2);
    }
    
    public final void a() {
        if (!this.f) {
            if (this.d != null) {
                this.f = true;
                try {
                    com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Starting audio player");
                    this.d.a();
                    return;
                }
                catch (Throwable t) {
                    com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error starting player", t);
                }
            }
        }
        else {
            com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Player already started");
        }
        this.b.a(this.e);
    }
    
    public final void b() {
        if (!this.f || this.g) {
            return;
        }
        Label_0107: {
            if (this.d == null) {
                break Label_0107;
            }
            this.g = true;
            synchronized (this.j) {
                try {
                    if (!this.h) {
                        com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Stopping audio player");
                        this.d.f();
                        this.i = true;
                        while (!this.h) {
                            try {
                                this.j.wait();
                            }
                            catch (InterruptedException ex) {}
                        }
                    }
                }
                catch (Throwable t) {
                    com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error stopping player", t);
                    this.h = true;
                }
                return;
            }
        }
        this.b.a(this.e);
    }
    
    public final hb c() {
        return this.d;
    }
}
