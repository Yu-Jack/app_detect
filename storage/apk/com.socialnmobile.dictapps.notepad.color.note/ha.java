import android.content.Context;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView;
import com.socialnmobile.colornote.activity.BackupLocal;
import android.widget.AdapterView$OnItemClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ha implements AdapterView$OnItemClickListener
{
    final /* synthetic */ BackupLocal a;
    
    public ha(final BackupLocal a) {
        this.a = a;
    }
    
    public final void onItemClick(final AdapterView adapterView, final View view, final int n, final long n2) {
        if (((yq)view.getTag()).e.a > 6) {
            Toast.makeText((Context)this.a, 2131230843, 1).show();
            return;
        }
        this.a.b.showContextMenuForChild(view);
    }
}
