// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.view.menu;

import android.view.ViewConfiguration;
import android.content.Context;

class ActionMenuPresenter$HasPermanentMenuKey
{
    public static boolean get(final Context context) {
        return ViewConfiguration.get(context).hasPermanentMenuKey();
    }
}
