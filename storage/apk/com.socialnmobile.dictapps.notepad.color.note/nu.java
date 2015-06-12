import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.socialnmobile.colornote.fragment.ListEditor;

// 
// Decompiled by Procyon v0.5.29
// 

public final class nu implements Runnable
{
    final /* synthetic */ ListEditor a;
    
    public nu(final ListEditor a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        if (this.a.h() != null) {
            ((InputMethodManager)this.a.h().getSystemService("input_method")).restartInput((View)this.a.ac.c);
        }
    }
}
