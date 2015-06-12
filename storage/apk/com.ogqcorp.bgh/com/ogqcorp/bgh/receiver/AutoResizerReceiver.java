// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.receiver;

import android.app.WallpaperManager;
import com.ogqcorp.bgh.system.l;
import com.ogqcorp.bgh.system.v;
import com.ogqcorp.bgh.system.e;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public final class AutoResizerReceiver extends BroadcastReceiver
{
    public void onReceive(final Context context, final Intent intent) {
        final boolean a = e.a(context);
        if (!v.a().h(context) && !a) {
            long currentTimeMillis;
            try {
                currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - v.a().k(context)) < 1000L) {
                    l.a("## [AUTO_RESIZING] DETECT PINGPONG ##", new Object[0]);
                    return;
                }
            }
            catch (Exception ex) {
                l.b(ex);
                return;
            }
            final int i = v.a().i(context);
            final int j = v.a().j(context);
            if (i != -1 && j != -1) {
                WallpaperManager.getInstance(context).suggestDesiredDimensions(i, j);
                v.a().b(context, currentTimeMillis);
                final Object[] array = { i, j, null };
                String action;
                if (intent != null) {
                    action = intent.getAction();
                }
                else {
                    action = "APP";
                }
                array[2] = action;
                l.a("## [AUTO_RESIZING] X: %4d, Y: %4d, A: %s ##", array);
            }
        }
    }
}
