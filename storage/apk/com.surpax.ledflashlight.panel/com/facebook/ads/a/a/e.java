// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a.a;

import android.util.Log;
import com.facebook.ads.VideoAdActivity;
import java.util.Iterator;
import android.content.Intent;
import java.util.Map;
import android.net.Uri;
import android.content.Context;

public class e extends c
{
    private static final String a;
    private final Context b;
    private final Uri c;
    
    static {
        a = e.class.getSimpleName();
    }
    
    public e(final Context b, final Uri c) {
        super(b, c);
        this.b = b;
        this.c = c;
    }
    
    private static void a(final Map map, final Intent intent) {
        for (final Map.Entry<String, V> entry : map.entrySet()) {
            intent.putExtra((String)entry.getKey(), (String)entry.getValue());
        }
    }
    
    @Override
    public final void a(final Map map) {
        com.facebook.ads.a.a.a.a(this.b, this.c);
        final String queryParameter = this.c.getQueryParameter("video_url");
        final Intent intent = new Intent(this.b, (Class)VideoAdActivity.class);
        intent.putExtra("adUri", this.c.toString());
        intent.putExtra("adVideoPath", queryParameter);
        intent.putExtra("adMarketUri", this.a().toString());
        a(map, intent);
        try {
            this.b.startActivity(intent);
        }
        catch (Exception ex) {
            Log.d(e.a, "Failed to start video", (Throwable)ex);
        }
    }
}
