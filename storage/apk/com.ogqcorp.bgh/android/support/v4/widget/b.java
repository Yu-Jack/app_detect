// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.os.Handler;
import android.database.ContentObserver;

class b extends ContentObserver
{
    final /* synthetic */ a a;
    
    public b(final a a) {
        this.a = a;
        super(new Handler());
    }
    
    public boolean deliverSelfNotifications() {
        return true;
    }
    
    public void onChange(final boolean b) {
        this.a.onContentChanged();
    }
}
