import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import java.util.List;
import android.content.Context;
import android.view.View$OnClickListener;
import android.widget.ArrayAdapter;

// 
// Decompiled by Procyon v0.5.29
// 

public final class yr extends ArrayAdapter
{
    int a;
    boolean b;
    int c;
    View$OnClickListener d;
    View$OnClickListener e;
    View$OnClickListener f;
    
    public yr(final Context context, final List list, final int c, final View$OnClickListener e, final View$OnClickListener f, final View$OnClickListener d) {
        super(context, 0, list);
        this.b = jp.a(context, "pref_list_item_drag", context.getResources().getBoolean(2131296262));
        this.c = c;
        this.e = e;
        this.f = f;
        this.d = d;
    }
    
    public final void a(final int c) {
        this.c = c;
    }
    
    public final void b(final int a) {
        this.a = a;
    }
    
    public final View getView(final int i, View inflate, final ViewGroup viewGroup) {
        ys ys;
        if (inflate == null) {
            inflate = LayoutInflater.from(this.getContext()).inflate(2130903081, (ViewGroup)null);
            inflate.findViewById(2131624106).setFocusable(false);
            inflate.findViewById(2131624105).setFocusable(false);
            inflate.findViewById(2131624108).setFocusable(false);
            final ys tag = new ys(this, inflate, this.b);
            inflate.setTag((Object)tag);
            ys = tag;
        }
        else {
            ys = (ys)inflate.getTag();
        }
        final jx jx = (jx)this.getItem(i);
        ys.a(false, null);
        ys.b.setText((CharSequence)jx.a);
        final boolean a = jx.a();
        final int g = gr.a(ys.a.getContext()).g(ys.a.c);
        if (a) {
            ys.b.setTextColor(gw.a(102, g));
            ys.b.setText(gw.a(ys.b.getText().toString()));
        }
        else {
            final String string = ys.b.getText().toString();
            ys.b.setTextColor(g);
            ys.b.setText((CharSequence)string);
        }
        final View$OnClickListener e = this.e;
        final View$OnClickListener f = this.f;
        final View$OnClickListener d = this.d;
        ys.f.setTag((Object)i);
        ys.f.setOnClickListener(e);
        ys.g.setTag((Object)i);
        ys.g.setOnClickListener(f);
        ys.h.setTag((Object)i);
        ys.h.setOnClickListener(d);
        ys.b.setTextSize((float)this.a);
        return inflate;
    }
}
