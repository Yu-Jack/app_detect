// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.app.Activity;

interface IAdActivityAdapter
{
    void onCreate();
    
    void onPause();
    
    void onResume();
    
    void onStop();
    
    void preOnCreate();
    
    void setActivity(Activity p0);
}
