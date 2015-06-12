// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Iterator;
import java.util.List;
import android.content.Context;
import android.text.TextUtils;

public final class bd implements bf
{
    private static final String a;
    
    static {
        a = bd.class.getSimpleName();
    }
    
    private boolean a(final String s, final String s2, final bc bc) {
        if (TextUtils.isEmpty((CharSequence)s) || TextUtils.isEmpty((CharSequence)s2) || bc == null) {
            return false;
        }
        boolean b;
        while (true) {
            try {
                final boolean empty = TextUtils.isEmpty((CharSequence)bc.c());
                b = false;
                if (!empty) {
                    Class.forName(bc.c());
                    b = true;
                }
                if (!b) {
                    eo.b(bd.a, s + ": package=\"" + s2 + "\": apk should include ad provider library with name=\"" + bc.a() + "\" and version=\"" + bc.b() + "\" or higher");
                    return b;
                }
            }
            catch (ClassNotFoundException ex) {
                eo.a(6, bd.a, "failed to find third party ad provider api with exception: ", ex);
                b = false;
                continue;
            }
            catch (ExceptionInInitializerError exceptionInInitializerError) {
                eo.a(6, bd.a, "failed to initialize third party ad provider api with exception: ", exceptionInInitializerError);
                b = false;
                continue;
            }
            catch (LinkageError linkageError) {
                eo.a(6, bd.a, "failed to link third party ad provider api with exception: ", linkageError);
                b = false;
                continue;
            }
            break;
        }
        eo.a(3, bd.a, s + ": package=\"" + s2 + "\": apk has ad provider library with name=\"" + bc.a() + "\" and version=\"" + bc.b() + "\" or higher");
        return b;
    }
    
    @Override
    public final boolean a(final Context context, final bj bj) {
        if (bj != null) {
            final String a = bj.a();
            if (!TextUtils.isEmpty((CharSequence)a)) {
                final List b = bj.b();
                if (b != null) {
                    final String packageName = context.getPackageName();
                    final Iterator<bc> iterator = b.iterator();
                    boolean b2 = true;
                    while (iterator.hasNext()) {
                        b2 = (this.a(a, packageName, iterator.next()) && b2);
                    }
                    return b2;
                }
            }
        }
        return false;
    }
}
