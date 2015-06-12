import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import java.util.Collection;
import android.content.Context;
import java.util.List;
import android.text.format.Time;
import android.widget.ArrayAdapter;

// 
// Decompiled by Procyon v0.5.29
// 

public final class aal extends ArrayAdapter
{
    int a;
    int b;
    boolean c;
    Time d;
    List e;
    
    private aal(final Context context, final List e, final int b, final int a, final boolean c) {
        super(context, 0, e);
        this.e = e;
        this.a = a;
        this.c = c;
        this.b = b;
    }
    
    public static aal a(final Context context, final List list, final int n, final boolean b) {
        return new aal(context, list, 1, n, b);
    }
    
    public static aal b(final Context context, final List list, final int n, final boolean b) {
        return new aal(context, list, 3, n, b);
    }
    
    public final void a(final List list, final Time d) {
        this.e.clear();
        this.e.addAll(list);
        this.a = 5;
        this.c = false;
        this.d = d;
        this.notifyDataSetChanged();
    }
    
    public final long getItemId(final int n) {
        return ((kh)this.getItem(n)).a;
    }
    
    public final View getView(final int n, View view, final ViewGroup viewGroup) {
        if (view == null) {
            final LayoutInflater from = LayoutInflater.from(this.getContext());
            if (this.b == 1) {
                view = from.inflate(2130903087, (ViewGroup)null);
            }
            else if (this.b == 3) {
                view = from.inflate(2130903088, (ViewGroup)null);
            }
            view.setTag((Object)new aan(view, this.b));
        }
        final aan aan = (aan)view.getTag();
        if (this.d != null) {
            final int year = this.d.year;
            final int month = this.d.month;
            final int monthDay = this.d.monthDay;
            aan.h = year;
            aan.i = month;
            aan.j = monthDay;
        }
        final kh b = (kh)this.getItem(n);
        final int a = this.a;
        final boolean c = this.c;
        aan.b = b;
        aan.c = a;
        aan.d = c;
        aan.a(a);
        return view;
    }
}
