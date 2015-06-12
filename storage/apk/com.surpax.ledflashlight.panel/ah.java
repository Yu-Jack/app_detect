import com.nuance.nmdp.speechkit.recognitionresult.b;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ah
{
    private final ae a;
    private final Object b;
    private final Object c;
    private final ab d;
    private final Object e;
    private boolean f;
    private boolean g;
    
    public ah(final ae a, final Object c, final Object b, final ab ab) {
        this.a = a;
        this.b = b;
        this.f = false;
        this.g = false;
        this.c = c;
        this.e = new Object();
        this.d = new ab() {
            @Override
            public final void a(final Object o) {
                synchronized (ah.this.e) {
                    ah.this.g = true;
                    // monitorexit(ah.a(this.b))
                    ab.a(o);
                }
            }
            
            @Override
            public final void b(final Object o) {
                ab.b(o);
            }
            
            @Override
            public final void c(final Object o) {
                synchronized (ah.this.e) {
                    ah.this.g = true;
                    // monitorexit(ah.a(this.b))
                    ab.c(o);
                }
            }
        };
    }
    
    public final void a() {
        if (!this.f) {
            this.f = true;
            this.a.a(this.c, this.d, this.b);
            return;
        }
        com.nuance.nmdp.speechkit.recognitionresult.b.c(this, "Prompt already started");
    }
    
    public final void b() {
        if (!this.f) {
            return;
        }
        synchronized (this.e) {
            if (!this.g) {
                com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Stopping prompt");
                this.g = true;
                this.a.a();
            }
        }
    }
}
