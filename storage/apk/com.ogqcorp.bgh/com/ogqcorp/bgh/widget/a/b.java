// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.widget.a;

import java.util.Arrays;
import android.graphics.Typeface;
import android.content.Context;

public final class b
{
    public static Typeface a(final Context context, final String str) {
        return Typeface.createFromAsset(context.getAssets(), "sc_fonts/" + str + ".ttf");
    }
    
    public static String[] a(final Context context) {
        final String[] list = context.getAssets().list("sc_fonts");
        Arrays.sort(list);
        for (int i = 0; i < list.length; ++i) {
            list[i] = list[i].replace(".ttf", "");
        }
        return list;
    }
}
