// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;

public class he
{
    private static final Uri GG;
    private static final Uri GH;
    
    static {
        GG = Uri.parse("http://plus.google.com/");
        GH = he.GG.buildUpon().appendPath("circles").appendPath("find").build();
    }
    
    public static Intent aB(final String s) {
        final Uri fromParts = Uri.fromParts("package", s, (String)null);
        final Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }
    
    private static Uri aC(final String s) {
        return Uri.parse("market://details").buildUpon().appendQueryParameter("id", s).build();
    }
    
    public static Intent aD(final String s) {
        final Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(aC(s));
        intent.setPackage("com.android.vending");
        intent.addFlags(524288);
        return intent;
    }
    
    public static Intent fA() {
        return new Intent("android.settings.DATE_SETTINGS");
    }
}
