import android.content.Context;
import android.app.Activity;

// 
// Decompiled by Procyon v0.5.29
// 

public final class yd
{
    String a;
    int b;
    Activity c;
    public ye d;
    int e;
    
    public yd(final Activity c) {
        this.c = c;
    }
    
    public final void a() {
        final String h = jp.h((Context)this.c);
        final int p = jp.p((Context)this.c);
        if (this.a == null || !this.a.equals(h) || this.b == 0 || this.b != p) {
            this.a = h;
            this.b = p;
            final yc a = gr.a((Context)this.c);
            if (a.a()) {
                final Activity c = this.c;
                int theme;
                if (jp.p((Context)this.c) == 1) {
                    if (this.e == 1) {
                        theme = 2131492865;
                    }
                    else {
                        theme = 2131492867;
                    }
                }
                else if (this.e == 1) {
                    theme = 2131492872;
                }
                else {
                    theme = 2131492874;
                }
                c.setTheme(theme);
            }
            else {
                final Activity c2 = this.c;
                int theme2;
                if (jp.p((Context)this.c) == 1) {
                    if (this.e == 1) {
                        theme2 = 2131492866;
                    }
                    else {
                        theme2 = 2131492868;
                    }
                }
                else if (this.e == 1) {
                    theme2 = 2131492873;
                }
                else {
                    theme2 = 2131492875;
                }
                c2.setTheme(theme2);
            }
            if (this.d != null) {
                this.d.a(a);
            }
        }
    }
    
    public final void a(final int e) {
        this.e = e;
        this.a();
    }
}
