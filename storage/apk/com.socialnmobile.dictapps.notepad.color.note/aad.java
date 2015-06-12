import com.socialnmobile.colornote.view.MyViewPager;
import android.database.DataSetObserver;

// 
// Decompiled by Procyon v0.5.29
// 

public final class aad extends DataSetObserver
{
    final /* synthetic */ MyViewPager a;
    
    private aad(final MyViewPager a) {
        this.a = a;
    }
    
    public final void onChanged() {
        this.a.c();
    }
    
    public final void onInvalidated() {
        this.a.c();
    }
}
