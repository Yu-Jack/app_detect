import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.database.Cursor;
import android.content.Context;
import android.widget.CursorAdapter;

// 
// Decompiled by Procyon v0.5.29
// 

public final class aam extends CursorAdapter
{
    Context a;
    int b;
    int c;
    boolean d;
    
    private aam(final Context a, final Cursor cursor, final int c, final int b, final boolean d) {
        super(a, cursor);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public static aam a(final Context context, final Cursor cursor, final int n, final boolean b) {
        return new aam(context, cursor, 1, n, b);
    }
    
    public static aam b(final Context context, final Cursor cursor, final int n, final boolean b) {
        return new aam(context, cursor, 3, n, b);
    }
    
    public final void bindView(final View view, final Context context, final Cursor cursor) {
        final aan aan = (aan)view.getTag();
        final int b = this.b;
        final boolean d = this.d;
        aan.b.a(cursor);
        aan.c = b;
        aan.d = d;
        aan.a(b);
    }
    
    public final View newView(final Context context, final Cursor cursor, final ViewGroup viewGroup) {
        final LayoutInflater from = LayoutInflater.from(context);
        View inflate;
        if (this.c == 1) {
            inflate = from.inflate(2130903087, (ViewGroup)null);
            inflate.setTag((Object)new aan(inflate, this.c));
        }
        else {
            final int c = this.c;
            inflate = null;
            if (c == 3) {
                final View inflate2 = from.inflate(2130903088, (ViewGroup)null);
                inflate2.setTag((Object)new aan(inflate2, this.c));
                return inflate2;
            }
        }
        return inflate;
    }
}
