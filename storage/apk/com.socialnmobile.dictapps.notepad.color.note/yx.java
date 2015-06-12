import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import java.util.List;
import android.content.Context;
import android.widget.ArrayAdapter;

// 
// Decompiled by Procyon v0.5.29
// 

public final class yx extends ArrayAdapter
{
    Context a;
    boolean b;
    
    public yx(final Context context, final List list) {
        super(context, 0, list);
    }
    
    public final void a(final boolean b) {
        this.b = b;
    }
    
    public final long getItemId(final int n) {
        return ((jy)this.getItem(n)).b;
    }
    
    public final View getView(final int n, View inflate, final ViewGroup viewGroup) {
        yy yy;
        if (inflate == null) {
            inflate = LayoutInflater.from(this.getContext()).inflate(2130903084, (ViewGroup)null);
            final yy tag = new yy(this, inflate);
            inflate.setTag((Object)tag);
            yy = tag;
        }
        else {
            yy = (yy)inflate.getTag();
        }
        final jy jy = (jy)this.getItem(n);
        final yc a = gr.a(yy.d.a);
        yy.a.setTextColor(a.n(13));
        yy.a.setHintTextColor(gw.a(64, a.n(13)));
        yy.c.setTextColor(a.l(jy.b));
        while (true) {
            Label_0241: {
                if (yy.d.b) {
                    yy.c.setText((CharSequence)String.valueOf(jy.c));
                    if (jy.a == null) {
                        break Label_0241;
                    }
                    yy.a.setText((CharSequence)jy.a);
                }
                else {
                    yy.c.setText((CharSequence)"");
                    if (jy.b != 0) {
                        break Label_0241;
                    }
                    yy.a.setText((CharSequence)jy.a);
                }
                yy.b.setImageDrawable(gw.b(yy.d.getContext(), jy.b));
                return inflate;
            }
            yy.a.setText((CharSequence)"");
            continue;
        }
    }
}
