import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import java.util.List;
import android.content.Context;
import android.widget.ArrayAdapter;

// 
// Decompiled by Procyon v0.5.29
// 

public final class aah extends ArrayAdapter implements aag
{
    boolean a;
    int b;
    float c;
    
    public aah(final Context context, final List list) {
        super(context, 0, list);
        this.a = false;
    }
    
    public final void a(final float c) {
        this.c = c;
    }
    
    public final void a(final int b) {
        this.b = b;
    }
    
    public final long getItemId(final int n) {
        return ((kh)this.getItem(n)).a;
    }
    
    public final View getView(final int n, View inflate, final ViewGroup viewGroup) {
        if (inflate == null) {
            inflate = LayoutInflater.from(this.getContext()).inflate(2130903086, (ViewGroup)null);
            inflate.setTag((Object)new aaj(inflate));
        }
        if (this.a) {
            inflate.findViewById(2131624117).setVisibility(8);
        }
        final aaj aaj = (aaj)inflate.getTag();
        aaj.a(this.b);
        aaj.a(this.c);
        aaj.a = (kh)this.getItem(n);
        aaj.b();
        return inflate;
    }
}
