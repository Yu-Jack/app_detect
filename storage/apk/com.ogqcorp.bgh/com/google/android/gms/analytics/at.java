// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import java.io.File;
import android.os.Build$VERSION;

class at
{
    public static int a() {
        try {
            return Integer.parseInt(Build$VERSION.SDK);
        }
        catch (NumberFormatException ex) {
            p.a("Invalid version number: " + Build$VERSION.SDK);
            return 0;
        }
    }
    
    static boolean a(final String pathname) {
        if (a() < 9) {
            return false;
        }
        final File file = new File(pathname);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
        return true;
    }
}
