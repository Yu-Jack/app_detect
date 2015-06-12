// 
// Decompiled by Procyon v0.5.29
// 

package com.gamme.news.crash;

import android.app.Application;

public class CrashApplication extends Application
{
    public void onCreate() {
        super.onCreate();
        CrashHandler.getInstance().init(this.getApplicationContext());
    }
}
