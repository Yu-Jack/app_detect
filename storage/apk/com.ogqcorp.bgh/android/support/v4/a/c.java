// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.a;

import android.content.Intent;
import java.io.File;
import android.content.Context;

class c
{
    public static File a(final Context context) {
        return context.getObbDir();
    }
    
    static void a(final Context context, final Intent[] array) {
        context.startActivities(array);
    }
}
