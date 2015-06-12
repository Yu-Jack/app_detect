import android.view.inputmethod.InputMethodManager;

// 
// Decompiled by Procyon v0.5.29
// 

final class lg implements Runnable
{
    final /* synthetic */ ld a;
    
    lg(final ld a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        ((InputMethodManager)this.a.getContext().getSystemService("input_method")).hideSoftInputFromInputMethod(this.a.b.getApplicationWindowToken(), 1);
    }
}
