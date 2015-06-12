import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.text.method.SingleLineTransformationMethod;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.Toast;
import android.content.ContentUris;
import android.graphics.Typeface;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import java.util.Locale;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import android.view.View$OnClickListener;
import android.text.format.Time;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class aan implements aak
{
    Context a;
    kh b;
    int c;
    boolean d;
    Time e;
    Time f;
    int g;
    int h;
    int i;
    int j;
    View$OnClickListener k;
    View$OnClickListener l;
    View$OnClickListener m;
    private ViewGroup n;
    private View o;
    private TextView p;
    private TextView q;
    private View r;
    private TextView s;
    private ImageView t;
    private ImageView u;
    private ImageButton v;
    private View w;
    private int x;
    
    public aan(final View view, final int x) {
        this.e = new Time();
        this.f = new Time();
        this.k = (View$OnClickListener)new aao(this);
        this.l = (View$OnClickListener)new aap(this);
        this.m = (View$OnClickListener)new aaq(this);
        this.n = (ViewGroup)view;
        this.a = this.n.getContext();
        this.o = this.n.findViewById(2131624116);
        this.p = (TextView)this.n.findViewById(2131624097);
        this.q = (TextView)this.n.findViewById(2131624104);
        this.s = (TextView)this.n.findViewById(2131624117);
        this.r = this.n.findViewById(2131624092);
        this.t = (ImageView)this.n.findViewById(2131624112);
        this.u = (ImageView)this.n.findViewById(2131624067);
        this.v = (ImageButton)this.n.findViewById(2131624119);
        this.w = this.n.findViewById(2131624118);
        this.x = x;
        this.b = new kh();
        if (gw.a(Locale.getDefault())) {
            this.s.setGravity(21);
            this.s.setPadding(0, 0, gw.c(view.getContext(), 5), 0);
        }
        else {
            this.s.setGravity(16);
            this.s.setPadding(0, 0, 0, 0);
        }
        this.b();
    }
    
    private void a(final long n, final boolean b, final boolean b2) {
        String s;
        if (b2 || (b && DateUtils.isToday(n))) {
            s = DateUtils.formatDateTime(this.a, n, 1);
        }
        else if (this.x == 1) {
            this.e.set(n);
            this.f.set(System.currentTimeMillis());
            s = DateUtils.formatDateTime(this.a, n, 65560);
            if (this.e.year != this.f.year) {
                s = String.valueOf(s) + "\n" + (Object)DateFormat.format((CharSequence)"yyyy", n);
            }
        }
        else {
            s = DateUtils.formatDateTime(this.a, n, 65552);
        }
        this.s.setText((CharSequence)s);
        this.s.setTypeface(Typeface.DEFAULT, 0);
        this.s.setTextColor(gr.a(this.a).n(0));
    }
    
    private void b() {
        final int b = jp.b(this.a);
        if (this.g != b) {
            this.g = b;
            if (this.x == 1) {
                if (this.g == 1) {
                    this.s.setTextSize(0, (float)this.a.getResources().getDimensionPixelSize(2131361829));
                }
                else {
                    this.s.setTextSize(0, (float)this.a.getResources().getDimensionPixelSize(2131361803));
                }
            }
            else {
                this.s.setTextSize(0, (float)this.a.getResources().getDimensionPixelSize(2131361828));
            }
            final int d = jp.d(this.a);
            this.p.setMinHeight(d);
            if (this.x == 1) {
                this.s.setMinHeight(d);
            }
        }
    }
    
    @Override
    public final kh a() {
        return this.b;
    }
    
    final void a(final int n) {
        this.b();
        final boolean a = this.b.a();
        final int j = this.b.j;
        final yc a2 = gr.a(this.a);
        this.r.setBackgroundColor(a2.k(j));
        this.o.setBackgroundColor(a2.b(j));
        if (this.w != null) {
            this.w.setBackgroundColor(a2.n(2));
        }
        final int g = a2.g(j);
        if (a) {
            this.p.setTextColor(gw.a(102, g));
            if (this.q != null) {
                this.q.setTextColor(gw.a(102, g));
            }
        }
        else {
            this.p.setTextColor(g);
            if (this.q != null) {
                this.q.setTextColor(gw.a(221, g));
            }
        }
        if (n == 1) {
            this.a(this.b.i, true, false);
        }
        else if (n == 2) {
            this.a(this.b.h, true, false);
        }
        else if (n == 6) {
            this.a(this.b.h(), true, false);
        }
        final int i = this.b.j;
        final int f = this.b.f;
        this.b.a();
        if (f == 0) {
            this.t.setImageDrawable((Drawable)null);
        }
        else if (f == 16) {
            this.t.setImageResource(2130837680);
        }
        final String g2 = this.b.g;
        this.p.setTextColor(gr.a(this.a).g(this.b.j));
        this.p.setGravity(8388629);
        this.p.setGravity(8388627);
        this.p.setText((CharSequence)g2);
        if (this.q != null) {
            CharSequence charSequence = this.b.d();
            if (this.q != null) {
                if (this.b.f == 16) {
                    final Context a3 = this.a;
                    charSequence = yf.a((String)charSequence);
                }
                this.q.setText(SingleLineTransformationMethod.getInstance().getTransformation(charSequence, (View)this.q));
            }
        }
        if (this.b.k != 0) {
            this.t.setImageResource(2130837681);
        }
        if (n == 4 || n == 5) {
            if (this.b.m != 16 && this.b.m == 32) {
                this.s.setVisibility(0);
                this.a(this.b.f(), true, true);
                this.s.setTextColor(gr.a(this.a).n(1));
                if (n == 5) {
                    final LinearLayout$LayoutParams layoutParams = (LinearLayout$LayoutParams)this.s.getLayoutParams();
                    layoutParams.width = -2;
                    layoutParams.height = -1;
                    layoutParams.weight = 0.0f;
                    this.s.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
                }
            }
            else {
                this.s.setVisibility(8);
            }
            this.v.setVisibility(0);
            this.w.setVisibility(0);
            if (n == 4) {
                this.v.setImageResource(2130837582);
                this.v.setBackgroundResource(2130837531);
                this.v.setOnClickListener(this.k);
            }
            else if (n == 5) {
                if (this.b.g() == 0L) {
                    this.v.setImageResource(2130837661);
                    this.v.setBackgroundResource(2130837531);
                    this.v.setOnClickListener(this.m);
                }
                else if (this.a(this.b.g())) {
                    this.v.setImageResource(2130837662);
                    this.v.setBackgroundResource(2130837531);
                    this.v.setOnClickListener(this.l);
                }
                else {
                    this.v.setImageResource(2130837660);
                    this.v.setBackgroundResource(2130837531);
                    this.v.setOnClickListener(this.m);
                }
            }
        }
        else if (n == 3) {
            this.s.setVisibility(8);
            this.v.setVisibility(8);
        }
        else {
            this.s.setVisibility(0);
            final long g3 = this.b.g();
            final int m = this.b.m;
            final int n2 = this.b.n;
            this.b.a();
            if (m == 32 && g3 > System.currentTimeMillis()) {
                this.t.setImageResource(2130837683);
                this.a(g3, true, false);
                this.s.setTextColor(gr.a(this.a).n(1));
            }
            else if (m == 16 && n2 == 144 && g3 > System.currentTimeMillis()) {
                this.t.setImageResource(2130837684);
                this.s.setText(2131230887);
                this.s.setTextColor(gr.a(this.a).n(1));
            }
            else if (m == 16 && g3 > System.currentTimeMillis()) {
                this.t.setImageResource(2130837684);
                this.a(g3, false, false);
                this.s.setTextColor(gr.a(this.a).n(1));
            }
            else if (m == 128) {
                this.t.setImageResource(2130837685);
            }
        }
        final boolean a4 = this.b.a();
        final int k = this.b.j;
        if (a4) {
            this.p.setTextColor(gw.a(102, gr.a(this.a).g(k)));
            this.p.setText(gw.a(this.p.getText().toString()));
            this.s.setTextColor(gw.a(102, gr.a(this.a).g(k)));
            if (this.t.getDrawable() != null) {
                this.t.getDrawable().mutate().setAlpha(102);
            }
            this.u.getDrawable().mutate().setAlpha(102);
        }
        else {
            if (this.t.getDrawable() != null) {
                this.t.getDrawable().mutate().setAlpha(255);
            }
            this.u.getDrawable().mutate().setAlpha(255);
        }
        if (this.b.b()) {
            this.t.setVisibility(0);
            this.t.setImageResource(2130837679);
        }
        if (this.b.c != 0) {
            this.t.setImageResource(2130837682);
        }
        if (this.b.n != 0 && this.b.g() != 0L) {
            this.u.setVisibility(0);
            return;
        }
        this.u.setVisibility(8);
    }
    
    public final boolean a(final long n) {
        final Time time = new Time();
        time.set(n);
        return this.h == time.year && this.i == time.month && this.j == time.monthDay;
    }
}
