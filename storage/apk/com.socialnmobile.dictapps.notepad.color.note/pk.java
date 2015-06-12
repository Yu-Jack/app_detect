import android.view.View;
import com.socialnmobile.colornote.fragment.RecycleBinFragment;
import android.view.View$OnClickListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class pk implements View$OnClickListener
{
    final /* synthetic */ RecycleBinFragment a;
    
    public pk(final RecycleBinFragment a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        switch (view.getId()) {
            default: {}
            case 2131624079: {
                this.a.a(true);
            }
        }
    }
}
