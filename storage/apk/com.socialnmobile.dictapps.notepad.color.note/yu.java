import android.view.ViewParent;
import android.widget.ListView;
import android.view.View;
import android.widget.ImageButton;
import android.view.View$OnClickListener;
import android.content.Context;
import android.widget.TextView;

// 
// Decompiled by Procyon v0.5.29
// 

public final class yu
{
    TextView a;
    public jx b;
    Context c;
    boolean d;
    View$OnClickListener e;
    View$OnClickListener f;
    private yt g;
    private ImageButton h;
    private View i;
    private View j;
    private View k;
    private View l;
    
    public yu(final yt g, final View j) {
        this.e = (View$OnClickListener)new yv(this);
        this.f = (View$OnClickListener)new yw(this);
        this.g = g;
        this.c = j.getContext();
        this.j = j;
        this.a = (TextView)j.findViewById(2131624033);
        this.h = (ImageButton)j.findViewById(2131624110);
        this.k = j.findViewById(2131624109);
        this.l = j.findViewById(2131624111);
        this.h.setOnClickListener(this.f);
        this.k.setOnClickListener(this.e);
        this.l.setOnClickListener(this.e);
        this.i = j.findViewById(2131624030);
        final int d = jp.d(this.c);
        this.a.setMinHeight(d);
        gw.a(this.k, d);
        gw.a(this.l, d);
        gw.b((View)this.h, gv.d(this.c));
    }
    
    final void a() {
        ViewParent viewParent = this.j.getParent();
        if (viewParent == null) {
            return;
        }
        while (!(viewParent instanceof ListView)) {
            viewParent = viewParent.getParent();
            if (viewParent == null) {
                return;
            }
        }
        ((ListView)viewParent).showContextMenuForChild(this.j);
    }
    
    public final void a(final jx b) {
        this.b = b;
        final yc a = gr.a(this.c);
        final int a2 = this.g.a();
        final int g = a.g(a2);
        if (b.a()) {
            this.a.setTextColor(gw.a(102, g));
            this.a.setText(gw.a(b.a));
            this.h.setImageResource(2130837540);
            this.h.setClickable(false);
            this.i.setVisibility(8);
            this.d = false;
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.a.setPadding(gw.c(this.c, 8), 0, 0, 0);
            return;
        }
        this.a.setTextColor(g);
        b.a(this.c, this.g.b());
        this.d = (b.d == 1);
        if (this.d) {
            b.a(this.c, this.g.b());
            this.a.setText((CharSequence)b.b);
            this.i.setBackgroundColor(a.d(a2));
            int imageResource = 0;
            switch (this.b.e.get(0).a) {
                default: {
                    imageResource = 0;
                    break;
                }
                case 3: {
                    imageResource = 2130837638;
                    break;
                }
                case 4: {
                    imageResource = 2130837639;
                    break;
                }
                case 5: {
                    imageResource = 2130837640;
                    break;
                }
                case 1: {
                    imageResource = 2130837641;
                    break;
                }
                case 2: {
                    imageResource = 2130837642;
                    break;
                }
            }
            this.h.setImageResource(imageResource);
            this.h.setClickable(true);
            this.i.setVisibility(0);
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            this.a.setPadding(gw.c(this.c, 8), 0, gw.c(this.c, 16), 0);
            return;
        }
        this.a.setText((CharSequence)b.a);
        this.h.setImageResource(2130837539);
        this.h.setClickable(false);
        this.i.setVisibility(8);
        this.k.setVisibility(8);
        this.l.setVisibility(0);
        this.a.setPadding(gw.c(this.c, 8), 0, 0, 0);
    }
}
