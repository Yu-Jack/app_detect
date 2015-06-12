import android.os.Bundle;
import android.os.Handler;
import com.socialnmobile.colornote.view.ScreenCalendar;
import android.database.ContentObserver;

// 
// Decompiled by Procyon v0.5.29
// 

public final class aaw extends ContentObserver
{
    final /* synthetic */ ScreenCalendar a;
    
    public aaw(final ScreenCalendar a, final Handler handler) {
        this.a = a;
        super(handler);
    }
    
    public final void onChange(final boolean b) {
        if (this.a.a.l()) {
            this.a.a.q().a(2, null, this.a);
        }
    }
}
