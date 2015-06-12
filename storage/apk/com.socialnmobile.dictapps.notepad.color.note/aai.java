import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.database.Cursor;
import android.content.Context;
import android.widget.CursorAdapter;

// 
// Decompiled by Procyon v0.5.29
// 

public final class aai extends CursorAdapter implements aag
{
    Context a;
    int b;
    float c;
    
    public aai(final Context a, final Cursor cursor) {
        super(a, cursor);
        this.a = a;
    }
    
    public final void a(final float c) {
        this.c = c;
    }
    
    public final void a(final int b) {
        this.b = b;
    }
    
    public final void bindView(final View view, final Context context, final Cursor cursor) {
        final aaj aaj = (aaj)view.getTag();
        aaj.a(this.b);
        aaj.a(this.c);
        aaj.a.a(cursor);
        aaj.b();
    }
    
    public final View newView(final Context context, final Cursor cursor, final ViewGroup viewGroup) {
        final View inflate = LayoutInflater.from(context).inflate(2130903086, (ViewGroup)null);
        inflate.setTag((Object)new aaj(inflate));
        return inflate;
    }
}
