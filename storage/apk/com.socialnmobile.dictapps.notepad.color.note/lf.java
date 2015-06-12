import android.view.View;
import android.view.inputmethod.InputMethodManager;

// 
// Decompiled by Procyon v0.5.29
// 

final class lf implements Runnable
{
    final /* synthetic */ ld a;
    
    lf(final ld a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        final InputMethodManager inputMethodManager = (InputMethodManager)this.a.getContext().getSystemService("input_method");
        inputMethodManager.showSoftInput((View)this.a.b, 0);
        inputMethodManager.showSoftInputFromInputMethod(this.a.b.getApplicationWindowToken(), 0);
    }
}
