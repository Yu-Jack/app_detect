// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.a;

import java.io.File;
import android.content.Context;

class b
{
    public static File a(final Context context) {
        return context.getExternalCacheDir();
    }
    
    public static File a(final Context context, final String s) {
        return context.getExternalFilesDir(s);
    }
}
