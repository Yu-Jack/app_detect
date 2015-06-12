// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import android.text.TextUtils;
import java.io.File;

public class ce
{
    public static File a(final String str) {
        return new File(fd.b(true).getPath() + File.separator + ".fcaches" + File.separator + str);
    }
    
    public static File b(final String str) {
        return new File(fd.a(true).getPath() + File.separator + ".fcaches" + File.separator + str);
    }
    
    public static String c(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return null;
        }
        return String.format("%016x", fe.g(s)).trim();
    }
}
