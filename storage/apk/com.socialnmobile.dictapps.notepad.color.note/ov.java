import android.content.ContentUris;
import android.content.Intent;
import com.socialnmobile.colornote.activity.NoteWidgetConfigure;
import android.view.View;
import android.widget.AdapterView;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import android.widget.AdapterView$OnItemClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ov implements AdapterView$OnItemClickListener
{
    final /* synthetic */ NoteListFragment a;
    
    public ov(final NoteListFragment a) {
        this.a = a;
    }
    
    public final void onItemClick(final AdapterView adapterView, final View view, final int n, final long n2) {
        if (this.a.ag != 1) {
            this.a.b(n2);
            return;
        }
        if (this.a.h() instanceof NoteWidgetConfigure) {
            ((NoteWidgetConfigure)this.a.h()).a(n2);
            return;
        }
        this.a.h().setResult(-1, new Intent().setData(ContentUris.withAppendedId(this.a.O(), n2)));
        this.a.h().finish();
    }
}
