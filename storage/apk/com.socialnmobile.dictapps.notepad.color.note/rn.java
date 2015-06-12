import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.content.Context;
import android.widget.FrameLayout;
import android.app.Activity;
import android.widget.LinearLayout;
import android.webkit.WebView;
import android.app.ProgressDialog;
import android.app.Dialog;
import android.os.Bundle;
import java.io.IOException;
import android.os.AsyncTask;

// 
// Decompiled by Procyon v0.5.29
// 

final class rn extends AsyncTask
{
    final /* synthetic */ rj a;
    
    private rn(final rj a) {
        this.a = a;
    }
    
    private static String a(final String... array) {
        final String s = array[0];
        try {
            return ro.a(s);
        }
        catch (IOException ex) {
            return null;
        }
    }
    
    protected final void onPreExecute() {
        if (!this.a.g.isFinishing()) {
            this.a.c.show();
        }
    }
}
