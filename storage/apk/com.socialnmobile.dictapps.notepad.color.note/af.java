import android.os.Handler;
import android.database.ContentObserver;

// 
// Decompiled by Procyon v0.5.29
// 

public final class af extends ContentObserver
{
    final /* synthetic */ ae a;
    
    public af(final ae a) {
        this.a = a;
        super(new Handler());
    }
    
    public final boolean deliverSelfNotifications() {
        return true;
    }
    
    public final void onChange(final boolean b) {
        this.a.m();
    }
}
