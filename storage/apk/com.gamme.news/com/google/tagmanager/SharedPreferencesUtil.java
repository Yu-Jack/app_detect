// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.os.Build$VERSION;
import android.annotation.SuppressLint;
import android.content.SharedPreferences$Editor;
import android.content.Context;

class SharedPreferencesUtil
{
    @SuppressLint({ "CommitPrefEdits" })
    static void saveAsync(final Context context, final String s, final String s2, final String s3) {
        final SharedPreferences$Editor edit = context.getSharedPreferences(s, 0).edit();
        edit.putString(s2, s3);
        saveEditorAsync(edit);
    }
    
    static void saveEditorAsync(final SharedPreferences$Editor sharedPreferences$Editor) {
        if (Build$VERSION.SDK_INT >= 9) {
            sharedPreferences$Editor.apply();
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                sharedPreferences$Editor.commit();
            }
        }).start();
    }
}
