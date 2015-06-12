import android.content.Intent;
import android.content.ContentUris;
import android.view.View;
import android.widget.AdapterView;
import com.socialnmobile.colornote.fragment.RecycleBinFragment;
import android.widget.AdapterView$OnItemClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class pl implements AdapterView$OnItemClickListener
{
    final /* synthetic */ RecycleBinFragment a;
    
    public pl(final RecycleBinFragment a) {
        this.a = a;
    }
    
    public final void onItemClick(final AdapterView adapterView, final View view, final int n, final long n2) {
        final Intent intent = new Intent("android.intent.action.VIEW", ContentUris.withAppendedId(kf.a, n2));
        intent.putExtra("EXTRA_VIEW_FROM", "RECYCLE");
        this.a.a(intent);
    }
}
