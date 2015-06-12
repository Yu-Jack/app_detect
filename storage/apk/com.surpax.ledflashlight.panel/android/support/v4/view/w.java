// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.database.DataSetObserver;
import android.database.DataSetObservable;

public abstract class w
{
    private DataSetObservable a;
    
    public w() {
        this.a = new DataSetObservable();
    }
    
    public static void b() {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }
    
    public abstract int a();
    
    public final void a(final DataSetObserver dataSetObserver) {
        this.a.registerObserver((Object)dataSetObserver);
    }
    
    public final void b(final DataSetObserver dataSetObserver) {
        this.a.unregisterObserver((Object)dataSetObserver);
    }
    
    public abstract boolean c();
}
