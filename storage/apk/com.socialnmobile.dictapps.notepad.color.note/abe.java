import android.os.Bundle;
import android.os.Handler;
import com.socialnmobile.colornote.view.ScreenGridList;
import android.database.ContentObserver;

// 
// Decompiled by Procyon v0.5.29
// 

public final class abe extends ContentObserver
{
    final /* synthetic */ ScreenGridList a;
    
    public abe(final ScreenGridList a, final Handler handler) {
        this.a = a;
        super(handler);
    }
    
    public final void onChange(final boolean b) {
        if (this.a.a.l()) {
            this.a.a.q().a(1, null, this.a);
        }
    }
}
