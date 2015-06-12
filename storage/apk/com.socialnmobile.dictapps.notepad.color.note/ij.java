import android.view.View;
import android.widget.AdapterView;
import com.socialnmobile.colornote.activity.ReminderSettings;
import android.widget.AdapterView$OnItemSelectedListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ij implements AdapterView$OnItemSelectedListener
{
    final /* synthetic */ ReminderSettings a;
    
    public ij(final ReminderSettings a) {
        this.a = a;
    }
    
    public final void onItemSelected(final AdapterView adapterView, final View view, final int n, final long n2) {
        this.a.c(this.a.a(n));
    }
    
    public final void onNothingSelected(final AdapterView adapterView) {
    }
}
