// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import android.content.Intent;
import java.util.concurrent.ExecutorService;
import android.app.Activity;

public interface CordovaInterface
{
    Activity getActivity();
    
    ExecutorService getThreadPool();
    
    Object onMessage(String p0, Object p1);
    
    void setActivityResultCallback(CordovaPlugin p0);
    
    void startActivityForResult(CordovaPlugin p0, Intent p1, int p2);
}
