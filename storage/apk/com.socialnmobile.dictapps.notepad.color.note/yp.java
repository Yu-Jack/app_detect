import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import java.util.List;
import android.content.Context;
import android.widget.ArrayAdapter;

// 
// Decompiled by Procyon v0.5.29
// 

public final class yp extends ArrayAdapter
{
    String a;
    String b;
    String c;
    
    public yp(final Context context, final jr jr, final List list) {
        super(context, 0, list);
        this.a = jr.a();
        this.b = jr.c();
        this.c = jr.b();
    }
    
    public final View getView(final int n, View inflate, final ViewGroup viewGroup) {
        yq yq;
        if (inflate == null) {
            inflate = LayoutInflater.from(this.getContext()).inflate(2130903080, (ViewGroup)null);
            final yq tag = new yq(this, inflate);
            inflate.setTag((Object)tag);
            yq = tag;
        }
        else {
            yq = (yq)inflate.getTag();
        }
        final jv e = (jv)this.getItem(n);
        yq.e = e;
        yq.b.setText((CharSequence)gs.b(yq.a.getContext(), e.c));
        yq.d.setText((CharSequence)String.valueOf(e.d));
        switch (e.b) {
            default: {
                yq.c.setText(2131230839);
                yq.c.setTextColor(-65536);
                break;
            }
            case 2: {
                yq.c.setText(2131230994);
                yq.c.setTextColor(-1);
                break;
            }
            case 1: {
                yq.c.setText(2131230993);
                yq.c.setTextColor(-256);
                break;
            }
        }
        if (e.g.contains(yq.a.a)) {
            yq.f.setVisibility(0);
        }
        else {
            yq.f.setVisibility(8);
        }
        if (e.g.contains(yq.a.b) || e.g.contains(yq.a.c)) {
            yq.g.setVisibility(0);
            return inflate;
        }
        yq.g.setVisibility(8);
        return inflate;
    }
}
