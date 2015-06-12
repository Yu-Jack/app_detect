import android.util.AttributeSet;
import android.content.Context;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemSelectedListener;

// 
// Decompiled by Procyon v0.5.29
// 

final class qt implements AdapterView$OnItemSelectedListener
{
    final /* synthetic */ qs a;
    
    qt(final qs a) {
        this.a = a;
    }
    
    public final void onItemSelected(final AdapterView adapterView, final View view, final int n, final long n2) {
        if (n != -1) {
            final qu c = this.a.c;
            if (c != null) {
                qu.a(c, false);
            }
        }
    }
    
    public final void onNothingSelected(final AdapterView adapterView) {
    }
}
