// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.database.DataSetObserver;

class bn extends DataSetObserver
{
    final /* synthetic */ ViewPager a;
    
    private bn(final ViewPager a) {
        this.a = a;
    }
    
    public void onChanged() {
        this.a.b();
    }
    
    public void onInvalidated() {
        this.a.b();
    }
}
