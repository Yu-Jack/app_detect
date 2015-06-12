import android.content.Context;
import android.webkit.WebView;

// 
// Decompiled by Procyon v0.5.29
// 

final class rk extends WebView
{
    final /* synthetic */ rj a;
    
    rk(final rj a, final Context context) {
        this.a = a;
        super(context);
    }
    
    public final void onWindowFocusChanged(final boolean b) {
        try {
            super.onWindowFocusChanged(b);
        }
        catch (NullPointerException ex) {}
    }
}
