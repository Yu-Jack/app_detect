import android.view.View$OnClickListener;
import android.widget.TextView;
import android.view.View;
import android.support.v4.app.Fragment;

// 
// Decompiled by Procyon v0.5.29
// 

public final class abh
{
    Fragment a;
    View b;
    View c;
    View d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    View i;
    int j;
    
    public abh() {
        this.j = 0;
    }
    
    public final void a() {
        if (this.h != null) {
            this.h.setVisibility(8);
        }
    }
    
    public final void a(final int n) {
        if (n == 1) {
            this.f.setVisibility(0);
            this.e.setVisibility(8);
            this.g.setVisibility(8);
        }
        else if (n == 3) {
            this.f.setVisibility(0);
            this.e.setVisibility(0);
            this.g.setVisibility(0);
        }
    }
    
    public final void a(final View$OnClickListener onClickListener) {
        this.f.setOnClickListener(onClickListener);
        this.e.setOnClickListener(onClickListener);
        this.g.setOnClickListener(onClickListener);
    }
    
    public final void a(final View b, final Fragment a) {
        this.b = b;
        this.a = a;
        this.c = b.findViewById(2131624076);
        this.d = b.findViewById(2131624077);
        this.f = (TextView)b.findViewById(2131624079);
        this.e = (TextView)b.findViewById(2131624078);
        this.g = (TextView)b.findViewById(2131624080);
        this.h = (TextView)b.findViewById(2131624082);
        this.i = b.findViewById(2131624081);
    }
    
    public final void a(final String text) {
        this.f.setText((CharSequence)text);
    }
    
    public final void b() {
        this.c(this.j);
    }
    
    public final void b(final int backgroundColor) {
        this.i.setBackgroundColor(backgroundColor);
    }
    
    public final void c(int j) {
        this.j = j;
        final yc a = gr.a(this.b.getContext());
        if (j == 0) {
            j = 0;
        }
        this.d.setBackgroundColor(a.c(j));
        this.f.setTextColor(a.f(j));
        this.e.setTextColor(a.f(j));
        this.g.setTextColor(a.f(j));
    }
}
