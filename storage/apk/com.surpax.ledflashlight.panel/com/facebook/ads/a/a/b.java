// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a.a;

import android.net.Uri;
import android.content.Context;

public final class b
{
    public static a a(final Context context, final Uri uri) {
        final String authority = uri.getAuthority();
        final String queryParameter = uri.getQueryParameter("video_url");
        if ("store".equals(authority)) {
            if (queryParameter != null) {
                return new e(context, uri);
            }
            return new c(context, uri);
        }
        else {
            if ("open_link".equals(authority)) {
                return new d(context, uri);
            }
            return null;
        }
    }
}
