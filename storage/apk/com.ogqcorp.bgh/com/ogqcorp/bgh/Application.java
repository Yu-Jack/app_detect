// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh;

import com.ogqcorp.commons.g;
import android.app.Application;

public class Application extends android.app.Application
{
    public void onCreate() {
        super.onCreate();
        g.a().b();
    }
    
    public void onTerminate() {
        g.a().c();
        super.onTerminate();
    }
}
