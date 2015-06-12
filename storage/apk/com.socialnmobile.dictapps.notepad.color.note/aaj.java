import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

// 
// Decompiled by Procyon v0.5.29
// 

public final class aaj implements aak
{
    kh a;
    private View b;
    private TextView c;
    private TextView d;
    private ImageView e;
    private ImageView f;
    private View g;
    private Context h;
    private View i;
    private View j;
    private View k;
    private int l;
    private float m;
    
    public aaj(final View b) {
        this.h = b.getContext();
        this.b = b;
        this.c = (TextView)this.b.findViewById(2131624097);
        this.e = (ImageView)this.b.findViewById(2131624112);
        this.d = (TextView)this.b.findViewById(2131624115);
        this.f = (ImageView)this.b.findViewById(2131624068);
        this.i = this.b.findViewById(2131624077);
        this.j = this.b.findViewById(2131624114);
        this.g = this.b.findViewById(2131624113);
        this.k = this.b.findViewById(2131624092);
        this.a = new kh();
    }
    
    @Override
    public final kh a() {
        return this.a;
    }
    
    final void a(final float n) {
        if (this.m != n) {
            this.d.setTextSize(0, n);
        }
    }
    
    final void a(final int l) {
        if (this.l != l) {
            this.l = l;
            final int dimensionPixelSize = this.h.getResources().getDimensionPixelSize(2131361794);
            gw.a(this.j, l - dimensionPixelSize - this.h.getResources().getDimensionPixelSize(2131361793));
            gw.a(this.i, dimensionPixelSize);
        }
    }
    
    final void b() {
        final String d = this.a.d();
        Object a;
        if (this.a.f == 16) {
            final Context h = this.h;
            a = yf.a(d);
        }
        else {
            a = new SpannableStringBuilder((CharSequence)d);
        }
        final boolean a2 = this.a.a();
        final int j = this.a.j;
        final yc a3 = gr.a(this.h);
        this.j.setBackgroundColor(a3.b(j));
        this.i.setBackgroundColor(a3.b(j));
        this.k.setBackgroundColor(a3.k(j));
        final int g = a3.g(j);
        if (a2) {
            this.c.setTextColor(gw.a(102, g));
            this.d.setTextColor(gw.a(102, g));
        }
        else {
            this.c.setTextColor(g);
            this.d.setTextColor(gw.a(221, g));
        }
        final int i = this.a.j;
        final int f = this.a.f;
        this.a.a();
        if (f == 0) {
            this.e.setImageDrawable((Drawable)null);
            this.e.setVisibility(8);
            this.g.setVisibility(0);
        }
        else if (f == 16) {
            gw.a(this.h.getResources(), this.e, 2130837680);
            this.e.setVisibility(0);
            this.g.setVisibility(8);
        }
        final boolean a4 = this.a.a();
        final String g2 = this.a.g;
        final int k = this.a.k;
        if (a4) {
            this.c.setText(gw.a(g2));
        }
        else {
            this.c.setText((CharSequence)g2);
        }
        if (k != 0) {
            this.f.setVisibility(0);
            this.d.setText((CharSequence)"");
        }
        else {
            this.d.setText((CharSequence)a);
            this.f.setVisibility(4);
        }
        final long g3 = this.a.g();
        final int m = this.a.m;
        final int n = this.a.n;
        if (m == 32 && g3 > System.currentTimeMillis()) {
            gw.a(this.h.getResources(), this.e, 2130837683);
            this.e.setVisibility(0);
            this.g.setVisibility(8);
        }
        else if (m == 16 && n == 144 && g3 > System.currentTimeMillis()) {
            gw.a(this.h.getResources(), this.e, 2130837684);
            this.e.setVisibility(0);
            this.g.setVisibility(8);
        }
        else if (m == 16 && g3 > System.currentTimeMillis()) {
            gw.a(this.h.getResources(), this.e, 2130837684);
            this.e.setVisibility(0);
            this.g.setVisibility(8);
        }
        else if (m == 128) {
            gw.a(this.h.getResources(), this.e, 2130837685);
            this.e.setVisibility(0);
            this.g.setVisibility(8);
        }
        if (this.a.a()) {
            if (this.e.getDrawable() != null) {
                this.e.getDrawable().mutate().setAlpha(102);
            }
        }
        else if (this.e.getDrawable() != null) {
            this.e.getDrawable().mutate().setAlpha(255);
        }
        if (this.a.b()) {
            this.e.setVisibility(0);
            this.g.setVisibility(8);
            gw.a(this.h.getResources(), this.e, 2130837679);
        }
        if (this.a.c != 0) {
            gw.a(this.h.getResources(), this.e, 2130837682);
        }
    }
}
