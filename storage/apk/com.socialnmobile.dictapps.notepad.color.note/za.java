import android.graphics.drawable.Drawable;
import android.graphics.PorterDuff$Mode;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class za
{
    public Context a;
    public TextView b;
    public TextView c;
    public ImageView d;
    public ImageView e;
    public ImageView f;
    private View g;
    
    public za(final View g) {
        this.a = g.getContext();
        this.g = g;
        this.b = (TextView)g.findViewById(2131624065);
        this.c = (TextView)g.findViewById(2131624069);
        this.d = (ImageView)g.findViewById(2131624067);
        this.e = (ImageView)g.findViewById(2131624068);
        this.f = (ImageView)g.findViewById(2131624066);
    }
    
    public final void a() {
        this.g.setVisibility(8);
    }
    
    public final void a(final int n) {
        final yc a = gr.a(this.a);
        final int h = a.h(n);
        this.g.setBackgroundColor(a.b(n));
        this.b.setTextColor(h);
        this.c.setTextColor(h);
        final Drawable[] compoundDrawables = this.c.getCompoundDrawables();
        if (compoundDrawables[0] != null) {
            compoundDrawables[0].setColorFilter(h, PorterDuff$Mode.MULTIPLY);
        }
        this.d.getDrawable().mutate().setColorFilter(h, PorterDuff$Mode.MULTIPLY);
        this.e.getDrawable().mutate().setColorFilter(h, PorterDuff$Mode.MULTIPLY);
    }
}
