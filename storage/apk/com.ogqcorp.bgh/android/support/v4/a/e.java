// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.a;

import java.io.File;
import android.content.Context;

class e
{
    public static File[] a(final Context context) {
        return context.getExternalCacheDirs();
    }
    
    public static File[] a(final Context context, final String s) {
        return context.getExternalFilesDirs(s);
    }
    
    public static File[] b(final Context context) {
        return context.getObbDirs();
    }
}
