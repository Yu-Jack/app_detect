import android.graphics.drawable.GradientDrawable;
import android.view.View$OnClickListener;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.GestureDetector;
import com.socialnmobile.colornote.view.MyImageButton;
import android.widget.EditText;
import android.view.ViewGroup;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class zg
{
    public Context a;
    public ViewGroup b;
    public EditText c;
    public MyImageButton d;
    public MyImageButton e;
    public MyImageButton f;
    public MyImageButton g;
    public GestureDetector h;
    View i;
    int j;
    public boolean k;
    public int l;
    
    public zg(final View view) {
        this.a = view.getContext();
        this.b = (ViewGroup)view;
        this.c = (EditText)view.findViewById(2131624072);
        this.d = (MyImageButton)view.findViewById(2131624074);
        this.e = (MyImageButton)view.findViewById(2131624073);
        this.f = (MyImageButton)view.findViewById(2131624075);
        this.g = (MyImageButton)view.findViewById(2131624070);
        this.i = view.findViewById(2131624071);
    }
    
    public final void a() {
        int n;
        if (gv.b(this.a) >= 400) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n != 0) {
            this.i.setVisibility(8);
            this.g.setVisibility(0);
            if (this.l == 1) {
                this.g.setImageResource(2130837571);
            }
            else {
                this.g.setImageResource(2130837565);
            }
        }
        else {
            this.i.setVisibility(0);
            this.g.setVisibility(8);
        }
        final int d = gv.d(this.a);
        gw.b((View)this.g, d);
        gw.b((View)this.d, d);
        gw.b((View)this.e, d);
        gw.b((View)this.f, d);
    }
    
    public final void a(final int j) {
        switch (this.j = j) {
            default: {}
            case 1: {
                this.d.setImageResource(2130837570);
            }
            case 2: {
                this.d.setImageResource(2130837570);
            }
            case 3: {
                this.d.setEnabled(false);
                this.d.setImageDrawable((Drawable)null);
                this.d.setImageResource(2130837566);
            }
            case 4: {
                this.d.setImageResource(2130837568);
            }
        }
    }
    
    public final void a(final int n, final yc yc, final int n2) {
        final String b = this.b();
        switch (n) {
            default: {}
            case 1: {
                this.a(b);
                this.c.setTextColor(-16777216);
            }
            case 2: {
                this.a(gw.a(b));
                this.c.setTextColor(gw.a(102, yc.f(n2)));
            }
            case 3: {
                this.a(b);
                this.c.setTextColor(yc.f(n2));
            }
        }
    }
    
    public final void a(final View$OnClickListener onClickListener) {
        this.e.setOnClickListener(onClickListener);
    }
    
    public final void a(final CharSequence textKeepState) {
        this.c.setTextKeepState(textKeepState);
    }
    
    public final String b() {
        return this.c.getText().toString().trim();
    }
    
    public final void b(final int n) {
        final yc a = gr.a(this.a);
        this.b.setBackgroundColor(a.c(n));
        final GradientDrawable gradientDrawable = (GradientDrawable)this.e.getDrawable();
        if (gradientDrawable != null) {
            gradientDrawable.setColor(a.e(n));
        }
    }
    
    public final void b(final View$OnClickListener onClickListener) {
        this.d.setOnClickListener(onClickListener);
    }
    
    public final void c() {
        this.d.setEnabled(false);
        this.e.setVisibility(8);
    }
}
