import android.view.View;
import com.socialnmobile.colornote.view.MyImageButton;
import android.view.View$OnLongClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class zs implements View$OnLongClickListener
{
    final /* synthetic */ MyImageButton a;
    
    public zs(final MyImageButton a) {
        this.a = a;
    }
    
    public final boolean onLongClick(final View view) {
        this.a.a();
        return true;
    }
}
