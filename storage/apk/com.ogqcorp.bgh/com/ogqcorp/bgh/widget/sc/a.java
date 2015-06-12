// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.widget.sc;

import android.content.Intent;
import android.content.Context;

public final class a
{
    public static void a(final Context context) {
        context.sendBroadcast(new Intent("com.ogqcorp.bgh.widget.sc.action.UPDATE"));
    }
}
