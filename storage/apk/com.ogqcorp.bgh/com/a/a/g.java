// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a;

class g implements Runnable
{
    final /* synthetic */ f a;
    private final n b;
    private final q c;
    private final Runnable d;
    
    public g(final f a, final n b, final q c, final Runnable d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public void run() {
        if (this.b.g()) {
            this.b.b("canceled-at-delivery");
        }
        else {
            if (this.c.a()) {
                this.b.a(this.c.a);
            }
            else {
                this.b.b(this.c.c);
            }
            if (this.c.d) {
                this.b.a("intermediate-response");
            }
            else {
                this.b.b("done");
            }
            if (this.d != null) {
                this.d.run();
            }
        }
    }
}
