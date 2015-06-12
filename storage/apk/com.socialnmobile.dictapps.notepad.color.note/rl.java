import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.LinearLayout$LayoutParams;
import android.webkit.WebViewClient;
import android.os.Bundle;
import android.content.Context;
import android.widget.FrameLayout;
import android.app.Activity;
import android.widget.LinearLayout;
import android.app.ProgressDialog;
import android.app.Dialog;
import com.socialnmobile.colornote.ColorNote;
import android.webkit.WebView;
import android.webkit.WebChromeClient;

// 
// Decompiled by Procyon v0.5.29
// 

final class rl extends WebChromeClient
{
    final /* synthetic */ rj a;
    
    private rl(final rj a) {
        this.a = a;
    }
    
    public final void onReceivedTitle(final WebView webView, final String str) {
        super.onReceivedTitle(webView, str);
        new StringBuilder("Receive Title: ").append(str).toString();
        ColorNote.a();
        if (str != null) {
            if (str.contains("code=")) {
                final String[] split = str.split("=");
                this.a.d.loadData("", "text/html", "utf-8");
                rj.a(this.a, true);
                new rn(this.a, (byte)0).execute((Object[])new String[] { split[1] });
                return;
            }
            if (str.contains("error=")) {
                this.a.b.a();
                this.a.dismiss();
            }
        }
    }
}
