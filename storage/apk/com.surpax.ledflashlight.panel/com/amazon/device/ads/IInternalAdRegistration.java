// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.io.File;
import android.content.Context;

interface IInternalAdRegistration
{
    void contextReceived(Context p0);
    
    AppInfo getAppInfo();
    
    Context getApplicationContext();
    
    DeviceInfo getDeviceInfo();
    
    File getFilesDir();
    
    boolean getIsAppDisabled();
    
    int getNoRetryTtlRemainingMillis();
    
    RegistrationInfo getRegistrationInfo();
    
    boolean isRegistered();
    
    void register();
    
    void setIsAppDisabled(boolean p0);
    
    void setNoRetryTtl(int p0);
}
