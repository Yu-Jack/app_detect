// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Iterator;
import java.util.List;
import android.content.Context;
import android.text.TextUtils;
import android.content.pm.PackageManager;

public final class bi implements bf
{
    private static final String a;
    
    static {
        a = bi.class.getSimpleName();
    }
    
    private boolean a(final String s, final PackageManager packageManager, final String s2, final String s3) {
        if (TextUtils.isEmpty((CharSequence)s) || packageManager == null || TextUtils.isEmpty((CharSequence)s2) || TextUtils.isEmpty((CharSequence)s3)) {
            return false;
        }
        if (-1 == packageManager.checkPermission(s3, s2)) {
            eo.b(bi.a, s + ": package=\"" + s2 + "\": AndroidManifest.xml should include uses-permission node with android:name=\"" + s3 + "\"");
            return false;
        }
        eo.a(3, bi.a, s + ": package=\"" + s2 + "\": AndroidManifest.xml has uses-permission node with android:name=\"" + s3 + "\"");
        return true;
    }
    
    @Override
    public final boolean a(final Context context, final bj bj) {
        if (bj != null) {
            final String a = bj.a();
            if (!TextUtils.isEmpty((CharSequence)a)) {
                final List d = bj.d();
                if (d != null) {
                    final PackageManager packageManager = context.getPackageManager();
                    final String packageName = context.getPackageName();
                    final Iterator<String> iterator = d.iterator();
                    boolean b = true;
                    while (iterator.hasNext()) {
                        b = (this.a(a, packageManager, packageName, iterator.next()) && b);
                    }
                    return b;
                }
            }
        }
        return false;
    }
}
