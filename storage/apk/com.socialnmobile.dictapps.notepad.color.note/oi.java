import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.socialnmobile.colornote.fragment.ListEditor$EditDialogFragment;

// 
// Decompiled by Procyon v0.5.29
// 

public final class oi implements Runnable
{
    final /* synthetic */ ListEditor$EditDialogFragment a;
    
    public oi(final ListEditor$EditDialogFragment a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        if (this.a.h() != null) {
            final InputMethodManager inputMethodManager = (InputMethodManager)this.a.h().getSystemService("input_method");
            inputMethodManager.showSoftInput((View)this.a.Z, 0);
            inputMethodManager.showSoftInputFromInputMethod(this.a.Z.getApplicationWindowToken(), 0);
        }
    }
}
