// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.content.pm.ActivityInfo;
import android.content.Context;
import android.content.Intent;
import android.app.Activity;

interface NavUtils$NavUtilsImpl
{
    Intent getParentActivityIntent(Activity p0);
    
    String getParentActivityName(Context p0, ActivityInfo p1);
    
    void navigateUpTo(Activity p0, Intent p1);
    
    boolean shouldUpRecreateTask(Activity p0, Intent p1);
}
