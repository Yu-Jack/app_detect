// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.content.SharedPreferences$Editor;
import android.annotation.TargetApi;

@TargetApi(9)
class AndroidTargetUtils$GingerbreadTargetUtils
{
    protected static void editorApply(final SharedPreferences$Editor sharedPreferences$Editor) {
        sharedPreferences$Editor.apply();
    }
}
