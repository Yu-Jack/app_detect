// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.widget;

import android.database.DataSetObserver;

class c extends DataSetObserver
{
    final /* synthetic */ a a;
    
    private c(final a a) {
        this.a = a;
    }
    
    public void onChanged() {
        this.a.mDataValid = true;
        this.a.notifyDataSetChanged();
    }
    
    public void onInvalidated() {
        this.a.mDataValid = false;
        this.a.notifyDataSetInvalidated();
    }
}
