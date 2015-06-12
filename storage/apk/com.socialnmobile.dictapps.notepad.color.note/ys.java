import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ys
{
    yr a;
    TextView b;
    public TextView c;
    public View d;
    public View e;
    View f;
    View g;
    View h;
    private View i;
    private View j;
    
    public ys(final yr a, final View i, final boolean b) {
        this.a = a;
        this.i = i;
        this.b = (TextView)i.findViewById(2131624033);
        this.c = (TextView)i.findViewById(2131624102);
        this.d = i.findViewById(2131624103);
        this.e = i.findViewById(2131624104);
        this.f = i.findViewById(2131624106);
        this.g = i.findViewById(2131624105);
        this.h = i.findViewById(2131624108);
        this.j = i.findViewById(2131624107);
        if (b) {
            if (this.f != null) {
                this.f.setVisibility(8);
                this.g.setVisibility(8);
            }
        }
        else if (this.j != null) {
            this.j.setVisibility(8);
        }
        if (this.b != null) {
            this.b.setMinHeight(jp.d(i.getContext()));
        }
        if (this.c != null) {
            this.c.setMinHeight(jp.d(i.getContext()));
        }
    }
    
    public final void a(final boolean b, final Drawable backgroundDrawable) {
        gw.a(this.i, -2);
        if (b) {
            this.c.setVisibility(0);
            this.d.setVisibility(0);
            this.e.setVisibility(0);
            this.d.setBackgroundDrawable(backgroundDrawable);
            return;
        }
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(0);
    }
}
