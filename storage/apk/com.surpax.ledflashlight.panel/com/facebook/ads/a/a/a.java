// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a.a;

import java.util.Map;
import com.facebook.ads.a.r;
import com.facebook.ads.a.aa;
import com.facebook.ads.a.ab;
import android.net.Uri;
import android.content.Context;

public abstract class a
{
    protected static void a(final Context context, final Uri uri) {
        final String queryParameter = uri.getQueryParameter("native_click_report_url");
        if (ab.a(queryParameter)) {
            return;
        }
        new aa().execute((Object[])new String[] { queryParameter });
        r.a(context, "Click logged");
    }
    
    public abstract void a(final Map p0);
}
