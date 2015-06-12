// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.view.MotionEvent;
import android.content.Context;
import android.net.Uri;

public class kw
{
    private String a;
    private String b;
    private String[] c;
    private ir d;
    private final hf e;
    
    public kw(final ir d) {
        this.a = "googleads.g.doubleclick.net";
        this.b = "/pagead/ads";
        this.c = new String[] { ".doubleclick.net", ".googleadservices.com", ".googlesyndication.com" };
        this.e = new hf();
        this.d = d;
    }
    
    private Uri a(final Uri uri, final Context context, final String s, final boolean b) {
        try {
            if (uri.getQueryParameter("ms") != null) {
                throw new kx("Query parameter already exists: ms");
            }
        }
        catch (UnsupportedOperationException ex) {
            throw new kx("Provided Uri is not in a valid state");
        }
        String s2;
        if (b) {
            s2 = this.d.a(context, s);
        }
        else {
            s2 = this.d.a(context);
        }
        return this.a(uri, "ms", s2);
    }
    
    private Uri a(final Uri uri, final String str, final String str2) {
        final String string = uri.toString();
        int n = string.indexOf("&adurl");
        if (n == -1) {
            n = string.indexOf("?adurl");
        }
        if (n != -1) {
            return Uri.parse(string.substring(0, n + 1) + str + "=" + str2 + "&" + string.substring(n + 1));
        }
        return uri.buildUpon().appendQueryParameter(str, str2).build();
    }
    
    public Uri a(final Uri uri, final Context context) {
        try {
            return this.a(uri, context, uri.getQueryParameter("ai"), true);
        }
        catch (UnsupportedOperationException ex) {
            throw new kx("Provided Uri is not in a valid state");
        }
    }
    
    public ir a() {
        return this.d;
    }
    
    public void a(final MotionEvent motionEvent) {
        this.d.a(motionEvent);
    }
    
    public boolean a(final Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            final String host = uri.getHost();
            final String[] c = this.c;
            final int length = c.length;
            int n = 0;
            boolean b;
            while (true) {
                b = false;
                if (n >= length) {
                    break;
                }
                if (host.endsWith(c[n])) {
                    b = true;
                    break;
                }
                ++n;
            }
            return b;
        }
        catch (NullPointerException ex) {
            return false;
        }
    }
}
