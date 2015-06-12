// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.pm.PackageManager;
import android.content.Intent;
import android.net.Uri;
import java.util.HashMap;
import android.text.TextUtils;
import java.util.Map;

final class bb$2 implements bc
{
    @Override
    public void b(final ex ex, final Map map) {
        final String s = map.get("urls");
        if (TextUtils.isEmpty((CharSequence)s)) {
            eu.D("URLs missing in canOpenURLs GMSG.");
            return;
        }
        final String[] split = s.split(",");
        final HashMap<String, Boolean> hashMap = new HashMap<String, Boolean>();
        final PackageManager packageManager = ex.getContext().getPackageManager();
        for (final String key : split) {
            final String[] split2 = key.split(";", 2);
            final String trim = split2[0].trim();
            String trim2;
            if (split2.length > 1) {
                trim2 = split2[1].trim();
            }
            else {
                trim2 = "android.intent.action.VIEW";
            }
            hashMap.put(key, packageManager.resolveActivity(new Intent(trim2, Uri.parse(trim)), 65536) != null);
        }
        ex.a("openableURLs", hashMap);
    }
}
