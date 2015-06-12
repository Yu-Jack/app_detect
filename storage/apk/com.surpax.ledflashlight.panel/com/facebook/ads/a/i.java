// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import java.util.Iterator;
import android.content.Context;
import java.util.HashSet;
import java.util.Collection;
import org.json.JSONArray;

public final class i
{
    public static Collection a(final JSONArray jsonArray) {
        if (jsonArray == null || jsonArray.length() == 0) {
            return null;
        }
        final HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < jsonArray.length(); ++i) {
            set.add(jsonArray.optString(i));
        }
        return set;
    }
    
    public static boolean a(final Context context, final e e) {
        final h a = e.a();
        if (a != null && a != h.a) {
            final Collection b = e.b();
            if (b != null && !b.isEmpty()) {
                final Iterator<String> iterator = b.iterator();
                while (true) {
                    while (iterator.hasNext()) {
                        if (a(context, iterator.next())) {
                            final boolean b2 = true;
                            if (a == h.b) {
                                return b2;
                            }
                            if (a == h.c && !b2) {
                                return true;
                            }
                            return false;
                        }
                    }
                    final boolean b2 = false;
                    continue;
                }
            }
        }
        return false;
    }
    
    public static boolean a(final Context context, final String s) {
        if (ab.a(s)) {
            return false;
        }
        final PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getPackageInfo(s, 1);
            return true;
        }
        catch (PackageManager$NameNotFoundException ex) {
            return false;
        }
    }
}
