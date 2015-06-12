// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a.a;

import android.util.Log;
import android.content.Intent;
import java.util.Map;
import android.net.Uri;
import android.content.Context;

public class d extends a
{
    private static final String a;
    private final Context b;
    private final Uri c;
    
    static {
        a = d.class.getSimpleName();
    }
    
    public d(final Context b, final Uri c) {
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void a(final Map map) {
        com.facebook.ads.a.a.a.a(this.b, this.c);
        final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.c.getQueryParameter("link")));
        try {
            this.b.startActivity(intent);
        }
        catch (Exception ex) {
            Log.d(d.a, "Failed to open market url: " + this.c.toString(), (Throwable)ex);
        }
    }
}
