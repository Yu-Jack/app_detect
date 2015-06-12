import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import java.util.List;
import android.content.Context;
import android.widget.ArrayAdapter;

// 
// Decompiled by Procyon v0.5.29
// 

public final class yt extends ArrayAdapter
{
    int a;
    int b;
    boolean c;
    
    public yt(final Context context, final List list, final int b, final boolean c) {
        super(context, 0, list);
        this.b = b;
        this.c = c;
    }
    
    public final int a() {
        return this.b;
    }
    
    public final void a(final int b) {
        this.b = b;
    }
    
    public final void b(final int a) {
        this.a = a;
    }
    
    public final boolean b() {
        return this.c;
    }
    
    public final View getView(final int n, View inflate, final ViewGroup viewGroup) {
        yu yu;
        if (inflate == null) {
            inflate = LayoutInflater.from(this.getContext()).inflate(2130903083, (ViewGroup)null);
            inflate.findViewById(2131624110).setFocusable(false);
            final yu tag = new yu(this, inflate);
            inflate.setTag((Object)tag);
            yu = tag;
        }
        else {
            yu = (yu)inflate.getTag();
        }
        yu.a((jx)this.getItem(n));
        yu.a.setTextSize((float)this.a);
        return inflate;
    }
}
