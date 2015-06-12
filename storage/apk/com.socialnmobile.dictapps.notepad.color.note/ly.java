import android.view.View;
import android.view.inputmethod.InputMethodManager;

// 
// Decompiled by Procyon v0.5.29
// 

final class ly implements Runnable
{
    final /* synthetic */ lv a;
    
    ly(final lv a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        final InputMethodManager inputMethodManager = (InputMethodManager)this.a.getContext().getSystemService("input_method");
        inputMethodManager.showSoftInput((View)this.a.a, 0);
        inputMethodManager.showSoftInputFromInputMethod(this.a.a.getApplicationWindowToken(), 0);
    }
}
