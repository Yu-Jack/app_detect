import android.content.Intent;
import com.socialnmobile.colornote.activity.NoteWidgetConfigure;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ia implements rg
{
    final /* synthetic */ NoteWidgetConfigure a;
    
    public ia(final NoteWidgetConfigure a) {
        this.a = a;
    }
    
    @Override
    public final boolean a(final int n, final String s) {
        if (this.a.o != null) {
            this.a.o.dismiss();
            this.a.o = null;
        }
        final Intent intent = new Intent("android.intent.action.INSERT", kf.a);
        intent.putExtra("socialnmobile.intent.extra.TYPE", n);
        this.a.startActivityForResult(intent, 1);
        return true;
    }
}
