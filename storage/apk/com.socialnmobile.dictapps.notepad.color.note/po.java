import android.support.v4.app.DialogFragment;
import com.socialnmobile.colornote.fragment.RecycleBinFragment;

// 
// Decompiled by Procyon v0.5.29
// 

public final class po implements Runnable
{
    final /* synthetic */ RecycleBinFragment a;
    private final /* synthetic */ DialogFragment b;
    
    public po(final RecycleBinFragment a, final DialogFragment b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        if (this.a.m()) {
            this.b.a(this.a.k(), "dialog");
        }
    }
}
