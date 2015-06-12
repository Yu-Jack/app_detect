// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Iterator;
import java.util.List;
import android.content.Context;
import android.text.TextUtils;
import android.os.Bundle;

public final class bh implements bf
{
    private static final String a;
    
    static {
        a = bh.class.getSimpleName();
    }
    
    private boolean a(final String s, final String s2, final Bundle bundle, final String s3) {
        if (TextUtils.isEmpty((CharSequence)s) || TextUtils.isEmpty((CharSequence)s2) || bundle == null || TextUtils.isEmpty((CharSequence)s3)) {
            return false;
        }
        final String string = bundle.getString(s3);
        if (TextUtils.isEmpty((CharSequence)string)) {
            eo.b(bh.a, s + ": package=\"" + s2 + "\": AndroidManifest.xml should include meta-data node with android:name=\"" + s3 + "\" and not empty value for android:value");
            return false;
        }
        eo.a(3, bh.a, s + ": package=\"" + s2 + "\": AndroidManifest.xml has meta-data node with android:name=\"" + s3 + "\" and android:value=\"" + string + "\"");
        return true;
    }
    
    @Override
    public final boolean a(final Context context, final bj bj) {
        if (bj != null) {
            final String a = bj.a();
            if (!TextUtils.isEmpty((CharSequence)a)) {
                final List c = bj.c();
                if (c != null) {
                    final Bundle d = dx.d(context);
                    final String packageName = context.getPackageName();
                    final Iterator<String> iterator = c.iterator();
                    boolean b = true;
                    while (iterator.hasNext()) {
                        b = (this.a(a, packageName, d, iterator.next()) && b);
                    }
                    return b;
                }
            }
        }
        return false;
    }
}
