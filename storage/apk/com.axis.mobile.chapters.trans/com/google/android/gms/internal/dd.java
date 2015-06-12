// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.Intent;
import android.os.IInterface;

public interface dd extends IInterface
{
    void onActivityResult(int p0, int p1, Intent p2);
    
    void onCreate();
    
    void onDestroy();
}
