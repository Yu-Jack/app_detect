import android.view.inputmethod.InputMethodManager;

// 
// Decompiled by Procyon v0.5.29
// 

final class lz implements Runnable
{
    final /* synthetic */ lv a;
    
    lz(final lv a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        ((InputMethodManager)this.a.getContext().getSystemService("input_method")).hideSoftInputFromInputMethod(this.a.a.getApplicationWindowToken(), 1);
    }
}
